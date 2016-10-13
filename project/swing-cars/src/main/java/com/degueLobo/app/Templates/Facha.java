package com.degueLobo.app.Templates;

import com.degueLobo.app.Templates.Lobo.MyFrame;

import javax.swing.*;

public class Facha {


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MyFrame();
            }
        });

    }
}