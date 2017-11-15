<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Compra"%>
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
        <%!
            ArrayList<Compra> resultado;
                    
        %>
                    
        <h1>Lista de Compras</h1>
        <a href="Form_Compra.jsp">Incluir Compra</a>
        <p></p>
        <table>
            <thead>
            <th>Pedido</th>
            <th>Cookie</th>
            <th>Cliente</th>
            <th>Total</th>
            <th>Processamento</th>
            <th>Encarregado</th>
            <th></th>
        </thead>
        <%
            resultado = (ArrayList<Compra>) request.getAttribute("Compra");
            if (resultado.size() > 0){
                for (int i = 0; i < resultado.size(); i++) {
                Compra aux = (Compra)resultado.get(i);
        %>
        <tr>
        <td><%=aux.getIdCompra()%></td>
        <td><%=aux.getCookie()%></td> 
        <td><%=aux.getIdCompra()%></td>
        <td><%=aux.getTotal()%></td>
        <td><%=aux.getProcessado()%></td>
        <td><%=aux.getIdFuncionario()%></td>
        <td><a href="VisualizarCompra?id=<%=aux.getIdCompra()%>">Visualizar</a></td>
        </tr>
        <%
            }
            }
        %>

    </table>

</body>
</html>

