/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Controllers;

import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Entities.Utils.Roles;
import com.degueLobo.app.Managers.ApplicationManager;
import com.degueLobo.app.Models.LoginModel;
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
                
                if(user.getRol() != null) {
                    switch (user.getRol())
                    {
                        case ADMINISTRADOR:
                            ApplicationManager.prepareAdminLayout();
                            break;
                        case EMPLEADO:
                            ApplicationManager.prepareEmpleadoLayout();
                            break;
                        default:
                            JOptionPane.showConfirmDialog(null, "Aun no hay rol cliente", "Login info", JOptionPane.DEFAULT_OPTION);
                            break;
                    }
                }
            }
            else
            {
                JOptionPane.showConfirmDialog(null, "User or password invalid", "Login info", JOptionPane.DEFAULT_OPTION);
            }
        }
    }
}
