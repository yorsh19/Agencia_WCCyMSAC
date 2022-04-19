
package Viaje;

import agenciaCamiones.ControladorAgenciaCamiones;
import agenciaCamiones.frmAgenciaCamiones;
import Repositorio.Repositorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */
public class ControladorViaje {
    ArregloViaje viajes;
    frmViaje frmV;
    
    public ControladorViaje(ArregloViaje viajes, frmViaje frmV){
        this.viajes = viajes;
        this.frmV = frmV;
        
        this.frmV.btnNuevo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                limpiarControles();
                tablaViajes();
            }
        });
        
        this.frmV.btnGuardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(validar()){
                    String origen = frmV.txtOrigen.getText();
                    String destino = frmV.txtDestino.getText();
                    viajes.agregarViaje(new Viaje(origen, destino, viajes.generarAleatorio()));
                    JOptionPane.showMessageDialog(frmV, "Viaje agregado");
                    tablaViajes();
                }else{
                    JOptionPane.showMessageDialog(frmV, "Complete todos los campos");
                }
                limpiarControles();
            }
        });
        
        this.frmV.btnModificar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                int fila = frmV.tabViajes.getSelectedRow();
                if(fila >= 0){
                    int codigo = Integer.parseInt(frmV.tabViajes.getValueAt(fila, 5).toString());
                    Viaje encontrado = viajes.recuperarViaje(codigo);
                    frmViajeModificar frmVM = new frmViajeModificar();
                    ControladorViajeModificar conVM = new ControladorViajeModificar(encontrado, frmVM);
                    conVM.iniciar();
                    frmV.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(frmV, "Seleccione una fila de la tabla");
                }
            }
        });
        
        this.frmV.btnEliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                int fila = frmV.tabViajes.getSelectedRow();
                if(fila >= 0){
                    int codigo = Integer.parseInt(frmV.tabViajes.getValueAt(fila, 5).toString());
                    Viaje encontrado = viajes.recuperarViaje(codigo);
                    frmViajeEliminar frmVE = new frmViajeEliminar();
                    ControladorViajeEliminar conVE = new ControladorViajeEliminar(encontrado, frmVE);
                    conVE.iniciar();
                    frmV.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(frmV, "Seleccione una fila de la tabla");
                }
            }
        });
        
        this.frmV.btnSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmAgenciaCamiones frmAB = new frmAgenciaCamiones();
                ControladorAgenciaCamiones conAB = new ControladorAgenciaCamiones(frmAB);
                conAB.iniciar();
                frmV.setVisible(false);
            }
        });
    }
    
    public void iniciar(){
        this.frmV.setVisible(true);
        this.frmV.setLocationRelativeTo(null);
        tablaViajes();
    }
    
    public void limpiarControles(){
        this.frmV.txtDestino.setText("");
        this.frmV.txtOrigen.setText("");
    }
    
    public boolean validar(){
        if(this.frmV.txtDestino.getText().length() != 0 &&
                this.frmV.txtOrigen.getText().length() != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public void tablaViajes(){
        DefaultTableModel tablaViajes = new DefaultTableModel(Repositorio.viajes.obtenerDatos(), Repositorio.viajes.obtenerCabecera());
        frmV.tabViajes.setModel(tablaViajes);
    }
}
