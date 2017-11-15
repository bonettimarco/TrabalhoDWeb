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

/**
 *
 * @author Leo
 */
@WebServlet(name = "VisualizarProduto", urlPatterns = {"/VisualizarProduto"})
public class VisualizarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        Produto produto = new Produto(idProduto);
        Produto_DAO produto_dao = new Produto_DAO();
        try {
            produto_dao.get(produto);
            request.setAttribute("Produto", produto);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Produto_Visualizar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

}
