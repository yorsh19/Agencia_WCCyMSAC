
package Chofer;

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
public class ControladorChofer {
    ListaDobleChofer choferes;
    frmChofer frmC;
    
    public ControladorChofer(ListaDobleChofer choferes, frmChofer frmC){
        this.choferes = choferes;
        this.frmC =  frmC;
        
        this.frmC.btnNuevo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                limpiarControles();
                tablaChoferes();
            }
        });
        
        this.frmC.btnGuardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(validar()){
                    String nombre = frmC.txtNombre.getText();
                    int dni = Integer.parseInt(frmC.txtDni.getText());
                    String brevete = frmC.txtBrevete.getText();
                    choferes.agregarAlInicio(new Chofer(nombre, dni, brevete));
                    JOptionPane.showMessageDialog(frmC, "Chofer agregado");
                    tablaChoferes();
                }else{
                    JOptionPane.showMessageDialog(frmC, "Complete todos los campos");
                }
                limpiarControles();
            }
        });
        
        this.frmC.btnModificar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                int fila = frmC.tabChoferes.getSelectedRow();
                if(fila >= 0){
                    int dni = Integer.parseInt(frmC.tabChoferes.getValueAt(fila, 0).toString());
                    Chofer encontrado = choferes.recuperarChofer(dni);
                    frmChoferModificar frmCM = new frmChoferModificar();
                    ControladorChoferModificar conCM = new ControladorChoferModificar(encontrado, frmCM);
                    conCM.iniciar();
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
                int fila = frmC.tabChoferes.getSelectedRow();
                if(fila >= 0){
                    int dni = Integer.parseInt(frmC.tabChoferes.getValueAt(fila, 0).toString());
                    Chofer encontrado = choferes.recuperarChofer(dni);
                    frmChoferEliminar frmCE = new frmChoferEliminar();
                    ControladorChoferEliminar conCE = new ControladorChoferEliminar(encontrado, frmCE);
                    conCE.iniciar();
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
                frmAgenciaCamiones frmAB = new frmAgenciaCamiones();
                ControladorAgenciaCamiones conAB = new ControladorAgenciaCamiones(frmAB);
                conAB.iniciar();
                frmC.setVisible(false);
            }
        });
    }
    
    public void iniciar(){
        this.frmC.setVisible(true);
        this.frmC.setLocationRelativeTo(null);
        tablaChoferes();
    }
    
    public void limpiarControles(){
        this.frmC.txtNombre.setText("");
        this.frmC.txtDni.setText("");
        this.frmC.txtBrevete.setText("");
    }
    
    public boolean validar(){
        if(this.frmC.txtNombre.getText().length() != 0 &&
                this.frmC.txtDni.getText().length() != 0 &&
                this.frmC.txtBrevete.getText().length() != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public void tablaChoferes(){
        DefaultTableModel tablaChoferes = new DefaultTableModel(Repositorio.choferes.obtenerDatos(), Repositorio.choferes.obtenerCabecera());
        frmC.tabChoferes.setModel(tablaChoferes);
    }
}
