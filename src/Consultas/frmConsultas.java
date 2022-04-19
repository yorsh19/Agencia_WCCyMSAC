
package Consultas;

/**
 *
 * @author 
 */
public class frmConsultas extends javax.swing.JFrame {

    /**
     * Creates new form frmConsultas
     */
    public frmConsultas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panCuerpo = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnBuscarPasajero = new javax.swing.JButton();
        btnBuscarEncomienda = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalir.setText("Salir");

        btnBuscarPasajero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscarPasajero.setText("Buscar Pasajero");

        btnBuscarEncomienda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscarEncomienda.setText("Buscar Carga");

        btnBuscarCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscarCliente.setText("Buscar Cliente");

        javax.swing.GroupLayout panCuerpoLayout = new javax.swing.GroupLayout(panCuerpo);
        panCuerpo.setLayout(panCuerpoLayout);
        panCuerpoLayout.setHorizontalGroup(
            panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCuerpoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnBuscarEncomienda)
                .addGap(18, 18, 18)
                .addGroup(panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir)
                    .addGroup(panCuerpoLayout.createSequentialGroup()
                        .addComponent(btnBuscarCliente)
                        .addGap(27, 27, 27)
                        .addComponent(btnBuscarPasajero)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        panCuerpoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBuscarCliente, btnBuscarEncomienda, btnBuscarPasajero, btnSalir});

        panCuerpoLayout.setVerticalGroup(
            panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCuerpoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panCuerpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscarEncomienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarPasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btnSalir)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnSalir.setFocusPainted(false);
        btnBuscarPasajero.setFocusPainted(false);
        btnBuscarEncomienda.setFocusPainted(false);
        btnBuscarCliente.setFocusPainted(false);

        getContentPane().add(panCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 440, 190));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CONSULTAS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 460, -1));

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
            java.util.logging.Logger.getLogger(frmConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsultas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConsultas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscarCliente;
    public javax.swing.JButton btnBuscarEncomienda;
    public javax.swing.JButton btnBuscarPasajero;
    public javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel panCuerpo;
    // End of variables declaration//GEN-END:variables
}
