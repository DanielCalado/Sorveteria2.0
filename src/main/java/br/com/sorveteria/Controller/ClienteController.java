/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Controller;

import br.com.sorveteria.Model.ClienteModel;
import br.com.sorveteria.Model.Entidades.Cliente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aluno
 */
@ManagedBean
@SessionScoped
public class ClienteController {
    private ClienteModel model = null;
    private Cliente cliente;
    
public ClienteController(){
    model =new ClienteModel();
    cliente = new Cliente();
}

public void inserir(){
    model.salvar(cliente);
}
public void alterar(){
    model.alterar(cliente);
}
public void excluir(){
    model.excluir();
}
public void consultar(){
    model.consultar(cliente.getId());
}
public void consultarCPF(){
    model.consultarPorCPF(cliente.getCpf());
}
public List<Cliente> buscarTodos(){
    return model.consultarTodos();
}

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
