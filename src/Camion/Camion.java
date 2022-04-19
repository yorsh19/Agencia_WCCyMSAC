
package Camion;

/**
 *
 * @author 
 */
public class Camion {
    String modelo;
    String ruc;
    int numAsientos;
    String placa;
    boolean enPlanilla;
    
    public Camion(String modelo, String ruc, int numAsientos, String placa){
        this.modelo = modelo;
        this.ruc = ruc;
        this.numAsientos = numAsientos;
        this.placa = placa.toUpperCase();
        this.enPlanilla = false;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getRuc() {
        return ruc;
    }
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    public int getNumAsientos() {
        return numAsientos;
    }
    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public boolean getEnPlanilla() {
        return enPlanilla;
    }
    public void setEnPlanilla(boolean enPlanilla) {
        this.enPlanilla = enPlanilla;
    }    
    
    @Override
    public String toString(){
        return  placa+" - "+modelo;
    }
    
}
