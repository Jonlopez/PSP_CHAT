/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chaton.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 9fdam03
 */
public class Server {
    
    private Syn_online syn_online;
    int puerto;

    public Server(Syn_online syn_online, int puerto) throws IOException, InterruptedException {
          this.syn_online = syn_online;
          this.puerto = puerto;
          arrancarServidor();
    }

    /**
     * @param args the command line arguments
     */
    public void arrancarServidor() throws IOException, InterruptedException {
        ServerSocket serverSocket = null;
        boolean escuchando = true;
        
        ServerClientThread clientServerTh;
        
        //Syn_online syn_online = new Syn_online();
        
        System.out.println("El servidor va a escuchar por el puerto -> " + puerto);
        
        try {
            serverSocket = new ServerSocket(puerto);// crea socket servidor que escuchara en puerto 5500
        } catch (IOException e) {
            System.err.println("No puedo escuchar por el puerto: " + puerto);
            System.exit(-1);
        }
        //Creamos un bucle infinito para que se vayan creando nuevos sockets
        //cliente segun vayan llegando nuevas solicitudes
        while (escuchando)
        {
            System.out.println("Esperando una conexión...");
            
            //Inicia el socket, ahora esta esperando una conexión por parte del cliente
            clientServerTh = new ServerClientThread(serverSocket.accept(), this.syn_online);
            clientServerTh.start(); 
            
        }
        serverSocket.close();
    }
    
}
