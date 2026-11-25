/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import controller.Controller;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Kupac;
import model.Licenca;
import model.Mesto;
import model.Oprema;
import model.Prodavac;
import model.Racun;
import static operacije.Operacije.GET_ALL_KUPCI;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Lazar
 */
public class ObradaKlijentskihZahteva extends Thread {
    private Socket s;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private String username;
    private int userId;
    

    public ObradaKlijentskihZahteva(Socket s) {
        this.s = s;
        
    }

    @Override
    public void run() {
        try {
            ois = new ObjectInputStream(s.getInputStream());  
            oos = new ObjectOutputStream(s.getOutputStream());  
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(!s.isClosed()){
            ServerskiOdgovor so=new ServerskiOdgovor();
            try {
                KlijentskiZahtev kz=primiZahtev();
                if(kz==null){
                    break;
                }
                
                boolean success=false;
                switch (kz.getOperacija()) {
                    case LOGIN:
                        Prodavac p=Controller.getInstance().login((Prodavac)kz.getParam());
                        if(p.getId()!=-1){
                            username=p.getUsername();
                            userId=p.getId();
                            Controller.getInstance().getKlijenti().add(this);
                            System.out.println("KLIJENT "+username+" JE POVEZAN!");
                        }
                        so.setParam(p);
                        break;
                    case LOGOFF:
                        odjaviKlijenta(so);
                        continue;
                    case GET_ALL_KUPCI:
                        ArrayList<Kupac> kupci=Controller.getInstance().getAllKupci();
                        so.setParam(kupci);
                        break;
                    case GET_ALL_OPREMA:
                        ArrayList<Oprema> oprema=Controller.getInstance().getAllOprema();
                        so.setParam(oprema);
                        break;
                    case DECLARATION_RACUN:
                        Racun r=Controller.getInstance().declareRacun((Racun)kz.getParam());
                        so.setParam(r);
                        break;
                    case ISSUE_RACUN:
                        success=Controller.getInstance().saveRacun((Racun)kz.getParam());
                        so.setParam(success);
                        break;
                    case ABORT_RACUN:
                        success=Controller.getInstance().abortRacun((Racun)kz.getParam());
                        so.setParam(success);
                        break;
                   /* case DRAFT_RACUN:
                        boolean uspeh2=Controller.getInstance().draftRacun((Racun)kz.getParam());
                        so.setParam(uspeh2);
                        break;*/
                    case GET_ALL_RACUNI:
                        ArrayList<Racun> racuni=Controller.getInstance().getAllRacuni();
                        so.setParam(racuni);
                        break;
                    case GET_ALL_PRODAVCI:
                        ArrayList<Prodavac> prodavci=Controller.getInstance().getAllProdavci();
                        so.setParam(prodavci);
                        break;
                    case GET_ALL_MESTA:
                        ArrayList<Mesto> mesta=Controller.getInstance().getAllMesta();
                        so.setParam(mesta);
                        break;
                    case DECLARATION_KUPAC:
                        Kupac k=Controller.getInstance().declareKupac((Kupac)kz.getParam());
                        so.setParam(k);
                        break;
                    case ABORT_KUPAC:
                        success=Controller.getInstance().abortKupac((Kupac)kz.getParam());
                        so.setParam(success);
                        break;
                    case SAVE_KUPAC:
                        success=Controller.getInstance().saveKupac((Kupac)kz.getParam());
                        so.setParam(success);
                        break;
                    case DELETE_KUPAC:
                        success=Controller.getInstance().deleteKupac((Kupac)kz.getParam());
                        so.setParam(success);
                        break;
                    case DECLARATION_LICENCA:
                        Licenca licenca=Controller.getInstance().declareLicenca((Licenca)kz.getParam());
                        so.setParam(licenca);
                        break;
                    case SAVE_LICENCA:
                        success=Controller.getInstance().saveLicenca((Licenca)kz.getParam());
                        so.setParam(success);
                        break;
                    case ABORT_LICENCA:
                        success=Controller.getInstance().abortLicenca((Licenca)kz.getParam());
                        so.setParam(success);
                        break;
                    default:
                        throw new AssertionError();
                }
                if(so.getParam()!=null)
                    posaljiOdgovor(so);
              }catch (EOFException ex) {
                try {
                    System.out.println("KLIJENT "+username+" SE ODVEZAO!");
                    Controller.getInstance().logoff(this);
                    closeConnection();
                } catch (IOException ex1) {
                    Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } catch (SocketException ex) {
                try {
                    System.out.println("KLIJENT "+username+" SE ODVEZAO!");
                    Controller.getInstance().logoff(this);
                    closeConnection();
                } catch (IOException ex1) {
                    Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } catch (Exception ex) {
                so.setException(ex);
                posaljiOdgovor(so);
            }
        }
    }
    
    public KlijentskiZahtev primiZahtev() throws EOFException, SocketException{
        try {
            return (KlijentskiZahtev) ois.readObject();
        }catch(SocketException e){
            throw e;
        }catch(EOFException ex){
            throw ex;
        }catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void posaljiOdgovor(ServerskiOdgovor so){
        try {
            oos.writeObject(so);
            oos.flush();
            oos.reset();
            
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void closeConnection() throws IOException {
        s.close();
    }

    private void odjaviKlijenta(ServerskiOdgovor so) {
        so.setParam(Boolean.TRUE);
        System.out.println("KLIJENT " + username + " JE ODJAVLJEN!");
        Controller.getInstance().logoff(this);
        posaljiOdgovor(so);
        try {
            closeConnection();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
