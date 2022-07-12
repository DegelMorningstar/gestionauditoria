/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import controlador.Propiedades;
import controlador.XmlActions;
import java.awt.Color;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Yael_
 */
public class OpcServicio extends javax.swing.JFrame {

    /**
     * Creates new form OpcServicio
     */
    //variables moer ventana
    int xmouse, ymouse;
    Propiedades prop = new Propiedades();
    String ruta = "src/documentos/";
    String carpeta = "";
    boolean banderaEliminar = false;
    File periodo;
    XmlActions xml = new XmlActions();
    public OpcServicio() {
        ImageIcon iconoT = new ImageIcon("src/Archivos/favicon.png");
        this.setIconImage(iconoT.getImage());
        initComponents();
        this.setLocationRelativeTo(null);
        carpeta = prop.acceder("archivoActual", ruta + "config.properties");
        periodo = new File(ruta + "Periodos/" + carpeta + "/Periodo.properties");
        System.out.println(periodo.getAbsolutePath());
        loadValues();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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

        jLabel7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("CONTROL DE SERVICIOS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(200, 200, 200)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(248, 248, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBox1.setBackground(new java.awt.Color(248, 248, 255));
        jCheckBox1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jCheckBox1.setText("COORDINACION DE CARRERAS");
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 360, -1));

