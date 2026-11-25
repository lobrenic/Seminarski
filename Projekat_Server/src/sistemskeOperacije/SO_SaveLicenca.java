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
public class SO_SaveLicenca extends GenericSO {
    private boolean result;
    @Override
    protected void validate(DomainObjectModel dom) throws Exception {
        if(dom==null || !(dom instanceof Licenca)){
            throw new Exception("Greska sa klasom Licenca");
        }
        Licenca l=(Licenca)dom;
        if(l.getId()==-1){
            throw new Exception("Greska sa parametrom ID");
        }
        if(l.getBrend()==null || l.getBrend().isEmpty()){
            throw new Exception("Greska sa parametrom Brend");
        }
        if(l.getLicencor()==null || l.getLicencor().isEmpty()){
            throw new Exception("Greska sa parametrom Licencor");
        }
        if(l.getTip()==null){
            throw new Exception("Greska sa parametrom Tip");
        }
        if(l.getTrzisnaMarka()==null){
            throw new Exception("Greska sa parametrom Trzisna Marka");
        }
        
    }

    @Override
    protected void executeOp(DomainObjectModel dom) throws Exception {
        int aRows=Controller.getInstance().getDbb().update(dom);
        if(aRows<=0){
            throw new Exception("Greska pri cuvanju licence");
        }
        result=aRows>0;
    }
    public boolean getResult(){
        return result;
    }
            
}
