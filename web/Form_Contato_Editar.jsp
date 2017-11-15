<%@page import="br.DAO.Contato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="custom.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
    </head>
    <body>
        <jsp:include page="head.jsp"></jsp:include>
<div class="col-md-6">
        <h1>Lista de Contatos</h1>
        <h1>Alterar Dados do Contato</h1>
        <% Contato contato = (Contato) request.getAttribute("contato"); 
        %>
        <form action="Editar" method="POST">
            
            <input type="hidden" name="id" value="<%=contato.getId()%>" >
            
            <% if(request.getAttribute("erro_email") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_email"));%></h3>        
            <% }%>
            e-mail:<br>
            <input type="text" name="email" value="<%=contato.getEmail() %>" >
            <br>
            É administrador?<br>
            <input type="text" name="admin" value="<%=contato.isAdmin()%>" >
            <br><br>
            senha:<br>
            <input type="password" name="senha" value="<%=contato.getSenha() %>" >
            <br>           
            <input type="submit" value="Alterar">
            <a href="ListaContato">Retorna</a>
        </form> 
</div>
            
    </body>
</html>
