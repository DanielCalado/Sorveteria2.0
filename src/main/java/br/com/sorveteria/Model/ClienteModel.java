/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model;

import br.com.sorveteria.Model.Util.Messages;
import br.com.sorveteria.Model.DAO.ClienteDAO;
import br.com.sorveteria.Model.Entidades.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aluno
 */
public class ClienteModel{

    private Cliente cliente = new Cliente();

    public ClienteModel() {

    }

    public void salvar(Cliente cli) {
        try {
            
            Cliente novo = ClienteDAO.getInstance().recuperarPorCPF(cli.getCpf());
            if (novo == null) {
                ClienteDAO.getInstance().inserir(cli);
                cliente = new Cliente();
                Messages.getInstance().adicionarMensagem(null, "Cliente cadastrado com sucesso!", FacesMessage.SEVERITY_INFO);

            } else {
                Messages.getInstance().adicionarMensagem(null, "CPF já cadastrado!", FacesMessage.SEVERITY_WARN);

            }
        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo salvar model!");
        }

    }

    public void alterar(Cliente cli) {
        try {

            ClienteDAO.getInstance().alterar(cli);
            cliente = new Cliente();
            Messages.getInstance().adicionarMensagem(null, "Cliente alterado com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo alterar!");

        }
    }

    public void excluir() {
        try {
            ClienteDAO.getInstance().deletar(cliente);
            cliente = new Cliente();
        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo Excluir!");

        }
    }

    public void consultar(int codigo) {
        this.cliente = ClienteDAO.getInstance().recuperar(codigo);

    }
    public void consultarPorCPF(String cpf) {
        this.cliente = ClienteDAO.getInstance().recuperarPorCPF(cpf);

    }
    public List<Cliente> consultarTodos() {
        try {
            return ClienteDAO.getInstance().recuperarTodos();
        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo consultarTodos!");

        }
        return null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
