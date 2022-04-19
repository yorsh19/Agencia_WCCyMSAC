
package Planilla;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class ControladorImprimirPlanilla {
    frmImprimirPlanilla frmIP;
    ArregloPlanilla planillas;
    
    public ControladorImprimirPlanilla(ArregloPlanilla planillas, frmImprimirPlanilla frmIP){
        this.planillas = planillas;
        this.frmIP = frmIP;
        
        this.frmIP.btnBuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(validar()){
                    int codigo = Integer.parseInt(frmIP.txtCodigoBuscar.getText());
                    if(planillas.buscarPorCodigo(codigo)){
                        JOptionPane.showMessageDialog(frmIP, "Planilla encontrada");
                        frmIP.txtAreaPlanilla.setText(planillas.mostrarPlanilla(codigo));
                    }else{
                        JOptionPane.showMessageDialog(frmIP, "Código incorrecto");
                    }
                }else{
                    JOptionPane.showMessageDialog(frmIP, "Ingrese el código a buscar");
                }
                limpiarControles();
            }
        });
        
        this.frmIP.btnSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frmCrearPlanilla frmCP = new frmCrearPlanilla();
                ControladorCrearPlanilla conCP = new ControladorCrearPlanilla(planillas, frmCP);
                conCP.iniciar();
                frmIP.setVisible(false);
            }
        });
    }
    
    public void iniciar(){
        this.frmIP.setVisible(true);
        this.frmIP.setLocationRelativeTo(null);
    }
    
    public boolean validar(){
        if(this.frmIP.txtCodigoBuscar.getText().length() != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public void limpiarControles(){
        this.frmIP.txtCodigoBuscar.setText("");
    }
}
