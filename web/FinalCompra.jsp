<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Produto"%>
<%@page import="br.DAO.ItemProduto"%>
<%@page import="br.DAO.Item"%>
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
        <jsp:include page="Final_head.jsp"></jsp:include>
        <jsp:include page="DadosGeraisDaCompra.jsp"></jsp:include>
        <jsp:include page="FinalDadosCliente.jsp"></jsp:include>
<%! ArrayList<ItemProduto> meusItensProdutos;
Compra compra;
ItemProduto aux;
double total = 0;
boolean faz = false;
%>
        <%
            meusItensProdutos = (ArrayList) request.getAttribute("meusItensProdutos");
            compra = (Compra) request.getAttribute("Compra");
            for (int i = 0; i < meusItensProdutos.size(); i++) {
                aux = (ItemProduto)meusItensProdutos.get(i);//cada um
                total += (aux.getValor()*aux.getQuantidade()); 
                }
        %>
<section>
      <div class="container">
            <div class="col-lg-12 text-center">
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
                aux = (ItemProduto)meusItensProdutos.get(i);//cada um
        %>
                <tr>
                <td><h2><%= aux.getQuantidade() %></h2></td>
                <td></td>
                <td><%=aux.getNome()%></td>
                <td><%=aux.getDescricao()%></td> 
                <td><%=NumberFormat.getCurrencyInstance().format(aux.getValor()) %></td>
                <td><%= NumberFormat.getCurrencyInstance().format(aux.getValor()*aux.getQuantidade())%></td> 
                </tr>
        <%
            } //fecha for
        %>
    </table>
            </div>
      </div>
</section>
</body>
</html>

