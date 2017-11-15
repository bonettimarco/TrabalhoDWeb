<%@page import="br.DAO.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <link rel="stylesheet" type="text/css" href="custom.css" />
	<meta charset="utf-8" />
	<title>Dados Cliente</title>
        
	<script type="text/javascript">

	function avisarCliente(){
             alert("Você receberá um mail de confirmação da entrega.");
}


</script>
</head> 
<body> 
         <h1>Dados do cliente</h1>
        <% Cliente cliente = (Cliente) request.getAttribute("Cliente"); 
        %>
        <form action="#" method="GET" id="formulario">
	<div class="box"> 
		<h1>Dados de entrega do Cliente :</h1>
 
		<label> 
			<span>Nome</span>
                        <input type="text" class="input_text" value="<%= cliente.getNome() %>" readonly="true"/>
 		</label>
 
		<label>
 			<span>Endereço</span>
			<input type="text" class="input_text" name="endereco" id="address" value="<%= cliente.getEndereco() %>" readonly="true"/>
		 </label>
 
		<label>
 			<span>Bairro</span>
			<input type="text" class="input_text" name="bairro" value="<%= cliente.getBairro() %>" readonly="true"/>
		</label>
 
		<label>
			 <span>Cidade</span>
			<input type="text" class="input_text" name="cidade" value="<%= cliente.getCidade() %>" readonly="true"/>
		</label>           

		<label>
			 <span>CEP</span>
			<input type="text" class="input_text" name="cep" value="<%= cliente.getCep() %>" readonly="true"/>
		</label>           
		
		<label>
			 <span>Estado (UF)</span>
			<input type="text" class="input_text" name="estado" value="<%= cliente.getEstado() %>" readonly="true"/>
		</label>           
		
		</div>
		<div class="box"> 
		<label>
			 <span>referencias</span>
			<input type="text" class="input_text" name="referencia" value="<%= cliente.getReferencias() %>" readonly="true"/>
		</label>           
		
	
		<label>
			 <span>Telefone fixo</span>
			<input type="text" class="input_text" name="telefone" value="<%= cliente.getTelFixo() %>" readonly="true"/>
		</label>           
		
		<label>
			 <span>Celular</span>
			<input type="text" class="input_text" name="celular" value="<%= cliente.getCelular() %>" readonly="true"/>
		</label>           
		
			<input type="hidden" onload="avisarCliente();" />
		</div>
</form> 
                <div></div>
</body>

<style>
*{ margin:0; padding:0;}

body{ font:100% normal Arial, Helvetica, sans-serif; }

form,input,select,textarea{margin:0; padding:0; color:#ffffff;}


</style>
</html>