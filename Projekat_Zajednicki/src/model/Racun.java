/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Lazar
 */
public class Racun implements DomainObjectModel {
    private int id;
    private String brojRacuna;
    private Prodavac prodavac;
    private Kupac kupac;
    private ArrayList<StavkaRacuna> stavka;
    private double ukupanIznos;
    private StatusRacun status;
    private LocalDate createdAt;
    public Racun() {
    }

    

    public Racun(int id, String brojRacuna, Prodavac prodavac, Kupac kupac, ArrayList<StavkaRacuna> stavka, double ukupanIznos, StatusRacun status, LocalDate createdAt) {
        this.id = id;
        this.brojRacuna = brojRacuna;
        this.prodavac = prodavac;
        this.kupac = kupac;
        this.stavka = stavka;
        this.ukupanIznos = ukupanIznos;
        this.status = status;
        this.createdAt = createdAt;
    }

    

    public ArrayList<StavkaRacuna> getStavka() {
        return stavka;
    }

    public void setStavka(ArrayList<StavkaRacuna> stavka) {
        this.stavka = stavka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Prodavac getProdavac() {
        return prodavac;
    }

    public void setProdavac(Prodavac prodavac) {
        this.prodavac = prodavac;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    
    
    public StatusRacun getStatus() {
        return status;
    }

    public void setStatus(StatusRacun status) {
        this.status = status;
    }
    
    

    @Override
    public String toString() {
        return "Racun{" + "id=" + id + ", brojRacuna=" + brojRacuna + ", prodavac=" + prodavac + ", kupac=" + kupac + ", stavka=" + stavka + ", ukupanIznos=" + ukupanIznos + ", status=" + status + ", createdAt=" + createdAt + '}';
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
        final Racun other = (Racun) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.ukupanIznos) != Double.doubleToLongBits(other.ukupanIznos)) {
            return false;
        }
        if (!Objects.equals(this.brojRacuna, other.brojRacuna)) {
            return false;
        }
        if (!Objects.equals(this.prodavac, other.prodavac)) {
            return false;
        }
        return Objects.equals(this.kupac, other.kupac);
    }

    

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String getTableName() {
        return "racun";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "brRacuna,ukupanIznos,status,createdAt,kupac,prodavac";
    }

    @Override
    public String getInsert() {
        return "?,?,?,?,?,?";
    }

    @Override
    public void setInsertValues(PreparedStatement ps) throws Exception {
        ps.setNull(1, java.sql.Types.VARCHAR);
            ps.setBigDecimal(2, BigDecimal.valueOf(ukupanIznos));
            ps.setString(3, status.toString());
            ps.setDate(4, Date.valueOf(createdAt));
            
            if(status==StatusRacun.DRAFT){
                if(kupac!=null){
                ps.setInt(5, kupac.getId());
                }else{
                    ps.setNull(5, Types.BIGINT);
                }
            }else{
                if(kupac == null){
                    throw new Exception("Izdati račun mora imati kupca.");
                }
                ps.setInt(5, kupac.getId());
            }
            ps.setInt(6, prodavac.getId());
    }

    @Override
    public String getTableAlias() {
        return "r";
    }

    @Override
    public String getSelectColumns() {
        return "*";
    }

    @Override
    public String getJoinClause() {
        return "LEFT JOIN kupac k ON r.kupac=k.id \n" +
                    "LEFT JOIN mesto m ON k.mesto=m.id\n" +
                    "LEFT JOIN prodavac p ON p.id=r.prodavac";
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
            Kupac k = null;

            if(rs.getObject("k.id") != null){
                Mesto m = new Mesto(
                    rs.getInt("m.id"), 
                    rs.getString("m.grad")
                );

                k = new Kupac(
                    rs.getInt("k.id"),
                    rs.getString("k.ime"),
                    rs.getString("k.prezime"),
                    rs.getString("k.telefon"),
                    rs.getString("k.ulica"),
                    rs.getInt("k.broj"),
                    m
                );
            }
            Mesto m=new Mesto(rs.getInt("m.id"), rs.getString("m.grad"));
            Prodavac p=new Prodavac(rs.getInt("p.id"), rs.getString("p.ime")
                ,rs.getString("p.prezime"), rs.getString("p.username"),
                rs.getString("p.password"), rs.getString("p.JMBG"));
            Racun r=new Racun(rs.getInt("r.id"), rs.getString("r.brRacuna"), p, k, new ArrayList<>()
                ,rs.getDouble("r.ukupanIznos"), StatusRacun.valueOf(rs.getString("r.status")),
                rs.getDate("createdAt").toLocalDate());
            list.add(r);
        }
        return list;
    }

    @Override
    public String getUpdateSet() {
        return "brRacuna=?, ukupanIznos=?, status=?, createdAt=?, kupac=?, prodavac=?";
    }

    @Override
    public String getUpdateWhereCondition() {
        return "id=?";
    }

    @Override
    public void setUpdateValues(PreparedStatement ps) throws Exception {
        
        ps.setString(1, brojRacuna);
            ps.setBigDecimal(2, new BigDecimal(ukupanIznos));
            ps.setString(3, status.toString());
            ps.setDate(4, Date.valueOf(createdAt));
            if(kupac != null){
                ps.setInt(5, kupac.getId());
            }else{
                ps.setNull(5, Types.BIGINT);
            }
            ps.setInt(6, prodavac.getId());
            ps.setInt(7, id);
    }

    @Override
    public String getDeleteWhereCondition() {
        return "id=? AND status=?";
    }

    @Override
    public void setDeleteValues(PreparedStatement ps) throws Exception {
        ps.setInt(1, id);
        ps.setString(2, StatusRacun.DRAFT.toString());
        
    }
    
    
}
