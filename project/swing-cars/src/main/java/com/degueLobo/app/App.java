package com.degueLobo.app;

import java.sql.*;

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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "1234asdf");
            stm = conn.createStatement();
            String sql = "SELECT * FROM user";
            ResultSet a = stm.executeQuery(sql);
            System.out.printf(a.toString());

            conn.close();
            System.out.printf("TOdo pioli");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
