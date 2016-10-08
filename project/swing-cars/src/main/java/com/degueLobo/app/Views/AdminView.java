/*Avis
Expression licensePrefix is undefined on line 4, column 3 in Templates/Licenses/license-default.txt.To change this license header, choose License Headers in Project Properties.
Expression licensePrefix is undefined on line 5, column 3 in Templates/Licenses/license-default.txt.To change this template file, choose Tools | Templates
Expression licensePrefix is undefined on line 6, column 3 in Templates/Licenses/license-default.txt.and open the template in the editor.
 Lobo/Degue*/

package com.degueLobo.app.Views;

import com.degueLobo.app.Managers.ApplicationManager;
import com.degueLobo.app.Models.Model;
import com.degueLobo.app.Templates.ContentView.InsertClienteContentView;
import com.degueLobo.app.Templates.SideBar.AdminSideBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mjdegue
 */
public class AdminView extends View {
    //Save the action listeners so when any new screen is pushed we can send the ActionListeners
    private ActionListener commitUserListener;
    private ActionListener commitClienteListener;
    private AdminSideBar adminSidebar;

    //Posible content screens:
    private InsertClienteContentView insertClientContentView;
    
    public AdminView(Model m)
    {
        super(m);
        adminSidebar = new AdminSideBar();
        ApplicationManager.getMainAppContainer().setSideBar(adminSidebar);
        adminSidebar.addNewClientButtonListener(new NewClientActionListener());
    }
    
    public void addLogOutListener(ActionListener al) {
        adminSidebar.addLogOutButtonListener(al);
    }
    
    @Override
    public void onShow() {
    }

    @Override
    public void onHide() {
    }
    
    public void addCommitClienteListener(ActionListener al) {
        this.commitClienteListener = al;
    }
    
    //this is for every type of role
    public void addCommitUserListener(ActionListener al) {
        this.commitUserListener = al;
    }

    public String getNombreUsuario() {
        return insertClientContentView.getNombreUsuario();
    }
    
    public String getNombre() {
        return insertClientContentView.getNombre();
    }
    
    public String getDni() {
        return insertClientContentView.getDni();
    }
    
    public String getDireccion() {
        return insertClientContentView.getDireccion();
    }
    
    public String getTelefono() {
        return insertClientContentView.getTelefono();
    }
    
    public String getPassword() {
        return insertClientContentView.getPassword();
    }
    
    private class NewClientActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            insertClientContentView = new InsertClienteContentView();
            ApplicationManager.getMainAppContainer().resetContentPanelStatus();
            ApplicationManager.getMainAppContainer().pushContentPanel(insertClientContentView);
            
            //aca depende del estado como se hace
            insertClientContentView.addConfirmActionListener(new ConfirmClientActionListener());
        }
    }
    
    //To check if all the data inserted is correct
    private class ConfirmClientActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<String> errorList = insertClientContentView.getErrors();
            if(errorList.isEmpty()) {
                commitClienteListener.actionPerformed(e);
            } else {
                //ApplicationManager -> crear metodo mostrar lista error
                JOptionPane.showConfirmDialog(null, "Errores");
            }
        }
    }
}
