
package Consultas;

import Cliente.Cliente;
import Cliente.ListaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class ControladorBuscarCliente {
    frmBuscarCliente  frmBC;
    ListaCliente clientes;
    
    public ControladorBuscarCliente(ListaCliente clientes, frmBuscarCliente frmBC){
        this.clientes = clientes;
        this.frmBC = frmBC;
        
        this.frmBC.btnBuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(frmBC.txtDniBuscar.getText().length() != 0){
                    int dniBuscar = Integer.parseInt(frmBC.txtDniBuscar.getText());
                    if(clientes.buscarDni(dniBuscar)){
                        JOptionPane.showMessageDialog(frmBC, "Cliente encontrado");
                        Cliente encontrado = clientes.recuperarCliente(dniBuscar);
                        frmBC.lblClienteNombre.setText(encontrado.getNombre());
                        frmBC.lblClienteApellidoPaterno.setText(encontrado.getApellidoPaterno());
                        frmBC.lblClienteApellidoMaterno.setText(encontrado.getApellidoMaterno());
                        frmBC.lblClienteDni.setText(String.valueOf(encontrado.getDni()));
                        frmBC.lblClienteTelefono.setText(String.valueOf(encontrado.getTelefono()));
                        frmBC.lblClienteRuc.setText(encontrado.getRuc());
                        frmBC.lblClienteDireccion.setText(encontrado.getDireccion());
                    }else{
                        JOptionPane.showMessageDialog(frmBC, "El cliente no se encuentra en la lista");
                        frmBC.txtDniBuscar.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(frmBC, "El campo `Ingrese Dni` es  obligatorio completar");
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
                frmBC.setVisible(false);
            }
        });
        
    }
    
    public void iniciar(){
        this.frmBC.setVisible(true);
        this.frmBC.setLocationRelativeTo(null);
        limpiarControles();
    }
    
    public void limpiarControles(){
        this.frmBC.lblClienteApellidoMaterno.setText("");
        this.frmBC.lblClienteApellidoPaterno.setText("");
        this.frmBC.lblClienteDireccion.setText("");
        this.frmBC.lblClienteDni.setText("");
        this.frmBC.lblClienteNombre.setText("");
        this.frmBC.lblClienteRuc.setText("");
        this.frmBC.lblClienteTelefono.setText("");
        this.frmBC.txtDniBuscar.setText("");
    }

}
