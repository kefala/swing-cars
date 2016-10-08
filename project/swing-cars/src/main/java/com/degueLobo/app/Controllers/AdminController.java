/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Controllers;

import com.degueLobo.app.Entities.Users.ClientDTO;
import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Entities.Utils.Roles;
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
                JOptionPane.showInputDialog(null, "Ingresado correctamente!");
            }
        }
    }
}
