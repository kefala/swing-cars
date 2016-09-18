package com.degueLobo.app;

import java.sql.Connection;
import java.sql.DriverManager;
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
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "1234asdf");
            conn.close();
            System.out.printf("TOdo pioli");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
