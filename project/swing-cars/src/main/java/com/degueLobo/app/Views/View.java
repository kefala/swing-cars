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
    protected JPanel controlPanel;
    public View(Model m) {
        this.m = m;
        controlPanel = new JPanel();
    }
 
    public JPanel getControlPanel() {
        return controlPanel;
    }
    
    public Model getM()
    {
        return m;
    }
 
    public abstract void onShow();
    
    public abstract void onHide();
    
}
