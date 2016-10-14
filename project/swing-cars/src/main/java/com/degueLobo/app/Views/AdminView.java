/*Avis
Expression licensePrefix is undefined on line 4, column 3 in Templates/Licenses/license-default.txt.To change this license header, choose License Headers in Project Properties.
Expression licensePrefix is undefined on line 5, column 3 in Templates/Licenses/license-default.txt.To change this template file, choose Tools | Templates
Expression licensePrefix is undefined on line 6, column 3 in Templates/Licenses/license-default.txt.and open the template in the editor.
 Lobo/Degue*/

package com.degueLobo.app.Views;

import com.degueLobo.app.Entities.Utils.Roles;
import com.degueLobo.app.Managers.ApplicationManager;
import com.degueLobo.app.Models.Model;
import com.degueLobo.app.Templates.ContentView.InsertClienteContentView;
import com.degueLobo.app.Templates.ContentView.InsertUsuarioContentView;
import com.degueLobo.app.Templates.ContentView.UsersListView;
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
    private ActionListener commitClienteListener;
    private ActionListener commitUsuarioListener;
    private AdminSideBar adminSidebar;

    //Posible content screens:
    private InsertClienteContentView insertClientContentView;
    private InsertUsuarioContentView insertUsuarioContentView;
    
    public AdminView(Model m)
    {
        super(m);
        adminSidebar = new AdminSideBar();
        ApplicationManager.getMainAppContainer().setSideBar(adminSidebar);
        adminSidebar.addNewClientButtonListener(new NewClientActionListener());
        adminSidebar.addNewUserButtonListener(new NewUsuarioActionListener());
        adminSidebar.addUsersViewButtonListener(new GoToListUserView());
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
    
    public void addCommitUsuarioListener(ActionListener al) {
        this.commitUsuarioListener = al;
    }
    
    public String getNombreUsuario() {
        if(insertClientContentView != null) {
            return insertClientContentView.getNombreUsuario();
        } 
        else if(insertUsuarioContentView != null) {
            return insertUsuarioContentView.getNombreUsuario();
        }
        return "";
    }
    
    public String getNombre() {
        
        if(insertClientContentView != null) {
            return insertClientContentView.getNombre();
        } 
        return "";
    }
    
    public String getDni() {
        
        if(insertClientContentView != null) {
            return insertClientContentView.getDni();
        } 
        return "";
    }
    
    public String getDireccion() {
        if(insertClientContentView != null) {
            return insertClientContentView.getDireccion();
        }
        return "";
    }
    
    public String getTelefono() {
        if(insertClientContentView != null) {
            return insertClientContentView.getTelefono();
        }
        return "";
    }
    
    public String getPassword() {
        if(insertClientContentView != null) {
            return insertClientContentView.getPassword();
        }
        else if(insertUsuarioContentView != null) {
            return insertUsuarioContentView.getPassword();
        }
        return "";
    }
    
    public Roles getRol() {
        if(insertUsuarioContentView != null) {
            return insertUsuarioContentView.getRole();
        }
        return null;
    }
    
    private void clearScreenData() {
        insertClientContentView = null;
        insertUsuarioContentView = null;
    }
    
    private class NewClientActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clearScreenData();
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
                if(commitUsuarioListener != null) {
                    commitClienteListener.actionPerformed(e);
                }
            } else {
                //ApplicationManager -> crear metodo mostrar lista error
                JOptionPane.showConfirmDialog(null, "Errores");
            }
        }
    }
    
    private class NewUsuarioActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clearScreenData();
            insertUsuarioContentView = new InsertUsuarioContentView();
            ApplicationManager.getMainAppContainer().resetContentPanelStatus();
            ApplicationManager.getMainAppContainer().pushContentPanel(insertUsuarioContentView);
            
            //aca depende del estado como se hace
            insertUsuarioContentView.addConfirmActionListener(new ConfirmUsuarioActionListener());
        }
    }
    
    //To check if all the data inserted is correct
    private class ConfirmUsuarioActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<String> errorList = insertUsuarioContentView.getErrors();
            if(errorList.isEmpty()) {
                if(commitUsuarioListener != null) {
                    commitUsuarioListener.actionPerformed(e);
                }
            } else {
                //ApplicationManager -> crear metodo mostrar lista error
                JOptionPane.showConfirmDialog(null, "Errores");
            }
        }
    }

    private class GoToListUserView implements ActionListener {
        private UsersListView userListView;

        public void actionPerformed(ActionEvent e) {
            clearScreenData();
            userListView = new UsersListView();
            ApplicationManager.getMainAppContainer().resetContentPanelStatus();
            ApplicationManager.getMainAppContainer().pushContentPanel(userListView);
        }
    }
}
