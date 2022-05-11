/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Pregunta;
import controlador.Propiedades;
import controlador.XmlActions;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import rojerusan.RSNotifyAnimated;

/**
 *
 * @author Yael_
 */
public class opcPregunta extends javax.swing.JFrame {

    /**
     * Creates new form opcPregunta
     */
    String area;

    Propiedades prop = new Propiedades();
    String ruta = "src/Documentos/ajustesAreas.properties";
    boolean existeResponsable2 = false;
    //ObservableList<Pregunta> datos;
    XmlActions xml = new XmlActions();
    String rutaXml = "src/Documentos/";

    public opcPregunta(String area) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Configuracion de la encuesta");
        this.area = area;
        llenadoCampos();
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 248, 255));

        jButton1.setText("REGRESAR");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Pregunta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("OPCIONES");

        jLabel2.setText("RESPONSABLE DEL AREA");

        jLabel3.setText("NUMERO DE ENCUESTAS");

        jButton2.setText("AGREGAR");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("EDITAR");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("GUARDAR");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jButton5.setText("ELIMINAR");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(jTextField2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1)))
                .addGap(18, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(69, 69, 69)
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(149, 149, 149))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jButton2)
                        .addGap(72, 72, 72)
                        .addComponent(jButton3)
                        .addGap(81, 81, 81)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(99, 99, 99))))
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

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        String nuevoValor = (String) JOptionPane.showInputDialog(null, "Ingresa la nueva pregunta", "Nueva pregunta", JOptionPane.QUESTION_MESSAGE, null, null, "");
        if (nuevoValor != null) {
            modelo.addRow(new Object[]{nuevoValor});
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int columna = jTable1.getSelectedColumn();
        int renglon = jTable1.getSelectedRow();

        String valor = (String) modelo.getValueAt(renglon, columna);
        String nuevoValor = (String) JOptionPane.showInputDialog(null, "Escriba aquí la nueva pregunta", "Editar pregunta", JOptionPane.QUESTION_MESSAGE, null, null, valor);
        if (nuevoValor != null) {
            jTable1.setValueAt(nuevoValor, jTable1.getSelectedRow(), jTable1.getSelectedColumn());
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int seleccion = jTable1.getSelectedRow();
        modelo.removeRow(seleccion);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        if (!jTextField3.getText().equals("") && !jTextField1.equals("")) {
            if (jTextField1.getText().matches("^[0-9]+$") && Integer.parseInt(jTextField1.getText()) > 0) {
                if (existeResponsable2) {
                    if (!jTextField2.getText().equals("")) {
                        int resp = JOptionPane.showConfirmDialog(null, "¿Deseas guardar los cambios?", "GUARDAR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (resp == 0) {
                            List<Pregunta> listaPreguntas = new ArrayList();
                            for (int i = 0; i < jTable1.getRowCount(); i++) {
                                //String valor = String.valueOf(jTable1.getValueAt(i, 0));
                                Pregunta c = new Pregunta();
                                c.setNumero(String.valueOf(jTable1.getValueAt(i, 0)));
                                c.setPreg(String.valueOf(jTable1.getValueAt(i, 1)));
                                listaPreguntas.add(c);
                            }
                            boolean mensaje = false;
                            mensaje = prop.guardar("responsable" + area + "1", jTextField3.getText().trim(), ruta);
                            mensaje = prop.guardar("responsable" + area + "2", jTextField2.getText().trim(), ruta);
                            mensaje = prop.guardar("noEncuestas" + area, jTextField1.getText().trim(), ruta);
                            if (mensaje) {
                                rutaXml += prop.acceder("archivo" + area, ruta) + ".xml";
                                if (xml.savePreguntasDataToFile(new File(rutaXml), listaPreguntas)) {
                                    new rojerusan.RSNotifyAnimated("EXITO!", "Las preguntas registradas y almacenadas sin ningun error.", 7,
                                            RSNotifyAnimated.PositionNotify.BottomRight,
                                            RSNotifyAnimated.AnimationNotify.BottomUp,
                                            RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                                } else {
                                    new rojerusan.RSNotifyAnimated("ERROR!", "Algo salio mal al almacenar las preguntas.", 7,
                                            RSNotifyAnimated.PositionNotify.BottomRight,
                                            RSNotifyAnimated.AnimationNotify.BottomUp,
                                            RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                                }
                            } else {
                                new rojerusan.RSNotifyAnimated("ERROR!", "Algo salio mal al almacenar las preguntas.", 7,
                                        RSNotifyAnimated.PositionNotify.BottomRight,
                                        RSNotifyAnimated.AnimationNotify.BottomUp,
                                        RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                            }

                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "No dejes campos vacios");
                    }

                } else {
                    int resp = JOptionPane.showConfirmDialog(null, "¿Deseas guardar los cambios?", "GUARDAR", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (resp == 0) {
                        List<Pregunta> listaPreguntas = new ArrayList();
                        for (int i = 0; i < jTable1.getRowCount(); i++) {
                            //String valor = String.valueOf(jTable1.getValueAt(i, 0));
                            Pregunta c = new Pregunta();
                            c.setNumero(String.valueOf(jTable1.getValueAt(i, 0)));
                            c.setPreg(String.valueOf(jTable1.getValueAt(i, 1)));
                            listaPreguntas.add(c);
                        }
                        boolean mensaje = false;
                        mensaje = prop.guardar("responsable" + area + "1", jTextField3.getText().trim(), ruta);
                        mensaje = prop.guardar("noEncuestas" + area, jTextField1.getText().trim(), ruta);
                        if (mensaje) {
                            rutaXml += prop.acceder("archivo" + area, ruta) + ".xml";
                            if (xml.savePreguntasDataToFile(new File(rutaXml), listaPreguntas)) {
                                new rojerusan.RSNotifyAnimated("EXITO!", "Las preguntas registradas y almacenadas sin ningun error.", 7,
                                        RSNotifyAnimated.PositionNotify.BottomRight,
                                        RSNotifyAnimated.AnimationNotify.BottomUp,
                                        RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
                            } else {
                                new rojerusan.RSNotifyAnimated("ERROR!", "Algo salio mal al almacenar las preguntas.", 7,
                                        RSNotifyAnimated.PositionNotify.BottomRight,
                                        RSNotifyAnimated.AnimationNotify.BottomUp,
                                        RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                            }
                        } else {
                            new rojerusan.RSNotifyAnimated("ERROR!", "Algo salio mal al almacenar las preguntas.", 7,
                                    RSNotifyAnimated.PositionNotify.BottomRight,
                                    RSNotifyAnimated.AnimationNotify.BottomUp,
                                    RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
                        }

                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "El numero de encuestas no es valido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No dejes campos vacios");
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(null, "¿Deseas salir?\nSe perderan todos los cambios sin guardar.", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resp == 0) {
            CAPTURA obj = new CAPTURA();
            obj.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1MouseClicked

    public void llenadoCampos() {
        jTextField3.setText(prop.acceder("responsable" + area + "1", ruta));
        jTextField1.setText(prop.acceder("noEncuestas" + area, ruta));
        if (prop.acceder("noresponsables" + area, ruta).equalsIgnoreCase("1")) {
            jTextField2.setVisible(false);
        } else {
            jTextField2.setText(prop.acceder("responsable" + area + "2", ruta));
            existeResponsable2 = true;
        }
        rutaXml += prop.acceder("archivo" + area, ruta) + ".xml";
        List<Pregunta> preguntas = new ArrayList();
        preguntas = xml.loadPreguntasDataFromFile(new File(rutaXml));
        if (preguntas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No fue posible cargar las preguntas");
        } else {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            for (int i = 0; i < preguntas.size(); i++) {
                modelo.addRow(new Object[]{preguntas.get(i).getNumero(), preguntas.get(i).getPreg()});
            }
            jTable1.setModel(modelo);
            jTable1.setFont(new Font("Arial", Font.BOLD, 12));
            jTable1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
            jTable1.setRowHeight(30);
            resizeColumnWidth(jTable1);
        }
    }

    private void resizeColumnWidth(JTable table) {
        //Se obtiene el modelo de la columna
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        columnModel.getColumn(1).setPreferredWidth(500);

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
            java.util.logging.Logger.getLogger(opcPregunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(opcPregunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(opcPregunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(opcPregunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new opcPregunta("Centro").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
