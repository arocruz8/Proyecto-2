package quiosco;
/*public class Nodo extends cliente { 
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
    
}*/


public class Nodo<cliente> {
    private cliente dato;
    private int prioridad;
    private Nodo<cliente> anterior;
    private Nodo<cliente> siguiente;
    
    //constructor
    public Nodo(int prioridad, cliente dato){
        //this.dato = dato;
        this.prioridad = prioridad;
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
    
    public void serPrioridad(int prioridad){
        this.prioridad=prioridad;    
    }
    
    public int getPrioridad(){
        return this.prioridad;
    }
    
    public cliente getDato(){  
        return this.dato;
    }
    
    public void setDato(cliente dato){   
        this.dato = dato;
    }
    
    public Nodo<cliente> getAnterior(){  
        return this.anterior;
    }
    
    public void setAnterior(Nodo<cliente> anterior){  
        this.anterior = anterior;
    }
    
    public Nodo<cliente> getSiguiente() {
        return this.siguiente;
    }
    
    public void setSiguiente(Nodo<cliente> siguiente) {
        this.siguiente = siguiente;
    }
    

}
