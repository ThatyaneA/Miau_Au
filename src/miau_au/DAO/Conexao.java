/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miau_au.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author thaty
 */
public class Conexao {
    
    private static final String URL = "jdbc:mysql://localhost:3306/pi?zeroDateTimeBehavior=convertToNull";
    private static final String USER = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String SENHA = "1995";
    
    public static void executar (String query){
        try{
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USER, SENHA);
            PreparedStatement st = conn.prepareStatement(query);
            st.execute();
            st.close();
            conn.close();
        }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public static ResultSet consultar (String query){
        try{
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL,USER,SENHA);
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            //conn.close();
            return rs;
        }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
    
}
