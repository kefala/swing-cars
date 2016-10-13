/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Templates.ContentView;

import javax.swing.JPanel;

/**
 *
 * @author mjdegue
 */
public class CustomContentView {
    protected JPanel controlPanel;
    
    protected CustomContentView(){
        controlPanel = new JPanel();
    }
    
    public JPanel getControlPanel() {
        return controlPanel;
    }

}
