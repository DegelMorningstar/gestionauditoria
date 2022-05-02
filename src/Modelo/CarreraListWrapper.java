
package Modelo;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "carreras")
public class CarreraListWrapper {
    
    private List<Carrera> carreras;

    @XmlElement(name = "carrera")
    public List<Carrera> getElements() {
        return carreras;
    }

    public void setElements(List<Carrera> persons) {
        this.carreras = persons;
    }
}
