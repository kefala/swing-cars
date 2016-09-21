/*Degue Maximiliano, Nicolas Conde, TODO: ADD HERE
 FightingQuestionClub To change this license header, choose License Headers in Project Properties.
 FightingQuestionClub To change this template file, choose Tools | Templates
 FightingQuestionClub and open the template in the editor.
 The game*/

package com.degueLobo.app.Managers;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mjdegue
 */
public class ConnectionManager {
    private static String server = "localhost:3306";
    private static String database = "avis";
    private static String user = "appuser";
    private static String password = "7LB7qBZh6Zjmqz7c";
    
    public static void InitializeManager(String server, String database, String user, String password)
    {
        ConnectionManager.server = server;
        ConnectionManager.database = database;
        ConnectionManager.user = user;
        ConnectionManager.password = password;
    }
    
    public static Connection GetConnection() throws SQLException
    {
        Connection conn = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database, user, password);
        return conn;
    }
}
/*
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
        }*/