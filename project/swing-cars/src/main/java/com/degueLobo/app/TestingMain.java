/*Avis
 Lobo/Degue*/

package com.degueLobo.app;

import com.degueLobo.app.Entities.Autos.AutoDTO;
import com.degueLobo.app.Entities.Oficinas.OficinaDAO;
import com.degueLobo.app.Entities.Oficinas.OficinaDTO;
import com.degueLobo.app.Entities.Reservas.ItemReservaDAO;
import com.degueLobo.app.Entities.Reservas.ItemReservaDTO;
import com.degueLobo.app.Entities.Reservas.ReservaDAO;
import com.degueLobo.app.Entities.Reservas.ReservaDTO;
import com.degueLobo.app.Entities.Users.ClientDAO;
import com.degueLobo.app.Entities.Users.ClientDTO;
import com.degueLobo.app.Entities.Users.UserDAO;
import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Entities.Utils.Estados;
import com.degueLobo.app.Managers.ConnectionManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mjdegue
 */
public class TestingMain {
    public static void main( String[] args ) throws ParseException
    {
        try
        {
            List<UserDTO> userList = new UserDAO(ConnectionManager.GetConnection()).getAll();
            for(UserDTO i: userList)
            {
                System.out.println("item: " + i.getUsername());
            }
        } catch (SQLException e)
        {
            JOptionPane.showConfirmDialog(null, e.toString());
        }
    }
}
