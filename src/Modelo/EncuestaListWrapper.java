
package Modelo;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "encuestas")
public class EncuestaListWrapper {
    private List<Encuesta> encuestas;
    private String Recomendaciones;

    @XmlElement(name = "recomendacion")
    public String getRecomendaciones() {
        return Recomendaciones;
    }

    public void setRecomendaciones(String Recomendaciones) {
        this.Recomendaciones = Recomendaciones;
    }

    @XmlElement(name = "encuesta")
    public List<Encuesta> getElements() {
        return encuestas;
    }

    public void setElements(List<Encuesta> encuestas) {
        this.encuestas = encuestas;
    }
}
