
package Consultas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Repositorio.Repositorio;

/**
 *
 * @author 
 */
public class ControladorBuscarCarga {
    frmBuscarCarga frmBC;
    
    public ControladorBuscarCarga(frmBuscarCarga frmBE){
        this.frmBC = frmBE;
        
        this.frmBC.btnBuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(frmBE.txtDniBuscar.getText().length() != 0){
                    int dni = Integer.parseInt(frmBE.txtDniBuscar.getText());
                    if(Repositorio.cargas.buscarEncomienda(dni)){
                        JOptionPane.showMessageDialog(frmBE, "DNI encontrado");
                        frmBE.txtAreaEncomienda.setText(Repositorio.cargas.mostrarEncomiendas(dni));
                    }else{
                        JOptionPane.showMessageDialog(frmBE, "DNI no encontrado");
                        limpiarControles();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(frmBE, "El campo `Ingrese DNI` es obligatorio completar");
                }
            }
        });
        
        this.frmBC.btnNuevaBusqueda.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                limpiarControles();
            }
        });
        
        this.frmBC.btnSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmConsultas frmC = new frmConsultas();
                ControladorConsultas conC = new ControladorConsultas(frmC);
                conC.iniciar();
                frmBE.setVisible(false);
            }
        });
    }
    
    public void iniciar(){
        this.frmBC.setVisible(true);
        this.frmBC.setLocationRelativeTo(null);
    }
    
    public void limpiarControles(){
        this.frmBC.txtDniBuscar.setText("");
        this.frmBC.txtAreaEncomienda.setText("");
    }
}
