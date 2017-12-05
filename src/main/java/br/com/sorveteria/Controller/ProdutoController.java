/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Controller;

import br.com.sorveteria.Model.Entidades.Produto;
import br.com.sorveteria.Model.ProdutoModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aluno
 */
@ManagedBean(name = "produtoController")
@SessionScoped
public class ProdutoController{
 private ProdutoModel model = null;
    private Produto produto;
    private List<Produto> ListadeProdutos;
    private List<Produto> ListadeProdutosFiltrados;
    
public ProdutoController(){
    model =new ProdutoModel();
    produto = new Produto();
    ListadeProdutos = new ArrayList<>();
}

public void inserir(){
    model.salvar(produto);
    limpar();
}
public void alterar(){
    model.alterar(produto);
    limpar();
}
public void excluir(){
    model.excluir(produto);
    limpar();
}
public void consultar(){
    model.consultar(produto.getCodigo());
}
public void buscarTodos(){
    ListadeProdutos = model.consultarTodos();
}

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getListadeProdutos() {
        return ListadeProdutos;
    }

    public void setListadeProdutos(List<Produto> ListadeProdutos) {
        this.ListadeProdutos = ListadeProdutos;
    }

    public List<Produto> getListadeProdutosFiltrados() {
        return ListadeProdutosFiltrados;
    }

    public void setListadeProdutosFiltrados(List<Produto> ListadeProdutosFiltrados) {
        this.ListadeProdutosFiltrados = ListadeProdutosFiltrados;
    }
    
public void limpar(){
    produto = new Produto();
    buscarTodos();
}
}

