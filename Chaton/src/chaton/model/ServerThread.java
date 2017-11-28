/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chaton.model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jon
 */
public class ServerThread extends Thread{
    
    private Server server;
    private Syn_online syn_online;
    int puerto;

    public ServerThread(Syn_online syn_online, int puerto) {
        this.syn_online = syn_online;
        this.puerto = puerto;
    }

    @Override
    public void run() {
        
        System.out.println("Arranca RUN de hilo server");
        try {
            this.server = new Server(this.syn_online, this.puerto);
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Server getServer() {
        return server;
    }
    
}
