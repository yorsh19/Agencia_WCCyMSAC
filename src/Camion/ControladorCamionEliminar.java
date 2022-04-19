
package Camion;

import Repositorio.Repositorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class ControladorCamionEliminar {
    Camion camion;
    frmCamionEliminar frmCE;
    
    public ControladorCamionEliminar(Camion camion, frmCamionEliminar frmCE){
        this.camion = camion;
        this.frmCE = frmCE;
        
        frmCE.btnEliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                Repositorio.camiones.eliminarCamion(camion.getPlaca());
                JOptionPane.showMessageDialog(frmCE, "Camion eliminado");
                frmCamion frmC = new frmCamion();
                ControladorCamion conC =  new ControladorCamion(Repositorio.camiones, frmC);
                conC.iniciar();
                frmCE.setVisible(false);
            }
        });
        
        frmCE.btnCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmCamion frmC = new frmCamion();
                ControladorCamion conB =  new ControladorCamion(Repositorio.camiones, frmC);
                conB.iniciar();
                frmCE.setVisible(false);
            }
        });
    }
    
    public void iniciar(){
        this.frmCE.setVisible(true);
        this.frmCE.setLocationRelativeTo(null);
        this.frmCE.lblCamionModelo.setText(camion.getModelo());
        this.frmCE.lblCamionPlaca.setText(camion.getPlaca());
        this.frmCE.lblCamionRuc.setText(camion.getRuc());
        this.frmCE.lblCamionNumAsientos.setText(String.valueOf(camion.getNumAsientos()));
    }
}
