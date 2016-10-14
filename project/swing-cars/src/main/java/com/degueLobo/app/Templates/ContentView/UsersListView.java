package com.degueLobo.app.Templates.ContentView;

import com.degueLobo.app.Entities.RowInfo;
import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Entities.Users.UserRowInfo;
import com.degueLobo.app.Entities.Utils.Roles;
import com.degueLobo.app.Models.UsuariosModel;
import com.degueLobo.app.Templates.CustomWidgets.ButtonColumn;
import com.degueLobo.app.Templates.CustomWidgets.CustomTable;
import com.degueLobo.app.Templates.CustomWidgets.CustomTableButtonInfo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 * Created by kefala on 13/10/16.
 */
public class UsersListView extends CustomContentView  {
    private JTable table;
    private JLabel fileUser, title;
    
    public UsersListView() {
        JPanel innerPanel = new JPanel();
        
        /*String[] cNames= {"nombre", "usuario", "", ""};
        Object[][] content = {{"juan", "j01", "editar", "borrar", new Object()},
                                {"oeoe", "o01", "editar", "borrar", new Object()}};
        */
        UserDTO user1 = new UserDTO("usuario1", Roles.EMPLEADO);
        user1.setId(1);
        UserDTO user2 = new UserDTO("usuario2", Roles.ADMINISTRADOR);
        user2.setId(2);
        List<RowInfo> rowList = new ArrayList<RowInfo>();
        UserRowInfo rowInfo = new UserRowInfo(user1);
        rowList.add(rowInfo);
        rowList.add(new UserRowInfo(user2));

        List<ActionListener> actions = new ArrayList<ActionListener>();
        
        actions.add(new EditAction());
        actions.add(new DeleteAction());
        
        List<CustomTableButtonInfo> buttonInfoList = new ArrayList<CustomTableButtonInfo>();
        buttonInfoList.add(new CustomTableButtonInfo(new EditAction(), "edit"));
        buttonInfoList.add(new CustomTableButtonInfo(new DeleteAction(), "delete"));
        CustomTable p = new CustomTable(rowInfo.getColumnNames(), rowList, buttonInfoList);
        innerPanel.add(new JScrollPane(p));
        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(innerPanel, BorderLayout.WEST);
        controlPanel.setBackground(Color.WHITE);
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
