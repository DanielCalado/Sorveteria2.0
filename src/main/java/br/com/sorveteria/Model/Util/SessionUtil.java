/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model.Util;


import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jose Junio
 */
public class SessionUtil {
    private static SessionUtil instance;

        public static SessionUtil getInstance(){
        if(instance == null){
            instance = new SessionUtil();
        }
        return instance;
    }
    public static HttpSession getSession() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().
                getExternalContext().getSession(false);
        return session;

    }

    public static void inserirUsuarioSessao(String tipo, Object objeto) {
        getSession().setAttribute(tipo, objeto);
    }

    public static Object recuperarUsuarioSessao(String tipo, Object objeto) {
        return getSession().getAttribute(tipo);
    }

    public static void removerUsuarioSessao(String tipo, Object objeto) {
        getSession().removeAttribute(tipo);
    }

    public static void invalidate(String tipo, Object objeto) {
        getSession().invalidate();
    }
    public static String getParam(String nome){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        ExternalContext externalContext = facesContext.getExternalContext();
        
        Map<String, String> parametros = externalContext.getRequestParameterMap();
        
        String valor = parametros.get(nome);
        
        return valor;
    }
}