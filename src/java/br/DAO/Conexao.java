/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//CREATE TABLE CONTATO (
//    id INT not null primary key
//        GENERATED ALWAYS AS IDENTITY
//        (START WITH 1, INCREMENT BY 1), 
//    nome varchar(20),
//    idade integer
//
//);
public class Conexao {

//    private String DRIVE = "rg.apache.derby.jdbc.ClientDriver";
//    private String URL = "jdbc:derby://localhost:1527/alomundodb";
//    private String user = "usuario";
//    private String password = "12345";
    private Connection conexao;

    public Conexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");//load driver
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/sitevendas", "root", "Mcluhan_01");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Nao foi possivel efetuar uma conexao com o BD!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Nao foi possivel encontrar a classe referente! Verifique o driver!");
        }
    }
    
    public Connection getConexao(){
        return this.conexao;
    }
    
    public void closeConexao(){
        try {
            this.conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

 
}
