package Vista;

import Modelo.Carrera;
import controlador.LectorExcel;
import controlador.Propiedades;
import controlador.RandomValues;
import controlador.XmlActions;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class verRespuestas extends javax.swing.JFrame {

    boolean banderafiltrado = false;
    String carpeta = "";

    LectorExcel Lector = new LectorExcel();
    List cellData = new ArrayList();
    private String area;
    private String clave;

    List<Carrera> carreras = new ArrayList();
    int tam = 0;
    String rutaCarreras = "src/Documentos/carreras.xml";
    String rutaMuestra = "src/Documentos/muestra.properties";
    String ruta = "src/documentos/";
    File periodo;

    XmlActions xml = new XmlActions();
    Propiedades prop = new Propiedades();

    public verRespuestas(String name, String area, String clave) {
        initComponents();
        this.area = area;
        this.clave = clave;

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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 248, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("AREA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 950, 430));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona una carrera" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 440, 40));

        jButton1.setText("COMENTARIOS");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 300, 50));

        jButton2.setText("AGREGAR RECOMENDACIOENS");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 660, 300, 50));

        jButton3.setText("GUARDAR");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 660, 290, 50));

        jButton4.setText("APLICAR MUESTRA");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 550, 280, 40));

        jButton5.setText("FILTRAR");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 550, 180, 40));

        jButton6.setText("REGRESAR");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, -1, -1));

        jButton7.setText("LIMPIAR TABLA");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, -1, -1));

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

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        if (!banderafiltrado) {
            String carrera = jComboBox1.getSelectedItem().toString();
            if (!carrera.equalsIgnoreCase("Selecciona una carrera")) {
                banderafiltrado = true;
                filtrar(carrera);
            } else {
                JOptionPane.showMessageDialog(null, "Aun no seleccionas ninguna carrera");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Para filtrar una carrera nueva necesitas limpiar la tabla primero");
        }

    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        llenarTabla();
        banderafiltrado = false;
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        CAPTURA obj = new CAPTURA();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        if (banderafiltrado) {
            String rutaPeriodoCarrera = ruta + "/Periodos/" + carpeta + "/" + jComboBox1.getSelectedItem().toString() + "/PeriodoCarrera.properties";
            String iniciado = prop.acceder("iniciado" + clave, rutaPeriodoCarrera);
            if (iniciado.equals("no")) {
                String muestra = prop.acceder("muestra" + jComboBox1.getSelectedItem().toString().trim(), rutaMuestra);
                if (muestra != null) {
                    float rows = jTable1.getRowCount();
                    float m = Float.parseFloat(muestra);
                    if (rows >= m) {
                        int resp = JOptionPane.showConfirmDialog(null, "La muestra cumple con los requisitos\n¿Deseas aplicar la muestra?", jComboBox1.getSelectedItem().toString(), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (resp == 0) {
                            if (prop.guardar("iniciado" + clave, "si", rutaPeriodoCarrera)) {
                                guardarRespuestas(m);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La muestra de la carrera " + jComboBox1.getSelectedItem().toString().trim() + " no cumple con los requisitos\n "
                                + "La muestra es: " + m + "\n"
                                + "Actualmente la carrera tiene: " + rows + "\n"
                                + "Es necesario capturar " + (m - rows) + " encuestas");
                    }
                    JOptionPane.showMessageDialog(null, "La muestra de la carrera " + jComboBox1.getSelectedItem().toString().trim() + " es: " + muestra);

                } else {
                    JOptionPane.showMessageDialog(null, "Aun no has registrado la muestra para esta carrera, por favor ve a la generacion de muestra.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ya has registrado la muestra para esta carrera.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Es necesario seleccionar y filtrar una carrera para conocer la muestra.");
        }


    }//GEN-LAST:event_jButton4MouseClicked
    private void guardarRespuestas(float m) {
        int limit = jTable1.getRowCount();
        int aux = 0;
        RandomValues obj = new RandomValues();
        ArrayList<Integer> index = new ArrayList<>();
        index = obj.getRandomList(limit);
        //while(aux<m){  
        //}
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    
}
