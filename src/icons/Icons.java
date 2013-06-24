/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package icons;


import java.util.ResourceBundle;
import javax.swing.ImageIcon;

/**
 *
 * @author Przemysław
 */
public class Icons {
    
    public final static String HelpIcon48 = "/icons/help_48.png";
    
    public final static String HelpIcon32 = "/icons/help_32.png";
    
    public final static String ErrorIcon120 = "/icons/Error_icon.png";
    
    public static final String ErrorIcon48 = "/icons/Error_icon_48.png";
    
    public static final String QuestionMark48 = "/icons/Question-Mark-Icon.png";
    
    
    public static ImageIcon getIcon(String icon){
        return new ImageIcon(ResourceBundle.class.getResource(icon));
    }
}
