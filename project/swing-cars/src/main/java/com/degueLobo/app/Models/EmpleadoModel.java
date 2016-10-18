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




}
