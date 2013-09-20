/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import gubas.components.interfaces.TabbedPanelListeners;
import gubas.management.impl.ComponentAnimationManager;
import gubas.management.interfaces.AnimationManagable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.plaf.BorderUIResource;

/**
 *
 * @author Przemysław
 */
public class TabbedPanelComponent extends JPanel implements AnimationManagable {
    
    
    Map<JPanel, JPanel> componentsMap = new HashMap<>();
    JPanel buttonsPanel = new JPanel();
    JPanel centralPanel = new JPanel();
    JPanel spacer = new JPanel();
    List<TabbedPanelListeners> myListeners = new ArrayList<>();
    ComponentAnimationManager cman = null;
    int cAlfa = 0;
    JPanel animatedButton = null;
    int minButtonsWidth = 150;
    int numOfLayers = 0;
    
    Color inactiveButtonColor = new Color(200, 200, 255, 255);

    public int getMinButtonsWidth() {
        return minButtonsWidth;
    }

    public void setMinButtonsWidth(int minButtonsWidth) {
        this.minButtonsWidth = minButtonsWidth;
    }

    public Color getInactiveButtonColor() {
        return inactiveButtonColor;
    }

    public void setInactiveButtonColor(Color inactiveButtonColor) {
        this.inactiveButtonColor = inactiveButtonColor;
    }

    public Color getActiveButtonColor() {
        return activeButtonColor;
    }

    public void setActiveButtonColor(Color activeButtonColor) {
        this.activeButtonColor = activeButtonColor;
    }

    public Color getActiveButtonForegroundColor() {
        return activeButtonForegroundColor;
    }

    public void setActiveButtonForegroundColor(Color activeButtonForegroundColor) {
        this.activeButtonForegroundColor = activeButtonForegroundColor;
    }

    public Color getInactiveForegroundColor() {
        return inactiveForegroundColor;
    }

    public void setInactiveForegroundColor(Color inactiveForegroundColor) {
        this.inactiveForegroundColor = inactiveForegroundColor;
    }
    Color activeButtonColor = new Color(100, 100, 150, 255);
    Color activeButtonForegroundColor = Color.white;
    Color inactiveForegroundColor = Color.BLACK;
    
    public TabbedPanelComponent(){
        setLayout(new BorderLayout());
        buttonsPanel.setPreferredSize(new Dimension(80, 35));
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        centralPanel.setPreferredSize(new Dimension(100, 100));
        add(buttonsPanel, BorderLayout.NORTH);
        add(centralPanel, BorderLayout.CENTER
                );
        setBorder(BorderUIResource.getLoweredBevelBorderUIResource());
        cman = new ComponentAnimationManager(this);
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
        b.setBorder(BorderUIResource.getRaisedBevelBorderUIResource());
        buttonsPanel.add(b);
        buttonsPanel.add(spacer);
        centralPanel.add(c);
        numOfLayers++;
        b.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent me) {
                
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
     * Activates the tab of a given index
     * @param i index of the tab to activate, starting at 0
     */
    public void setActiveTab(int i){
        JPanel[] buttons = componentsMap.keySet().toArray(new JPanel[]{});
        if(i<buttons.length){
            setSelectedButton(buttons[i], Boolean.TRUE);
        }
    }
    
    /**
     * Sets the style of a selected button
     * @param b button whose style should be changed
     * @param active whether the button should be marked as active or not
     * @remark Set the styles - now preliminary tests only
     */
    protected void setSelectedButton(JPanel b, Boolean active){
        if(active){
            centralPanel.removeAll();
            animatedButton = b;
            b.setBorder(BorderUIResource.getLoweredBevelBorderUIResource());
            b.setForeground(activeButtonForegroundColor);
           cman.animate();
           centralPanel.add(componentsMap.get(b));
        } else {
            b.setBackground(inactiveButtonColor);
            b.setBorder(BorderUIResource.getRaisedBevelBorderUIResource());
            b.setForeground(inactiveForegroundColor);
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
        if(animatedButton!=null){
            animatedButton.setBackground(new Color(activeButtonColor.getRed(),
                    activeButtonColor.getGreen(), activeButtonColor.getBlue(), getCurrentAlpha()));
        }
       calculateElementsPositions();
       super.paint(g);   
    }

    @Override
    public int getCurrentAlpha() {
        return cAlfa;
    }

    @Override
    public void setCurrentAlpha(int a) {
        cAlfa = a;
    }
}
