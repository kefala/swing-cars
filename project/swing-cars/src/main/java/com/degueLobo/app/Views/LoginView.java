/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Views;

import com.degueLobo.app.Managers.ApplicationManager;
import com.degueLobo.app.Models.Model;
import com.degueLobo.app.Templates.SideBar.LoginSideBar;
import com.degueLobo.app.Templates.Toolbar.CustomToolbar;

import java.awt.event.ActionListener;

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
        mainContainer.setToolBar(new CustomToolbar());
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
