/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miau_au.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import miau_au.model.Tutor;

/**
 *
 * @author thaty
 */
public class DAOTutor {
    
    public void cadastrarPessoa(String descricao, int pessoa){
        String sql = "INSERT INTO tutor (descricao, pessoa) VALUES ("
        +"'"+ descricao +"', "
        + pessoa+")";
        Conexao.executar(sql);
    }
    
    public Tutor consultarTutor(String codigoCpf) throws SQLException{
        String nome = "";
        String cpf = "";
        String email = "";
        String endereco = "";
        String telefone = "";
        int idPessoa =0;
        Tutor tutor = new Tutor (nome,cpf,email,endereco,telefone);
        try{
            String sql = "SELECT idPessoa, nome, cpf, email, endereco, telefone FROM pessoa WHERE cpf='"+codigoCpf+"'";
            ResultSet rs = Conexao.consultar(sql);
            while (rs.next()){
                tutor.setNome(rs.getString("nome"));
                tutor.setCpf(rs.getString("cpf"));
                tutor.setEmail(rs.getString("email"));
                tutor.setEndereco(rs.getString("endereco"));
                tutor.setTelefone(rs.getString("telefone"));
                tutor.setIdPessoa(rs.getInt("idPessoa"));
                String consultaFilha = "SELECT descricao WHERE pessoa="+idPessoa;
                ResultSet resultadoFilho = Conexao.consultar(consultaFilha);
                while (resultadoFilho.next()){
                    tutor.setDescricao(resultadoFilho.getString("descricao"));
                }
            }
        }catch(SQLException e){
            throw new SQLException(e);
            
        }
        return tutor;
    }
    
    public ArrayList<Tutor> listaTutores() throws SQLException{
        ArrayList<Tutor> lista = new ArrayList<> ();
            String sql = "SELECT idPessoa, nome, cpf, email, endereco, telefone FROM pessoa WHERE ORDER BY nome";
            ResultSet rs = Conexao.consultar(sql);
        if (rs != null){
            try{
                while (rs.next()){
                    String nome = rs.getString("nome");
                    String cpf = rs.getString("cpf");
                    String email = rs.getString("email");
                    String endereco = rs.getString("endereco");
                    String telefone = rs.getString("telefone");
                    int idPessoa =rs.getInt("idPessoa");
                    Tutor tutor = new Tutor (nome,cpf, email, endereco, telefone);
                    tutor.setIdPessoa(idPessoa);
                    String consultaFilha = "SELECT descricao WHERE pessoa="+idPessoa;
                    ResultSet resultadoFilho = Conexao.consultar(consultaFilha);
                    while (resultadoFilho.next()){
                        tutor.setDescricao(resultadoFilho.getString("descricao"));
                    }
                    lista.add(tutor);
                }
            }catch(SQLException e){
                throw new SQLException(e);
            }
        }
        return lista;
    }
    
    public void editarPessoa(int idPessoa, String descricao){
        String sql = "UPDATE tutor SET "
            +"descricao = '"+ descricao+ "', "
            +"WHERE pessoa = "+ idPessoa;
        Conexao.executar(sql);     
    }
    
    public void excluirTutor(int idPessoa){
        String sql = "DELETE FROM tutor WHERE pessoa = "+ idPessoa;
        Conexao.executar(sql);
    } 
}
