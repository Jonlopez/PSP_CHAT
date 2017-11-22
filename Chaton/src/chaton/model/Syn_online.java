/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chaton.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 9fdam03
 */
public class Syn_online {
    
    private int num_users = 0;

    public Syn_online() {
        
    }      

    public int getNum_users() {
        return num_users;
    }
    
    
     public synchronized void conectarUsuario(String nickname){
      System.out.println("El cliente " + nickname + " se ha CONECTADO.");
        this.num_users += 1;
        notifyAll();
    }
    
    public synchronized void desconectarUsuario(String nickname){
       System.out.println("El cliente " + nickname + " se ha DESCONECTADO.");
        this.num_users -= 1;
        notifyAll();
    }

    
    
}
