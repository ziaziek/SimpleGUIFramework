/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.forms;

import javax.swing.JLabel;
import javax.swing.JPanel;
import gubas.icons.Icons;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 *
 * @author Przemysław
 */
public class QuestionDialog extends DialogForm{
 
    public QuestionDialog(String question, String info, ActionListener yesAction){
        this(question, info);
        JButton b = null;
        if((b = findFirstButtonOfType(YESButton.class))!=null){
            b.addActionListener(yesAction);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public QuestionDialog(String question, String info){
        super( Dialog.YES_NO, question);
        addInfo(info);
    }
    
    @Override
    protected void addMessage(String message){
        JPanel messPan = new JPanel();
        try {
            messPan.add(new JLabel(Icons.getIcon(Icons.QuestionMark48)));
        } catch (IOException ex) {
            Logger.getLogger(QuestionDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        messPan.add(new JLabel(message));
        messPan.setOpaque(false);
        this.add(messPan, BorderLayout.NORTH);
    }
    
    protected void addInfo(String info){
        add(new JLabel("  " +info), BorderLayout.CENTER);
    }
}
