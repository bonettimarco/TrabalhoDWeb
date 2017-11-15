<%@page import="br.DAO.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="custom.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Categorias em servlet</title>
    </head>
    <body>
        <jsp:include page="head.jsp"></jsp:include>
        <h1>Alterar Dados da Categoria</h1>
        <% Categoria categoria = (Categoria) request.getAttribute("Categoria"); 
        %>
        <form action="EditarCategoria" method="POST">
            
            <input type="hidden" name="id" value="<%=categoria.getId()%>" >
            
            Descrição:<br>
            <input type="text" name="descricao" value="<%=categoria.getDescricao() %>" >
            <br><br>
            <input type="submit" value="Alterar">
            <a href="ListaCategoria">Retorna</a>
        </form> 
    </body>
</html>
