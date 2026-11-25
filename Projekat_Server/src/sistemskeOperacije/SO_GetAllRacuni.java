/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemskeOperacije;

import controller.Controller;
import java.util.ArrayList;
import model.DomainObjectModel;
import model.Racun;
import model.StavkaRacuna;

/**
 *
 * @author Lazar
 */
public class SO_GetAllRacuni extends GenericSO {
    ArrayList<Racun> result=new ArrayList<>();
    @Override
    protected void validate(DomainObjectModel dom) throws Exception {
        
    }

    @Override
    protected void executeOp(DomainObjectModel dom) throws Exception {
        ArrayList<DomainObjectModel> listNoStavka=Controller.getInstance().getDbb().select(dom, dom.getSelectWhereCondition(), true);
        ArrayList<Racun> listWithStavka=new ArrayList<>();
        for (DomainObjectModel r : listNoStavka) {
            StavkaRacuna dummy=new StavkaRacuna(-1, -1, -1, -1, null, ((Racun)r).getId());
            ArrayList<DomainObjectModel> stavkeDOM=Controller.getInstance()
                    .getDbb().select(dummy, dummy.getSelectWhereCondition(), true);
            ArrayList<StavkaRacuna> stavkeRacuna=new ArrayList<>();
            for (DomainObjectModel stDom : stavkeDOM) {
                stavkeRacuna.add((StavkaRacuna)stDom);
            }
            ((Racun)r).setStavka(stavkeRacuna);
            listWithStavka.add((Racun)r);
        }
        result=listWithStavka;
    }
    
    public ArrayList<Racun> getResult(){
        return result;
    }
    
}
