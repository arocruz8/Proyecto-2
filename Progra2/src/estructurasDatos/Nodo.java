
package estructurasDatos;
/*
public class Nodo {
    Object dato;
    Nodo next;
    String prioridad;
    
    public Nodo(Object dato){
        this.dato=dato;
        this.next=null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
    
    public String getPrioridad(){
        return prioridad;
    }
    
    public void setPrioridad(String prioridad){
        this.prioridad=prioridad;
    }
}*/

public class Nodo<T> {
    
    private T dato;
    private Nodo<T> siguiente;

    public Nodo(){
        siguiente=null;
     }
    public Nodo(T p){
        siguiente=null;
        dato = p;
    }  
    public Nodo(T t, Nodo<T> siguiente){
        this.siguiente=siguiente;
        dato = t;
    }     
    public T getDato() {
        return dato;
    } 
    public void setDato(T dato) {
        this.dato = dato;
    }
    public Nodo<T> getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }     
}
