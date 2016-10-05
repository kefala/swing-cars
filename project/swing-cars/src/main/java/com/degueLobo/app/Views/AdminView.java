/*Avis
Expression licensePrefix is undefined on line 4, column 3 in Templates/Licenses/license-default.txt.To change this license header, choose License Headers in Project Properties.
Expression licensePrefix is undefined on line 5, column 3 in Templates/Licenses/license-default.txt.To change this template file, choose Tools | Templates
Expression licensePrefix is undefined on line 6, column 3 in Templates/Licenses/license-default.txt.and open the template in the editor.
 Lobo/Degue*/

package com.degueLobo.app.Views;

import com.degueLobo.app.Managers.ApplicationManager;
import com.degueLobo.app.Models.Model;
import com.degueLobo.app.Templates.SideBar.AdminSideBar;
import java.awt.event.ActionListener;

/**
 *
 * @author mjdegue
 */
public class AdminView extends View {
    private AdminSideBar adminSidebar;

    public AdminView(Model m)
    {
        super(m);
        adminSidebar = new AdminSideBar();
        ApplicationManager.getMainAppContainer().setSideBar(adminSidebar);
    }
    
    public void addLogOutListener(ActionListener al) {
        adminSidebar.addLogOutButtonListener(al);
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
