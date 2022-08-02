package Vista;

import Modelo.Carrera;
import Modelo.FormatoFechas;
import controlador.Propiedades;
import controlador.XmlActions;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PERIODO extends javax.swing.JFrame {

    int xmouse, ymouse;
    Propiedades prop = new Propiedades();
    String ruta = "src/Documentos/config.properties";
    String rutaCarpeta = "src/Documentos/Periodos/";
    List<Carrera> carreras = new ArrayList();
    int tam = 0;

    public PERIODO() {
        initComponents();
        ordenInterfaz();
        this.setLocationRelativeTo(null);
        
        ImageIcon iconoT = new ImageIcon("src/Archivos/favicon.png");
        this.setIconImage(iconoT.getImage());
        
        XmlActions xml = new XmlActions();
        carreras = xml.loadCarrerasDataFromFile(new File("src/Documentos/carreras.xml"));
        tam = carreras.size();
        
    }

    private void ordenInterfaz() {
        if (prop.acceder("actual", ruta).equals("si")) {
            nueva.setVisible(false);
            //continuar.setVisible(true);
            chooserFecha1.setVisible(false);
            chooserFecha2.setVisible(false);
            btnGenera.setVisible(false);
            lblSelecciona.setVisible(false);
            //btnEliminar.setVisible(true);
            lblInicio.setVisible(false);
            lblFin.setVisible(false);
            //paneles agragados como btns
            continuar.setVisible(false);
            btnEliminar.setVisible(false);
            jPanel7.setVisible(false);
            jPanel9.setVisible(false);
        } else {
            nueva.setVisible(true);
            continuar.setVisible(false);
            chooserFecha1.setVisible(false);
            chooserFecha2.setVisible(false);
            btnGenera.setVisible(false);
            lblSelecciona.setVisible(false);
            btnEliminar.setVisible(false);
            lblInicio.setVisible(false);
            lblFin.setVisible(false);
            //paneles agregados como btns
            jPanel8.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nueva = new javax.swing.JButton();
        continuar = new javax.swing.JButton();
        btnGenera = new javax.swing.JButton();
        lblSelecciona = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        lblInicio = new javax.swing.JLabel();
        lblFin = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        chooserFecha1 = new rojeru_san.componentes.RSDateChooser();
        chooserFecha2 = new rojeru_san.componentes.RSDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 53, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoITZ.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(248, 248, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(248, 248, 255));
        jLabel2.setText("MENU PRINCIPAL");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(248, 248, 255));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(248, 248, 255));
        jLabel6.setText("GENERA MUESTRA");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(248, 248, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(103, 123, 134));
        jLabel7.setText("CAPTURA DE DATOS");

        jLabel8.setBackground(new java.awt.Color(248, 248, 255));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(248, 248, 255));
        jLabel8.setText("AJUSTES GENERALES");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(248, 248, 255));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(248, 248, 255));
        jLabel9.setText("REPORTES FINALES");
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

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BtnUno.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BtnConf.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BtnGenerar.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BtnReportes.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(58, 58, 58))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel9)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel8))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(29, 29, 29)
                                .addComponent(jLabel6))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel9))
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 600));

        jPanel2.setBackground(new java.awt.Color(248, 248, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info2.png"))); // NOI18N

        nueva.setText("Nueva Captura");
        nueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaActionPerformed(evt);
            }
        });

        continuar.setBackground(new java.awt.Color(27, 57, 106));
        continuar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        continuar.setText("Continuar Captura");
        continuar.setBorderPainted(false);
        continuar.setOpaque(false);
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarActionPerformed(evt);
            }
        });

        btnGenera.setText("Generar Captura");
        btnGenera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneraActionPerformed(evt);
            }
        });

        lblSelecciona.setFont(new java.awt.Font("Arial", 3, 20)); // NOI18N
        lblSelecciona.setForeground(new java.awt.Color(27, 57, 106));
        lblSelecciona.setText("Selecciona el Periodo");

        btnEliminar.setText("Eliminar Periodo");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblInicio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblInicio.setForeground(new java.awt.Color(27, 57, 106));
        lblInicio.setText("INICIO");

        lblFin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblFin.setForeground(new java.awt.Color(27, 57, 106));
        lblFin.setText("FIN");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(27, 57, 106));
        jLabel14.setText("PERIODO");

        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BtnXdark.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabel4)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabel4)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BtnMinDark.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(27, 57, 106));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(248, 248, 255));
        jLabel18.setText("ELIMINAR PERIODO");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(18, 18, 18))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(27, 57, 106));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(248, 248, 255));
        jLabel17.setText("NUEVA CAPTURA");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(35, 35, 35))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(27, 57, 106));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(248, 248, 255));
        jLabel16.setText("CONTINUAR CAPTURA");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(18, 18, 18))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(27, 57, 106));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(248, 248, 255));
        jLabel19.setText("GENERAR CAPTURA");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(18, 18, 18))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(99, 99, 99)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnGenera, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nueva)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(25, 25, 25))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(continuar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(lblInicio))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(chooserFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(chooserFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lblSelecciona, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(lblFin)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSelecciona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chooserFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chooserFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(continuar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGenera)
                            .addComponent(btnEliminar)
                            .addComponent(nueva))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 520, 600));

        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel5MouseDragged(evt);
            }
        });
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        try {
            Runtime.getRuntime().exec("C:\\Windows\\System32\\cmd.exe /K start http://www.itzacatepec.edu.mx/");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido ingresar a la página");
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        AJUSTES obj = new AJUSTES();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    
    
    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        REPORTES obj = new REPORTES();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    
    
    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        REPORTES obj = new REPORTES();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void nuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaActionPerformed
        // TODO add your handling code here:
        lblSelecciona.setVisible(true);
        chooserFecha1.setVisible(true);
        chooserFecha2.setVisible(true);
        btnGenera.setVisible(true);
        lblInicio.setVisible(true);
        lblFin.setVisible(true);

    }//GEN-LAST:event_nuevaActionPerformed

    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
        // TODO add your handling code here:
        CAPTURA obj = new CAPTURA();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_continuarActionPerformed

    private void btnGeneraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneraActionPerformed
        Date fecha1 = null;
        Date fecha2 = null;
        if (chooserFecha1.getDatoFecha() == null) {
            JOptionPane.showMessageDialog(this, "Selecciona una fecha de inicio", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (chooserFecha2.getDatoFecha() == null) {
            JOptionPane.showMessageDialog(this, "Selecciona una fecha de fin", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            fecha1 = chooserFecha1.getDatoFecha();
            fecha2 = chooserFecha2.getDatoFecha();
        }
        //guardado
        if (fecha1 != null && fecha2 != null) {
            System.out.println("PASO");
            Date inicio = fecha1;
            Date fin = fecha2;
            System.out.println(inicio);
            System.out.println(fin);
            if (inicio.before(fin)) {
                if (FormatoFechas.compruebaPeriodo(inicio, fin)) {
                    //Confirmacion.
                    //MEJORAR EL DIALOGO DE CONFIRMACION
                    String r = JOptionPane.showInputDialog("¿Quieres generar el periodo de captura de " + FormatoFechas.dateFormatToString(inicio) + " al " + FormatoFechas.dateFormatToString(fin) + "?");
                    //if (alert.showAndWait().get() == ButtonType.OK) {
                    if (r.equals("s")) {

                        String nombreCarpeta = FormatoFechas.dateFormatToString(inicio) + "_" + FormatoFechas.dateFormatToString(fin);
                        File folder = new File("src/Documentos/Periodos/", nombreCarpeta);
                        if (folder.exists()) {
                            nombreCarpeta += "(1)";
                            folder = new File("src/Documentos/Periodos/", nombreCarpeta);
                            folder.mkdir();
                        } else {
                            folder.mkdir();
                        }
                        //UNA VEZ CREADA LA CARPETA PADRE, CREAMOS CARPETA POR CARRERA EXISTENTE
                        String auxiliarNombre = nombreCarpeta;
                        nombreCarpeta = "src/Documentos/Periodos/" + nombreCarpeta;
                        for (int i = 0; i < tam; i++) {
                            System.out.println("el tamaño de las carreras son: " + carreras.get(i).getNombre());
                            String nombreCarrera = carreras.get(i).getNombre();
                            File Cfolder = new File(nombreCarpeta + "/", nombreCarrera);
                            if (Cfolder.exists()) {
                                nombreCarrera += "(1)";
                                Cfolder = new File(nombreCarpeta + "/", nombreCarrera);
                                Cfolder.mkdir();
                            } else {
                                Cfolder.mkdir();
                            }
                        }

                        File informacionPeriodo = new File(nombreCarpeta, "Periodo.properties");
                        System.out.println(nombreCarpeta);

                        try {

                            if (informacionPeriodo.createNewFile()) {

                                prop.guardar("nombreCarpeta", auxiliarNombre, informacionPeriodo.getAbsolutePath());
                                prop.guardar("fechaInicio", FormatoFechas.dateFormatToString(inicio), informacionPeriodo.getAbsolutePath());
                                prop.guardar("fechaFin", FormatoFechas.dateFormatToString(fin), informacionPeriodo.getAbsolutePath());
                                
                                prop.guardar("centroDeInformacionExcel", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("CentroExcelTerminado", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("centroInformacionActivo", "si", informacionPeriodo.getAbsolutePath());
                                
                                prop.guardar("coordinacionDeCarrerasExcel", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("CoordinacionExcelTerminado", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("coordinacionCarrerasActivo", "si", informacionPeriodo.getAbsolutePath());
                                
                                prop.guardar("recursosFinancierosExcel", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("FinancierosExcelTerminado", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("recursosFinancierosActivo", "si", informacionPeriodo.getAbsolutePath());
                                
                                prop.guardar("computoExcel", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("ComputoExcelTerminado", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("computoActivo", "si", informacionPeriodo.getAbsolutePath());
                                
                                prop.guardar("servicioSocialExcel", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("SocialExcelTerminado", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("servicioSocialActivo", "si", informacionPeriodo.getAbsolutePath());
                                
                                prop.guardar("serviciosEscolaresExcel", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("EscolaresExcelTerminado", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("serviciosEscolaresActivo", "si", informacionPeriodo.getAbsolutePath());
                                
                                prop.guardar("residenciasProfesionalesExcel", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("ResidenciasExcelTerminado", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("residenciaProfesionalActivo", "si", informacionPeriodo.getAbsolutePath());
                                //CREAMOS LOS PROPIETIES PARA CADA CARRERA, PRACTICAMENTE SON FLAGS QUE INDICAN SI YA ESTAN LLENADAS LAS ENCUESTAS
                                File informacionCarrera = null;
                                for (int i = 0; i < tam; i++) {
                                    String aux = nombreCarpeta + "/" + carreras.get(i).getNombre();
                                    System.out.println(aux);
                                    
                                    informacionCarrera = new File(aux, "PeriodoCarrera.properties");
                                    informacionCarrera.createNewFile();
                                    //llenamos los propieties
                                    prop.guardar("iniciadoCentro", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("encuestasLlenadasCentro", "0", informacionCarrera.getAbsolutePath());
                                    prop.guardar("recomendacionesCapturadasCentro", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("procesosTerminadosCentro", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("comparacionCentro", "sincomparacion", informacionCarrera.getAbsolutePath());
                                    prop.guardar("activoCentro", "si", informacionCarrera.getAbsolutePath());
                                    
                                    prop.guardar("iniciadoCoordinacion", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("encuestasLlenadasCoordinacion", "0", informacionCarrera.getAbsolutePath());
                                    prop.guardar("recomendacionesCapturadasCoordinacion", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("procesosTerminadosCoordinacion", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("comparacionCoordinacion", "sincomparacion", informacionCarrera.getAbsolutePath());
                                    prop.guardar("activoCoordinacion", "si", informacionCarrera.getAbsolutePath());
                                    
                                    prop.guardar("iniciadoFinancieros", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("encuestasLlenadasFinancieros", "0", informacionCarrera.getAbsolutePath());
                                    prop.guardar("recomendacionesCapturadasFinancieros", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("procesosTerminadosFinancieros", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("comparacionFinancieros", "sincomparacion", informacionCarrera.getAbsolutePath());
                                    prop.guardar("activoFinancieros", "si", informacionCarrera.getAbsolutePath());
                                    
                                    prop.guardar("iniciadoComputo", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("encuestasLlenadasComputo", "0", informacionCarrera.getAbsolutePath());
                                    prop.guardar("recomendacionesCapturadasComputo", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("procesosTerminadosComputo", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("comparacionComputo", "sincomparacion", informacionCarrera.getAbsolutePath());
                                    prop.guardar("activoComputo", "si", informacionCarrera.getAbsolutePath());
                                    
                                    prop.guardar("iniciadoSocial", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("encuestasLlenadasSocial", "0", informacionCarrera.getAbsolutePath());
                                    prop.guardar("recomendacionesCapturadasSocial", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("procesosTerminadosSocial", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("comparacionSocial", "sincomparacion", informacionCarrera.getAbsolutePath());
                                    prop.guardar("activoSocial", "si", informacionCarrera.getAbsolutePath());
                                    
                                    prop.guardar("iniciadoEscolares", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("encuestasLlenadasEscolares", "0", informacionCarrera.getAbsolutePath());
                                    prop.guardar("recomendacionesCapturadasEscolares", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("procesosTerminadosEscolares", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("comparacionEscolares", "sincomparacion", informacionCarrera.getAbsolutePath());
                                    prop.guardar("activoEscolares", "si", informacionCarrera.getAbsolutePath());
                                    
                                    prop.guardar("iniciadoResidencias", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("encuestasLlenadasResidencias", "0", informacionCarrera.getAbsolutePath());
                                    prop.guardar("recomendacionesCapturadasResidencias", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("procesosTerminadosResidencias", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("comparacionResidencias", "sincomparacion", informacionCarrera.getAbsolutePath());
                                    prop.guardar("activoResidencias", "si", informacionCarrera.getAbsolutePath());
                                }

                                //guardar configuracion de que se inicio un nuevo registro de encuestas
                                prop.guardar("actual", "si", ruta);
                                prop.guardar("archivoAnterior", prop.acceder("archivoActual", ruta), ruta);
                                prop.guardar("archivoActual", auxiliarNombre, ruta);
                                //encuestas, generar cada una en las carpetas de carrera para almacenar los resultados de encuestas

                                File encuestasCentro = null;
                                File encuestasCoordinacion = null;
                                File encuestasFinancieros = null;
                                File encuestasComputo = null;
                                File encuestasSocial = null;
                                File encuestasEscolares = null;
                                File encuestasResidencias = null;
                                int i = 0;
                                do {
                                    String aux = nombreCarpeta + "/" + carreras.get(i).getNombre();
                                    System.out.println(aux);
                                    encuestasCentro = new File(aux, "centroInformacionEncuestas.xml");
                                    encuestasCentro.createNewFile();
                                    encuestasCoordinacion = new File(aux, "coordinacionCarrerasEncuestas.xml");
                                    encuestasCoordinacion.createNewFile();
                                    encuestasFinancieros = new File(aux, "recursosFinancierosEncuestas.xml");
                                    encuestasFinancieros.createNewFile();
                                    encuestasComputo = new File(aux, "centroComputoEncuestas.xml");
                                    encuestasComputo.createNewFile();
                                    encuestasSocial = new File(aux, "servicioSocialEncuestas.xml");
                                    encuestasSocial.createNewFile();
                                    encuestasEscolares = new File(aux, "serviciosEscolaresEncuestas.xml");
                                    encuestasEscolares.createNewFile();
                                    encuestasResidencias = new File(aux, "residenciasProfesionalesEncuestas.xml");
                                    encuestasResidencias.createNewFile();
                                    i++;
                                } while (i < tam);
                                //si se crea
                                if (encuestasCentro.exists() && encuestasComputo.exists()
                                        && encuestasCoordinacion.exists() && encuestasEscolares.exists()
                                        && encuestasFinancieros.exists() && encuestasResidencias.exists()
                                        && encuestasSocial.exists()) {
                                    //SI SE CREAN TODOS LOS ARCHIVOS ABRE INTERFAZ DE CAPTURA.
                                    CAPTURA obj = new CAPTURA();
                                    obj.setVisible(true);
                                    this.dispose();
                                    System.out.println("se crearon con exito, archivos y ahora deberia mostrar capturaForm");
                                } else {
                                    //no se crearon los archivos
                                    funcionEliminarCarpeta(new File(nombreCarpeta));
                                    System.out.println("no se crearon los archivos");
                                }
                            } else {
                                //no se creo el periodo
                                System.out.println("no se creo el peridoo");
                            }
                        } catch (IOException ex) {
                            System.out.println("No se creo archivo");
                        }
                    }
                } else {
                    //el periodo excede el rango
                    System.out.println("El periodo de fechas es mayor a 6 meses y no es posible.");
                }
            } else {
                //La fecha FIN es mayor a la fecha INICIO
                System.out.println("Las fechas estan invertidas");
            }

        } else {
            //no seleccionaste fechhas
            System.out.println("No se han seleccionado fechas");
        }

    }//GEN-LAST:event_btnGeneraActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String rutaCarpeta = this.rutaCarpeta + prop.acceder("archivoActual", ruta);
        System.out.println(rutaCarpeta);
        String inicioPeriodo = prop.acceder("fechaInicio", rutaCarpeta + "/Periodo.properties");
        String finalPeriodo = prop.acceder("fechaFin", rutaCarpeta + "/Periodo.properties");
        System.out.println(inicioPeriodo);
        System.out.println(finalPeriodo);
        //CONFIRMACION DE ELIMINACION
        String r = JOptionPane.showInputDialog("estas seguro de eliminar el periodo?");
        if (r.equals("s")) {
            //introduce contraseña para eliminar
            String password = JOptionPane.showInputDialog("ingrese su contraseña pa confirmar");
            if (!password.equals("")) {
                //System.out.println("si se elimina: " + result.get());
                System.out.println(prop.acceder("acceso", ruta));
                if (prop.acceder("acceso", ruta).equals(password)) {
                    prop.guardar("actual", "no", ruta);
                    prop.guardar("archivoActual", prop.acceder("archivoAnterior", ruta), ruta);
                    funcionEliminarCarpeta(new File(rutaCarpeta));
                    System.out.println("se elimino equisde");
                    ordenInterfaz();
                } else {
                    System.out.println("contraseña incorrecta");
                }

            } else {
                System.out.println("no hay nada");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        MENU obj = new MENU();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        AJUSTES obj= new AJUSTES();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        MUESTRA obj = new MUESTRA();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    
    
    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        MUESTRA obj = new MUESTRA();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        // TODO add your handling code here:
         jLabel8.setForeground(new Color(248, 248, 255 ));
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        // TODO add your handling code here:
        jLabel8.setForeground(new Color(103,123,134));
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // TODO add your handling code here:
        jLabel6.setForeground(new Color(103,123,134));
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        // TODO add your handling code here:
        jLabel6.setForeground(new Color(248,248,255));
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
        jLabel9.setForeground(new Color(103,123,134));
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        // TODO add your handling code here:
        jLabel9.setForeground(new Color(248,248,255));
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
        jPanel3.setBackground(new Color(248, 248, 255));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        jPanel3.setBackground(Color.red);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        // TODO add your handling code here:
        jPanel4.setBackground(new Color(248, 248, 255));
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        // TODO add your handling code here:
        jPanel4.setBackground(Color.red);
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        // TODO add your handling code here:
        jPanel6.setBackground(new Color(67, 80, 88 ));
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        // TODO add your handling code here:
        jPanel6.setBackground(new Color(27, 57, 106));
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        CAPTURA obj = new CAPTURA();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        lblSelecciona.setVisible(true);
        chooserFecha1.setVisible(true);
        chooserFecha2.setVisible(true);
        btnGenera.setVisible(true);
        lblInicio.setVisible(true);
        lblFin.setVisible(true);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        // TODO add your handling code here:
        jPanel7.setBackground(new Color(67, 80, 88 ));
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        // TODO add your handling code here:
        jPanel7.setBackground(new Color(27, 57, 106));
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
        String rutaCarpeta = this.rutaCarpeta + prop.acceder("archivoActual", ruta);
        System.out.println(rutaCarpeta);
        String inicioPeriodo = prop.acceder("fechaInicio", rutaCarpeta + "/Periodo.properties");
        String finalPeriodo = prop.acceder("fechaFin", rutaCarpeta + "/Periodo.properties");
        System.out.println(inicioPeriodo);
        System.out.println(finalPeriodo);
        //wea nueva eliminar
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar el periodo?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resp == 0) {
            String password = JOptionPane.showInputDialog("ingrese su contraseña pa confirmar");
            if (!password.equals("")) {
                //System.out.println("si se elimina: " + result.get());
                System.out.println(prop.acceder("acceso", ruta));
                if (prop.acceder("acceso", ruta).equals(password)) {
                    prop.guardar("actual", "no", ruta);
                    prop.guardar("archivoActual", prop.acceder("archivoAnterior", ruta), ruta);
                    funcionEliminarCarpeta(new File(rutaCarpeta));
                    System.out.println("se elimino equisde");
                    ordenInterfaz();
                } else {
                    System.out.println("contraseña incorrecta");
                }

            } else {
                System.out.println("no hay nada");
            }
        }
        
        /*
        String r = JOptionPane.showInputDialog("estas seguro de eliminar el periodo?");
        if (r.equals("s")) {
            //introduce contraseña para eliminar
            String password = JOptionPane.showInputDialog("ingrese su contraseña pa confirmar");
            if (!password.equals("")) {
                //System.out.println("si se elimina: " + result.get());
                System.out.println(prop.acceder("acceso", ruta));
                if (prop.acceder("acceso", ruta).equals(password)) {
                    prop.guardar("actual", "no", ruta);
                    prop.guardar("archivoActual", prop.acceder("archivoAnterior", ruta), ruta);
                    funcionEliminarCarpeta(new File(rutaCarpeta));
                    System.out.println("se elimino equisde");
                    ordenInterfaz();
                } else {
                    System.out.println("contraseña incorrecta");
                }

            } else {
                System.out.println("no hay nada");
            }
        }*/
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        // TODO add your handling code here:
        jPanel8.setBackground(new Color(67, 80, 88 ));
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        // TODO add your handling code here:
        setBackground(new Color(27,57,106));
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
        Date fecha1 = null;
        Date fecha2 = null;
        if (chooserFecha1.getDatoFecha() == null) {
            JOptionPane.showMessageDialog(this, "Selecciona una fecha de inicio", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (chooserFecha2.getDatoFecha() == null) {
            JOptionPane.showMessageDialog(this, "Selecciona una fecha de fin", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            fecha1 = chooserFecha1.getDatoFecha();
            fecha2 = chooserFecha2.getDatoFecha();
        }
        //guardado
        if (fecha1 != null && fecha2 != null) {
            System.out.println("PASO");
            Date inicio = fecha1;
            Date fin = fecha2;
            System.out.println(inicio);
            System.out.println(fin);
            if (inicio.before(fin)) {
                if (FormatoFechas.compruebaPeriodo(inicio, fin)) {
                    //Confirmacion.
                    //MEJORAR EL DIALOGO DE CONFIRMACION
                    String r = JOptionPane.showInputDialog("¿Quieres generar el periodo de captura de " + FormatoFechas.dateFormatToString(inicio) + " al " + FormatoFechas.dateFormatToString(fin) + "?");
                    //if (alert.showAndWait().get() == ButtonType.OK) {
                    if (r.equals("s")) {

                        String nombreCarpeta = FormatoFechas.dateFormatToString(inicio) + "_" + FormatoFechas.dateFormatToString(fin);
                        File folder = new File("src/Documentos/Periodos/", nombreCarpeta);
                        if (folder.exists()) {
                            nombreCarpeta += "(1)";
                            folder = new File("src/Documentos/Periodos/", nombreCarpeta);
                            folder.mkdir();
                        } else {
                            folder.mkdir();
                        }
                        //UNA VEZ CREADA LA CARPETA PADRE, CREAMOS CARPETA POR CARRERA EXISTENTE
                        String auxiliarNombre = nombreCarpeta;
                        nombreCarpeta = "src/Documentos/Periodos/" + nombreCarpeta;
                        for (int i = 0; i < tam; i++) {
                            System.out.println("el tamaño de las carreras son: " + carreras.get(i).getNombre());
                            String nombreCarrera = carreras.get(i).getNombre();
                            File Cfolder = new File(nombreCarpeta + "/", nombreCarrera);
                            if (Cfolder.exists()) {
                                nombreCarrera += "(1)";
                                Cfolder = new File(nombreCarpeta + "/", nombreCarrera);
                                Cfolder.mkdir();
                            } else {
                                Cfolder.mkdir();
                            }
                        }

                        File informacionPeriodo = new File(nombreCarpeta, "Periodo.properties");
                        System.out.println(nombreCarpeta);

                        try {

                            if (informacionPeriodo.createNewFile()) {

                                prop.guardar("nombreCarpeta", auxiliarNombre, informacionPeriodo.getAbsolutePath());
                                prop.guardar("fechaInicio", FormatoFechas.dateFormatToString(inicio), informacionPeriodo.getAbsolutePath());
                                prop.guardar("fechaFin", FormatoFechas.dateFormatToString(fin), informacionPeriodo.getAbsolutePath());
                                
                                prop.guardar("centroDeInformacionExcel", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("centroDeInformacionExcelTerminado", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("centroInformacionActivo", "si", informacionPeriodo.getAbsolutePath());
                                
                                prop.guardar("coordinacionDeCarrerasExcel", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("coordinacionDeCarrerasExcelTerminado", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("coordinacionCarrerasActivo", "si", informacionPeriodo.getAbsolutePath());
                                
                                prop.guardar("recursosFinancierosExcel", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("recursosFinancierosExcelTerminado", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("recursosFinancierosActivo", "si", informacionPeriodo.getAbsolutePath());
                                
                                prop.guardar("computoExcel", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("computoExcelTerminado", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("computoActivo", "si", informacionPeriodo.getAbsolutePath());
                                
                                prop.guardar("servicioSocialExcel", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("servicioSocialExcelTerminado", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("servicioSocialActivo", "si", informacionPeriodo.getAbsolutePath());
                                
                                prop.guardar("serviciosEscolaresExcel", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("serviciosEscolaresExcelTerminado", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("serviciosEscolaresActivo", "si", informacionPeriodo.getAbsolutePath());
                                
                                prop.guardar("residenciasProfesionalesExcel", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("residenciasProfesionalesExcelTerminado", "no", informacionPeriodo.getAbsolutePath());
                                prop.guardar("residenciaProfesionalActivo", "si", informacionPeriodo.getAbsolutePath());
                                //CREAMOS LOS PROPIETIES PARA CADA CARRERA, PRACTICAMENTE SON FLAGS QUE INDICAN SI YA ESTAN LLENADAS LAS ENCUESTAS
                                File informacionCarrera = null;
                                for (int i = 0; i < tam; i++) {
                                    String aux = nombreCarpeta + "/" + carreras.get(i).getNombre();
                                    System.out.println(aux);
                                    
                                    informacionCarrera = new File(aux, "PeriodoCarrera.properties");
                                    informacionCarrera.createNewFile();
                                    //llenamos los propieties
                                    prop.guardar("iniciadoCentro", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("encuestasLlenadasCentro", "0", informacionCarrera.getAbsolutePath());
                                    prop.guardar("recomendacionesCapturadasCentro", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("procesosTerminadosCentro", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("comparacionCentro", "sincomparacion", informacionCarrera.getAbsolutePath());
                                    prop.guardar("activoCentro", "si", informacionCarrera.getAbsolutePath());
                                    
                                    prop.guardar("iniciadoCoordinacion", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("encuestasLlenadasCoordinacion", "0", informacionCarrera.getAbsolutePath());
                                    prop.guardar("recomendacionesCapturadasCoordinacion", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("procesosTerminadosCoordinacion", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("comparacionCoordinacion", "sincomparacion", informacionCarrera.getAbsolutePath());
                                    prop.guardar("activoCoordinacion", "si", informacionCarrera.getAbsolutePath());
                                    
                                    prop.guardar("iniciadoFinancieros", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("encuestasLlenadasFinancieros", "0", informacionCarrera.getAbsolutePath());
                                    prop.guardar("recomendacionesCapturadasFinancieros", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("procesosTerminadosFinancieros", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("comparacionFinancieros", "sincomparacion", informacionCarrera.getAbsolutePath());
                                    prop.guardar("activoFinancieros", "si", informacionCarrera.getAbsolutePath());
                                    
                                    prop.guardar("iniciadoComputo", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("encuestasLlenadasComputo", "0", informacionCarrera.getAbsolutePath());
                                    prop.guardar("recomendacionesCapturadasComputo", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("procesosTerminadosComputo", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("comparacionComputo", "sincomparacion", informacionCarrera.getAbsolutePath());
                                    prop.guardar("activoComputo", "si", informacionCarrera.getAbsolutePath());
                                    
                                    prop.guardar("iniciadoSocial", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("encuestasLlenadasSocial", "0", informacionCarrera.getAbsolutePath());
                                    prop.guardar("recomendacionesCapturadasSocial", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("procesosTerminadosSocial", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("comparacionSocial", "sincomparacion", informacionCarrera.getAbsolutePath());
                                    prop.guardar("activoSocial", "si", informacionCarrera.getAbsolutePath());
                                    
                                    prop.guardar("iniciadoEscolares", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("encuestasLlenadasEscolares", "0", informacionCarrera.getAbsolutePath());
                                    prop.guardar("recomendacionesCapturadasEscolares", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("procesosTerminadosEscolares", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("comparacionEscolares", "sincomparacion", informacionCarrera.getAbsolutePath());
                                    prop.guardar("activoEscolares", "si", informacionCarrera.getAbsolutePath());
                                    
                                    prop.guardar("iniciadoResidencias", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("encuestasLlenadasResidencias", "0", informacionCarrera.getAbsolutePath());
                                    prop.guardar("recomendacionesCapturadasResidencias", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("procesosTerminadosResidencias", "no", informacionCarrera.getAbsolutePath());
                                    prop.guardar("comparacionResidencias", "sincomparacion", informacionCarrera.getAbsolutePath());
                                    prop.guardar("activoResidencias", "si", informacionCarrera.getAbsolutePath());
                                }

                                //guardar configuracion de que se inicio un nuevo registro de encuestas
                                prop.guardar("actual", "si", ruta);
                                prop.guardar("archivoAnterior", prop.acceder("archivoActual", ruta), ruta);
                                prop.guardar("archivoActual", auxiliarNombre, ruta);
                                //encuestas, generar cada una en las carpetas de carrera para almacenar los resultados de encuestas

                                File encuestasCentro = null;
                                File encuestasCoordinacion = null;
                                File encuestasFinancieros = null;
                                File encuestasComputo = null;
                                File encuestasSocial = null;
                                File encuestasEscolares = null;
                                File encuestasResidencias = null;
                                int i = 0;
                                do {
                                    String aux = nombreCarpeta + "/" + carreras.get(i).getNombre();
                                    System.out.println(aux);
                                    encuestasCentro = new File(aux, "centroInformacionEncuestas.xml");
                                    encuestasCentro.createNewFile();
                                    encuestasCoordinacion = new File(aux, "coordinacionCarrerasEncuestas.xml");
                                    encuestasCoordinacion.createNewFile();
                                    encuestasFinancieros = new File(aux, "recursosFinancierosEncuestas.xml");
                                    encuestasFinancieros.createNewFile();
                                    encuestasComputo = new File(aux, "centroComputoEncuestas.xml");
                                    encuestasComputo.createNewFile();
                                    encuestasSocial = new File(aux, "servicioSocialEncuestas.xml");
                                    encuestasSocial.createNewFile();
                                    encuestasEscolares = new File(aux, "serviciosEscolaresEncuestas.xml");
                                    encuestasEscolares.createNewFile();
                                    encuestasResidencias = new File(aux, "residenciasProfesionalesEncuestas.xml");
                                    encuestasResidencias.createNewFile();
                                    i++;
                                } while (i < tam);
                                //si se crea
                                if (encuestasCentro.exists() && encuestasComputo.exists()
                                        && encuestasCoordinacion.exists() && encuestasEscolares.exists()
                                        && encuestasFinancieros.exists() && encuestasResidencias.exists()
                                        && encuestasSocial.exists()) {
                                    //SI SE CREAN TODOS LOS ARCHIVOS ABRE INTERFAZ DE CAPTURA.
                                    CAPTURA obj = new CAPTURA();
                                    obj.setVisible(true);
                                    this.dispose();
                                    System.out.println("se crearon con exito, archivos y ahora deberia mostrar capturaForm");
                                } else {
                                    //no se crearon los archivos
                                    funcionEliminarCarpeta(new File(nombreCarpeta));
                                    System.out.println("no se crearon los archivos");
                                }
                            } else {
                                //no se creo el periodo
                                System.out.println("no se creo el peridoo");
                            }
                        } catch (IOException ex) {
                            System.out.println("No se creo archivo");
                        }
                    }
                } else {
                    //el periodo excede el rango
                    System.out.println("El periodo de fechas es mayor a 6 meses y no es posible.");
                }
            } else {
                //La fecha FIN es mayor a la fecha INICIO
                System.out.println("Las fechas estan invertidas");
            }

        } else {
            //no seleccionaste fechhas
            System.out.println("No se han seleccionado fechas");
        }
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        // TODO add your handling code here:
        jPanel9.setBackground(new Color(67, 80, 88 ));
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
        // TODO add your handling code here:
        jPanel9.setBackground(new Color(27, 57, 106 ));
    }//GEN-LAST:event_jLabel19MouseExited

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        // TODO add your handling code here:
        xmouse = evt.getX();
        ymouse = evt.getY();

    }//GEN-LAST:event_jPanel5MousePressed

    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xmouse, y - ymouse);
    }//GEN-LAST:event_jPanel5MouseDragged

    private void funcionEliminarCarpeta(File pArchivo) {
        if (!pArchivo.exists()) {
            return;
        }

        if (pArchivo.isDirectory()) {
            for (File f : pArchivo.listFiles()) {
                funcionEliminarCarpeta(f);
            }
        }
        pArchivo.delete();
    }

   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PERIODO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenera;
    private rojeru_san.componentes.RSDateChooser chooserFecha1;
    private rojeru_san.componentes.RSDateChooser chooserFecha2;
    private javax.swing.JButton continuar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblFin;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblSelecciona;
    private javax.swing.JButton nueva;
    // End of variables declaration//GEN-END:variables
    
}
