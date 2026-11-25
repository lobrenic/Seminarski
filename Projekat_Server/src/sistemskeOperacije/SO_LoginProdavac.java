/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemskeOperacije;

import controller.Controller;
import java.util.ArrayList;
import model.DomainObjectModel;
import model.Prodavac;
import server.ObradaKlijentskihZahteva;

/**
 *
 * @author Lazar
 */
public class SO_LoginProdavac extends GenericSO {
    private Prodavac result;
    @Override
    protected void validate(DomainObjectModel dom) throws Exception {
        if (dom == null || !(dom instanceof Prodavac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Prodavac!");
        }
        Prodavac p = (Prodavac) dom;

        if (p.getUsername().isEmpty() || p.getPassword().isEmpty()) {
            throw new Exception("Korisnicko ime i lozinka nisu uneti!");
        }

        for (ObradaKlijentskihZahteva k : Controller.getInstance().getKlijenti()) {
            if(k.getUsername().equals(p.getUsername())){
                throw new Exception("Korisnik je vec ulogovan");
            }
        }
    }

    @Override
    protected void executeOp(DomainObjectModel dom)throws Exception{
        ArrayList<DomainObjectModel> list=Controller.getInstance().getDbb().select(dom, ((Prodavac)dom).getSelectWhereCondition(),false);
        result=list.isEmpty() ? (Prodavac)dom : (Prodavac)list.get(0);
    }
    public Prodavac getResult(){
        return result;
    }
}
