
package Otros;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;


public class imgTabla extends DefaultTableCellRenderer {

    /**
     * Método que permite personalizar la apariencia de las celdas en una tabla.
     * @param table tipo jTable.
     * @param value tipo Object.
     * @param isSelected tipo Boolean.
     * @param hasFocus tipo Boolean.
     * @param row tipo int.
     * @param column tipo int.
     * @return 
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof JLabel){
            JLabel lbl = (JLabel)value;
            return lbl;
        }
    
        if(value instanceof JButton){
            JButton button = (JButton)value;
            if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(UIManager.getColor("Button.background"));
    }
            return button;
        }
        
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
