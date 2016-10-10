/*Avis
Expression licensePrefix is undefined on line 4, column 3 in Templates/Licenses/license-default.txt.To change this license header, choose License Headers in Project Properties.
Expression licensePrefix is undefined on line 5, column 3 in Templates/Licenses/license-default.txt.To change this template file, choose Tools | Templates
Expression licensePrefix is undefined on line 6, column 3 in Templates/Licenses/license-default.txt.and open the template in the editor.
 Lobo/Degue*/

package com.degueLobo.app.Templates.SideBar;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author mjdegue
 */
public class EmpleadoSideBar extends CustomSideBar {
    private JButton newReservation;
    private JButton newClient;
    private JButton logOut;
    
    public EmpleadoSideBar() {
        newReservation = new JButton("Create Reservation");
        newClient = new JButton("Create Client");
        logOut = new JButton("Log Out");
        
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.PAGE_AXIS));
        innerPanel.add(newReservation);
        innerPanel.add(newClient);
        innerPanel.add(logOut);
        innerPanel.setBackground(Color.GRAY);
        controlPanel.add(innerPanel);
        controlPanel.setBackground(Color.GRAY);
    }
}
