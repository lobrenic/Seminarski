/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Lazar
 */
public class ServerskiOdgovor implements Serializable {
    private Object param;
    private Exception exception;
    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object param) {
        this.param = param;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
    
    
    
}
