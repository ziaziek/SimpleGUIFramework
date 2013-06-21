/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package images;

import com.sun.xml.internal.ws.api.ResourceLoader;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Przemysław
 */
public class Images {
    
    public static final String GreenGradientBackground = "/images/Green-Gradient-Background.jpg";
    
    public static final String  RedGradientBackground = "/images/Red-Gradient-Background.jpg";
    
    public static final String BlueGradientBackground = "/images/Blue-Gradient-Background.jpg";
    
    public static ImageIcon getImageIcon(String im){
        return new ImageIcon(ResourceLoader.class.getResource(im));
    }
}
