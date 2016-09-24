/*Avis
 Lobo/Degue*/

package com.degueLobo.app.mvc;

import com.degueLobo.app.mvc.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mjdegue
 */
public abstract class View {
    private Model m;
    
 public View(Model m) {
        this.m = m;
        this.m.addExceptionListener(new ExceptionListener());
    }
 
 public Model getM()
    {
        return m;
    }
 
 public abstract void mostrar();
 
 public abstract void mostrarException(String exception);
 
    private class ExceptionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            mostrarException(event.getActionCommand());
        }
    }

}