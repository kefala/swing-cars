/*Avis
Expression licensePrefix is undefined on line 4, column 3 in Templates/Licenses/license-default.txt.To change this license header, choose License Headers in Project Properties.
Expression licensePrefix is undefined on line 5, column 3 in Templates/Licenses/license-default.txt.To change this template file, choose Tools | Templates
Expression licensePrefix is undefined on line 6, column 3 in Templates/Licenses/license-default.txt.and open the template in the editor.
 Lobo/Degue*/

package com.degueLobo.app.Models;

import com.degueLobo.app.Entities.Users.ClientDAO;
import com.degueLobo.app.Entities.Users.ClientDTO;
import com.degueLobo.app.Entities.Users.UserDAO;
import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Managers.ConnectionManager;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author mjdegue
 */
public class EmpleadoModel extends Model {

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
