<%@page import="br.DAO.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="custom.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
        <style>
        input:-moz-read-only { /* For Firefox */
            background-color: #DCDCDC;
        }

        input:read-only {
            background-color: #DCDCDC;
        }
        </style>
    </head>
    <body>
        <jsp:include page="head.jsp"></jsp:include>
        <h1>Lista de Produtos</h1>
        <h1>Excluir Produto</h1>
        <% Produto produto = (Produto) request.getAttribute("produto"); 
        %>
        <form action="ExcluirProduto" method="Post">
            
            <input type="hidden" name="idProduto" value="<%=produto.getIdProduto()%>" >

            Nome:<br>
            <input type="text" name="nome" value="<%=produto.getNome() %>" readonly="" >
            <br>
            <br>
            <input type="submit" value="Confirmar Exclusão">
            <a href="ListaProduto">Retorna</a>
        </form> 
    </body>
</html>
