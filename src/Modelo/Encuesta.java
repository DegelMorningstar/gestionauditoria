
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Encuesta {
    private List<Respuesta> respuestas = new ArrayList<Respuesta>();
    private String comentario;

    public Encuesta(List<Respuesta> respuestas, String comentario) {
        this.respuestas = respuestas;
        this.comentario = comentario;
    }

    public Encuesta() {
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
    
    public void addRespuesta(Respuesta respuesta) {
        respuestas.add(respuesta);
    }
    
    public Respuesta getRespuesta(int index){
        return respuestas.get(index);
    }
    
}
