package br.DAO;

public class Contador {

    private int idCliente;
    private int idAdmin;
    private int idCategoria;
    private int idProduto;
    private int idCompra;
    private int idCookie;
    private int id;

    public Contador() {
    }

    public void setIdCliente(int valor) {
        idCliente = valor;
    }
    	
      public void setIdAdmin(int valor) {
        idAdmin = valor;
    }

    public void setIdCategoria(int valor) {
        idCategoria = valor;
    }

    public void setIdProduto(int valor) {
        idProduto = valor;
    }

    public void setIdCompra(int valor) {
        idCompra = valor;
    }
    public void setIdCookie(int valor) {
        idCookie = valor;
    }
    
      public int getId() {
        return id;
    }

      public int getIdCliente() {
        return idCliente;
    }

      public int getIdAdmin() {
        return idAdmin;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getIdCompra() {
        return idCompra;
    }
    public int getIdCookie() {
        return idCookie;
    }
}
