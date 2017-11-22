/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model.DAO.Interfaces;

import br.com.sorveteria.Model.Entidades.Funcionario;

/**
 *
 * @author Aluno
 */
public interface FuncionarioInterfaceDAO extends GenericoDAO<Funcionario>{
  
        public Funcionario recuperarPorCPF(String cpf);
        public Funcionario recuperarLogin(String login);

}
