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
public class Mesto implements DomainObjectModel{
    private int id;
    private String grad;

    public Mesto() {
    }

    public Mesto(int id, String grad) {
        this.id = id;
        this.grad = grad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
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
        final Mesto other = (Mesto) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.grad, other.grad);
    }

    @Override
    public String toString() {
        return grad;
    }

    @Override
    public String getTableName() {
        return "mesto";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "";
    }

    @Override
    public String getInsert() {
        return "";
    }

    @Override
    public void setInsertValues(PreparedStatement ps) throws Exception {
        
    }

    @Override
    public String getTableAlias() {
        return "m";
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
            list.add(new Mesto(rs.getInt("id"), rs.getString("grad")));
        }
        return list;
    }

    @Override
    public String getUpdateSet() {
        return "";
    }

    @Override
    public String getUpdateWhereCondition() {
        return "";
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
