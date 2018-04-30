package estructurasDatos;
public class colaPrioridad {
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
    }
}
   
    

