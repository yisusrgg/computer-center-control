
package pruebas;
import java.time.LocalDateTime;
import java.io.Serializable;
public class InformacionALumnosBackEnd1 
{
   private String matricula;
   private String name;
   private String lastname;
   private String telefono;
   private LocalDateTime dat;

   /**
    * contructor vacio de la clase InformacionALumnosBackEnd1.
    */
   public InformacionALumnosBackEnd1(){
       
   }
   /**
    * Contructor de la clase InformacionALumnosBackEnd1 que recibe 4 atributos de la misma clase. 
    * @param matricula tipo String. 
    * @param name tipo String. 
    * @param lastname tipo String. 
    * @param telefono tipo String.
    */
    public InformacionALumnosBackEnd1(String matricula, String name, String lastname, String telefono) {
        this.matricula = matricula;
        this.name = name;
        this.lastname = lastname;
        this.telefono = telefono;
    }

    /**
     * Método getter para retornar la matricula.
     * @return 
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Método setter para asignar un valor a matricula.
     * @param matricula 
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Metodo getter para retornar el nombre.
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * Método setter para asignar un valor al nombre. 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo getter para retornar los apellidos.
     * @return 
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Método setter para asignar un valor a apellidos. 
     * @param name 
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    /**
     * Metodo getter para retornar los apellidos.
     * @return 
     */
    public LocalDateTime getDat() {
        return dat;
    }

    /**
     * Metodo setter para asignar un valor a la fecha.
     * @param dat 
     */
    public void setDat(LocalDateTime dat) {
        this.dat = dat;
    }

    /**
     * Metodo getter para retornar el telefono.
     * @return 
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo setter para asignar un valor a telefono.
     * @param telefono 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    
    
   
   
}
