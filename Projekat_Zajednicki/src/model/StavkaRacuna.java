/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Lazar
 */
public class StavkaRacuna implements DomainObjectModel {
    private int redniBroj;
    private int kolicina;
    private double cena;
    private double iznos;
    private Oprema oprema;
    private int racunId;
    
    public StavkaRacuna() {
    }

    public StavkaRacuna(int redniBroj, int kolicina, double cena, double iznos, Oprema oprema,int racunId) {
        this.redniBroj = redniBroj;
        this.kolicina = kolicina;
        this.cena = cena;
        this.iznos = iznos;
        this.oprema = oprema;
        this.racunId=racunId;
    }

    public int getRacun() {
        return racunId;
    }

    public void setRacun(int racunId) {
        this.racunId = racunId;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public Oprema getOprema() {
        return oprema;
    }

    public void setOprema(Oprema oprema) {
        this.oprema = oprema;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final StavkaRacuna other = (StavkaRacuna) obj;
        if (this.redniBroj != other.redniBroj) {
            return false;
        }
        if (this.kolicina != other.kolicina) {
            return false;
        }
        if (Double.doubleToLongBits(this.cena) != Double.doubleToLongBits(other.cena)) {
            return false;
        }
        if (Double.doubleToLongBits(this.iznos) != Double.doubleToLongBits(other.iznos)) {
            return false;
        }
        if (this.racunId != other.racunId) {
            return false;
        }
        return Objects.equals(this.oprema, other.oprema);
    }

    

    

    @Override
    public String toString() {
        return "StavkaRacuna{" + "redniBroj=" + redniBroj + ", kolicina=" + kolicina + ", cena=" + cena + ", iznos=" + iznos + ", oprema=" + oprema + '}';
    }

    @Override
    public String getTableName() {
        return "stavkaracuna";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "idRacun,rb,kolicina,cena,iznos,oprema";
    }

    @Override
    public String getInsert() {
        return "?,?,?,?,?,?";
    }

    @Override
    public void setInsertValues(PreparedStatement ps) throws Exception {
        ps.setInt(1, racunId);
        ps.setInt(2, redniBroj);
        ps.setInt(3, kolicina);
        ps.setBigDecimal(4, new BigDecimal(cena));
        ps.setBigDecimal(5, new BigDecimal(iznos));
        ps.setInt(6, oprema.getId());
    }

    @Override
    public String getTableAlias() {
        return "st";
    }

    @Override
    public String getSelectColumns() {
        return "*";
    }

    @Override
    public String getJoinClause() {
        return "JOIN oprema o ON st.oprema=o.idOprema";
    }

    @Override
    public String getSelectWhereCondition() {
        return "idRacun=?";
    }

    @Override
    public void setSelectValues(PreparedStatement ps) throws Exception {
        ps.setInt(1, racunId);
    }

    @Override
    public ArrayList<DomainObjectModel> getListFromResultSet(ResultSet rs) throws Exception {
        ArrayList<DomainObjectModel> list=new ArrayList<>();
        while(rs.next()){
                Oprema o=new Oprema(rs.getInt("o.idOprema"), TipOpreme.valueOf(rs.getString("o.tip")),
                            rs.getString("o.marka"), rs.getString("o.model"),
                            rs.getDouble("o.cena"), rs.getString("o.opis"));
                StavkaRacuna sr=new StavkaRacuna(rs.getInt("st.rb"), rs.getInt("st.kolicina"), o.getCena(),
                            rs.getDouble("st.iznos"), o, rs.getInt("st.idRacun"));
                list.add(sr);
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
        return "idRacun=? AND rb=?";
    }

    @Override
    public void setDeleteValues(PreparedStatement ps) throws Exception {
        ps.setInt(1, racunId);
        ps.setInt(2, redniBroj);
    }
    
    
}
