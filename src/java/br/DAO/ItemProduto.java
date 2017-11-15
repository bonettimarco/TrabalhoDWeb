package br.DAO;

public class ItemProduto {

    private int idPedido;
    private int idProduto;
    private String nome;
    private String descricao;
    private double valor;
    private int quantidade;
    
    public ItemProduto(){
    }
    
    public ItemProduto(int idPedido, int idProduto, String nome, String descricao, double valor, int quantidade){
            
    this.idPedido = idPedido;
    this.idProduto = idProduto;
    this.nome = nome;
    this.descricao = descricao;
    this.valor = valor;
    this.quantidade = quantidade;
    }
 
    public int getIdPedido(){
        return idPedido;
    }

    public void setIdPedido (int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
