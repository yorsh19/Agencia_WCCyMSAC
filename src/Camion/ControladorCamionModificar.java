
package Camion;

import Repositorio.Repositorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class ControladorCamionModificar {
    Camion camion;
    frmCamionModificar frmCM;
    
    public ControladorCamionModificar(Camion camion, frmCamionModificar frmCM){
        this.camion = camion;
        this.frmCM = frmCM;
        
        frmCM.btnModificar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(validar()){
                    camion.setModelo(frmCM.txtModelo.getText());
                    camion.setPlaca(frmCM.txtPlaca.getText());
                    camion.setRuc(frmCM.txtRuc.getText());
                    camion.setNumAsientos(Integer.parseInt(frmCM.txtNumAsientos.getText()));
                    JOptionPane.showMessageDialog(frmCM, "Camión modificado");
                    frmCamion frmB = new frmCamion();
                    ControladorCamion conB =  new ControladorCamion(Repositorio.camiones, frmB);
                    conB.iniciar();
                    frmCM.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(frmCM, "Complete todos los campos");
                }
            }
        });
        
        frmCM.btnCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmCamion frmC = new frmCamion();
                ControladorCamion conC =  new ControladorCamion(Repositorio.camiones, frmC);
                conC.iniciar();
                frmCM.setVisible(false);
            }
        });
    }
    
    public void iniciar(){
        this.frmCM.setVisible(true);
        this.frmCM.setLocationRelativeTo(null);
        this.frmCM.txtModelo.setText(camion.getModelo());
        this.frmCM.txtPlaca.setText(camion.getPlaca());
        this.frmCM.txtRuc.setText(camion.getRuc());
        this.frmCM.txtNumAsientos.setText(String.valueOf(camion.getNumAsientos()));
    }
    
    public boolean validar(){
        if(this.frmCM.txtModelo.getText().length() != 0 &&
                this.frmCM.txtNumAsientos.getText().length() != 0 &&
                this.frmCM.txtPlaca.getText().length() != 0 &&
                this.frmCM.txtRuc.getText().length() != 0){
            return true;
        }else{
            return false;
        }
    }
}
