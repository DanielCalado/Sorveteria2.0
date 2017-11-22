/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model.DAO;

import br.com.sorveteria.Model.DAO.Interfaces.GenericoDAO;
import br.com.sorveteria.Model.Entidades.ItensVenda;
import br.com.sorveteria.Model.Entidades.Venda;
import br.com.sorveteria.Model.Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Aluno
 */
public class ItemVendaDAO implements GenericoDAO<ItensVenda>{ 
    private static ItemVendaDAO instance;
    private ItemVendaDAO(){
    
} 
    public static ItemVendaDAO getInstance(){
        if(instance == null){
            instance = new ItemVendaDAO();
        }
        return instance;
    }
    @Override
 public void inserir(ItensVenda itv) {
     //Pega uma session na fabrica de sessoes e armazena na variavel "sessao"
     Session sessao = HibernateUtil.getSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     sessao.save(itv);
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
    public void alterar(ItensVenda itv) {
     //Pega uma session na fabrica de sessoes e armazena na variavel "sessao"
     Session sessao = HibernateUtil.getSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     sessao.update(itv);
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
public ItensVenda recuperar(int id) {
      Session sessao = HibernateUtil.getSession();
     ItensVenda itv = null;
     try{
        
         Query consulta = sessao.getNamedQuery("ItensVenda.BuscarId");
         consulta.setInteger("id", id);
         itv = (ItensVenda)consulta.uniqueResult();
     }catch (RuntimeException ex){
       throw ex;
        
    }finally{
         sessao.close();
     }
   return itv; 
     }

    @Override
    public void deletar(ItensVenda itv) {
      Session sessao = HibernateUtil.getSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     ItensVenda itensVenda = recuperar(itv.getId());
     sessao.delete(itensVenda);
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
    public List<ItensVenda> recuperarTodos() {
     Session sessao = HibernateUtil.getSession();
     List<ItensVenda> itv = null;
     try{
         sessao.beginTransaction();
         Query consulta = sessao.getNamedQuery("ItensVenda.listar");
         itv = consulta.list();
     }catch (RuntimeException ex){
        sessao.getTransaction().commit();
        
    }finally{
         sessao.close();
     }
   return itv; 
    }



}

