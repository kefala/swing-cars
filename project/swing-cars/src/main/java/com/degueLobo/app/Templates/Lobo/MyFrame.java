package com.degueLobo.app.Templates.Lobo;

import com.degueLobo.app.Templates.Toolbar.CustomToolbar;
import java.awt.*;

import javax.swing.*;

/**
 * Created by kefala on 27/9/16.
 */
public class MyFrame extends JFrame {
    private JLabel facha, fachita;
    private CustomToolbar fachota;

    public MyFrame() {
        super("Titulo de pagina");

        setLayout(new BorderLayout());

        fachota = new CustomToolbar();
        facha = new JLabel("Facha");
        fachita = new JLabel("Fachita");

        add(fachota, BorderLayout.NORTH);
        add(fachita, BorderLayout.SOUTH);
        add(facha, BorderLayout.CENTER);

        setVisible(true);
        setSize(1300, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
