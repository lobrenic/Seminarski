/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.StavkaRacuna;

/**
 *
 * @author Lazar
 */
public class ModelTabeleStavke extends AbstractTableModel {
    
    private ArrayList<StavkaRacuna> stavke=new ArrayList<>();
    private String[] kolone={"Rb.","Proizvod","Količina", "Cena","Iznos"};

    public ModelTabeleStavke(ArrayList<StavkaRacuna> stavke) {
        this.stavke=stavke;
    }

    public ModelTabeleStavke() {
    }
    
    @Override
    public int getRowCount() {
        return stavke.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRacuna sr=stavke.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sr.getRedniBroj();
            case 1:
                return sr.getOprema();
            case 2:
                return sr.getKolicina();
            case 3:
                return sr.getCena();
            case 4:
                return String.format("%.2f", sr.getIznos());
            default:
                return "N/A";
        }
        
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
    
}
