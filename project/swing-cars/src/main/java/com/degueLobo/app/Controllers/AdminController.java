/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Controllers;

import com.degueLobo.app.Entities.Users.ClientDTO;
import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Managers.ApplicationManager;
import com.degueLobo.app.Models.AdminModel;
import com.degueLobo.app.Templates.Toolbar.AdminToolBar;
import com.degueLobo.app.Views.AdminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author mjdegue
 */
public class AdminController extends Controller {
    private AdminModel model;
    private AdminView view;
    
    public AdminController(AdminModel model, AdminView view) {
        this.model = model;
        this.view = view;
        
        view.addLogOutListener(new LogOutEventListener());
        view.addCommitClienteListener(new CommitClientEventListener());
        view.addCommitUsuarioListener(new CommitUserEventListener());
        view.addOnShowListener(new OnAdminViewShowEventListener());
        AdminToolBar toolbar = new AdminToolBar();
        toolbar.initialize();
        ApplicationManager.getMainAppContainer().setToolBar(toolbar);
    }
    
    private class LogOutEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ApplicationManager.logOut();
        }
    }
            
    private class CommitClientEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ClientDTO client = model.ingresarCliente(view.getNombreUsuario(), view.getPassword(), view.getNombre(), view.getDni(), view.getDireccion(), view.getTelefono());
            if(client != null) {
                ApplicationManager.getMainAppContainer().resetContentPanelStatus();
            } else {
                JOptionPane.showConfirmDialog(ApplicationManager.getMainAppContainer().getContentPane(), "El Cliente no pudo ser ingresado", "Error", JOptionPane.DEFAULT_OPTION);
            }
        }
    }

    private class CommitUserEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            UserDTO user = model.ingresarUsuario(view.getNombreUsuario(), view.getPassword(), view.getRol());
            if(user != null) {
                ApplicationManager.getMainAppContainer().resetContentPanelStatus();
            } else {
                JOptionPane.showConfirmDialog(ApplicationManager.getMainAppContainer().getContentPane(), "El Cliente no pudo ser ingresado", "Error", JOptionPane.DEFAULT_OPTION);
            }
        }
    }
    
    private class OnAdminViewShowEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AdminView source = (AdminView) e.getSource();
            source.pushUserListInfo(model.getAllUsers());
        }
    }

}
