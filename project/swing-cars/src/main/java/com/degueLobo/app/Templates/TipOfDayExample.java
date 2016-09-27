package com.degueLobo.app.Templates;
import javax.swing.*;
import java.awt.*;

public class TipOfDayExample extends JDialog {


    public TipOfDayExample() {

        initUI();
    }

    public final void initUI() {

        JPanel basic = new JPanel();
        basic.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));
        add(basic);

        JPanel topPanel = new JPanel(new BorderLayout(0, 0));
        topPanel.setMaximumSize(new Dimension(1500, 1000));
        topPanel.setSize(1000, 100);
        JLabel hint = new JLabel("JDeveloper Productivity Hints");
        hint.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        topPanel.add(hint);

        ImageIcon icon = new ImageIcon("jdev.png");
        JLabel label = new JLabel(icon);
        label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        topPanel.add(label, BorderLayout.EAST);

        JSeparator separator = new JSeparator();
        separator.setForeground(Color.gray);

        topPanel.add(separator, BorderLayout.SOUTH);

        basic.add(topPanel);

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));
        JTextPane pane = new JTextPane();

        pane.setContentType("text/html");
        String text = "<p><b>Closing windows using the mouse wheel</b></p>" +
                "<p>Clicking with the mouse wheel on an editor tab closes the window. " +
                "This method works also with dockable windows or Log window tabs.</p>";
        pane.setText(text);
        pane.setEditable(false);
        textPanel.add(pane);

        basic.add(textPanel);

        JPanel boxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));

        JCheckBox box = new JCheckBox("Show Tips at startup");

        boxPanel.add(box);
        basic.add(boxPanel);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton ntip = new JButton("Next Tip");
        JButton close = new JButton("Close");

        bottom.add(ntip);
        bottom.add(close);
        basic.add(bottom);

        bottom.setMaximumSize(new Dimension(450, 0));

        setTitle("Tip of the Day");
        setSize(new Dimension(450, 350));
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                TipOfDayExample ex = new TipOfDayExample();
                ex.setVisible(true);
            }
        });
    }
}