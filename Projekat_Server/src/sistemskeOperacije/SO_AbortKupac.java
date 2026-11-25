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
public class SO_AbortKupac extends GenericSO {
    private boolean success;
    @Override
    protected void validate(DomainObjectModel dom) throws Exception {
        if(dom==null || !(dom instanceof Kupac))
            throw new Exception("Prosledjeni objekat nije instance klase Kupac");
        Kupac kupac=(Kupac)dom;
        if(kupac.getId()==-1)
            throw new Exception("Greska sa parametrom Id");
    }

    @Override
    protected void executeOp(DomainObjectModel dom) throws Exception {
        int aRows=Controller.getInstance().getDbb().delete(dom);
        if(aRows<=0){
            rollback();
            success=false;
            return;
        }
        success=true;
    }
    public boolean getResult(){
        return success;
    }
}
