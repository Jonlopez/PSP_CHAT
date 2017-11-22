/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chaton;

import chaton.model.Syn_online;
import chaton.view.VistaPrincipal;

/**
 *
 * @author 9fdam03
 */
public class Chaton {

    /**
     * @param args the command line arguments
     */
    
    private static Syn_online syn_online;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        lanzarServidor();
        lanzarVista();
    }
    
    public static void lanzarVista(){
        syn_online = new Syn_online();
        VistaPrincipal vP = new VistaPrincipal(syn_online);        
        vP.setVisible(true);
    }
    
    public static void lanzarServidor(){
        
    }
    
}
