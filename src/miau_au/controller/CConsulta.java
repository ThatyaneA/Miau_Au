/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package miau_au.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import miau_au.DAO.DAOOng;
import miau_au.DAO.DAOTutor;
import miau_au.model.Ong;
import miau_au.model.Tutor;

/**
 *
 * @author thaty
 */
public class CConsulta {
    public void excluirOng(int id){
        Ong eO = new Ong();
        eO.excluirOng(id);
    }
    public void excluirTutor(int id){
        Tutor eT = new Tutor();
        eT.excluirPessoa(id);
    }
    public void editarOng(int idOng,String nome, String cnpj, String descricao, String email, String telefone){
        Ong editO = new Ong(nome,cnpj,descricao,email,telefone);
        editO.editarOng(idOng);
    }
    public void editarTutor(int idPessoa, String nome, String cpf, String email, String endereco, String telefone){
        Tutor editT = new Tutor(nome, cpf, email, endereco, telefone);
        editT.editarPessoa(idPessoa);
    }
    public Ong consultaOng(String cnpj) throws SQLException{
        DAOOng consultaOng = new DAOOng();
        Ong ongC= consultaOng.consultarOng(cnpj);
        return ongC;
    }
    public Tutor consultaTutor(String cpf) throws SQLException{
        DAOTutor consultaTutor = new DAOTutor();
        Tutor tC= consultaTutor.consultarTutor(cpf);
        return tC;
    }
    public ArrayList<Ong> listaOngs() throws SQLException{
        DAOOng listaOng = new DAOOng();
        ArrayList<Ong> lista = listaOng.listaOngs();
        return lista;
    }
        public ArrayList<Tutor> listaTutores() throws SQLException{
        DAOTutor listaTutor = new DAOTutor();
        ArrayList<Tutor> lista = listaTutor.listaTutores();
        return lista;
    }
}
