/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemskeOperacije;

import controller.Controller;
import java.util.ArrayList;
import model.DomainObjectModel;
import model.Kupac;
import model.Racun;

/**
 *
 * @author Lazar
 */
public class SO_DeleteKupac extends GenericSO {
    private boolean result;
    @Override
    protected void validate(DomainObjectModel dom) throws Exception {
        if(dom==null || !(dom instanceof Kupac))
            throw new Exception("Prosledjeni objekat nije instanca klase Kupac");
        Kupac kupac=(Kupac)dom;
        if(kupac.getId()==-1)
            throw new Exception("Greska sa parametrom Id");
        Racun dummy=new Racun();
        ArrayList<DomainObjectModel> racuni= Controller.getInstance().getDbb().select(dummy,dummy.getSelectWhereCondition() , true);
        for (DomainObjectModel r : racuni) {
            if(((Racun)r).getKupac().getId()==kupac.getId())
                throw new Exception("Nemoguce obrisati kupca, postoje racuni koje je kupac izdao!");
        }
    }

    @Override
    protected void executeOp(DomainObjectModel dom) throws Exception {
        int aRows=Controller.getInstance().getDbb().delete(dom);
        result=aRows>0;
        
    }

    public boolean getResult() {
        return result;
    }
    
    
    
}
