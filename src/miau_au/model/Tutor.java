/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miau_au.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import miau_au.DAO.Conexao;
/**
 *
 * @author thaty
 */
public class Tutor extends Pessoa {
    private String descricao;
    //adicionar email ao tutor(pessoa). Arrumar ordem

    public Tutor(String descricao, String nome, String cpf, String endereco, String telefone, Login login) {
        super(nome, cpf, endereco, telefone, login);
        this.descricao = descricao;
    }
    
    public Tutor(String nome, String cpf, String endereco, String telefone) {
        super(nome, cpf, endereco, telefone);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    //método para criar nova pessoa no banco de dados
    @Override
    public void cadastrarPessoa(){
        String sql = "INSERT INTO tutor (descricao, pessoa) VALUES ("
        +"'"+ this.getDescricao() +"', "
        +"'"+ this.getIdPessoa()+")";
        Conexao.executar(sql);
    }
    
    public static Tutor consultarTutor(String codigoCpf) throws SQLException{
        try{
            String sql = "SELECT idPessoa, nome, cpf, endereco, telefone FROM pessoa WHERE cpf="+codigoCpf;
            ResultSet rs = Conexao.consultar(sql);
            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            String endereco = rs.getString("endereco");
            String telefone = rs.getString("telefone");
            int idPessoa =rs.getInt("idPessoa");
            Tutor tutor = new Tutor (nome,cpf, endereco, telefone);
            tutor.setIdPessoa(idPessoa);
            String consultaFilha = "SELECT descricao WHERE pessoa="+idPessoa;
            ResultSet resultadoFilho = Conexao.consultar(consultaFilha);
            tutor.setDescricao(resultadoFilho.getString("descricao"));
            return tutor;
        }catch(SQLException e){
            throw new SQLException(e);
        }
    }
    
    public static ArrayList<Tutor> listaTutores() throws SQLException{
        ArrayList<Tutor> lista = new ArrayList<> ();
            String sql = "SELECT idPessoa, nome, cpf, endereco, telefone FROM pessoa WHERE ORDER BY nome";
            ResultSet rs = Conexao.consultar(sql);
        if (rs != null){
            try{
                while (rs.next()){
                    String nome = rs.getString("nome");
                    String cpf = rs.getString("cpf");
                    String endereco = rs.getString("endereco");
                    String telefone = rs.getString("telefone");
                    int idPessoa =rs.getInt("idPessoa");
                    Tutor tutor = new Tutor (nome,cpf, endereco, telefone);
                    tutor.setIdPessoa(idPessoa);
                    String consultaFilha = "SELECT descricao WHERE pessoa="+idPessoa;
                    ResultSet resultadoFilho = Conexao.consultar(consultaFilha);
                    tutor.setDescricao(resultadoFilho.getString("descricao"));
                    lista.add(tutor);
                }
            }catch(SQLException e){
                throw new SQLException(e);
            }
        }
        return lista;
    } 
    
    @Override
    public void editarPessoa(int idPessoa){
        super.editarPessoa(idPessoa);
        String sql = "UPDATE tutor SET "
            +"descricao = "+ this.getDescricao()+ "', "
            +"WHERE pessoa = "+ idPessoa;
        Conexao.executar(sql);     
    }
    
    @Override
    public void excluirPessoa(int idPessoa){
        String sql = "DELETE FROM tutor WHERE pessoa = "+ idPessoa;
        Conexao.executar(sql);
    }        
}
