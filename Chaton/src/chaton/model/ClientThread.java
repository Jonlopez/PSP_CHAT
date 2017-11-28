/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chaton.model;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jon
 */
public class ClientThread extends Thread{
    
    private Client cliente;
    String nickname;
    String host;
    int puerto;

    public ClientThread(String nickname, String host, int puerto) {
        this.nickname = nickname;
        this.host = host;
        this.puerto = puerto;
        
    }

    @Override
    public void run() {
        try {
            this.cliente = new Client(nickname, host, puerto);
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Client getCliente(){
        return this.cliente;
    }

    public String getNickname() {
        return nickname;
    }
    
    
}
