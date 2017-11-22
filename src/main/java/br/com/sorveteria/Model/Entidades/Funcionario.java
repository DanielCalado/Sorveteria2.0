/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model.Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 *
 * @author Aluno
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Funcionario.listar", query = "SELECT pessoa FROM Pessoa pessoa WHERE dtype = Cliente"),
@NamedQuery(name = "Funcionario.BuscarCodigo", query = "SELECT pessoa FROM Pessoa pessoa WHERE pessoa.id = :id"),
@NamedQuery(name = "Funcionario.BuscarCPF", query = "SELECT pessoa FROM Pessoa pessoa WHERE pessoa.cpf = :cpf"),
@NamedQuery(name = "Funcionario.BuscarLogin", query = "SELECT pessoa FROM Pessoa pessoa WHERE pessoa.Login = :login")})

public class Funcionario extends Pessoa implements Serializable {
    @Column(length = 20)
    private String Login;
    @Column(length = 30)
    private String senha;

    public Funcionario(String Login, String senha, int id, String nome, String cpf, String telefone, String email, Endereco endereco) {
        super(id, nome, cpf, telefone, email, endereco);
        this.Login = Login;
        this.senha = senha;
    }



    public Funcionario() {
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "Login=" + Login + ", senha=" + senha + '}';
    }

    
}
