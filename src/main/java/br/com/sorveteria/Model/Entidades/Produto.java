/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model.Entidades;

import java.io.Serializable;
import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author 20161D13GR0031
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Produto.listar", query = "SELECT produto FROM Produto produto"),
@NamedQuery(name = "Produto.BuscarCodigo", query = "SELECT produto FROM Produto produto WHERE produto.codigo = :codigo"),
@NamedQuery(name = "Produto.BuscarNome", query = "SELECT produto FROM Produto produto WHERE produto.nome like :nome")})
public class Produto implements Serializable{
    @Id
    private int codigo;
    @Column(length = 20)
    private String tipo;
    @Column(length = 20)
    private String nome;
    @Column(length = 5)
    private int quantidade;
    @Column(length = 5)
    private double custoVenda;
    @Column(length = 5)
    private double custoCompra;

    public Produto() {
    }

    public Produto(int codigo, String tipo, String nome, int quantidade, double custoVenda, double custoCompra) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.custoVenda = custoVenda;
        this.custoCompra = custoCompra;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the custoVenda
     */
    public double getCustoVenda() {
        return custoVenda;
    }

    /**
     * @param custoVenda the custoVenda to set
     */
    public void setCustoVenda(double custoVenda) {
        this.custoVenda = custoVenda;
    }

    /**
     * @return the custoCompra
     */
    public double getCustoCompra() {
        return custoCompra;
    }

    /**
     * @param custoCompra the custoCompra to set
     */
    public void setCustoCompra(double custoCompra) {
        this.custoCompra = custoCompra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.codigo;
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
        final Produto other = (Produto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", tipo=" + tipo + ", nome=" + nome + ", quantidade=" + quantidade + ", custoVenda=" + custoVenda + ", custoCompra=" + custoCompra + '}';
    }


}
