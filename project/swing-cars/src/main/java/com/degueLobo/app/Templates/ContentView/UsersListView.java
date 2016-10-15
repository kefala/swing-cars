package com.degueLobo.app.Templates.ContentView;

import com.degueLobo.app.Entities.RowInfo;
import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Entities.Users.UserRowInfo;
import com.degueLobo.app.Entities.Utils.Roles;
import com.degueLobo.app.Templates.CustomWidgets.CustomTable;
import com.degueLobo.app.Templates.CustomWidgets.CustomTableButtonInfo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * Created by kefala on 13/10/16.
 */
public class UsersListView extends CustomContentView  {
    private JTable table;
    private JLabel fileUser, title;
    
    private ActionListener editAction;
    private ActionListener deleteAction;
    
    private List<UserDTO> userList;
    
    public UsersListView() {
        
    }
    
    public void dataPushed(String[]columnNames, List<UserDTO> userList)
    {
        JPanel innerPanel = new JPanel();
        this.userList = userList;
        
        List<RowInfo> rowList = getUserRowInfo(userList);
        
        List<CustomTableButtonInfo> buttonInfoList = new ArrayList<CustomTableButtonInfo>();
        buttonInfoList.add(new CustomTableButtonInfo(new EditAction(), "edit"));
        buttonInfoList.add(new CustomTableButtonInfo(new DeleteAction(), "delete"));
        CustomTable p = new CustomTable(columnNames, rowList, buttonInfoList);
        innerPanel.add(new JScrollPane(p));
        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(innerPanel, BorderLayout.WEST);
        controlPanel.setBackground(Color.WHITE);
    }
    
    private List<RowInfo> getUserRowInfo(List<UserDTO> users)
    {
        List<RowInfo> answer = new ArrayList<RowInfo>();
        for(UserDTO user: users)
        {
            answer.add(new UserRowInfo(user));
        }
        return answer;
    }
    
    private class DeleteAction implements ActionListener 
    {
        public void actionPerformed(ActionEvent e)
        {
            JTable table = (JTable)e.getSource();
            Integer index = Integer.valueOf(e.getActionCommand());
            String str = ((Object)table.getValueAt(index, 4)).toString();
            JOptionPane.showConfirmDialog(null, "Deletting: " + str);
        }
    }
    
    
    private class EditAction implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            JTable table = (JTable)e.getSource();
            Integer index = Integer.valueOf(e.getActionCommand());
            String str = ((Object)table.getValueAt(index, 3)).toString();
            JOptionPane.showConfirmDialog(null, "edit: " + str);
        }
    }
}
