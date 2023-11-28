/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.funcionario_dadosPessoais;

import com.mycompany.dao.DaoCadastro_funcionário;
import com.mycompany.dao.DaoCidade;
import com.mycompany.dao.DaoEstadoCivil;
import com.mycompany.ferramentas.BancoDeDadosMySql;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModDadosPessoaisFuncionario;
import com.mycompany.visao.cidade.ListCidade;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author jose.5989
 */
public class Cad_Funcionario extends javax.swing.JFrame {

    /**
     * Creates new form Cad_Funcionario
     */
    public Cad_Funcionario() {
        initComponents();
        
        setLocationRelativeTo(null);
        
        carregarCidades();
        recuperaIdCidade();
        
        if(!existeDadosTemporarios()){
            DaoCadastro_funcionário daoCadastro_funcionário = new DaoCadastro_funcionário();

            int id = daoCadastro_funcionário.buscarProximoId(); 
            if (id > 0)
                tfId.setText(String.valueOf(id));
            
            btnAcao.setText(Constantes.BTN_SALVAR_TEXT);
            btnExcluir.setVisible(false);
        }else{
            btnAcao.setText(Constantes.BTN_ALTERAR_TEXT);
            btnExcluir.setVisible(true);
        }
        
        tfGenero.setVisible(false);
        tfSetor.setVisible(false);
        tfFuncionario.setVisible(false);
        
        carregarEstadoCivil();
        recuperaIdEstadoCivil();
    }

    private Boolean existeDadosTemporarios(){        
        if(DadosTemporarios.tempObject instanceof ModDadosPessoaisFuncionario){
            int id = ((ModDadosPessoaisFuncionario) DadosTemporarios.tempObject).getId();
            int idCidade = ((ModDadosPessoaisFuncionario) DadosTemporarios.tempObject).getIdCidade();
            int idEstadoCivil = ((ModDadosPessoaisFuncionario) DadosTemporarios.tempObject).getIdEstadoCivil();
            String nome = ((ModDadosPessoaisFuncionario) DadosTemporarios.tempObject).getNome();
            String sobrenome = ((ModDadosPessoaisFuncionario) DadosTemporarios.tempObject).getSobrenome();
            int idade = ((ModDadosPessoaisFuncionario) DadosTemporarios.tempObject).getIdade();
            String genero = ((ModDadosPessoaisFuncionario) DadosTemporarios.tempObject).getGenero();
            String rg = ((ModDadosPessoaisFuncionario) DadosTemporarios.tempObject).getRg();
            String cpf = ((ModDadosPessoaisFuncionario) DadosTemporarios.tempObject).getCpf();
            String setor = ((ModDadosPessoaisFuncionario) DadosTemporarios.tempObject).getSetor();
            int horarioTrabalho = ((ModDadosPessoaisFuncionario) DadosTemporarios.tempObject).getHorarioTrabalho();
            Double salario = ((ModDadosPessoaisFuncionario) DadosTemporarios.tempObject).getSalario();
            String statusFuncionario = ((ModDadosPessoaisFuncionario) DadosTemporarios.tempObject).getStatusFuncionario();
            String dataAdmissao = ((ModDadosPessoaisFuncionario) DadosTemporarios.tempObject).getDataAdmissao();
            String dataDemissao = ((ModDadosPessoaisFuncionario) DadosTemporarios.tempObject).getDataDemissao();
            
            tfId.setText(String.valueOf(id));
            tfIdCidade.setText(String.valueOf(idCidade));
            tfIdEstadoCivil.setText(String.valueOf(idEstadoCivil));
            tfNome.setText(nome);
            tfSobrenome.setText(sobrenome);
            tfIdade.setText(String.valueOf(idade));
            tfGenero.setText(genero);
            tfGenero.setText(rg);
            tfGenero.setText(cpf);
            tfGenero.setText(setor);
            tfGenero.setText(String.valueOf(horarioTrabalho));
            tfGenero.setText(String.valueOf(salario));
            tfGenero.setText(statusFuncionario);
            tfGenero.setText(dataAdmissao);
            tfGenero.setText(dataDemissao);
            
            DadosTemporarios.tempObject = null;
            
            return true;
        }else
            return false;
    }
    
