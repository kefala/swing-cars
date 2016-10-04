/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Views;

import com.degueLobo.app.Managers.ApplicationManager;
import com.degueLobo.app.Models.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author mjdegue
 */
public class FakeButtonView extends View{
    private JButton fakeButton;
    public FakeButtonView(Model m)
    {
        super(m);
        
        fakeButton = new JButton("fakeButton");
        //controlPanel.add(fakeButton);
    }

    public void AddFakeButtonListener(ActionListener al) {
        fakeButton.addActionListener(al);
    }
    @Override
    public void onShow()
    {
        
    }

    @Override
    public void onHide()
    {
        
    }
}
