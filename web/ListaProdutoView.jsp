<%@page import="java.text.NumberFormat"%>
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

        </style>
    </head>
    <body>
        <jsp:include page="head.jsp"></jsp:include>
        <%! boolean faz = false; %>
        <% String usuario = ""+(String)session.getAttribute("NomeUsuarioLogado"); %>
        <% if(usuario.contentEquals("admin")){ faz = true; } %>
        <% usuario = ""; %>

<session>
 <div class="container row col-md-12" background-color="#c4534f">
    <div class="aside col-lg-12 col-md-12 col-lg-offset-8 col-md-offsset-8 text-center">
        <a href="PesquisarItemCompra?categoria=0">Todos os produtos</a>|<a href="PesquisarItemCompra?categoria=1">Eletrodomésticos</a>|<a href="PesquisarItemCompra?categoria=2">Informática</a> | <a href="PesquisarItemCompra?categoria=3">Eletroeletrônicos</a> |<a href="PesquisarItemCompra?categoria=4">Smartphones</a>
        <% if(faz){ %> <a href="Form_Produto.jsp">|  Incluir Produto</a> <% } %>|<a href="IniciarCompra">Ir para o Carrinho</a> 
        <a href="IniciarCompra"><img src="carrinho.png" class="col-lg-offset-8" width="200 px"></a>
        <p></p>
    </div>
    <div class="aside col-lg-4 col-md-3 text-center">
          <h1>Lista de Produtos</h1>
    </div>
         <inp
         
     </div>
    <p></p>
    <table>
        <thead>
        <th>Pesquisar<br>produto</th>
        <th>
            <form action="PesquisarProduto" method="POST">
            <input type="text" name="pesquisa" value="" >
        </th>
        <th>
            <input type="submit" value="Separe cada item por virgula">
            </form> 
        </th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </table>
    <table>
        <thead>
            <th></th>
            <th>IdProduto</th>
            <th>Categoria</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Valor</th>
            <th></th>
    </thead>
        <%
            ArrayList<Produto> resultado = (ArrayList) request.getAttribute("meusProdutos");
            for (int i = 0; i < resultado.size(); i++) {
                Produto aux = (Produto)resultado.get(i);
        %>
        <tr>
        <td><a href="IncluirItemCompra?codigo=<%=aux.getIdProduto() %>">Comprar</a></td>
        <td><%=aux.getIdProduto()%></td>
        <td><%=aux.getIdCategoria()%></td>
        <td><%=aux.getNome()%></td> 
        <td><%=aux.getDescricao()%></td>
        <td><%=NumberFormat.getCurrencyInstance().format(aux.getValor())%></td> 
        <td><a href="VisualizarProduto?idProduto=<%=aux.getIdProduto()%>">Visualizar</a> <% if(faz){ %> | <a href="EditarProduto?idProduto=<%=aux.getIdProduto()%>">Editar</a> | <a href="ExcluirProduto?idProduto=<%=aux.getIdProduto()%>">Excluir</a></td>
        <% } %> 
        </tr>
        <%
            }
        faz=false;
        %>

    </table>
            </div>
      </div>
    </section>
</body>
</html>

