/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miau_au.controller;

import java.sql.SQLException;
import miau_au.model.Login;

/**
 *
 * @author thaty
 */
public class CLogin {
    
    public boolean autenticarUsuario(String usuario, String senha) throws SQLException{
        Login log = new Login(usuario, senha);
        try
        {
            return log.autenticarUsuario();
        }
        catch(SQLException se)
        {
            throw new SQLException(".CLogin " + se.getMessage());
        }
    }
}

