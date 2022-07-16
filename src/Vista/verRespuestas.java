package Vista;

import Modelo.Carrera;
import Modelo.Encuesta;
import Modelo.Pregunta;
import Modelo.Respuesta;
import controlador.LectorExcel;
import controlador.Propiedades;
import controlador.RandomValues;
import controlador.XmlActions;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextField;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rojerusan.RSNotifyAnimated;

public class verRespuestas extends javax.swing.JFrame {

    //variables moer ventana
    int xmouse, ymouse;

    private boolean banderafiltrado = false;
    private String carpeta = "";
    private String area, clave, archivo, comentarios = "";

    LectorExcel Lector = new LectorExcel();
    List cellData = new ArrayList();

    List<Carrera> carreras = new ArrayList();
    List<Pregunta> preguntas = new ArrayList();
    List<Encuesta> encuestas = new ArrayList();

    int tam = 0, tamPreguntas = 0;
    String rutaXml = "src/Documentos/";
    //String rutaDocs = "src/gestionauditoria/archivos/documentos/";
    String rutaCarreras = "src/Documentos/carreras.xml";
    String rutaMuestra = "src/Documentos/muestra.properties";
    String ruta = "src/Documentos/";
    File periodo;

    XmlActions xml = new XmlActions();
    Propiedades prop = new Propiedades();

    public verRespuestas(String name, String area, String clave) {
        ImageIcon iconoT = new ImageIcon("src/Archivos/favicon.png");
        this.setIconImage(iconoT.getImage());
        initComponents();
        this.area = area;
        this.clave = clave;
        this.archivo = prop.acceder("archivo" + clave, ruta + "ajustesAreas.properties");

        this.setLocationRelativeTo(null);
        this.setTitle(area);
        jLabel1.setText(area);

        File rutaArchivoExcel = new File(name);
        cellData = Lector.getExcel(rutaArchivoExcel);

        llenarTabla();

        carreras = xml.loadCarrerasDataFromFile(new File("src/Documentos/carreras.xml"));
        tam = carreras.size();
        llenarCarreras();

        carpeta = prop.acceder("archivoActual", ruta + "config.properties");

        System.out.println(clave);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(248, 248, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "usuario", "Programa", "fecha", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "comentarios"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 950, 430));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona una carrera" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 440, 40));

