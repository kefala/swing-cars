/*Avis
Lobo/Degue*/

package com.degueLobo.app.Templates.ContentView;

import com.degueLobo.app.Entities.Utils.Roles;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author mjdegue
 */
public class InsertUsuarioContentView extends CustomContentView {
    private JTextField txtNombreUsuario; //This should be grey and filled in some other way.
    private JPasswordField password;
    private JPasswordField confirmPassword;
    private JButton confirmButton;
    private JButton cancelButton;
    private JComboBox rolesComboBox;
    public InsertUsuarioContentView(){
        txtNombreUsuario = new JTextField();
        password = new JPasswordField();
        confirmPassword = new JPasswordField();
        confirmButton = new JButton("Accept");
        cancelButton = new JButton("Cancel");
        JPanel innerPanel = new JPanel();
        
        innerPanel.setPreferredSize(new Dimension(300, 200));
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.PAGE_AXIS));
        
        innerPanel.add(new JLabel("Nombre de usuario:"));
        innerPanel.add(txtNombreUsuario);
        
        innerPanel.add(new JLabel("Password:"));
        innerPanel.add(password);
        
        innerPanel.add(new JLabel("Confirmar Password:"));
        innerPanel.add(confirmPassword);
    
        Vector<ComboBoxRow> rolRows = new Vector<ComboBoxRow>();
        rolRows.add(new ComboBoxRow(-1, "Elegir Rol:"));
        Roles[] roles = Roles.getRolesVector();
        for (int i = 0; i < roles.length; ++i)
        {
            Roles rol = roles[i];
            rolRows.add(new ComboBoxRow(rol.getId(), rol.getName()));
        }
        rolesComboBox = new JComboBox(rolRows);
        innerPanel.add(new JLabel("Elija rol de usuario:"));
        innerPanel.add(rolesComboBox);
        
        innerPanel.add(confirmButton);
        innerPanel.add(cancelButton);
        innerPanel.setBackground(Color.WHITE);
        
        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(innerPanel, BorderLayout.WEST);
        controlPanel.setBackground(Color.WHITE);
    }
    
    public void addConfirmActionListener(ActionListener al) {
        confirmButton.addActionListener(al);
    }
    
    public void addCancelActionListener(ActionListener al) {
        cancelButton.addActionListener(al);
    }
    
    public List<String> getErrors() {
        List<String> errorList = new ArrayList<String>();
        boolean dataMissed = false;
        
        dataMissed |= txtNombreUsuario.getText().isEmpty();
        String pass = String.valueOf(password.getPassword());
        dataMissed |= pass.isEmpty();
        String confirmPass = String.valueOf(confirmPassword.getPassword());
        dataMissed |= pass.isEmpty();
        dataMissed |= ((ComboBoxRow)rolesComboBox.getSelectedItem()).value == -1;
        
        if(dataMissed) {
           errorList.add("Some fields are empty.");
        }
        
        if(!pass.equals(confirmPass)) {
            errorList.add("Passwords doesnt match.");
        }
        
        return errorList;
    }
    
    public String getNombreUsuario() {
        return txtNombreUsuario.getText();
    }
    
    public String getPassword() {
        return String.valueOf(password.getPassword());
    }
    
    public Roles getRole() {
        ComboBoxRow selectedRow = (ComboBoxRow)rolesComboBox.getSelectedItem();
        return Roles.getRolById(selectedRow.value);
    }

    private class ComboBoxRow {
        int value;
        String text;
        ComboBoxRow(int value, String text){
            this.value = value;
            this.text = text;
        }
        
        @Override
        public String toString(){
            return this.text;
        }
    }
}
