package estructurasDatos;
import quiosco.*;

public class heap extends paqueteInfoCliente{
    private paqueteInfoCliente[] heap;
    private int tamañoHeap;
    private final int capacidad;
    public cliente data = new cliente();
    
    //constructor
    public heap(int capacidad){
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
    
    /*función que agrega a la cola de los paquetes 
    comprando la prioridad que tengan*/
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
    
   /*función que elimina el paquete se encarga de revisar el tamaño del heap
    de buscar la prioridad y dependiendo si la cola tiene más de un elemento
    compara el padre con el hijo para asi ir sacando el elemento que se desea*/ 
    public paqueteInfoCliente eliminar(){
        int padre;
        int hijo;
        paqueteInfoCliente item, temp;
        if(vacia()){
            return null;}
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
