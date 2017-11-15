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

public class Compra_DAO {

    public void Inserir(Compra compra) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO COMPRA VALUES (?,?,?,?,?)");
            sql.setInt(1, compra.getIdCompra());
            sql.setInt(2, compra.getCookie());
            sql.setDouble(3, compra.getTotal());
            sql.setBoolean(4, compra.getProcessado());
            sql.setDouble(5, compra.getIdFuncionario());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Compra get(Compra compra) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM COMPRA WHERE idCompra = ? ");
            sql.setInt(1, compra.getIdCompra());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                        compra.setIdCompra(Integer.parseInt(resultado.getString("idCompra")));
                        compra.setCookie(Integer.parseInt(resultado.getString("cookie")));
                        compra.setTotal(Double.parseDouble(resultado.getString("TOTAL")));
        		compra.setProcessado(Boolean.getBoolean(resultado.getString("processado")));
                        compra.setIdFuncionario(Integer.parseInt(resultado.getString("IDFUNCIONARIO")));
				}
            }
            return compra;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
  public void Processar(Compra compra) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE COMPRA SET processado = true, idFuncionario = ?  WHERE ID = ? ");
            sql.setInt(1, compra.getIdFuncionario());
            sql.setInt(2, compra.getIdCompra());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
  
  
    public ArrayList<Compra> Listar() {
        ArrayList<Compra> compras = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM COMPRA";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Compra compra;
                    compra = new Compra(Integer.parseInt(resultado.getString("idCompra")),
							Integer.parseInt(resultado.getString("cookie")),
							Double.parseDouble(resultado.getString("TOTAL")),
							Boolean.parseBoolean(resultado.getString("PROCESSADO")),
							Integer.parseInt(resultado.getString("IDFUNCIONARIO")));
                    compras.add(compra);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return compras;

    }

}
