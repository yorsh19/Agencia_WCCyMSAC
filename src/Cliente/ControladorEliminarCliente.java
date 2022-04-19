/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author D&J GODS PC
 */
public class ControladorEliminarCliente {
    ListaCliente clientes;
    frmClienteEliminar frmCE;
    
    public ControladorEliminarCliente(ListaCliente clientes, frmClienteEliminar frmCE){
        this.clientes = clientes;
        this.frmCE = frmCE;
        
        this.frmCE.btnBuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(frmCE.txtDniBuscar.getText().length() != 0){
                    int dniBuscar = Integer.parseInt(frmCE.txtDniBuscar.getText());
                    if(clientes.buscarDni(dniBuscar)){
                        JOptionPane.showMessageDialog(frmCE, "Cliente encontrado");
                        Cliente encontrado = clientes.recuperarCliente(dniBuscar);
                        frmCE.lblClienteNombre.setText(encontrado.getNombre());
                        frmCE.lblClienteApellidoPaterno.setText(encontrado.getApellidoPaterno());
                        frmCE.lblClienteApellidoMaterno.setText(encontrado.getApellidoMaterno());
                        frmCE.lblClienteDni.setText(String.valueOf(encontrado.getDni()));
                        frmCE.lblClienteTelefono.setText(String.valueOf(encontrado.getTelefono()));
                        frmCE.lblClienteRuc.setText(encontrado.getRuc());
                        frmCE.lblClienteDireccion.setText(encontrado.getDireccion());
                        frmCE.btnEliminar.setEnabled(true);
                        frmCE.txtDniBuscar.setEnabled(false);
                    }else{
                        JOptionPane.showMessageDialog(frmCE, "El cliente no se encuentra en la lista");
                        frmCE.txtDniBuscar.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(frmCE, "El campo `Ingrese Dni` es  obligatorio completar");
                }
            }
        });
        
        this.frmCE.btnEliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                int dniBuscar = Integer.parseInt(frmCE.txtDniBuscar.getText());
                clientes.eliminarCliente(dniBuscar);
                JOptionPane.showMessageDialog(frmCE, "Cliente eliminado");
                frmCliente frmC = new frmCliente();
                ControladorCliente conC = new ControladorCliente(clientes, frmC);
                conC.iniciar();
                frmCE.setVisible(false);
            }
        });
        
        this.frmCE.btnCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmCliente frmC = new frmCliente();
                ControladorCliente conC = new ControladorCliente(clientes, frmC);
                conC.iniciar();
                frmCE.setVisible(false);
            }
        });
    }
    
    public void iniciar(){
        this.frmCE.setVisible(true);
        this.frmCE.setLocationRelativeTo(null);
        this.frmCE.btnEliminar.setEnabled(false);
        limpiarControles();
    }
    
    public void limpiarControles(){
        this.frmCE.lblClienteApellidoMaterno.setText("");
        this.frmCE.lblClienteApellidoPaterno.setText("");
        this.frmCE.lblClienteDireccion.setText("");
        this.frmCE.lblClienteDni.setText("");
        this.frmCE.lblClienteNombre.setText("");
        this.frmCE.lblClienteRuc.setText("");
        this.frmCE.lblClienteTelefono.setText("");
    }
}
