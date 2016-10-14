/*Avis
Expression licensePrefix is undefined on line 4, column 3 in Templates/Licenses/license-default.txt.To change this license header, choose License Headers in Project Properties.
Expression licensePrefix is undefined on line 5, column 3 in Templates/Licenses/license-default.txt.To change this template file, choose Tools | Templates
Expression licensePrefix is undefined on line 6, column 3 in Templates/Licenses/license-default.txt.and open the template in the editor.
 Lobo/Degue*/

package com.degueLobo.app.Templates.CustomWidgets;

import java.awt.event.ActionListener;

/**
 *
 * @author mjdegue
 */
public class CustomTableButtonInfo{
    private ActionListener buttonListener;
    private String buttonLabel;
    public CustomTableButtonInfo(ActionListener buttonListener, String buttonLabel){
        this.buttonLabel = buttonLabel;
        this.buttonListener = buttonListener;
    }

    /**
     * @return the buttonListener
     */
    public ActionListener getButtonListener()
    {
        return buttonListener;
    }

    /**
     * @param buttonListener the buttonListener to set
     */
    public void setButtonListener(ActionListener buttonListener)
    {
        this.buttonListener = buttonListener;
    }

    /**
     * @return the buttonLabel
     */
    public String getButtonLabel()
    {
        return buttonLabel;
    }

    /**
     * @param buttonLabel the buttonLabel to set
     */
    public void setButtonLabel(String buttonLabel)
    {
        this.buttonLabel = buttonLabel;
    }
}
