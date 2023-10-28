
package pruebas;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BackEndSoftwaresUsados {
    private int Word;
    private int Excel;
    private int Arduino;
    private int NetBeans;
    private int CodeBlocks;
    private int Chrome;

    /**
     * Contructor vacio de la clase BackEndSoftwaresUsados
     */
    public BackEndSoftwaresUsados() {
        
    }

    /**
     * Método para contar las ocurrencias de palabras que se encuentran en un archivo 
     * @param line tipo String 
     * @param palabra tipo String 
     * @return 
     */
    public int contarPalabra(String line, String palabra) {
        String llave = "Software:";
        int indice = line.indexOf(llave);
        if (indice != -1) {
            String softwares = line.substring(indice + llave.length());
            String[] arr = softwares.split(",\\s*");
            int count = 0;
            for (String software : arr) {
                if (software.trim().equalsIgnoreCase(palabra)) {
                    count++;
                }
            }
            return count;
        }
        return 0;
    }
    
}