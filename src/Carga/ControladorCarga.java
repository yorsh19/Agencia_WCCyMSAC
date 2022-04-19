
package Carga;

import Planilla.Planilla;
import Repositorio.Repositorio;
import agenciaCamiones.ControladorAgenciaCamiones;
import agenciaCamiones.frmAgenciaCamiones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class ControladorCarga {
    ListaCarga encomiendas;
    frmCarga frmE;
    
    public ControladorCarga(ListaCarga encomiendas, frmCarga frmE){
        this.encomiendas = encomiendas;
        this.frmE = frmE;
        
        this.frmE.btnNuevo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                limpiarControles();
            }
        });
        
        this.frmE.btnGuardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(validar()){
                    int codigo = Integer.parseInt(frmE.boxPlanillas.getSelectedItem().toString().substring(1));
                    Planilla planilla = Repositorio.planillas.recuperarPlanilla(codigo);
                    String remitente = frmE.txtRemitente.getText();
                    int dniRemitente = Integer.parseInt(frmE.txtDniRemitente.getText());
                    String destinatario = frmE.txtDestinatario.getText();
                    int dniDestinatario = Integer.parseInt(frmE.txtDniDestinatario.getText());
                    String descripcion =  frmE.txtDescripcion.getText();
                    int codigoEncomienda = encomiendas.codigoAleatorio();
                    encomiendas.agregarEncomienda(new Carga(remitente, dniRemitente, destinatario, dniDestinatario, descripcion, codigoEncomienda));
                    Carga encomienda = encomiendas.recuperarEncomienda(codigoEncomienda);
                    Repositorio.planillas.agregarEncomienda(planilla.getCodigo(), encomienda);
                    JOptionPane.showMessageDialog(frmE, "Encomienda agregada");
                }else{
                    JOptionPane.showMessageDialog(frmE, "Complete todos los campos");
                }
                limpiarControles();
            }
        });
        
        this.frmE.btnSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmAgenciaCamiones frmAB = new frmAgenciaCamiones();
                ControladorAgenciaCamiones conAB = new ControladorAgenciaCamiones(frmAB);
                conAB.iniciar();
                frmE.setVisible(false);
            }
        });
    }
    
    public void iniciar(){
        this.frmE.setVisible(true);
        this.frmE.setLocationRelativeTo(null);
        boxPlanillas();
        limpiarControles();
    }
    
    public void boxPlanillas(){
        if(!Repositorio.planillas.estaVacio()){
            DefaultComboBoxModel boxPlanillas = new DefaultComboBoxModel();
            for( Object o : Repositorio.planillas.getDatosCombo()){
                boxPlanillas.addElement(o);
            }
            frmE.boxPlanillas.setModel(boxPlanillas);
        }else{
            frmE.boxPlanillas.setEnabled(false);
        }
    }
    
    public void limpiarControles(){
        this.frmE.boxPlanillas.setSelectedIndex(-1);
        this.frmE.txtRemitente.setText("");
        this.frmE.txtDniRemitente.setText("");
        this.frmE.txtDestinatario.setText("");
        this.frmE.txtDniDestinatario.setText("");
        this.frmE.txtDescripcion.setText("");
    }
    
    public boolean validar(){
        if(this.frmE.boxPlanillas.getSelectedIndex() != -1 &&
                this.frmE.txtRemitente.getText().length() != 0 &&
                this.frmE.txtDniRemitente.getText().length() != 0 &&
                this.frmE.txtDestinatario.getText().length() != 0 &&
                this.frmE.txtDniDestinatario.getText().length() != 0 &&
                this.frmE.txtDescripcion.getText().length() != 0){
            return true;
        }else{
            return false;
        }
    }
}
