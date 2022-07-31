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
import javax.swing.JOptionPane;

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
    List<Encuesta> encuestas = new ArrayList();
    List<TablaDiagnostico> listaTablaDiagnostico = new ArrayList();
    List<ResultadosTabla> resultados = new ArrayList();
    List<Pregunta> preguntas = new ArrayList();
    float promedios[];

    private String carrera, area, tituloPantalla, nombreAreaBien, carpeta, comentarios = "", comparacion, carpetaAnterior;
    String rutaXml = "src/Documentos/";
    XmlActions xml = new XmlActions();
    Propiedades prop = new Propiedades();
    double promedio = 0;
    boolean banderaComparacion = false;
    int preguntasDobles = 0, aumentosAltos = 0, aumentosComparacion = 0;
    private double valorParcial;

    public opcRecomendaciones(String area, String tituloPantalla, String carrera) {
        ImageIcon iconoT = new ImageIcon("src/Archivos/favicon.png");
        this.setIconImage(iconoT.getImage());
        initComponents();
        this.carrera = carrera;
        this.area = area;
        System.out.println("nombre de la variable area "+area);
        this.tituloPantalla = tituloPantalla;
        System.out.println(area);
        nombreAreaBien = prop.acceder("archivo" + area, rutaXml + "ajustesAreas.properties");
        System.out.println("nombre area bien "+nombreAreaBien);
        carpeta = prop.acceder("archivoActual", rutaXml + "config.properties");
        System.out.println(nombreAreaBien + "\n" + carpeta);

        loadrecomendaciones();

        preguntas = xml.loadPreguntasDataFromFile(new File(rutaXml + nombreAreaBien + ".xml"));
        //preguntas = xml.loadPreguntasDataFromFile(new File(rutaXml + "residenciasProfesionales" + ".xml"));
        encuestas = xml.loadEncuestasDataFromFile(new File(rutaXml + "Periodos/" + carpeta + "/" + carrera.trim() + "/" + nombreAreaBien + "Encuestas.xml"));
        System.out.println("Numero de preguntas: " + preguntas.size());
        System.out.println("Numero de encuestas: " + encuestas.size());

        //como llenar la informacion
        ResultadosTabla respuestasCondensadas[] = new ResultadosTabla[preguntas.size()];

        for (int i = 0; i < respuestasCondensadas.length; i++) {
            respuestasCondensadas[i] = new ResultadosTabla(i + 1);
        }

        int numeracion = 1;
        for (int i = 0; i < encuestas.size(); i++) {
            Encuesta encuesta = encuestas.get(i);
            for (int j = 0; j < preguntas.size(); j++) {
                int respuesta = Integer.parseInt(encuesta.getRespuesta(j).getRespuesta());
                switch (respuesta) {
                    case 1:
                        respuestasCondensadas[j].setNoCalificacionUno(respuestasCondensadas[j].getNoCalificacionUno() + 1);
                        break;
                    case 2:
                        respuestasCondensadas[j].setNoCalificacionDos(respuestasCondensadas[j].getNoCalificacionDos() + 1);
                        break;
                    case 3:
                        respuestasCondensadas[j].setNoCalificacionTres(respuestasCondensadas[j].getNoCalificacionTres() + 1);
                        break;
                    case 4:
                        respuestasCondensadas[j].setNoCalificacionCuatro(respuestasCondensadas[j].getNoCalificacionCuatro() + 1);
                        break;
                    case 5:
                        respuestasCondensadas[j].setNoCalificacionCinco(respuestasCondensadas[j].getNoCalificacionCinco() + 1);
                        break;
                }
            }
            if (!encuesta.getComentario().isEmpty()) {
                comentarios += /*"• "*/ (numeracion++) + ". " + encuesta.getComentario() + "\n";
            }

        }
        promedios = new float[respuestasCondensadas.length];
        for (int i = 0; i < respuestasCondensadas.length; i++) {
            System.out.println("Pregunta " + i + ": respuestas con 1=" + respuestasCondensadas[i].getNoCalificacionUno()
                    + ": respuestas con 2=" + respuestasCondensadas[i].getNoCalificacionDos()
                    + ": respuestas con 3=" + respuestasCondensadas[i].getNoCalificacionTres()
                    + ": respuestas con 4=" + respuestasCondensadas[i].getNoCalificacionCuatro()
                    + ": respuestas con 5=" + respuestasCondensadas[i].getNoCalificacionCinco());
            ResultadosTabla resultado = new ResultadosTabla(i + 1, respuestasCondensadas[i].getNoCalificacionUno(), respuestasCondensadas[i].getNoCalificacionDos(), respuestasCondensadas[i].getNoCalificacionTres(), respuestasCondensadas[i].getNoCalificacionCuatro(), respuestasCondensadas[i].getNoCalificacionCinco());
            promedio += resultado.getPromedio();
            promedios[i] = (float) resultado.getPromedio();

            prop.guardar("promedioPregunta" + (i + 1) + area, String.format("%.2f", resultado.getPromedio()), rutaXml + "Periodos/" + carpeta + "/" + carrera.trim() + "/PeriodoCarrera.properties");
            resultados.add(resultado);
        }
        valorParcial = promedio;
        BigDecimal bd = new BigDecimal(valorParcial).setScale(2, RoundingMode.HALF_UP);
        promedio = bd.doubleValue();

        promedio = promedio / resultados.size();

        //DATOS A ENVIAR
        System.out.println("Promedio General: " + promedio);
        System.out.println(comentarios);
        jTextArea3.setText(comentarios);

        //cargando promedios anteriores
        carpetaAnterior = prop.acceder("archivoAnterior", rutaXml + "config.properties");
        System.out.println("Carpeta anterior: " + carpetaAnterior);

        for (int i = 0; i < preguntas.size(); i++) {
            String promedioPreguntaAnterior = prop.acceder("promedioPregunta" + (i + 1) + area, rutaXml + "Periodos/" + carpetaAnterior + "/" + carrera + "/PeriodoCarrera.properties");
            System.out.println("Promedio Pregunta Anterior: " + promedioPreguntaAnterior + "\nCarrera: " + carrera);
            String pregunta = (i + 1) + ". " + preguntas.get(i).getPreg();
            if (pregunta.length() > 80) {
                String palabras[] = pregunta.split(" ");
                String preguntaFormateada = "", auxiliarPregunta = "";
                for (int j = 0; j < palabras.length; j++) {
                    String palabra = palabras[j];
                    if ((auxiliarPregunta.length() + palabra.length()) < 80) {
                        auxiliarPregunta += palabra + " ";
                    } else {
                        preguntaFormateada += auxiliarPregunta + "\n";
                        auxiliarPregunta = palabra + " ";
                        aumentosAltos++;
                    }
                }
                preguntaFormateada += auxiliarPregunta;
                System.out.println(preguntaFormateada);
                pregunta = preguntaFormateada;
                preguntasDobles++;
            }
            //ARRAYLIST SE LLENA LA TABLA DIAGNOSTICO :)
            listaTablaDiagnostico.add(new TablaDiagnostico(promedioPreguntaAnterior, resultados.get(i).getPromedio() + "", pregunta));
        }
        comparacion = prop.acceder("comparacion" + area, rutaXml + "Periodos/" + carpeta + "/" + carrera + "/PeriodoCarrera.properties");
        System.out.println("valor inicial de comparacion "+comparacion);
        if (!comparacion.equals("sincomparacion")) {
            System.out.println("EXISTE COMPARACION");
            banderaComparacion = true;
            /*if (comparacion.length() > 80) {
                String palabras[] = comparacion.replace("\n", "").split(" ");
                String comparacionFormateada = "", auxiliarComparacion = "";
                for (int j = 0; j < palabras.length; j++) {
                    String palabra = palabras[j];
                    System.out.println(palabra);
                    if ((auxiliarComparacion.length() + palabra.length()) < 80) {
                        auxiliarComparacion += palabra + " ";
                    } else {
                        comparacionFormateada += auxiliarComparacion + "\n";
                        auxiliarComparacion = palabra + " ";
                        aumentosComparacion++;
                    }
                }
                comparacionFormateada += auxiliarComparacion;
                System.out.println("COMPARACION FORMATEADA "+comparacionFormateada);
                comparacion = comparacionFormateada;
                System.out.println("COMPARACION "+comparacion);
                
            }*/
            jTextArea2.setText(comparacion);
            listaTablaDiagnostico.add(new TablaDiagnostico(prop.acceder("promedioEncuestas" + area, rutaXml + "Periodos/" + carpetaAnterior + "/" + carrera + "/PeriodoCarrera.properties"), String.format("%.2f", promedio), jTextArea2.getText()));
        } else {
            listaTablaDiagnostico.add(new TablaDiagnostico(prop.acceder("promedioEncuestas" + area, rutaXml + "Periodos/" + carpetaAnterior + "/" + carrera + "/PeriodoCarrera.properties"), String.format("%.2f", promedio), ""));
        }
        System.out.println("promedio general anterior" + listaTablaDiagnostico.get(preguntas.size()).getPromedioAnterior());
        System.out.println("promedio general anterior" + listaTablaDiagnostico.get(preguntas.size()).getPromedioActual());
        jTextField1.setText(listaTablaDiagnostico.get(preguntas.size()).getPromedioAnterior());
        jTextField2.setText(listaTablaDiagnostico.get(preguntas.size()).getPromedioActual());
        String terminado = prop.acceder("procesosTerminados" + area, rutaXml + "Periodos/" + carpeta + "/" + carrera + "/PeriodoCarrera.properties");
        if(terminado.equalsIgnoreCase("si")){
            jLabel9.setText("EL SERVICIO HA SIDO FINALIZADO");
        }else{
            jLabel9.setText("EL SERVICIO ESTA EN PROCESO DE CAPTURA");
        }
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
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
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

        jButton1.setText("VISUALIZAR REPORTE");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("GUARDAR Y FINALIZAR");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel2.setText("PROMEDIO GENERAL ANTERIOR:");

        jTextField1.setEditable(false);

        jLabel5.setText("PROMEDIO GENERAL ACTUAL:");

        jTextField2.setEditable(false);

        jLabel9.setText("EL SERVICIO SIGUE EN CAPTURA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(521, 521, 521)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3)
                                        .addComponent(jScrollPane3)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(357, 357, 357)
                                .addComponent(jButton1)
                                .addGap(45, 45, 45)
                                .addComponent(jButton2)))
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel9)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(58, 58, 58))
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
        if (!comparativo.isEmpty()) {
            if (!recomendaciones.isEmpty()) {
                genera.generar(resultados, promedio, promedios, comentarios, preguntas, area, recomendaciones, carrera, tituloPantalla, comparativo, listaTablaDiagnostico);
            } else {
                JOptionPane.showMessageDialog(null, "NO PUEDES DEJAR EL CAMPO DE RECOMENDACIONES VACIO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "EL DIAGNOSTICO COMPARATIVO DE LOS PROMEDIOS ESTA VACIO, POR FAVOR NO DEJES VACIO ESTE CAMPO");
        }

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:

        String recomendaciones = jTextArea1.getText();
        String comparativo = jTextArea2.getText();
        if (!comparativo.isEmpty()) {
            if (!recomendaciones.isEmpty()) {
                int resp = JOptionPane.showConfirmDialog(null, "Antes de finalizar este proceso es recomendable revisar que el documento este correcto\n"
                    + "¿Deseas finalizar este proceso?", "Finalizar Reporte", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == 0) {

                    System.out.println("si tiene contenido: " + recomendaciones);

                    File archivoXml = new File(rutaXml + "Periodos/" + carpeta + "/" + carrera.trim() + "/" + nombreAreaBien + "Encuestas.xml");
                    if (xml.saveRecomendacionesDataToFile(archivoXml, recomendaciones)) {

                        prop.guardar("procesosTerminados" + area, "si", rutaXml + "Periodos/" + carpeta + "/" + carrera + "/PeriodoCarrera.properties");
                        prop.guardar("recomendacionesCapturadas" + area, "si", rutaXml + "Periodos/" + carpeta + "/" + carrera + "/PeriodoCarrera.properties");
                        prop.guardar("promedioEncuestas" + area, String.format("%.2f", promedio), rutaXml + "Periodos/" + carpeta + "/" + carrera + "/PeriodoCarrera.properties");
                        prop.guardar("comparacion" + area, jTextArea2.getText(), rutaXml + "Periodos/" + carpeta + "/" + carrera + "/PeriodoCarrera.properties");

                        JOptionPane.showMessageDialog(null, "Se han guardado las recomendaciones.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Se ha producido un error al guardar las recomendaciones");
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha escrito nada en las recomendaciones");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha escrito nada en el diagnóstico.");
        }
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     */
    public void loadrecomendaciones() {
        File archivoXml = new File(rutaXml + "Periodos/" + carpeta + "/" + carrera.trim() + "/" + nombreAreaBien + "Encuestas.xml");
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
                new opcRecomendaciones("Centro", "Centro De Informacion", "ING. En administración").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
