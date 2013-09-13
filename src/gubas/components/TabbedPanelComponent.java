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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    
    Map<JButton, JPanel> componentsMap = new HashMap<>();
    JPanel buttonsPanel = new JPanel();
    JLayeredPane centralPanel = new JLayeredPane();
    List<TabbedPanelListeners> myListeners = new ArrayList<>();
    int numOfLayers = 0;
    
    public TabbedPanelComponent(){
        setLayout(new BorderLayout());
        buttonsPanel.setPreferredSize(new Dimension(100, 35));
        centralPanel.setPreferredSize(new Dimension(100, 100));
        add(buttonsPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER
                );
        setBorder(BorderUIResource.getLoweredBevelBorderUIResource());
    }
    
    /**
     * Adds a tab and a component associated to the TabPanelComponent
     * @param text text of the button
     * @param c component
     * @return  number of tabs
     */
    public int addTab(String text, JPanel c){
        final JButton b = new JButton(text);
        componentsMap.put(b, c);
        c.setOpaque(true);
        buttonsPanel.add(b);
        centralPanel.add(c);
        numOfLayers++;
        b.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                centralPanel.setLayer(componentsMap.get(b), 0);
                for(TabbedPanelListeners l : myListeners){
                    l.buttonClicked(b);
                }
                for(JButton but: componentsMap.keySet()){
                    setSelectedButton(but, b==but);
                }
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
        JButton[] buttons = componentsMap.keySet().toArray(new JButton[]{});
        if(i<buttons.length){
            buttonsPanel.remove(buttons[i]);
            centralPanel.remove(componentsMap.get(buttons[i]));
            componentsMap.remove(buttons[i]);         
        }
        return componentsMap.size();
    }

    /**
     * Sets the style of a selected button
     * @param b button whose style should be changed
     * @param active whether the button should be marked as active or not
     * @remark Set the styles - now preliminary tests only
     */
    protected void setSelectedButton(JButton b, Boolean active){
        if(active){
            b.setBackground(Color.blue);
        } else {
            b.setBackground(null);
        }
    }

    @Override
    public void paint(Graphics g){
       super.paint(g);
       for(Component c : componentsMap.values()){
           c.setBounds(0,0, centralPanel.getWidth(), centralPanel.getHeight());
       }
    }
}
