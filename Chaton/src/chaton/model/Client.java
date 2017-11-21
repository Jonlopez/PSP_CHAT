/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chaton.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

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
    public static void main(String[] args) {
         Socket sc;
        BufferedReader br;
        //Cliente
        try 
        {
            sc = new Socket(HOST, PUERTO); //conectar a un servidor en localhost con puerto 5500
            //creamos el flujo de datos por el que se enviara un mensaje
            br= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introduce texto a enviar al servidor");
            
            String cadenaEnvio = br.readLine();
            PrintWriter pw =new PrintWriter(sc.getOutputStream(), true);
            while(!cadenaEnvio.equalsIgnoreCase("fin"))
            {
                pw.println(cadenaEnvio);
                System.out.println("Introduce texto a enviar al servidor");
                cadenaEnvio = br.readLine();
            }
            pw.println(cadenaEnvio);
            //cerramos la conexión
                br.close();
                pw.close();
                sc.close();
        } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
        }
    }
    
}
