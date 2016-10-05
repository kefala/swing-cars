/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Managers;

import com.degueLobo.app.Controllers.AdminController;
import com.degueLobo.app.Controllers.LoginController;
import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Models.AdminModel;
import com.degueLobo.app.Models.LoginModel;
import com.degueLobo.app.Views.AdminView;
import com.degueLobo.app.Views.LoginView;
import com.degueLobo.app.Views.MainContainer;
import javax.swing.JFrame;

/**
 *
 * @author mjdegue
 */
public class ApplicationManager {
    private static UserDTO currentUser;
    private static MainContainer mainAppContainer;
    
    public static MainContainer getMainAppContainer(){
        if(mainAppContainer == null) {
            mainAppContainer = new MainContainer();
            mainAppContainer.initialize();
            mainAppContainer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        return mainAppContainer;
    }
    
    public static void setCurrentUser(UserDTO user) {
        currentUser = user;
    }
    
    public static UserDTO getCurrentUser() {
        return currentUser;
    }
    
    public static void logOut() {
        if(currentUser != null){
            //Might logic based on role should be implemented here
            currentUser = null;
        }
        prepareLoginScreen();
    }
    
    public static void startApplication() {
        prepareLoginScreen();
    }
    
    public static void prepareLoginScreen() {
        LoginModel model = new LoginModel();
        LoginView view = new LoginView(model);
        new LoginController(view, model);
    }
    
    public static void prepareAdminScreen() {
        AdminModel model = new AdminModel();
        AdminView view = new AdminView(model);
        new AdminController(model, view);
    }
}
