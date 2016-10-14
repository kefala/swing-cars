/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Templates.CustomWidgets;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author mjdegue
 */
public class CustomTable extends JTable {
    String[] columnNames;
    Object[][] columnContent;
    
    public CustomTable(String[] columnNames, Object[][] columnContent, List<ActionListener> buttonListenerList) 
    {
        super(new DefaultTableModel(columnContent, columnNames));
        this.columnContent = columnContent;
        this.columnNames = columnNames;
        int firstActionButton = columnNames.length - buttonListenerList.size();
        for(ActionListener a: buttonListenerList) 
        {
            new ButtonColumn(this, a, firstActionButton);
            ++firstActionButton;
        }
    }
    
    
}
