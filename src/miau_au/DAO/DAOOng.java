/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miau_au.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import miau_au.model.Ong;

/**
 *
 * @author thaty
 */
public class DAOOng {
    public void cadastrarOng(String nome, String cnpj, String descricao, String email, String telefone, int login){
        String sql = "INSERT INTO ong (nome,cnpj,descricao,email,telefone,login) VALUES ("
        +"'"+ nome +"', "
        +"'"+ cnpj +"', "
        +"'"+ descricao  +"', "
        +"'"+ email +"', "
        +"'"+ telefone +"', "
        +"'"+ login +")";
        Conexao.executar(sql);        
    }
    
    /*public static Ong consultarOng(String codigoCnpj) throws SQLException{
        try{
            String sql = "SELECT idOng, nome, cnpj, descricao, email, telefone FROM ong WHERE cpf="+codigoCnpj;
            ResultSet rs = Conexao.consultar(sql);
            String nome = rs.getString("nome");
            String cnpj = rs.getString("cnpj");
            String descricao = rs.getString("descricao");
            String email = rs.getString("email");
            String telefone = rs.getString("telefone");
            Ong ong = new Ong (nome, cnpj, descricao, email, telefone);
            return ong;
        }catch(SQLException e){
            throw new SQLException(e);
        }
    }
    
    public static ArrayList<Ong> listaOngs() throws SQLException{
        ArrayList<Ong> lista = new ArrayList<> ();
            String sql = "SELECT idOng, nome, cnpj, descricao, email, telefone FROM ong ORDER BY nome";
            ResultSet rs = Conexao.consultar(sql);
        if (rs != null){
            try{
                while (rs.next()){
                    String nome = rs.getString("nome");
                    String cnpj = rs.getString("cnpj");
                    String descricao = rs.getString("descricao");
                    String email = rs.getString("email");
                    String telefone = rs.getString("telefone");
                    Ong ong = new Ong (nome, cnpj, descricao, email, telefone);
                    lista.add(ong);
                }
            }catch(SQLException e){
                throw new SQLException(e);
            }
        }
        return lista;
    } 
    
    public void editarOng(int idOng){
        String sql = "UPDATE ong SET "
            +"nome = "+ this.getNome()+ "', "
            +"cnpj = "+ this.getCnpj()+ "', "
            +"descricao = "+ this.getDescricao()+ "', "
            +"email = "+ this.getEmail()+ "', "
            +"telefone = "+ this.getTelefone()+ "', "
            +"login = "+ this.getLogin().getIdLogin()+ "', "
            +"WHERE idOng = "+ idOng;
        Conexao.executar(sql);   
    }
    
    public void excluirOng(int idOng){
        String sql = "DELETE FROM ong WHERE idOng = "+ idOng;
        Conexao.executar(sql);
    }*/
}
