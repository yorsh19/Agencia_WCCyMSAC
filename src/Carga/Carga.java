
package Carga;

/**
 *
 * @author 
 */
public class Carga {
    String remitente;
    String descripcion;
    int dniRemitente;
    String destinatario;
    int dniDestinatario;
    int codigo;
    
    public Carga(String remitente, int dniRemitente, String destinatario, int dniDestinatario, String descripcion, int codigo){
        this.remitente = remitente;
        this.dniRemitente = dniRemitente;
        this.destinatario = destinatario;
        this.dniDestinatario = dniDestinatario;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    public String getRemitente() {
        return remitente;
    }
    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getDniRemitente() {
        return dniRemitente;
    }
    public void setDniRemitente(int dniRemitente) {
        this.dniRemitente = dniRemitente;
    }
    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    public int getDniDestinatario() {
        return dniDestinatario;
    }
    public void setDniDestinatario(int dniDestinatario) {
        this.dniDestinatario = dniDestinatario;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
}
