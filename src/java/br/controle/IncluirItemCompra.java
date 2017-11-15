/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;


import br.DAO.Produto;
import br.DAO.ItemProduto;
import br.DAO.Produto_DAO;
import br.DAO.Item;
import br.DAO.Item_DAO;
import br.DAO.Compra;
import br.DAO.Compra_DAO;
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name = "IncluirItemCompra", urlPatterns = {"/IncluirItemCompra"})
public class IncluirItemCompra extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Produto_DAO produto_DAO = new Produto_DAO();
        Produto produto = new Produto();
        ItemProduto meusItensProdutos = new ItemProduto();
        Compra_DAO compra_DAO = new Compra_DAO();
        Compra compra = new Compra();
        Compra aux = new Compra();
        Item_DAO item_DAO = new Item_DAO();
        Item item = new Item();
        String lista = "";
        ArrayList <Item> meusItens;
        ArrayList <Produto> meusProdutos;
        int[] codigos = new int[30];
        boolean faz = false;
        
//pega os cookies, inicializa Compra se ainda não existir, recupera lista de produtos já incluidos
        Cookie[] cookies = request.getCookies();
        for(int i=0; i<cookies.length; i++){
            if(cookies[i].getName().equals("CookieLojaDW")){
                compra.setCookie(Integer.parseInt(cookies[i].getValue()));
            }
            if(cookies[i].getName().equals("CookiePedidoDW")){
                compra.setIdCompra(Integer.parseInt(cookies[i].getValue()));
                if (compra.getIdCompra() > 0) faz = true;
                else {
                        RequestDispatcher rd = request.getRequestDispatcher("IniciarCompra");
                        rd.forward(request, response);
                }//nao existe pedido em andamento
            } //fecha o if
            } //fecha o for
//checa se o produto nao está repetido na lista
        item.setIdProduto(Integer.parseInt(request.getParameter("codigo")));
        item.setIdPedido(compra.getIdCompra());
        try {
            if (!(item_DAO.checa(item))) { //se não estiver repetido, inclusão ok
            
                item_DAO.Inserir(item);
            } else { //se já existia soma uma unidade a quantidade
                item.setQuantidade(1+item.getQuantidade());
                item_DAO.Alterar(item);
           }
           } catch (Exception ex) {
                Logger.getLogger(IncluirItemCompra.class.getName()).log(Level.SEVERE, null, ex);
            }

        RequestDispatcher rd = request.getRequestDispatcher("IniciarCompra");
        rd.forward(request, response);       
    }
}

