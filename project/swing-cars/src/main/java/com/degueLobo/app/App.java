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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/avis", "appuser", "7LB7qBZh6Zjmqz7c");
            stm = conn.createStatement();
            String sql = "SELECT * FROM marca";
            ResultSet a = stm.executeQuery(sql);
            while(a.next())
            {
                int id = a.getInt("id");
                String marca = a.getString("nombre_marca");
                System.out.println("ID: " + id + "; Marca: " + marca);
            }

            conn.close();
            System.out.printf("TOdo pioli");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
