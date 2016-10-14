package com.degueLobo.app.Templates.ContentView;

import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Models.UsuariosModel;

import java.awt.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by kefala on 13/10/16.
 */
public class UsersListView extends CustomContentView  {
    private JLabel fileUser, title;
    public UsersListView() {
        JPanel innerPanel = new JPanel();

        title = new JLabel("Usuarios");

        innerPanel.setPreferredSize(new Dimension(300, 200));
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.PAGE_AXIS));

        title.setBorder(new EmptyBorder(30,20,40,20));
        innerPanel.add(title);


        UsuariosModel userModel = new UsuariosModel();

        List<UserDTO> userList =  userModel.getAdminAndVendedor();

        for (UserDTO user: userList) {
            fileUser = new JLabel(user.getUsername() + " - " + user.getRol().getName());
            fileUser.setBorder(new EmptyBorder(10,30,10,30));
            innerPanel.add(fileUser);
        }

        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(innerPanel, BorderLayout.WEST);
        controlPanel.setBackground(Color.WHITE);
    }
}
