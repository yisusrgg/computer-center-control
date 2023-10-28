
package pruebas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;

public class RegistroPcBackEnd 
{

    /**
     * Constructor vacio de la clase RegistroPcBackEnd. 
     */
    public RegistroPcBackEnd() {
        
    }
    
    /**
     * Método que lee el archivo matriculas.txt línea por línea y compara cada línea con la matrícula deseada.
     * @param matricula
     * @return 
     */
    public boolean verificarMatricula(String matricula) {
        try (BufferedReader reader = new BufferedReader(new FileReader("matriculas.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.trim().equals(matricula)) {
                    return true;
                }
        }
    } 
    catch (IOException e) {
        e.printStackTrace();
    }
    return false;
    }

    /**
     * Método que se encargara de guardar un registro en el archivo "registros.txt". El registro incluye la fecha, la matrícula, el equipo y el software utilizados. Cada registro se agrega al final del archivo existente.
     * @param dat tipo date.
     * @param matricula tipo String. 
     * @param equipo tipo String.
     * @param software tipo string.
     */
    public void guardarRegistro(Date dat,String matricula, String equipo, String software) {
        try (FileWriter writer = new FileWriter("registros.txt", true)) {
            Date f = new Date();
            
            
            writer.write("Fecha de registro: " + f + ", Matricula: " + matricula + ", Equipo: " + equipo + ", Software: " + software + "\n");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Método que se encarga de buscar una Matricula.
     */
    public void buscarMatricula() {
        RegistroPc rpc = new RegistroPc();
        String matricula = rpc.leerMatricula();
        if (matricula == null || matricula.isEmpty()) {
            mensaje("Ingresar Matricula");
        } 
        else {
            if (verificarMatricula(matricula)) {
                
            } else {
                mensaje("La matricula no existe");
            }
        }
    }
        
    /**
     * Método que se encarga de mostrar un mensaje para ciertas ocaciones.
     * @param texto tipo String.
     */
    public void mensaje(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }
    
}
