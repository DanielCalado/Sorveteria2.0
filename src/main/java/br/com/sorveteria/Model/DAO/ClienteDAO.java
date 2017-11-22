/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model.DAO;

import br.com.sorveteria.Model.DAO.Interfaces.GenericoDAO;
import br.com.sorveteria.Model.DAO.Interfaces.ClienteInterfaceDAO;
import br.com.sorveteria.Model.Entidades.Cliente;
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
public class ClienteDAO implements ClienteInterfaceDAO{ 
    private static ClienteDAO instance;
    public ClienteDAO(){
    
} 
    public static ClienteDAO getInstance(){
        if(instance == null){
            instance = new ClienteDAO();
        }
        return instance;
    }
    @Override
    public void inserir(Cliente cli) {
     //Pega uma session na fabrica de sessoes e armazena na variavel "sessao"
     Session sessao = HibernateUtil.getSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     sessao.save(cli);
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
    public void alterar(Cliente cli) {
     //Pega uma session na fabrica de sessoes e armazena na variavel "sessao"
     Session sessao = HibernateUtil.getSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     sessao.update(cli);
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
public Cliente recuperar(int id) {
      Session sessao = HibernateUtil.getSession();
     Cliente cli = null;
     try{
        
         Query consulta = sessao.getNamedQuery("Cliente.BuscarCodigo");
         consulta.setInteger("id", id);
         cli = (Cliente) consulta.uniqueResult();
     }catch (RuntimeException ex){
       throw ex;
        
    }finally{
         sessao.close();
     }
   return cli; 
     }

    @Override
    public void deletar(Cliente cli) {
      Session sessao = HibernateUtil.getSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     Cliente cliente = recuperar(cli.getId());
     sessao.delete(cliente);
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
    public List<Cliente> recuperarTodos() {
     Session sessao = HibernateUtil.getSession();
     List<Cliente> cli = null;
     try{
         sessao.beginTransaction();
         Query consulta = sessao.getNamedQuery("Cliente.listar");
         cli = consulta.list();
     }catch (RuntimeException ex){
        sessao.getTransaction().commit();
        
    }finally{
         sessao.close();
     }
   return cli; 
    }

    @Override
    public Cliente recuperarPorCPF(String cpf) {
    Session sessao = HibernateUtil.getSession();
     Cliente cli = null;
     try{
        
         Query consulta = sessao.getNamedQuery("Cliente.BuscarCPF");
         consulta.setString("cpf", cpf);
         cli = (Cliente)consulta.uniqueResult();
     }catch (RuntimeException ex){
       throw ex;
        
    }finally{
         sessao.close();
     }
   return cli; 
    }

}
