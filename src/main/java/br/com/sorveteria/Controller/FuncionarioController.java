/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Controller;

import br.com.sorveteria.Model.Entidades.Funcionario;
import br.com.sorveteria.Model.FuncionarioModel;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aluno
 */
@ManagedBean
@SessionScoped
public class FuncionarioController {
    private FuncionarioModel model = null;
    private Funcionario funcionario;
    private List<Funcionario> listadeFuncionarios = null;
    
public FuncionarioController(){
    model =new FuncionarioModel();
    funcionario = new Funcionario();
    listadeFuncionarios = new ArrayList<>();
}

public void inserir(){
    model.salvar(funcionario);
}
public void alterar(){
    model.alterar(funcionario);
}
public void excluir(){
    model.excluir();
}
public void consultar(){
    model.consultar(funcionario.getId());
}
public void consultarCPF(){
    model.consultarPorCPF(funcionario.getCpf());
}
public void buscarTodos(){
    listadeFuncionarios = model.consultarTodos();
}
public String login(){
    model.validaLogin(funcionario.getLogin(),funcionario.getSenha());
return "menu.xhtml";
}
public String logout(){
    model.logout();
 return "Login.xhtml";
  
}
public void limpar(){
    funcionario = new Funcionario();
}

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
