
package estructurasDatos;
public class Nodo<cliente> {
    //atributos
    private cliente dato;
    private Nodo<cliente> prioridad;
    private Nodo<cliente> siguiente;
    
    //constructores
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
    
   //setter and getter
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
    
    public void setPrioridad(Nodo<cliente> prioridad){
        this.prioridad=prioridad;
    }
    
    public Nodo<cliente> getPrioriddad(){
        return prioridad;
    }
         
}
