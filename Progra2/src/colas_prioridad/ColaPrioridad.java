package colas_prioridad;
public class ColaPrioridad extends cliente{
    private class Nodo extends cliente{
        public Object elemento;
        public int prioridad;
        public Nodo sig;
        
        //constructores
        public Nodo(Object elemento, int prioridad, Nodo sig) {
            this.elemento = elemento;
            this.prioridad = prioridad;
            this.sig = sig;
        }

        public Nodo() {
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
    
    //atributos clase cola de prioridad
    private Nodo cola;
    
    //construcotres
    public ColaPrioridad() {
        cola = new Nodo();
        cola.sig = null;
    }
    
    //vacia
    public boolean vacia() {
        return (cola.sig==null);
    } 
    
    //obtiene el primer elemento de la cola
    public Object primero(){
        return cola.sig.elemento;
    }
    
    //primero con prioridad
    public int primero_prioridad(){
        return cola.sig.prioridad;
    }      
    
    //agrega
    public void insertar(Object elemento, int prioridad) {
        Nodo p,q;
        boolean encontrado = false;
        p = cola;
        while((p.sig!=null)&&(!encontrado)) {
            if (p.sig.prioridad<prioridad) 
                encontrado = true;
            else p = p.sig;
        }
        q = p.sig;
        p.sig = new Nodo();
        p = p.sig;
        p.elemento = elemento;
        p.prioridad = prioridad;
        p.sig = q;
    }     
    
    //elimina
    public void suprime(){
        if (vacia()){
            cola = cola.sig;
        }
    }
        
    //muestra en consola
    public void imprimir(){
        Nodo aux = cola.sig;
            System.out.println("\nCola :");
        while(aux != null){
            System.out.println(aux.elemento);
            aux = aux.sig;
        }
            System.out.println("");
    }
        
        //busca en la cola
	public boolean buscar(Object elemento){
	    Nodo aux = cola;
	    boolean existe = false;
	    while(existe != true && aux != null){
	        if (elemento == aux.getElemento()) {
	            existe = true;
	        }
	        else{
	            aux = aux.sig;
	        }
	    }
	    return existe;
	}
}
