/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import images.Images;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import management.impl.DefaultWindowManager;
import management.interfaces.IWindow;
import management.interfaces.IWindowManager;

/**
 *
 * @author Przemysław
 */
public class BaseForm extends JFrame implements IWindow{
    
    IWindowManager wmngr = null;
    JLabel mainLabel;
  JPanel btmStrip;
  IWindow caller = null;

    public IWindow getCaller() {
        return caller;
    }

    public void setCaller(IWindow caller) {
        this.caller = caller;
    }
    
   public BaseForm(IWindowManager mngr){
       setPreferredSize(new Dimension(640, 480));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        setFormBackground();
        mainLabel.setLayout(new BorderLayout());
        super.add(mainLabel, BorderLayout.CENTER);
        createBottomStrip();
        this.pack();
       wmngr = mngr;
       mngr.registerWindow(this);
   }
   
    public BaseForm(){
        this(DefaultWindowManager.getInstance());
    }
    
    protected void setFormBackground(){
        mainLabel = new JLabel(Images.getImageIcon(Images.BlueGradientBackground));
    }
    
    protected final void createBottomStrip(){
        
        super.add(new BaseBottomStrip(), BorderLayout.SOUTH);
    }
  
    public Component add(Component c, String position){
        if(mainLabel!=null && c!=null){
           this.mainLabel.add(c, position); 
        }
        return c;
    }

    
    @Override
    public void dispose(){
        if(wmngr!=null){
            wmngr.unRegisterWindow(this);
        }
        super.dispose();
    }
    
    @Override
    public void registerAtManager(IWindowManager manager) {
        if(manager!=null){
            manager.registerWindow(this);
            this.wmngr = manager;
        }
        
    }

    @Override
    public void deRegisterAtManager(IWindowManager manager) {
        manager = null;
    }

    @Override
    public Object respondToDataRequest(IWindowManager manager) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void requestWindowData(Object data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