        jPanel8.setBackground(new java.awt.Color(27, 57, 106));
        jPanel8.setPreferredSize(new java.awt.Dimension(120, 50));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(248, 248, 255));
        jLabel9.setText("APLICAR MUESTRA");
        jLabel9.setAlignmentY(0.0F);
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 200, 40));

        jPanel9.setBackground(new java.awt.Color(27, 57, 106));
        jPanel9.setPreferredSize(new java.awt.Dimension(120, 50));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(248, 248, 255));
        jLabel10.setText("VER TODAS LAS CARRERAS");
        jLabel10.setAlignmentY(0.0F);
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 460, 280, 40));

        jPanel10.setBackground(new java.awt.Color(27, 57, 106));
        jPanel10.setPreferredSize(new java.awt.Dimension(120, 50));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(248, 248, 255));
        jLabel11.setText("COMENTARIOS");
        jLabel11.setAlignmentY(0.0F);
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 200, 40));

        jPanel11.setBackground(new java.awt.Color(27, 57, 106));
        jPanel11.setPreferredSize(new java.awt.Dimension(120, 50));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(248, 248, 255));
        jLabel12.setText("AGREGAR RECOMENDACIONES");
        jLabel12.setAlignmentY(0.0F);
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, 330, 40));

        jPanel12.setBackground(new java.awt.Color(27, 57, 106));
        jPanel12.setPreferredSize(new java.awt.Dimension(120, 50));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel12MouseEntered(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(248, 248, 255));
        jLabel13.setText("GUARDAR");
        jLabel13.setAlignmentY(0.0F);
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel13)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 520, 150, 40));

        jPanel3.setBackground(new java.awt.Color(0, 53, 153));
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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BtnAtras.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info1.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AREA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(356, 356, 356)
                .addComponent(jLabel3))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

        String item = (String) evt.getItem();
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (!banderafiltrado) {
                if (!item.equalsIgnoreCase("Selecciona una carrera")) {
                    banderafiltrado = true;
                    filtrar(item);
                } else {
                    JOptionPane.showMessageDialog(null, "Aun no seleccionas ninguna carrera");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Para filtrar una carrera nueva necesitas limpiar la tabla primero");
            }
        }
        if (evt.getStateChange() == ItemEvent.DESELECTED) {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);
            llenarTabla();
            banderafiltrado = false;
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        CAPTURA obj = new CAPTURA();
        obj.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jLabel2MouseClicked

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

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        if (banderafiltrado) {
            String carrera = jComboBox1.getSelectedItem().toString().trim();
            String rutaPeriodoCarrera = ruta + "/Periodos/" + carpeta + "/" + carrera + "/PeriodoCarrera.properties";
            String iniciado = prop.acceder("iniciado" + clave, rutaPeriodoCarrera);
            if (iniciado.equals("no")) {
                String muestra = prop.acceder("muestra" + carrera, rutaMuestra);
                if (muestra != null) {
                    float rows = jTable1.getRowCount();
                    float m = Float.parseFloat(muestra);
                    if (rows >= m) {
                        int resp = JOptionPane.showConfirmDialog(null, "La muestra cumple con los requisitos\n¿Deseas aplicar la muestra?", carrera, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (resp == 0) {
                            if (guardarRespuestas(carrera, m)) {
                                if (prop.guardar("iniciado" + clave, "si", rutaPeriodoCarrera)) {
                                    JOptionPane.showMessageDialog(null, "La muestra de la carrera " + carrera + " es: " + muestra);
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La muestra de la carrera " + carrera + " no cumple con los requisitos\n "
                                + "La muestra es: " + m + "\n"
                                + "Actualmente la carrera tiene: " + rows + "\n"
                                + "Es necesario capturar " + (m - rows) + " encuestas");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Aun no has registrado la muestra para esta carrera, por favor ve a la generacion de muestra.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ya has registrado la muestra para esta carrera.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Es necesario seleccionar una carrera para conocer la muestra.");
        }

    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
        jPanel8.setBackground(new Color(67, 80, 80));
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        // TODO add your handling code here:
        jPanel8.setBackground(new Color(27, 57, 106));
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        llenarTabla();
        banderafiltrado = false;
        jComboBox1.setSelectedItem(null);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        // TODO add your handling code here:
        jPanel9.setBackground(new Color(67,80,80));
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        // TODO add your handling code here:
        jPanel9.setBackground(new Color(27,57,106));
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        // TODO add your handling code here:
        jPanel10.setBackground(new Color(60,80,80));
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        // TODO add your handling code here:
        jPanel10.setBackground(new Color(27,57,106));
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        if (banderafiltrado) {
            String carrera = jComboBox1.getSelectedItem().toString().trim();
            String rutaPeriodoCarrera = ruta + "/Periodos/" + carpeta + "/" + carrera + "/PeriodoCarrera.properties";
            String iniciado = prop.acceder("iniciado" + clave, rutaPeriodoCarrera);
            if (!iniciado.equals("no")) {
                //necesita area, titulo pantalla, carrera
                opcRecomendaciones obj = new opcRecomendaciones(clave, area, carrera);
                obj.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Aun no has registrado la muestra para esta carrera.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Es necesario seleccionar una carrera para acceder a sus resultados.");
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        // TODO add your handling code here:
        jPanel11.setBackground(new Color(67,80,80));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        // TODO add your handling code here:
        jPanel11.setBackground(new Color(27,57,106));
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        // TODO add your handling code here:
        jPanel12.setBackground(new Color(67,80,80));
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        // TODO add your handling code here:
        jPanel12.setBackground(new Color(27,57,106));
    }//GEN-LAST:event_jLabel13MouseExited

    private void jPanel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel12MouseEntered
    private boolean guardarRespuestas(String carrera, Float muestra) {
        rutaXml = ruta + "Periodos/" + carpeta + "/" + carrera.trim() + "/" + archivo + "Encuestas.xml";
        System.out.println("rutaXML: " + rutaXml);

        String rutaPreguntas = ruta + archivo + ".xml";
        preguntas = xml.loadPreguntasDataFromFile(new File(rutaPreguntas));
        tamPreguntas = preguntas.size();

        if (persistirRespuestas(muestra)) {
            if (xml.saveEncuestasDataToFile(new File(rutaXml), encuestas)) {
                new rojerusan.RSNotifyAnimated("COMPLETADO", "Se han guardado las respuestas correspondientes a " + carrera, 7,
                        RSNotifyAnimated.PositionNotify.BottomRight,
                        RSNotifyAnimated.AnimationNotify.BottomUp,
                        RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                return true;
            } else {
                new rojerusan.RSNotifyAnimated("ERROR!", "Ocurrio un error al almacenar las respuestas de " + carrera, 7,
                        RSNotifyAnimated.PositionNotify.BottomRight,
                        RSNotifyAnimated.AnimationNotify.BottomUp,
                        RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                return false;
            }
        }
        return false;
    }

    private boolean persistirRespuestas(Float muestra) {
        RandomValues random = new RandomValues();
        int limite = Math.round(muestra);
        String aux;
        int renglon, columna;
        ArrayList<Integer> index = random.getRandomList(jTable1.getRowCount(), limite);
        System.out.println("posiciones: " + index);
        int pregunta = 1;
        for (int i = 0; i < index.size(); i++) {
            Encuesta enc = new Encuesta();
            for (int j = 0; j < tamPreguntas; j++) {
                renglon = index.get(i);
                columna = 3 + j;
                aux = (String) jTable1.getValueAt(renglon, columna);
                System.out.println("value of: " + renglon + " " + columna + " is " + aux);
                enc.addRespuesta(new Respuesta(String.valueOf(j), aux));
            }
            comentarios = (pregunta + i) + ".-" + jTable1.getValueAt(index.get(i), 12);
            enc.setComentario(comentarios);
            System.out.println(comentarios);
            if (enc != null) {
                encuestas.add(enc);
            }
            System.out.println("valores " + enc.toString());

        }

        return true;
    }

    private void llenarCarreras() {
        jComboBox1.removeAll();
        for (int i = 0; i < tam; i++) {
            String aux = carreras.get(i).getNombre();
            jComboBox1.addItem(aux);
        }
    }

    private void llenarTabla() {
        if (cellData != null) {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            for (int i = 1; i < cellData.size(); i++) {
                String[] data = (String[]) cellData.get(i);
                modelo.addRow(new Object[]{
                    data[1],
                    data[2],
                    data[3],
                    data[4],
                    data[5],
                    data[6],
                    data[7],
                    data[8],
                    data[9],
                    data[10],
                    data[11],
                    data[12],
                    data[13],});
            }
            jTable1.setModel(modelo);
        } else {
            JOptionPane.showMessageDialog(null, "HUBO UN ERROR AL CARGAR LOS DATOS DEL EXCEL");
        }

    }

    private void filtrar(String carrera) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int cont = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String valor = (String) modelo.getValueAt(i, 1);
            if (!carrera.equals(valor)) {
                modelo.removeRow(i);
                cont++;
            }
        }
        jTable1.setModel(modelo);
        if (cont != 0) {
            filtrar(carrera);
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
            java.util.logging.Logger.getLogger(verRespuestas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verRespuestas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verRespuestas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verRespuestas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verRespuestas("", "", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
