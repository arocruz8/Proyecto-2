package estructurasDatos;
/*
public class colaPrioridad {
    /*
    Nodo inicio, fin;
    int tamaño;
    
    //constructor
    public colaPrioridad(){
        inicio=fin=null;
        tamaño=0;
    }
    
    //vacia
    public boolean vacia(){
        return inicio==null;
    }    
    
    //agrega en la cola    
    public void agregar(Object dato){    
        Nodo nuevo = new Nodo(dato);
        if(vacia()){
          inicio=nuevo;
        }else{
            fin.next=nuevo;
        }
        fin=nuevo;
        tamaño++;
    }
    
    //eiminar
    public Object eliminar(){
        Object aux = inicio.dato;
        inicio=inicio.next;
        tamaño--;
         return aux;
    }
    
    //inicio cola
    public Object inicioCola(){
        return inicio.dato;
    }
    
    //tamaño cola
    public int tamañoCola(){
        return this.tamaño;
    }*/
    
    public class colaPrioridad<T>{
	
	private Nodo<T> inicio;
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

	public Nodo<T> enqueue(T t){
	    Nodo<T> nuevo = new Nodo<>(t);
	    Nodo<T> aux;
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
	
	public boolean buscar(T referencia){
	    Nodo<T> aux = inicio;
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
	
	public void imprimir(){
	    Nodo<T> aux = inicio;
		System.out.println("\nCola :");
	    while(aux != null){
	        System.out.println("¡_" + aux.getDato() + "_¡");
	        aux = aux.getSiguiente();
	    }
		System.out.println("");
	}
}
   
    

