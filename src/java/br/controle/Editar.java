/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Contato;
import br.DAO.Contato_DAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leo
 */
@WebServlet(name = "Editar", urlPatterns = {"/Editar"})
public class Editar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Contato contato = new Contato(id);
        Contato_DAO contato_dao = new Contato_DAO();
        try {
            contato_dao.get(contato);
            request.setAttribute("contato", contato);
            RequestDispatcher rd = request.getRequestDispatcher("Form_Contato_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String senha = (String)request.getAttribute("senhaCriptografada");
        boolean admin = Boolean.parseBoolean(request.getParameter("admin"));

        Contato contato = new Contato(id, email, senha, admin);
        try {
            if ((email.isEmpty()) || (senha.isEmpty())) // verifica os dados
            {  // retorna para o formulario de contato

                if (email.isEmpty()) {
                    request.setAttribute("erro_email", "O mail não pode ser vazio");
                }

                if (senha.isEmpty()) {
                    request.setAttribute("erro_senha", "A senha não pode ficar em branco");
                }


                request.setAttribute("contato", contato);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Contato_Editar.jsp");
                rd.forward(request, response);
            } else {

                Contato_DAO contato_dao = new Contato_DAO();
                try {
                    contato_dao.Alterar(contato);
                    request.setAttribute("mensagem", "Alterado Com Sucesso");
                    request.setAttribute("retorna", "ListaContato");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_email", "O mail não pode ser vazio");
            request.setAttribute("erro_senha", "A senha não pode ficar em branco");
            RequestDispatcher rd = request.getRequestDispatcher("Form_Contato.jsp");
            rd.forward(request, response);
        }

    }

}
