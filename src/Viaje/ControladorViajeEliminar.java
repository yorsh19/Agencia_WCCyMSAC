
package Viaje;

import Repositorio.Repositorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class ControladorViajeEliminar {
    Viaje viaje;
    frmViajeEliminar frmVE;
    
    public ControladorViajeEliminar(Viaje viaje, frmViajeEliminar frmVE){
        this.viaje = viaje;
        this.frmVE = frmVE;
        
        frmVE.btnEliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                Repositorio.viajes.eliminarViaje(viaje.codigo);
                JOptionPane.showMessageDialog(frmVE, "Viaje eliminado");
                frmViaje frmV = new frmViaje();
                ControladorViaje conV =  new ControladorViaje(Repositorio.viajes, frmV);
                conV.iniciar();
                frmVE.setVisible(false);
            }
        });
        
        frmVE.btnCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmViaje frmV = new frmViaje();
                ControladorViaje conV =  new ControladorViaje(Repositorio.viajes, frmV);
                conV.iniciar();
                frmVE.setVisible(false);
            }
        });
    }
    
    public void iniciar(){
        frmVE.setVisible(true);
        frmVE.setLocationRelativeTo(null);
        frmVE.lblViajeDestino.setText(viaje.getDestino());
        frmVE.lblViajeOrigen.setText(viaje.getOrigen());
    }
}
