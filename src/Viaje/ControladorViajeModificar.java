
package Viaje;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Repositorio.Repositorio;

/**
 *
 * @author 
 */
public class ControladorViajeModificar {
    Viaje viaje;
    frmViajeModificar frmVM;
    
    public ControladorViajeModificar(Viaje viaje, frmViajeModificar frmVM){
        this.viaje = viaje;
        this.frmVM = frmVM;
        
        frmVM.btnModificar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(validar()){
                    viaje.setOrigen(frmVM.txtOrigen.getText());
                    viaje.setDestino(frmVM.txtDestino.getText());
                    JOptionPane.showMessageDialog(frmVM, "Viaje modificado");
                    frmViaje frmV = new frmViaje();
                    ControladorViaje conV =  new ControladorViaje(Repositorio.viajes, frmV);
                    conV.iniciar();
                    frmVM.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(frmVM, "Complete todos los campos");
                }
            }
        });
        
        frmVM.btnCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmViaje frmV = new frmViaje();
                ControladorViaje conV =  new ControladorViaje(Repositorio.viajes, frmV);
                conV.iniciar();
                frmVM.setVisible(false);
            }
        });
    }
    
    public void iniciar(){
        frmVM.setVisible(true);
        frmVM.setLocationRelativeTo(null);
        frmVM.txtDestino.setText(viaje.getDestino());
        frmVM.txtOrigen.setText(viaje.getOrigen());
    }
    
    public boolean validar(){
        if(frmVM.txtOrigen.getText().length() != 0 &&
                frmVM.txtDestino.getText().length() != 0){
            return true;
        }else{
            return false;
        }
    }
}
