package quiosco;
public class Nodo<cliente> {
    //atributos de la clase
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
    
    //métodos set y get
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
