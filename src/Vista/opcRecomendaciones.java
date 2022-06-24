/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Encuesta;
import Modelo.Pregunta;
import Modelo.ResultadosTabla;
import Modelo.TablaDiagnostico;
import controlador.Propiedades;
import controlador.XmlActions;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Yael_
 */
public class opcRecomendaciones extends javax.swing.JFrame {

    /**
     * Creates new form opcRecomendaciones
     */
    ObservableList<ResultadosTabla> datos;
    ObservableList<TablaDiagnostico> datosDiagnostico;
    List<Encuesta> encuestas = new ArrayList();
    List<TablaDiagnostico> listaTablaDiagnostico = new ArrayList();
    
    private String carrera, area, tituloPantalla, nombreAreaBien, carpeta, comentarios = "", comparacion, carpetaAnterior;
    String rutaXml = "src/Documentos/";
    XmlActions xml = new XmlActions();
    Propiedades prop= new Propiedades();
    double promedio = 0;
    boolean banderaComparacion = false;
    int preguntasDobles = 0, aumentosAltos = 0, aumentosComparacion = 0;
    private double valorParcial;
    
    public opcRecomendaciones(String area, String tituloPantalla, String carrera) {
        initComponents();
        this.carrera=carrera;
        this.area = area;
        this.tituloPantalla = tituloPantalla;
        System.out.println(area);
        nombreAreaBien = prop.acceder("archivo"+area, rutaXml + "ajustesAreas.properties");
        carpeta = prop.acceder("archivoActual", rutaXml + "config.properties");
        System.out.println(nombreAreaBien + "\n" + carpeta);
        
        loadrecomendaciones();
        
        List<ResultadosTabla> resultados = new ArrayList();
        List<Pregunta> preguntas = new ArrayList();
        
        preguntas = xml.loadPreguntasDataFromFile(new File(rutaXml + nombreAreaBien + ".xml"));
        //preguntas = xml.loadPreguntasDataFromFile(new File(rutaXml + "residenciasProfesionales" + ".xml"));
        encuestas = xml.loadEncuestasDataFromFile(new File(rutaXml+"Periodos/" + carpeta + "/"+carrera.trim()+"/" + nombreAreaBien + "Encuestas.xml"));
        System.out.println("Numero de preguntas: " + preguntas.size());
        System.out.println("Numero de encuestas: " + encuestas.size());
        
        //como llenar la informacion
        ResultadosTabla respuestasCondensadas [] = new ResultadosTabla[preguntas.size()];
        
        for (int i = 0; i < respuestasCondensadas.length ; i++) {
            respuestasCondensadas[i] = new ResultadosTabla(i+1);
        }
        
        int numeracion = 1;
        for (int i = 0; i < encuestas.size(); i++) {
            Encuesta encuesta = encuestas.get(i);
            for (int j = 0; j < preguntas.size(); j++) {
                int respuesta = Integer.parseInt(encuesta.getRespuesta(j).getRespuesta());
                switch (respuesta) {
                    case 1:
                        respuestasCondensadas[j].setNoCalificacionUno(respuestasCondensadas[j].getNoCalificacionUno()+1);
                        break;
                    case 2:
                        respuestasCondensadas[j].setNoCalificacionDos(respuestasCondensadas[j].getNoCalificacionDos()+1);
                        break;
                    case 3:
                        respuestasCondensadas[j].setNoCalificacionTres(respuestasCondensadas[j].getNoCalificacionTres()+1);
                        break;
                    case 4:
                        respuestasCondensadas[j].setNoCalificacionCuatro(respuestasCondensadas[j].getNoCalificacionCuatro()+1);
                        break;
                    case 5:
                        respuestasCondensadas[j].setNoCalificacionCinco(respuestasCondensadas[j].getNoCalificacionCinco()+1);
                        break;
                }
            }
            if (!encuesta.getComentario().isEmpty()) {
                comentarios += /*"• "*/ (numeracion++) + ". " + encuesta.getComentario() + "\n";
            }
            
        }
        for (int i = 0; i < respuestasCondensadas.length; i++) {
            System.out.println("Pregunta " + i + ": respuestas con 1=" + respuestasCondensadas[i].getNoCalificacionUno() +
                    ": respuestas con 2=" + respuestasCondensadas[i].getNoCalificacionDos() +
                    ": respuestas con 3=" + respuestasCondensadas[i].getNoCalificacionTres() +
                    ": respuestas con 4=" + respuestasCondensadas[i].getNoCalificacionCuatro() +
                    ": respuestas con 5=" + respuestasCondensadas[i].getNoCalificacionCinco());
            ResultadosTabla resultado = new ResultadosTabla(i+1, respuestasCondensadas[i].getNoCalificacionUno(), respuestasCondensadas[i].getNoCalificacionDos(), respuestasCondensadas[i].getNoCalificacionTres(), respuestasCondensadas[i].getNoCalificacionCuatro(), respuestasCondensadas[i].getNoCalificacionCinco());
            promedio += resultado.getPromedio();
            
            
            prop.guardar("promedioPregunta" + (i + 1) + area, String.format("%.2f", resultado.getPromedio()), rutaXml+"Periodos/" + carpeta+"/"+carrera.trim() + "/PeriodoCarrera.properties");
            resultados.add(resultado);
        }
        valorParcial = promedio;
        BigDecimal bd = new BigDecimal(valorParcial).setScale(2, RoundingMode.HALF_UP);
        promedio = bd.doubleValue();
        
        promedio = promedio/resultados.size();
        
        System.out.println("Promedio General: " + promedio);
        System.out.println(comentarios);
        //add comments in text area
        //jTextArea3.setText(comentarios);
        datos = FXCollections.observableArrayList(resultados);
        //tablaResultados.setItems(datos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 248, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("RECOMENDACIONES");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel3.setText("DIAGNOSTICO COMPARATIVO DE LOS PROMEDIOS");

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(379, 379, 379)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane3)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(99, 99, 99)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void loadrecomendaciones(){
        File archivoXml = new File(rutaXml+"Periodos/" + carpeta + "/"+carrera.trim()+"/" + nombreAreaBien + "Encuestas.xml");
        String recomendaciones = xml.loadRecomendacionDataFromFile(archivoXml);
        if (recomendaciones == null) {
            jTextArea1.setText("");
            System.out.println("nose ha obtenido nada");
        } else {
             jTextArea1.setText(recomendaciones);
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(opcRecomendaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(opcRecomendaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(opcRecomendaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(opcRecomendaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new opcRecomendaciones("Centro","Centro De Informacion","ING. En administración").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
