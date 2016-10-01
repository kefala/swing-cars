package com.degueLobo.app.Templates.Lobo;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by kefala on 27/9/16.
 */
public class CustomToolbar extends JPanel {

    JLabel title;

    public CustomToolbar() {
        setBackground(Color.black);

        setLayout(new BorderLayout());


        title = new JLabel("Welcome");
        title.setForeground(Color.GRAY);
        title.setBorder(new EmptyBorder(10, 10, 10, 10));

        add(title, BorderLayout.WEST);
    }
}
