/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Views;

import com.degueLobo.app.Managers.ApplicationManager;
import com.degueLobo.app.Models.Model;
import com.degueLobo.app.Templates.SideBar.EmpleadoSideBar;
import java.awt.event.ActionListener;

/**
 *
 * @author mjdegue
 */
public class EmpleadoView extends View{
    private EmpleadoSideBar empleadoSideBar;
    public EmpleadoView(Model m)
    {
        super(m);
        empleadoSideBar = new EmpleadoSideBar();
        ApplicationManager.getMainAppContainer().setSideBar(empleadoSideBar);
        
    }

    public void addLogOutListener(ActionListener al) {
        empleadoSideBar.addLogOutButtonListener(al);
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
