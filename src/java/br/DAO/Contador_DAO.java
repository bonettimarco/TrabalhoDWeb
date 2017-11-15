/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Contador_DAO {

    /**
     *
     * @param opcao
     * @return
     * @throws Exception
     */
    
    public Contador get(Contador contador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM CONTADOR WHERE ID = 1 ");
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                        contador.setIdAdmin(Integer.parseInt(resultado.getString("idProduto")));
                        contador.setIdCategoria(Integer.parseInt(resultado.getString("idCategoria")));
                        contador.setIdProduto(Integer.parseInt(resultado.getString("idProduto")));
                        contador.setIdCompra(Integer.parseInt(resultado.getString("idCompra")));
                        contador.setIdCookie(Integer.parseInt(resultado.getString("idCookie")));
                        contador.setIdCliente(Integer.parseInt(resultado.getString("idCliente")));
                }
            }
            return contador;
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Contador contador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE CONTADOR SET idAdmin=?, idCategoria=?, idProduto=?, idCompra=?, idCookie=?, idCliente=?");
            sql.setInt(1, contador.getIdAdmin());
            sql.setInt(2, contador.getIdCategoria());
            sql.setInt(3, contador.getIdProduto());
            sql.setInt(4, contador.getIdCompra());
            sql.setInt(5, contador.getIdCookie());
            sql.setInt(6, contador.getIdCliente());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
}

