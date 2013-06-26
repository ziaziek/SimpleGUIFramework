/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.management.interfaces;

import java.util.List;

/**
 *
 * @author Przemysław
 */
public interface IWindowManager {
    
    List<IWindow> getRegisteredWindows();
    
    void registerWindow(IWindow window);
    
    IWindow unRegisterWindow(IWindow window);
    
    boolean hasChildren(IWindow window);
    
    List<IWindow> getWindowChildren(IWindow window);
    
}
