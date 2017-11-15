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
        <h1>Lista de Contatos</h1>
        <h1><% out.println(request.getAttribute("mensagem"));    %></h1>
        <p></p>
        <div><a href="<% out.println(request.getAttribute("retorna"));%>">Retornar Para a Lista</a></div>
    </body>
</html>
