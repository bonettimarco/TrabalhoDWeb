package br.DAO;

public class Compra {

    private int idCompra;
    private int cookie;
    private double total;
    private boolean processado;
    private int idFuncionario;

    public Compra(int idCompra, int idCookie) {
        this.idCompra = idCompra;
	this.cookie = idCookie;
	total = 0;
        processado = false;
        idFuncionario = 0;
    }

    public Compra(Compra compra){ 
        idCompra = compra.idCompra;
        cookie = compra.cookie;
        total = compra.total;
        processado = false;
        idFuncionario = 0;
    };    

    public Compra(){ 
        idCompra = 0;
        cookie = 0;
        total = 0;
        processado = false;
        idFuncionario = 0;
    };
    
    public Compra(String inutilizar) throws Exception {
             Contador contador = new Contador();
             Contador_DAO contador_dao = new Contador_DAO();
             contador = contador_dao.get(contador);
             cookie = contador.getIdCookie();
             contador.setIdCookie(cookie+1);
             idCompra = contador.getIdCompra();
             contador.setIdCompra(idCompra+1);
             contador_dao.Alterar(contador);
    }
    
    public Compra(int cookie) throws Exception {
        this.cookie = cookie;
        Contador contador = new Contador();
        Contador_DAO contador_dao = new Contador_DAO();
        contador = contador_dao.get(contador);
        idCompra = contador.getIdCompra();
        contador.setIdCompra(idCompra+1);
        contador_dao.Alterar(contador);
    }
    
    public Compra(int idCompra, int cookie, double total, boolean processado, int idFuncionario) {
        this.idCompra = idCompra;
        this.cookie = cookie;
        this.total = total;
        this.processado = processado;
        this.idFuncionario = idFuncionario;
    }
    
    public int getIdCompra() {
        return idCompra;
    }
    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
    public int getCookie() {
        return cookie;
    }

    public void setCookie(int coockie) {
        this.cookie = coockie;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int id) {
        this.idFuncionario = id;
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double valor) {
        this.total = valor;
    }

    public boolean getProcessado() {
        return processado;
    }

    public void setProcessado(boolean valor) {
        this.processado = valor;
    }

}
