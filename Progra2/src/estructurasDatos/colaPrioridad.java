package estructurasDatos;
    public class colaPrioridad<cliente>{
	
	private Nodo<cliente> inicio;
	private static int size = 0;

	public colaPrioridad(){
	    inicio = null;
	    size = 0;
	}

	public Nodo getTope(){
		return inicio;
	}

	public static boolean esVacia(){
	    return size ==0;
	}
	public static int getsize(){
	    return size;
	}
        
        //agregar
	public Nodo<cliente> enqueue(cliente t){
	    Nodo<cliente> nuevo = new Nodo<>(t);
	    Nodo<cliente> aux;
	    if (esVacia()) {
	        inicio = nuevo;
	    }else {
	        aux = inicio;
	
	        while(aux.getSiguiente() != null){
	            aux=aux.getSiguiente();
	        }
	        aux.setSiguiente(nuevo);
	    }
		System.out.println("Enqueue... Value:"+nuevo.getDato());
	    size++;
	    return nuevo;
	}
        
        //eliminar
	public void dequeue(){
		if (!esVacia()) {
			System.out.println("Dequeue... Value:"+inicio.getDato());
			inicio = inicio.getSiguiente();
			size--;
		}
	}
	
        
	public void peek() throws Exception{		//public T peek() throws Exception{
	    if(!esVacia()){
	    	System.out.print("\nPeek... Value: "+inicio.getDato().toString()+"\n");
	    } else {
	        throw new Exception("> La pila se encuentra vacia.");
	    }
	}
	
        //buscar
	public boolean buscar(cliente referencia){
	    Nodo<cliente> aux = inicio;
	    boolean existe = false;
	    while(existe != true && aux != null){
	        if (referencia == aux.getDato()) {
	            existe = true;
	        }
	        else{
	            aux = aux.getSiguiente();
	        }
	    }
	    return existe;
	}
	
        //muestra
	public void imprimir(){
	    Nodo<cliente> aux = inicio;
		System.out.println("\nCola :");
	    while(aux != null){
	        System.out.println("¡_" + aux.getDato() + "_¡");
	        aux = aux.getSiguiente();
	    }
		System.out.println("");
	}
}
   
    

