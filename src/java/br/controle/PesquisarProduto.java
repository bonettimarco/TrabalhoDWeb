/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;


import br.DAO.Produto;
import br.DAO.Produto_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PesquisarProduto", urlPatterns = {"/PesquisarProduto"})
public class PesquisarProduto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Produto_DAO produto_DAO = new Produto_DAO();
        ArrayList<Produto> meusProdutos, todosProdutos;
        Produto produto = new Produto();
        String pesquisa, descricao, nome;
        String[] lista;
        int[] codigos;
        int k = 0;
        
        meusProdutos = new ArrayList<Produto>();
        pesquisa = (String) request.getParameter("pesquisa");
        lista = pesquisa.split(",");
        todosProdutos = produto_DAO.Listar();
        for (int i = 0; i < todosProdutos.size(); i++){
            produto = todosProdutos.get(i);
            nome = produto.getNome();
            descricao = produto.getDescricao();
            for (int j = 0; j < lista.length; j++){
                lista[j] = lista[j].replace(" ","");
                if (nome.toLowerCase().contains(lista[j].toLowerCase()) || descricao.toLowerCase().contains(lista[j].toLowerCase())) {
                    meusProdutos.add(produto);
                }
            }
        }
        request.setAttribute("meusProdutos", meusProdutos);
        RequestDispatcher rd = request.getRequestDispatcher("ListaProdutoView.jsp");
        rd.forward(request, response);
    }
}
