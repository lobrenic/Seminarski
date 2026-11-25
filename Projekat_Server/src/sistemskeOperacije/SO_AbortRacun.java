/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemskeOperacije;

import controller.Controller;
import model.DomainObjectModel;
import model.Racun;

/**
 *
 * @author Lazar
 */
public class SO_AbortRacun extends GenericSO {
    private boolean success=false;
    @Override
    protected void validate(DomainObjectModel dom) throws Exception {
        if(dom==null || !(dom instanceof Racun)){
            throw new Exception("Prosledjeni objekat nije isntanca kalse Racun");
        }
        Racun racun=(Racun)dom;
        if(racun.getId()==-1 || racun.getId()==0){
            throw new Exception("Greska sa parametrom ID");
        }
        
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
