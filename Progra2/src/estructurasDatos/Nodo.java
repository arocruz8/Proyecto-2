package estructurasDatos;
public class Nodo<cliente> {
    
    private cliente dato;
    private Nodo<cliente> siguiente;

    public Nodo(){
        siguiente=null;
     }
    public Nodo(cliente p){
        siguiente=null;
        dato = p;
    }  
    public Nodo(cliente t, Nodo<cliente> siguiente){
        this.siguiente=siguiente;
        dato = t;
    }     
    public cliente getDato() {
        return dato;
    } 
    public void setDato(cliente dato) {
        this.dato = dato;
    }
    public Nodo<cliente> getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo<cliente> siguiente) {
        this.siguiente = siguiente;
    }     
}