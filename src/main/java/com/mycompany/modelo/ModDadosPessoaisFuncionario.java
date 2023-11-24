/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelo;

/**
 *
 * @author jose.5989
 */
public class ModDadosPessoaisFuncionario {
    private int id;
    private int idCidade;
    private int idEstadoCivil;
    private String nome;
    private String sobrenome;
    private int idade;
    private String genero;
    private String rg;
    private String cpf;
    private String setor;
    private int horarioTrabalho;
    private Double salario;
    private String statusFuncionario;
    private String dataAdmissao;
    private String dataDemissao;

    public ModDadosPessoaisFuncionario() {
    }

    public ModDadosPessoaisFuncionario(int id, int idCidade, int idEstadoCivil, String nome, String sobrenome, int idade, String genero, String rg, String cpf, String setor, int horarioTrabalho, Double salario, String statusFuncionario, String dataAdmissao, String dataDemissao) {
        this.id = id;
        this.idCidade = idCidade;
        this.idEstadoCivil = idEstadoCivil;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.genero = genero;
        this.rg = rg;
        this.cpf = cpf;
        this.setor = setor;
        this.horarioTrabalho = horarioTrabalho;
        this.salario = salario;
        this.statusFuncionario = statusFuncionario;
        this.dataAdmissao = dataAdmissao;
        this.dataDemissao = dataDemissao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public int getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(int idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getHorarioTrabalho() {
        return horarioTrabalho;
    }

    public void setHorarioTrabalho(int horarioTrabalho) {
        this.horarioTrabalho = horarioTrabalho;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getStatusFuncionario() {
        return statusFuncionario;
    }

    public void setStatusFuncionario(String statusFuncionario) {
        this.statusFuncionario = statusFuncionario;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(String dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    @Override
    public String toString() {
        return "ModDadosPessoaisFuncionario{" + "id=" + id + ", idCidade=" + idCidade + ", idEstadoCivil=" + idEstadoCivil + ", nome=" + nome + ", sobrenome=" + sobrenome + ", idade=" + idade + ", genero=" + genero + ", rg=" + rg + ", cpf=" + cpf + ", setor=" + setor + ", horarioTrabalho=" + horarioTrabalho + ", salario=" + salario + ", statusFuncionario=" + statusFuncionario + ", dataAdmissao=" + dataAdmissao + ", dataDemissao=" + dataDemissao + '}';
    }
}
