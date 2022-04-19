
package Planilla;

import Cliente.Cliente;
import Carga.Carga;

/**
 *
 * @author 
 */
public class ArregloPlanilla {
    Planilla[] planillas;
    int indicePlanillas;
    int[] indiceClientes;
    int[] indiceCargas;
    private final String[] cabecera = {"DNI", "NOMBRE", "RUC", "TELÉFONO", "DIRECCIÓN"};
    
    public ArregloPlanilla(){
        this.indicePlanillas = 0;
        this.indiceClientes = new int[100];
        for(int i=0; i<100; i++){
            this.indiceClientes[i] = 0;
        }
        this.indiceCargas = new int[100];
        for(int i=0; i<100; i++){
            this.indiceCargas[i] = 0;
        }
        this.planillas = new Planilla[50];
    }
    
    public boolean estaVacio(){
        return this.indicePlanillas == 0;
    }
    
    public void agregarPlanilla(Planilla planilla){
        this.planillas[this.indicePlanillas] = planilla;
        this.indicePlanillas++;
    }
    
    public void agregarCliente(int codigo, Cliente cliente){
        for(int i=0; i<this.indicePlanillas; i++){
            if(planillas[i].getCodigo() == codigo){
                planillas[i].clientes[this.indiceClientes[i]] = cliente;
                this.indiceClientes[i]++;
            }
        }
    }
    
    public void agregarEncomienda(int codigo, Carga encomienda){
        for(int i=0; i<this.indicePlanillas; i++){
            if(planillas[i].getCodigo() == codigo){
                planillas[i].cargas[this.indiceCargas[i]] = encomienda;
                this.indiceCargas[i]++;
            }
        }
    }
    
    public Object[] getDatosCombo() {
        Object[] resultado = null;
        if(!estaVacio()){
            resultado = new Object[this.indicePlanillas];
            for(int i=0; i < this.indicePlanillas; i++){
                resultado[i] = this.planillas[i];
            }
        }
        return resultado;
    }

    public int codigoAleatorio() {
        int valor = 0;
        do{
            boolean encontrado = false;
            int random = (int) Math.floor(Math.random()*10000+10000);
            for(int i=0; i<this.indicePlanillas; i++){
                if(planillas[i].getCodigo() == random){
                    encontrado = true;
                }
            }
            if(encontrado == false){
                valor = random;
            }
        }while(valor == 0);
        return valor;
    }

    public Planilla recuperarPlanilla(int codigo) {
        Planilla encontrado = null;
        for(int i=0; i<this.indicePlanillas; i++){
            if(planillas[i].getCodigo() == codigo){
                encontrado = planillas[i];
            }
        }
        return encontrado;
    }

    public boolean buscarPorCodigo(int codigo) {
        boolean encontrado = false;
        for(int i=0; i<this.indicePlanillas; i++){
            if(planillas[i].getCodigo() == codigo){
                encontrado = true;
            }
        }
        return encontrado;
    }
    
    public String mostrarPlanilla(int codigo){
        String mostrar = "";
        for(int i=0; i<this.indicePlanillas; i++){
            if(planillas[i].getCodigo() == codigo){
                mostrar = "Planilla: "+planillas[i].toString()+
                        "\nCamión: "+planillas[i].getBus().toString()+
                        "\nChofer: "+planillas[i].getChofer().toString()+
                        "\nViaje: "+planillas[i].getViaje().toString()+
                        "\n# de cargas: "+this.indiceCargas[i];
            }
        }
        return mostrar;
    }

    public boolean buscarCliente(int dni) {
        boolean encontrado = false;
        for(int i=0; i<this.indicePlanillas; i++){
            for(int j=0; j<this.indiceClientes[i]; j++){
                if(planillas[i].clientes[j].getDni() == dni){
                    encontrado = true;
                }
            }
        }
        return encontrado;
    }
    
    public Object[][] obtenerDatos(int codigo){
        int i, contador = 0;
        for(i=0; i<this.indicePlanillas; i++){
            if(planillas[i].getCodigo() == codigo){
                contador = i;
            }
        }
        Object resultado[][] = new Object[this.indiceClientes[contador]][11];
        if(!estaVacio()){
            for(int j = 0; j< this.indiceClientes[contador]; i++){
                resultado[j][0] = this.planillas[contador].clientes[j].getDni();
                resultado[j][1] = this.planillas[contador].clientes[j].getNombre();
                resultado[j][2] = this.planillas[contador].clientes[j].getRuc();
                resultado[j][3] = this.planillas[contador].clientes[j].getTelefono();
                resultado[j][4] = this.planillas[contador].clientes[j].getDireccion();
            }
        }
        return resultado;
    }
    
    public String[] obtenerCabecera(){
        return cabecera;
    }
}
