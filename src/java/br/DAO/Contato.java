package br.DAO;

public class Contato {

    private int id;
    private String email;
    private String senha;
    private boolean admin;
    private int session;

    public Contato(){}
    
    public Contato(int id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.admin = true;
        this.session = 0;
    }

        public Contato(int id, String email, String senha, boolean admin) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.admin = admin;
        this.session = 0;
    }
        
    public Contato(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

       
    public boolean getAdmin(){
        return admin;
    }
	
	public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isAdmin(){
        return admin;
    }

}
