<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Compra"%>
<%@page import="br.DAO.ItemProduto"%>
<%@page import="br.DAO.Item_DAO"%>
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
                <jsp:include page="DadosGeraisDaCompra.jsp"></jsp:include>
        <%!
            ItemProduto aux = new ItemProduto();
            Item_DAO item_DAO = new Item_DAO();
            ArrayList<ItemProduto> meusItensProdutos = new ArrayList<ItemProduto>() ;
            Compra compra;
            boolean faz = false;
             double total = 0;
         %>
               
        <%

            compra = (Compra) request.getAttribute("Compra");

               meusItensProdutos = (ArrayList<ItemProduto>) request.getAttribute("meusItensProdutos");
            
        %>
<section>
      <div class="container">
            <div class="col-lg-12 text-center">
                <div class="col-lg-4 col-md-4 col-xs-4">
                    <% if(meusItensProdutos.isEmpty()){ %>
                    <a href="PesquisarItemCompra?categoria=0">Pesquisar produtos</a> 
                     <% }else { %>
                    <a href="Form_Cliente.jsp?id=<%=compra.getIdCompra()%>">Finalizar Compra</a> | 
                    <a href="PesquisarItemCompra?categoria=0">Continuar Comprando</a> 
                </div>
                <div class="col-lg-12 col-md-12 col-xs-12 text-center">
                    <h3>Lista de produtos</h3>
                </div>
            </div>
            <div class="col-lg-12 text-center">
           
        <p></p>

        <table>
            <thead>
            <th>Quantidade<br>alterar</th>
                <th></th>
                <th>Código</th>
                <th>Produto</th>
                <th>Valor unidade</th>
                <th>Subtotal</th>
                <th></th>
            </thead>
        <%
             for (int i = 0; i < meusItensProdutos.size(); i++) {
               aux = (ItemProduto) meusItensProdutos.get(i);
         %>
                <tr>
                    <td><a href="SomarUm?idPedido=<%= aux.getIdPedido() %>&idProduto=<%= aux.getIdProduto() %>"> | ++ |</a><a href="TirarUm?idPedido=<%= aux.getIdPedido() %>&idProduto=<%= aux.getIdProduto() %>">|  --  |</a><a href="VisualizarProduto?idProduto=<%= aux.getIdProduto() %>"><h2><%= aux.getQuantidade() %></h2></a></td>
                <td></td>
                <td><%=aux.getNome()%></td>
                <td><%=aux.getDescricao()%></td> 
                <td><%=NumberFormat.getCurrencyInstance().format(aux.getValor()) %></td>
                <td><%= NumberFormat.getCurrencyInstance().format(aux.getValor()*aux.getQuantidade()) %></td> 
                </tr>
        <%
            } //fecha o for
        }//fecha o else
        %>
    </table>
            </div>
      </div>
</section>
</body>
</html>

