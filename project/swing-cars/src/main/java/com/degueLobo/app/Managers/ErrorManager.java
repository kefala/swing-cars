/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Managers;

import javax.swing.JOptionPane;

/**
 *
 * @author mjdegue
 */
public class ErrorManager {
    public static void PopupException(Exception e) {
        JOptionPane.showConfirmDialog(null, e.toString(), "Error occurred", 0);
    }
}
