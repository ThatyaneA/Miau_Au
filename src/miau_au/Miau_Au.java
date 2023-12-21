/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package miau_au;

import javax.swing.JFrame;
import miau_au.view.Tela_Login;

/**
 *
 * @author thaty
 */
public class Miau_Au {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tela_Login TelaLog = new Tela_Login();
        TelaLog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        TelaLog.setVisible(true);
        TelaLog.setSize(661, 555);
    }
    
}
