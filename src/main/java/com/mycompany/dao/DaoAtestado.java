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
            getStatement().setString(4, data_afastamento);           
            getStatement().setString(5, motivo);
          
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
            
            getStatement().setInt(5, id);
            getStatement().setInt(1, id_dados_pessoais_funcionario);          
            getStatement().setString(2, nome);
            getStatement().setString(3, data_afastamento);           
            getStatement().setString(4, motivo);
            
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
               " select                                                 " +
               "  a.id as id,                                           " +
               " .nome as nome,                                         " +
               " a.data_afastamento  as data_afastamento,               " +
               " a.motivo as motivo                                     " +
               " from                                                   " +
               " atestados a                                            " +
               " join dados_pessoais_funcionario dpf	on              " +
               " dpf.id = a.id_dados_pessoais_funcionario               " ;
            
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
               " select                                                 " +
               "  a.id as id,                                           " +
               " .nome as nome,                                         " +
               " a.data_afastamento  as data_afastamento,               " +
               " a.motivo as motivo                                     " +
               " from                                                   " +
               " atestados a                                            " +
               " join dados_pessoais_funcionario dpf	on              " +
               " dpf.id = a.id_dados_pessoais_funcionario               " +
               " where id = ? ";
            
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
               " select                                                 " +
               "  a.id as id,                                           " +
               " .nome as nome,                                         " +
               " a.data_afastamento  as data_afastamento,               " +
               " a.motivo as motivo                                     " +
               " from                                                   " +
               " atestados a                                            " +
               " join dados_pessoais_funcionario dpf	on              " +
               " dpf.id = a.id_dados_pessoais_funcionario               " +
               " where nome like ? ";
            
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
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM ATESTADOS";
            
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
