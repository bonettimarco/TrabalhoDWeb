<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Contato"%>
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
        <h1>Lista de Contatos</h1>
        <a href="Form_Contato.jsp">Incluir Contato</a>
        <p></p>
        <table>
            <thead>
            <th>Id</th>
            <th>Email</th>
            <th>Senha</th>
            <th>Admin</th>
        </thead>
        <%
            ArrayList<Contato> resultado = (ArrayList) request.getAttribute("meusContatos");
            for (int i = 0; i < resultado.size(); i++) {
                Contato aux = (Contato)resultado.get(i);
        %>
        <tr>
        <td><%=aux.getId()%></td>
        <td><%=aux.getEmail()%></td> 
        <td><%=aux.getSenha()%></td>
        <td><%=aux.isAdmin() %></td>
        <td><a href="Visualizar?id=<%=aux.getId()%>">Visualizar</a> | <a href="Editar?id=<%=aux.getId()%>&senha=1">Editar</a> | <a href="Excluir?id=<%=aux.getId()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>

</body>
</html>

