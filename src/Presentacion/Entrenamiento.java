package Presentacion;

import Logica.RNA;
import archivo.Archivo;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;

public class Entrenamiento extends javax.swing.JFrame {

    private MenuInicio menu;
    private RNA red;
    private boolean band = false;
    private String direccion;

    public Entrenamiento(MenuInicio m) {
        initComponents();
        menu = m;
        red = menu.getRed();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelCarga = new javax.swing.JLabel();
        jButtonExaminar = new javax.swing.JButton();
        jLabelRuta = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabelTitulo.setBackground(new java.awt.Color(255, 0, 0));
        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 0, 0));
        jLabelTitulo.setText("ENTRENAMIENTO");

        jLabelCarga.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelCarga.setText("Cargue el archivo del DataSet");

        jButtonExaminar.setText("Examinar");
        jButtonExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExaminarActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabelTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabelCarga))
                    .addComponent(jButtonExaminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAceptar)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExaminarActionPerformed
        JFileChooser dig = new JFileChooser();
        int opcion = dig.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            String file = dig.getSelectedFile().getName();
            band = true;
            jLabelRuta.setText("Archivo: " + file);
            direccion = dig.getSelectedFile().getAbsolutePath();
        }
    }//GEN-LAST:event_jButtonExaminarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        if (band) {
            Archivo a = new Archivo(direccion);
            try {
                red.setCantidadLineas(a.CantidadLineas());
                jLabelRuta.setText("Por Favor Espera, La Red Está Entrenando...");
                JOptionPane.showMessageDialog(null, "Patrones De Entrenamiento Cargados", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                String ciclos = JOptionPane.showInputDialog("Ingresa la cantidad de Iteraciones por ciclo de Entrenamiento");
                String factorAprendizaje = JOptionPane.showInputDialog("Ingresa el Factor de Aprendizaje");
                String momentum = JOptionPane.showInputDialog("Ingresa el Momentum");
                try {
                    red.setCiclos(Integer.parseInt(ciclos));
                    red.setDirEntradas(direccion);
                    red.setFactorAprendizaje(Double.parseDouble(factorAprendizaje));
                    red.setMomentum(Double.parseDouble(momentum));
                    try {
                        String error = red.training("Error.txt");
                        JOptionPane.showMessageDialog(null, "Entrenamiento Realizado Exitosamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        if(error != null)
                            JOptionPane.showMessageDialog(rootPane, "Error Cuadratico Medio: " + error);
                        menu.setVisible(true);
                        this.dispose();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, "Ocurrio un Error Al Entrenar La Red", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Datos Incorrectos", "Error I/O", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, "Error Al Cargar Archivo:\n" + direccion, "Error I/O", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe cargar un Archivo", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        menu.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonExaminar;
    private javax.swing.JLabel jLabelCarga;
    private javax.swing.JLabel jLabelRuta;
    private javax.swing.JLabel jLabelTitulo;
    // End of variables declaration//GEN-END:variables
}
