
package Chofer;

/**
 *
 * @author 
 */
public class NodoDoble {
    NodoDoble anterior, siguiente;
    Chofer chofer;
    
    public NodoDoble(Chofer chofer, NodoDoble siguiente, NodoDoble anterior){
        this.siguiente = siguiente;
        this.anterior = anterior;
        this.chofer = chofer;
    }
    public NodoDoble(Chofer chofer){
        this(chofer,null,null);
    }

    public NodoDoble() {
    }

    public NodoDoble getAnterior() {
        return anterior;
    }
    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
    public NodoDoble getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
    public Chofer getChofer() {
        return chofer;
    }
    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }
}
