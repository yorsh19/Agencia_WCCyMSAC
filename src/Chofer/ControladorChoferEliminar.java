
package Chofer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Repositorio.Repositorio;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class ControladorChoferEliminar {
    Chofer chofer;
    frmChoferEliminar frmCE;
    
    public ControladorChoferEliminar(Chofer chofer, frmChoferEliminar frmCE){
        this.chofer = chofer;
        this.frmCE = frmCE;
        
        frmCE.btnEliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                Repositorio.choferes.eliminarChofer(chofer.getDni());
                JOptionPane.showMessageDialog(frmCE, "Chofer eliminado");
                frmChofer frmC = new frmChofer();
                ControladorChofer conC =  new ControladorChofer(Repositorio.choferes, frmC);
                conC.iniciar();
                frmCE.setVisible(false);
            }
        });
        
        frmCE.btnCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmChofer frmC = new frmChofer();
                ControladorChofer conC =  new ControladorChofer(Repositorio.choferes, frmC);
                conC.iniciar();
                frmCE.setVisible(false);
            }
        });
    }
    
    public void iniciar(){
        frmCE.setVisible(true);
        frmCE.setLocationRelativeTo(null);
        frmCE.lblChoferBrevete.setText(chofer.getBrevete());
        frmCE.lblChoferDni.setText(String.valueOf(chofer.getDni()));
        frmCE.lblChoferNombre.setText(chofer.getNombre());
    }
}
