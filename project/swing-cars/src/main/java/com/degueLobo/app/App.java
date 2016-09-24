package com.degueLobo.app;

import com.degueLobo.app.mvc.Controller;
import com.degueLobo.app.mvc.controllers.LoginController;
import com.degueLobo.app.mvc.models.LoginModel;
import com.degueLobo.app.mvc.views.LoginView;

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
