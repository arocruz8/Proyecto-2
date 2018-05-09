package quiosco;
public class Nodo extends cliente { 
    public Object elemento;
    public int prioridad;
    public Nodo sig;

    //constructores
    public Nodo(Object elemento, int prioridad, Nodo sig) {
        this.elemento = elemento;
        this.prioridad = prioridad;
        this.sig = sig;
    }

    public Nodo(){
    }

    //setter and getters
    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }     
    
}
