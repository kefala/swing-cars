package com.degueLobo.app.Templates.ContentView;

import com.degueLobo.app.Entities.Users.UserDTO;
import com.degueLobo.app.Models.UsuariosModel;
import com.degueLobo.app.Templates.CustomWidgets.ButtonColumn;
import com.degueLobo.app.Templates.CustomWidgets.CustomTable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
        
        String[] cNames= {"nombre", "usuario", "", ""};
        Object[][] content = {{"juan", "j01", "editar", "borrar"},
                                {"oeoe", "o01", "editar", "borrar"}};
        
        List<ActionListener> actions = new ArrayList<ActionListener>();
        
        actions.add(new EditAction());
        actions.add(new DeleteAction());
        
        CustomTable p = new CustomTable(cNames, content, actions);
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
            String str = (String)table.getValueAt(index, 1);
            JOptionPane.showConfirmDialog(null, "Deletting: " + str);
        }
    }
    
    
    private class EditAction implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            JTable table = (JTable)e.getSource();
            Integer index = Integer.valueOf(e.getActionCommand());
            String str = (String)table.getValueAt(index, 1);
            JOptionPane.showConfirmDialog(null, "edit: " + str);
        }
    }
}
