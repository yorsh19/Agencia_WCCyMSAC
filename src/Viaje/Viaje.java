
package Viaje;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 
 */
public class Viaje {
    String origen;
    String destino;
    int horaSalida;
    int horaLlegada;
    String fecha;
    int codigo;
    boolean enPlanilla;
    
    public Viaje(String origen, String destino, int codigo){
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = (int) Math.floor(Math.random()*23);
        this.horaLlegada = definirLlegada();
        this.fecha = definirFecha();
        this.codigo = codigo;
        this.enPlanilla = false;
    }

    public String getOrigen() {
        return origen;
    }
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getHoraSalida() {
        return horaSalida;
    }
    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }
    public int getHoraLlegada() {
        return horaLlegada;
    }
    public void setHoraLlegada(int horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public boolean getEnPlanilla() {
        return enPlanilla;
    }
    public void setEnPlanilla(boolean enPlanilla) {
        this.enPlanilla = enPlanilla;
    }    
    
    public String definirFecha(){
        Date fecha = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        return sdf.format(fecha);
    }
    
    public int definirLlegada(){
        int llegada = this.horaSalida + (int) Math.floor(Math.random()*5+3);
        if(llegada>24){
            llegada = llegada - 24;
            return llegada;
        }else{
            return llegada;
        }
    }
    
    @Override
    public String toString(){
        return  origen+" - "+destino;
    }
}
