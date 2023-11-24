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

/**
 *
 * @author jose.5989
 */
public class DaoAtestado extends BancoDeDadosMySql {
    String sql;
    
    public Boolean inserir(int id, int id_dados_pessoais_funcionario, String nome, String data_afastamento, String motivo){
       try{
            sql = "INSERT INTO ATESTADOS (ID, ID_DADOS_PESSOAIS_FUNCIONARIO, NOME, DATA_AFASTAMENTO, MOTIVO) VALUES (?, ?, ?, ?, ?)";
           
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, id_dados_pessoais_funcionario);          
            getStatement().setString(3, nome);
            getStatement().setString(5, data_afastamento);           
            getStatement().setString(6, motivo);
          
           getStatement().executeUpdate();
           
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
       }
   } 
    
    public Boolean alterar(int id, int id_dados_pessoais_funcionario, String nome, String data_afastamento, String motivo){
        try{
            sql = "UPDATE ATESTADOS SET DADOS_PESSOAIS_FUNCIONARIO = ?,  NOME = ?, DATA_AFASTAMENTO = ?, MOTIVO = ?,  WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, id_dados_pessoais_funcionario);          
            getStatement().setString(3, nome);
            getStatement().setString(5, data_afastamento);           
            getStatement().setString(6, motivo);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
     public Boolean excluir(int id){
        try{
            sql = "DELETE FROM ATESTADOS WHERE ID = ?";
            
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
}
