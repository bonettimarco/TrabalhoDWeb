/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Item_DAO;
import br.DAO.Compra;
import br.DAO.Compra_DAO;
import br.DAO.ItemProduto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FinalizarCompra", urlPatterns = {"/FinalizarCompra"})
public class FinalizarCompra extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<ItemProduto> meusItensProdutos = new ArrayList<ItemProduto>();
        Compra compra = new Compra();
        Item_DAO item_DAO = new Item_DAO(); 
        Compra_DAO compra_DAO = new Compra_DAO();
        boolean faz = false;
        
        
//pega os cookies
        Cookie[] cookies = request.getCookies();
        for(int i=0; i<cookies.length; i++){
            if(cookies[i].getName().equals("CookieLojaDW")){
                compra.setCookie(Integer.parseInt(cookies[i].getValue()));
            }
            if(cookies[i].getName().equals("CookiePedidoDW")){
                compra.setIdCompra(Integer.parseInt(cookies[i].getValue()));
            }
        }

//checa se os cookies existiam, se nao, devolve para o Início
        if ((compra.getCookie() == 0) || (compra.getIdCompra() == 0)){
            RequestDispatcher rd = request.getRequestDispatcher("IniciarCompra");
            rd.forward(request, response);
        }

//pega os dados da compra e fecha o pedido
            meusItensProdutos = item_DAO.Listar(compra.getIdCompra());
         try {
             compra_DAO.Inserir(compra);
         } catch (Exception ex) {
             Logger.getLogger(FinalizarCompra.class.getName()).log(Level.SEVERE, null, ex);
         }

//apaga os cookie
        Cookie cookiePedido = new Cookie("CookiePedidoDW", String.valueOf(compra.getIdCompra()));
        response.addCookie(cookiePedido);
        Cookie cookieCliente = new Cookie("CookieLojaDW", String.valueOf(compra.getCookie()));
        response.addCookie(cookieCliente);
        Cookie cookieLista = new Cookie("ItensPedidoDW", "");
        response.addCookie(cookieLista);

        request.setAttribute("Compra", compra);
        request.setAttribute("meusItensProdutos", meusItensProdutos);
        RequestDispatcher rd = request.getRequestDispatcher("ListaCompraEmAndamentoView.jsp");
        rd.forward(request, response);
    }
}