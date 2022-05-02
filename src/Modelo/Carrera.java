
package Modelo;

public class Carrera {
    private String nombre;
    
    public Carrera() {
        this(null);
    }

    public Carrera(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
