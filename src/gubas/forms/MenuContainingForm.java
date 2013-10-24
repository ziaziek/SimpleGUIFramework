/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.forms;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;

/**
 *
 * @author Przemek
 */
public abstract class MenuContainingForm extends BaseForm implements ActionListener {
    
    protected JMenuBar myMenuBar;

    public JMenuBar getMyMenuBar() {
        return myMenuBar;
    }
    
    public MenuContainingForm(){
        super();
        add(createMenuBar(), BorderLayout.NORTH);
    }
    
    /**
     * This method creates and returns an empty MenuBar.
     * Should be overridden to specify elements and behaviour of the menu bar.
     * @return an instance of JMenuBar, specifocally the field called menuBar.
     */
    protected JMenuBar createMenuBar(){
        if(myMenuBar==null){
            myMenuBar = new JMenuBar();
        }
        return myMenuBar;
    }
}
