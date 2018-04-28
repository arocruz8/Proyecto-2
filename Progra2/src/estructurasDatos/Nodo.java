
package estructurasDatos;
public class Nodo {
    Object dato;
    Nodo next;
    
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
    
    
}
