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
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mjdegue
 */
public class AdminModel extends Model {


    public List<UserDTO> getAllUsers()
    {
        List<UserDTO> userList = null;
        try
        {
            userList = new UserDAO(ConnectionManager.GetConnection()).getAll();
        } catch (SQLException e)
        {
        }
        return userList;
    }

    public List<ClientDTO> getAllClientes()
    {
        List<ClientDTO> clientList = null;
        try
        {
            clientList = new ClientDAO(ConnectionManager.GetConnection()).getAll();
        } catch (SQLException e)
        {
        }
        return clientList;
    }

    public ClientDTO ingresarCliente(String userName, String password, String nombre, String dni, String direccion, String telefono) { 
        ClientDTO cliente = new ClientDTO(userName, password, nombre, dni, direccion, telefono);
        ClientDTO newClient = null;
        try {
            ClientDAO dao = new ClientDAO(ConnectionManager.GetConnection());
            newClient = dao.create(cliente);
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error al cargar usuario\n" + e.toString());
        }
        return newClient;
    }
    
    public UserDTO ingresarUsuario(String userName, String password, Roles rol) {
        UserDTO user = new UserDTO(userName, password, rol);
        UserDTO newUser = null;
        try {
            UserDAO dao = new UserDAO(ConnectionManager.GetConnection());
            newUser = dao.create(user);
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error al cargar usuario\n" + e.toString());
        }
        return newUser;
    }

    public UserDTO editarUsuario(Integer id, String userName, String password, Roles rol) {
        UserDTO user = new UserDTO(id, userName, password, rol);
        try {
            UserDAO dao = new UserDAO(ConnectionManager.GetConnection());
            user = dao.update(user);
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error al editar el usuario\n" + e.toString());
        }
        return user;
    }

    public List<UserDTO> getAdminAndVendedor() {
        List<UserDTO> usersList = Collections.emptyList();
        try {
            UserDAO userDAO = new UserDAO(ConnectionManager.GetConnection());
            usersList = userDAO.getAdminAndVendedor();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }
    
    public boolean deleteUser(UserDTO user) {
        boolean ans = false;
        try
        {
            UserDAO dao = new UserDAO(ConnectionManager.GetConnection());
            dao.delete(user.getId());
        } catch (SQLException e)
        {
        }
        
        return ans;
    }

    public boolean deleteClient(ClientDTO client) {
        boolean ans = false;
        try
        {
            ClientDAO dao = new ClientDAO(ConnectionManager.GetConnection());
            UserDAO userDAO = new UserDAO(ConnectionManager.GetConnection());
            dao.delete(client.getId());
            userDAO.delete(client.getUser().getId());
        } catch (SQLException e)
        {
        }

        return ans;
    }

    public ClientDTO editarCliente(Integer id, String nombre, String dni, String direccion, String telefono, UserDTO user) {
        ClientDTO cliente = new ClientDTO(id, user, nombre, dni, direccion, telefono);
        try {
            ClientDAO dao = new ClientDAO(ConnectionManager.GetConnection());
            cliente = dao.update(cliente);
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error al editar el usuario\n" + e.toString());
        }
        return cliente;
    }

}
