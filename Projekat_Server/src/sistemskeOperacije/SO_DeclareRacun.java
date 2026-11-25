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
public class SO_DeclareRacun extends GenericSO {
    private Racun result;
    @Override
    protected void validate(DomainObjectModel dom) throws Exception {
        if(dom==null || !(dom instanceof Racun)){
            throw new Exception("Greska sa klasom Racun");
        }
        Racun r=(Racun)dom;
        if(r.getId()!=-1){
            throw new Exception("Greska sa parametrom ID");
        }if(r.getProdavac()==null){
            throw new Exception("Greska sa parametrom Prodavac");
        }if(r.getStatus()==null){
            throw new Exception("Greska sa parametrom Status");
        }
        
        
    }

    @Override
    protected void executeOp(DomainObjectModel dom) throws Exception {
        int id=Controller.getInstance().getDbb().insert(dom);
        result=(Racun)dom;
        result.setId(id);
    }
    public Racun getResult(){
        return result;
    }
}
