package com.degueLobo.app.Entities;

import com.degueLobo.app.Entities.Users.UserDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kefala on 17/09/16.
 */
public interface DAOInterface<MODEL_DTO> {

    MODEL_DTO create(MODEL_DTO dto) throws SQLException;

    boolean delete(Integer id) throws SQLException;

    List<MODEL_DTO> getAll() throws SQLException;

    MODEL_DTO find(Integer id) throws SQLException;

    MODEL_DTO update(MODEL_DTO dto) throws SQLException;
    
    String getTableName();

}
