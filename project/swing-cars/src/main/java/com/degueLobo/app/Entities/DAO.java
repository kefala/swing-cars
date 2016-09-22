package com.degueLobo.app.Entities;

import java.util.List;
import java.sql.*;

/**
 * Created by kefala on 17/09/16.
 */
public abstract class DAO<MODEL_DTO extends DTO> implements DAOInterface<MODEL_DTO> {

    protected Connection conn = null;
    
    public DAO(Connection conn)
    {
        this.conn = conn;
    }
    
    public abstract MODEL_DTO create(MODEL_DTO model) throws SQLException;

    public abstract void delete(MODEL_DTO model) throws SQLException;

    public abstract List<MODEL_DTO> getAll() throws SQLException;

    public abstract MODEL_DTO find(Integer id) throws SQLException;

    public abstract void update(MODEL_DTO model) throws SQLException;

    public abstract Integer getLastId();

    public abstract void deleteAll() throws SQLException;
    
    public abstract String getTableName();
}
