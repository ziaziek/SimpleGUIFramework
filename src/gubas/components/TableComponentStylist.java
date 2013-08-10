/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gubas.components;

import java.awt.Color;
import javax.swing.JTable;

/**
 *
 * @author Przemo
 */
public class TableComponentStylist {

    public Color getHoverOverBackgroundColor() {
        return hoverOverBackgroundColor;
    }

    public void setHoverOverBackgroundColor(Color hoverOverBackgroundColor) {
        this.hoverOverBackgroundColor = hoverOverBackgroundColor;
    }

    public Color getHoverOverForegroundColor() {
        return hoverOverForegroundColor;
    }

    public void setHoverOverForegroundColor(Color hoverOverForegroundColor) {
        this.hoverOverForegroundColor = hoverOverForegroundColor;
    }

    public Color getOddRowBackgroundColor() {
        return oddRowBackgroundColor;
    }

    public void setOddRowBackgroundColor(Color oddRowBackgroundColor) {
        this.oddRowBackgroundColor = oddRowBackgroundColor;
    }

    public Color getOddRowForegroundColor() {
        return oddRowForegroundColor;
    }

    public void setOddRowForegroundColor(Color oddRowForegroundColor) {
        this.oddRowForegroundColor = oddRowForegroundColor;
    }

    public Color getEvenRowBackgroundColor() {
        return evenRowBackgroundColor;
    }

    public void setEvenRowBackgroundColor(Color evenRowBackgroundColor) {
        this.evenRowBackgroundColor = evenRowBackgroundColor;
    }

    public Color getEvenRowForegroundColor() {
        return evenRowForegroundColor;
    }

    public void setEvenRowForegroundColor(Color evenRowForegroundColor) {
        this.evenRowForegroundColor = evenRowForegroundColor;
    }

    public Color getTableHeaderGradientFromColor() {
        return tableHeaderGradientFromColor;
    }

    public void setTableHeaderGradientFromColor(Color tableHeaderGradientFromColor) {
        this.tableHeaderGradientFromColor = tableHeaderGradientFromColor;
    }

    public Color getTableHeaderGradientToColor() {
        return tableHeaderGradientToColor;
    }

    public void setTableHeaderGradientToColor(Color tableHeaderGradientToColor) {
        this.tableHeaderGradientToColor = tableHeaderGradientToColor;
    }
    
    protected Color hoverOverBackgroundColor = Color.lightGray;
    
    protected Color hoverOverForegroundColor = Color.white;
    
    protected Color oddRowBackgroundColor = Color.yellow;
    
    protected Color oddRowForegroundColor = Color.gray;
    
    protected Color evenRowBackgroundColor = Color.white;
    
    protected Color evenRowForegroundColor = Color.gray;
    
    protected Color tableHeaderGradientFromColor = new Color(0,55,255,100);
    
    protected Color tableHeaderGradientToColor = new Color(255,255,255,120);
    
    protected Color tableHeaderGradientForegroundColor = Color.blue;

    public Color getTableHeaderGradientForegroundColor() {
        return tableHeaderGradientForegroundColor;
    }

    public void setTableHeaderGradientForegroundColor(Color tableHeaderGradientForegroundColor) {
        this.tableHeaderGradientForegroundColor = tableHeaderGradientForegroundColor;
    }

    JTable tab = null;
    
    public TableComponentStylist(JTable table){
        tab = table;
    }
    
    public void applyStylesChanges(){
        tab.repaint();
    }
}
