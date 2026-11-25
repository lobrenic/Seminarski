/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemskeOperacije;

import controller.Controller;
import java.util.ArrayList;
import model.DomainObjectModel;
import model.Oprema;

/**
 *
 * @author Lazar
 */
public class SO_GetAllOprema extends GenericSO {
    
    private ArrayList<DomainObjectModel> result;
    @Override
    protected void validate(DomainObjectModel dom) throws Exception {
        
    }

    @Override
    protected void executeOp(DomainObjectModel dom) throws Exception {
        result=Controller.getInstance().getDbb().select(dom, dom.getSelectWhereCondition(), false);
    }
    public ArrayList<DomainObjectModel> getResult(){
        return result;
    }
}
