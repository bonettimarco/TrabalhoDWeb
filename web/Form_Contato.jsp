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

        <h1>Incluir Contato</h1>
        <form action="Incluir" method="POST">
            <% if(
                    (request.getAttribute("erro_email") != null)
                    || (request.getAttribute("erro_senha") != null)
                 ) { %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_mail"));%></h3>        
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_senha"));%></h3>        
            <% }%>
            id:<br>
            <input type="text" name="id" >
            <br>
            e-mail:<br>
            <input type="text" name="email" >
            <br>
            senha:<br>
            <input type="password" name="senha" >
            <br>
            <br>
            <input type="submit" value="Submit">
        </form> 
    </body>
</html>
