package com.DAOTests;

import com.degueLobo.app.Entities.Users.ClientDTO;
import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Entities.Utils.Roles;
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
        am.ingresarCliente("kefalikoiko", "gato", "Martín Lobo", "38029675", "direccion sarasa", "1168884769");
    }

    @Test
    public void getAll() {
        AdminModel am = new AdminModel();
        List<ClientDTO> list = am.getAllClientes();
        System.out.printf(list.get(0).getName());
    }

    @Test
    public void update() {
        AdminModel am = new AdminModel();
        UserDTO user = new UserDTO(17, "", "", Roles.CLIENTE);
        ClientDTO client = am.editarCliente(1, "chefita", "44444", "J alvarez", "1167676767", user);
        System.out.printf(client.getName() + "asfa" + client.getUser().getUsername() );
    }
}
