
package Camion;

/**
 *
 * @author 
 */
public class ArregloCamion {
    Camion[] camiones;
    int indice;
    int tamanho;
    private final String[] cabecera = {"MODELO", "PLACA", "RUC", "AS. DISP."};
    
    public ArregloCamion(){
        this.indice = 0;
        this.tamanho = 50;
        this.camiones = new Camion[this.tamanho];
    }
    
    public void agregarCamion(Camion camion){
        camiones[this.indice] = camion;
        this.indice++;
    }
    
    public boolean estaVacio(){
        return this.indice==0;
    }
    
    public Object[][] obtenerDatos(){
        Object resultado[][] = new Object[this.indice][11];
        if(!estaVacio()){
            for(int i = 0; i< this.indice; i++){
                resultado[i][0] = this.camiones[i].getModelo();
                resultado[i][1] = this.camiones[i].getPlaca();
                resultado[i][2] = this.camiones[i].getRuc();
                resultado[i][3] = this.camiones[i].getNumAsientos();
            }
        }
        return resultado;
    }
    
    public String[] obtenerCabecera(){
        return cabecera;
    }
    
    public Camion recuperarCamion(String placa){
        Camion encontrado = null;
        for(int i=0; i<this.indice; i++){
            if(camiones[i].getPlaca().equals(placa)){
                encontrado = camiones[i];
            }
        }
        return encontrado;
    }

    public void eliminarCamion(String placa) {
        for(int i=0; i<this.indice; i++){
            if(camiones[i].getPlaca().equals(placa)){
                if(i == this.indice-1){
                    this.indice--;
                }else{
                    for(int j=i; j<this.indice-1; j++){
                        camiones[j] = camiones[j+1];
                    }
                    this.indice--;
                }
            }
        }
    }
    
    public Object[] getDatosCombo() {
        Object[] resultado = null;
        int j = 0, contador = 0;
        if(!estaVacio()){
            for(int i=0; i<this.indice; i++){
                if(camiones[i].getEnPlanilla() == false){
                    contador++;
                }
            }
            resultado = new Object[contador];
            for(int i=0; i < this.indice;i++){
                if(camiones[i].getEnPlanilla() == false){
                    resultado[j] = this.camiones[i];
                    j++;
                }
            }
        }
        return resultado;
    }
    
    public void activarEnPlanilla(String placa){
        for(int i=0; i<this.indice; i++){
            if(camiones[i].getPlaca().equals(placa)){
                camiones[i].setEnPlanilla(true);
            }
        }
    }
}
