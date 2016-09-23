package com.degueLobo.app.Entities;

import java.util.List;
import java.sql.*;

/**
 * Created by kefala on 17/09/16.
 */
public abstract class DAO<MODEL_DTO extends DTO> implements DAOInterface<MODEL_DTO> {

    protected Connection conn = null;
    
    public DAO(Connection conn) {
        this.conn = conn;
    }

    public void delete(Integer id) throws SQLException {
        PreparedStatement st = null;
        st = this.conn.prepareStatement("DELETE FROM " + getTableName()+ " WHERE id = " + id.toString() + ";");
    };

    public List<MODEL_DTO> getAll() throws SQLException {
        PreparedStatement st = null;
        st = this.conn.prepareStatement("SELECT * FROM " + getTableName()+ ";");
        return null;
    };

    public void deleteAll() throws SQLException {
        PreparedStatement st = null;
        st = this.conn.prepareStatement("DELETE FROM " + getTableName()+ " WHERE true = true;");
    };
    
    public abstract String getTableName();

    public abstract MODEL_DTO create(MODEL_DTO model) throws SQLException;

    public abstract void update(MODEL_DTO model) throws SQLException;

    public abstract MODEL_DTO find(Integer id) throws SQLException;

}
