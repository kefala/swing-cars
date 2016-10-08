/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Controllers;

import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Entities.Utils.Roles;
import com.degueLobo.app.Managers.ApplicationManager;
import com.degueLobo.app.Models.LoginModel;
import com.degueLobo.app.Templates.SideBar.AdminSideBar;
import com.degueLobo.app.Templates.Toolbar.AdminToolBar;
import com.degueLobo.app.Views.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author mjdegue
 */
public class LoginController {
    private LoginView v;
    private LoginModel m;
    
    public LoginController(LoginView v, LoginModel m) {
        this.v = v;
        this.m = m;
        v.AddEnterListener(new LoginListener());
    }
    
    private class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            UserDTO user = m.logUserIn(v.GetUsername(), v.GetPassword());
            
            if(user != null)
            {
                ApplicationManager.setCurrentUser(user);
                
                //This all should be moved somewhere else. For now is for testing :)
                //ApplicationManager.getMainAppContainer().setSideBar(new AdminSideBar());
                if(user.getRol() == Roles.ADMINISTRADOR) {
                    ApplicationManager.prepareAdminLayout();
                } else {
                    JOptionPane.showConfirmDialog(null, "Aun no hay otro rol que no sea ADMIN", "Login info", JOptionPane.DEFAULT_OPTION);
                }
            }
            else
            {
                JOptionPane.showConfirmDialog(null, "User or password invalid", "Login info", JOptionPane.DEFAULT_OPTION);
            }
        }
    }
    
}
