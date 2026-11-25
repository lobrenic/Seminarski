/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import komunikacija.Komunikacija;
import model.Prodavac;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Lazar
 */
public class Controller {
    private static Controller instance;
    private Prodavac ulogovani;
    
    private Controller(){
        
    }
    public static Controller getInstance(){
        if(instance==null){
            instance=new Controller();
        }
        return instance;
    }

    public Prodavac getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Prodavac ulogovani) {
        this.ulogovani = ulogovani;
    }
    
    public void posaljiZahtev(KlijentskiZahtev kz){
        Komunikacija.getInstance().posaljiZahtev(kz);
    }
    
    public ServerskiOdgovor primiOdgovor(){
        return Komunikacija.getInstance().primiOdgovor();
    }
}
