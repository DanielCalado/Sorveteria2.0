/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model;

import br.com.sorveteria.Model.Util.Messages;
import br.com.sorveteria.Model.DAO.ProdutoDAO;
import br.com.sorveteria.Model.Entidades.Produto;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aluno
 */

public class ProdutoModel implements Serializable {

    private Produto produto = new Produto();

    public ProdutoModel() {

    }

    public void salvar(Produto pro) {
        try {
            Random randon = new Random();
            pro.setCodigo(randon.nextInt((9999 - 1000) + 1) + 1000);
            Produto novo = ProdutoDAO.getInstance().recuperar(pro.getCodigo());
            if (novo == null) {
                ProdutoDAO.getInstance().inserir(pro);
                produto = new Produto();
                Messages.getInstance().adicionarMensagem(null, "Produto efetuado com sucesso!", FacesMessage.SEVERITY_INFO);

            } else {
                Messages.getInstance().adicionarMensagem(null, "Codigo já cadastrado. Precione salvar novamente!", FacesMessage.SEVERITY_WARN);

            }
        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo salvar model!");
        }

    }

    public void alterar(Produto pro) {
        try {

            ProdutoDAO.getInstance().alterar(pro);
            produto = new Produto();
            Messages.getInstance().adicionarMensagem(null, "Produto alterado com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo alterar!");

        }
    }

    public void excluir(Produto pro) {
        try {
            ProdutoDAO.getInstance().deletar(pro);
            produto = new Produto();
        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo salvar!");

        }
    }

    public void consultar(int codigo) {
        this.produto = ProdutoDAO.getInstance().recuperar(codigo);

    }
    public List<Produto> consultarPorNome(String nome) {
        return ProdutoDAO.getInstance().recuperarPorNome(nome);

    }
    public List<Produto> consultarTodos() {
        try {
            return ProdutoDAO.getInstance().recuperarTodos();
        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo consultarTodos!");

        }
        return null;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
