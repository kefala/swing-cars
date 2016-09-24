/*Avis
Lobo/Degue*/

package com.degueLobo.app.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mjdegue
 */
public abstract class Model {
    private ActionListener listener;
    
    protected void reportException(String exception) {
        if (listener != null) {
            ActionEvent evt = new ActionEvent(this, 0, exception);
            listener.actionPerformed(evt);
        }
    }

    public void addExceptionListener(ActionListener listener) {
        this.listener = listener;
    }
}