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
@NamedQuery(name = "Cliente.listar", query = "SELECT pessoa FROM Pessoa pessoa WHERE dtype = Cliente"),
@NamedQuery(name = "Cliente.BuscarCodigo", query = "SELECT pessoa FROM Pessoa pessoa WHERE pessoa.id = :id"),
@NamedQuery(name = "Cliente.BuscarCPF", query = "SELECT pessoa FROM Pessoa pessoa WHERE pessoa.cpf = :cpf")})

public class Cliente extends Pessoa implements Serializable{
  
    @Column(length = 5)
    private double credito;

    public Cliente(double credito, int id, String nome, String cpf, String telefone, String email, Endereco endereco) {
        super(id, nome, cpf, telefone, email, endereco);
        this.credito = credito;
    }

    public Cliente() {
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    @Override
    public String toString() {
        return "Cliente{" + "credito=" + credito + '}';
    }
    
    
}
