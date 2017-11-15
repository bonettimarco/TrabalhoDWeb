/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Contato;
import br.DAO.Contato_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Incluir", urlPatterns = {"/Incluir"})
public class Incluir extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String senha = (String)request.getAttribute("senhaCriptografada");
        try {
            request.setAttribute("erro_email", "");
            request.setAttribute("erro_senha", "");

            if ((email.isEmpty()) || (senha.isEmpty())) // verifica os dados
            {  // retorna para o formulario de contato

                if (email.isEmpty()) {
                    request.setAttribute("erro_email", "O mail não pode ser vazio");
                }

                if (senha.isEmpty()) {
                    request.setAttribute("erro_senha", "A senha não pode ficar vazia");
                }

                RequestDispatcher rd = request.getRequestDispatcher("Form_Contato.jsp");
                rd.forward(request, response);
            } else {

                Contato contato = new Contato(id, email, senha);
                Contato_DAO contato_dao = new Contato_DAO();
                try {
                    contato_dao.Inserir(contato);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
                    request.setAttribute("retorna", "ListaContato");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_nome", "O nome não pode ser vazio");
            request.setAttribute("erro_idade", "A idade não pode ser menor que 18");
            RequestDispatcher rd = request.getRequestDispatcher("Form_Contato.jsp");
            rd.forward(request, response);
        }

    }

}
