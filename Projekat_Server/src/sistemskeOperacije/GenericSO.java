/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemskeOperacije;

import baza.Konekcija;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DomainObjectModel;

/**
 *
 * @author Lazar
 */
public abstract class GenericSO {
    
    protected abstract void validate(DomainObjectModel dom)throws Exception;
    protected abstract void executeOp(DomainObjectModel dom)throws Exception;
    public void execute(DomainObjectModel dom) throws Exception{
        try {
            validate(dom);
            executeOp(dom);
            commit();
        } catch (SQLException ex) {
            rollback();
            throw ex;
        }
    }
    
    public void commit() throws Exception{
        Konekcija.getInstance().getConnection().commit();
    }
    
    public void rollback() throws Exception{
        Konekcija.getInstance().getConnection().rollback();
    }
    
}
