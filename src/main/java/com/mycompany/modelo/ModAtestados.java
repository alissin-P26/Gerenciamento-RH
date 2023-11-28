/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author jose.5989
 */
public class ModAtestados {
    private int id;
    private int id_dados_pessoais_funcionario;
    private String nome;
    private String data_afastamento;
    private String motivo;
    
    public ModAtestados(){
    }
    
    public ModAtestados(int id, int id_dados_pessoais_funcionario, String nome, String data_afastamento, String motivo){
        this.id = id;
        this.id_dados_pessoais_funcionario = id_dados_pessoais_funcionario;     
        this.nome = nome;
        this.data_afastamento = data_afastamento;
        this.motivo = motivo;
    }
}
