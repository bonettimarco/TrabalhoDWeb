<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Compra"%>
<%@page import="br.DAO.ItemProduto"%>
<%@page import="br.DAO.Item_DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" type="text/css" href="custom.css" />
        <title>CRUD em servlet</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">


    </head>
    <body>
               
        <%
         String usuario = ""+(String)session.getAttribute("NomeUsuarioLogado");
         if(usuario.contentEquals("admin")){
        	int id = (Integer) session.getAttribute("IdUsuarioLogado");
                 String status = ""+(String)session.getAttribute("logado");
            
        %>
                <section>
                      <div class="container">
                            <div class="col-lg-12 text-center">
                                <div class="col-lg-4 col-md-4 col-xs-4">
                                    <h1><%=usuario%></h1>
                                    <h1><%=id%></h1>
                                    <h1><%=status%></h1>
                                </div>
                            </div>
                      </div>
                </section>
        <% } %>
</body>
</html>

