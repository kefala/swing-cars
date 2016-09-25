package com.degueLobo.app;

import com.degueLobo.app.Controllers.LoginController;
import com.degueLobo.app.Models.LoginModel;
import com.degueLobo.app.Views.LoginView;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        LoginModel model = new LoginModel();
        LoginView view = new LoginView(model);
        LoginController con = new LoginController(view, model);
        con.start();
        
    }
}
