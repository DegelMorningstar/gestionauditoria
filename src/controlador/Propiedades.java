
package controlador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


public class Propiedades {
    
    public String acceder(String propiedad, String ruta){
        Properties propiedades = new Properties();
        InputStream entrada = null;
        
        try {
            entrada = new FileInputStream(ruta);
            propiedades.load(entrada);
            return propiedades.getProperty(propiedad);

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    
    public boolean guardar(String propiedad, String valor, String ruta){
        Properties propiedades = new Properties();
        OutputStream salida = null;
        InputStream entrada = null;
        try {
            entrada = new FileInputStream(ruta);
            propiedades.load(entrada);
            salida = new FileOutputStream(ruta);
            propiedades.setProperty(propiedad, valor);
            propiedades.store(salida, null);
               return true;
        } catch (IOException io) {
            io.printStackTrace();
            return false;
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
}
