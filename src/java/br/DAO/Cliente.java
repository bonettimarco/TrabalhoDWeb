package br.DAO;

public class Cliente {
        //tamanhos configurados no BD
	private int idCliente;
        private String email;//max 30
        private String nome;//max 60
        private String endereco;//max 50
        private String bairro;
        private String cidade;
        private String cep;//max 10
        private String estado;//max 20
        private String referencias;
        private String cpf;
        private String ri;
        private String telFixo;
        private String celular;
        private String cartao;
        private String bandeira;//max 12
        private boolean admin;
		//o que nao marquei, max 20
		
	public Cliente(){}
                
    public Cliente(String email, String nome, String endereco, String bairro, String cidade, String cep, String estado, String referencias, String cpf, String ri, String telFixo, String celular, String cartao, String bandeira){
	 try {
		 Contador contador = new Contador();
		 Contador_DAO contador_DAO = new Contador_DAO();
		 contador = contador_DAO.get(contador);
		 idCliente = contador.getIdCliente();
		 contador.setIdCliente(idCliente+1);
		 contador_DAO.Alterar(contador);
		} catch (Exception e) {}
    this.email = email;
    this.nome=nome;
    this.endereco=endereco;
    this.bairro=bairro;
    this.cidade = cidade;
    this.cep = cep;
    this.estado= estado;
    this.referencias = referencias;
    this.cpf = cpf;
    this.ri = ri;
    this.telFixo = telFixo;
    this.celular = celular;
    this.cartao = cartao;
    this.bandeira = bandeira;
    this.admin = false;
    }
    
   
		public void setIdCliente(int idCliente){
				this.idCliente = idCliente;
		}

		public void setEmail(String email){
				this.email = email;
		}
		
        
        public void setNome(String nome){
            this.nome = nome;
        }//max 60
        
        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }//max 50
        
        public void setBairro(String bairro){
            this.bairro = bairro;
        }

        public void setCidade(String cidade){
            this.cidade = cidade;
        }

        public void setCep(String cep){
            this.cep = cep;
        }//max 10
        
        public void setEstado(String estado){
            this.estado = estado;
        }//max 2
        
        public void setReferencias(String referencias){
            this.referencias = referencias;
        }
        
        public void setCpf(String cpf){
            this.cpf = cpf;
        }
        
        public void setRi(String ri){
            this.ri = ri;
        }
        
        public void setTelFixo(String tel){
            telFixo = tel;
        }
        
        public void setCelular(String cel){
            celular = cel;
        }
        
        public void setAdmin(boolean admin){
            this.admin = admin;
        }
        
        
        public void setCartao(String cartao){
            this.cartao = cartao;
        }
        
        public void setBandeira(String bandeira){
            this.bandeira = bandeira;
        }//max 12
        
        public int getIdCliente(){
            return idCliente;
		}
        
		public String getEmail(){
            return email;
		}
        
        public String getNome(){
            return nome;
        }//max 60
        
        public String getEndereco() {
            return endereco;
        }//max 50
        
        public String getBairro(){
            return bairro;
        }

        public String getCidade(){
            return cidade;
        }

        public String getCep(){
            return cep;
        }//max 10
        
        public String getEstado(){
            return estado;
        }//max 2
        
        public String getReferencias(){
            return referencias;
        }
        
        public String getCpf(){
            return cpf;
        }
        
        public String getRi(){
            return ri;
        }
        
        public String getTelFixo(){
            return telFixo;
        }
        
        public String getCelular(){
            return celular;
        }
        
        public String getCartao(){
            return cartao;
        }
        
        public String getBandeira(){
            return bandeira;
        }//max 12
        
        public boolean isAdmin(){
            return admin;
        }//o que nao marquei, 20
    
}
