/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miau_au.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author thaty
 */
public class DAOPessoa {
        public int cadastrarPessoa(String nome, String cpf, String email,String endereco, String telefone, int login) throws SQLException{
            int id = 0;
            String sql = "INSERT INTO pessoa (nome,cpf,email,endereco,telefone,login) VALUES ("
                +"'"+ nome +"', "
                +"'"+ cpf +"', "
                +"'"+ email +"', "
                +"'"+ endereco +"', "
                +"'"+ telefone +"', "
                + login+")";
            Conexao.executar(sql);
            try{
                String comando = "SELECT idpessoa FROM pessoa WHERE cpf ='"+cpf+"'";
                ResultSet rs = Conexao.consultar(comando);
                while (rs.next()){
                    id= rs.getInt("idpessoa");  
                }
            }catch(SQLException e){
                throw new SQLException(e);
            }
            return id;
        }
    
    public void editarPessoa(int idPessoa, String nome, String cpf, String email, String endereco, String telefone){
        String sql = "UPDATE pessoa SET "
            +"nome = '"+ nome+ "', "
            +"cpf = '"+ cpf+ "', "
            +"email= '"+ email+ "',"
            +"endereco = '"+ endereco+ "', "
            +"telefone = '"+ telefone+ "' "
            +"WHERE idpessoa = "+ idPessoa;
        Conexao.executar(sql);
    }
    
    public void excluirPessoa(int idPessoa){
        String sql = "DELETE FROM pessoa WHERE idPessoa = "+ idPessoa;
        Conexao.executar(sql);
    }
}
