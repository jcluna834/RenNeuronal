package Presentacion;

import Logica.RNA;
import archivo.Archivo;
import java.io.IOException;
import javax.swing.JOptionPane;

public class MenuInicio extends javax.swing.JFrame {

    private RNA red;

    public MenuInicio() {
        initComponents();
        red = null;
    }

    public void setRed(RNA red) {
        this.red = red;
    }

    public RNA getRed() {
        return red;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelOpcion = new javax.swing.JLabel();
        jButtonEntrenamiento = new javax.swing.JButton();
        jButtonProduccion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitulo.setBackground(new java.awt.Color(255, 0, 0));
        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 0, 0));
        jLabelTitulo.setText("MENU DE LA RED NEURONAL");

        jLabelOpcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelOpcion.setText("Escoja una opcion");

        jButtonEntrenamiento.setText("Entrenar");
        jButtonEntrenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrenamientoActionPerformed(evt);
            }
        });

        jButtonProduccion.setText("Producir");
        jButtonProduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProduccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelOpcion)
                        .addGap(87, 87, 87))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonEntrenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonProduccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabelTitulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jLabelOpcion)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEntrenamiento)
                    .addComponent(jButtonProduccion))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEntrenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrenamientoActionPerformed
        TipoRNA aux = new TipoRNA(red, this);
        aux.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonEntrenamientoActionPerformed

    private void jButtonProduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProduccionActionPerformed
        String opc;
        if (red == null) {
            if (JOptionPane.showConfirmDialog(rootPane, "Debes Ingresar una Red Neuronal.\nDesea Ingresarla Ahora?") == JOptionPane.YES_OPTION) {
                TipoRNA aux = new TipoRNA(red, this);
                aux.setVisible(true);
                this.setVisible(false);
            }
        } else {
            if (JOptionPane.showConfirmDialog(rootPane, "Desea Usar La Interfaz?", "Selecciona una Opcion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Produccion production = new Produccion("salida.txt", this);
                this.setVisible(false);
                production.setVisible(true);
            } else {
                String direccion = JOptionPane.showInputDialog("Ingresa La Direccion Del Archivo");
                if(direccion != null) {
                    Archivo ar = new Archivo(direccion);
                    try {
                        red.setCantidadLineas(ar.CantidadLineas());
                        red.setDirEntradas(direccion);
                        red.generate("SalidaProduccion.txt");
                        JOptionPane.showMessageDialog(rootPane, "Revisa El Archivo SalidaProduccion.txt", "Produccion", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(rootPane, "Error Cargar El Archivo", "I/O Error", JOptionPane.ERROR_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, "La Red no se ha entrenado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else
                    JOptionPane.showMessageDialog(rootPane, "Error AL Ingresar Archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonProduccionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrenamiento;
    private javax.swing.JButton jButtonProduccion;
    private javax.swing.JLabel jLabelOpcion;
    private javax.swing.JLabel jLabelTitulo;
    // End of variables declaration//GEN-END:variables
}
