package controlador;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.export.JRGraphics2DExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class GeneradorReporte {

    Propiedades prop = new Propiedades();
    String ruta = "src/Documentos/config.properties";
    String rutaDocs = "src/Documentos/";
    String areaRuta = "src/Documentos/ajustesAreas.properties";

    String carpeta = prop.acceder("archivoActual", ruta);
    String nombreDocumento = prop.acceder("nombreDocumento", ruta);
    String revision = prop.acceder("revision", ruta);
    String norma = prop.acceder("norma", ruta);
    String rd = prop.acceder("rd", ruta);
    String auditorLider = prop.acceder("auditorLider", ruta);
    ///String autorLider2we2 = prop.acceder("auditorLider", ruta);
    String responsables;
    String nombreIT = "De Zacatepec";
    String inicioPeriodo = prop.acceder("fechaInicio", rutaDocs + "Periodos/" + carpeta + "/Periodo.properties");
    String finalPeriodo = prop.acceder("fechaFin", rutaDocs + "Periodos/" + carpeta + "/Periodo.properties");
    String fecha;
    String noEncuestas;
    String areaAuditada;
    String comentarios;
    String recomendaciones;
    Float promTotal;
    private final Object[][] listadoPreguntas  = new Object[][]{
            {1.3f, 5.4f, "1. Me informa oportunamente sobre el horario de atención"},
            {2.2f, 1.4f, "2. Me informa oportunamente sobre el horario de atención"},
            {3.3f, 2.3f, "3. Me informa oportunamente sobre el horario de atención"},
            {4.4f, 2.5f, "4. Me informa oportunamente sobre el horario de atención"},
            {5.2f, 5.0f, "5. Me informa oportunamente sobre el horario de atención"},
            {6.1f, 5.0f, "6. Me informa oportunamente sobre el horario de atención"},
            {7.9f, 6.5f, "7. Me informa oportunamente sobre el horario de atención"},
            {8.78f, 6.4f, "8. Me informa oportunamente sobre el horario de atención"},
            {9.23f, 7.8f, "9. Me informa oportunamente sobre el horario de atención"},
            {1.23f, 9.5f, "Este servicio no fue aditado debido a que el inmueble donde se encuentra ubicado el centro de información resultó con severos daños"
                + " por el sismo pasado 19 de septiembre del presente año."}
        };
    
    private final Object[][] listadoCalificaciones = new Object[][]{
            {1, 1, 9, 10, 20, 10, 8.9f},
            {2, 1, 39, 10, 20, 10, 8.9f},
            {3, 1, 23, 10, 20, 10, 5.9f},
            {4, 1, 232, 10, 20, 10, 7.9f},
            {5, 1, 9, 10, 20, 10, 6.9f},
            {6, 1, 9, 10, 20, 10, 6.9f},
            {7, 1, 9, 10, 20, 10, 8.9f},
            {8, 1, 9, 10, 20, 10, 9.9f},
            {9, 1, 9, 10, 20, 10, 5.9f},
            {"Promedio", 1, 9, 10, 20, 10, 5.9f}
        };
    
    public static Object[][] grafico = new Object[][]{
        {"1", 4.9f},
        {"2", 2.9f},
        {"3", 3.9f},
        {"4", 2.9f},
        {"5", 1.9f},
        {"6", 4.4f},
        {"7", 2.9f},
        {"8", 3.9f},
        {"9", 2.9f}
    };

    public void responsable(String area) {

        //RESPONSABLES
        if (prop.acceder("noresponsables" + area, areaRuta).equalsIgnoreCase("1")) {
            responsables = prop.acceder("responsable" + area + "1", areaRuta);
            System.out.println(responsables);
        } else {
            responsables = prop.acceder("responsable" + area + "1", areaRuta) + " / ";
            responsables += prop.acceder("responsable" + area + "2", areaRuta);
            System.out.println(responsables);
        }

    }

    public void fecha() {
        //FECHA
        inicioPeriodo = inicioPeriodo.replace("-", " ");
        finalPeriodo = finalPeriodo.replace("-", " ");
        String inicio[] = inicioPeriodo.split(" ");
        String fin[] = finalPeriodo.split(" ");
        fecha = inicio[0];
        if (inicio[1].equals(fin[1])) {
            fecha += " al " + fin[0] + " de " + fin[1] + " del " + fin[2];
        } else {
            fecha += " de " + inicio[1] + " al " + fin[0] + " de " + fin[1] + " del " + fin[2];
        }
        fecha = "Del " + fecha;
        System.out.println(fecha);
    }

    public void muestra(String carrera) {
        noEncuestas = prop.acceder("muestra" + carrera, rutaDocs + "muestra.properties");
        System.out.println(noEncuestas);
    }

    public void areaAuditada(String areaAuditada) {
        this.areaAuditada = areaAuditada;
    }

    public GeneradorReporte() {

        try {

            responsable("Computo");
            fecha();
            muestra("ING. Electromecánica");
            areaAuditada("Centro de Computo");
            promTotal = 4.6f;

            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("reporteMaestroEncuesta.jasper"));
            Map<String, Object> parametros = new HashMap();
            parametros.put("nombreDocumento", nombreDocumento);
            parametros.put("referenciaNorma", norma);
            parametros.put("revision", revision);
            File file = new File("src/Archivos/" + prop.acceder("logo", ruta));
            String logo = file.getAbsolutePath();
            parametros.put("logo", logo);
            parametros.put("nombreIT", nombreIT.toUpperCase());
            parametros.put("areaAuditada", areaAuditada);
            parametros.put("responsable", responsables.toUpperCase());
            parametros.put("fecha", fecha);
            parametros.put("rd", rd.toUpperCase());
            parametros.put("auditor", auditorLider.toUpperCase());
            parametros.put("noEncuestas", noEncuestas);
            parametros.put("promTotal", promTotal);

            comentarios = "1. Este servicio no fue auditado debido a que el inmueble donde se encuentra ubicado el centro de "
                    + "información resultó con severos daños por el sismo del pasado 19 de septiembre del presente año. "
                    + "No se ha proporcionado el servicio a la comunidad tecnológica, por lo tanto, no se tienen elementos para "
                    + "realizar esta auditoria.";
            parametros.put("comentarios", comentarios);
            
            
            GraficoReporte.hacerGrafico(grafico);
            file = new File("src/Archivos/" + "grafica.png");
            String grafica = file.getAbsolutePath();
            parametros.put("grafica", grafica);

            JasperReport reportDiagnostico = (JasperReport) JRLoader.loadObject(getClass().getResource("preguntas.jasper"));
            JasperPrint jprintDiagnostico = JasperFillManager.fillReport(reportDiagnostico, null, DiagnosticoDataSource.getDataSource(listadoPreguntas));

            final String extension = "png";
            final float zoom = 4f;
            String fileName = "report";
            //one image for every page in my report
            int pages = jprintDiagnostico.getPages().size();
            file = new File("src/Archivos/");
            String rutaImagen = file.getAbsolutePath();
            for (int i = 0; i < pages; i++) {
                try (OutputStream out = new FileOutputStream(rutaImagen + "/diagnostico" + (i + 1) + "." + extension)) {
                    System.out.println(rutaImagen);
                    BufferedImage image = (BufferedImage) JasperPrintManager.printPageToImage(jprintDiagnostico, i, zoom);
                    ImageIO.write(image, extension, out); //write image to file
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            
            file = new File("src/Archivos/" + "diagnostico1.png");
            String diagnostico = file.getAbsolutePath();
            parametros.put("diagnostico", diagnostico);
            
            
            recomendaciones = "1. Este servicio no fue auditado debido a que el inmueble donde se encuentra ubicado el centro de "
                    + "información resultó con severos daños por el sismo del pasado 19 de septiembre del presente año. "
                    + "No se ha proporcionado el servicio a la comunidad tecnológica, por lo tanto, no se tienen elementos para "
                    + "realizar esta auditoria.";
            parametros.put("recomendaciones", recomendaciones);

            //parametros.put("subReporte", subReporte);
            //parametros.put("subReporteDiagnostico", subReporteDiagnostico);
            JasperPrint jprint = JasperFillManager.fillReport(report, parametros, ReporteDataSource.getDataSource(listadoCalificaciones));

            JasperViewer view = new JasperViewer(jprint, false);
            
            
            

            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);

        } catch (JRException ex) {
            ex.getMessage();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        GeneradorReporte jasper = new GeneradorReporte();

    }

}
