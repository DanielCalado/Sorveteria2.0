/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model.Util;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Session;
/**
 *
 * @author Aluno
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private HibernateUtil(){
        
    }

    private static SessionFactory getSessionFactory(){
        try {
            // Cria um sessionFactory a partir do hibernate.cfg.xml
           if(sessionFactory == null){
            Configuration configuration = new Configuration();
            configuration.configure();
            
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
             sessionFactory = configuration.buildSessionFactory(serviceRegistry);
           }
        }
        catch (Throwable ex) {
            // Exibe uma mesagem de erro
            System.err.println("Falha ao tentar criar o sessionFactory." + ex);
            throw new ExceptionInInitializerError(ex);
        }finally{
        return sessionFactory;

        }
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }
}
