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
import javax.swing.JOptionPane;

/**
 *
 * @author 9fdam03
 */
public class Client {
        
    //podemos usar el nombre del host o una InetAddress
    String host = "localhost";
    int puerto = 9090;
    
    Socket sc = null;
    BufferedReader br = null;
    PrintWriter pw = null;

    String nickname = "fulano";
    String cadena = "";
    
    public Client(String nickname, String host, int puerto) throws IOException {
        this.nickname = nickname;
        this.host = host;
        this.puerto = puerto;
        arrancarCliente();
    }      

    /**
     * @param args the command line arguments
     */
    public void arrancarCliente() throws IOException {
      
        //Cliente
        try 
        {
            sc = new Socket(host, puerto);
            //creamos el flujo de datos por el que se enviara un mensaje
            br= new BufferedReader(new InputStreamReader(System.in));
            pw =new PrintWriter(sc.getOutputStream(), true);
            
            pw.println(this.nickname);       
            System.out.print(nickname + " escribe tu mensaje: ");            
            
            String cadenaEnvio = br.readLine();
           
            while(!cadenaEnvio.equalsIgnoreCase("fin"))
            {  
                pw.println(cadenaEnvio);
                System.out.print( nickname +" escribe tu mensaje: " );
                cadenaEnvio = br.readLine();
            }
         
            pw.println(cadenaEnvio);
                   
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }finally{
            //cerramos la conexión
            if(br != null)
                br.close();
            if(pw != null)
                pw.close();
            if(sc != null)
                sc.close();
        }
    }
    
    public void solicitarMensaje(String sms){
        
    }
    
    public void enviarMensaje(String sms) throws IOException{        
        this.cadena = sms;
    }
    
}
