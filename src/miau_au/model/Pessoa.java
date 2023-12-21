/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miau_au.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import miau_au.DAO.Conexao;
import miau_au.DAO.DAOPessoa;

/**
 *
 * @author thaty
 */
public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String telefone;
    private Login login;
    private int idPessoa;

    public Pessoa(){
        
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public Pessoa(String nome,String cpf, String email, String endereco,String telefone, Login login){
        this.nome=nome;
        this.cpf=cpf;
        this.email=email;
        this.endereco=endereco;
        this.telefone=telefone;
        this.login=login;
    }
    
    public Pessoa(String nome,String cpf,String email, String endereco,String telefone){
        this.nome=nome;
        this.cpf=cpf;
        this.email=email;
        this.endereco=endereco;
        this.telefone=telefone;
    }
    
    public abstract void cadastrarPessoa() throws SQLException;
    
    
    public abstract void editarPessoa(int idPessoa);
    
    public abstract void excluirPessoa(int idPessoa);
}
