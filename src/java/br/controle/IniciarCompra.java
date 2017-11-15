/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Item;
import br.DAO.Item_DAO;
import br.DAO.Contador;
import br.DAO.Contador_DAO;
import br.DAO.Compra;
import br.DAO.Produto;
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

@WebServlet(name = "IniciarCompra", urlPatterns = {"/IniciarCompra"})
public class IniciarCompra extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<ItemProduto> meusItensProdutos = new ArrayList<ItemProduto>();
        String listaIdProdutos = "";
        Compra compra = new Compra();
        ItemProduto itemProduto = new ItemProduto();
        Item_DAO item_DAO = new Item_DAO(); 
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
//checa se os cookies existiam, se nao, cria o que faltava
        if ((compra.getCookie() == 0) || (compra.getIdCompra() == 0)){
            try {
                Contador contador = new Contador();
                Contador_DAO contador_dao = new Contador_DAO();
                contador = contador_dao.get(contador);
                if(compra.getCookie() == 0){
                    compra.setCookie(contador.getIdCookie());
                    contador.setIdCookie(compra.getCookie()+1);
                }
                if(compra.getIdCompra()==0){
                    compra.setIdCompra(contador.getIdCompra());
                    contador.setIdCompra(compra.getIdCompra()+1);
                }
                contador_dao.Alterar(contador);
                meusItensProdutos.add(itemProduto);
            } catch (Exception e) {}
        } else {
            //se já existia, pega lista de itens no BD
            meusItensProdutos = item_DAO.Listar(compra.getIdCompra());
            //prepara request para página inicial do pedido e manda para lá
        request.setAttribute("meusItensProdutos", meusItensProdutos);
        request.setAttribute("Compra", compra);
        RequestDispatcher rd = request.getRequestDispatcher("ListaCompraEmAndamentoView.jsp");
        rd.forward(request, response);
        }

        Cookie cookiePedido = new Cookie("CookiePedidoDW", String.valueOf(compra.getIdCompra()));
        cookiePedido.setMaxAge(60*60*24*7);
        response.addCookie(cookiePedido);
        Cookie cookieCliente = new Cookie("CookieLojaDW", String.valueOf(compra.getCookie()));
        cookieCliente.setMaxAge(60*60*24*7);
        response.addCookie(cookieCliente);

//prepara request para página inicial do pedido
        request.setAttribute("meusItensProdutos", meusItensProdutos);
        request.setAttribute("Compra", compra);
        RequestDispatcher rd = request.getRequestDispatcher("PesquisarItemCompra?categoria=0");
        rd.forward(request, response);
    }
}