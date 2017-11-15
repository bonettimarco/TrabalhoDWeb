package br.DAO;

public class Item {

    private int idPedido;
    private int idProduto;
    private int quantidade;
    private double total;

    public Item() {
    }

    public Item(int idPedido, int idProduto){
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.quantidade = 1;
        this.total = 0;
    }

    public Item(int idPedido, int idProduto, int quantidade) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.total = 0;
    }
    
    public Item(int idPedido, int idProduto, int quantidade, double total) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.total = total;
    }
    	
    public int getIdPedido() {
        return idPedido;
    }
    
    public void setIdPedido(int idPedido){
        this.idPedido=idPedido;
    }

    public int getIdProduto() {
        return idProduto;
    }
    
    public void setIdProduto(int idProduto){
        this.idProduto=idProduto;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade=quantidade;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
    
    public double getTotal() {
        return total;
    }
}
