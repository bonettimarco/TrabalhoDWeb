<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="custom.css" />
        <title>CRUD em servlet</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </head>
    <body>
        <jsp:include page="head.jsp"></jsp:include>
        <h1>Loja DW</h1>
        <a href="#">Área restrita</a><br>
        <a href="#">Eletrodomésticos |</a>
        <a href="#">Informática |</a>
        <a href="#">Eletroeletrônicos |</a>
        <a href="#">Smartphones |</a>
        <form>
            <input type="text" name="pesquisa" value="Digite o produto que deseja"> 
            <input type="submit" value="Pesquisar">
        </form>
        <p></p>
        <table>
            <thead>
            <th>IdProduto</th>
            <th>Categoria</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Valor</th>
        </thead>
        <%
            ArrayList<Produto> resultado = (ArrayList) request.getAttribute("minhasCompras");
            for (int i = 0; i < resultado.size(); i++) {
                Produto aux = (Produto)resultado.get(i);
        %>
        <tr>
        <td><%=aux.getIdProduto()%></td>
        <td><%=aux.getIdCategoria()%></td>
        <td><%=aux.getNome()%></td> 
        <td><%=aux.getDescricao()%></td>
        <td><%=aux.getValor()%></td> 
        <td><a href="VisualizarProduto?idProduto=<%=aux.getIdProduto()%>">Visualizar</a> | <a href="EditarProduto?idProduto=<%=aux.getIdProduto()%>">Editar</a> | <a href="ExcluirProduto?idProduto=<%=aux.getIdProduto()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>

</body>
</html>

