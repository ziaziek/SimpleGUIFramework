/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import forms.BaseForm;
import forms.Dialog;
import forms.DialogForm;
import forms.ErrorDialog;
import forms.QuestionDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Przemysław
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Files.copy(Paths.get("C:/X.txt"), Paths.get("C:/Y.txt"));
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
            
            JFrame f = new QuestionDialog("Are you sure you want to go?", "If you say yes, you will have no excuse not to go with her.",
                    new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.out.println("Action being performed.");
                    if(ae.getActionCommand().equals("YES")){
                      SwingUtilities.invokeLater(new Runnable(){

                          @Override
                          public void run() {
                              JFrame fr = new ErrorDialog("What?");
                              fr.setTitle("Window X");
                              fr.setVisible(true);
                          }
                      });
                        
                    }                  
                }
            });
            f = FormsCaller.callNewWindow("Window 1", f);
        }
    }
}
