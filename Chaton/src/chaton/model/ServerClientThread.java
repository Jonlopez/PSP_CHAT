/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chaton.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 9fdam03
 */
public class ServerClientThread extends Thread {
    Socket socket = null;
    String nickname;
    Syn_online syn_online;
    
    public ServerClientThread(Socket socket, Syn_online syn_online) throws IOException {
        this.syn_online = syn_online;
        
        this.socket = socket;     
    } 
    
     public void run() 
    {
        BufferedReader br = null;
        PrintWriter pw = null;

        try
        {
       // CREO FLUJO DE ENTRADA DEL CLIENTE
            
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           
            String cadena = br.readLine();
            
            if(cadena != null && cadena != "")
                this.nickname = (String) cadena;                      
            
            this.syn_online.conectarUsuario(nickname);     
            
            System.out.println("USUARIOS CONECTADOS -> " + syn_online.getNum_users());
            
            cadena = br.readLine();
            
            while(!cadena.equalsIgnoreCase("fin"))
            {
                if(cadena != ""){
                    //EL CLIENTE ME ENVIA UN MENSAJE
                    System.out.println("El usuario " + this.nickname + " dice: " + cadena);                     
                    cadena = br.readLine();
                }
                
            }      
            
            this.syn_online.desconectarUsuario(nickname);        
            System.out.println("USUARIOS CONECTADOS -> " + syn_online.getNum_users());
            
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            try {
                if(br != null)
                    br.close();
                if(socket != null)
                    socket.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
}
