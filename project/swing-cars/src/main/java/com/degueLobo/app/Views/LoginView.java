/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Views;

import com.degueLobo.app.Managers.ApplicationManager;
import com.degueLobo.app.Models.Model;
import com.degueLobo.app.Templates.Lobo.LoginSideBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;

import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author mjdegue
 */
public class LoginView extends View {
    private LoginSideBar loginSideBar;
    
    public LoginView(Model m)
    {
        super(m);
        
        loginSideBar = new LoginSideBar();
        
        MainContainer mainContainer = ApplicationManager.getMainAppContainer();
        
        
        mainContainer.setSideBar(loginSideBar);
        mainContainer.setVisible(true);
    }
    
    public void AddEnterListener(ActionListener al)
    {
        loginSideBar.AddEnterListener(al);
    }
    
    public String GetUsername()
    {
        return loginSideBar.getUserName();
    }
    
    public String GetPassword()
    {
        return loginSideBar.getPassword();
    }
    
    public void pushFakeScreen(ActionListener al) {
        ApplicationManager.getMainAppContainer().pushContentPanel(new FakeButtonView(getM()));
    }
    
    @Override
    public void onShow()
    {
        //Empty for now
        //Here we should fill the screen info.
    }

    @Override
    public void onHide()
    {
        //If someone has to be done when the screen is hide, do it here.
    }

}
