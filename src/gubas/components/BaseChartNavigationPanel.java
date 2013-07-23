/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import gubas.icons.Icons;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Przemek
 */
public class BaseChartNavigationPanel extends JPanel{
    
    
    public static final String ZOOM_IN_COMMAND = "zoomin";
    public static final String ZOOM_OUT_COMMAND = "zoomout";
    public static final String MOVE_LEFT_COMMAND = "moveLeft";
    public static final String MOVE_RIGHT_COMMAND = "moveRight";
    
    JLabel naviTxt;    
    JPanel labPanel;
    JPanel buttonsPanel;
    JButton moveLeft, moveRight, zoomIn, zoomOut;
    protected JComponent[] panelComponents;
    ActionListener buttonsListener;

    public ActionListener getButtonsListener() {
        return buttonsListener;
    }

    public void setButtonsListener(ActionListener buttonsListener) {
        this.buttonsListener = buttonsListener;
    }

    public BaseChartNavigationPanel(String naviLabel) {
        this.setLayout(new BorderLayout());
        naviTxt = new JLabel(naviLabel);
        buttonsPanel = new JPanel();
        labPanel = new JPanel();
        createNaviButtons();
        panelComponents = new JComponent[]{moveLeft, zoomIn, zoomOut, moveRight};
    }
    
    public void buildPanel() throws Exception{
        if(buttonsListener!=null){
            buildPanel(buttonsListener);
        } else {
            throw new Exception("Buttons listener not set!");
        }
    }
    
    public void buildPanel(ActionListener l) {
        if (l != null) {
            for (int i = 0; i < panelComponents.length; i++) {
                if (panelComponents[i] != null) {
                System.out.println("Not null");
                    buttonsPanel.add(panelComponents[i]);
                    if (panelComponents[i] instanceof AbstractButton) {
                        ((AbstractButton) panelComponents[i]).addActionListener(l);
                    }
                }
            }
        }
        buttonsPanel.setPreferredSize(new Dimension(50, 60));
        buttonsPanel.setBackground(Color.WHITE);
        labPanel.add(naviTxt);
        this.add(labPanel, BorderLayout.NORTH);
        this.add(buttonsPanel, BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(50, 70));
    }
    
    protected void createNaviButtons(){
        moveLeft = createNaviButton(Icons.MoveLeftIcon, "Left");
        moveRight = createNaviButton(Icons.MoveRightIcon, "Right");
        zoomIn = createNaviButton(Icons.PlusIcon32, "Zoom In");
        zoomOut = createNaviButton(Icons.MinusIcon32, "Zoom Out");
        moveLeft.setPreferredSize(new Dimension(40,40));
        moveRight.setPreferredSize(new Dimension(40,40));
        zoomIn.setPreferredSize(new Dimension(40,40));
        zoomIn.setActionCommand(ZOOM_IN_COMMAND);
        zoomOut.setPreferredSize(new Dimension(40,40));
        zoomOut.setActionCommand(ZOOM_OUT_COMMAND);
        moveLeft.setActionCommand(MOVE_LEFT_COMMAND);
        moveRight.setActionCommand(MOVE_RIGHT_COMMAND);
        panelComponents = new JComponent[]{moveLeft, zoomIn, zoomOut, moveRight};
    }
    
    protected JButton createNaviButton(String icon, String alternativeString){
        JButton b ;
        try {
            b = new JButton(Icons.getIcon(icon));
        } catch(IOException ex){
            Logger.getLogger(GubasChart.class.getName()).log(Level.SEVERE, null, ex);
            b = new JButton(alternativeString);
        }
        return b;
    }
}
