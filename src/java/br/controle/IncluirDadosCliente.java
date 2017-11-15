/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Item;
import br.DAO.Item_DAO;
import br.DAO.Compra;
import br.DAO.ItemProduto;
import br.DAO.Produto_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IncluirDadosCliente", urlPatterns = {"/IncluirDadosCliente"})
public class IncluirDadosCliente extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Produto_DAO produto_DAO = new Produto_DAO();
        Item_DAO item_DAO = new Item_DAO();
        Item item = new Item();
        ArrayList<ItemProduto> meusItensProdutos;
        Compra compra;
        
        compra = (Compra) request.getAttribute("Compras");
        meusItensProdutos = item_DAO.Listar(compra.getIdCompra());
        request.setAttribute("meusProdutos", meusItensProdutos);
        request.setAttribute("Compras", compra);
        RequestDispatcher rd = request.getRequestDispatcher("Form_Cliente.jsp");
        rd.forward(request, response);
    }
}