/*Avis
 Lobo/Degue*/

package com.degueLobo.app;

import com.degueLobo.app.Entities.Oficinas.OficinaDAO;
import com.degueLobo.app.Entities.Oficinas.OficinaDTO;
import com.degueLobo.app.Entities.Reservas.ReservaDAO;
import com.degueLobo.app.Entities.Reservas.ReservaDTO;
import com.degueLobo.app.Entities.Users.ClientDAO;
import com.degueLobo.app.Entities.Users.ClientDTO;
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
            ReservaDAO d = new ReservaDAO(ConnectionManager.GetConnection());
            ReservaDTO r = d.find(2);
            
            System.out.println("Reserva: " + r.getDescripcion());

        } catch (SQLException e)
        {
            JOptionPane.showConfirmDialog(null, e.toString());
        }
    }
}
