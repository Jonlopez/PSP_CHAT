/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chaton.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author 9fdam03
 */
public class ServerThread extends Thread {
    Socket socket;
    public ServerThread(Socket socket) {
      this.socket = socket;
    }
    
     public void run() 
    {
        BufferedReader br;
        try
        {
       // CREO FLUJO DE ENTRADA DEL CLIENTE
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String cadena = br.readLine();
            while(!cadena.equalsIgnoreCase("fin"))
            {
            //EL CLIENTE ME ENVIA UN MENSAJE
                System.out.println("Recibiendo del cliente: " + cadena);
                cadena = br.readLine();
            }
        
            br.close(); 
            socket.close();
        }catch(IOException e){}
    }
}
