/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Controllers;

import com.degueLobo.app.Managers.ApplicationManager;
import com.degueLobo.app.Views.FakeButtonView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author mjdegue
 */
public class FakeButtonController extends Controller {
    private FakeButtonView v;
    private FakeButtonModel m;
    
    FakeButtonController(FakeButtonView v, FakeButtonModel m) {
        this.v = v;
        this.m = m;
        v.AddFakeButtonListener(new ButtonListener());
    }
    
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            if(m.ConfirmExitScreen()) {
                ApplicationManager.getMainAppContainer().popContentPanel();
            }
        }
    }

}
