
package controlador;

import Modelo.Carrera;
import Modelo.CarreraListWrapper;
import Modelo.Encuesta;
import Modelo.EncuestaListWrapper;
import Modelo.Pregunta;
import Modelo.PreguntaListWrapper;
import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class XmlActions {
    
    
    public List<Carrera> loadCarrerasDataFromFile(File file) {
        CarreraListWrapper wrapper = null;
        try {
            JAXBContext context = JAXBContext
                    .newInstance(CarreraListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            wrapper = (CarreraListWrapper) um.unmarshal(file);

            return wrapper.getElements();

        } catch (Exception e) { 
            System.out.println("Error al obtener carreras");
        } finally {
            return wrapper.getElements();
        }
    }

    public boolean saveCarrerasDataToFile(File file, List<Carrera> list) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(CarreraListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            CarreraListWrapper wrapper = new CarreraListWrapper();
            wrapper.setElements(list);

            m.marshal(wrapper, file);
            return true;
        } catch (Exception e) { 
            System.out.println("Error al gurdar carreras");
            return false;
        }
    }
    
    public List<Pregunta> loadPreguntasDataFromFile(File file) {
        PreguntaListWrapper wrapper = null;
        try {
            JAXBContext context = JAXBContext
                    .newInstance(PreguntaListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            wrapper = (PreguntaListWrapper) um.unmarshal(file);

            return wrapper.getElements();

        } catch (Exception e) { 
            System.out.println("Error al obtener preguntas");
        } finally {
            return wrapper.getElements();
        }
    }

    public boolean savePreguntasDataToFile(File file, List<Pregunta> list) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(PreguntaListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            PreguntaListWrapper wrapper = new PreguntaListWrapper();
            wrapper.setElements(list);

            m.marshal(wrapper, file);
            return true;
        } catch (Exception e) { 
            System.out.println("Error al gurdar preguntas");
            return false;
        }
    }
    
    public List<Encuesta> loadEncuestasDataFromFile(File file) {
        EncuestaListWrapper wrapper = null;
        try {
            JAXBContext context = JAXBContext
                    .newInstance(EncuestaListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            wrapper = (EncuestaListWrapper) um.unmarshal(file);

            return wrapper.getElements();

        } catch (Exception e) { 
            System.out.println("Error al obtener preguntas " + e);
            List<Encuesta> envio = null;
            return envio;
        }
    }

    public boolean saveEncuestasDataToFile(File file, List<Encuesta> list) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(EncuestaListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            EncuestaListWrapper wrapper = new EncuestaListWrapper();
            wrapper.setElements(list);
            String recomendaciones = loadRecomendacionDataFromFile(file);
            if (recomendaciones == null) {
                wrapper.setRecomendaciones("");
            } else {
                wrapper.setRecomendaciones(recomendaciones);
            }
            
            m.marshal(wrapper, file);
            return true;
        } catch (Exception e) { 
            System.out.println("Error al guardar encuestas: " + e);
            return false;
        }
    }
    
    public boolean saveRecomendacionesDataToFile(File file, String recomendaciones) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(EncuestaListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            EncuestaListWrapper wrapper = new EncuestaListWrapper();
            wrapper.setElements(loadEncuestasDataFromFile(file));
            wrapper.setRecomendaciones(recomendaciones);
            
            
            m.marshal(wrapper, file);
            return true;
        } catch (Exception e) { 
            System.out.println("Error al guardar encuestas");
            return false;
        }
    }
    
    public String loadRecomendacionDataFromFile(File file) {
        EncuestaListWrapper wrapper = null;
        try {
            JAXBContext context = JAXBContext
                    .newInstance(EncuestaListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            wrapper = (EncuestaListWrapper) um.unmarshal(file);

            return wrapper.getRecomendaciones();

        } catch (Exception e) { 
            System.out.println("Error al obtener preguntas " + e);
            String envio = "";
            return envio;
        }
    }
   
}
