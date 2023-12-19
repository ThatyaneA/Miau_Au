package miau_au.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import miau_au.DAO.Conexao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thaty
 */
public class Login {
    private String usuario;
    private String senha;
    private int idLogin;
    
    public Login (String usuario, String senha){
        this.usuario=usuario;
        this.senha=senha;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }
    
    public void cadastrarUsuario() throws SQLException{
        String sql = "INSERT INTO login (usuario, senha) VALUES ("
                     +"'"+ this.getUsuario() +"', "
                     +"'"+ this.getSenha() +")";
        Conexao.executar(sql);
        try{
            String comando = "'SELECT idLogin FROM login WHERE usuario ="+this.getUsuario()+"'";
            ResultSet rs = Conexao.consultar(comando);
            this.setIdLogin(rs.getInt("idLogin"));
        }catch(SQLException e){
            throw new SQLException(e);
        }
    }
    
}
