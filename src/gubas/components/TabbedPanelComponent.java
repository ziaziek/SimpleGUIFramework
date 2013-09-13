/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import gubas.components.interfaces.TabbedPanelListeners;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.plaf.BorderUIResource;

/**
 *
 * @author Przemysław
 */
public class TabbedPanelComponent extends JPanel {
    
    
    Map<JPanel, JPanel> componentsMap = new HashMap<>();
    JPanel buttonsPanel = new JPanel();
    JLayeredPane centralPanel = new JLayeredPane();
    JPanel spacer = new JPanel();
    List<TabbedPanelListeners> myListeners = new ArrayList<>();
    int minButtonsWidth = 150;
    int numOfLayers = 0;
    
    public TabbedPanelComponent(){
        setLayout(new BorderLayout());
        buttonsPanel.setPreferredSize(new Dimension(100, 35));
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        centralPanel.setPreferredSize(new Dimension(100, 100));
        add(buttonsPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER
                );
        setBorder(BorderUIResource.getLoweredBevelBorderUIResource());
        repaint();
    }
    
    /**
     * Adds a tab and a component associated to the TabPanelComponent
     * @param text text of the button
     * @param c component
     * @return  number of tabs
     */
    public int addTab(String text, JPanel c){
        final JPanel b = new JPanel();
        b.add(new JLabel(text));
        componentsMap.put(b, c);
        c.setOpaque(true);
        buttonsPanel.remove(spacer);
        b.setBorder(BorderUIResource.getBlackLineBorderUIResource());
        buttonsPanel.add(b);
        buttonsPanel.add(spacer);
        centralPanel.add(c);
        numOfLayers++;
        b.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent me) {
                centralPanel.setLayer(componentsMap.get(b), 0);
                for(TabbedPanelListeners l : myListeners){
                    l.buttonClicked(b);
                }
                for(JPanel but: componentsMap.keySet()){
                    setSelectedButton(but, b==but);
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
                
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                
            }

            @Override
            public void mouseExited(MouseEvent me) {
                
            }
        });

        repaint();
        return componentsMap.size();
    }
    
    /**
     * Removes tab and its component at given position
     * @param i position of the tab
     * @return number of tabs that are left
     */
    public int removeTab(int i){
        JPanel[] buttons = componentsMap.keySet().toArray(new JPanel[]{});
        buttonsPanel.remove(spacer);
        if(i<buttons.length){
            buttonsPanel.remove(buttons[i]);
            centralPanel.remove(componentsMap.get(buttons[i]));
            componentsMap.remove(buttons[i]);         
        }
        buttonsPanel.add(spacer);
        return componentsMap.size();
    }

    /**
     * Sets the style of a selected button
     * @param b button whose style should be changed
     * @param active whether the button should be marked as active or not
     * @remark Set the styles - now preliminary tests only
     */
    protected void setSelectedButton(JPanel b, Boolean active){
        if(active){
            b.setBackground(Color.blue);
        } else {
            b.setBackground(null);
        }
    }
    
    protected void calculateElementsPositions(){
 
        for(Entry c : componentsMap.entrySet()){
           if(c.getValue() instanceof JPanel){
              ((JPanel)c.getValue()).setBounds(0,0, centralPanel.getWidth(), centralPanel.getHeight()); 
           } 
       }
    }

    
    @Override
    public void paint(Graphics g){
       calculateElementsPositions();
       super.paint(g);   
    }
}
