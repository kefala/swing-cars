package com.degueLobo.app.Entities;

import java.util.List;
import java.sql.*;

/**
 * Created by kefala on 17/09/16.
 */
public abstract class DAO<MODEL_DTO extends DTO> implements DAOInterface<MODEL_DTO> {
    protected final String TABLE_NAME;
    protected Connection conn = null;
    
    public DAO(Connection conn, String tableName) {
        this.conn = conn;
        this.TABLE_NAME = tableName;
    }

    public void delete(Integer id) throws SQLException {
        PreparedStatement st = null;
        st = this.conn.prepareStatement("DELETE FROM " + getTableName()+ " WHERE id = " + id.toString() + ";");
    };

    public void deleteAll() throws SQLException {
        /* Dejo esto comentado ya que A)No creo que lo usemos y B) no usarlo sin querer :P 
        PreparedStatement st = null;
        st = this.conn.prepareStatement("DELETE FROM " + getTableName()+ " WHERE true = true;");
        */
        
    };

    public String getTableName()
    {
        return TABLE_NAME;
    }
    
    public abstract List<MODEL_DTO> getAll() throws SQLException;
    
    public abstract MODEL_DTO create(MODEL_DTO model) throws SQLException;

    public abstract void update(MODEL_DTO model) throws SQLException;

    public abstract MODEL_DTO find(Integer id) throws SQLException;

}
