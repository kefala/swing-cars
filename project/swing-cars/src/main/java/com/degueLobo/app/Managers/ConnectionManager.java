/*Degue Maximiliano, Nicolas Conde, TODO: ADD HERE
 FightingQuestionClub To change this license header, choose License Headers in Project Properties.
 FightingQuestionClub To change this template file, choose Tools | com.degueLobo.app.Templates
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
    //por lo que hable con corsi esto tiene que se un singleton, por lo que solo tenemos que inicializarlo una vez.
    //SI podes revisar como lo hizo corsi seria genial.
    public static Connection GetConnection() throws SQLException
    {
        Connection conn = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database, user, password);
        return conn;
    }
}
