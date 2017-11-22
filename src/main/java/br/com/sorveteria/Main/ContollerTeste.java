/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Main;

import br.com.sorveteria.Model.Entidades.Produto;
import br.com.sorveteria.Model.ProdutoModel;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aluno
 */
@ManagedBean(name = "ControllerTeste")
@SessionScoped
public class ContollerTeste {
 private ProdutoModel model = null;
 private Produto produto;

    public ContollerTeste() {
        model = new ProdutoModel();
        produto = new Produto();
    }
 public void salvar(){
     model.salvar(produto);
 }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
 
    
}
