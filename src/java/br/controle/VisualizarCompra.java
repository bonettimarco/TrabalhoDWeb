/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Compra;
import br.DAO.Compra_DAO;
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
@WebServlet(name = "VisualizarCompra", urlPatterns = {"/VisualizarCompra"})
public class VisualizarCompra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idCompra = Integer.parseInt(request.getParameter("id"));
        Compra compra = new Compra();
        Compra_DAO compra_DAO = new Compra_DAO();
        compra.setIdCompra(idCompra);
        try {
        compra = compra_DAO.get(compra);
            request.setAttribute("Compra", compra);
            RequestDispatcher rd = request.getRequestDispatcher("Form_Compra_Visualizar.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

}
