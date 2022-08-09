package controlador;

import Modelo.Pregunta;
import Modelo.ResultadosTabla;
import Modelo.TablaDiagnostico;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
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
    Float promTotal;
    private Object[][] listadoPreguntas;

    private Object[][] listadoCalificaciones;

    public Object[][] grafico;

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

    }

    public void llenarResultados(List<ResultadosTabla> resultados, float promedios[], float promedio, List<Pregunta> preguntas, String comparativo, List<TablaDiagnostico> listaTablaDiagnostico) {
        int fila1 = 0, fila2 = 0, fila3 = 0, fila4 = 0, fila5 = 0;

        for (int i = 1; i <= 8; i++) {
            fila1 += resultados.get(i).getNoCalificacionUno();
            fila2 += resultados.get(i).getNoCalificacionDos();
            fila3 += resultados.get(i).getNoCalificacionTres();
            fila4 += resultados.get(i).getNoCalificacionCuatro();
            fila5 += resultados.get(i).getNoCalificacionCinco();
        }
        BigDecimal bd = new BigDecimal(promedio).setScale(2, RoundingMode.HALF_UP);
        promedio = (float) bd.doubleValue();

        listadoCalificaciones = new Object[][]{
            {1, resultados.get(0).getNoCalificacionUno(), resultados.get(0).getNoCalificacionDos(), resultados.get(0).getNoCalificacionTres(), resultados.get(0).getNoCalificacionCuatro(), resultados.get(0).getNoCalificacionCinco(), promedios[0]},
            {2, resultados.get(1).getNoCalificacionUno(), resultados.get(1).getNoCalificacionDos(), resultados.get(1).getNoCalificacionTres(), resultados.get(1).getNoCalificacionCuatro(), resultados.get(1).getNoCalificacionCinco(), promedios[1]},
            {3, resultados.get(2).getNoCalificacionUno(), resultados.get(2).getNoCalificacionDos(), resultados.get(2).getNoCalificacionTres(), resultados.get(2).getNoCalificacionCuatro(), resultados.get(2).getNoCalificacionCinco(), promedios[2]},
            {4, resultados.get(3).getNoCalificacionUno(), resultados.get(3).getNoCalificacionDos(), resultados.get(3).getNoCalificacionTres(), resultados.get(3).getNoCalificacionCuatro(), resultados.get(3).getNoCalificacionCinco(), promedios[3]},
            {5, resultados.get(4).getNoCalificacionUno(), resultados.get(4).getNoCalificacionDos(), resultados.get(4).getNoCalificacionTres(), resultados.get(4).getNoCalificacionCuatro(), resultados.get(4).getNoCalificacionCinco(), promedios[4]},
            {6, resultados.get(5).getNoCalificacionUno(), resultados.get(5).getNoCalificacionDos(), resultados.get(5).getNoCalificacionTres(), resultados.get(5).getNoCalificacionCuatro(), resultados.get(5).getNoCalificacionCinco(), promedios[5]},
            {7, resultados.get(6).getNoCalificacionUno(), resultados.get(6).getNoCalificacionDos(), resultados.get(6).getNoCalificacionTres(), resultados.get(6).getNoCalificacionCuatro(), resultados.get(6).getNoCalificacionCinco(), promedios[6]},
            {8, resultados.get(7).getNoCalificacionUno(), resultados.get(7).getNoCalificacionDos(), resultados.get(7).getNoCalificacionTres(), resultados.get(7).getNoCalificacionCuatro(), resultados.get(7).getNoCalificacionCinco(), promedios[7]},
            {9, resultados.get(8).getNoCalificacionUno(), resultados.get(8).getNoCalificacionDos(), resultados.get(8).getNoCalificacionTres(), resultados.get(8).getNoCalificacionCuatro(), resultados.get(8).getNoCalificacionCinco(), promedios[8]},
            {"Promedio", fila1, fila2, fila3, fila4, fila5, promedio}
        };

        grafico = new Object[][]{
            {"1", promedios[0]},
            {"2", promedios[1]},
            {"3", promedios[2]},
            {"4", promedios[3]},
            {"5", promedios[4]},
            {"6", promedios[5]},
            {"7", promedios[6]},
            {"8", promedios[7]},
            {"9", promedios[8]}
        };

        listadoPreguntas = new Object[][]{
            {Float.parseFloat(listaTablaDiagnostico.get(0).getPromedioAnterior()), promedios[0], preguntas.get(0).getPreg()},
            {Float.parseFloat(listaTablaDiagnostico.get(1).getPromedioAnterior()), promedios[1], preguntas.get(1).getPreg()},
            {Float.parseFloat(listaTablaDiagnostico.get(2).getPromedioAnterior()), promedios[2], preguntas.get(2).getPreg()},
            {Float.parseFloat(listaTablaDiagnostico.get(3).getPromedioAnterior()), promedios[3], preguntas.get(3).getPreg()},
            {Float.parseFloat(listaTablaDiagnostico.get(4).getPromedioAnterior()), promedios[4], preguntas.get(4).getPreg()},
            {Float.parseFloat(listaTablaDiagnostico.get(5).getPromedioAnterior()), promedios[5], preguntas.get(5).getPreg()},
            {Float.parseFloat(listaTablaDiagnostico.get(6).getPromedioAnterior()), promedios[6], preguntas.get(6).getPreg()},
            {Float.parseFloat(listaTablaDiagnostico.get(7).getPromedioAnterior()), promedios[7], preguntas.get(7).getPreg()},
            {Float.parseFloat(listaTablaDiagnostico.get(8).getPromedioAnterior()), promedios[8], preguntas.get(8).getPreg()},
            {Float.parseFloat(listaTablaDiagnostico.get(9).getPromedioAnterior()), promedio, comparativo}
        };

    }

    public GeneradorReporte(List<ResultadosTabla> resultados, double promedio, float promedios[], String comentarios, List<Pregunta> preguntas, String area, String recomendaciones, String carrera, String areaAudi, String comparativo, List<TablaDiagnostico> listaTablaDiagnostico, boolean graficoHecho) {

        try {
            promTotal = (float) promedio;
            llenarResultados(resultados, promedios, promTotal, preguntas, comparativo, listaTablaDiagnostico);

            responsable(area);
            fecha();
            muestra(carrera);
            areaAuditada(areaAudi);

            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("reporteMaestroEncuesta.jasper"));
            Map<String, Object> parametros = new HashMap();
            parametros.put("nombreDocumento", nombreDocumento);
            parametros.put("referenciaNorma", norma);
            parametros.put("revision", revision);
            File file = new File("src/Archivos/" + prop.acceder("logo", ruta));
            String logo = file.getAbsolutePath();
            parametros.put("logo", logo);
            parametros.put("nombreIT", nombreIT.toUpperCase());
            parametros.put("areaAuditada", areaAuditada + " / " + carrera);
            parametros.put("responsable", responsables.toUpperCase());
            parametros.put("fecha", fecha);
            parametros.put("rd", rd.toUpperCase());
            parametros.put("auditor", auditorLider.toUpperCase());
            parametros.put("noEncuestas", noEncuestas);
            parametros.put("promTotal", promTotal);

            parametros.put("comentarios", comentarios);

            //GraficoReporte generaGrafico = new GraficoReporte(grafico);
            try {
                GraficaQuickChart.generarGrafico(promedios);
            } catch (Exception ex) {
                Logger.getLogger(GeneradorReporte.class.getName()).log(Level.SEVERE, null, ex);
            }

//            try {
//                // if(graficoHecho==false){
//                generaGrafico.hacerGrafico(grafico);
//                // }
//            } catch (Exception ex) {
//                Logger.getLogger(GeneradorReporte.class.getName()).log(Level.SEVERE, null, ex);
//            }
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
     * @param resultados
     * @param promedio
     * @param promedios
     * @param comentarios
     * @param preguntas
     * @param area
     * @param recomendaciones
     * @param carrera
     * @param areaAudi
     * @param comparativo
     * @param listaTablaDiagnostico
     * @param graficoHecho
     */
    public void generar(List<ResultadosTabla> resultados, double promedio, float promedios[], String comentarios, List<Pregunta> preguntas, String area, String recomendaciones, String carrera, String areaAudi, String comparativo, List<TablaDiagnostico> listaTablaDiagnostico, boolean graficoHecho) {

        GeneradorReporte jasper = new GeneradorReporte(resultados, promedio, promedios, comentarios, preguntas, area, recomendaciones, carrera, areaAudi, comparativo, listaTablaDiagnostico, graficoHecho);
        
    }

}
