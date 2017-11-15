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

public class Cliente_DAO {

    public void Inserir(Cliente cliente) throws Exception {
        Conexao conexao = new Conexao();
        try {
//            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO cliente VALUES (?,marco_bonetti,Marco,Rua fl,Bairro,Cidade,234567,RJ,Perto,843729,47392834,238928,92839482,27349823,Visa,?");
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO CLIENTE VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            sql.setInt(1, cliente.getIdCliente());
            sql.setString(2, cliente.getEmail());
            sql.setString(3, cliente.getNome());
            sql.setString(4, cliente.getEndereco());
            sql.setString(5, cliente.getBairro());
            sql.setString(6, cliente.getCidade());
            sql.setString(7, cliente.getCep());
            sql.setString(8, cliente.getEstado());
            sql.setString(9, cliente.getReferencias());
            sql.setString(10,cliente.getCpf());
            sql.setString(11,cliente.getRi());
            sql.setString(12, cliente.getTelFixo());
            sql.setString(13, cliente.getCelular());
            sql.setString(14, cliente.getCartao());
            sql.setString(15, cliente.getBandeira());
            sql.setBoolean(16, false);
            sql.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Cliente get(Cliente cliente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM CLIENTE WHERE idCliente = 1 ");
//            sql.setString(1, cliente.getEmail());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    cliente.setIdCliente(resultado.getInt("idCliente"));
                    cliente.setEmail(resultado.getString("email"));
                    cliente.setNome(resultado.getString("nome"));
                    cliente.setEndereco(resultado.getString("endereco"));
                    cliente.setBairro(resultado.getString("bairro"));
                    cliente.setCidade(resultado.getString("cidade"));
                    cliente.setCep(resultado.getString("cep"));
                    cliente.setEstado(resultado.getString("estado"));
                    cliente.setReferencias(resultado.getString("referencias"));
                    cliente.setCpf(resultado.getString("cpf"));
                    cliente.setRi(resultado.getString("ri"));
                    cliente.setTelFixo(resultado.getString("telFixo"));
                    cliente.setCelular(resultado.getString("celular"));
                    cliente.setCartao(resultado.getString("cartao"));
                    cliente.setBandeira(resultado.getString("bandeira"));
                    cliente.setAdmin(false);
                }
            }
            return cliente;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

}
