/*Avis
Expression licensePrefix is undefined on line 4, column 3 in Templates/Licenses/license-default.txt.To change this license header, choose License Headers in Project Properties.
Expression licensePrefix is undefined on line 5, column 3 in Templates/Licenses/license-default.txt.To change this template file, choose Tools | Templates
Expression licensePrefix is undefined on line 6, column 3 in Templates/Licenses/license-default.txt.and open the template in the editor.
 Lobo/Degue*/

package com.degueLobo.app.Templates.Lobo;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author mjdegue
 */
public class LoginSideBar extends CustomSideBar {
    private JTextField userName;
    private JPasswordField password;
    private JButton goButton;

    public LoginSideBar() {
        userName = new JTextField(10);
        password = new JPasswordField(10);
        goButton = new JButton("enter");
        
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.PAGE_AXIS));
        innerPanel.add(userName);
        innerPanel.add(password);
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
