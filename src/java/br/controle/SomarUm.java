/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Item;
import br.DAO.Item_DAO;
import br.DAO.Compra;
import br.DAO.Compra_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leo/ adaptação Marco
 */
@WebServlet(name = "SomarUm", urlPatterns = {"/SomarUm"})
public class SomarUm extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Item_DAO item_DAO = new Item_DAO();
        Item item = new Item();
        Compra_DAO compra_DAO = new Compra_DAO();
        Compra compra = new Compra();
        int idPedido = Integer.parseInt(request.getParameter("idPedido"));
        int idProduto = Integer.parseInt(request.getParameter("idProduto"));
        
        item.setIdPedido(idPedido);
        item.setIdProduto(idProduto);
         try {
            item = item_DAO.get(item);
            item.setQuantidade(item.getQuantidade()+1);
            item_DAO.Alterar(item);
            RequestDispatcher rd = request.getRequestDispatcher("IniciarCompra");
            rd.forward(request, response);
         } catch (Exception ex) {
             Logger.getLogger(TirarUm.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
