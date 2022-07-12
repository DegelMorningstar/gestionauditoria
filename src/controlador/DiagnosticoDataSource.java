package controlador;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class DiagnosticoDataSource implements JRDataSource {

    private int index;
    private Object[][] listadoPreguntas;

    public DiagnosticoDataSource(Object[][] listadoPreguntas2) {
        listadoPreguntas =listadoPreguntas2;
        index = -1;
        
    }


    @Override
    public boolean next() throws JRException {
        index++;
        return (index < listadoPreguntas.length);
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {

        Object value = null;

        String fieldName = jrf.getName();

        switch (fieldName) {
            case "pant":
                value = listadoPreguntas[index][0];
                break;
            case "pact":
                value = listadoPreguntas[index][1];
                break;
            case "preg":
                value = listadoPreguntas[index][2];
                break;
        }
        return value;

    }

    public static JRDataSource getDataSource(Object[][] listadoPreguntas2) {
        
        return new DiagnosticoDataSource(listadoPreguntas2);
    }

}
