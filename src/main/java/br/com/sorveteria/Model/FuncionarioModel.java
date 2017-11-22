/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model;

import br.com.sorveteria.Model.Util.Criptografia;
import br.com.sorveteria.Model.Util.Messages;
import br.com.sorveteria.Model.DAO.FuncionarioDAO;
import br.com.sorveteria.Model.Entidades.Funcionario;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Aluno
 */

public class FuncionarioModel{

    private Funcionario funcionario = new Funcionario();

    public FuncionarioModel() {

    }

    public void salvar(Funcionario fun) {
        try {

            Funcionario novo = FuncionarioDAO.getInstance().recuperarPorCPF(fun.getCpf());

            if (novo == null) {
                fun.setSenha(Criptografia.criptografa(fun.getSenha()));
                FuncionarioDAO.getInstance().inserir(fun);
                funcionario = new Funcionario();
                Messages.getInstance().adicionarMensagem(null, "Funcionario cadastrado com sucesso!", FacesMessage.SEVERITY_INFO);
                novo = new Funcionario();
            } else {
                Messages.getInstance().adicionarMensagem(null, "CPF já cadastrado!", FacesMessage.SEVERITY_WARN);

            }
        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo salvar model!");
        }

    }

    public void alterar(Funcionario fun) {
        try {

            FuncionarioDAO.getInstance().alterar(fun);
            funcionario = new Funcionario();
            Messages.getInstance().adicionarMensagem(null, "Funcionario alterado com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo alterar!");

        }
    }

    public void excluir() {
        try {
            FuncionarioDAO.getInstance().deletar(funcionario);
            funcionario = new Funcionario();
        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo Excluir!");

        }
    }

    public void consultar(int id) {
        this.funcionario = FuncionarioDAO.getInstance().recuperar(id);

    }

    public void consultarPorCPF(String cpf) {
        this.funcionario = FuncionarioDAO.getInstance().recuperarPorCPF(cpf);

    }

    public List<Funcionario> consultarTodos() {
        try {
            return FuncionarioDAO.getInstance().recuperarTodos();
        } catch (Exception ex) {
            System.out.println("Erro ao executar metodo consultarTodos!");

        }
        return null;
    }
    private Funcionario logado = new Funcionario();
    public String validaLogin(String login, String senha) {
        Funcionario novo = FuncionarioDAO.getInstance().recuperarLogin(login);
        if (novo == null) {
            Messages.getInstance().adicionarMensagem(null, "Erro ao efetuar Login!"
                    + " confira login e senha!", FacesMessage.SEVERITY_ERROR);
            return null;
        } else {
            if (novo.getSenha().equals(Criptografia.criptografa(senha))) {
                this.logado = novo;
                Messages.getInstance().adicionarMensagem(null, "Login Efetuado com sucesso!", FacesMessage.SEVERITY_INFO);
                Messages.getInstance().adicionarMensagem(null, "Bem Vindo", FacesMessage.SEVERITY_INFO);
                return "menu.xhtml";
            }else{
                return null;
            }
        }
    }
    public String logout(){
        this.logado = null;
        return "login.xhtml";
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
