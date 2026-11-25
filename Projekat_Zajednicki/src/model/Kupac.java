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
public class Kupac implements DomainObjectModel {
    private int id;
    private String ime;
    private String prezime;
    private String telefon;
    private String ulica;
    private int broj;
    private Mesto mesto;
    
    public Kupac() {
    }

    public Kupac(int id, String ime, String prezime, String telefon, String ulica, int broj, Mesto mesto) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.ulica = ulica;
        this.broj = broj;
        this.mesto = mesto;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
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
        final Kupac other = (Kupac) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        return Objects.equals(this.telefon, other.telefon);
    }

    

    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    @Override
    public String getTableName() {
        return "kupac";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "ime, prezime, telefon, ulica, broj, mesto";
    }

    @Override
    public String getInsert() {
        return "?,?,?,?,?,?";
    }

    @Override
    public void setInsertValues(PreparedStatement ps) throws Exception {
        ps.setNull(1, java.sql.Types.VARCHAR);
        ps.setNull(2, java.sql.Types.VARCHAR);
        ps.setNull(3, java.sql.Types.VARCHAR);
        ps.setNull(4, java.sql.Types.VARCHAR);
        ps.setNull(5,java.sql.Types.BIGINT);
        ps.setInt(6, 5);
    }

    @Override
    public String getTableAlias() {
        return "k";
    }

    @Override
    public String getSelectColumns() {
        return "*";
    }

    @Override
    public String getJoinClause() {
        
        return "JOIN mesto m ON k.mesto=m.id";
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
                list.add(new Kupac(rs.getInt("k.id"), rs.getString("ime"),
                        rs.getString("prezime"), rs.getString("telefon"),
                        rs.getString("ulica"), rs.getInt("broj"), new Mesto(rs.getInt("mesto"), rs.getString("grad"))));
            }
        return list;
    }

    @Override
    public String getUpdateSet() {
        return "ime=?, prezime=?, telefon=?, broj=?, ulica=?, mesto=?";
    }

    @Override
    public String getUpdateWhereCondition() {
        return "id=?";
    }

    @Override
    public void setUpdateValues(PreparedStatement ps) throws Exception {
        ps.setString(1, ime);
        ps.setString(2, prezime);
        ps.setString(3, telefon);
        ps.setInt(4, broj);
        ps.setString(5, ulica);
        ps.setInt(6, mesto.getId());
        ps.setInt(7, id);
    }

    @Override
    public String getDeleteWhereCondition() {
        return "id=?";
    }

    @Override
    public void setDeleteValues(PreparedStatement ps) throws Exception {
        ps.setInt(1, id);
    }
    
    
    
}
