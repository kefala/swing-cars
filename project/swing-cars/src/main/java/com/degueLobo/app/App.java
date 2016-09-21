package com.degueLobo.app;

import com.degueLobo.app.Entities.Users.UserDAO;
import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Managers.ConnectionManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Connection conn = null;
        Statement stm = null;
        try {
            conn = ConnectionManager.GetConnection();
            UserDTO user = new UserDTO();
            UserDAO userDao = new UserDAO(conn);
            user.setUsername("Pepeeerino");
            user.setPassword("pass");
            user.setUserType(2);
            user = userDao.create(user);
            System.out.println("User's ID: " + user.getId());
            conn.close();
            System.out.printf("TOdo pioli");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
