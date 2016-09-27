/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Views;

import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author mjdegue
 */
public class MainContainer {
    private JPanel sideBar;
    private JPanel bottomMenu;
    private Stack<JPanel> contentPanelStack;
    private JPanel currentContentPanel;
    private JPanel mainPanel;
    private JFrame mainFrame;
    
    public MainContainer() {
        mainPanel = new JPanel();
        mainFrame = new JFrame();
        contentPanelStack = new Stack<JPanel>();
    }
    
    public void show() {
        mainFrame.setTitle("Login View");
        mainFrame.setContentPane(mainPanel);
        mainFrame.pack();
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //mainFrame.setLocationRelativeTo(mainPanel); // Centrar
        mainFrame.setVisible(true);
    }
            
    
    public void setSideBar(JPanel sideBar) {
        this.sideBar = sideBar;
    }
    
    public void setBottomMenu(JPanel bottomMenu) {
        this.bottomMenu = bottomMenu;
    }
    
    public void pushContentPanel(JPanel contentPanel) {
        this.contentPanelStack.push(contentPanel);
        updateScreen();
    }
    
    public void popContentPanel(){
        contentPanelStack.pop();
        updateScreen();
    }
    
    public void initialize() {
        if(sideBar != null) {
            mainPanel.add(sideBar);
        }
        
        if(bottomMenu != null) {
            mainPanel.add(bottomMenu);
        }
        
        if(!contentPanelStack.empty()){
            mainPanel.add(contentPanelStack.lastElement());
        }
    }
    
    private void updateScreen() {
        if(currentContentPanel != null) {
            mainPanel.remove(currentContentPanel);
        }
        
        if(!contentPanelStack.empty())
        {
            currentContentPanel = contentPanelStack.lastElement();
            mainPanel.add(currentContentPanel);
            SwingUtilities.updateComponentTreeUI(mainPanel);
        }
        
    }
    
}
