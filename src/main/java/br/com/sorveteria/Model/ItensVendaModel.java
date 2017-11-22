/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model;

import br.com.sorveteria.Model.DAO.ItemVendaDAO;
import br.com.sorveteria.Model.Entidades.ItensVenda;
import br.com.sorveteria.Model.Util.Messages;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;

/**
 *
 * @author Aluno
 */

public class ItensVendaModel implements Serializable {

    private ItensVenda itensVenda = new ItensVenda();

    public ItensVendaModel() {

    }

    public void salvar(ItensVenda itv) {
        try {
                ItemVendaDAO.getInstance().inserir(itv);
                itensVenda = new ItensVenda();
                Messages.getInstance().adicionarMensagem(null, "Itens venda salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo salvar model!");
        }

    }

    public void alterar(ItensVenda itv) {
        try {

            ItemVendaDAO.getInstance().alterar(itv);
            itensVenda = new ItensVenda();
            Messages.getInstance().adicionarMensagem(null, "Item venda alterada com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo alterar!");

        }
    }

    public void excluir(ItensVenda itv) {
        try {
            ItemVendaDAO.getInstance().deletar(itv);
            itensVenda = new ItensVenda();
        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo salvar!");

        }
    }

    public void consultar(int id) {
        this.itensVenda = ItemVendaDAO.getInstance().recuperar(id);
    }
    
    public List<ItensVenda> consultarTodos() {
        try {
            return ItemVendaDAO.getInstance().recuperarTodos();
        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo consultarTodos!");

        }
        return null;
    }

    public ItensVenda getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(ItensVenda itensVenda) {
        this.itensVenda = itensVenda;
    }

}

