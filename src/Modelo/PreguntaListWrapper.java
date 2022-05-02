
package Modelo;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "preguntas")
public class PreguntaListWrapper {
    
    private List<Pregunta> preguntas;
    
    @XmlElement(name = "pregunta")
    public List<Pregunta> getElements(){
        return preguntas;
    }
    
    public void setElements(List<Pregunta> preguntas){
        this.preguntas = preguntas;
    }
    
}
