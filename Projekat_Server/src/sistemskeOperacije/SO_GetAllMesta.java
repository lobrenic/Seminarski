/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemskeOperacije;

import controller.Controller;
import java.util.ArrayList;
import model.DomainObjectModel;
import model.Mesto;

/**
 *
 * @author Lazar
 */
public class SO_GetAllMesta extends GenericSO {
    private ArrayList<Mesto> result;
    @Override
    protected void validate(DomainObjectModel dom) throws Exception {
        
    }

    @Override
    protected void executeOp(DomainObjectModel dom) throws Exception {
        ArrayList<DomainObjectModel> listDom=Controller.getInstance().getDbb().select(dom, dom.getSelectWhereCondition(),false);
        ArrayList<Mesto> list=new ArrayList<>();
        for (DomainObjectModel m : listDom) {
            list.add((Mesto)m);
        }
        result=list;
    }

    public ArrayList<Mesto> getResult() {
        return result;
    }
    
}
