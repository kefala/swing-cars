package com.degueLobo.app.Templates.Toolbar;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by kefala on 27/9/16.
 */
public class CustomToolbar extends JPanel {

    private JLabel title;

    public CustomToolbar() {
        setBackground(Color.black);

        setLayout(new BorderLayout());


        title = new JLabel("Welcome");
        title.setForeground(Color.GRAY);
        title.setBorder(new EmptyBorder(10, 10, 10, 10));

        add(title, BorderLayout.WEST);
    }
    
    public void setTitle(String title) {
        this.title.setText(title);
    }
}
