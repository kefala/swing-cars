/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Managers;

import com.degueLobo.app.Entities.Users.UserDTO;
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
    
    
}
