
package Planilla;

import Camion.Camion;
import Viaje.Viaje;
import Chofer.Chofer;
import Cliente.Cliente;
import Carga.Carga;

/**
 *
 * @author 
 */
public class Planilla {
    Camion camion;
    Chofer chofer;
    Viaje viaje;
    int codigo;
    Cliente[] clientes;
    Carga[] cargas;
    
    public Planilla(Camion camion, Chofer chofer, Viaje viaje, int codigo){
        this.viaje = viaje;
        this.chofer = chofer;
        this.camion = camion;
        this.codigo = codigo;
        this.clientes = new Cliente[100];
        this.cargas = new Carga[100];
    }

    public Camion getBus() {
        return camion;
    }
    public void setBus(Camion bus) {
        this.camion = bus;
    }
    public Chofer getChofer() {
        return chofer;
    }
    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }
    public Viaje getViaje() {
        return viaje;
    }
    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Carga[] getCargas() {
        return cargas;
    }
    public void setCargas(Carga[] cargas) {
        this.cargas = cargas;
    }   
    public Cliente[] getClientes() {
        return clientes;
    }
    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }
    
    @Override
    public String toString(){
        return "#"+codigo;
    }

}
