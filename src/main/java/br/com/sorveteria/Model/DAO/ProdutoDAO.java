/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model.DAO;

import br.com.sorveteria.Model.DAO.Interfaces.GenericoDAO;
import br.com.sorveteria.Model.DAO.Interfaces.ProdutoInterfaceDAO;
import br.com.sorveteria.Model.Entidades.Produto;
import br.com.sorveteria.Model.Util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aluno
 */
public class ProdutoDAO implements Serializable,ProdutoInterfaceDAO{ 
    private static ProdutoDAO instance;
    private ProdutoDAO(){
    
} 
    public static ProdutoDAO getInstance(){
        if(instance == null){
            instance = new ProdutoDAO();
        }
        return instance;
    }
    @Override
    public void inserir(Produto pro) {
     //Pega uma session na fabrica de sessoes e armazena na variavel "sessao"
     Session sessao = HibernateUtil.getSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     sessao.save(pro);
     sessao.getTransaction().commit();
     
    }catch (RuntimeException ex){
        if(transacao != null){
            //desfaz a transacao
            transacao.rollback();
        }
    }finally{
         sessao.close();
     }
    }
    @Override
    public void alterar(Produto pro) {
     //Pega uma session na fabrica de sessoes e armazena na variavel "sessao"
     Session sessao = HibernateUtil.getSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     sessao.update(pro);
     sessao.getTransaction().commit();
     
    }catch (RuntimeException ex){
        if(transacao != null){
            //desfaz a transacao
            transacao.rollback();
        }
    }finally{
         sessao.close();
     }
    }
    
    /**
     *
     * @param id
     * @return
     */
    @Override
public Produto recuperar(int id) {
      Session sessao = HibernateUtil.getSession();
     Produto pro = null;
     try{
        
         Query consulta = sessao.getNamedQuery("Produto.BuscarCodigo");
         consulta.setInteger("codigo", id);
         pro = (Produto) consulta.uniqueResult();
     }catch (RuntimeException ex){
       throw ex;
        
    }finally{
         sessao.close();
     }
   return pro; 
     }

    @Override
    public void deletar(Produto pro) {
      Session sessao = HibernateUtil.getSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     Produto produto = recuperar(pro.getCodigo());
     sessao.delete(produto);
     sessao.getTransaction().commit();
     
    }catch (RuntimeException ex){
        if(transacao != null){
            transacao.rollback();
        }
    }finally{
         sessao.close();
     }
    }
    

    @Override
    public List<Produto> recuperarTodos() {
     Session sessao = HibernateUtil.getSession();
     List<Produto> pro = null;
     try{
         sessao.beginTransaction();
         Query consulta = sessao.getNamedQuery("Produto.listar");
         pro = consulta.list();
     }catch (RuntimeException ex){
        sessao.getTransaction().commit();
        
    }finally{
         sessao.close();
     }
   return pro; 
    }

    @Override
    public List<Produto> recuperarPorNome(String nome) {
    Session sessao = HibernateUtil.getSession();
     List<Produto> pro = null;
     try{
        
         Query consulta = sessao.getNamedQuery("Produto.BuscarNome");
         consulta.setParameter("nome", nome + "%");
         pro = consulta.list();
     }catch (RuntimeException ex){
       throw ex;
        
    }finally{
         sessao.close();
     }
   return pro; 
    }

}
