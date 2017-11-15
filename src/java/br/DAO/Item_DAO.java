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

public class Item_DAO {

    public void Inserir(Item item) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO ITEM VALUES (?,?,1, ?)");
            sql.setInt(1, item.getIdPedido());
            sql.setInt(2, item.getIdProduto());
            sql.setDouble(3, item.getTotal());
            sql.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Item get(Item item) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Item WHERE idPedido = ? AND idProduto = ?");
            sql.setInt(1, item.getIdPedido());
            sql.setInt(2, item.getIdProduto());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                        item.setIdPedido(Integer.parseInt(resultado.getString("idPedido")));
                        item.setIdProduto(Integer.parseInt(resultado.getString("idProduto")));
                        item.setQuantidade(Integer.parseInt(resultado.getString("quantidade")));
                        item.setTotal(Double.parseDouble(resultado.getString("precoSubTotal")));
                }
            }
            return item;
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Item item) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE Item SET idPedido = ?, idProduto = ?, quantidade = ?, precoSubTotal = ?  WHERE IDPedido = ? AND IDPRODUTO = ? ");
            sql.setInt(1, item.getIdPedido());
            sql.setInt(2, item.getIdProduto());
            sql.setInt(3, item.getQuantidade());
            sql.setDouble(4, item.getTotal());
            sql.setInt(5, item.getIdPedido());
            sql.setInt(6, item.getIdProduto());
            sql.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void ExcluirItem(Item item) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM Item WHERE idPedido = ? AND IDPRODUTO = ? ");
            sql.setInt(1, item.getIdPedido());
            sql.setInt(2, item.getIdProduto());
            sql.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

     public ArrayList<Item> Listar() {
        ArrayList<Item> meusItens = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM Item";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Item item;
                    item = new Item(Integer.parseInt(resultado.getString("idPedido")),
							Integer.parseInt(resultado.getString("idProduto")),
							Integer.parseInt(resultado.getString("quantidade")),
                                                        Double.parseDouble(resultado.getString("precoSubTotal")));
                    meusItens.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusItens;

    }

     
    public ArrayList<Item> Listar(int idPedido, int idProduto) {
        
        ArrayList<Item> meusItens = new ArrayList();
        Conexao conexao = new Conexao();
        try {
                PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM ITEM WHERE idPedido = ? AND IdProduto=?");
                sql.setInt(1, idPedido);
                sql.setInt(2, idProduto);
                ResultSet resultado = sql.executeQuery();
                if (resultado != null) {
                    Item item;
                    while (resultado.next()) {
                        item = new Item(Integer.parseInt(resultado.getString("idPedido")),Integer.parseInt(resultado.getString("idProduto")));
                        meusItens.add(item);
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusItens;
    }

     public ArrayList<ItemProduto> Listar(int idPedido) {
        
        ArrayList<ItemProduto> meusItens = new ArrayList<ItemProduto>();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT p.idProduto idProduto, p.nome nome, p.descricao descricao, i.quantidade quantidade, p.valor valor FROM item i INNER JOIN produto p ON p.idProduto=i.idProduto where idPedido =?";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            preparedStatement.setInt(1, idPedido);
            ResultSet resultado = preparedStatement.executeQuery();

                     if (resultado != null) {
                        while (resultado.next()) {
                            ItemProduto itemProduto = new ItemProduto();
                            itemProduto.setIdPedido(idPedido);
							itemProduto.setIdProduto(resultado.getInt("idProduto"));
                            itemProduto.setNome(resultado.getString("nome"));
                            itemProduto.setDescricao(resultado.getString("descricao"));
                            itemProduto.setQuantidade(resultado.getInt("quantidade"));
                            itemProduto.setValor((Double) (resultado.getDouble("valor")));
                            meusItens.add(itemProduto);
                        }
                                     
                    }
         //              itemProduto.setValor(resultado.getDouble("valor"));
        
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }

       
       return meusItens;
    }

     public boolean checa(Item item) {
        Conexao conexao = new Conexao();
        boolean naoEncontrou = true;
        try {
                PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Item  WHERE idPedido = ? AND idProduto = ?");
                sql.setInt(1, item.getIdPedido());
                sql.setInt(2, item.getIdProduto());
                ResultSet resultado = sql.executeQuery();
                if (resultado != null) { 
                    naoEncontrou = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return naoEncontrou;
     }


     public boolean checa(int idPedido) {
        Conexao conexao = new Conexao();
        boolean naoEncontrou = false;
        try {
                PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Item  WHERE idPedido = ?");
                sql.setInt(1, idPedido);
                ResultSet resultado = sql.executeQuery();
                if (resultado != null) { 
                    naoEncontrou = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return naoEncontrou;
     }
     
     
    public ArrayList<Item> Listar(int[] codigos) {
        ArrayList<Item> meusItens = new ArrayList();
        Conexao conexao = new Conexao();

        try {
            for (int i=0; i<codigos.length; i++){
                PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Item  WHERE idProduto = ?");
                sql.setInt(1, codigos[i]);
                ResultSet resultado = sql.executeQuery();
                if (resultado != null) {
                    while (resultado.next()) {
                        Item item;
                        item = new Item(Integer.parseInt(resultado.getString("idPedido")),
                                                            Integer.parseInt(resultado.getString("idProduto")),
                                                            Integer.parseInt(resultado.getString("quantidade")),
                                                            Double.parseDouble(resultado.getString("precoSubTotal")));
                        meusItens.add(item);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusItens;

    }
 
}
