/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Produto;
import br.DAO.Produto_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IncluirProduto", urlPatterns = {"/IncluirProduto"})
public class IncluirProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        int id = Integer.parseInt(request.getParameter("id"));
		int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		double valor = Double.parseDouble(request.getParameter("valor"));
		
        try {
            if (valor < 0) // verifica os dados
            {  // retorna para o formulario de contato

                RequestDispatcher rd = request.getRequestDispatcher("Form_Produto.jsp");
                rd.forward(request, response);
            } else {

                Produto produto = new Produto(id, idCategoria, nome, descricao, valor);
                Produto_DAO produto_dao = new Produto_DAO();
                try {
                    produto_dao.Inserir(produto);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
                    request.setAttribute("retorna", "ListaProduto");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Form_Produto.jsp");
            rd.forward(request, response);
        }

    }

}
