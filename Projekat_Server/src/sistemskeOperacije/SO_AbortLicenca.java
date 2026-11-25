/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemskeOperacije;

import controller.Controller;
import model.DomainObjectModel;
import model.Licenca;

/**
 *
 * @author Lazar
 */
public class SO_AbortLicenca extends GenericSO {
     private boolean success;
    @Override
    protected void validate(DomainObjectModel dom) throws Exception {
        if(dom==null || !(dom instanceof Licenca)){
            throw new Exception("Greska sa klasom Licenca");
        }
        Licenca l=(Licenca)dom;
        if(l.getId()==-1){
            throw new Exception("Licenca nije inicijalizovana");
        }
    }

    @Override
    protected void executeOp(DomainObjectModel dom) throws Exception {
        int aRows=Controller.getInstance().getDbb().delete(dom);
        success = aRows>0;
    }
    public boolean getResult(){
        return success;
    }
}
