package Otros;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Limpiar_txt {
    
    
    /**
     * Método que recorre todos los componentes de un JPanel y, si son JTextField o un JPasswordField, marcara su texto como una cadena vacía para limpiarlos.
     * @param panel 
     */
    public void limpiar_texto(JPanel panel){
        for(int i = 0; panel.getComponents().length > i; i++){
            if(panel.getComponents()[i] instanceof JTextField){
                ((JTextField)panel.getComponents()[i]).setText("");
            }
            else if(panel.getComponents()[i] instanceof JPasswordField){
                ((JPasswordField)panel.getComponents()[i]).setText("");
            }
        }
    }
    
}
