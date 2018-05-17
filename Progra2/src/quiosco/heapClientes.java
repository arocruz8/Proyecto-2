package quiosco;
import estructurasDatos.*;


public class heapClientes extends cliente{
    private paqueteInfoCliente[] heap;
    private int tamañoHeap;
    private int capacidad;
    
    //constructor
    public heapClientes(int capacidad){
        this.capacidad=capacidad+1;
        heap = new paqueteInfoCliente[this.capacidad];
        tamañoHeap=0;
    }
    
    //función vaciar/limpiar
    public void clear(){
        heap = new paqueteInfoCliente[capacidad];
        tamañoHeap=0;
    }
    
    //función verifica si es vacia o no
    public boolean vacia(){
        return tamañoHeap == 0;
    }
    
    //función verifica si el arreglo está lleno
    public boolean lleno(){
        return tamañoHeap == capacidad-1;
    }
    
    //tamaño
    public int tamañoArreglo(){
        return tamañoHeap;
    }
    
    //función que agrega a la cola de los paquetes
   public void añadir(cliente data, int prioridad){
        paqueteInfoCliente nuevoPaquete = new paqueteInfoCliente(data, prioridad);
        
        heap[++tamañoHeap] = nuevoPaquete;
        int pos = tamañoHeap;
        
        while(pos != 1 && nuevoPaquete.prioridad > heap[pos/2].prioridad){
            heap[pos]=heap[pos/2];
            pos /= 2;
        }
        heap[pos] = nuevoPaquete;
    }
    
    
    //función que elimina el paquete 
    public paqueteInfoCliente eliminar(){
        int padre;
        int hijo;
        paqueteInfoCliente item, temp;
        if(vacia()){
            return null;
        }
        item = heap[1];
        temp = heap[tamañoHeap--];
        
        padre=1;
        hijo=2;
        
        while(hijo <= tamañoHeap){
            if(hijo < tamañoHeap && heap[hijo].prioridad < heap[hijo+1].prioridad)
                hijo++;
            if(temp.prioridad >= heap[hijo].prioridad)
                break;
            
            heap[padre]=heap[hijo];
            padre = hijo;
            hijo *= 2;
        }
        heap[padre]=temp;
        return item;
    }
    
}
