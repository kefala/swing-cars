/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Controllers;

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
    }
    
    public void start() {
        v.mostrar();
        v.AddEnterListener(new LoginListener());
    }
    
    private class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            boolean b = m.ConfirmLogin(v.GetUsername(), v.GetPassword());
            
            if(b)
            {
                JOptionPane.showConfirmDialog(null, "Logged in correctly", "Login info", JOptionPane.OK_OPTION);
            }
            else
            {
                v.pushFakeScreen(new FakeListener());
                JOptionPane.showConfirmDialog(null, "Logged failure", "Login info", JOptionPane.OK_OPTION);
            }
        }
    }
    
    private class FakeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            v.popFakeScreen();
        }
    }
}
