/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Lazar
 */
public class Oprema implements DomainObjectModel{
    private int id;
    private TipOpreme tip;
    private String marka;
    private String model;
    private double cena;
    private String opis;

    

    public Oprema(int id, TipOpreme tip, String marka, String model, double cena, String opis) {
        this.id = id;
        this.tip = tip;
        this.marka = marka;
        this.model = model;
        this.cena = cena;
        this.opis = opis;
    }

    
    
    public Oprema() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipOpreme getTip() {
        return tip;
    }

    public void setTip(TipOpreme tip) {
        this.tip = tip;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Oprema other = (Oprema) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.cena) != Double.doubleToLongBits(other.cena)) {
            return false;
        }
        if (!Objects.equals(this.marka, other.marka)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        return this.tip == other.tip;
    }

    @Override
    public String toString() {
        return marka+" "+model+" "+cena;
    }

    @Override
    public String getTableName() {
        return "oprema";
    }

    @Override
    public String getColumnNamesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setInsertValues(PreparedStatement ps) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableAlias() {
        return "o";
    }

    @Override
    public String getSelectColumns() {
        return "*";
    }

    @Override
    public String getJoinClause() {
        return "";
    }

    @Override
    public String getSelectWhereCondition() {
        return "";
    }

    @Override
    public void setSelectValues(PreparedStatement ps) throws Exception {
        
    }

    @Override
    public ArrayList<DomainObjectModel> getListFromResultSet(ResultSet rs) throws Exception {
        ArrayList<DomainObjectModel> list=new ArrayList<>();
        while(rs.next()){
                list.add(new Oprema(rs.getInt("idOprema"),TipOpreme.valueOf(rs.getString("tip")),
                        rs.getString("marka"), rs.getString("model"), rs.getDouble("cena"), rs.getString("opis")));
            }
        return list;
    }

    @Override
    public String getUpdateSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setUpdateValues(PreparedStatement ps) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDeleteWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setDeleteValues(PreparedStatement ps) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
