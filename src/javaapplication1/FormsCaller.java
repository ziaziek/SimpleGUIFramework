/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Przemysław
 */
public class FormsCaller {
    
    
    
    public static JFrame callNewWindow(final String title, JFrame window){
        return callNewWindow(title,window,  JFrame.DISPOSE_ON_CLOSE, window.getPreferredSize());
    }
    
    public static JFrame callNewWindow(final String title, final JFrame f, final int behaviour, final Dimension d){
        SwingUtilities.invokeLater(new Runnable() { public void run() {
            Dimension winDim;
        if(d==null || f.getPreferredSize()==null){
            winDim = new Dimension(350, 250);
        } else {
            winDim = d;
        }
             f.setDefaultCloseOperation (behaviour);
             if(d==null){
                 
             }
             f.setPreferredSize(winDim);
             f.setTitle(title);
             f.pack();
             f.setVisible(true);
         } });
        return f;
    }
    
}
