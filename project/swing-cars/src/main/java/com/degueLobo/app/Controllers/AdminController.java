/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Controllers;

import com.degueLobo.app.Managers.ApplicationManager;
import com.degueLobo.app.Models.AdminModel;
import com.degueLobo.app.Views.AdminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mjdegue
 */
public class AdminController extends Controller {
    private AdminModel model;
    private AdminView view;
    
    public AdminController(AdminModel model, AdminView view) {
        this.model = model;
        this.view = view;
        
        view.addLogOutListener(new LogOutEventListener());
    }
    
    private class LogOutEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ApplicationManager.logOut();
        }
    }
            
}
