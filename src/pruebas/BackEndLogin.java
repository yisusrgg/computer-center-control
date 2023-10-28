package pruebas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class BackEndLogin {
    
    /**
     * Metodo que funciona como login del usuario
     * @param u tipo String 
     * @param p tipo String 
     * @return 
     */
    public  boolean  ingresar(String u, String p)
    {
        String ruta="datos.txt";
        File r = new File(ruta);
        boolean regresa=false;

        try{
            
            FileReader fi = new FileReader(ruta);
            BufferedReader bu= new BufferedReader(fi); 
            String user = null;
            String password = null;
            user = bu.readLine();
            password = bu.readLine();
            if(u.equals(user) && p.equals(password))
            {
                regresa =true;
            }
            else
            {
                regresa =false;
            }
            return regresa;
        }
        catch(Exception e){
            System.out.println("Error...");
            regresa = false;
        }
        return regresa;
    }
    

}