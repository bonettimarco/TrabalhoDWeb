<%-- 
    Document   : head
    Created on : 28/10/2017, 00:31:58
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="col-md-12"> 
            <div class="col-md-4">
            <a href="IniciarCompra"><img src="DW.jpg" class="col-lg-offset-8" width="150 px"></a>
            </div>
            <div class="col-md-4">
               <a class="float-right" href="Form_Login.jsp">Área restrita</a>
            </div>
            <% String usuario = ""+(String)session.getAttribute("NomeUsuarioLogado");%>
            <% if(usuario.contentEquals("admin")){ %>
            <div class="col-md-4">
               <a class="float-right" href="SairLogin">Logout</a>
            </div>
            <% } %>
            
 
        </div>
    </body>
</html>
