/*Avis
Lobo/Degue*/

package com.degueLobo.app.Templates.SideBar;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author mjdegue
 */
public class AdminSideBar extends CustomSideBar {
    private JButton newUser;
    private JButton newClient;
    private JButton logOut;
    public AdminSideBar() {
        newUser = new JButton("Create User");
        newClient = new JButton("Create Client");
        logOut = new JButton("Log Out");
        
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.PAGE_AXIS));
        innerPanel.add(newUser);
        innerPanel.add(newClient);
        innerPanel.add(logOut);
        innerPanel.setBackground(Color.GRAY);
        controlPanel.add(innerPanel);
        controlPanel.setBackground(Color.GRAY);
    }
    
    public void addNewUserButtonListener(ActionListener al) {
        newUser.addActionListener(al);
    }
    
    public void addNewClientButtonListener(ActionListener al) {
        newClient.addActionListener(al);
    }
    
    public void addLogOutButtonListener(ActionListener al) {
        logOut.addActionListener(al);
    }
}
