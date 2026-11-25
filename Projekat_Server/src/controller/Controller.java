/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import sistemskeOperacije.SO_AbortKupac;
import sistemskeOperacije.SO_AbortLicenca;
import sistemskeOperacije.SO_AbortRacun;
import sistemskeOperacije.SO_DeclareKupac;
import sistemskeOperacije.SO_DeclareLicenca;
import sistemskeOperacije.SO_DeclareRacun;
import sistemskeOperacije.SO_DeleteKupac;
import sistemskeOperacije.SO_GetAllMesta;
import sistemskeOperacije.SO_GetAllProdavci;
import sistemskeOperacije.SO_GetAllRacuni;
import sistemskeOperacije.SO_LoginProdavac;
import sistemskeOperacije.SO_SaveRacun;
import sistemskeOperacije.SO_GetAllOprema;
import sistemskeOperacije.SO_GetAllKupci;
import sistemskeOperacije.SO_SaveKupac;
import sistemskeOperacije.SO_SaveLicenca;
import baza.DBBroker;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DomainObjectModel;
import model.Kupac;
import model.Licenca;
import model.Mesto;
import model.Oprema;
import model.Prodavac;
import model.Racun;
import server.ObradaKlijentskihZahteva;
import server.PokreniServer;

/**
 *
 * @author Lazar
 */
public class Controller {
    private static Controller instance;
    private DBBroker dbb;
    private List<ObradaKlijentskihZahteva> klijenti = Collections.synchronizedList(new ArrayList<>());
    
    private Controller (){
        dbb=new DBBroker();
        
    }

    public static Controller getInstance(){
        if(instance==null){
            instance=new Controller();
        }
        return instance;
    }

    public List<ObradaKlijentskihZahteva> getKlijenti() {
        return klijenti;
    }

    public void setKlijenti(List<ObradaKlijentskihZahteva> klijenti) {
        this.klijenti = klijenti;
    }

    public Prodavac login(Prodavac prodavac) throws Exception {
        SO_LoginProdavac so=new SO_LoginProdavac();
        so.execute(prodavac);
        return so.getResult();
        //return dbb.postojiProdavac(prodavac);
    }

    

    public void stopServer() {
        List<ObradaKlijentskihZahteva> kopija;
        synchronized (klijenti) {
            kopija = new ArrayList<>(klijenti);
        }
        for (ObradaKlijentskihZahteva k : kopija) {
            try {
                k.closeConnection();
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<Kupac> getAllKupci() throws Exception {
        SO_GetAllKupci so=new SO_GetAllKupci();
        so.execute(new Kupac());
        ArrayList<Kupac> list=new ArrayList<>();
        for (DomainObjectModel dom : so.getResult()) {
            list.add((Kupac)dom);
        }
        return list;
        //return dbb.getAllKupci();
    }

    public ArrayList<Oprema> getAllOprema() throws Exception {
        SO_GetAllOprema so=new SO_GetAllOprema();
        so.execute(new Oprema());
        ArrayList<Oprema> list=new ArrayList<>();
        for (DomainObjectModel dom : so.getResult()) {
            list.add((Oprema)dom);
        }
        return list;
        //return dbb.getAllOprema();
    }

    public Racun declareRacun(Racun racun) throws Exception {
        SO_DeclareRacun so=new SO_DeclareRacun();
        so.execute(racun);
        return so.getResult();
        //return dbb.declareRacun(racun);
    }

    public boolean saveRacun(Racun racun) throws Exception {
        SO_SaveRacun so=new SO_SaveRacun();
        so.execute(racun);
        return so.getResult();
        //return dbb.saveRacun(racun);
    }

    public boolean abortRacun(Racun racun) throws Exception {
        SO_AbortRacun so=new SO_AbortRacun();
        so.execute(racun);
        return so.getResult();
        //return dbb.abortRacun(racun);
    }

    /*public boolean draftRacun(Racun racun) {
        return dbb.draftRacun(racun);
    }*/

    public ArrayList<Racun> getAllRacuni() throws Exception {
        SO_GetAllRacuni so=new SO_GetAllRacuni();
        Racun dummy=new Racun();
        so.execute(dummy);
        return so.getResult();
        //return dbb.getAllRacuni();
    }

    public ArrayList<Prodavac> getAllProdavci() throws Exception {
        SO_GetAllProdavci so=new SO_GetAllProdavci();
        Prodavac dummy=new Prodavac();
        so.execute(dummy);
        return so.getResult();
        //return dbb.getAllProdavci();
    }

    public ArrayList<Mesto> getAllMesta() throws Exception {
        SO_GetAllMesta so=new SO_GetAllMesta();
        Mesto dummy=new Mesto();
        so.execute(dummy);
        return so.getResult();
        //return dbb.getAllMesta();
    }

    public Kupac declareKupac(Kupac kupac) throws Exception {
        SO_DeclareKupac so=new SO_DeclareKupac();
        so.execute(kupac);
        return so.getResult();
        //return dbb.declareKupac(kupac);
    }

    public DBBroker getDbb() {
        return dbb;
    }

    public void setDbb(DBBroker dbb) {
        this.dbb = dbb;
    }

    public void logoff(ObradaKlijentskihZahteva klijent) {
        klijenti.remove(klijent);
    }

    public boolean abortKupac(Kupac kupac) throws Exception {
        SO_AbortKupac so=new SO_AbortKupac();
        so.execute(kupac);
        return so.getResult();
    }

    public boolean saveKupac(Kupac kupac) throws Exception {
        SO_SaveKupac so=new SO_SaveKupac();
        so.execute(kupac);
        return so.getResult();
    }

    public boolean deleteKupac(Kupac kupac) throws Exception {
        SO_DeleteKupac so=new SO_DeleteKupac();
        so.execute(kupac);
        return so.getResult();
    }

    public Licenca declareLicenca(Licenca licenca) throws Exception {
        SO_DeclareLicenca so=new SO_DeclareLicenca();
        so.execute(licenca);
        return so.getResult();
    }

    public boolean saveLicenca(Licenca licenca) throws Exception {
        SO_SaveLicenca so=new SO_SaveLicenca();
        so.execute(licenca);
        return so.getResult();
    }

    public boolean abortLicenca(Licenca licenca) throws Exception {
        SO_AbortLicenca so=new SO_AbortLicenca();
        so.execute(licenca);
        return so.getResult();
    }

   
    
    
    
}
