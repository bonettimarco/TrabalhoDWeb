/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Contato;
import br.DAO.Contato_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LogarFuncionarios", urlPatterns = {"/LogarFuncionarios"})
public class LogarFuncionarios extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
		Contato contato = new Contato();
                Contato_DAO contato_DAO = new Contato_DAO();
		
		String email_user = request.getParameter("email");
        contato.setEmail(email_user);
        try {
            contato = contato_DAO.get(contato);
        } catch (Exception ex) {
            Logger.getLogger(LogarFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
		String senha_user = (String)request.getAttribute("senhaCriptografada");
		if (senha_user.equals(contato.getSenha())) {
            HttpSession session = request.getSession();
            session.setAttribute("NomeUsuarioLogado", "admin");
			session.setAttribute("IdUsuarioLogado", contato.getId());
            session.setAttribute("logado", "ok");
            RequestDispatcher resposta = request.getRequestDispatcher("sucesso.jsp");
            resposta.forward(request, response);
        } else {
            response.sendRedirect("Form_Login.jsp");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.sendRedirect("Form_Login.jsp");
    }

}
