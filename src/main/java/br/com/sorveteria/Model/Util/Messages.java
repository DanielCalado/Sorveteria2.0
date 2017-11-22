/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model.Util;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Jose Junio
 */
public class Messages {
    
    private static Messages message;
    
    private Messages(){
        
    }
    
    public static Messages getInstance(){
        
        if(message == null){
            message = new Messages();
        }
        
        return message;
    }
    
    public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, mensagem);
    }
    
    
}