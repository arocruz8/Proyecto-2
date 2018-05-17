package quiosco;

//public class ColaPrioridad extends cliente{
//    //atributos clase cola de prioridad
//    private Nodo cola;
//
//    /**
//     * construcotres
//     */
//    public ColaPrioridad() {
//        cola = new Nodo();
//        cola.sig = null;
//      
//    }
//
//    /**
//     *vacia
//     * @return
//     */
//    public boolean vacia() {
//        return (cola.sig==null);
//    } 
//    
//    /**
//     *obtiene el primer elemento de la cola
//     * @return
//     */
//    public Object primero(){
//        return cola.sig.elemento;
//    }
//    
//    /**
//     *primero con prioridad
//     * @return
//     */
//    public int primero_prioridad(){
//        return cola.sig.prioridad;
//    }      
//
//    /**
//     *agrega a la cola lo que hace es buscar el tipo de prioridad que tenga si ya existe lo mete
//     * en la cola que pertenezca sino crea una cola nueva
//     * @param elemento
//     * @param prioridad
//     */
//    public void insertar(Object elemento, int prioridad) {
//        Nodo p,q;
//        boolean encontrado = false;
//        p = cola;
//        while((p.sig!=null)&&(!encontrado)) {
//            if (p.sig.prioridad<prioridad) 
//                encontrado = true;
//            else p = p.sig;
//        }
//        q = p.sig;
//        p.sig = new Nodo();
//        p = p.sig;
//        p.elemento = elemento;
//        p.prioridad = prioridad;
//        p.sig = q;
//    }   
//                  
//    /**
//     *elimina
//     */
//    public void eliminar(){
//        if (vacia()){
//            cola = cola.sig;
//        }
//    } 
//    
//    public void eliminarPrioridad(int prioridad){
//        Nodo p,q;
//        boolean a = false;
//        p=cola;
//        while((p.sig!=null&&(!a))){
//            if(p.sig.prioridad==prioridad)
//                a = true;
//            else p=p.sig;
//        }
//        q=p.sig;
//    }
//
//    /**
//     *muestra en consola
//     */
//    public void imprimir(){
//        Nodo aux = cola;
//            System.out.println("\nCola :");
//        while(aux != null){
//            System.out.println(aux.elemento);
//            aux = aux.sig;
//        }
//            System.out.println("");
//    }
//}

public class ColaPrioridad<cliente>{
    //atributos
    private Nodo<cliente> frente;
    private Nodo<cliente> fondo;
    
    //constructor
    public ColaPrioridad() {
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
