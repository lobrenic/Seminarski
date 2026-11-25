/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemskeOperacije;

import controller.Controller;
import model.DomainObjectModel;
import model.Kupac;

/**
 *
 * @author Lazar
 */
public class SO_SaveKupac extends GenericSO {
    private boolean result;
    @Override
    protected void validate(DomainObjectModel dom) throws Exception {
        if(dom==null || !(dom instanceof Kupac))
            throw new Exception("Prosledjeni objekat nije instance klase Kupac");
        Kupac kupac=(Kupac)dom;
        if(kupac.getId()==-1)
            throw new Exception("Greska sa parametrom Id");
        if(kupac.getBroj()==-1)
            throw new Exception("Greska sa parametrom Broj");
        if(kupac.getIme()==null || kupac.getIme().isEmpty())
            throw new Exception("Greska sa parametrom Ime");
        if(kupac.getPrezime()==null || kupac.getPrezime().isEmpty())
            throw new Exception("Greska sa parametrom Prezime");
        if(kupac.getTelefon()==null || kupac.getTelefon().isEmpty())
            throw new Exception("Greska sa parametrom Telefon");
        if(kupac.getUlica()==null || kupac.getUlica().isEmpty())
            throw new Exception("Greska sa parametrom Ulica");
        if(kupac.getMesto()==null)
            throw new Exception("Greska sa parametrom Mesto");
            
    }
    

    @Override
    protected void executeOp(DomainObjectModel dom) throws Exception {
        int aRows= Controller.getInstance().getDbb().update(dom);
        if(aRows<=0){
            rollback();
        }
        result=aRows>0;
    }
    public boolean getResult(){
        return result;
    }
}
