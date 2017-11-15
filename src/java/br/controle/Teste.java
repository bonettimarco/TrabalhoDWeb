/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import java.io.*;
import java.text.*;
import java.util.*;
import br.DAO.Compra;
import br.DAO.Contador;
import br.DAO.Contador_DAO;
import br.DAO.Cliente;
import br.DAO.Cliente_DAO;
import br.DAO.ItemProduto;
import br.DAO.Item_DAO;
import br.DAO.Produto_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leo/adaptado por Marco
 */
@WebServlet(name = "Teste", urlPatterns = {"/Teste"})
public class Teste extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

     Cliente cliente = new Cliente("marco_mail", "Marco", "endereco", "bairro", "cidade", "cep", "estado", "referencias", "cpf", "ri", " String telFixo"," String celular"," String cartao", "Deira");
//     Cliente cliente = new Cliente();
     Cliente_DAO cliente_DAO = new Cliente_DAO();
        Contador contador = new Contador();
        Contador_DAO contador_DAO = new Contador_DAO();
        try {
            contador = contador_DAO.get(contador);
 //           cliente = cliente_DAO.get(cliente);
            cliente_DAO.Inserir(cliente);
        } catch (Exception ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html");
        ServletOutputStream out = response.getOutputStream();
        out.println("<HTML><BODY>");
        out.println(contador.getIdCliente());
        out.println(contador.getIdCookie());
        out.println(contador.getIdCompra());
        out.println(cliente.getEmail());
        out.println(cliente.getIdCliente());
        out.println(cliente.getBandeira());
        out.println(cliente.getBairro());
        out.println(cliente.getCidade());
        out.println(cliente.getTelFixo());
        out.println(cliente.getCelular());
        out.println("</HTML></BODY>");
        
        
    }
}
