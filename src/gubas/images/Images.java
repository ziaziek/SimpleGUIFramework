/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.images;


import javax.swing.ImageIcon;

/**
 *
 * @author Przemysław
 */
public class Images {
    
    public static final String GreenGradientBackground = "Green-Gradient-Background.jpg";
    
    public static final String  RedGradientBackground = "Red-Gradient-Background.jpg";
    
    public static final String BlueGradientBackground = "Blue-Gradient-Background.jpg";
    
    public static ImageIcon getImageIcon(String im){
        return new ImageIcon(Images.class.getResource(im));
    }
}
