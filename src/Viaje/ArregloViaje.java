
package Viaje;

/**
 *
 * @author 
 */
public class ArregloViaje {
    Viaje[] viajes;
    int tamanho;
    int indice;
    private final String[] cabecera = {"ORIGEN", "DESTINO", "SALIDA", "LLEGADA","FECHA","CÓDIGO"};
    
    public ArregloViaje(){
        this.tamanho = 50;
        this.indice = 0;
        this.viajes = new Viaje[this.tamanho];
    }
    
    public void agregarViaje(Viaje viaje){
        viajes[this.indice]=viaje;
        this.indice++;
    }
    
    public boolean estaVacio(){
        return this.indice==0;
    }
    
    public Object[][] obtenerDatos(){
        Object resultado[][] = new Object[this.indice][11];
        if(!estaVacio()){
            for(int i = 0; i< this.indice; i++){
                resultado[i][0] = this.viajes[i].getOrigen();
                resultado[i][1] = this.viajes[i].getDestino();
                resultado[i][2] = this.viajes[i].getHoraSalida()+" HORAS";
                resultado[i][3] = this.viajes[i].getHoraLlegada()+" HORAS";
                resultado[i][4] = this.viajes[i].getFecha();
                resultado[i][5] = this.viajes[i].getCodigo();
            }
        }
        return resultado;
    }
    
    public String[] obtenerCabecera(){
        return cabecera;
    }

    public Viaje recuperarViaje(int codigo){
        Viaje encontrado=null;
        for(int i=0; i<this.indice; i++){
            if(viajes[i].getCodigo() == codigo){
                encontrado = viajes[i];
            }
        }
        return encontrado;
    }

    public void eliminarViaje(int codigo) {
        for(int i=0; i<this.indice; i++){
            if(viajes[i].getCodigo() == codigo){
                if(i==this.indice-1){
                    this.indice--;
                }else{
                    for(int j=i; j<this.indice-1; j++){
                        viajes[j] = viajes[j+1];
                    }
                    this.indice--;
                }
            }
        }
    }

    public int generarAleatorio(){
        int valor = 0;
        do{
            boolean encontrado = false;
            int random = (int) Math.floor(Math.random()*99+1);
            for(int i=0; i<this.indice; i++){
                if(viajes[i].getCodigo() == random){
                    encontrado = true;
                }
            }
            if(encontrado == false){
                valor = random;
            }
        }while(valor == 0);
        return valor;
    }
    
    public Object[] getDatosCombo() {
        Object[] resultado = null;
        int j = 0, contador=0;
        if(!estaVacio()){
            for(int i=0; i < this.indice; i++){
                if(viajes[i].getEnPlanilla() == false){
                    contador++;
                }
            }
            resultado = new Object[contador];
            for(int i=0; i < this.indice; i++){
                if(viajes[i].getEnPlanilla() == false){
                    resultado[j] = this.viajes[i];
                    j++;
                }
            }
        }
        return resultado;
    }
    
    public void activarEnPlanilla(int codigo){
        for(int i=0; i<this.indice; i++){
            if(viajes[i].getCodigo() == codigo){
                viajes[i].setEnPlanilla(true);
            }
        }
    }
}
