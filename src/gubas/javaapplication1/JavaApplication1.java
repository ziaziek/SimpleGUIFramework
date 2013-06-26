/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.javaapplication1;

import gubas.components.TableComponent;
import gubas.forms.*;
import gubas.icons.Icons;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Przemysław
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataForm f = new DataForm();
        TableComponent tc = new TableComponent(new Object[][]{{0,0,0}, {0,0,0}}, new String[]{"A","B", "C"});
        tc.setOpaque(false);
        f.add(tc);
        FormsCaller.callNewWindow("Table window", f);
    }
}
