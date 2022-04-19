
package Consultas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Repositorio.Repositorio;
import agenciaCamiones.ControladorAgenciaCamiones;
import agenciaCamiones.frmAgenciaCamiones;

/**
 *
 * @author 
 */
public class ControladorConsultas {
    frmConsultas frmC;
    
    public ControladorConsultas(frmConsultas frmC){
        this.frmC = frmC;
        
        this.frmC.btnBuscarCliente.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmBuscarCliente frmBC = new frmBuscarCliente();
                ControladorBuscarCliente conBC = new ControladorBuscarCliente(Repositorio.clientes, frmBC);
                conBC.iniciar();
                frmC.setVisible(false);
            }
        });
        
        this.frmC.btnBuscarEncomienda.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmBuscarCarga frmBE = new frmBuscarCarga();
                ControladorBuscarCarga conBE = new ControladorBuscarCarga(frmBE);
                conBE.iniciar();
                frmC.setVisible(false);
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
    }
}
