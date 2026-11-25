/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.math.BigDecimal;
import model.Prodavac;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Kupac;
import model.Mesto;
import model.Oprema;
import model.Racun;
import model.StatusRacun;
import model.StavkaRacuna;
import model.TipOpreme;
import model.DomainObjectModel;
/**
 *
 * @author Lazar
 */
public class DBBroker {

    
    public ArrayList<DomainObjectModel> select(DomainObjectModel dom, String where,boolean join) throws Exception{
        String query="SELECT "+dom.getSelectColumns()+" FROM "+dom.getTableName()+" "+dom.getTableAlias()+
                (join ? " "+dom.getJoinClause() : "");
        query+=(where!=null && !where.isEmpty()) ?
                " WHERE "+where : "";
        System.out.println(query);
        PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(query);
        dom.setSelectValues(ps);
        ResultSet rs=ps.executeQuery();
        ArrayList<DomainObjectModel> list=dom.getListFromResultSet(rs);
        return list;
    }
    
    
    public int insert(DomainObjectModel dom) throws Exception{
        String query="INSERT INTO "+dom.getTableName()+
                " ("+dom.getColumnNamesForInsert()+") VALUES("+dom.getInsert()+") ";
        System.out.println(query);
        PreparedStatement ps=Konekcija.getInstance().getConnection().
                prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        dom.setInsertValues(ps);
        ps.executeUpdate();
        int id=-1;
        ResultSet rs=ps.getGeneratedKeys();
        if(rs.next()){
            id=rs.getInt(1);
        }
        return id;
    }
    
    public int update(DomainObjectModel dom) throws Exception{
        String query="UPDATE "+dom.getTableName()+" "+dom.getTableAlias()+
                " SET "+dom.getUpdateSet()+
                " WHERE "+dom.getUpdateWhereCondition();
        System.out.println(query);
        PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(query);
        dom.setUpdateValues(ps);
        int aRows=ps.executeUpdate();
        return aRows;
    }
    public int delete(DomainObjectModel dom) throws Exception{
        String query="DELETE FROM "+dom.getTableName()+" "+
                " WHERE "+dom.getDeleteWhereCondition();
        System.out.println(query);
        PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(query);
        dom.setDeleteValues(ps);
        int aRows=ps.executeUpdate();
        return aRows;
    }
    
    
}
