
package Carga;

/**
 *
 * @author 
 */
public class Nodo {
    Nodo siguiente;
    Carga encomienda;
    
    public Nodo(){
        this.siguiente = null;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    public Carga getEncomienda() {
        return encomienda;
    }
    public void setEncomienda(Carga encomienda) {
        this.encomienda = encomienda;
    }
}
