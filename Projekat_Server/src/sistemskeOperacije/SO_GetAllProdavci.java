/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemskeOperacije;

import controller.Controller;
import java.util.ArrayList;
import model.DomainObjectModel;
import model.Prodavac;

/**
 *
 * @author Lazar
 */
public class SO_GetAllProdavci extends GenericSO {
    private ArrayList<Prodavac> result;
    @Override
    protected void validate(DomainObjectModel dom) throws Exception {
        
    }

    @Override
    protected void executeOp(DomainObjectModel dom) throws Exception {
        ArrayList<DomainObjectModel> list=Controller.getInstance().getDbb().select(dom, "", false);
        ArrayList<Prodavac> prodavci=new ArrayList<>();
        for (DomainObjectModel p : list) {
            prodavci.add((Prodavac)p);
        }
        result=prodavci;
    }

    public ArrayList<Prodavac> getResult() {
        return result;
    }

    
    
}
