/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miau_au.model;


import java.sql.SQLException;
import miau_au.DAO.DAOPessoa;
import miau_au.DAO.DAOTutor;
/**
 *
 * @author thaty
 */
public class Tutor extends Pessoa {
    private String descricao;
    //adicionar email ao tutor(pessoa). Arrumar ordem

    public Tutor(){
        
    }
    
    public Tutor(String descricao, String nome, String cpf, String email, String endereco, String telefone, String cep, Login login) {
        super(nome, cpf, email, endereco, telefone, cep, login);
        this.descricao = descricao;
    }
    
    public Tutor(String nome, String cpf, String email, String endereco, String telefone, String cep) {
        super(nome, cpf, email, endereco, telefone, cep);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    //método para criar nova pessoa no banco de dados
    @Override
    public void cadastrarPessoa() throws SQLException{
        String nomeP = this.getNome();
        String cpfP = this.getCpf();
        String emailP = this.getEmail();
        String enderecoP = this.getDescricao();
        String telefoneP = this.getTelefone();
        int loginP = this.getLogin().getIdLogin();
        DAOPessoa criaPessoa= new DAOPessoa();
        int id = criaPessoa.cadastrarPessoa(nomeP, cpfP, emailP, enderecoP, telefoneP, loginP);
        this.setIdPessoa(id);
        String descricaoT = this.getDescricao();
        DAOTutor criaTutor = new DAOTutor();
        criaTutor.cadastrarPessoa(descricaoT, id);
    }
    
    @Override
    public void editarPessoa(int idPessoa){
        String nomeP= this.getNome();
        String cpfP= this.getCpf();
        String emailP= this.getEmail();
        String enderecoP= this.getEndereco();
        String telefoneP= this.getTelefone();
        this.setIdPessoa(idPessoa);
        DAOPessoa editPessoa = new DAOPessoa();
        editPessoa.editarPessoa(idPessoa, nomeP, cpfP, emailP, enderecoP, telefoneP);
        String descricaoP= this.getDescricao();
        DAOTutor editTutor = new DAOTutor();
        editTutor.editarPessoa(idPessoa, descricaoP);
    }   
    
    @Override
    public void excluirPessoa(int idPessoa){
        DAOPessoa excluiP = new DAOPessoa();
        excluiP.excluirPessoa(idPessoa);
        DAOTutor excluiT = new DAOTutor();
        excluiT.excluirTutor(idPessoa);
    }    
}
