<%@page import="br.DAO.Categoria"%>
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
         <h1>Categoria</h1>
        <% Categoria categoria = (Categoria) request.getAttribute("Categoria"); 
        %>
        <form action="ListaCategoria" method="GET">
            
            <input type="hidden" name="id" value="<%=categoria.getId()%>" >
            
            Descrição:<br>
            <input type="text" name="descricao" value="<%=categoria.getDescricao() %>" readonly="true" >
            <br>
			<br>
            <a href="ListaCategoria">Retorna</a>
        </form> 
    </body>
</html>