    private void inserir(){
        DaoCadastro_funcionário daoCadastro_funcionário = new DaoCadastro_funcionário();
        
        String genero = String.valueOf(jcbGenero.getSelectedItem());
        String status = String.valueOf(jcbStatusFunc.getSelectedItem());
        String setor = String.valueOf(jcbSetor.getSelectedItem());
        
        if (daoCadastro_funcionário.inserir(
                Integer.parseInt(tfId.getText()), 
                Integer.parseInt(tfIdCidade.getText()), 
                Integer.parseInt(tfIdEstadoCivil.getText()), 
                tfNome.getText(), tfSobrenome.getText(), 
                Integer.parseInt(tfIdade.getText()), 
                genero, 
                tfRg.getText(), 
                tfCpf.getText(), 
                setor, 
                Integer.parseInt(tfHorario.getText()), 
                Double.parseDouble(tfSalario.getText()), 
                status, 
                tfAdmissao.getText(), 
                tfDemissao.getText())){
            
            JOptionPane.showMessageDialog(null, "Funcionário salvo com sucesso!");
            
            tfId.setText(String.valueOf(daoCadastro_funcionário.buscarProximoId()));
            tfNome.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o funcionário!");
        }
    }
    
    private void alterar(){
        DaoCadastro_funcionário daoCadastro_funcionário = new DaoCadastro_funcionário();
        
        if (daoCadastro_funcionário.alterar(Integer.parseInt(tfId.getText()), 
                Integer.parseInt(tfIdCidade.getText()), 
                Integer.parseInt(tfIdEstadoCivil.getText()), 
                tfNome.getText(), tfSobrenome.getText(), 
                Integer.parseInt(tfIdade.getText()), 
                tfGenero.getText(), 
                tfRg.getText(), 
                tfCpf.getText(), 
                tfSetor.getText(), 
                Integer.parseInt(tfHorario.getText()), 
                Double.parseDouble(tfSalario.getText()), 
                "A", 
                tfAdmissao.getText(), 
                tfDemissao.getText())){
            
            JOptionPane.showMessageDialog(null, "Dados do funcionário alterados com sucesso!");
            
            tfId.setText("");
            tfNome.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar os dados do funcionário!");
        }
        
//        ((List_Funcionario) Formularios.list_Funcionario).listarTodos();
        
        dispose();
    }
    
    private void excluir(){
        DaoCadastro_funcionário daoCadastro_funcionário = new DaoCadastro_funcionário();
        
        if (daoCadastro_funcionário.excluir(Integer.parseInt(tfId.getText()))){
            JOptionPane.showMessageDialog(null, "Funcionário " + tfNome.getText() + " excluído com sucesso!");
            
            tfId.setText("");
            tfNome.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o funcionário!");
        }
        
//        ((ListCidade) Formularios.listCidade).listarTodos();
        
        dispose();
    }
    
    public void carregarCidades(){
        try{
            DaoCidade daoCidade = new DaoCidade();

            ResultSet resultSet = daoCidade.listarTodos();

            while(resultSet.next()){
                jcbCidade.addItem(resultSet.getString("CIDADE"));
            }
        }catch(Exception e){
            
        }
    }
    
    private void recuperaIdCidade(){
        try{
            DaoCidade daoCidade = new DaoCidade();
            ResultSet resultSet = daoCidade.listarPorNome(jcbCidade.getSelectedItem().toString());
            
            resultSet.next();
            tfIdCidade.setText(resultSet.getString("ID"));
        }catch(Exception e){
            System.out.println(e.getMessage());            
        }
    }
    
    public void carregarEstadoCivil(){
        try{
            DaoEstadoCivil daoEstadoCivil = new DaoEstadoCivil();

            ResultSet resultSet = daoEstadoCivil.listarTodos();

            while(resultSet.next()){
                jcbEstadoCivil.addItem(resultSet.getString("NOME"));
            }
        }catch(Exception e){
            
        }
    }
    
