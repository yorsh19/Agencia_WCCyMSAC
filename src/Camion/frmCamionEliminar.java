
package Camion;

import Viaje.*;


/**
 *
 * @author 
 */
public class frmCamionEliminar extends javax.swing.JFrame {

    /**
     * Creates new form frmCliente
     */
    public frmCamionEliminar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panEliminar = new javax.swing.JPanel();
        lblModelo = new javax.swing.JLabel();
        lblRuc = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCamionModelo = new javax.swing.JLabel();
        lblCamionRuc = new javax.swing.JLabel();
        lblAsientos = new javax.swing.JLabel();
        lblCamionNumAsientos = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        lblCamionPlaca = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblModelo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblModelo.setText("Modelo:");

        lblRuc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblRuc.setText("Ruc:");

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminar.setText("Eliminar");

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");

        lblCamionModelo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCamionModelo.setText("Modelo");

        lblCamionRuc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCamionRuc.setText("Ruc");

        lblAsientos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAsientos.setText("#Asientos:");

        lblCamionNumAsientos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCamionNumAsientos.setText("#Asientos");

        lblPlaca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPlaca.setText("Placa:");

        lblCamionPlaca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCamionPlaca.setText("Placa");

        javax.swing.GroupLayout panEliminarLayout = new javax.swing.GroupLayout(panEliminar);
        panEliminar.setLayout(panEliminarLayout);
        panEliminarLayout.setHorizontalGroup(
            panEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEliminarLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panEliminarLayout.createSequentialGroup()
                        .addGroup(panEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panEliminarLayout.createSequentialGroup()
                                .addGroup(panEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAsientos)
                                    .addComponent(lblPlaca))
                                .addGap(18, 18, 18)
                                .addGroup(panEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCamionNumAsientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCamionPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panEliminarLayout.createSequentialGroup()
                                .addGroup(panEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRuc)
                                    .addComponent(lblModelo))
                                .addGap(34, 34, 34)
                                .addGroup(panEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCamionModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCamionRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panEliminarLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(95, 95, 95))))
        );
        panEliminarLayout.setVerticalGroup(
            panEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEliminarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(lblCamionModelo))
                .addGap(18, 18, 18)
                .addGroup(panEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRuc)
                    .addComponent(lblCamionRuc))
                .addGap(18, 18, 18)
                .addGroup(panEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAsientos)
                    .addComponent(lblCamionNumAsientos))
                .addGap(18, 18, 18)
                .addGroup(panEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaca)
                    .addComponent(lblCamionPlaca))
                .addGap(32, 32, 32)
                .addGroup(panEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        btnEliminar.setFocusPainted(false);
        btnCancelar.setFocusPainted(false);

        getContentPane().add(panEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 430, 230));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ELIMINAR CAMION");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 620, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmCamionEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCamionEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCamionEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCamionEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCamionEliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAsientos;
    public javax.swing.JLabel lblCamionModelo;
    public javax.swing.JLabel lblCamionNumAsientos;
    public javax.swing.JLabel lblCamionPlaca;
    public javax.swing.JLabel lblCamionRuc;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblRuc;
    private javax.swing.JPanel panEliminar;
    // End of variables declaration//GEN-END:variables
}
