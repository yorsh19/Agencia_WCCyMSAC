
package Chofer;

import Repositorio.Repositorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class ControladorChoferModificar {
    Chofer chofer;
    frmChoferModificar frmCM;
    
    public ControladorChoferModificar(Chofer chofer, frmChoferModificar frmCM){
        this.chofer = chofer;
        this.frmCM = frmCM;
        
        frmCM.btnModificar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(validar()){
                    chofer.setNombre(frmCM.txtNombre.getText());
                    chofer.setDni(Integer.parseInt(frmCM.txtDni.getText()));
                    chofer.setBrevete(frmCM.txtBrevete.getText());
                    JOptionPane.showMessageDialog(frmCM, "Chofer modificado");
                    frmChofer frmC = new frmChofer();
                    ControladorChofer conC =  new ControladorChofer(Repositorio.choferes, frmC);
                    conC.iniciar();
                    frmCM.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(frmCM, "Complete todos los campos");
                }
            }
        });
        
        frmCM.btnCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmChofer frmC = new frmChofer();
                ControladorChofer conC =  new ControladorChofer(Repositorio.choferes, frmC);
                conC.iniciar();
                frmCM.setVisible(false);
            }
        });
    }
    
    public boolean validar(){
        if(this.frmCM.txtNombre.getText().length() != 0 &&
                this.frmCM.txtDni.getText().length() != 0 &&
                this.frmCM.txtBrevete.getText().length() != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public void iniciar(){
        this.frmCM.setVisible(true);
        this.frmCM.setLocationRelativeTo(null);
        this.frmCM.txtBrevete.setText(chofer.getBrevete());
        this.frmCM.txtDni.setText(String.valueOf(chofer.getDni()));
        this.frmCM.txtNombre.setText(chofer.getNombre());
    }
}
