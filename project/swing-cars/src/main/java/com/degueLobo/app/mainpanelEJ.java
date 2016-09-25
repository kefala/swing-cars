package com.degueLobo.app;

import javax.swing.*;

/**
 * Created by kefala on 25/09/16.
 */
public class mainpanelEJ {
    public static void mostrar() {
        JFrame mainFrame;
        JTextField usernameTxt;
        JPasswordField passwordTxt;
        mainFrame = new JFrame("AVIS");
        mainFrame.setSize(1200,768);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
