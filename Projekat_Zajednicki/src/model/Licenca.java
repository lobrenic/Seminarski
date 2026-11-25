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
public class Licenca implements DomainObjectModel {
    private int id;
    private TipLicence tip;
    private String licencor;
    private TrzisnaMarka trzisnaMarka;
    private String brend;

    public Licenca() {
    }

    public Licenca(int id, TipLicence tip, String licencor, TrzisnaMarka trzisnaMarka, String brend) {
        this.id = id;
        this.tip = tip;
        this.licencor = licencor;
        this.trzisnaMarka = trzisnaMarka;
        this.brend = brend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipLicence getTip() {
        return tip;
    }

    public void setTip(TipLicence tip) {
        this.tip = tip;
    }

    public String getLicencor() {
        return licencor;
    }

    public void setLicencor(String licencor) {
        this.licencor = licencor;
    }

    public TrzisnaMarka getTrzisnaMarka() {
        return trzisnaMarka;
    }

    public void setTrzisnaMarka(TrzisnaMarka trzisnaMarka) {
        this.trzisnaMarka = trzisnaMarka;
    }

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
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
        final Licenca other = (Licenca) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.licencor, other.licencor)) {
            return false;
        }
        if (!Objects.equals(this.trzisnaMarka, other.trzisnaMarka)) {
            return false;
        }
        if (!Objects.equals(this.brend, other.brend)) {
            return false;
        }
        return this.tip == other.tip;
    }

    @Override
    public String toString() {
        return "Licenca{" + "id=" + id + ", tip=" + tip + ", licencor=" + licencor + ", trzisnaMarka=" + trzisnaMarka + ", brend=" + brend + '}';
    }

    @Override
    public String getTableName() {
        return "licenca";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "tip, licencor, trzisnaMarka, brend";
    }

    @Override
    public String getInsert() {
        return "?, ?, ?, ?";
    }

    @Override
    public void setInsertValues(PreparedStatement ps) throws Exception {
        if(tip==null)
            ps.setNull(1, java.sql.Types.VARCHAR);
        else{
            ps.setString(1, tip.toString());
        }
        if(licencor==null)
            ps.setNull(2, java.sql.Types.VARCHAR);
        else{
            ps.setString(2, licencor);
        }
        if(trzisnaMarka==null)
            ps.setNull(3, java.sql.Types.VARCHAR);
        else{
            ps.setString(3, trzisnaMarka.toString());
        }
        if(brend==null)
            ps.setNull(4, java.sql.Types.VARCHAR);
        else{
            ps.setString(4, brend);
        }
    }

    @Override
    public String getTableAlias() {
        return "l";
    }

    @Override
    public String getSelectColumns() {
        return "";
    }

    @Override
    public String getJoinClause() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSelectWhereCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setSelectValues(PreparedStatement ps) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<DomainObjectModel> getListFromResultSet(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateSet() {
        return "tip=?, licencor=?, trzisnaMarka=?, brend=?";
    }

    @Override
    public String getUpdateWhereCondition() {
        return "id=?";
    }

    @Override
    public void setUpdateValues(PreparedStatement ps) throws Exception {
         ps.setString(1, tip.toString());
         ps.setString(2, licencor);
         ps.setString(3, trzisnaMarka.toString());
         ps.setString(4, brend);
         ps.setInt(5, id);
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
