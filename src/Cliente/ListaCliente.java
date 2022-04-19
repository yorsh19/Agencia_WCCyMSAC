/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;


/**
 *
 * @author D&J GODS PC
 */
public class ListaCliente {
    Nodo inicio, ultimo;
    int tamanho;
    private final String[] cabecera = {"DNI", "NOMBRE", "RUC", "TELÉFONO", "DIRECCIÓN"};
    
    public ListaCliente(){
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }
    
    public boolean listaVacia(){
        return inicio==null;
    }
    
    public void agregarCliente(Cliente cliente){
        Nodo nuevo = new Nodo();
        nuevo.setCliente(cliente);
        if(listaVacia()){
            inicio = nuevo;
            ultimo = nuevo;
        }else{
            nuevo.siguiente = inicio;
            inicio = nuevo;
        }
        this.tamanho++;
    }

    public boolean buscarDni(int dni) {
        Nodo recorrido = inicio;
        boolean encontrado = false;
        if(!listaVacia()){
            while(recorrido != null){
                if(recorrido.cliente.getDni() == dni){
                    encontrado = true;
                }
                recorrido = recorrido.siguiente;
            }
        }
        return encontrado;
    }

    public Cliente recuperarCliente(int dni) {
        Cliente encontrado = null;
        Nodo recorrido = inicio;
        if(!listaVacia()){
            while(recorrido != null){
                if(recorrido.cliente.getDni() == dni){
                    encontrado = recorrido.cliente;
                }
                recorrido = recorrido.siguiente;
            }
        }
        return encontrado;
    }

    public void eliminarCliente(int dni) {
        Nodo recorrido = inicio;
        Nodo auxiliar = new Nodo();
        int band = 1;
        while((!(recorrido.cliente.getDni() == dni)) && (band == 1)){
            if(recorrido.siguiente != null){
                auxiliar = recorrido;
            }else{
                band = 0;
            }
            recorrido =  recorrido.siguiente;
        }
        if(band == 0){
            //El elemento no existe
        }else{
            if(inicio == recorrido){
                inicio = recorrido.siguiente;
            }else{
                auxiliar.siguiente = recorrido.siguiente;
            }
        }
    }
    
    public Object[][] obtenerDatos(){
        int contador = 0;
        Nodo recorrido = inicio;
        while(recorrido != null){
            if(recorrido.cliente.getAsientoReservado() == false){
                contador++;
            }
            recorrido = recorrido.getSiguiente();
        }
        Object resultado[][] = new Object[contador][10];
        int i=0;
        Nodo aux = inicio;
        while(aux != null){
            if(aux.cliente.getAsientoReservado() == false){
                resultado[i][0] = aux.cliente.getDni();
                resultado[i][1] = aux.cliente.getNombre();
                resultado[i][2] = aux.cliente.getRuc();
                resultado[i][3] = aux.cliente.getTelefono();
                resultado[i][4] = aux.cliente.getDireccion();
                i++;
            }
            aux = aux.getSiguiente();
        }
        return resultado;
    }
    
    public String[] obtenerCabecera(){
        return cabecera;
    }
    
    public void activarAsientoReservado(int dni){
        Nodo recorrido = inicio;
        if(!listaVacia()){
            while(recorrido != null){
                if(recorrido.cliente.getDni() == dni){
                    recorrido.cliente.setAsientoReservado(true);
                }
                recorrido = recorrido.getSiguiente();
            }
        }
    }
}
