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
public class SO_DeclareKupac extends GenericSO {
    private Kupac result;
    @Override
    protected void validate(DomainObjectModel dom) throws Exception {
        if(dom==null || !(dom instanceof Kupac))
            throw new Exception("prosledjeni objekat nije klase Kupac");
        Kupac kupac=(Kupac)dom;
        if(kupac.getId()!=-1)
            throw new Exception("Greska sa parametrom Id");
        if(kupac.getBroj()!=-1)
            throw new Exception("Greska sa parametrom Broj");
        if(kupac.getMesto()!=null)
            throw new Exception("Greska sa parametrom Mesto");
        
    }

    @Override
    protected void executeOp(DomainObjectModel dom) throws Exception {
        int id=Controller.getInstance().getDbb().insert(dom);
        if(id==-1){
            rollback();
        }
        result=(Kupac)dom;
        result.setId(id);
    }

    public Kupac getResult() {
        return result;
    }
    
    
    
}
