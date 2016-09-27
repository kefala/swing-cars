/*Avis
Expression licensePrefix is undefined on line 4, column 3 in com.degueLobo.app.Templates/Licenses/license-default.txt.To change this license header, choose License Headers in Project Properties.
Expression licensePrefix is undefined on line 5, column 3 in com.degueLobo.app.Templates/Licenses/license-default.txt.To change this template file, choose Tools | com.degueLobo.app.Templates
Expression licensePrefix is undefined on line 6, column 3 in com.degueLobo.app.Templates/Licenses/license-default.txt.and open the template in the editor.
 Lobo/Degue*/

package com.degueLobo.app.Views;

import com.degueLobo.app.Models.Model;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author mjdegue
 */
public class LoginView extends View {
    private JFrame mainFrame;
    private JPanel panel;
    private JTextField userName;
    private JPasswordField password;
    private JButton goButton;
    private MainContainer mContainer;
    
    public LoginView(Model m)
    {
        super(m);
        
        mContainer = new MainContainer();
        
        
        mainFrame = new JFrame();
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userName = new JTextField(10);
        password = new JPasswordField(10);
        goButton = new JButton("enter");

        panel = new JPanel();
        panel.add(userName);
        panel.add(password);
        panel.add(goButton);
        
        mContainer.pushContentPanel(panel);
        mContainer.show();
    }
    @Override
    public void mostrar()
    {/*
        mainFrame.setTitle("Login View");
        mainFrame.setContentPane(panel);
        mainFrame.pack(); // Ajustar tama�o
        mainFrame.setLocationRelativeTo(null); // Centrar
        mainFrame.setVisible(true);
*/
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
        JPanel fakePanel = new JPanel();
        JButton fakeButton = new JButton("fakeButton");
        fakeButton.addActionListener(al);
        fakePanel.add(fakeButton);
        mContainer.pushContentPanel(fakePanel);
    }
    
    public void popFakeScreen() {
        mContainer.popContentPanel();
    }
    
    @Override
    public void mostrarException(String exception)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | com.degueLobo.app.Templates.
    }

}
