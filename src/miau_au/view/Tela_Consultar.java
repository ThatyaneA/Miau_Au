/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package miau_au.view;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import miau_au.controller.CConsulta;
import miau_au.model.Ong;
import miau_au.model.Tutor;

/**
 *
 * @author USUARIO
 */
public class Tela_Consultar extends javax.swing.JFrame {
    private int idEdit;
    private boolean editar= false;
    private DefaultTableModel dtm;
    /**
     * Creates new form Tela_Consultar
     */
    public Tela_Consultar() {
        initComponents();
        criarTabela();
    }
    
     private void criarTabela(){
        dtm = new DefaultTableModel(
                new Object[][]{},
                new Object[]{"ID", "Nome", "CNPJ/CPF", "Telefone", "Email", "Descrição", "Endereço", "CEP"}
        );
        
        jTable.setModel(dtm);
    }
    
    private void limparTabela(){
        dtm.setRowCount(0);
    }
    
    private void consultarONG() {
        CConsulta cons = new CConsulta();
        try
        {
            Ong ong = cons.consultaOng(jtfCNPJ.getText());
            dtm.addRow(new String[] {
                String.valueOf(ong.getIdOng()),
                ong.getNome(),
                ong.getCnpj(),
                ong.getTelefone(),
                ong.getEmail(),
                ong.getDescricao(),
                "--", "--"
            });
            
            jTable.setModel(dtm);
        }
        catch(SQLException se)
        {
            JOptionPane.showMessageDialog(null, "Erro na consulta de ONG: " + se.getMessage());
        }
    }
    
    private void consultarTutor() {
        CConsulta cons = new CConsulta();
        try
        {
            Tutor tutor = cons.consultaTutor(jtfCPF.getText());
            dtm.addRow(new String[] {
                String.valueOf(tutor.getIdPessoa()),
                tutor.getNome(),
                tutor.getCpf(),
                tutor.getTelefone(),
                tutor.getEmail(),
                tutor.getDescricao(),
                tutor.getEndereco(),
                tutor.getCep()
            });
            
            jTable.setModel(dtm);
        }
        catch(SQLException se)
        {
            JOptionPane.showMessageDialog(null, "Erro na consulta de Tutor: " + se.getMessage());
        }
    }
    
    private void pesquisarONG() {
        CConsulta cons = new CConsulta();
        try
        {
            ArrayList<Ong> ongs = cons.listaOngs();
            for(Ong ong : ongs)
            {
                dtm.addRow(new String[] {
                    String.valueOf(ong.getIdOng()),
                    ong.getNome(),
                    ong.getCnpj(),
                    ong.getTelefone(),
                    ong.getEmail(),
                    ong.getDescricao(),
                    "--", "--"
                });
            }
            
            jTable.setModel(dtm);
        }
        catch(SQLException se)
        {
            JOptionPane.showMessageDialog(null, "Erro na pesquisa de ONG: " + se.getMessage());
        }
    }
    
    private void pesquisarTutor() {
        CConsulta cons = new CConsulta();
        try
        {
            ArrayList<Tutor> tutores = cons.listaTutores();
            for(Tutor tutor : tutores)
            {
                dtm.addRow(new String[] {
                    String.valueOf(tutor.getIdPessoa()),
                    tutor.getNome(),
                    tutor.getCpf(),
                    tutor.getTelefone(),
                    tutor.getEmail(),
                    tutor.getDescricao(),
                    tutor.getEndereco(),
                    tutor.getCep()
                });
            }
            
            jTable.setModel(dtm);
        }
        catch(SQLException se)
        {
            JOptionPane.showMessageDialog(null, "Erro na pesquisa de Tutor: " + se.getMessage());
        }
    }
    
    private void editarONG() {
        idEdit = Integer.parseInt(txtId.getText());
        editar=true;
        Tela_Cadastro TelaCadas = new Tela_Cadastro(editar, idEdit);
        TelaCadas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        TelaCadas.setVisible(true);
        TelaCadas.setSize(688, 588);
    }
    
    private void editarTutor() {
        idEdit = Integer.parseInt(txtId.getText());
        editar=true;
        Tela_Cadastro TelaCadas = new Tela_Cadastro(editar, idEdit);
        TelaCadas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        TelaCadas.setVisible(true);
        TelaCadas.setSize(691, 600);
    }
    
    private void excluirONG(){
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir essa ONG?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if(opcao == JOptionPane.YES_OPTION)
        {
            CConsulta ong= new CConsulta();
            idExclui = Integer.parseInt(txtId.getText());
            ong.excluirOng(idExclui);
            JOptionPane.showMessageDialog(null, "Excluído com Sucesso");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada");
        }
    }
    
