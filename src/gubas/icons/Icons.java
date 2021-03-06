/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.icons;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Przemysław
 */
public class Icons {
    
    public final static String HelpIcon48 = "help_48.png";
    
    public static String HelpIcon32 = "help_32.png";
    
    public final static String ErrorIcon120 = "Error_icon.png";
    
    public static final String ErrorIcon48 = "Error_icon_48.png";
    
    public static final String QuestionMark48 = "Question-Mark-Icon.png";
    
    public static final String MoveLeftIcon = "Reverse-Play-icon_32.png";
    
    public static final String MoveRightIcon = "Play-icon_32.png";
    
    public static final String PlusIcon48 = "Plus-icon_48.png";
    
    public static final String MinusIcon48 = "Minus-icon_48.png";
    
    public static final String PlusIcon32 = "Plus-icon_32.png";
    
    public static final String MinusIcon32 = "Minus-icon_32.png";
    
    
    public static ImageIcon getIcon(final String icon) throws IOException{
        BufferedImage im = ImageIO.read(Icons.class.getResourceAsStream(icon));
        return new ImageIcon(im);
    }
}
