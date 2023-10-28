
package pruebas;
import java.io.Serializable;
import java.util.ArrayList;

public class InformacionAlumnosBackEnd2 
{
    private ArrayList<Object> a = new ArrayList<Object> ();

    /**
     * Constructor vacio de la clase InformacionAlumnosBackEnd2.
     */
    public InformacionAlumnosBackEnd2() {
    }
    
    /**
     * Constructor de la clase InformacionAlumnosBackEnd2 que recibe un ArrayList de objetos y lo asigna al atributo a.
     * @param a tipo ArrayList de objetos.
     */
    public InformacionAlumnosBackEnd2(ArrayList<Object> a) {
        this.a = a;
    }
    
    /**
     * Método para agregar un objeto de la clase InformacionALumnosBackEnd1 al ArrayList a.
     * @param p tipo InformacionALumnosBackEnd1.
     */
    public void agregarRegistro(InformacionALumnosBackEnd1 p){
        this.a.add(p);
    }
    
    /**
     * Método que permite agregar un objeto de la clase InformacionALumnosBackEnd1 al ArrayList a.
     * @param crud tipo InformacionALumnosBackEnd1.
     */
    public void agregarAlumno(InformacionALumnosBackEnd1 crud)
    {
        this.a.add(crud);
    }
    
    /**
     * Método que permite modificar el objeto de la clase InformacionALumnosBackEnd1 en la posición n del ArrayList a con el objeto crud.
     * @param n tipo int. 
     * @param crud tipo InformacionALumnosBackEnd1
     */
    public void modificarAlumno(int n, InformacionALumnosBackEnd1 crud)
    {
        this.a.set(n, crud);
    }
    
    /**
     * MEtodo que permite eliminar el objeto en la posición i del ArrayList a.
     * @param i tipo int.
     */
    public void eliminarAlumno(int i){
        this.a.remove(i);
    }
    
    /**
     * Metpdo que retorna el objeto de la clase InformacionALumnosBackEnd1 en la posición n del ArrayList a.
     * @param n tipo int.
     * @return 
     */
    public InformacionALumnosBackEnd1 obtenerAlumno(int n)
    {
        return (InformacionALumnosBackEnd1)a.get(n);
    }
    
    /**
     * MEtodo que retorna la cantidad de alumnos que se han registrado en el ArrayList a.
     * @return 
     */
    public int cantidadAlumnos()
    {
        return this.a.size();
    }
    
    /**
     * Método que busca un objeto de la clase InformacionALumnosBackEnd1 en el ArrayList a que tenga la matrícula igual a codigo y retorna su posición. Si no se encuentra, retorna -1.
     * @param codigo tipo String.
     * @return 
     */
    public int buscaMatricula(String codigo) {
        for (int i = 0; i < cantidadAlumnos(); i++) {
            if (codigo.equals(obtenerAlumno(i).getMatricula())) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * ´Método que se encarga de modificar el objeto en la posición i del ArrayList a con el objeto p.
     * @param i tipo int.
     * @param p tipo InformacionALumnosBackEnd1.
     */
    public void modificarRegistro(int i, InformacionALumnosBackEnd1 p){
        this.a.set(i, p);
    }
    
}
