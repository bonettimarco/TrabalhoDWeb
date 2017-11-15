<%@page import="br.DAO.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
        <link rel="stylesheet" type="text/css" href="custom.css" />
    </head>
    <body>
        <h1>Lista de Categorias</h1>
        <h1>Excluir Categoria</h1>
        <% Categoria categoria = (Categoria) request.getAttribute("categoria"); 
        %>
        <form action="ExcluirCategoria" method="Post">
            
            <input type="hidden" name="id" value="<%=categoria.getId()%>" >
            
            Nome:<br>
            <input type="text" name="descricao" value="<%=categoria.getDescricao() %>" readonly="" >
            <br>
<br>
            <input type="submit" value="Confirmar Exclusão">
            <a href="ListaCategoria">Retorna</a>
        </form> 
    </body>
</html>
