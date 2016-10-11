/*Avis
Expression licensePrefix is undefined on line 4, column 3 in Templates/Licenses/license-default.txt.To change this license header, choose License Headers in Project Properties.
Expression licensePrefix is undefined on line 5, column 3 in Templates/Licenses/license-default.txt.To change this template file, choose Tools | Templates
Expression licensePrefix is undefined on line 6, column 3 in Templates/Licenses/license-default.txt.and open the template in the editor.
 Lobo/Degue*/

package com.degueLobo.app.Controllers;

import com.degueLobo.app.Managers.ApplicationManager;
import com.degueLobo.app.Models.EmpleadoModel;
import com.degueLobo.app.Views.EmpleadoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mjdegue
 */
public class EmpleadoController extends Controller{
    private EmpleadoView view;
    private EmpleadoModel model;
    
    public EmpleadoController(EmpleadoView view, EmpleadoModel model) {
        this.view = view;
        this.model = model;
        
        this.view.addLogOutListener(new LogOutEventListener());
    }
    
    private class LogOutEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ApplicationManager.logOut();
        }
    }
    
}
