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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 9fdam03
 */
public class ServerThread extends Thread {
    Socket socket = null;
    String nickname;
    
    public ServerThread(Socket socket) throws IOException {
      this.socket = socket;
      this.nickname = findNickName();      
    }
    
    private String findNickName() throws IOException{
        
         BufferedReader br = null;
         String str = "";
       /* try
        {
       // CREO FLUJO DE ENTRADA DEL CLIENTE
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String cadena = br.readLine();
             
            str = (String) cadena.split("_")[0]; 
            //cadena = br.readLine();                    
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{           
            if(br != null)
                br.close();  
        }*/
        
        return str;
    }
    
     public void run() 
    {
        BufferedReader br = null;
        try
        {
       // CREO FLUJO DE ENTRADA DEL CLIENTE
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String cadena = br.readLine();
            
            this.nickname = (String) cadena.split("_")[0];
            String mensaje = (String) cadena.split("_")[1];
            
            System.out.println("El cliente " + this.nickname + " se ha conectado.");
            
            while(!cadena.equalsIgnoreCase("fin"))
            {
            //EL CLIENTE ME ENVIA UN MENSAJE
                System.out.println("El usuario " + this.nickname + " dice: " + mensaje);
                cadena = br.readLine();
            }        
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            try {
                if(br != null)
                    br.close();
                if(socket != null)
                    socket.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
