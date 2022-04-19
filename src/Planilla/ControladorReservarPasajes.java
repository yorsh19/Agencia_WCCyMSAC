
package Planilla;

import Cliente.Cliente;
import Repositorio.Repositorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */
public class ControladorReservarPasajes {
    frmReservarPasajes frmRP;
    ArregloPlanilla planillas;
    
    public ControladorReservarPasajes(ArregloPlanilla planillas, frmReservarPasajes frmRP){
        this.planillas = planillas;
        this.frmRP = frmRP;
        
        this.frmRP.boxPlanillas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(frmRP.boxPlanillas.getSelectedIndex() != -1){
                    int codigo = Integer.parseInt(frmRP.boxPlanillas.getSelectedItem().toString().substring(1));
                    Planilla planilla = Repositorio.planillas.recuperarPlanilla(codigo);
                    frmRP.lblPlanillaCodigo.setText("#"+String.valueOf(planilla.getCodigo()));
                    frmRP.lblPlanillaAsientos.setText(String.valueOf(planilla.getBus().getNumAsientos()));
                }
            }
        });
        
        this.frmRP.btnReservarPasajero.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                int fila = frmRP.tabClientes.getSelectedRow();
                if(fila >= 0 && frmRP.boxPlanillas.getSelectedIndex() != -1){
                    int codigo = Integer.parseInt(frmRP.boxPlanillas.getSelectedItem().toString().substring(1));
                    int dni = Integer.parseInt(frmRP.tabClientes.getValueAt(fila, 0).toString());
                    Cliente cliente = Repositorio.clientes.recuperarCliente(dni);
                    Planilla planilla = Repositorio.planillas.recuperarPlanilla(codigo);
                    if(planilla.getBus().getNumAsientos()>0){
                        Repositorio.clientes.activarAsientoReservado(cliente.getDni());
                        Repositorio.planillas.agregarCliente(planilla.getCodigo(), cliente);
                        JOptionPane.showMessageDialog(frmRP, "Pasajero agregado a la planilla #"+planilla.getCodigo());
                        planilla.getBus().setNumAsientos(planilla.getBus().getNumAsientos()-1);
                        frmRP.lblPlanillaAsientos.setText(String.valueOf(planilla.getBus().getNumAsientos()));
                    }else{
                        JOptionPane.showMessageDialog(frmRP, "El bus está ocupado");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(frmRP, "Seleccione una fila de la tabla y/o seleccione una planilla");
                }
                tablaClientes();
            }
        });
        
        this.frmRP.btnSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmCrearPlanilla frmCP = new frmCrearPlanilla();
                ControladorCrearPlanilla conCP = new ControladorCrearPlanilla(planillas, frmCP);
                conCP.iniciar();
                frmRP.setVisible(false);
            }
        });
    }
    
    public void iniciar(){
        this.frmRP.setVisible(true);
        this.frmRP.setLocationRelativeTo(null);
        boxPlanillas();
        tablaClientes();
        this.frmRP.boxPlanillas.setSelectedIndex(-1);
        this.frmRP.lblPlanillaAsientos.setText("");
        this.frmRP.lblPlanillaCodigo.setText("");
    }
    
    public void boxPlanillas(){
        if(!Repositorio.planillas.estaVacio()){
            DefaultComboBoxModel boxPlanillas = new DefaultComboBoxModel();
            for( Object o : Repositorio.planillas.getDatosCombo()){
                boxPlanillas.addElement(o);
            }
            frmRP.boxPlanillas.setModel(boxPlanillas);
        }else{
            frmRP.boxPlanillas.setEnabled(false);
        }
    }
    
    public void tablaClientes(){
        DefaultTableModel tablaClientes = new DefaultTableModel(Repositorio.clientes.obtenerDatos(), Repositorio.clientes.obtenerCabecera());
        frmRP.tabClientes.setModel(tablaClientes);
    }
}
