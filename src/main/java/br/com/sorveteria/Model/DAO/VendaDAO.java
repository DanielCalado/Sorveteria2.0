/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model.DAO;

import br.com.sorveteria.Model.DAO.Interfaces.GenericoDAO;
import br.com.sorveteria.Model.DAO.Interfaces.ProdutoInterfaceDAO;
import br.com.sorveteria.Model.Entidades.Produto;
import br.com.sorveteria.Model.Entidades.Venda;
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
public class VendaDAO implements GenericoDAO<Venda>{ 
    private static VendaDAO instance;
    private VendaDAO(){
    
} 
    public static VendaDAO getInstance(){
        if(instance == null){
            instance = new VendaDAO();
        }
        return instance;
    }
    @Override
    public void inserir(Venda ven) {
     //Pega uma session na fabrica de sessoes e armazena na variavel "sessao"
     Session sessao = HibernateUtil.getSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     sessao.save(ven);
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
    public void alterar(Venda ven) {
     //Pega uma session na fabrica de sessoes e armazena na variavel "sessao"
     Session sessao = HibernateUtil.getSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     sessao.update(ven);
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
public Venda recuperar(int id) {
      Session sessao = HibernateUtil.getSession();
     Venda ven = null;
     try{
        
         Query consulta = sessao.getNamedQuery("Venda.BuscarId");
         consulta.setInteger("id", id);
         ven = (Venda)consulta.uniqueResult();
     }catch (RuntimeException ex){
       throw ex;
        
    }finally{
         sessao.close();
     }
   return ven; 
     }

    @Override
    public void deletar(Venda ven) {
      Session sessao = HibernateUtil.getSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     Venda venda = recuperar(ven.getId());
     sessao.delete(venda);
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
    public List<Venda> recuperarTodos() {
     Session sessao = HibernateUtil.getSession();
     List<Venda> ven = null;
     try{
         sessao.beginTransaction();
         Query consulta = sessao.getNamedQuery("Venda.listar");
         ven = consulta.list();
     }catch (RuntimeException ex){
        sessao.getTransaction().commit();
        
    }finally{
         sessao.close();
     }
   return ven; 
    }



}

