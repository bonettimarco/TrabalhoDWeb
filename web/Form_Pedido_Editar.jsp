<%@page import="br.DAO.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="custom.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processar Pedido em servlet</title>
    </head>
    <body>
        <jsp:include page="head.jsp"></jsp:include>

        <h1>Confirmar Pedido</h1>
        <% Produto produto = (Produto) request.getAttribute("produto"); 
		Item item = (Item) request.getAttribute("item");
        %>
        <form action="Editar" method="POST">
            
            <input type="hidden" name="idCompras" value="<%=produto.getId()%>" >
            
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
