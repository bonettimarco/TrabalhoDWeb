/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Categoria;
import br.DAO.Categoria_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IncluirCategoria", urlPatterns = {"/IncluirCategoria"})
public class IncluirCategoria extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        int idCategoria = Integer.parseInt(request.getParameter("id"));
		String descricao = request.getParameter("descricao");
        try {
            if ((idCategoria < 1) || (descricao.isEmpty())) // verifica os dados
            {  // retorna para o formulario de contato

                if (descricao.isEmpty()) {
                    request.setAttribute("erro_descricao", "A categoria não pode ficar em branco");
                }

                if (idCategoria < 1) {
                    request.setAttribute("erro_id", "O id está errado");
                }

                RequestDispatcher rd = request.getRequestDispatcher("Form_Categoria.jsp");
                rd.forward(request, response);
            } else {

                Categoria categoria = new Categoria(idCategoria, descricao);
                Categoria_DAO categoria_dao = new Categoria_DAO();
                try {
                    categoria_dao.Inserir(categoria);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
                    request.setAttribute("retorna", "ListaCategoria");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_id", "O id não pode ser vazio");
            request.setAttribute("erro_descricao", "A descrição não pode ficar em branco");
            RequestDispatcher rd = request.getRequestDispatcher("Form_Categoria.jsp");
            rd.forward(request, response);
        }

    }

}