        jCheckBox2.setBackground(new java.awt.Color(248, 248, 255));
        jCheckBox2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jCheckBox2.setText("CENTRO DE INFORMACION");
        jPanel2.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 320, -1));

        jCheckBox3.setBackground(new java.awt.Color(248, 248, 255));
        jCheckBox3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jCheckBox3.setText("DE COMPUTO");
        jPanel2.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 200, -1));

        jCheckBox4.setBackground(new java.awt.Color(248, 248, 255));
        jCheckBox4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jCheckBox4.setText("RECURSOS FINANCIEROS");
        jPanel2.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 310, -1));

        jCheckBox8.setBackground(new java.awt.Color(248, 248, 255));
        jCheckBox8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jCheckBox8.setText("RESIDENCIAS PROFESIONALES");
        jPanel2.add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 360, -1));

        jCheckBox9.setBackground(new java.awt.Color(248, 248, 255));
        jCheckBox9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jCheckBox9.setText("SERVICIOS ESCOLARES");
        jPanel2.add(jCheckBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 300, -1));

        jCheckBox10.setBackground(new java.awt.Color(248, 248, 255));
        jCheckBox10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jCheckBox10.setText("SERVICIO SOCIAL");
        jPanel2.add(jCheckBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 240, -1));

        jButton2.setText("GUARDAR");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, -1, -1));

        jPanel5.setBackground(new java.awt.Color(248, 248, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 40, 40));

        jPanel8.setBackground(new java.awt.Color(27, 57, 106));
        jPanel8.setPreferredSize(new java.awt.Dimension(120, 50));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(248, 248, 255));
        jLabel9.setText(" GUARDAR");
        jLabel9.setAlignmentX(0.5F);
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
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void loadValues(){
        String aux;
        aux = prop.acceder("centroInformacionActivo", periodo.getAbsolutePath());
        if(aux.equals("si")){
            jCheckBox2.setSelected(true);
        }
        aux = prop.acceder("coordinacionCarrerasActivo", periodo.getAbsolutePath());
        if(aux.equals("si")){
            jCheckBox1.setSelected(true);
        }
        aux = prop.acceder("recursosFinancierosActivo", periodo.getAbsolutePath());
        if(aux.equals("si")){
            jCheckBox4.setSelected(true);
        }
        aux = prop.acceder("computoActivo", periodo.getAbsolutePath());
        if(aux.equals("si")){
            jCheckBox3.setSelected(true);
        }
        aux = prop.acceder("servicioSocialActivo", periodo.getAbsolutePath());
        if(aux.equals("si")){
            jCheckBox10.setSelected(true);
        }
        aux = prop.acceder("serviciosEscolaresActivo", periodo.getAbsolutePath());
        if(aux.equals("si")){
            jCheckBox9.setSelected(true);
        }
        aux = prop.acceder("residenciaProfesionalActivo", periodo.getAbsolutePath());
        if(aux.equals("si")){
            jCheckBox8.setSelected(true);
        }
    }
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        boolean mensaje = false;
        if(jCheckBox2.isSelected()){
            mensaje = prop.guardar("centroInformacionActivo", "si", periodo.getAbsolutePath());
        }else{
            mensaje = prop.guardar("centroInformacionActivo", "no", periodo.getAbsolutePath());
        }
        if(jCheckBox1.isSelected()){
            mensaje = prop.guardar("coordinacionCarrerasActivo", "si", periodo.getAbsolutePath());
        }else{
            mensaje = prop.guardar("coordinacionCarrerasActivo", "no", periodo.getAbsolutePath());
        }
        if(jCheckBox4.isSelected()){
            mensaje = prop.guardar("recursosFinancierosActivo", "si", periodo.getAbsolutePath());
        }else{
            mensaje = prop.guardar("recursosFinancierosActivo", "no", periodo.getAbsolutePath());
        }
        if(jCheckBox3.isSelected()){
            mensaje = prop.guardar("computoActivo", "si", periodo.getAbsolutePath());
        }else{
            mensaje = prop.guardar("computoActivo", "no", periodo.getAbsolutePath());
        }
        if(jCheckBox10.isSelected()){
            mensaje = prop.guardar("servicioSocialActivo", "si", periodo.getAbsolutePath());
        }else{
            mensaje = prop.guardar("servicioSocialActivo", "no", periodo.getAbsolutePath());
        }
        if(jCheckBox9.isSelected()){
            mensaje = prop.guardar("serviciosEscolaresActivo", "si", periodo.getAbsolutePath());
        }else{
            mensaje = prop.guardar("serviciosEscolaresActivo", "no", periodo.getAbsolutePath());
        }
        if(jCheckBox8.isSelected()){
            mensaje = prop.guardar("residenciaProfesionalActivo", "si", periodo.getAbsolutePath());
        }else{
            mensaje = prop.guardar("residenciaProfesionalActivo", "no", periodo.getAbsolutePath());
        }
        if(mensaje){
            JOptionPane.showMessageDialog(null, "Se ha guardado con exito.");
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        // TODO add your handling code here:
        xmouse = evt.getX();
        ymouse = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xmouse, y - ymouse);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        CAPTURA obj = new CAPTURA();
        obj.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        boolean mensaje = false;
        if(jCheckBox2.isSelected()){
            mensaje = prop.guardar("centroInformacionActivo", "si", periodo.getAbsolutePath());
        }else{
            mensaje = prop.guardar("centroInformacionActivo", "no", periodo.getAbsolutePath());
        }
        if(jCheckBox1.isSelected()){
            mensaje = prop.guardar("coordinacionCarrerasActivo", "si", periodo.getAbsolutePath());
        }else{
            mensaje = prop.guardar("coordinacionCarrerasActivo", "no", periodo.getAbsolutePath());
        }
        if(jCheckBox4.isSelected()){
            mensaje = prop.guardar("recursosFinancierosActivo", "si", periodo.getAbsolutePath());
        }else{
            mensaje = prop.guardar("recursosFinancierosActivo", "no", periodo.getAbsolutePath());
        }
        if(jCheckBox3.isSelected()){
            mensaje = prop.guardar("computoActivo", "si", periodo.getAbsolutePath());
        }else{
            mensaje = prop.guardar("computoActivo", "no", periodo.getAbsolutePath());
        }
        if(jCheckBox10.isSelected()){
            mensaje = prop.guardar("servicioSocialActivo", "si", periodo.getAbsolutePath());
        }else{
            mensaje = prop.guardar("servicioSocialActivo", "no", periodo.getAbsolutePath());
        }
        if(jCheckBox9.isSelected()){
            mensaje = prop.guardar("serviciosEscolaresActivo", "si", periodo.getAbsolutePath());
        }else{
            mensaje = prop.guardar("serviciosEscolaresActivo", "no", periodo.getAbsolutePath());
        }
        if(jCheckBox8.isSelected()){
            mensaje = prop.guardar("residenciaProfesionalActivo", "si", periodo.getAbsolutePath());
        }else{
            mensaje = prop.guardar("residenciaProfesionalActivo", "no", periodo.getAbsolutePath());
        }
        if(mensaje){
            JOptionPane.showMessageDialog(null, "Se ha guardado con exito.");
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
        jPanel8.setBackground(new Color(67,80,80));
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        // TODO add your handling code here:
        jPanel8.setBackground(new Color(27,57,106));
    }//GEN-LAST:event_jLabel9MouseExited

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(OpcServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpcServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpcServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpcServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpcServicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables
}
