/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model.Entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Aluno
 */
@Entity
@NamedQueries({
@NamedQuery(name = "ItensVenda.listar", query = "SELECT itensVenda FROM ItensVenda itensVenda"),
@NamedQuery(name = "ItensVenda.BuscarId", query = "SELECT itensVenda FROM ItensVenda itensVenda WHERE itensVenda.id = :id")})
public class ItensVenda implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private double valor;
    private String nome;
    private int quantidade;
    @ManyToOne(cascade=CascadeType.ALL)
    private Produto produto;

    public ItensVenda(String nome, int id, double valor, int quantidade, Produto produto) {
        this.id = id;
        this.valor = valor;
        this.quantidade = quantidade;
        this.produto = produto;
        this.nome = nome;
    }

    public ItensVenda() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
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
        final ItensVenda other = (ItensVenda) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItensVenda{" + "id=" + id + ", valor=" + valor + ", quantidade=" + quantidade + ", produto=" + produto + '}';
    }
    
    
}
