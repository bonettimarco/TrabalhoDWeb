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

public class Contato_DAO {

    public void Inserir(Contato contato) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO ADMINISTRADOR (id, email, senha, admin, session) VALUES (?,?,?,?,?)");
            sql.setInt(1, contato.getId());
            sql.setString(2, contato.getEmail());
            sql.setString(3, contato.getSenha());
            sql.setBoolean(4, true);
            sql.setInt(5, 0);
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Contato get(Contato contato) throws Exception {
        PreparedStatement sql;
        Conexao conexao = new Conexao();
        try {
        if(contato.getId()>0){
            sql = conexao.getConexao().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE id = ? ");
            sql.setInt(1, contato.getId());
        } else {
            sql = conexao.getConexao().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE email = ? ");
            sql.setString(1, contato.getEmail());
        }
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    contato.setEmail(resultado.getString("email"));
                    contato.setSenha(resultado.getString("senha"));
					contato.setAdmin(resultado.getBoolean("admin"));
					contato.setId(resultado.getInt("id"));
                }
            }
            return contato;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Contato contato) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE ADMINISTRADOR SET email = ?, senha = ?, admin = ?  WHERE ID = ? ");
            sql.setString(1, contato.getEmail());
            sql.setString(2, contato.getSenha());
            sql.setBoolean(3, contato.getAdmin());
            sql.setInt(4, contato.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Contato contato) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM ADMINISTRADOR WHERE ID = ? ");
            sql.setInt(1, contato.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Contato> Listar() {
        ArrayList<Contato> meusContatos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM ADMINISTRADOR";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Contato contato;
                    contato = new Contato(Integer.parseInt(resultado.getString("id")),
                            resultado.getString("email"),
                            resultado.getString("admin"));
                    meusContatos.add(contato);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusContatos;

    }

}
