package br.DAO;

public class Produto {

    private int idProduto;
    private int idCategoria;
    private String nome;
    private String descricao;
	private double valor;

    public Produto(int idProduto, int idCategoria, String nome, String descricao, double valor) {
        this.idProduto = idProduto;
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Produto() {
    }

    public Produto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int id) {
        this.idCategoria = id;
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

}
