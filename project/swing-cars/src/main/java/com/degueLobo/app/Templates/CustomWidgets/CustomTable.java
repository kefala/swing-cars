/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Templates.CustomWidgets;

import com.degueLobo.app.Entities.RowInfo;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mjdegue
 */
public class CustomTable extends JTable {
    RowInfo[] rowInfoList;
    String[] columnNames;
    Object[][] columnContent;
    
    public CustomTable(String[] columnNames, List<RowInfo> columnContent, List<CustomTableButtonInfo> buttonListenerList) 
    {
        this.columnNames = columnNames;
        this.columnContent = parseRowInfo(columnContent, buttonListenerList);
        setModel(new DefaultTableModel(this.columnContent, columnNames));
        int firstActionButton = columnNames.length - buttonListenerList.size();
        for(CustomTableButtonInfo a: buttonListenerList) 
        {
            new ButtonColumn(this, a.getButtonListener(), firstActionButton);
            ++firstActionButton;
        }
    }
    
    private Object[][] parseRowInfo(List<RowInfo> rowInfoList, List<CustomTableButtonInfo> buttonListenerList){
        Object[][] answer = new Object[rowInfoList.size()][columnNames.length];
        int i = 0;
        for(RowInfo rInfo: rowInfoList)
        {
            answer[i] = rInfo.getRowInfo();
            int columns = rInfo.getColumnNames().length;
            int firstColumn = columns - buttonListenerList.size();
            for(CustomTableButtonInfo info: buttonListenerList)
            {
                answer[i][firstColumn++] = info.getButtonLabel();
            }
            ++i;
        }
        return answer;
    }
}
