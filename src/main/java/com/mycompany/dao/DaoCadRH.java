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
public class DaoCadRH extends BancoDeDadosMySql{
    String sql;
    public Boolean inserir(int id, int id_dados_pessoais_funcionario, String email, String usuario, String senha){
        try{
            sql = "INSERT INTO CADASTRO_DE_GERENCIAMNETORH (ID, ID_DADOS_PESSOAIS_FUNCIONARIO, EMAIL, USUARIO, SENHA) VALUES (?, ?, ?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, id_dados_pessoais_funcionario);
            getStatement().setString(3, email);
            getStatement().setString(4, usuario);
            getStatement().setString(5, senha);
            
            getStatement().executeUpdate();
            
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean alterar(int id, int id_dados_pessoais_funcionario, String email, String usuario, String senha ){
        try{
            sql = "UPDATE CADASTRO_DE_GERENCIAMNETORH SET NOME = ? WHERE ID = ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(2, id);
//            getStatement().setString(1, novoNome);
            
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
                "   select                                          " +
                "	crh.id as id,                               " +
                "	dpf.nome as nome,                           " +
                "	dpf.sobrenome as sobrenome,                 " +
                "	crh.email as email,                         " +
                "	crh.usuario as usuario,                     " +
                "	crh.senha                                   " +
                "   from                                            " +
                "	CADASTRO_DE_GERENCIAMENTORH crh             " +
                "   join dados_pessoais_funcionario dpf on          " +
                "	dpf.id = crh.id_dados_pessoais_funcionario  ";
            
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
                "   select                                          " +
                "	crh.id as id,                               " +
                "	dpf.nome as nome,                           " +
                "	dpf.sobrenome as sobrenome,                 " +
                "	crh.email as email,                         " +
                "	crh.usuario as usuario,                     " +
                "	crh.senha                                   " +
                "   from                                            " +
                "	CADASTRO_DE_GERENCIAMENTORH crh             " +
                "   join dados_pessoais_funcionario dpf on          " +
                "	dpf.id = crh.id_dados_pessoais_funcionario  " +
                "   where crh.id = ?                                " ;
            
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
                 "   select                                          " +
                "	crh.id as id,                               " +
                "	dpf.nome as nome,                           " +
                "	dpf.sobrenome as sobrenome,                 " +
                "	crh.email as email,                         " +
                "	crh.usuario as usuario,                     " +
                "	crh.senha                                   " +
                "   from                                            " +
                "	CADASTRO_DE_GERENCIAMENTORH crh             " +
                "   join dados_pessoais_funcionario dpf on          " +
                "	dpf.id = crh.id_dados_pessoais_funcionario  " +                
                " where crh.nome like ? ";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet recuperaSenha(String usuario){
        try{
            sql = 
                " SELECT                            " +
                "   ID,                             " +
                "   SENHA                           " +
                " FROM                              " +
                "   CADASTRO_DE_GERENCIAMENTORH     " +
                " WHERE crh.USUARIO = ?                 " ;
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, usuario);
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    public int buscarProximoId(){
        int id = 0;
        
        try{
            sql = "SELECT IFNULL(MAX(ID), 0) + 1 FROM CADASTRO_DE_GERENCIAMENTORH";
            
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
