
package Planilla;

import Chofer.Chofer;
import Viaje.Viaje;
import Camion.Camion;
import javax.swing.DefaultComboBoxModel;
import Repositorio.Repositorio;
import agenciaCamiones.ControladorAgenciaCamiones;
import agenciaCamiones.frmAgenciaCamiones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class ControladorCrearPlanilla {
    ArregloPlanilla planillas;
    frmCrearPlanilla frmCP;
    
    public ControladorCrearPlanilla(ArregloPlanilla planillas, frmCrearPlanilla frmCP){
        this.planillas = planillas;
        this.frmCP = frmCP;
        
        this.frmCP.btnCrearPlanilla.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(validar()){
                    Camion camion = (Camion) frmCP.boxBuses.getSelectedItem();
                    Viaje viaje = (Viaje) frmCP.boxViajes.getSelectedItem();
                    Chofer chofer = (Chofer) frmCP.boxChoferes.getSelectedItem();
                    Repositorio.camiones.activarEnPlanilla(camion.getPlaca());
                    Repositorio.viajes.activarEnPlanilla(viaje.getCodigo());
                    Repositorio.choferes.activarEnPlanilla(chofer.getDni());
                    Repositorio.planillas.agregarPlanilla(new Planilla(camion, chofer, viaje, planillas.codigoAleatorio()));
                    JOptionPane.showMessageDialog(frmCP, "Planilla agregada");
                }else{
                    JOptionPane.showMessageDialog(frmCP, "Elija todos los campos");
                }
                boxBuses();
                boxViajes();
                boxChoferes();
                limpiarControles();
                
            }
        });
        
        this.frmCP.btnReservarPasajes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmReservarPasajes frmRP = new frmReservarPasajes();
                ControladorReservarPasajes conRP = new ControladorReservarPasajes(planillas, frmRP);
                conRP.iniciar();
                frmCP.setVisible(false);
            }
        });
        
        this.frmCP.btnImprimirPlanilla.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmImprimirPlanilla frmIP = new frmImprimirPlanilla();
                ControladorImprimirPlanilla conIP = new ControladorImprimirPlanilla(planillas, frmIP);
                conIP.iniciar();
                frmCP.setVisible(false);
            }
        });
        
        this.frmCP.btnSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmAgenciaCamiones frmAB = new frmAgenciaCamiones();
                ControladorAgenciaCamiones conAB = new ControladorAgenciaCamiones(frmAB);
                conAB.iniciar();
                frmCP.setVisible(false);
            }
        });
    }
    
    public void iniciar(){
        this.frmCP.setVisible(true);
        this.frmCP.setLocationRelativeTo(null);
        boxBuses();
        boxViajes();
        boxChoferes();
        limpiarControles();
    }
    
    public void boxBuses(){
        if(!Repositorio.camiones.estaVacio()){
            DefaultComboBoxModel boxBuses = new DefaultComboBoxModel();
            for( Object o : Repositorio.camiones.getDatosCombo()){
                boxBuses.addElement(o);
            }
            frmCP.boxBuses.setModel(boxBuses);
        }else{
            frmCP.boxBuses.setEnabled(false);
        }
    }
    
    public void boxViajes(){
        if(!Repositorio.viajes.estaVacio()){
            DefaultComboBoxModel boxViajes = new DefaultComboBoxModel();
            for( Object o : Repositorio.viajes.getDatosCombo()){
                boxViajes.addElement(o);
            }
            frmCP.boxViajes.setModel(boxViajes);
        }else{
            frmCP.boxViajes.setEnabled(false);
        }
    }
    
    public void boxChoferes(){
        if(!Repositorio.choferes.vacia()){
            DefaultComboBoxModel boxChoferes = new DefaultComboBoxModel();
            for( Object o : Repositorio.choferes.getDatosCombo()){
                boxChoferes.addElement(o);
            }
            frmCP.boxChoferes.setModel(boxChoferes);
        }else{
            frmCP.boxChoferes.setEnabled(false);
        }
    }
    
    public void limpiarControles(){
        frmCP.boxChoferes.setSelectedIndex(-1);
        frmCP.boxViajes.setSelectedIndex(-1);
        frmCP.boxBuses.setSelectedIndex(-1);
    }
    
    public boolean validar(){
        if(this.frmCP.boxBuses.getSelectedIndex() != -1 &&
                this.frmCP.boxChoferes.getSelectedIndex() != -1 &&
                this.frmCP.boxViajes.getSelectedIndex() != -1){
            return true;
        }else{
            return false;
        }
    }
}
