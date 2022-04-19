
package agenciaCamiones;

import Camion.Camion;
import Repositorio.Repositorio;
import Viaje.*;
import Chofer.*;

/**
 *
 * @author 
 */
public class AgenciaCamiones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        crearCamiones();
        crearChoferes();
        crearViajes();
        
        
        frmAgenciaCamiones frmAB = new frmAgenciaCamiones();
        ControladorAgenciaCamiones conAB = new ControladorAgenciaCamiones(frmAB);
        conAB.iniciar();
    } 
    
    private static void crearCamiones(){
        Repositorio.camiones.agregarCamion(new Camion("Toyota","13254654561",50,"F6T4E5"));
        Repositorio.camiones.agregarCamion(new Camion("Hyundai","16497845132",40,"897I6I"));
        Repositorio.camiones.agregarCamion(new Camion("Mitsubishi","16548932164",45,"84D7H6"));
        Repositorio.camiones.agregarCamion(new Camion("JAC","12346798465",55,"DFR5W7"));
        Repositorio.camiones.agregarCamion(new Camion("Volvo","12348789465",60,"GFD8D2"));
    }
    
    private static void crearChoferes(){
        Repositorio.choferes.agregarAlInicio(new Chofer("Héctor",76817816,"A-IIIa"));
        Repositorio.choferes.agregarAlInicio(new Chofer("Rafael",15648978,"A-IIb"));
        Repositorio.choferes.agregarAlInicio(new Chofer("Javier",32468714,"A-IIIb"));
        Repositorio.choferes.agregarAlInicio(new Chofer("Juan",65489123,"A-I"));
        Repositorio.choferes.agregarAlInicio(new Chofer("Nicole",54781265,"A-IIa"));
    }
    
    private static void crearViajes(){
        Repositorio.viajes.agregarViaje(new Viaje("Lima","Cusco",35));
        Repositorio.viajes.agregarViaje(new Viaje("Lima","Piura",45));
        Repositorio.viajes.agregarViaje(new Viaje("Piura","Tacna",22));
        Repositorio.viajes.agregarViaje(new Viaje("Arequipa","Lima",11));
        Repositorio.viajes.agregarViaje(new Viaje("Chiclayo","Huancayo",33));
    }
}
