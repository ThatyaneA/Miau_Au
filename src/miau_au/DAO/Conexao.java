/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miau_au.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author thaty
 */
public class Conexao {
    
    private static final String URL = "jdbc:mysql://localhost:3306/pi?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String SENHA = "Polly28.";
    
    
    public static void executar (String query){
        try{
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USER, SENHA);
            java.sql.Statement st = conn.createStatement();
            st.execute(query);
            conn.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public static ResultSet consultar (String query){
        try{
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL,USER,SENHA);
            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            //conn.close();
            return rs;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
}
