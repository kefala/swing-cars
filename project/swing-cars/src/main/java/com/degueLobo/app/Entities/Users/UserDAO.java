package com.degueLobo.app.Entities.Users;

import com.degueLobo.app.Entities.DAO;

/**
 * Created by kefala on 17/09/16.
 */
public class UserDAO extends DAO<UserDTO> {
    private static final String TABLE_NAME = "users";

    public UserDAO() {
    }

    public String getTableName() {
        return TABLE_NAME;
    }
}
