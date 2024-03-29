/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.funcionario_dadosPessoais;

import com.mycompany.dao.DaoCadastro_funcionário;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModDadosPessoaisFuncionario;
import com.mycompany.visao.atestado.CadAtestado;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jose.5989
 */
public class List_Funcionario extends javax.swing.JFrame {

    /**
     * Creates new form List_Funcionario
     */
    public List_Funcionario() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        listarTodos();
        
    }
public void listarTodos(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableFuncionario.getModel();
            
            tableFuncionario.setModel(defaultTableModel);

            DaoCadastro_funcionário daoCadastro_funcionário = new DaoCadastro_funcionário();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoCadastro_funcionário.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String idCidade = resultSet.getString(3);
                String idEstado_Civil = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String sobrenome = resultSet.getString(7);
                String idade = resultSet.getString(8);
                String genero = resultSet.getString(9);
                String rg = resultSet.getString(10);
                String cpf = resultSet.getString(11);
                String setor = resultSet.getString(12);
                String horario_de_trabalho = resultSet.getString(13);
                String salario = resultSet.getString(14);
                String status_funcionario = resultSet.getString(15);
                String data_admissao = resultSet.getString(16);
                String data_demissao = resultSet.getString(17);
                
                                                                               
                defaultTableModel.addRow(new Object[]{id, idCidade, idEstado_Civil, nome, sobrenome, idade, genero, rg, cpf, setor, horario_de_trabalho, salario, status_funcionario, data_admissao, data_demissao, });
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPorId(int pId){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableFuncionario.getModel();

            tableFuncionario.setModel(defaultTableModel);

            DaoCadastro_funcionário daoCadastro_funcionário = new DaoCadastro_funcionário();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoCadastro_funcionário.listarPorId(pId);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String idCidade = resultSet.getString(3);
                String idEstado_Civil = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String sobrenome = resultSet.getString(7);
                String idade = resultSet.getString(8);
                String genero = resultSet.getString(9);
                String rg = resultSet.getString(10);
                String cpf = resultSet.getString(11);
                String setor = resultSet.getString(12);
                String horario_de_trabalho = resultSet.getString(13);
                String salario = resultSet.getString(14);
                String status_funcionario = resultSet.getString(15);
                String data_admissao = resultSet.getString(16);
                String data_demissao = resultSet.getString(17);
                
                defaultTableModel.addRow(new Object[]{ id, idCidade, idEstado_Civil, nome, sobrenome, idade, genero, rg, cpf, setor, horario_de_trabalho, salario, status_funcionario, data_admissao, data_demissao,});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
   public void listarPorNome(String pNome){
        try{
            //Define o model da tabela.
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableFuncionario.getModel();
            
            tableFuncionario.setModel(defaultTableModel);

            DaoCadastro_funcionário daoCadastro_funcionário= new DaoCadastro_funcionário();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoCadastro_funcionário.listarPorNome(pNome);
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String idCidade = resultSet.getString(3);
                String idEstado_Civil = resultSet.getString(5);
                String nome = resultSet.getString(6);
                String sobrenome = resultSet.getString(7);
                String idade = resultSet.getString(8);
                String genero = resultSet.getString(9);
                String rg = resultSet.getString(10);
                String cpf = resultSet.getString(11);
                String setor = resultSet.getString(12);
                String horario_de_trabalho = resultSet.getString(13);
                String salario = resultSet.getString(14);
                String status_funcionario = resultSet.getString(15);
                String data_admissao = resultSet.getString(16);
                String data_demissao = resultSet.getString(17);
                
                defaultTableModel.addRow(new Object[]{id, idCidade, idEstado_Civil, nome, sobrenome, idade, genero, rg, cpf, setor, horario_de_trabalho, salario, status_funcionario, data_admissao, data_demissao,});
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
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

        jcbTipoFiltro = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFuncionario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jcbTipoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "ID", "NOME", " " }));
        jcbTipoFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTipoFiltroActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tableFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "CIDADE ", "ESTADO CIVIL", "NOME", "SOBRENOME", "IDADE", "GENERO", "RG", "CPF", "SETOR", "HORARIO DE TRABLHO", "SALARIO", "STATUS FUNCIONARIO", "DATA  ADMISSAO", "DATA DEMISSAO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableFuncionario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 1407, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTipoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        Formularios.list_Funcionario= null;
    }//GEN-LAST:event_formMouseClicked

    private void jcbTipoFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTipoFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTipoFiltroActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        switch (jcbTipoFiltro.getSelectedIndex()) {
            case 0:
                listarTodos();
                break;
            case 1:
                listarPorId(Integer.parseInt(tfFiltro.getText()));
                break;
            case 2:
                listarPorNome(tfFiltro.getText());
                break;
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tableFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFuncionarioMouseClicked
        if(evt.getClickCount() == 2){
            ModDadosPessoaisFuncionario modDadosPessoaisFuncionario = new ModDadosPessoaisFuncionario();

            modDadosPessoaisFuncionario.setId(Integer.parseInt(String.valueOf(tableFuncionario.getValueAt(tableFuncionario.getSelectedRow(), 0))));
            modDadosPessoaisFuncionario.setNome(String.valueOf(tableFuncionario.getValueAt(tableFuncionario.getSelectedRow(), 3)));
            modDadosPessoaisFuncionario.setSobrenome(String.valueOf(tableFuncionario.getValueAt(tableFuncionario.getSelectedRow(), 4)));

            DadosTemporarios.tempObject = modDadosPessoaisFuncionario;

            ((CadAtestado) Formularios.CadAtestado).recuperaFuncionario();

            dispose();
        }
    }//GEN-LAST:event_tableFuncionarioMouseClicked

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
            java.util.logging.Logger.getLogger(List_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new List_Funcionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTipoFiltro;
    private javax.swing.JTable tableFuncionario;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
