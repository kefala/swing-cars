/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Controllers;

import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Managers.ApplicationManager;
import com.degueLobo.app.Models.FakeButtonModel;
import com.degueLobo.app.Models.LoginModel;
import com.degueLobo.app.Views.FakeButtonView;
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
    }
    
    public void start() {
        v.AddEnterListener(new LoginListener());
    }
    
    private class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            UserDTO user = m.logUserIn(v.GetUsername(), v.GetPassword());
            
            if(user != null)
            {
                ApplicationManager.setCurrentUser(user);
                ApplicationManager.getMainAppContainer().removeSideBar();
            }
            else
            {
                JOptionPane.showConfirmDialog(null, "User or password invalid", "Login info", JOptionPane.DEFAULT_OPTION);
            }
        }
    }
    
}
