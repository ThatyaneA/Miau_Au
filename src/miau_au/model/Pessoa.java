/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miau_au.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import miau_au.DAO.Conexao;

/**
 *
 * @author thaty
 */
public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private Login login;
    private int idPessoa;

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
    
    public Pessoa(String nome,String cpf,String endereco,String telefone, Login login){
        this.nome=nome;
        this.cpf=cpf;
        this.endereco=endereco;
        this.telefone=telefone;
        this.login=login;
    }
    
    public Pessoa(String nome,String cpf,String endereco,String telefone){
        this.nome=nome;
        this.cpf=cpf;
        this.endereco=endereco;
        this.telefone=telefone;
    }
    
    public void cadastrarPessoa() throws SQLException{
        String sql = "INSERT INTO pessoa (nome,cpf,endereco,telefone) VALUES ("
            +"'"+ this.getNome() +"', "
            +"'"+ this.getCpf() +"', "
            +"'"+ this.getEndereco() +"', "
            +"'"+ this.getTelefone() +"', "
            +"'"+ this.getLogin().getIdLogin()+")";
        Conexao.executar(sql);
        try{
            String comando = "'SELECT idpessoa FROM pessoa WHERE cpf ="+this.getCpf()+"'";
            ResultSet rs = Conexao.consultar(comando);
            this.setIdPessoa(rs.getInt("idpessoa"));
        }catch(SQLException e){
            throw new SQLException(e);
        }
    }
    
    public void editarPessoa(int idPessoa){
        String sql = "UPDATE pessoa SET "
            +"nome = '"+ this.getNome()+ "', "
            +"cpf = '"+ this.getCpf()+ "', "
            +"endereco = "+ this.getEndereco()+ "', "
            +"telefone = "+ this.getTelefone()+ "', "
            +"WHERE idpessoa = "+ this.getIdPessoa();
        Conexao.executar(sql);
        this.setIdPessoa(idPessoa);
    }
    
    public void excluirPessoa(int idPessoa){
        String sql = "DELETE FROM pessoa WHERE idPessoa = "+ idPessoa;
        Conexao.executar(sql);
    }
}
