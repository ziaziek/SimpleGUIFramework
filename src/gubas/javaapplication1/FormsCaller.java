/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.javaapplication1;

import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Przemysław
 */
public class FormsCaller {
    
    
    
    public  static void callNewWindow(final String title, JFrame window){
         callNewWindow(title,window,  JFrame.DISPOSE_ON_CLOSE, window.getPreferredSize());
    }
    
    public  static void callNewWindow(final String title, final JFrame f, final int behaviour, final Dimension d){
            SwingUtilities.invokeLater(new Runnable() { 
                @Override
                public void run() {
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
    }
    
}