    private void recuperaIdEstadoCivil(){
        try{
            DaoEstadoCivil daoEstadoCivil = new DaoEstadoCivil();
            ResultSet resultSet = daoEstadoCivil.listarPorNome(jcbEstadoCivil.getSelectedItem().toString());
            
            resultSet.next();
            tfIdEstadoCivil.setText(resultSet.getString("ID"));
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

        jPanel1 = new javax.swing.JPanel();
        jcbCidade = new javax.swing.JComboBox<>();
        tfId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfIdCidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbEstadoCivil = new javax.swing.JComboBox<>();
        tfIdEstadoCivil = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfSobrenome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfIdade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfGenero = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfCpf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfRg = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfHorario = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfSalario = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfFuncionario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfAdmissao = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tfDemissao = new javax.swing.JTextField();
        tfSetor = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnAcao = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jcbStatusFunc = new javax.swing.JComboBox<>();
        jcbGenero = new javax.swing.JComboBox<>();
        jcbSetor = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jcbCidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCidadeItemStateChanged(evt);
            }
        });
        jcbCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCidadeActionPerformed(evt);
            }
        });

        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("Cidade");

        tfIdCidade.setText("id_cidade");
        tfIdCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdCidadeActionPerformed(evt);
            }
        });

        jLabel3.setText("Estado Civil");

        jcbEstadoCivil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEstadoCivilItemStateChanged(evt);
            }
        });

        tfIdEstadoCivil.setText("id_estado_civil");

        jLabel4.setText("Nome");

        tfSobrenome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSobrenomeActionPerformed(evt);
            }
        });

        jLabel5.setText("Sobrenome");

        jLabel6.setText("Idade");

        jLabel7.setText("Genero");

        jLabel8.setText("RG");

        jLabel9.setText("CPF");

        tfRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRgActionPerformed(evt);
            }
        });

        jLabel10.setText("Setor");

        jLabel11.setText("Horário de trabalho");

        jLabel12.setText("Salário");

        jLabel13.setText("Status funcionário");

        jLabel14.setText("Data-Admissão");

        jLabel15.setText("Data-Demissão");

        jLabel16.setText("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        jLabel19.setText("| | | | |");

        jLabel17.setText("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        btnAcao.setText("Salvar");
        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jcbStatusFunc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "I" }));

        jcbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Outros" }));

        jcbSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administração", "RH", "Financeiro", "Contábil", "Marketing", "Vendas", "Produção", "Logística", "TI" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addGap(928, 928, 928)
                        .addComponent(btnAcao))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(tfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jcbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(tfRg, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19))
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jcbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfIdEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(tfGenero))
                                        .addGap(18, 18, 18)
                                        .addComponent(tfSetor))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jcbStatusFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(86, 86, 86))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10)
                                .addComponent(jcbSetor, 0, 202, Short.MAX_VALUE)
                                .addComponent(tfDemissao))))
                    .addComponent(tfNome)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(tfSobrenome)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfIdEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jcbSetor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jcbStatusFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfDemissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(tfGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcao)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1085, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdActionPerformed

    private void tfRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRgActionPerformed

    private void jcbCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCidadeItemStateChanged
        recuperaIdCidade();
    }//GEN-LAST:event_jcbCidadeItemStateChanged

    private void tfSobrenomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSobrenomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSobrenomeActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        DaoCadastro_funcionário DaoCadastro_funcionário = new DaoCadastro_funcionário();
        
        if (btnAcao.getText() == Constantes.BTN_SALVAR_TEXT){
            inserir();
            
            tfId.setText(String.valueOf(DaoCadastro_funcionário.buscarProximoId()));
            tfNome.setText("");
            tfSobrenome.setText("");
            tfIdade.setText("");
            tfRg.setText("");
            tfCpf.setText("");
            tfSetor.setText("");
            tfHorario.setText("");
            tfSalario.setText("");
            tfAdmissao.setText("");
            tfDemissao.setText("");
        }
        else if (btnAcao.getText() == Constantes.BTN_ALTERAR_TEXT){
            alterar();
            ((List_Funcionario) Formularios.list_Funcionario).listarTodos();
            dispose();
        }
    }//GEN-LAST:event_btnAcaoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        "Deseja realmente excluir a categoria " + tfNome.getText() + "?");
        
        if(escolha == JOptionPane.YES_OPTION)
            excluir();       
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jcbCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCidadeActionPerformed

    private void tfIdCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdCidadeActionPerformed

    private void jcbEstadoCivilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbEstadoCivilItemStateChanged
        recuperaIdEstadoCivil();
    }//GEN-LAST:event_jcbEstadoCivilItemStateChanged

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
            java.util.logging.Logger.getLogger(Cad_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cad_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cad_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cad_Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cad_Funcionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcbCidade;
    private javax.swing.JComboBox<String> jcbEstadoCivil;
    private javax.swing.JComboBox<String> jcbGenero;
    private javax.swing.JComboBox<String> jcbSetor;
    private javax.swing.JComboBox<String> jcbStatusFunc;
    private javax.swing.JTextField tfAdmissao;
    private javax.swing.JTextField tfCpf;
    private javax.swing.JTextField tfDemissao;
    private javax.swing.JTextField tfFuncionario;
    private javax.swing.JTextField tfGenero;
    private javax.swing.JTextField tfHorario;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfIdCidade;
    private javax.swing.JTextField tfIdEstadoCivil;
    private javax.swing.JTextField tfIdade;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfRg;
    private javax.swing.JTextField tfSalario;
    private javax.swing.JTextField tfSetor;
    private javax.swing.JTextField tfSobrenome;
    // End of variables declaration//GEN-END:variables
}
