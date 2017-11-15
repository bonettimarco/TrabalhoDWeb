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

public class Categoria_DAO {

    public void Inserir(Categoria categoria) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO CATEGORIA (id, descricao) VALUES (?,?)");
            sql.setInt(1, categoria.getId());
            sql.setString(2, categoria.getDescricao());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Categoria get(Categoria categoria) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM CATEGORIA WHERE ID = ? ");
            sql.setInt(1, categoria.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                        categoria.setId(Integer.parseInt(resultado.getString("ID")));
        		categoria.setDescricao(resultado.getString("DESCRICAO"));
		 }
            }
            return categoria;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Categoria categoria) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE CATEGORIA SET id = ?, descricao = ? WHERE ID = ? ");
            sql.setInt(1, categoria.getId());
            sql.setString(2, categoria.getDescricao());
            sql.setDouble(3, categoria.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Categoria categoria) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM CATEGORIA WHERE ID = ? ");
            sql.setInt(1, categoria.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Categoria> Listar() {
        ArrayList<Categoria> categorias = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM CATEGORIA";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Categoria categoria;
                    categoria = new Categoria(Integer.parseInt(resultado.getString("ID")),
							resultado.getString("DESCRICAO"));
                    categorias.add(categoria);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return categorias;

    }

}
