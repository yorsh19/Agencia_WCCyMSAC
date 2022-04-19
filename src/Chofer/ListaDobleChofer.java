
package Chofer;

/**
 *
 * @author 
 */
public class ListaDobleChofer {
    private NodoDoble inicio, fin;
    int tamanho;
    private final String[] cabecera = {"DNI", "NOMBRE", "BREVETE"};
    
    public ListaDobleChofer(){
        inicio=fin=null;
    }
    
    public boolean vacia(){
        return inicio==null;
    }
    
    public void agregarAlFinal(Chofer chofer){
        if(!vacia()){
            fin=new NodoDoble(chofer, null, fin);
            fin.anterior.siguiente=fin;
        }
        else{
            inicio=fin=new NodoDoble(chofer);
        }
        this.tamanho++;
    }
    
    public void agregarAlInicio(Chofer chofer){
        if(!vacia()){
            inicio=new NodoDoble(chofer, inicio, null);
            inicio.siguiente.anterior=inicio;
        }
        else{
            inicio=fin=new NodoDoble(chofer);
        }
        this.tamanho++;
    }
    
    public Object[][] obtenerDatos(){
        Object resultado[][] = new Object[this.tamanho][10];
        int i=0;
        NodoDoble aux = inicio;
        while(aux != null){
            resultado[i][0] = aux.chofer.getDni();
            resultado[i][1] = aux.chofer.getNombre();
            resultado[i][2] = aux.chofer.getBrevete();
            i++;
            aux = aux.getSiguiente();
        }
        return resultado;
    }
    
    public String[] obtenerCabecera(){
        return cabecera;
    }

    public Chofer recuperarChofer(int dni) {
        NodoDoble recorrido = inicio;
        Chofer encontrado = null;
        while(recorrido != null){
            if(recorrido.chofer.getDni() == dni){
                encontrado = recorrido.chofer;
            }
            recorrido = recorrido.siguiente;
        }
        return encontrado;
    }

    public void eliminarChofer(int dni) {
        NodoDoble recorrido = inicio;
        NodoDoble auxiliar = new NodoDoble();
        int band = 1;
        while((!(recorrido.chofer.getDni() == dni)) && (band == 1)){
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
        this.tamanho--;
    }
    
    public Object[] getDatosCombo(){
        Object[] resultado = null;
        int contador = 0;
        if(!vacia()){
            NodoDoble auxiliar = inicio;
            while(auxiliar != null){
                if(auxiliar.chofer.getEnPlanilla() == false){
                    contador++;
                }
                auxiliar = auxiliar.getSiguiente();
            }
            resultado = new Object[contador];
            NodoDoble recorrido = inicio;
            int i = 0;
            while(recorrido != null){
                if(recorrido.chofer.getEnPlanilla() == false){
                    resultado[i] = recorrido.getChofer();
                    i++;
                }
                recorrido = recorrido.getSiguiente();
            }
        }
        return resultado;
    }
    
    public void activarEnPlanilla(int dni){
        NodoDoble recorrido = inicio;
        if(!vacia()){
            while(recorrido != null){
                if(recorrido.chofer.getDni() == dni){
                    recorrido.chofer.setEnPlanilla(true);
                }
                recorrido = recorrido.getSiguiente();
            }
        }
    }
}
