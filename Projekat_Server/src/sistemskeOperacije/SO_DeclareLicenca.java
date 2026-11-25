/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemskeOperacije;

import controller.Controller;
import model.DomainObjectModel;
import model.Licenca;
import model.Racun;

/**
 *
 * @author Lazar
 */
public class SO_DeclareLicenca extends GenericSO {
    private Licenca result;
    @Override
    protected void validate(DomainObjectModel dom) throws Exception {
        if(dom==null || !(dom instanceof Licenca)){
            throw new Exception("Greska sa klasom Licenca");
        }
        Licenca l=(Licenca)dom;
        if(l.getId()!=-1){
            throw new Exception("Greska sa parametrom ID");
        }
    }

    @Override
    protected void executeOp(DomainObjectModel dom) throws Exception {
        int id=Controller.getInstance().getDbb().insert(dom);
        result=(Licenca)dom;
        if(id==-1)
            throw new Exception("Licenca nije mogla da bude deklarisana");
        result.setId(id);
    }
    public Licenca getResult(){
        return result;
    }
}
