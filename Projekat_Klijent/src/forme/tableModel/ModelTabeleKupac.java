/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Kupac;

/**
 *
 * @author Lazar
 */
public class ModelTabeleKupac extends AbstractTableModel{
    
    private List<Kupac> kupci=new ArrayList<>();
    private String[] kolone={"Ime","Prezime","Telefon","Grad","Ulica","Broj"};

    public ModelTabeleKupac(List<Kupac> kupci) {
        this.kupci=kupci;
    }

    public ModelTabeleKupac() {
    }
    
    @Override
    public int getRowCount() {
        return kupci.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kupac k=kupci.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getIme();
            case 1:
                return k.getPrezime();
            case 2:
                return k.getTelefon();
            case 3:
                return k.getMesto().getGrad();
            case 4:
                return k.getUlica();
            case 5:
                return k.getBroj();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    
    
    public List<Kupac> getKupci() {
        return kupci;
    }

    public void setKupci(List<Kupac> kupci) {
        this.kupci = kupci;
    }

    public String[] getKolone() {
        return kolone;
    }

    public void setKolone(String[] kolone) {
        this.kolone = kolone;
    }
    
}
