/*Avis
Expression licensePrefix is undefined on line 4, column 3 in Templates/Licenses/license-default.txt.To change this license header, choose License Headers in Project Properties.
Expression licensePrefix is undefined on line 5, column 3 in Templates/Licenses/license-default.txt.To change this template file, choose Tools | Templates
Expression licensePrefix is undefined on line 6, column 3 in Templates/Licenses/license-default.txt.and open the template in the editor.
 Lobo/Degue*/

package com.degueLobo.app.Templates.Toolbar;

import com.degueLobo.app.Managers.ApplicationManager;

/**
 *
 * @author mjdegue
 */
public class AdminToolBar extends CustomToolbar {
    public AdminToolBar() {
        
    }
    
    public void initialize() {
        setTitle("Welcome, " + ApplicationManager.getCurrentUser().getUsername());
    }
}
