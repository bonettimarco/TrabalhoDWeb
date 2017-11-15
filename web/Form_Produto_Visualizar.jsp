<%@page import="br.DAO.Produto"%>
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
        <h1>Produto</h1>
        <% Produto produto = (Produto) request.getAttribute("Produto"); 
        %>
        <a href="IncluirItemCompra?codigo=<%=produto.getIdProduto() %>">Incluir Produto no Carrinho</a><br>
        <form action="ListaProduto" method="GET">
            
            <input type="hidden" name="idProduto" value="<%=produto.getIdProduto()%>" >
            
            Categoria:<br>
            <input type="text" name="idCategoria" value="<%=produto.getIdCategoria() %>" readonly="true" >
            <br>
            Nome:<br>
            <input type="text" name="nome" value="<%=produto.getNome() %>" readonly="true" >
            <br>
            Descrição:<br>
            <input type="text" name="descricao" value="<%=produto.getDescricao() %>" readonly="true" >
            <br>
            Valor:<br>
            <input type="text" name="valor" value="<%=produto.getValor() %>" readonly="true" >
            <br>
			<br>
            <a href="ListaProduto">Retorna</a>
        </form> 
    </body>
</html>
