/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.tableModel;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Racun;

/**
 *
 * @author Lazar
 */
public class ModelTabeleRacun extends AbstractTableModel {
    
    private List<Racun> racuni=new ArrayList<>();
    private String[] kolone={"Broj računa","Ukupan iznos","Datum kreiranja","Kupac","Prodavac","Status"};

    public ModelTabeleRacun() {
    }
    
    public ModelTabeleRacun(List<Racun> racuni) {
        this.racuni=racuni;
    }
    
    @Override
    public int getRowCount() {
        return racuni.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Racun r=racuni.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return r.getBrojRacuna();
            case 1:
                return r.getUkupanIznos();
            case 2:
                return r.getCreatedAt().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            case 3:
                return r.getKupac().getId()==0 ? "N/A" : r.getKupac();
            case 4:
                return r.getProdavac();
            case 5:
                return r.getStatus().toString();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public String[] getKolone() {
        return kolone;
    }

    public void setKolone(String[] kolone) {
        this.kolone = kolone;
    }

    public List<Racun> getRacuni() {
        return racuni;
    }

    public void setRacuni(List<Racun> racuni) {
        this.racuni = racuni;
    }
    
    
    
}
