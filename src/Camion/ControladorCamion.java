
package Camion;

import javax.swing.table.DefaultTableModel;
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
public class ControladorCamion {
    ArregloCamion camiones;
    frmCamion frmC;
    
    public ControladorCamion(ArregloCamion camiones, frmCamion frmC){
        this.camiones = camiones;
        this.frmC = frmC;
        
        this.frmC.btnNuevo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                limpiarControles();
                tablaCamiones();
            }
        });
        
        this.frmC.btnGuardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(validar()){
                    String modelo = frmC.txtModelo.getText();
                    String placa = frmC.txtPlaca.getText();
                    String ruc = frmC.txtRuc.getText();
                    int numAsientos = Integer.parseInt(frmC.txtNumAsientos.getText());
                    camiones.agregarCamion(new Camion(modelo, ruc, numAsientos, placa));
                    JOptionPane.showMessageDialog(frmC, "Camión agregado");
                    tablaCamiones();
                }else{
                    JOptionPane.showMessageDialog(frmC, "Complete todos los campos");
                }
                limpiarControles();
            }
        });
        
        this.frmC.btnModificar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                int fila = frmC.tabCamiones.getSelectedRow();
                if(fila >= 0){
                    String placa = frmC.tabCamiones.getValueAt(fila, 1).toString();
                    Camion encontrado = camiones.recuperarCamion(placa);
                    frmCamionModificar frmBM = new frmCamionModificar();
                    ControladorCamionModificar conBM = new ControladorCamionModificar(encontrado, frmBM);
                    conBM.iniciar();
                    frmC.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(frmC, "Seleccione una fila de la tabla");
                }
            }
        });
        
        this.frmC.btnEliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                int fila = frmC.tabCamiones.getSelectedRow();
                if(fila >= 0){
                    String placa = frmC.tabCamiones.getValueAt(fila, 1).toString();
                    Camion encontrado = camiones.recuperarCamion(placa);
                    frmCamionEliminar frmBE = new frmCamionEliminar();
                    ControladorCamionEliminar conBE = new ControladorCamionEliminar(encontrado, frmBE);
                    conBE.iniciar();
                    frmC.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(frmC, "Seleccione una fila de la tabla");
                }
            }
        });
        
        this.frmC.btnSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmAgenciaCamiones frmAC = new frmAgenciaCamiones();
                ControladorAgenciaCamiones conAB = new ControladorAgenciaCamiones(frmAC);
                conAB.iniciar();
                frmC.setVisible(false);
            }
        });
    }
    
    public void iniciar(){
        this.frmC.setVisible(true);
        this.frmC.setLocationRelativeTo(null);
        tablaCamiones();
    }
    
    public void limpiarControles(){
        this.frmC.txtModelo.setText("");
        this.frmC.txtNumAsientos.setText("");
        this.frmC.txtPlaca.setText("");
        this.frmC.txtRuc.setText("");
    }
    
    public boolean validar(){
        if(this.frmC.txtModelo.getText().length() != 0 &&
                this.frmC.txtNumAsientos.getText().length() != 0 &&
                this.frmC.txtPlaca.getText().length() != 0 &&
                this.frmC.txtRuc.getText().length() != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public void tablaCamiones(){
        DefaultTableModel tablaBuses = new DefaultTableModel(Repositorio.camiones.obtenerDatos(), Repositorio.camiones.obtenerCabecera());
        frmC.tabCamiones.setModel(tablaBuses);
    }
 
}
