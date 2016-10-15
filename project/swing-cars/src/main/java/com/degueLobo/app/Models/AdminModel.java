/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Models;

import com.degueLobo.app.Entities.Users.ClientDAO;
import com.degueLobo.app.Entities.Users.ClientDTO;
import com.degueLobo.app.Entities.Users.UserDAO;
import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Entities.Utils.Roles;
import com.degueLobo.app.Managers.ConnectionManager;
import com.degueLobo.app.Managers.ErrorManager;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mjdegue
 */
public class AdminModel extends Model {
    
    public ClientDTO ingresarCliente(String userName, String password, String nombre, String dni, String direccion, String telefono) { 
        ClientDTO cliente = new ClientDTO(userName, password, nombre, dni, direccion, telefono);
        ClientDTO newClient = null;
        
        try
        {
            ClientDAO dao = new ClientDAO(ConnectionManager.GetConnection());
            newClient = dao.create(cliente);
        } catch (SQLException e)
        {
            JOptionPane.showConfirmDialog(null, "Error al cargar usuario\n" + e.toString());
        }
        
        return newClient;
    }
    
    public UserDTO ingresarUsuario(String userName, String password, Roles rol) {
        UserDTO user = new UserDTO(userName, password, rol);
        UserDTO newUser = null;
        try
        {
            UserDAO dao = new UserDAO(ConnectionManager.GetConnection());
            newUser = dao.create(user);
        } catch (SQLException e)
        {
            JOptionPane.showConfirmDialog(null, "Error al cargar usuario\n" + e.toString());
        }
        return newUser;
    }
    
    public List<UserDTO> getAllUsers()
    {
        List<UserDTO> users = null;
        try
        {
            UserDAO dao = new UserDAO(ConnectionManager.GetConnection());
            users = dao.getAll();
        } catch (SQLException e)
        {
            ErrorManager.PopupException(e);
        }
        return users;
    }
}
