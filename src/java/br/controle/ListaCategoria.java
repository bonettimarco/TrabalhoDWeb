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
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leo/adaptado por Marco
 */
@WebServlet(name = "ListaCategoria", urlPatterns = {"/ListaCategoria"})
public class ListaCategoria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Categoria_DAO categoria_dao = new Categoria_DAO();
        ArrayList<Categoria> categorias = categoria_dao.Listar();
        request.setAttribute("Categorias", categorias);
        RequestDispatcher rd = request.getRequestDispatcher("ListaCategoriaView.jsp");
        rd.forward(request, response);

    }

}
