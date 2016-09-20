package com.degueLobo.app.Entities;

import java.util.Collections;
import java.util.List;
import java.sql.*;

/**
 * Created by kefala on 17/09/16.
 */
public abstract class DAO<MODEL_DTO extends DTO> implements DAOInterface<MODEL_DTO> {
    public MODEL_DTO create(MODEL_DTO model) {

        return null;
    }

    public void delete(MODEL_DTO model) {
    }

    public List<MODEL_DTO> getAll() {
        List<MODEL_DTO> all = Collections.emptyList();
        return all;
    }

    public MODEL_DTO find(Integer id) {
        return null;
    }

    public void update(MODEL_DTO model) {
    }


    public abstract String getTableName();

    public Integer getLastId() {
        Integer key = 0;
        return key;
    }

    public void deleteAll() {
    }

}
