/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Views;

import com.degueLobo.app.Models.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author mjdegue
 */
public abstract class View {
    private Model m;
    public View(Model m) {
        this.m = m;
    }
 
    public Model getM()
    {
        return m;
    }
 
    public abstract void onShow();
    
    public abstract void onHide();
    
}
