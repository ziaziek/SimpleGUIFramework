/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package management.impl;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import management.interfaces.IWindow;
import management.interfaces.IWindowManager;

/**
 *
 * @author Przemysław
 */
public class DefaultWindowManager implements IWindowManager {

    List<IWindow> windows = new ArrayList<>();
    
    private static IWindowManager m = null;
    
    public static IWindowManager getInstance(){
        if(m==null){
            m = new DefaultWindowManager();
        }
        return m;
    }
    
    private DefaultWindowManager(){
        
    }
    
    @Override
    public List<IWindow> getRegisteredWindows() {
        return windows;
    }

    @Override
    public void registerWindow(IWindow window) {
        boolean alreadyRegistered = false;
        int i=0;
        while(i<windows.size() && !alreadyRegistered){
            alreadyRegistered =  window.equals(windows.get(i));     
        }
        if(!alreadyRegistered){
            windows.add(window);
        }
    }

    @Override
    public IWindow unRegisterWindow(IWindow window) {
        if(windows.contains(window)){
            windows.remove(window);
            if(windows.isEmpty()){
            m = null;
        }
            return window;
        }
        return null;
        
    }
    
}
