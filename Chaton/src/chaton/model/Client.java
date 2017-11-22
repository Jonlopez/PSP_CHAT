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
    final static String HOST = "localhost";
    final static int PUERTO = 9090;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Socket sc = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        //Cliente
        try 
        {
            sc = new Socket(HOST, PUERTO); //conectar a un servidor en localhost con puerto 5500
            //creamos el flujo de datos por el que se enviara un mensaje
            br= new BufferedReader(new InputStreamReader(System.in));
            pw =new PrintWriter(sc.getOutputStream(), true);
            
            String nickname = (String) JOptionPane.showInputDialog("Escribe tu nickname para esta sesión: ");
            pw.println(nickname);
            System.out.print(nickname + " escribe tu mensaje: ");
            
            String cadenaEnvio = br.readLine();
           
            while(!cadenaEnvio.equalsIgnoreCase("fin"))
            {
                pw.println(cadenaEnvio);
                System.out.print( nickname +" escribe tu mensaje: ");
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
    
}
