package heap;
//librerias
import java.util.ArrayList;
import java.util.Collection;

public class heap<T extends Comparable<T>> {

    private  ArrayList<T> Heap;
    private final int siguiente;

    protected final int izquierda(int i) { return (i << 1) + 1; }
    protected final int derecha(int i) { return (i << 1) + 2; }
    protected final int padre(int i) { return ((i - 1) >> 1); }

    private void heapsort(int i) {
        int j = i;
        int izq = izquierda(i);
        int der = derecha(i);
        if(izq < Heap.size() && (siguiente == Heap.get(izq).compareTo(Heap.get(j))))
            j = izq;
        if(der < Heap.size() && (siguiente == Heap.get(der).compareTo(Heap.get(j))))
            j = der;
        if(j != i) {
            intercambiar(i, j);
            heapsort(j);
        }
    }

    //constructores
    public heap(int sign) {
        this.siguiente = sign;
        Heap = new ArrayList<T>();
    }

    public heap(int sign, Collection<T> contenido) {
        this.siguiente = sign;
        Heap = new ArrayList<T>(contenido);
        //se mueve en el heap y lo va construyendo
        for(int i = 1 + Heap.size() / 2; i >= 0; i--) {
                heapsort(i);
        }
    }
        
    //métodos 
    public int tamaño(){
        return Heap.size();
    }
    
    //cambia la posición de los elementos que van ingresando en el heap
    //utiliza los parametros i y j para referirce a los nodos que se cambian
    public void intercambiar(int i, int j){
        T temp = Heap.get(j);
        Heap.set(j, Heap.get(i));
        Heap.set(i, temp);
    }
    
    //agrega un elemento nuevo
    public void agregar(T t){
        Heap.add(t);
        int i = Heap.size() - 1;
        int p = padre(i);
        while(i > 0 && (siguiente == Heap.get(i).compareTo(Heap.get(p)))) {
            intercambiar(i, p);
            i = p;
            p = padre(i);
        }
    }
    
    //elimina un nodo en un elemento
    public T eliminar(){
        T resultado = null;
        if(Heap.size() > 0) {
            resultado = Heap.remove(0);
            if(Heap.size() > 1) {
                Heap.add(0, Heap.remove(Heap.size() -1));
                heapsort(0);
            }
        }
        return resultado;
    }
 
}