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
public class ControladorModificarCliente {
    ListaCliente clientes;
    frmClienteModificar frmCM;
    
    public ControladorModificarCliente(ListaCliente clientes, frmClienteModificar frmCM){
        this.clientes = clientes;
        this.frmCM = frmCM;
        
        this.frmCM.btnBuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(frmCM.txtDniBuscar.getText().length() != 0){
                    int dniBuscar = Integer.parseInt(frmCM.txtDniBuscar.getText());
                    if(clientes.buscarDni(dniBuscar)){
                        JOptionPane.showMessageDialog(frmCM, "Cliente encontrado");
                        Cliente encontrado = clientes.recuperarCliente(dniBuscar);
                        frmCM.txtNombre.setText(encontrado.getNombre());
                        frmCM.txtApellidoPaterno.setText(encontrado.getApellidoPaterno());
                        frmCM.txtApellidoMaterno.setText(encontrado.getApellidoMaterno());
                        frmCM.txtDni.setText(String.valueOf(encontrado.getDni()));
                        frmCM.txtTelefono.setText(String.valueOf(encontrado.getTelefono()));
                        frmCM.txtRuc.setText(encontrado.getRuc());
                        frmCM.txtDireccion.setText(encontrado.getDireccion());
                        frmCM.btnModificar.setEnabled(true);
                        frmCM.txtDniBuscar.setEnabled(false);
                    }else{
                        JOptionPane.showMessageDialog(frmCM, "El cliente no se encuentra en la lista");
                        frmCM.txtDniBuscar.setText("");
                        limpiarControles();
                    }
                }else{
                    JOptionPane.showMessageDialog(frmCM, "El campo `Ingrese Dni` es  obligatorio completar");
                    limpiarControles();
                }
            }
        });
        
        this.frmCM.btnModificar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(validar()){
                    int dniBuscar = Integer.parseInt(frmCM.txtDniBuscar.getText());
                    Cliente encontrado = clientes.recuperarCliente(dniBuscar);
                    encontrado.setNombre(frmCM.txtNombre.getText());
                    encontrado.setApellidoPaterno(frmCM.txtApellidoPaterno.getText());
                    encontrado.setApellidoMaterno(frmCM.txtApellidoMaterno.getText());
                    encontrado.setDni(Integer.parseInt(frmCM.txtDni.getText()));
                    encontrado.setTelefono(Integer.parseInt(frmCM.txtTelefono.getText()));
                    encontrado.setRuc(frmCM.txtRuc.getText());
                    encontrado.setDireccion(frmCM.txtDireccion.getText());
                    JOptionPane.showMessageDialog(frmCM, "Cliente Modificado");
                    frmCliente frmC = new frmCliente();
                    ControladorCliente conC = new ControladorCliente(clientes, frmC);
                    conC.iniciar();
                    frmCM.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(frmCM, "Todos los campos son obligatorios");
                }
            }
        });
        
        this.frmCM.btnCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmCliente frmC = new frmCliente();
                ControladorCliente conC = new ControladorCliente(clientes, frmC);
                conC.iniciar();
                frmCM.setVisible(false);
            }
        });
    }
    
    public void iniciar(){
        this.frmCM.setVisible(true);
        this.frmCM.setLocationRelativeTo(null);
        this.frmCM.btnModificar.setEnabled(false);
    }
    
    public boolean validar(){
        if(this.frmCM.txtNombre.getText().length() != 0 &&
                this.frmCM.txtApellidoPaterno.getText().length() != 0 &&
                this.frmCM.txtApellidoMaterno.getText().length() != 0 &&
                this.frmCM.txtDni.getText().length() != 0 &&
                this.frmCM.txtTelefono.getText().length() != 0 &&
                this.frmCM.txtRuc.getText().length() != 0 &&
                this.frmCM.txtDireccion.getText().length() != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public void limpiarControles(){
        this.frmCM.txtNombre.setText("");
        this.frmCM.txtApellidoPaterno.setText("");
        this.frmCM.txtApellidoMaterno.setText("");
        this.frmCM.txtDni.setText("");
        this.frmCM.txtTelefono.setText("");
        this.frmCM.txtRuc.setText("");
        this.frmCM.txtDireccion.setText("");
    }
}
