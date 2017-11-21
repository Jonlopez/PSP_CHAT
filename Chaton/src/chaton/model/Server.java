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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
          ServerSocket serverSocket = null;
        boolean escuchando = true;
        final int PUERTO = 9090;
        ServerThread serverTh;
        
        
        try {
            serverSocket = new ServerSocket(PUERTO);// crea socket servidor que escuchara en puerto 5500
        } catch (IOException e) {
            System.err.println("No puedo escuchar por el puerto: 9090.");
            System.exit(-1);
        }
        //Creamos un bucle infinito para que se vayan creando nuevos sockets
        //cliente segun vayan llegando nuevas solicitudes
        while (escuchando)
        {
            System.out.println("Esperando una conexión...");
            
            //Inicia el socket, ahora esta esperando una conexión por parte del cliente
            serverTh = new ServerThread(serverSocket.accept());
            serverTh.start();             
            
            
        }
        serverSocket.close();
    }
    
}
