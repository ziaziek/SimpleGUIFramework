/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package management.interfaces;

import java.util.List;

/**
 *
 * @author Przemysław
 */
public interface IWindowManager {
    
    List<IWindow> getRegisteredWindows();
    
    void registerWindow(IWindow window);
    
    IWindow unRegisterWindow(IWindow window);
    
}
