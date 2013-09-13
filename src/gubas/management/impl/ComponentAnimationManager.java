/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.management.impl;

import gubas.management.interfaces.AnimationManagable;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Przemysław
 */
public class ComponentAnimationManager {
    
    Timer t = null;
    
    AnimationManagable animComp = null;
    
    Integer timerInterval = 2;
    
    public ComponentAnimationManager(AnimationManagable aC){
        animComp = aC;
        t = new Timer(timerInterval, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if (animComp.getCurrentAlpha() < 255) {
                        animComp.repaint();
                        animComp.setCurrentAlpha(animComp.getCurrentAlpha()+15);
                    } else {
                        //curAlfa = 0;
                    }
            }
        });
      
        }
        
    
    public void animate(){
        animComp.setCurrentAlpha(0);
        if (t.isRunning()) {
            t.setRepeats(false);
            t.stop();

        }
        t.setRepeats(true);
        t.start();
    }
}
