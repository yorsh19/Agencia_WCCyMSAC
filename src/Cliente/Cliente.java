
package Cliente;

/**
 *
 * @author 
 */
public class Cliente {
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    int dni;
    String ruc;
    int telefono;
    String direccion;
    boolean asientoReservado;
    
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, int dni, String ruc, int telefono, String direccion){
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.dni = dni;
        this.ruc = ruc;
        this.telefono = telefono;
        this.direccion = direccion;
        this.asientoReservado = false;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public String getRuc() {
        return ruc;
    }
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public boolean getAsientoReservado() {
        return asientoReservado;
    }
    public void setAsientoReservado(boolean asientoReservado) {
        this.asientoReservado = asientoReservado;
    }    
    
}
