/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model.DAO;

import br.com.sorveteria.Model.DAO.Interfaces.FuncionarioInterfaceDAO;
import br.com.sorveteria.Model.Entidades.Funcionario;
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
public class FuncionarioDAO implements FuncionarioInterfaceDAO{ 
    private static FuncionarioDAO instance;
    public FuncionarioDAO(){
    
} 
    public static FuncionarioDAO getInstance(){
        if(instance == null){
            instance = new FuncionarioDAO();
        }
        return instance;
    }
    @Override
    public void inserir(Funcionario fun) {
     //Pega uma session na fabrica de sessoes e armazena na variavel "sessao"
     Session sessao = HibernateUtil.getSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     sessao.save(fun);
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
    public void alterar(Funcionario fun) {
     //Pega uma session na fabrica de sessoes e armazena na variavel "sessao"
     Session sessao = HibernateUtil.getSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
     sessao.update(fun);
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
public Funcionario recuperar(int id) {
      Session sessao = HibernateUtil.getSession();
     Funcionario fun = null;
     try{
        
         Query consulta = sessao.getNamedQuery("Funcionario.BuscarCodigo");
         consulta.setInteger("id", id);
         fun = (Funcionario) consulta.uniqueResult();
     }catch (RuntimeException ex){
       throw ex;
        
    }finally{
         sessao.close();
     }
   return fun; 
     }

    @Override
    public void deletar(Funcionario fun) {
      Session sessao = HibernateUtil.getSession();
     Transaction transacao = null;
    
     try{
     transacao = sessao.beginTransaction();
        Funcionario funcionario = recuperar(fun.getId());
     sessao.delete(funcionario);
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
    public List<Funcionario> recuperarTodos() {
     Session sessao = HibernateUtil.getSession();
     List<Funcionario> fun = null;
     try{
         sessao.beginTransaction();
         Query consulta = sessao.getNamedQuery("Funcionario.listar");
         fun = consulta.list();
     }catch (RuntimeException ex){
        sessao.getTransaction().commit();
        
    }finally{
         sessao.close();
     }
   return fun; 
    }

    @Override
    public Funcionario recuperarPorCPF(String cpf) {
    Session sessao = HibernateUtil.getSession();
     Funcionario fun = null;
     try{
        
         Query consulta = sessao.getNamedQuery("Funcionario.BuscarCPF");
         consulta.setString("cpf", cpf);
         fun = (Funcionario)consulta.uniqueResult();
     }catch (RuntimeException ex){
       throw ex;
        
    }finally{
         sessao.close();
     }
   return fun; 
    }
    @Override
    public Funcionario recuperarLogin(String login) {
    Session sessao = HibernateUtil.getSession();
     Funcionario fun = null;
     try{
        
         Query consulta = sessao.getNamedQuery("Funcionario.BuscarLogin");
         consulta.setString("login", login);
         fun = (Funcionario)consulta.uniqueResult();
     }catch (RuntimeException ex){
       throw ex;
        
    }finally{
         sessao.close();
     }
   return fun; 
    }

}
