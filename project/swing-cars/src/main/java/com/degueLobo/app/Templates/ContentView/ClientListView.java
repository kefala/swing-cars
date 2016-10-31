package com.degueLobo.app.Templates.ContentView;

import com.degueLobo.app.Entities.RowInfo;
import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Entities.Users.UserRowInfo;
import com.degueLobo.app.Templates.CustomWidgets.CustomTable;
import com.degueLobo.app.Templates.CustomWidgets.CustomTableButtonInfo;
import com.degueLobo.app.Views.AdminView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * Created by kefala on 13/10/16.
 */
public class ClientListView extends CustomContentView  {

    private JTable table;
    private JLabel fileUser, title;
    private JPanel innerPanel;
    private JScrollPane scrollPane;
    private ActionListener editAction;
    private ActionListener deleteAction;
    private CustomTable customTable;
    private List<UserDTO> userList;

    public ClientListView() {

    }
    public void initialize()
    {
        innerPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(innerPanel, BorderLayout.WEST);
        controlPanel.setBackground(Color.WHITE);
    }

    public void dataPushed(String[]columnNames, List<UserDTO> userList)
    {
        this.userList = userList;

        List<RowInfo> rowList = getUserRowInfo(userList);

        List<CustomTableButtonInfo> buttonInfoList = new ArrayList<CustomTableButtonInfo>();
        buttonInfoList.add(new CustomTableButtonInfo(new EditAction(), "edit"));
        buttonInfoList.add(new CustomTableButtonInfo(new DeleteAction(), "delete"));
        CustomTable p = new CustomTable(columnNames, rowList, buttonInfoList);

        if(scrollPane != null)
        {
            innerPanel.remove(scrollPane);
        }

        scrollPane = new JScrollPane(p);
        innerPanel.add(scrollPane);

    }

    public void addEditActionListener(ActionListener al) {
        this.editAction = al;
    }

    public void addDeleteActionListener(ActionListener al) {
        this.deleteAction = al;
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
            editAction.actionPerformed(new ActionEvent(userList.get(index), AdminView.AdminViewEvents.EDIT_USER_FROM_LIST, null));
        }
    }
}
