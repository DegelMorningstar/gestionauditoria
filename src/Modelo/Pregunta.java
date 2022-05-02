
package Modelo;


public class Pregunta {
    private String preg, numero;
    
    public Pregunta(String preg, String numero) {
        this.preg = preg;
        this.numero = numero;
    }

    public Pregunta() {
    }

    public String getPreg() {
        return preg;
    }

    public void setPreg(String preg) {
        this.preg = preg;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    
}
