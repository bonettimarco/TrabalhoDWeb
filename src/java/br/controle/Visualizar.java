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

/**
 *
 * @author Leo adaptado por Marco
 */
@WebServlet(name = "Visualizar", urlPatterns = {"/Visualizar"})
public class Visualizar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Contato contato = new Contato(id);
        Contato_DAO contato_dao = new Contato_DAO();
        try {
            contato_dao.get(contato);
            request.setAttribute("contato", contato);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Contato_Visualizar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

}
