/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import controller.Controller;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lazar
 */
public class PokreniServer extends Thread {
    private ServerSocket server;
    private boolean kraj=false;
    public PokreniServer() {
    }

    @Override
    public void run() {
        try {
            server=new ServerSocket(9000);
            System.out.println("SERVER JE PODIGNUT!");
            while(!kraj){
                System.out.println("SERVER CEKA KORISNIKE:...");
                Socket s;
                try {
                    s=server.accept();
                } catch (SocketException e) {
                    break;
                }

                System.out.println("KONEKCIJA USPOSTAVLJENA...");
                ObradaKlijentskihZahteva okz=new ObradaKlijentskihZahteva(s);
                
                okz.start();
            }
            
            System.out.println("Server ugasen");
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void zaustavi() {
        try {
            kraj=true;
            server.close();
            server=null;
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void zautsaviServer() {
        Controller.getInstance().stopServer();
        zaustavi();
    }
    
    
}
