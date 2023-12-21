/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miau_au.model;

import miau_au.DAO.DAOOng;

/**
 *
 * @author thaty
 */
public class Ong {
    private String nome;
    private String cnpj;
    private String descricao;
    private String email;
    private String telefone;
    private Login login;

    public Ong(){
        
    }
    
    public Ong(String nome, String cnpj, String descricao, String email, String telefone, Login login) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.email = email;
        this.telefone = telefone;
        this.login = login;
    }

    public Ong(String nome, String cnpj, String descricao, String email, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.descricao = descricao;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    
    public void cadastrarOng(){
        String nomeO = this.getNome();
        String cnpjO = this.getCnpj();
        String descricaoO = this.getDescricao();
        String emailO = this.getEmail();
        String telefoneO = this.getTelefone();
        int loginO = this.getLogin().getIdLogin();
        System.out.println(loginO);
        DAOOng criaOng = new DAOOng();
        criaOng.cadastrarOng(nomeO, cnpjO, descricaoO, emailO, telefoneO, loginO);
    }
    
    public void editarOng(int idOng){
        DAOOng editaOng = new DAOOng();
        String nomeO= this.getNome();
        String cnpjO= this.getCnpj();
        String descricaoO = this.getDescricao();
        String emailO = this.getEmail();
        String telefoneO = this.getTelefone();
        editaOng.editarOng(idOng, nomeO, cnpjO, descricaoO, emailO, telefoneO);
    }
    
    public void excluirOng(int idOng){
        DAOOng excluiO = new DAOOng();
        excluiO.excluirOng(idOng);
    }
}
