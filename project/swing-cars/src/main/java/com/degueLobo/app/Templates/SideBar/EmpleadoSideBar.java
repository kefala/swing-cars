/*Avis
Expression licensePrefix is undefined on line 4, column 3 in Templates/Licenses/license-default.txt.To change this license header, choose License Headers in Project Properties.
Expression licensePrefix is undefined on line 5, column 3 in Templates/Licenses/license-default.txt.To change this template file, choose Tools | Templates
Expression licensePrefix is undefined on line 6, column 3 in Templates/Licenses/license-default.txt.and open the template in the editor.
 Lobo/Degue*/

package com.degueLobo.app.Templates.SideBar;

import com.degueLobo.app.Templates.ContentView.InsertClienteContentView;
import java.awt.Color;
import java.awt.event.ActionListener;
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
    
    private InsertClienteContentView insertClienteContentView;
    
    public EmpleadoSideBar() {
        newReservation = new JButton("Crear Reserva");
        newClient = new JButton("Crear Client");
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
    
    
    public void addNewUserButtonListener(ActionListener al) {
        newReservation.addActionListener(al);
    }
    
    public void addNewClientButtonListener(ActionListener al) {
        newClient.addActionListener(al);
    }
    
    public void addLogOutButtonListener(ActionListener al) {
        logOut.addActionListener(al);
    }
}
