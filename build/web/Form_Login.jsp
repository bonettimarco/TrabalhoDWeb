<!DOCTYPE html>
<html>
<head>
        <link rel="stylesheet" type="text/css" href="custom.css" />
	<meta charset="utf-8" />
	<title>Formulario Login Funcionário</title>
        
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
    //email
    if (formulario.email.value.length==0){
       alert("Tem que escrever seu mail")
       formulario.email.focus()
       return 0;
    }

	    //senha
    if (formulario.senha.value.length==0){
       alert("Tem que escrever sua senha")
       formulario.senha.focus()
       return 0;
    }
	
    //o formulário se envia
    alert("Em caso de erro de usuário ou senha você será redirecionado novamente para o login");
    formulario.submit();
}


</script>
</head> 
<body> 

        <form action="LogarFuncionarios" method="post" id="formulario">
	<div class="box"> 
		<h1>Login :</h1>
 
		<label> 
			<span>e-mail</span>
 			<input type="text" class="input_text" name="email" id="email"/>
 		</label>
                
                <label> 
			<span>Senha</span>
 			<input type="password" class="input_text" name="senha" id="name"/>
 		</label>
	
		<label>
			<input type="button" class="button" value="ENTRAR" onclick="validaCampos();" />
		</label>   
                    
					
		</div>
		<a href="#">Esqueci a senha</a>
</form> 
</body>

<style>
*{ margin:0; padding:0;}

body{ font:100% normal Arial, Helvetica, sans-serif; }

form,input,select,textarea{margin:0; padding:0; color:#ffffff;}


</style>
</html>