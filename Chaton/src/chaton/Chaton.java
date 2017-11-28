/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chaton;

import chaton.model.ClientThread;
import chaton.model.ServerThread;
import chaton.model.Syn_online;
import chaton.view.VistaClient;
import chaton.view.VistaServer;
import javax.swing.JOptionPane;

/**
 *
 * @author 9fdam03
 */
public class Chaton {

    /**
     * @param args the command line arguments
     */
    
    public static Syn_online syn_online;
    public static ServerThread serverTh;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
       lanzarVista();
        
    }
    
    public static void lanzarVista(){
        String si = "Cliente"; //Aqui puede ir cualquier nombre 
        String no = "Servidor"; 
        String cancelar ="Estoy perdido, salir sin hacer nada"; 
        Object[] options ={si,no,cancelar}; 
        int res = JOptionPane.showOptionDialog(null, "¿Cómo deseas entrar?", "Chat On-line", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, cancelar); 
        
        switch(res){
            case 0:
                System.out.println("Cliente");
                VistaClient vC = new VistaClient(true);
                vC.setVisible(true);
                break;
            case 1:
                System.out.println("Servidor");
                VistaServer vS = new VistaServer(true);
                vS.setVisible(true);
                break;
            case 2:
                System.out.println("Salir sin hacer nada");
                break;
            default:
                System.out.println("Cierre de ventana inesperado");
        }
                
    }
    
    public static ServerThread lanzarServidor(int puerto){
        syn_online = new Syn_online();
        serverTh = new ServerThread(syn_online, puerto);
        serverTh.start();
        return serverTh;
    }
    
    public static ClientThread lanzarCliente(String nickname, String host, int puerto){
        ClientThread clientTh = new ClientThread(nickname, host, puerto);
        clientTh.start();
        return clientTh;
    }
    
    public static void cerrarConexionServidor(){
        
    }
    
    public static void cerrarConexionCliente(){
        
    }
    
}
