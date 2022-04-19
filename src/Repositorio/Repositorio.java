
package Repositorio;

import Camion.ArregloCamion;
import Chofer.ListaDobleChofer;
import Cliente.ListaCliente;
import Carga.ListaCarga;
import Planilla.ArregloPlanilla;
import Viaje.ArregloViaje;

/**
 *
 * @author 
 */
public class Repositorio {
    public static ListaCliente clientes = new ListaCliente();
    public static ArregloViaje viajes = new ArregloViaje();
    public static ListaDobleChofer choferes = new ListaDobleChofer();
    public static ArregloCamion camiones = new ArregloCamion();
    public static ArregloPlanilla planillas = new ArregloPlanilla();
    public static ListaCarga cargas = new ListaCarga();
}
