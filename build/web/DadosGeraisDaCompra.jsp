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
        <jsp:include page="head.jsp"></jsp:include>
        
        <%!
        ArrayList<ItemProduto> meusItensProdutos;
        Compra compra = new Compra();
        ItemProduto aux;
        double total = 0;
        boolean faz = false;
        %>
 
 <section>
      <div class="container">
            <div class="col-lg-12 text-center">
        <h1>Dados da Compra</h1>
        <p></p>
        <%
            compra = (Compra) request.getAttribute("Compra");
            if (compra.getIdFuncionario() != 999) faz = true;
 //aviso vindo do controlador, de que nao tem nada ainda no carrinho (999){
                if (faz){
                    meusItensProdutos = (ArrayList<ItemProduto>) request.getAttribute("meusItensProdutos");
                            for (int i = 0; i < meusItensProdutos.size(); i++) {
                                aux = (ItemProduto)meusItensProdutos.get(i);
                                total += (aux.getValor()*aux.getQuantidade()); 
                                } //fecha o for
                }//fecha o if
        %>
        <table>
            <thead>
                <th>Pedido numero <%=compra.getIdCompra()%></th>
                <th></th>
                <th></th>
                <th></th><th></th><th></th><th></th><th></th>
                <th>Total</th>
                <th><%= NumberFormat.getCurrencyInstance().format(total) %></th>
				<% total = 0; %>
            </thead>
             </tr>
        </table>
                
            </div>
      </div>
</section>
</body>
</html>

