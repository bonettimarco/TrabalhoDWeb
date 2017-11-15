<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="custom.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Produto em servlet</title>
    </head>
    <body>
        <jsp:include page="head.jsp"></jsp:include>

        <h1>Incluir Produto</h1>
        <form action="IncluirProduto" method="POST">
            Número do item:<br>
            <input type="text" name="id" >
            <br>
            Categoria:<br>
            <input type="text" name="idCategoria" >
            <br>
            Nome:<br>
            <input type="text" name="nome" >
			<br>
            Descrição:<br>
            <input type="text" name="descricao" >
            <br>        
            Valor:<br>
            <input type="text" name="valor" >
            <br><br>
            <input type="submit" value="Submit">
        </form> 
    </body>
</html>
