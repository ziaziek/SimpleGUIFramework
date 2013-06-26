/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.forms;

import gubas.icons.Icons;
import javax.swing.JLabel;
import gubas.images.Images;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Przemysław
 */
public class ErrorDialog extends DialogForm {
    
    JTextArea causeArea;
    JScrollPane scroll;
    
    public ErrorDialog(String message, Throwable e){
        this(message);
        if(e!=null){
            StackTraceElement[] sel = e.getStackTrace();
            causeArea = new JTextArea(18,60);
            causeArea.setEditable(false);
            scroll = new JScrollPane(causeArea);
            causeArea.append(e.toString()+": \n");
            for(StackTraceElement el : sel){
                causeArea.append(el.toString()+"\n");
            }
            if(e.getCause()!=null){
                causeArea.append(e.getCause().getLocalizedMessage());
            }
        }
        
        if(causeArea!=null){
            causeArea.setBorder(new BevelBorder(BevelBorder.LOWERED));
            causeArea.setMinimumSize(new Dimension(50, 50));
            causeArea.setPreferredSize(new Dimension(50, 150));
        }
        if(scroll!=null){
                scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                this.add(scroll, BorderLayout.CENTER);
            }
        
    }
    
    public ErrorDialog(String message){
        super(Dialog.ERROR, message);
        
    }
    
    @Override
    protected void addMessage(String message){
        JPanel messPan = new JPanel();
        try {
            messPan.add(new JLabel(Icons.getIcon(Icons.ErrorIcon48)), BorderLayout.BEFORE_FIRST_LINE);
        } catch (IOException ex) {
            Logger.getLogger(ErrorDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        messPan.add(new JLabel(message));
        this.add(messPan, BorderLayout.NORTH);
    }
    @Override
    protected void setFormBackground(){
        this.mainLabel = new JLabel(Images.getImageIcon(Images.RedGradientBackground));
    }
}
