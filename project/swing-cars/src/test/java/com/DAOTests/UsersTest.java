package com.DAOTests;

import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Entities.Utils.Roles;
import com.degueLobo.app.Models.AdminModel;

import org.junit.Test;

/**
 * Created by kefala on 14/10/16.
 */
public class UsersTest {
    @Test
    public void test() {
        System.out.printf("Facha");
    }

    @Test
    public void updateUser() {
        AdminModel am = new AdminModel();
        UserDTO user = am.editarUsuario(4, "Juancito", "pass", Roles.EMPLEADO);
        System.out.printf(user.getUsername());
    }

}
