package com.DAOTests;

import com.degueLobo.app.Entities.Users.ClientDTO;
import com.degueLobo.app.Models.AdminModel;

import java.util.List;

import org.junit.Test;

/**
 * Created by kefala on 18/10/16.
 */
public class ClienteTest {
    @Test
    public void create() {
        AdminModel am = new AdminModel();
        am.ingresarCliente("userName", "password", "nombre_U", "dni", "direccion", "telefono");
    }

    @Test
    public void getAll() {
        AdminModel am = new AdminModel();
        List<ClientDTO> list = am.getAllClientes();
        System.out.printf(list.get(0).getName());
    }
}
