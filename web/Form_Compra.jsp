<%@page import="br.DAO.Compra"%>
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
        <h1>Compras</h1>
        <% Compra compra = (Compra) request.getAttribute("Compra"); 
        if (true);
        else {
            
        %>
        <form action="ListaCompra" method="GET">
            
            <input type="hidden" name="idCompra" value="<%=compra.getIdCompra()%>" >
            
            Cliente:<br>
            <input type="text" name="coockie" value="<%=compra.getCookie() %>" readonly="true" >
            <br>
            Total:<br>
            <input type="text" name="total" value="<%=compra.getTotal() %>" readonly="true" >
            <br>
            Processado:<br>
            <input type="text" name="processado" value="<%=compra.getProcessado() %>" readonly="true" >
            <br>
            Funcionário:<br>
            <input type="text" name="idFuncionario" value="<%=compra.getIdFuncionario() %>" readonly="true" >
            <% } %>
            <br>
            <br>
            <a href="ListaCompra">Retorna</a>
        </form> 
    </body>
</html>
