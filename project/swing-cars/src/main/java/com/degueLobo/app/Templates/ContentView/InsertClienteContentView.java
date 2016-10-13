/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Templates.ContentView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author mjdegue
 */
public class InsertClienteContentView extends CustomContentView {
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JTextField txtDireccion;
    private JTextField txtDni;
    private JTextField txtNombreUsuario; //This should be grey and filled in some other way.
    private JPasswordField password;
    private JPasswordField confirmPassword;
    private JButton confirmButton;
    private JButton cancelButton;
    
    public InsertClienteContentView(){
        txtNombre = new JTextField();
        txtTelefono = new JTextField();
        txtDireccion = new JTextField();
        txtNombreUsuario = new JTextField();
        txtDni = new JTextField();
        password = new JPasswordField();
        confirmPassword = new JPasswordField();
        confirmButton = new JButton("Accept");
        cancelButton = new JButton("Cancel");
        JPanel innerPanel = new JPanel();
        
        innerPanel.setPreferredSize(new Dimension(300, 200));
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.PAGE_AXIS));
        
        innerPanel.add(new JLabel("Nombre y Apellido:"));
        innerPanel.add(txtNombre);
        
        innerPanel.add(new JLabel("Numero de Telefono:"));
        innerPanel.add(txtTelefono);
        
        innerPanel.add(new JLabel("DNI:"));
        innerPanel.add(txtDni);
        
        innerPanel.add(new JLabel("Nombre de usuario:"));
        innerPanel.add(txtNombreUsuario);
        
        innerPanel.add(new JLabel("Password:"));
        innerPanel.add(password);
        
        innerPanel.add(new JLabel("Confirmar Password:"));
        innerPanel.add(confirmPassword);
        
        innerPanel.add(new JLabel("Direccion"));
        innerPanel.add(txtDireccion);
        
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
        dataMissed |= txtNombre.getText().isEmpty();
        dataMissed |= txtDireccion.getText().isEmpty();
        dataMissed |= txtDni.getText().isEmpty();
        dataMissed |= txtDireccion.getText().isEmpty();
        dataMissed |= txtTelefono.getText().isEmpty();
        dataMissed |= txtNombreUsuario.getText().isEmpty();
        
        String pass = String.valueOf(password.getPassword());
        dataMissed |= pass.isEmpty();
        String confirmPass = String.valueOf(confirmPassword.getPassword());
        dataMissed |= pass.isEmpty();
        
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
    
    public String getNombre() {
        return txtNombre.getText();
    }
    
    public String getDni() {
        return txtDni.getText();
    }
    
    public String getDireccion() {
        return txtDireccion.getText();
    }
    
    public String getTelefono() {
        return txtTelefono.getText();
    }
    
    public String getPassword() {
        return String.valueOf(password.getPassword());
    }
}
