/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model;

import br.com.sorveteria.Model.DAO.VendaDAO;
import br.com.sorveteria.Model.Entidades.Venda;
import br.com.sorveteria.Model.Util.Messages;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;

/**
 *
 * @author Aluno
 */

public class VendaModel implements Serializable {

    private Venda venda = new Venda();

    public VendaModel() {

    }

    public void salvar(Venda ven) {
        try {
                VendaDAO.getInstance().inserir(ven);
                venda = new Venda();
                Messages.getInstance().adicionarMensagem(null, "Venda efetuada com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo salvar model!");
        }

    }

    public void alterar(Venda ven) {
        try {

            VendaDAO.getInstance().alterar(ven);
            venda = new Venda();
            Messages.getInstance().adicionarMensagem(null, "Venda alterada com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo alterar!");

        }
    }

    public void excluir(Venda ved) {
        try {
            VendaDAO.getInstance().deletar(ved);
            venda = new Venda();
        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo salvar!");

        }
    }

    public void consultar(int id) {
        this.venda = VendaDAO.getInstance().recuperar(id);
    }
    
    public List<Venda> consultarTodos() {
        try {
            return VendaDAO.getInstance().recuperarTodos();
        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo consultarTodos!");

        }
        return null;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

}
