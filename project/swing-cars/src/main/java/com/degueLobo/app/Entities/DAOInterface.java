package com.degueLobo.app.Entities;

import java.util.List;

/**
 * Created by kefala on 17/09/16.
 */
public interface DAOInterface<MODEL_DTO> {

    MODEL_DTO create(MODEL_DTO dto);

    void delete(MODEL_DTO dto);

    List<MODEL_DTO> getAll();

    MODEL_DTO find(Integer id);

    void update(MODEL_DTO dto);

    Integer getLastId();

}
