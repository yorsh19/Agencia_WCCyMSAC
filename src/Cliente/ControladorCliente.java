/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import agenciaCamiones.ControladorAgenciaCamiones;
import agenciaCamiones.frmAgenciaCamiones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author D&J GODS PC
 */
public class ControladorCliente {
    ListaCliente clientes;
    frmCliente frmC;
    
    public ControladorCliente(ListaCliente clientes, frmCliente frmC){
        this.clientes = clientes;
        this.frmC = frmC;
        
        frmC.btnNuevo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                limpiarControles();
            }
        });
        
        frmC.btnGuardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(validar()){
                    String nombre = frmC.txtNombre.getText();
                    String apellidoPaterno = frmC.txtApellidoPaterno.getText();
                    String apellidoMaterno = frmC.txtApellidoMaterno.getText();
                    int dni = Integer.parseInt(frmC.txtDni.getText());
                    int telefono = Integer.parseInt(frmC.txtTelefono.getText());
                    String ruc = frmC.txtRuc.getText();
                    String direccion = frmC.txtDireccion.getText();
                    clientes.agregarCliente(new Cliente(nombre, apellidoPaterno, apellidoMaterno, dni, ruc, telefono, direccion));
                    JOptionPane.showMessageDialog(frmC, "Cliente Agregado");
                }else{
                    JOptionPane.showMessageDialog(frmC, "Todos los campos son obligatorios");
                }
                limpiarControles();
            }
        });
        
        frmC.btnModificar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmClienteModificar frmCM = new frmClienteModificar();
                ControladorModificarCliente conMC = new ControladorModificarCliente(clientes, frmCM);
                conMC.iniciar();
                frmC.setVisible(false);
            }
        });
        
        frmC.btnEliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmClienteEliminar frmCE = new frmClienteEliminar();
                ControladorEliminarCliente conEC = new ControladorEliminarCliente(clientes, frmCE);
                conEC.iniciar();
                frmC.setVisible(false);
            }
        });
        
        frmC.btnSalir.addActionListener(new ActionListener(){
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
    }
    
    public void limpiarControles(){
        this.frmC.txtNombre.setText("");
        this.frmC.txtApellidoPaterno.setText("");
        this.frmC.txtApellidoMaterno.setText("");
        this.frmC.txtDni.setText("");
        this.frmC.txtTelefono.setText("");
        this.frmC.txtRuc.setText("");
        this.frmC.txtDireccion.setText("");
    }
    
    public boolean validar(){
        if(this.frmC.txtNombre.getText().length() != 0 &&
                this.frmC.txtApellidoPaterno.getText().length() != 0 &&
                this.frmC.txtApellidoMaterno.getText().length() != 0 &&
                this.frmC.txtDni.getText().length() != 0 &&
                this.frmC.txtTelefono.getText().length() != 0 &&
                this.frmC.txtRuc.getText().length() != 0 &&
                this.frmC.txtDireccion.getText().length() != 0){
            return true;
        }else{
            return false;
        }
    }
}
