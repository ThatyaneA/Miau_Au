/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miau_au.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import miau_au.model.Login;

/**
 *
 * @author thaty
 */
public class DAOLogin {
    public int cadastrarUsuario(String usuario, String senha) throws SQLException{
        int id = 0;
        String sql = "INSERT INTO login (usuario, senha) VALUES ("
                     +"'"+ usuario +"', "
                     +"'"+ senha +"')";
        Conexao.executar(sql);
        try{
            String comando = "SELECT idLogin FROM login WHERE usuario ='"+usuario+"'";
            System.out.println(comando);
            ResultSet rs = Conexao.consultar(comando);
            while (rs.next()){
                id = rs.getInt("idLogin");
                System.out.println(id);
            }
        }catch(SQLException e){
            throw new SQLException(e);
        }
        return id;
    }
    
    public boolean autenticarUsuario(Login log) throws SQLException {
        boolean correcao=false;
        String usuario = log.getUsuario();
        String senha = log.getSenha();
        String sql = "SELECT * FROM login WHERE usuario='" + usuario + "'";
        
        try
        {
            ResultSet rs = Conexao.consultar(sql);
            while (rs.next()){
                String user = rs.getString("usuario");
                String password = rs.getString("senha");
                if(usuario.equals(user) && (senha.equals(password))){
                    correcao= true;
                }
            }
        }
        catch(SQLException se)
        {
            throw new SQLException(".DAOLogin " + se.getMessage());
        }
        return correcao;
    }
}
