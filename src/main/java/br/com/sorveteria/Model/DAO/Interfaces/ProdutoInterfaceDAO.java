/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model.DAO.Interfaces;

import br.com.sorveteria.Model.Entidades.Produto;
import java.util.List;

/**
 *
 * @author Aluno
 */
public interface ProdutoInterfaceDAO extends GenericoDAO<Produto>{
  
        public List<Produto> recuperarPorNome(String nome);

}
