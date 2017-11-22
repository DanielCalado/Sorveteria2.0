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
    
public ProdutoController(){
    model =new ProdutoModel();
    produto = new Produto();
    ListadeProdutos = new ArrayList<>();
}

public void inserir(){
    model.salvar(produto);
}
public void alterar(){
    model.alterar(produto);
}
public void excluir(){
    model.excluir(produto);
    buscarTodos();
}
public void consultar(){
    model.consultar(produto.getCodigo());
}
public void buscarTodos(){
    ListadeProdutos = model.consultarTodos();
}
public List<Produto> buscarNome(){
    return model.consultarPorNome(produto.getNome());
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
public void limpar(){
    produto = new Produto();
}
}

