/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Compra;
import br.DAO.ItemProduto;
import br.DAO.Item_DAO;
import br.DAO.Produto_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
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
@WebServlet(name = "ListaCompraEmAndamento", urlPatterns = {"/ListaCompraEmAndamento"})
public class ListaCompraEmAndamento extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<ItemProduto> meusItensProdutos = new ArrayList<ItemProduto>();
        Compra compra = new Compra();
        Item_DAO item_DAO = new Item_DAO(); 
        boolean faz = false;

        compra = new Compra((Compra)request.getAttribute("Compra"));
        if (compra.getIdFuncionario() != 999) faz=true;
        if (faz) {
             meusItensProdutos = item_DAO.Listar(compra.getIdCompra());
        }
        request.setAttribute("Compra", compra);
        request.setAttribute("meusProdutos", meusItensProdutos);
        RequestDispatcher rd = request.getRequestDispatcher("ListaCompraEmAndamentoView.jsp");
        rd.forward(request, response);
    }
}
