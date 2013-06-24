/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package management.interfaces;

/**
 *
 * @author Przemysław
 */
public interface IWindow {
    
    void registerAtManager(IWindowManager manager);
    
    void deRegisterAtManager(IWindowManager manager);
    
    Object respondToDataRequest(IWindowManager manager);
    
    void requestWindowData(Object data);
    
    IWindow getCaller();
}
