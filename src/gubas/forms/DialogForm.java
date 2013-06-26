/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.forms;

import gubas.icons.Icons;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Przemysław
 */
public class DialogForm extends BaseForm implements MouseListener{
    
    protected class OKButton extends JButton {
        String label = "OK";
        
        public OKButton(){
            super();
            super.setText("OK");
        }
        
        public OKButton(String txt){
            this(); //block constructors that are trying to set text to the button.
        }
        
        @Override
        public void setText(String t){
            
        }
    }
    
    protected class NOButton extends JButton{
        String txt = "NO";
        
        public NOButton(){
            super();
            super.setText("NO");
        }
        public NOButton(String txt){
            this();
        }
        
        @Override
        public void setText(String t){
            
        }
    }
    
    protected class YESButton extends JButton{
        String txt = "YES";
        
        public YESButton(){
            super();
            super.setText(txt);
           super.setActionCommand("YES");
        }
        
        public YESButton(String t){
            this();
        }
        
        @Override
        public void setText(String t){
            
        }
    }
    JLabel message = null;
    ArrayList<JButton> buttons = new ArrayList<>();
    
    
    public DialogForm(Dialog dialogType, String message){
        super();
        setPreferredSize(new Dimension(640, 480));
        createFormOf(dialogType);
        addMessage(message);
        //this.setAlwaysOnTop(true);
    }
    
    protected void addMessage(String message){
        if(message!=null){
            this.add(new JLabel(message), BorderLayout.NORTH);
        }
    }
   protected final void createFormOf(Dialog type){
       switch (type){
           case OK:
               buttons.add(new OKButton());
               break;
           case YES_NO:
               buttons.add(new YESButton());
               buttons.add(new NOButton());
               break;
           case ERROR:
               this.setBackground(Color.red);
               buttons.add(new OKButton());
               break;
       }
       JPanel buttonsPanel = new JPanel();
       buttonsPanel.setOpaque(false);
       for(JButton b: buttons){
          buttonsPanel.add(b); 
          b.addMouseListener(this);
       }
       add(buttonsPanel, BorderLayout.SOUTH);
       setResizable(false);
       
   }
   
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() instanceof OKButton || me.getSource() instanceof NOButton){
            this.dispose();
        }
    }

    protected JButton findFirstButtonOfType(Class<?> buttonClass){
        int i=0;
        while(i<buttons.size()){
            if(buttons.get(i).getClass().equals(buttonClass)){
                return buttons.get(i);
            }
            i++;
        }
        return null;
    }
    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
}
