<%@page import="br.DAO.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="custom.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Produto em servlet</title>
    </head>
    <body>
        <jsp:include page="head.jsp"></jsp:include>

        <h1>Alterar Dados do Produto</h1>
        <% Produto produto = (Produto)request.getAttribute("Produto"); 
        %>
        <form action="EditarProduto" method="POST">
            
            <input type="hidden" name="idProduto" value="<%=produto.getIdProduto()%>" >
            
            Categoria:<br>
            <input type="text" name="idCategoria" value="<%=produto.getIdCategoria() %>" >
            <br>
            Nome:<br>
            <input type="text" name="nome" value="<%=produto.getNome() %>" >
            <br>
            Descrição:<br>
            <input type="text" name="descricao" value="<%=produto.getDescricao() %>" >
            <br>        
            Valor:<br>
            <input type="text" name="valor" value="<%=produto.getValor() %>" >
            <br><br>
            <input type="submit" value="Alterar">
            <a href="ListaProduto">Retorna</a>
        </form> 
    </body>
</html>
