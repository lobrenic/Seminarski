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
public class SO_SaveRacun extends GenericSO {
    private boolean success;
    @Override
    protected void validate(DomainObjectModel dom) throws Exception {
        if(dom==null || !(dom instanceof Racun)){
            throw new Exception("Greska sa klasom Racun");
        }
        Racun r=(Racun)dom;
        if(r.getBrojRacuna()==null || r.getBrojRacuna().isEmpty()){
            throw new Exception("Greska sa parametrom BrojRacuna");
        }if(r.getKupac()==null){
            throw new Exception("Greska sa paramerom Kupac");
        }if(r.getCreatedAt()==null){
            throw new Exception("Greska sa parametrom CreatedAt");
        }if(r.getStatus()==null){
            throw new Exception("Greska sa parametrom Status");
        }if(r.getStavka()==null){
            throw new Exception("Greska sa parametrom Stavke");
        }
        
        
    }

    @Override
    protected void executeOp(DomainObjectModel dom) throws Exception {
        ArrayList<StavkaRacuna> stavkeUBazi=new ArrayList<>();
        int aRows=Controller.getInstance().getDbb().update(dom);
        if(aRows==0){
            rollback();
            success=false;
            return;
        }
        StavkaRacuna dummy=new StavkaRacuna(-1, -1, -1, -1, null,((Racun)dom).getId());
        ArrayList<DomainObjectModel> stavke=Controller.getInstance().getDbb().select(
                dummy, dummy.getSelectWhereCondition(), true);
        for (DomainObjectModel st : stavke) {
            stavkeUBazi.add((StavkaRacuna)st);
        }
        for (StavkaRacuna st : stavkeUBazi) {
            if(!((Racun)dom).getStavka().contains(st)){
                Controller.getInstance().getDbb().delete(st);
            }
        }
        
        for (StavkaRacuna st : ((Racun)dom).getStavka()) {
            if(!stavkeUBazi.contains(st)){
                Controller.getInstance().getDbb().insert(st);
            }
        }
        
        success=true;
    }
    public boolean getResult(){
        return success;
    }
}
