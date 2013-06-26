/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.forms;

/**
 *
 * @author Przemysław
 */
public class DataForm extends BaseForm {
    
    public void setData(Object data) throws Exception{
        throw new Exception("This method must be overridden.");
    }
    
    public Object getData() throws Exception{
        throw new Exception("This method must be overridden");
    }
}
