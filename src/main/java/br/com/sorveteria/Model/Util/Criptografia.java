/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sorveteria.Model.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Fernando
 */
public class Criptografia{
   public static String criptografa(String senha){
     String s = "";
       String[] cri = {"Qs","Ka","Fs","29","aP","lO","jO","72","AS","ap"};
       for(int i = 0; i < senha.length(); i++){
         s += cri[i]; 
       }
       
         return s;
   }
    
}