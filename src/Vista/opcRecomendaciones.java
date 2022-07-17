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
import controlador.GeneradorReporte;
import controlador.Propiedades;
import controlador.XmlActions;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.ImageIcon;

/**
 *
 * @author Yael_
 */
public class opcRecomendaciones extends javax.swing.JFrame {
    
    
    //variables moer ventana
    int xmouse, ymouse;

    /**
     * Creates new form opcRecomendaciones
     */
    ObservableList<ResultadosTabla> datos;
    ObservableList<TablaDiagnostico> datosDiagnostico;
    List<Encuesta> encuestas = new ArrayList();
    List<TablaDiagnostico> listaTablaDiagnostico = new ArrayList();
    List<ResultadosTabla> resultados = new ArrayList();
    List<Pregunta> preguntas = new ArrayList();
    float promedios[];
    
    
    private String carrera, area, tituloPantalla, nombreAreaBien, carpeta, comentarios = "", comparacion, carpetaAnterior;
    String rutaXml = "src/Documentos/";
    XmlActions xml = new XmlActions();
    Propiedades prop= new Propiedades();
    double promedio = 0;
    boolean banderaComparacion = false;
    int preguntasDobles = 0, aumentosAltos = 0, aumentosComparacion = 0;
    private double valorParcial;
    
    public opcRecomendaciones(String area, String tituloPantalla, String carrera) {
        ImageIcon iconoT = new ImageIcon("src/Archivos/favicon.png");
        this.setIconImage(iconoT.getImage());
        initComponents();
        this.carrera=carrera;
        this.area = area;
        this.tituloPantalla = tituloPantalla;
        System.out.println(area);
        nombreAreaBien = prop.acceder("archivo"+area, rutaXml + "ajustesAreas.properties");
        carpeta = prop.acceder("archivoActual", rutaXml + "config.properties");
        System.out.println(nombreAreaBien + "\n" + carpeta);
        
        loadrecomendaciones();
        
        
        
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
        promedios = new float[respuestasCondensadas.length];
        for (int i = 0; i < respuestasCondensadas.length; i++) {
            System.out.println("Pregunta " + i + ": respuestas con 1=" + respuestasCondensadas[i].getNoCalificacionUno() +
                    ": respuestas con 2=" + respuestasCondensadas[i].getNoCalificacionDos() +
                    ": respuestas con 3=" + respuestasCondensadas[i].getNoCalificacionTres() +
                    ": respuestas con 4=" + respuestasCondensadas[i].getNoCalificacionCuatro() +
                    ": respuestas con 5=" + respuestasCondensadas[i].getNoCalificacionCinco());
            ResultadosTabla resultado = new ResultadosTabla(i+1, respuestasCondensadas[i].getNoCalificacionUno(), respuestasCondensadas[i].getNoCalificacionDos(), respuestasCondensadas[i].getNoCalificacionTres(), respuestasCondensadas[i].getNoCalificacionCuatro(), respuestasCondensadas[i].getNoCalificacionCinco());
            promedio += resultado.getPromedio();
            promedios[i] = (float)resultado.getPromedio();
            
            prop.guardar("promedioPregunta" + (i + 1) + area, String.format("%.2f", resultado.getPromedio()), rutaXml+"Periodos/" + carpeta+"/"+carrera.trim() + "/PeriodoCarrera.properties");
            resultados.add(resultado);
        }
        valorParcial = promedio;
        BigDecimal bd = new BigDecimal(valorParcial).setScale(2, RoundingMode.HALF_UP);
        promedio = bd.doubleValue();
        
        promedio = promedio/resultados.size();
        
        
        //DATOS A ENVIAR
        
        System.out.println("Promedio General: " + promedio);
        System.out.println(comentarios);
        jTextArea3.setText(comentarios);
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
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(248, 248, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1130, 852));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("RECOMENDACIONES");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel3.setText("DIAGNOSTICO COMPARATIVO DE LOS PROMEDIOS");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane4.setViewportView(jTextArea3);

        jLabel4.setText("COMENTARIOS");

        jButton1.setText("jButton1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(146, 146, 146))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(68, 68, 68))
        );

        jPanel3.setBackground(new java.awt.Color(0, 53, 153));
        jPanel3.setPreferredSize(new java.awt.Dimension(1130, 58));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BtnAtras.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info1.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("RECOMENDACIONES");
        jLabel8.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(444, 444, 444)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xmouse, y - ymouse);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        // TODO add your handling code here:
        xmouse = evt.getX();
        ymouse = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
        GeneradorReporte genera = new GeneradorReporte();
        String recomendaciones = jTextArea1.getText();
        String comparativo = jTextArea2.getText();
        genera.generar(resultados, promedio, promedios,comentarios,preguntas,area, recomendaciones,carrera,tituloPantalla,comparativo);
    }//GEN-LAST:event_jButton1MouseClicked

    
    /**
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}
