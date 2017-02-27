package Presentacion;

import Logica.RNA;
import archivo.Archivo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import static java.lang.Math.round;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Produccion extends javax.swing.JFrame {

    private String salidas;
    private RNA neuronaRNA;
    private int col1 = -1;
    private MenuInicio menu;

    public Produccion(String inputFile, MenuInicio m) {
        initComponents();
        menu = m;
        SNumeros(jTextFieldNa);
        SNumeros(jTextFieldCa);
        SNumeros(jTextFieldK);
        SNumeros(jTextFieldMg);
        SNumeros(jTextFieldFe);
        SNumeros(jTextFieldCu);
        SNumeros(jTextFieldP);
        SNumeros(jTextFieldS);
        SNumeros(jTextFieldCl);
        salidas = inputFile;
        neuronaRNA = menu.getRed();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelNa = new javax.swing.JLabel();
        jLabelK = new javax.swing.JLabel();
        jLabelCa = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelCu = new javax.swing.JLabel();
        jLabelS = new javax.swing.JLabel();
        jLabelCl = new javax.swing.JLabel();
        jLabelP = new javax.swing.JLabel();
        jTextFieldNa = new javax.swing.JTextField();
        jTextFieldCa = new javax.swing.JTextField();
        jTextFieldK = new javax.swing.JTextField();
        jTextFieldMg = new javax.swing.JTextField();
        jTextFieldFe = new javax.swing.JTextField();
        jTextFieldCu = new javax.swing.JTextField();
        jTextFieldP = new javax.swing.JTextField();
        jTextFieldS = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jTextFieldCl = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(265, 460));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelTitulo.setBackground(new java.awt.Color(255, 0, 0));
        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 0, 0));
        jLabelTitulo.setText("PRODUCCION");

        jLabelNa.setText("Sodio (Na)");

        jLabelK.setText("Potacio (K)");

        jLabelCa.setText("Calcio (Ca)");

        jLabel4.setText("Magnesio (Mg)");

        jLabel5.setText("Hierro (Fe)");

        jLabelCu.setText("Cobre (Cu)");

        jLabelS.setText("Azufre (S)");

        jLabelCl.setText("Cloro (Cl)");

        jLabelP.setText("Fosforo (P)");

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabelNa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelCa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCu, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonAceptar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelCl, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldCl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelS, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(23, 23, 23)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldNa)
                                .addComponent(jTextFieldK)
                                .addComponent(jTextFieldCa)
                                .addComponent(jTextFieldMg)
                                .addComponent(jTextFieldFe)
                                .addComponent(jTextFieldCu)
                                .addComponent(jTextFieldP)
                                .addComponent(jTextFieldS, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNa)
                    .addComponent(jTextFieldNa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelK)
                    .addComponent(jTextFieldK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCa)
                    .addComponent(jTextFieldCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldMg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldFe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCu)
                    .addComponent(jTextFieldCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelP)
                    .addComponent(jTextFieldP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelS)
                    .addComponent(jTextFieldS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCl)
                    .addComponent(jTextFieldCl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void SNumeros(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isLetter(c)) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        String linea;
        int bit1, bit2, bit3;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("produccion.txt");
            pw = new PrintWriter(fichero);
            double e1, e2, e3, e4, e5, e6, e7, e8, e9;
            e1 = Double.parseDouble(jTextFieldNa.getText()) / 2300;
            e2 = Double.parseDouble(jTextFieldK.getText()) / 572;
            e3 = Double.parseDouble(jTextFieldCa.getText()) / 320;
            e4 = Double.parseDouble(jTextFieldMg.getText()) / 223.2;
            e5 = Double.parseDouble(jTextFieldFe.getText()) / 18;
            e6 = Double.parseDouble(jTextFieldCu.getText()) / 16.7;
            e7 = Double.parseDouble(jTextFieldP.getText()) / 375;
            e8 = Double.parseDouble(jTextFieldS.getText()) / 493;
            e9 = Double.parseDouble(jTextFieldCl.getText()) / 2350;
            pw.write(e1 + ";" + e2 + ";" + e3 + ";" + e4 + ";" + e5 + ";" + e6 + ";" + e7 + ";" + e8 + ";" + e9);
        } catch (IOException | NumberFormatException e) {
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
            }
        }
        try {
            Archivo ar = new Archivo("produccion.txt");
            neuronaRNA.setDirEntradas("produccion.txt");
            neuronaRNA.setCantidadLineas(ar.CantidadLineas());
            neuronaRNA.generate(salidas);
            File archivo = new File(salidas);
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            if (archivo.exists()) {
                linea = br.readLine();
                String res[] = linea.split(";");
                switch (neuronaRNA.getTipo()) {
                    case 0:
                        bit3 = (int) round(Double.parseDouble(res[0]));
                        bit2 = (int) round(Double.parseDouble(res[1]));
                        bit1 = (int) round(Double.parseDouble(res[2]));
                        if (bit1 == 0 && bit2 == 0 && bit3 == 0) {
                            JOptionPane.showMessageDialog(rootPane, "El alimento es: CEREAL");
                        } else if (bit3 == 0 && bit2 == 0 && bit1 == 1) {
                            JOptionPane.showMessageDialog(rootPane, "El alimento es: TUBERCULOS Y HORTALIZAS");
                        } else if (bit3 == 0 && bit2 == 1 && bit1 == 0) {
                            JOptionPane.showMessageDialog(rootPane, "El alimento es: FRUTOS SECOS");
                        } else if (bit3 == 0 && bit2 == 1 && bit1 == 1) {
                            JOptionPane.showMessageDialog(rootPane, "El alimento es: CERDO");
                        } else if (bit3 == 1 && bit2 == 0 && bit1 == 0) {
                            JOptionPane.showMessageDialog(rootPane, "El alimento es: PESCADO");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "El alimento no se encuentra en un rango establecido");
                        }
                        break;
                    case 1:
                        if (Double.parseDouble(res[20]) >= 0.98) {
                            JOptionPane.showMessageDialog(rootPane, "El alimento es: LACTEOS");
                        } else if (Double.parseDouble(res[4]) >= 0.98) {
                            JOptionPane.showMessageDialog(rootPane, "El alimento es: HUEVOS");
                        } else if (Double.parseDouble(res[9]) >= 0.98) {
                            JOptionPane.showMessageDialog(rootPane, "El alimento es: CAZA");
                        } else if (Double.parseDouble(res[24]) >= 0.98) {
                            JOptionPane.showMessageDialog(rootPane, "El alimento es: EMBUTIDO");
                        } else if (Double.parseDouble(res[0]) >= 0.98) {
                            JOptionPane.showMessageDialog(rootPane, "El alimento es: AVE");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "El alimento no se encuentra en un rango establecido");
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(rootPane, "Error Al Cargar La Neuronal Artificial","Error RNA",JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(rootPane, "Error al leer el archivo");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Primero Debes Entrenar La Red", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        menu.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelCa;
    private javax.swing.JLabel jLabelCl;
    private javax.swing.JLabel jLabelCu;
    private javax.swing.JLabel jLabelK;
    private javax.swing.JLabel jLabelNa;
    private javax.swing.JLabel jLabelP;
    private javax.swing.JLabel jLabelS;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JTextField jTextFieldCa;
    private javax.swing.JTextField jTextFieldCl;
    private javax.swing.JTextField jTextFieldCu;
    private javax.swing.JTextField jTextFieldFe;
    private javax.swing.JTextField jTextFieldK;
    private javax.swing.JTextField jTextFieldMg;
    private javax.swing.JTextField jTextFieldNa;
    private javax.swing.JTextField jTextFieldP;
    private javax.swing.JTextField jTextFieldS;
    // End of variables declaration//GEN-END:variables
}
