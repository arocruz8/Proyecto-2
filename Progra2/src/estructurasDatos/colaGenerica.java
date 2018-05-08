package estructurasDatos;
import java.util.NoSuchElementException;

public class colaGenerica<E> implements interfazCola<E> {
    private Nodo<E> cabeza, cola;

    private static class Nodo<E> {
        private E data;

        private Nodo<E> back;

        public Nodo(E element) {
            data = element;
        }
    }
   
    public interfazCola<E> add(E element) {
        Nodo<E> nuevoNodo = new Nodo<E>(element);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            if (cabeza.back == null) {
                cabeza.back = nuevoNodo;
            } else {
                cola.back = nuevoNodo;
            }

            cola = nuevoNodo;
        }

        return this;
    }

    
    public E element() throws NoSuchElementException {
        if (cabeza == null) {
            throw new NoSuchElementException("Queue does not contain any items.");
        }

        return cabeza.data;
    }

    
    public E remove() throws NoSuchElementException {
        if (cabeza == null) {
            throw new NoSuchElementException("Queue does not contain any items.");
        }

        E output = cabeza.data;
        cabeza = cabeza.back;
        return output;
    }

   
    public boolean offer(E e) {
        // Only way for the offer to return false is if we run out of VM memory.
        add(e);
        return true;
    }

    
    public E peek() {
        return cabeza == null ? null : cabeza.data;
    }

   
    public E poll() {
        if (cabeza == null) {
            return null;
        }

        E output = cabeza.data;
        cabeza = cabeza.back;

        return output;
    }
    
      public int size() {
        Nodo<E> aux;
        int numElementos=0;
        aux = cabeza;
        while(aux != null){
            numElementos++;
            aux = aux.back;
        }
        return numElementos;
    }

    public boolean isEmpty() {
        return cabeza == null;
    }
    
}
