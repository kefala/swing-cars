/*Avis
Expression licensePrefix is undefined on line 4, column 3 in Templates/Licenses/license-default.txt.To change this license header, choose License Headers in Project Properties.
Expression licensePrefix is undefined on line 5, column 3 in Templates/Licenses/license-default.txt.To change this template file, choose Tools | Templates
Expression licensePrefix is undefined on line 6, column 3 in Templates/Licenses/license-default.txt.and open the template in the editor.
 Lobo/Degue*/

package com.degueLobo.app.Models;

import javax.swing.JOptionPane;

/**
 *
 * @author mjdegue
 */
public class FakeButtonModel extends Model {
    public boolean ConfirmExitScreen() {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to go to the previous page?", "Login info", JOptionPane.YES_NO_OPTION);
        return option == JOptionPane.YES_OPTION;    
    }
}
