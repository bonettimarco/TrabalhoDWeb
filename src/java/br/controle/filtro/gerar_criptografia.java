package br.controle.filtro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;


@WebFilter(filterName = "gerar_criptografia", urlPatterns={"/LogarFuncionarios", "/Incluir", "/Editar"})
public class gerar_criptografia implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        String senha_user = request.getParameter("senha");
        String com_criptografia;
        int numero = 0;
        String digitoString;
        char dig;
        int digito;
        for (int i=0;i<senha_user.length();i++){
            numero *= 10;
            dig = senha_user.charAt(i);
            digitoString = ""+dig;
            digito=Integer.parseInt(digitoString);
            if (digito+3<10) { numero=numero+digito+3;}
            else numero=numero+digito-3;
        }
        com_criptografia = ""+numero;
        request.setAttribute("senhaCriptografada", ""+numero);
        chain.doFilter(request,response);
    }
    
       
    @Override
    public void destroy() {  }

    @Override
    public void init(FilterConfig filterConfig) {   

    }







}
