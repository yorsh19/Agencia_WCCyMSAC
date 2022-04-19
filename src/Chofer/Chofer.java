
package Chofer;

/**
 *
 * @author 
 */
public class Chofer {
    String nombre;
    int dni;
    String brevete;
    boolean enPlanilla;
    
    public Chofer(String nombre, int dni, String brevete){
        this.nombre = nombre;
        this.brevete = brevete;
        this.dni = dni;
        this.enPlanilla = false;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public String getBrevete() {
        return brevete;
    }
    public void setBrevete(String brevete) {
        this.brevete = brevete;
    }
    public boolean getEnPlanilla() {
        return enPlanilla;
    }
    public void setEnPlanilla(boolean enPlanilla) {
        this.enPlanilla = enPlanilla;
    }
    
    @Override
    public String toString(){
        return nombre+" / "+brevete;
    }
}
