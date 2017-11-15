<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="custom.css" />
        <title>CRUD Categoria em servlet</title>
    </head>
    <body>
        <jsp:include page="head.jsp"></jsp:include>
        <h1>Incluir Categoria</h1>
        <form action="IncluirCategoria" method="POST">
            Número:<br>
            <input type="text" name="id" >
            <br>
            Categoria:<br>
            <input type="text" name="descricao" >
            <br>
			<br>
            <input type="submit" value="Submit">
        </form> 
    </body>
</html>
