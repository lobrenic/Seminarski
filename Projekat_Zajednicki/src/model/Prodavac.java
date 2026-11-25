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
public class Prodavac implements DomainObjectModel {
    private int id;
    private String ime;
    private String prezime;
    private String username;
    private String password;
    private String JMBG;

    public Prodavac() {
    }

    public Prodavac(int id, String ime, String prezime, String username, String password, String JMBG) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.JMBG = JMBG;
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

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Prodavac other = (Prodavac) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.JMBG, other.JMBG);
    }
    
    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    @Override
    public String getTableName() {
        return "prodavac";
    }

    @Override
    public String getColumnNamesForInsert() {
        return null;
    }

    @Override
    public String getInsert() {
        return null;
    }

    @Override
    public void setInsertValues(PreparedStatement ps) throws Exception {
        
    }

    @Override
    public String getTableAlias() {
        return "p";
    }

    @Override
    public String getSelectColumns() {
        return "*";
    }

    @Override
    public String getJoinClause() {
        return null;
    }

    @Override
    public String getSelectWhereCondition() {
        return "username=? AND password=?";
    }

    @Override
    public void setSelectValues(PreparedStatement ps) throws Exception {
        if(username != null && password != null){
            ps.setString(1, username);
            ps.setString(2, password);
        }
    }

    @Override
    public ArrayList<DomainObjectModel> getListFromResultSet(ResultSet rs) throws Exception {
        ArrayList<DomainObjectModel> list=new ArrayList<>();
        
        while(rs.next()){
            Prodavac p=new Prodavac(rs.getInt("id"), rs.getString("ime"),
                    rs.getString("prezime"), rs.getString("username"), rs.getString("password"), rs.getString("JMBG"));
            list.add(p);
            
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