    private void excluirTutor() {
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse Tutor?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if(opcao == JOptionPane.YES_OPTION)
        {
            CConsulta tutor = new CConsulta();
            idExclui = Integer.parseInt(txtId.getText());
            tutor.excluirTutor(idExclui);
            JOptionPane.showMessageDialog(null, "Excluído com Sucesso");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfCNPJ = new javax.swing.JTextField();
        jtfCPF = new javax.swing.JTextField();
        jbConsultarOng = new javax.swing.JButton();
        jbConsultarTutor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jbEditarOng = new javax.swing.JButton();
        jbEditarTutor = new javax.swing.JButton();
        jbExcluirOng = new javax.swing.JButton();
        jbExcluirTutor = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jbPesquisarOng = new javax.swing.JButton();
        jbPesquisarTutor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe Script", 0, 36)); // NOI18N
        jLabel1.setText("Miau-Au");

        jbConsultarOng.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        jbConsultarOng.setText("Consultar ONG");
        jbConsultarOng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultarOngActionPerformed(evt);
            }
        });

        jbConsultarTutor.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        jbConsultarTutor.setText("Consultar Tutor");
        jbConsultarTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConsultarTutorActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe Script", 0, 10)); // NOI18N
        jLabel2.setText("CNPJ:");

        jLabel3.setFont(new java.awt.Font("Segoe Script", 0, 10)); // NOI18N
        jLabel3.setText("CPF:");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CNPJ/CPF", "Telefone", "Email:", "Descrição", "Endereço", "CEP"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        jbEditarOng.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        jbEditarOng.setText("Editar ONG:");
        jbEditarOng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarOngActionPerformed(evt);
            }
        });

        jbEditarTutor.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        jbEditarTutor.setText("Editar Tutor:");
        jbEditarTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarTutorActionPerformed(evt);
            }
        });

        jbExcluirOng.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        jbExcluirOng.setText("Excluir ONG:");
        jbExcluirOng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirOngActionPerformed(evt);
            }
        });

        jbExcluirTutor.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        jbExcluirTutor.setText("Excluir Tutor:");
        jbExcluirTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirTutorActionPerformed(evt);
            }
        });

        jLabel4.setText("Digite o ID a ser modificado:");

        jbPesquisarOng.setFont(new java.awt.Font("Segoe Script", 0, 10)); // NOI18N
        jbPesquisarOng.setText("Pesquisar ONGs");
        jbPesquisarOng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarOngActionPerformed(evt);
            }
        });

        jbPesquisarTutor.setFont(new java.awt.Font("Segoe Script", 0, 10)); // NOI18N
        jbPesquisarTutor.setText("Pesquisar Tutores");
        jbPesquisarTutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarTutorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbEditarOng)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbExcluirOng)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                                .addComponent(jbEditarTutor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbExcluirTutor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                .addGap(381, 381, 381))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jbPesquisarTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jtfCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jbConsultarOng))
                                                .addComponent(jbPesquisarOng, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(24, 24, 24)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jtfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jbConsultarTutor))
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbConsultarTutor)
                    .addComponent(jbConsultarOng))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbPesquisarOng, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesquisarTutor))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEditarOng)
                    .addComponent(jbEditarTutor)
                    .addComponent(jbExcluirOng)
                    .addComponent(jbExcluirTutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbPesquisarOngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarOngActionPerformed
        limparTabela();
        pesquisarONG();
    }//GEN-LAST:event_jbPesquisarOngActionPerformed

    private void jbPesquisarTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarTutorActionPerformed
        limparTabela();
        pesquisarTutor();
    }//GEN-LAST:event_jbPesquisarTutorActionPerformed

    private void jbExcluirOngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirOngActionPerformed
        excluirONG();
        limparTabela();
        pesquisarONG();
    }//GEN-LAST:event_jbExcluirOngActionPerformed

    private void jbExcluirTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirTutorActionPerformed
        excluirTutor();
        limparTabela();
        pesquisarTutor();
    }//GEN-LAST:event_jbExcluirTutorActionPerformed

    private void jbEditarOngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarOngActionPerformed
        editarONG();
        limparTabela();
        pesquisarONG();
    }//GEN-LAST:event_jbEditarOngActionPerformed

    private void jbEditarTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarTutorActionPerformed
        editarTutor();
        limparTabela();
        pesquisarTutor();
    }//GEN-LAST:event_jbEditarTutorActionPerformed

    private void jbConsultarOngActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarOngActionPerformed
        limparTabela();
        consultarONG();
    }//GEN-LAST:event_jbConsultarOngActionPerformed

    private void jbConsultarTutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConsultarTutorActionPerformed
        limparTabela();
        consultarTutor();
    }//GEN-LAST:event_jbConsultarTutorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Consultar().setVisible(true);
            }
        });
    }
      private int idExclui = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbConsultarOng;
    private javax.swing.JButton jbConsultarTutor;
    private javax.swing.JButton jbEditarOng;
    private javax.swing.JButton jbEditarTutor;
    private javax.swing.JButton jbExcluirOng;
    private javax.swing.JButton jbExcluirTutor;
    private javax.swing.JButton jbPesquisarOng;
    private javax.swing.JButton jbPesquisarTutor;
    private javax.swing.JTextField jtfCNPJ;
    private javax.swing.JTextField jtfCPF;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
