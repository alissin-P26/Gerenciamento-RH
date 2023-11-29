/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author jose.5989
 */
public class ModCadRH {
    private int id;
    private int id_dados_pessoais_funcionario;
    private String email;
    private String usuario;
    private String senha;
    
 public ModCadRH (){
     
 }
 
 public ModCadRH (int id, int id_dados_pessoais_funcionario, String email, String usuario, String senha){
     this.id = id;
     this.id_dados_pessoais_funcionario = id_dados_pessoais_funcionario;
     this.email = email;
     this.usuario = usuario;
     this.senha = senha;
 }
  public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId_dados_pessoais_funcionario() {
        return id_dados_pessoais_funcionario;
    }

    public void setId_dados_pessoais_funcionario(int id) {
        this.id_dados_pessoais_funcionario = id_dados_pessoais_funcionario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "ModCadRH{" + "id=" + id + ", id_dados_pessoais_funcionario=" + id_dados_pessoais_funcionario + ", email=" + email + ", usuario=" + usuario + ", senha=" + senha + '}';
    }

               
}
