/*Avis
Expression licensePrefix is undefined on line 4, column 3 in Templates/Licenses/license-default.txt.To change this license header, choose License Headers in Project Properties.
Expression licensePrefix is undefined on line 5, column 3 in Templates/Licenses/license-default.txt.To change this template file, choose Tools | Templates
Expression licensePrefix is undefined on line 6, column 3 in Templates/Licenses/license-default.txt.and open the template in the editor.
 Lobo/Degue*/

package com.degueLobo.app.Templates.SideBar;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author mjdegue
 */
public class LoginSideBar extends CustomSideBar {
    private JTextField userName;
    private JPasswordField password;
    private JButton goButton;
    private JLabel label, label2, label3;

    public LoginSideBar() {
        userName = new JTextField(10);
        label = new JLabel("Usuario");
        label2 = new JLabel("Contraseña");
        label3 = new JLabel();
        password = new JPasswordField(10);
        goButton = new JButton("enter");

        label.setBorder(new EmptyBorder(10, 10, 10, 10));
        label2.setBorder(new EmptyBorder(10, 10, 10, 10));
        label3.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.PAGE_AXIS));
        innerPanel.add(label);
        innerPanel.add(userName);
        innerPanel.add(label2);
        innerPanel.add(password);
        innerPanel.add(label3);
        innerPanel.add(goButton);
        innerPanel.setBackground(Color.GRAY);

        controlPanel.add(innerPanel);
        controlPanel.setBackground(Color.GRAY);
    }
    
    public void AddEnterListener(ActionListener al)
    {
        goButton.addActionListener(al);
    }
    
    public String getUserName()
    {
        return userName.getText();
    }
    
    public String getPassword()
    {
        return String.valueOf(password.getPassword());
    }
}
