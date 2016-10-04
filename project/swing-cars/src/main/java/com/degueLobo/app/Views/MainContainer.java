/*Avis
 Lobo/Degue*/

package com.degueLobo.app.Views;

import com.degueLobo.app.Templates.Lobo.CustomSideBar;
import com.degueLobo.app.Templates.Lobo.CustomToolbar;
import java.awt.BorderLayout;
import java.util.Stack;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author mjdegue
 */
public class MainContainer extends JFrame {
    private JComponent sideBar;
    private JComponent bottomMenu;
    private Stack<View> contentPanelStack;
    private View currentView;
    private JPanel mainPanel;
    private JComponent toolbar;
    
    public MainContainer() {
        mainPanel = new JPanel();
        contentPanelStack = new Stack<View>();
    }
    
    public void initialize() {
        setLayout(new BorderLayout());
        setTitle("Login View");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initializeComponents();
    }
    
    private void initializeComponents() {
    
        if(toolbar == null) {
            toolbar = new CustomToolbar();
        }
        
        add(toolbar, BorderLayout.PAGE_START);
        
        if(sideBar != null) {
            add(sideBar, BorderLayout.LINE_START);
        }
        
        if(bottomMenu != null) {
            add(bottomMenu, BorderLayout.PAGE_END);
        }
    }
    
    public void setSideBar(JComponent sideBar) {
        this.sideBar = sideBar;
        initializeComponents();
    }
    
    public void removeSideBar() {
        remove(this.sideBar);
        this.sideBar = null;
        updateScreen();
    }
    
    public void setSideBar(CustomSideBar sideBar) {
        this.sideBar = sideBar.getControlPanel();
        initializeComponents();
    }
    
    public void setTopMenu(JMenuBar mb) {
        setJMenuBar(mb);
    }
    
    public void setBottomMenu(JPanel bottomMenu) {
        this.bottomMenu = bottomMenu;
    }
    
    public void pushContentPanel(View contentPanel) {
        this.contentPanelStack.push(contentPanel);
        updateScreen();
    }
    
    public void popContentPanel(){
        contentPanelStack.pop();
        updateScreen();
    }
    
    private void updateScreen() {
        if(currentView != null) {
            //remove(currentView.getControlPanel());
            currentView.onHide();
        }
        
        if(!contentPanelStack.empty())
        {
            currentView = contentPanelStack.lastElement();
            currentView.onShow();
            //add(currentView.getControlPanel(), BorderLayout.CENTER);
        }
        SwingUtilities.updateComponentTreeUI(this);
    }
    
}
