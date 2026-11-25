/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lazar
 */
public interface DomainObjectModel extends Serializable {

    //INSERT
    public abstract String getTableName();

    public abstract String getColumnNamesForInsert();

    public abstract String getInsert();

    public abstract void setInsertValues(PreparedStatement ps) throws Exception;

    // SELECT
    public abstract String getTableAlias();

    public abstract String getSelectColumns();

    public abstract String getJoinClause();

    public abstract String getSelectWhereCondition();

    public abstract void setSelectValues(PreparedStatement ps) throws Exception;

    public abstract ArrayList<DomainObjectModel> getListFromResultSet(ResultSet rs) throws Exception;

    // UPDATE
    public abstract String getUpdateSet();

    public abstract String getUpdateWhereCondition();

    public abstract void setUpdateValues(PreparedStatement ps) throws Exception;

    // DELETE
    public abstract String getDeleteWhereCondition();

    public abstract void setDeleteValues(PreparedStatement ps) throws Exception;
}
