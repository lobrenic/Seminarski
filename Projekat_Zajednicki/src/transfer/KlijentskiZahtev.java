/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.Serializable;
import java.util.Objects;
import operacije.Operacije;

/**
 *
 * @author Lazar
 */
public class KlijentskiZahtev implements Serializable {
    private Object param;
    private Operacije operacija;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(Object param, Operacije operacija) {
        this.param = param;
        this.operacija = operacija;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public Operacije getOperacija() {
        return operacija;
    }

    public void setOperacija(Operacije operacija) {
        this.operacija = operacija;
    }

    
}
