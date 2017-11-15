<!DOCTYPE html>
<html>
<head>
        <link rel="stylesheet" type="text/css" href="custom.css" />
	<meta charset="utf-8" />
	<title>Formulario Cliente</title>
        
	<script type="text/javascript">

	function validarFloat(valor){ 
     valor = parseFloat(valor) 
      if (isNaN(valor)) { 
            return "" 
      }else{ 
         return valor 
      } 
} 

function validaCampos(){
    //nome
    if ((formulario.name.value.length==0)||(formulario.name.value.length>59)){
       alert("Tem que escrever um nome. S� pode ter letras e no m�ximo 60 posi��es")
       formulario.nome.focus()
       return 0;
    }

	    //endereço
    if ((formulario.address.value.length==0) || (formulario.address.value.length>49) ){
       alert("Tem que escrever um endere�o at� 50 posi��es")
       formulario.address.focus()
       return 0;
    }
    //bairro
    if ((formulario.quarter.value.length==0) || (formulario.quarter.value.length>19)){
       alert("Tem que escrever um bairro em at� 20 posi��es")
       formulario.quarter.focus()
       return 0;
    }

	    //cidade
    if (((formulario.cidade.value.length==0)||(formulario.cidade.value.length>19))){
       alert("Tem que escrever a cidade em at� 20 posi��es")
       formulario.cidade.focus()
       return 0;
    }

    //CEP
    if ((formulario.cep.value.length==0)||(formulario.cep.value.length>19)){
       alert("Favor escrever o CEP no formato XXXXX-XXX somente com n�meros")
       formulario.cep.focus()
       return 0;
    }

    //valido o Estado
    if (((formulario.estado.value=="")||(formulario.estado.value.length>19))){
       alert("Tem que informar o Estado em at� 20 caracteres sem n�meros.")
       formulario.estado.focus()
       return 0;
    }

    //valido o CPF
    if (((formulario.cpf.value=="")||(formulario.cpf.value.length>19))){
 		alert("Favor informar o CPF no formato XXXXXXXXX-XX")
       formulario.cpf.focus()
       return 0;
    }
	

    //valido o RI
    if (((formulario.ri.value=="")||(formulario.ri.value.length>19))){
 		alert("Favor informar o RI somente com n�meros")
       formulario.ri.focus()
       return 0;
    }
	
    //valido o telefone
    if (((formulario.telefone.value=="")||(formulario.telefone.value.length>19))){
 		alert("Favor informar o telefone somente com n�meros")
       formulario.telefone.focus()
       return 0;
    }
	
    //valido o celular
    if (((formulario.celular.value=="")||(formulario.celular.value.length>19))){
 		alert("Favor informar o celular somente com n�meros")
       formulario.celular.focus()
       return 0;
    }

	    //valido o cart�o de cr�dito
    if (((formulario.cartao.value=="")||(formulario.cartao.value.length>13))){
 		alert("Favor informar o cart�o de cr�dito somente com 12 n�meros")
       formulario.cartao.focus()
       return 0;
    }

	    //valido o bandeira
    if (((formulario.bandeira.value=="")||(formulario.bandeira.value.length>11))){
 		alert("Favor informar a bandeira do cartao")
       formulario.bandeira.focus()
       return 0;
    }

	
    //o formul�rio se envia
    alert("Muito obrigado por enviar o formulario");
    formulario.submit();
}


</script>
</head> 
<body> 

        <form action="DadosFecharCompra" method="post" id="formulario">
	<div class="box"> 
		<h1>Formulario Cliente :</h1>
 
		<label> 
			<span>e-mail</span>
 			<input type="text" class="input_text" name="email" id="email"/>
 		</label>
                
                <label> 
			<span>Nome</span>
 			<input type="text" class="input_text" name="nome" id="name"/>
 		</label>
 
		<label>
 			<span>Endere�o</span>
			<input type="text" class="input_text" name="endereco" id="address"/>
		 </label>
 
		<label>
 			<span>Bairro</span>
			<input type="text" class="input_text" name="bairro" id="quarter"/>
		</label>
 
		<label>
			 <span>Cidade</span>
			<input type="text" class="input_text" name="cidade" id="city"/>
		</label>           

		<label>
			 <span>CEP</span>
			<input type="text" class="input_text" name="cep" id="ZIP"/>
		</label>           
		
		<label>
			 <span>Estado (UF)</span>
			<input type="text" class="input_text" name="estado" id="state"/>
		</label>           
		
		</div>
		<div class="box"> 
		<label>
			 <span>referencias</span>
			<input type="text" class="input_text" name="referencia" id="reference"/>
		</label>           
		
		
		<label>
			 <span>CPF</span>
			<input type="text" class="input_text" name="cpf" id="docment"/>
		</label>           
		
		<label>
			 <span>RI (identidade )</span>
			<input type="text" class="input_text" name="ri" id="id"/>
		</label>           
		
		<label>
			 <span>Telefone fixo</span>
			<input type="text" class="input_text" name="telefone" id="tel"/>
		</label>           
		
		<label>
			 <span>Celular</span>
			<input type="text" class="input_text" name="celular" id="cell"/>
		</label>           
		
		<label>
			 <span>N�mero do cart�o de credito</span>
			<input type="text" class="input_text" name="cartao" id="card"/>
		</label>           
		
		<label>
			 <span>Bandeira do cart�o de cr�dito (visa, master...)</span>
			<input type="text" class="input_text" name="bandeira" id="flag"/>
		</label>
		
		<label>
			<input type="button" class="button" value="CONFIRMAR A COMPRA" onclick="validaCampos();" />
		</label>   
                    
					
		</div>
</form> 
</body>

<style>
*{ margin:0; padding:0;}

body{ font:100% normal Arial, Helvetica, sans-serif; }

form,input,select,textarea{margin:0; padding:0; color:#ffffff;}


</style>
</html>