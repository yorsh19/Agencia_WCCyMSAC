
package Carga;

/**
 *
 * @author 
 */
public class ListaCarga {
    Nodo inicio, ultimo;
    int tamanho;
    
    public ListaCarga(){
        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }
    
    public boolean listaVacia(){
        return inicio==null;
    }
    
    public void agregarEncomienda(Carga encomienda){
        Nodo nuevo = new Nodo();
        nuevo.setEncomienda(encomienda);
        if(listaVacia()){
            inicio = nuevo;
            ultimo = nuevo;
        }else{
            nuevo.siguiente = inicio;
            inicio = nuevo;
        }
        this.tamanho++;
    }
    
   public int codigoAleatorio(){
        Nodo recorrido = inicio;
        int valor = 0;
        do{
            boolean encontrado = false;
            int random = (int) Math.floor(Math.random()*999+99);
            while(recorrido != null){
                if(recorrido.getEncomienda().getCodigo() == random){
                    encontrado = true;
                }
                recorrido = recorrido.getSiguiente();
            }
            if(encontrado == false){
                valor = random;
            }
        }while(valor == 0);
        return valor;
    }
   
   public Carga recuperarEncomienda(int codigo){
       Carga recuperado = null;
       Nodo recorrido = inicio;
       while(recorrido != null){
           if(recorrido.encomienda.getCodigo() == codigo){
               recuperado = recorrido.encomienda;
           }
           recorrido = recorrido.getSiguiente();
       }
       return recuperado;
   }
   
   public boolean buscarEncomienda(int dni){
       boolean encontrado = false;
       Nodo recorrido = inicio;
       while(recorrido != null){
           if(recorrido.encomienda.getDniDestinatario() == dni || recorrido.encomienda.getDniRemitente() == dni){
               encontrado = true;
           }
           recorrido = recorrido.getSiguiente();
       }
       return encontrado;
   }

    public String mostrarEncomiendas(int dni) {
        String mostrar = "";
        Nodo recorrido = inicio;
       while(recorrido != null){
           if(recorrido.encomienda.getDniDestinatario() == dni || recorrido.encomienda.getDniRemitente() == dni){
               mostrar = mostrar +"Remitente: "+recorrido.encomienda.getRemitente()+
                       "\nDestinatario: "+recorrido.encomienda.getDestinatario()+
                       "\nDescripción: "+recorrido.encomienda.getDescripcion()+
                       "\nCódigo: "+recorrido.encomienda.getCodigo()+"\n\n";
           }
           recorrido = recorrido.getSiguiente();
       }
        return mostrar;
    }
}
