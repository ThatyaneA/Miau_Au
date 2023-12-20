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
public class DAOLogin {
    public int cadastrarUsuario(String usuario, String senha) throws SQLException{
        int id = 0;
        String sql = "INSERT INTO login (usuario, senha) VALUES ("
                     +"'"+ usuario +"', "
                     +"'"+ senha +")";
        Conexao.executar(sql);
        try{
            String comando = "'SELECT idLogin FROM login WHERE usuario ="+usuario+"'";
            ResultSet rs = Conexao.consultar(comando);
            id = rs.getInt("idLogin");
        }catch(SQLException e){
            throw new SQLException(e);
        }
        return id;
    }
}
