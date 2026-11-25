/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package operacije;

import java.io.Serializable;

/**
 *
 * @author Lazar
 */
public enum Operacije implements Serializable {
    LOGIN,
    LOGOFF,
    GET_ALL_KUPCI,
    GET_ALL_OPREMA,
    DECLARATION_RACUN,
    ISSUE_RACUN,
    ABORT_RACUN,
    DRAFT_RACUN,
    GET_ALL_RACUNI,
    GET_ALL_PRODAVCI,
    GET_ALL_MESTA,
    DECLARATION_KUPAC, 
    ABORT_KUPAC,
    SAVE_KUPAC,
    DELETE_KUPAC, 
    DECLARATION_LICENCA,
    SAVE_LICENCA,
    ABORT_LICENCA
}
