/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model.Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aluno
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Venda.listar", query = "SELECT venda FROM Venda venda"),
@NamedQuery(name = "venda.BuscarId", query = "SELECT venda FROM Venda venda WHERE venda.id = :id")})
public class Venda implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(length = 20)
    private Date horario;
    private double valor;
    @ManyToOne(cascade=CascadeType.ALL)
    private Funcionario funcionario;

    public Venda(int id, Date horario, double valor, Funcionario funcionario) {
        this.id = id;
        this.horario = horario;
        this.valor = valor;
        this.funcionario = funcionario;
    }

    public Venda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda other = (Venda) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", horario=" + horario + ", valor=" + valor + ", funcionario=" + funcionario + '}';
    }
    
    
    
}
