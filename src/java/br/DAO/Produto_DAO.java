/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Produto_DAO {

    public void Inserir(Produto produto) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO PRODUTO (idProduto, idCategoria, nome, descricao, valor) VALUES (?,?,?,?,?)");
            sql.setInt(1, produto.getIdProduto());
            sql.setInt(2, produto.getIdCategoria());
            sql.setString(3, produto.getNome());
            sql.setString(4, produto.getDescricao());
            sql.setDouble(5, produto.getValor());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Produto get(Produto produto) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM PRODUTO WHERE IDPRODUTO = ? ");
            sql.setInt(1, produto.getIdProduto());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                        produto.setIdProduto(Integer.parseInt(resultado.getString("idProduto")));
                        produto.setIdCategoria(Integer.parseInt(resultado.getString("idCategoria")));
        		produto.setNome(resultado.getString("nome"));
			produto.setDescricao(resultado.getString("descricao"));
			produto.setValor(Double.parseDouble(resultado.getString("valor")));
                }
            }
            return produto;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Produto produto) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE PRODUTO SET idCategoria = ?, nome = ?, descricao = ?, valor = ?  WHERE IDPRODUTO = ? ");
            sql.setInt(1, produto.getIdCategoria());
            sql.setString(2, produto.getNome());
            sql.setString(3, produto.getDescricao());
            sql.setDouble(4, produto.getValor());
            sql.setDouble(5, produto.getIdProduto());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void ExcluirProduto(Produto produto) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM PRODUTO WHERE IDPRODUTO = ? ");
            sql.setInt(1, produto.getIdProduto());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

     public ArrayList<Produto> Listar() {
        ArrayList<Produto> meusProdutos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM PRODUTO";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Produto produto;
                    produto = new Produto(Integer.parseInt(resultado.getString("idProduto")),
							Integer.parseInt(resultado.getString("idCategoria")),
							resultado.getString("NOME"),
							resultado.getString("DESCRICAO"),
							Double.parseDouble(resultado.getString("VALOR")));
                    meusProdutos.add(produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;

    }

     
    public ArrayList<Produto> Listar(int[] codigos) {
        ArrayList<Produto> meusProdutos = new ArrayList();
        int indice;
        Conexao conexao = new Conexao();
        try {
            for (int i=0;i<codigos.length;i++){
                PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM PRODUTO WHERE IdProduto=?");
                sql.setInt(1, codigos[i]);
                ResultSet resultado = sql.executeQuery();
                if (resultado != null) {
                    while (resultado.next()) {
                        Produto produto;
                        produto = new Produto(Integer.parseInt(resultado.getString("idProduto")),
                                                            Integer.parseInt(resultado.getString("idCategoria")),
                                                            resultado.getString("NOME"),
                                                            resultado.getString("DESCRICAO"),
                                                            Double.parseDouble(resultado.getString("VALOR")));
                        meusProdutos.add(produto);
                }
            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;

    }
 
     
    public ArrayList<Produto> Listar(int codigo) {
        ArrayList<Produto> meusProdutos = new ArrayList<Produto>();
        int indice;
        Conexao conexao = new Conexao();
        try {
                PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM PRODUTO WHERE IdCategoria=?");
                sql.setInt(1, codigo);
                ResultSet resultado = sql.executeQuery();
                if (resultado != null) {
                    while (resultado.next()) {
                        Produto produto;
                        produto = new Produto(Integer.parseInt(resultado.getString("idProduto")),
                                                            Integer.parseInt(resultado.getString("idCategoria")),
                                                            resultado.getString("NOME"),
                                                            resultado.getString("DESCRICAO"),
                                                            Double.parseDouble(resultado.getString("VALOR")));
                        meusProdutos.add(produto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;

    }
 
     //funcao para listar os produtos constantes em um pedido
    public ArrayList<Produto> Listar(String idPedido) {
        ArrayList<Produto> meusProdutos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
                PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM PRODUTO P, ITEM I WHERE "
                        + "I.idPedido=? AND P.IdProduto=I.idProduto=P.idProduto");
                sql.setString(1, idPedido);
                ResultSet resultado = sql.executeQuery();
                if (resultado != null) {
                    while (resultado.next()) {
                        Produto produto;
                        produto = new Produto(Integer.parseInt(resultado.getString("idProduto")),
                                                            Integer.parseInt(resultado.getString("idCategoria")),
                                                            resultado.getString("NOME"),
                                                            resultado.getString("DESCRICAO"),
                                                            Double.parseDouble(resultado.getString("VALOR")));
                        meusProdutos.add(produto);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;

    }
    
}
