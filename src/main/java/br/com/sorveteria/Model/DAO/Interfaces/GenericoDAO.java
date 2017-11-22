/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model.DAO.Interfaces;

import java.util.List;

/**
 *
 * @author Aluno
 */
public interface GenericoDAO <T>{
    public void inserir(T t);
    public void alterar(T t);
    public void deletar(T t);
    public T recuperar(int id);
    public List<T> recuperarTodos();
    
}
