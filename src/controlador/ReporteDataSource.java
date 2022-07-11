/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author edgar
 */
public class ReporteDataSource implements JRDataSource {

    private final Object[][] listadoCalificaciones;
    private int index;

    public ReporteDataSource(Object[][] listadoCalificaciones_sub) {
        index = -1;
        listadoCalificaciones = listadoCalificaciones_sub;
    }

    @Override
    public boolean next() throws JRException {

        index++;
        return (index < listadoCalificaciones.length);

    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {

        Object value = null;

        String fieldName = jrf.getName();
        switch (fieldName) {

            case "p":
                value = listadoCalificaciones[index][0].toString();
                break;
            case "r1":
                value = listadoCalificaciones[index][1];
                break;
            case "r2":
                value = listadoCalificaciones[index][2];
                break;
            case "r3":
                value = listadoCalificaciones[index][3];
                break;
            case "r4":
                value = listadoCalificaciones[index][4];
                break;
            case "r5":
                value = listadoCalificaciones[index][5];
                break;
            case "promedioPreg":
                value = listadoCalificaciones[index][6];
                break;
        }
        return value;
    }

//    
//    public void Parametros() throws JRException{
//        
//        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource("reporteMaestroEncuesta.jasper"));
//        //List<String> paramsNames = Arrays.asList("stringParam", "intParam"); // we are going to show information about only this parameters
//        JRParameter[] parameters = jasperReport.getParameters();
//        for (JRParameter parameter : parameters) {
//            //JRExpression expression = parameter.getDefaultValueExpression();
//                System.out.println(String.format("Parameter name: %s ", parameter.getName())); // we are showing name, class and default expression of parameter  
//        }
//    }
    public static JRDataSource getDataSource(Object[][] listadoCalificaciones_sub) {

        //ReporteDataSource p = new ReporteDataSource();
        return new ReporteDataSource(listadoCalificaciones_sub);
    }

}
