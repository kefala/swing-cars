package com.degueLobo.app;

import com.degueLobo.app.Entities.Users.UserDAO;
import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Managers.ConnectionManager;
import java.sql.Connection;
import java.sql.Statement;
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
            //la conexion a la base tiene que darse dentro del DAO, es más claro que se maneje dentro de una clase.
            // Desde mi punto de vista simplifica la carga de datos dentro del programa, ya que no tengo que estar pidiendo la conexion solo con instanciar la clase bastaria para conectarse.
            // Mañana lo hago yo
            UserDTO user = new UserDTO();
            UserDAO userDao = new UserDAO(conn);
            user.setUsername("Pepeeerino");
            user.setPassword("pass");
            user.setUserType(2);
            user = userDao.create(user);
            System.out.println("User's ID: " + user.getId());

            /*
            Este script inicial es correcto, a esto quiero llegar, pero es un error no implementar en la clase DAO
            los accesos a datos más genericos, si cada DAO tiene su
            tabla por separado para listarlos todos es la misma query solo que cambia la tabla
             */

            System.out.printf("TOdo pioli");
            //DML (data manipulation) && DDL (data definition)
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
