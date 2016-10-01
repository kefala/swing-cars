/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Views;

import com.degueLobo.app.Managers.ApplicationManager;
import com.degueLobo.app.Models.Model;
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
    private JFrame mainFrame;
    private JTextField userName;
    private JPasswordField password;
    private JButton goButton;

    
    public LoginView(Model m)
    {
        super(m);
        
        MainContainer mainContainer = ApplicationManager.getMainAppContainer();
        
        mainFrame = new JFrame();
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userName = new JTextField(10);
        password = new JPasswordField(10);
        goButton = new JButton("enter");
        
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.PAGE_AXIS));
        innerPanel.add(userName);
        innerPanel.add(password);
        innerPanel.add(goButton);
        controlPanel.add(innerPanel);
        
        mainContainer.setSideBar(this);
        mainContainer.setVisible(true);
    }
    
    public void AddEnterListener(ActionListener al)
    {
        goButton.addActionListener(al);
    }
    
    public String GetUsername()
    {
        return userName.getText();
    }
    
    public String GetPassword()
    {
        return String.valueOf(password.getPassword());
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
