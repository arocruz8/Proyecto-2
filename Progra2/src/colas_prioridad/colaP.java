package colas_prioridad;
public class colaP<cliente>{
    //atributos
    private Nodo<cliente> frente;
    private Nodo<cliente> fondo;
    
    //constructor
    public colaP() {
	this.frente = null;
	this.fondo = null;
    }
    
    //vacia
    public boolean estaVacia() {
        return (this.frente == null);
    }

    //devuelve el tope
    public cliente getFrente() {
        if (this.estaVacia()) {
            System.out.println("La cola está vacía");}
        System.out.println("El primero es");
        return this.frente.getDato();
    }
    
    public int primero_prioridad(){
        return this.frente.getSiguiente().getPrioridad();
    }  
    
    //agrega en la cola
    public void agregar(int prioridad, cliente elemento) {
        if (prioridad == 0) {
            System.out.println("No se puede tener una prioridad 0");
        }
		
	Nodo<cliente> nuevoNodo = new Nodo<cliente>(prioridad, elemento);	
		
        if(this.estaVacia()){
            this.frente = nuevoNodo;
            this.fondo = nuevoNodo;
        }else{
            if (this.frente.getPrioridad() > nuevoNodo.getPrioridad()) {
                nuevoNodo.setSiguiente(this.frente);
                this.frente.setAnterior(nuevoNodo);
                this.frente = nuevoNodo;	
            }else{
                Nodo<cliente> nodoAnterior = this.fondo;
                while (nodoAnterior.getPrioridad() > nuevoNodo.getPrioridad()){
                        nodoAnterior = nodoAnterior.getAnterior();
                }
                if (nodoAnterior.getSiguiente() ==null){
                        this.fondo = nuevoNodo;}

                Nodo<cliente> nodoSiguiente = nodoAnterior.getSiguiente();
                nuevoNodo.setAnterior(nodoAnterior);
                nodoAnterior.setSiguiente(nuevoNodo);
                nuevoNodo.setSiguiente(nodoSiguiente);
                }
            }
    }
   
    //eliminar
    public cliente desacolar(){
        if (this.estaVacia()){
            System.out.println("La cola esta vacia.");
        }
        cliente elemento = this.frente.getDato();
        this.frente = this.frente.getSiguiente();
        return elemento;
    }	
    
    //imprimir
    public void imprimir(){
        Nodo aux = frente;
            System.out.println("Cola :");
        while(aux != null){
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
            System.out.println("");
    }    
}
