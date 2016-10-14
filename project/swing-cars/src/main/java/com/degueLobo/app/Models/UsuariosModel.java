package com.degueLobo.app.Models;

import com.degueLobo.app.Entities.Users.UserDAO;
import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Managers.ConnectionManager;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by kefala on 13/10/16.
 */
public class UsuariosModel extends Model {

    public List<UserDTO> getAdminAndVendedor() {
        List<UserDTO> usersList = Collections.emptyList();

        try {
            UserDAO userDAO = new UserDAO(ConnectionManager.GetConnection());
            usersList = userDAO.getAdminAndVendedor();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usersList;
    }
}
