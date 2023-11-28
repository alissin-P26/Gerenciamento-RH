/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import com.mycompany.ferramentas.BancoDeDadosMySql;
import static com.mycompany.ferramentas.BancoDeDadosMySql.getConexao;
import static com.mycompany.ferramentas.BancoDeDadosMySql.getResultado;
import static com.mycompany.ferramentas.BancoDeDadosMySql.getStatement;
import static com.mycompany.ferramentas.BancoDeDadosMySql.setResultado;
import static com.mycompany.ferramentas.BancoDeDadosMySql.setStatement;
import java.sql.ResultSet;
import java.sql.Types;

/**
 *
 * @author jose.5989
 */
public class DaoCadastro_funcionário extends BancoDeDadosMySql {
    String sql;
    
    public Boolean inserir(int id, int idCidade, int idEstadoCivil, String nome, String sobrenome, int idade, String genero, String rg, String cpf, String setor, int horarioTrabralhos, Double salario, String status, String admissao, String demissao){
        try{
            sql = "INSERT INTO DADOS_PESSOAIS_FUNCIONARIO (ID, ID_CIDADE, ID_ESTADO_CIVIL, NOME, SOBRENOME, IDADE, GENERO, RG, CPF, SETOR, HORARIO_DE_TRABALHO, SALARIO, STATUS_FUNCIONARIO, DATA_ADMISSAO, DATA_DEMISSAO) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idCidade);
            getStatement().setInt(3, idEstadoCivil);
            getStatement().setString(4, nome);
            getStatement().setString(5, sobrenome);
            getStatement().setInt(6, idade);
            getStatement().setString(7, genero);
            getStatement().setString(8, rg);
            getStatement().setString(9, cpf);
            getStatement().setString(10, setor);
            getStatement().setInt(11, horarioTrabralhos);
            getStatement().setDouble(12, salario);
            getStatement().setString(13, status);
            getStatement().setString(14, admissao);
            
            if(demissao.equals(""))
                getStatement().setNull(15, Types.DATE);
            else
                getStatement().setString(15, demissao);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    } 
    
    public Boolean alterar(int id, int idCidade, int idEstadoCivil, String nome, String sobrenome, int idade, String genero, String rg, String cpf, String setor, int horarioTrabralhos, double salaraio, String status, String admissao, String demissao){
        try{
            sql = "UPDATE DADOS_PESSOAIS_FUNCIONARIO SET ID_CIDADE = ?, ID_ESTADO_CIVIL = ?, NOME = ?, SOBRENOME = ?, GENERO = ?, RG = ?, CPF = ?, SETOR = ?, HORARIOTRABALHOS = ?, SALARIIO = ?, STATUS = ?, ADMISSAO = ?, DEMISSAO = ?, WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idCidade);
            getStatement().setInt(3, idEstadoCivil);
            getStatement().setString(4, nome);
            getStatement().setString(5, sobrenome);
            getStatement().setInt(6, idade);
            getStatement().setString(7, genero);
            getStatement().setString(8, rg);
            getStatement().setString(9, cpf);
            getStatement().setString(10, setor);
            getStatement().setInt(11, horarioTrabralhos);
            getStatement().setDouble(12, salaraio);
            getStatement().setString(13, status);
            getStatement().setString(14, admissao);
            getStatement().setString(15, demissao);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
     public Boolean excluir(int id){
        try{
            sql = "DELETE FROM DADOS_PESSOAIS_FUNCIONARIO WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
     public ResultSet listarTodos(){
        try{    
            sql = 
                " select                                        " +
                "    dpf.id as id,                              " +
                "    dpf.id_cidade as id_cidade,                " +
                "    c.nome as cidade,                          " +
                "    dpf.id_estado_civil as id_estado_civil,    " +
                "    ec.nome as estado_civil,                   " +
                "    dpf.nome as nome,                          " +
                "    dpf.sobrenome as sobrenome,                " +
                "    dpf.idade as idade,                        " +
                "    dpf.genero as genero,                      " +
                "    dpf.RG as RG,                              " +
                "    dpf.CPF as CPF,                            " +
                "    dpf.setor as setor,                        " +
                "    dpf.horario_de_trabalho as horario_de_trabalho,    " +
                "    dpf.salario as salario,                            " +
                "    dpf.status_funcionario as status_funcionario,      " +
                "    dpf.data_admissao as data_admissao,                " +
                "    dpf.data_demissao as data_demissao                 " +
                " from                                                  " +
                "        dados_pessoais_funcionario dpf                 " +
                " join cidade c on                                      " +
                "        c.id = dpf.id_cidade                           " +
                " join estado_civil ec on                               " +
                "        ec.id = dpf.id_estado_civil                    ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
     
    public ResultSet listarPorId(int id){
        try{    
            sql = 
                " select                                        " +
                "    dpf.id as id,                              " +
                "    dpf.id_cidade as id_cidade,                " +
                "    c.nome as cidade,                          " +
                "    dpf.id_estado_civil as id_estado_civil,    " +
                "    ec.nome as estado_civil,                   " +
                "    dpf.nome as nome,                          " +
                "    dpf.sobrenome as sobrenome,                " +
                "    dpf.idade as idade,                        " +
                "    dpf.genero as genero,                      " +
                "    dpf.RG as RG,                              " +
                "    dpf.CPF as CPF,                            " +
                "    dpf.setor as setor,                        " +
                "    dpf.horario_de_trabalho as horario_de_trabalho,    " +
                "    dpf.salario as salario,                            " +
                "    dpf.status_funcionario as status_funcionario,      " +
                "    dpf.data_admissao as data_admissao,                " +
                "    dpf.data_demissao as data_demissao                 " +
                " from                                                  " +
                "        dados_pessoais_funcionario dpf                 " +
                " join cidade c on                                      " +
                "        c.id = dpf.id_cidade                           " +
                " join estado_civil ec on                               " +
                "        ec.id = dpf.id_estado_civil                    " +
                " where dpf.id = ? ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    } 
     
    public ResultSet listarPorNome(String nome){
        try{    
            sql = 
                " select                                        " +
                "    dpf.id as id,                              " +
                "    dpf.id_cidade as id_cidade,                " +
                "    c.nome as cidade,                          " +
                "    dpf.id_estado_civil as id_estado_civil,    " +
                "    ec.nome as estado_civil,                   " +
                "    dpf.nome as nome,                          " +
                "    dpf.sobrenome as sobrenome,                " +
                "    dpf.idade as idade,                        " +
                "    dpf.genero as genero,                      " +
                "    dpf.RG as RG,                              " +
                "    dpf.CPF as CPF,                            " +
                "    dpf.setor as setor,                        " +
                "    dpf.horario_de_trabalho as horario_de_trabalho,    " +
                "    dpf.salario as salario,                            " +
                "    dpf.status_funcionario as status_funcionario,      " +
                "    dpf.data_admissao as data_admissao,                " +
                "    dpf.data_demissao as data_demissao                 " +
                " from                                                  " +
                "        dados_pessoais_funcionario dpf                 " +
                " join cidade c on                                      " +
                "        c.id = dpf.id_cidade                           " +
                " join estado_civil ec on                               " +
                "        ec.id = dpf.id_estado_civil                    " +
                " where dpf.nome like ? ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public int buscarProximoId(){
        int id = 0;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM DADOS_PESSOAIS_FUNCIONARIO";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next(); //Move para o primeiro registro.
            
            id = getResultado().getInt(1); //Pega o valor retornado na consulta
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id;
    }
}

