
package Modelo;


public class Respuesta {
    private String noPregunta, respuesta;

    public Respuesta(String noPregunta, String respuesta) {
        this.noPregunta = noPregunta;
        this.respuesta = respuesta;
    }
    
    public Respuesta() {
    }

    public String getNoPregunta() {
        return noPregunta;
    }

    public void setNoPregunta(String noPregunta) {
        this.noPregunta = noPregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
}
