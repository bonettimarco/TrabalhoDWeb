/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Cliente;
import br.DAO.Cliente_DAO;
import br.DAO.Item;
import br.DAO.Item_DAO;
import br.DAO.Contador;
import br.DAO.Contador_DAO;
import br.DAO.Compra;
import br.DAO.Compra_DAO;
import br.DAO.ItemProduto;
import br.DAO.Produto;
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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DadosFecharCompra", urlPatterns = {"/DadosFecharCompra"})
public class DadosFecharCompra extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<ItemProduto> meusItensProdutos = new ArrayList<ItemProduto>();
        Compra compra = new Compra();
        Compra_DAO compra_DAO = new Compra_DAO();
        Item_DAO item_DAO = new Item_DAO(); 
        boolean faz = false;
        Cliente cliente;
	Cliente_DAO cliente_DAO = new Cliente_DAO();
        ItemProduto aux = new ItemProduto();
        double total = 0;
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
        
       String email = request.getParameter("email");
       String nome = request.getParameter("nome");
       String endereco = request.getParameter("endereco");
       String bairro = request.getParameter("bairro");
       String cidade = request.getParameter("cidade");
       String cep = request.getParameter("cep");
       String estado = request.getParameter("estado");
       String referencia = request.getParameter("referencia");
       String cpf = request.getParameter("cpf");
       String ri = request.getParameter("ri");
       String telefone = request.getParameter("telefone");
       String celular = request.getParameter("celular");
       String cartao = request.getParameter("cartao");
       String bandeira = request.getParameter("bandeira");
    cliente = new Cliente(email, nome, endereco, bairro, cidade, cep, estado, referencia, cpf, ri, telefone, celular, cartao, bandeira);
         try {
        meusItensProdutos = item_DAO.Listar(compra.getIdCompra());
            for (int i = 0; i < meusItensProdutos.size(); i++) {
                aux = (ItemProduto)meusItensProdutos.get(i);//cada um
                total += (aux.getValor()*aux.getQuantidade()); 
                }
            compra.setTotal(total);
             compra_DAO.Inserir(compra);
             cliente_DAO.Inserir(cliente);
         } catch (Exception ex) {
             Logger.getLogger(DadosFecharCompra.class.getName()).log(Level.SEVERE, null, ex);
         }
       
        
//programa para apagar os cookies
        Cookie cookiePedido = new Cookie("CookiePedidoDW", String.valueOf(compra.getIdCompra()));
        response.addCookie(cookiePedido);
        Cookie cookieCliente = new Cookie("CookieLojaDW", String.valueOf(compra.getCookie()));
        response.addCookie(cookieCliente);

        request.setAttribute("Compra", compra);
        request.setAttribute("meusItensProdutos", meusItensProdutos);
        request.setAttribute("Cliente", cliente);
        RequestDispatcher rd = request.getRequestDispatcher("FinalCompra.jsp");
        rd.forward(request, response);
    }
}