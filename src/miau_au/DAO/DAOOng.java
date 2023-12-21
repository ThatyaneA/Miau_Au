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
        String sql = "INSERT INTO ong (nome, email, cnpj, telefone, descricao, login) VALUES ("
        +"'"+ nome +"', "
        +"'"+ email +"', "
        +"'"+ cnpj  +"', "
        +"'"+ telefone +"', "
        +"'"+ descricao +"',"
        + login +")";
        System.out.println(sql);
        Conexao.executar(sql);        
    }
    
    public Ong consultarOng(String codigoCnpj) throws SQLException{
        String nome = "";
        String cnpj = "";
        String descricao = "";
        String email = "";
        String telefone = "";
        Ong ong = new Ong (nome, cnpj, descricao, email, telefone);
        try{
            String sql = "SELECT idOng, nome, cnpj, descricao, email, telefone FROM ong WHERE cpf='"+codigoCnpj+"'";
            ResultSet rs = Conexao.consultar(sql);
            while (rs.next()){
            ong.setNome(rs.getString("nome"));
            ong.setCnpj(rs.getString("cnpj"));
            ong.setDescricao(rs.getString("descricao"));
            ong.setEmail(rs.getString("email"));
            ong.setTelefone(rs.getString("telefone"));
            }
        }catch(SQLException e){
            throw new SQLException(e);
        }
        return ong;
    }
    
    public ArrayList<Ong> listaOngs() throws SQLException{
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
    
    public void editarOng(int idOng,String nome,String cnpj,String descricao,String email,String telefone){
        String sql = "UPDATE ong SET "
            +"nome = '"+ nome + "', "
            +"cnpj = '"+ cnpj + "', "
            +"descricao = '"+ descricao + "', "
            +"email = '"+ email + "', "
            +"telefone = '"+ telefone + "', "
            +"WHERE idOng = "+ idOng;
        Conexao.executar(sql);   
    }
    
    public void excluirOng(int idOng){
        String sql = "DELETE FROM ong WHERE idOng = "+ idOng;
        Conexao.executar(sql);
    }
}
