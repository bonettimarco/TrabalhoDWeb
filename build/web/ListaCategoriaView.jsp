<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="custom.css" />
        <title>CRUD em servlet</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>
    <body>
        <jsp:include page="head.jsp"></jsp:include>
        <h1>Lista de Categorias</h1>
        <a href="Form_Categoria.jsp">Incluir Categoria</a>
        <p></p>
        <table>
            <thead>
                <th>Id</th>
                <th>Descrição</th>
                <th></th>
            </thead>
        <%
            ArrayList<Categoria> resultado = (ArrayList) request.getAttribute("Categorias");
            for (int i = 0; i < resultado.size(); i++) {
                Categoria aux = (Categoria)resultado.get(i);
        %>
        <tr>
        <td><%=aux.getId()%></td>
        <td><%=aux.getDescricao()%></td>
        <td><a href="VisualizarCategoria?id=<%=aux.getId()%>">Visualizar</a> | <a href="EditarCategoria?id=<%=aux.getId()%>">Editar</a> | <a href="ExcluirCategoria?id=<%=aux.getId()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>

</body>
</html>

