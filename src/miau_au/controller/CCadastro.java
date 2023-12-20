/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miau_au.controller;

import java.sql.SQLException;
import miau_au.model.Login;
import miau_au.model.Ong;
import miau_au.model.Tutor;

/**
 *
 * @author thaty
 */
public class CCadastro {

    public void CadastraOng(String usuario, String senha, String nome, String cnpj, String email, String telefone, String descricao)throws SQLException{
        Login loginOng = new Login(usuario,senha);
        loginOng.cadastrarUsuario();
        Ong criaOng = new Ong(nome,cnpj,email,telefone, descricao,loginOng);
        criaOng.cadastrarOng();
    }
    public  void CadastraTutor(String usuario, String senha, String nome, String cpf, String email, String telefone,String endereco, String cep,String descricao)throws SQLException{
        Login loginTutor = new Login(usuario,senha);
        loginTutor.cadastrarUsuario();
        Tutor criaTutor = new Tutor(descricao, nome, cpf, email, endereco, telefone, loginTutor);
        criaTutor.cadastrarPessoa();
    } 
}