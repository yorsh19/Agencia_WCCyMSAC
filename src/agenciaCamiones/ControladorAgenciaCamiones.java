
package agenciaCamiones;

import Camion.ControladorCamion;
import Camion.frmCamion;
import Chofer.ControladorChofer;
import Chofer.frmChofer;
import Cliente.ControladorCliente;
import Cliente.frmCliente;
import Consultas.ControladorConsultas;
import Consultas.frmConsultas;
import Carga.ControladorCarga;
import Carga.frmCarga;
import Planilla.ControladorCrearPlanilla;
import Planilla.frmCrearPlanilla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Repositorio.Repositorio;
import Viaje.ControladorViaje;
import Viaje.frmViaje;

/**
 *
 * @author 
 */
public class ControladorAgenciaCamiones {
    frmAgenciaCamiones frmAB;
    
    public ControladorAgenciaCamiones(frmAgenciaCamiones frmAB){
        this.frmAB = frmAB;
        
        this.frmAB.btnClientes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmCliente frmC = new frmCliente();
                ControladorCliente conC = new ControladorCliente(Repositorio.clientes, frmC);
                conC.iniciar();
                frmAB.setVisible(false);
            }
        });
        
        this.frmAB.btnViajes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmViaje frmV = new frmViaje();
                ControladorViaje conV = new ControladorViaje(Repositorio.viajes, frmV);
                conV.iniciar();
                frmAB.setVisible(false);
            }
        });
        
        this.frmAB.btnConductores.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmChofer frmC = new frmChofer();
                ControladorChofer conC = new ControladorChofer(Repositorio.choferes, frmC);
                conC.iniciar();
                frmAB.setVisible(false);
            }
        });
        
        this.frmAB.btnCamiones.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmCamion frmB = new frmCamion();
                ControladorCamion conB = new ControladorCamion(Repositorio.camiones, frmB);
                conB.iniciar();
                frmAB.setVisible(false);
            }
        });
        
        this.frmAB.btnCargas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmCarga frmE = new frmCarga();
                ControladorCarga conE = new ControladorCarga(Repositorio.cargas, frmE);
                conE.iniciar();
                frmAB.setVisible(false);
            }
        });
        
        this.frmAB.btnPlanillas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmCrearPlanilla frmCP = new frmCrearPlanilla();
                ControladorCrearPlanilla conCP = new ControladorCrearPlanilla(Repositorio.planillas, frmCP);
                conCP.iniciar();
                frmAB.setVisible(false);
            }
        });
        
        this.frmAB.btnConsultas.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmConsultas frmC = new frmConsultas();
                ControladorConsultas conC = new ControladorConsultas(frmC);
                conC.iniciar();
                frmAB.setVisible(false);
            }
        });
    }
    
    public void iniciar(){
        this.frmAB.setVisible(true);
        this.frmAB.setLocationRelativeTo(null);
    }
}
