package estructurasDatos;


public class colaPrioridad {
Nodo inicio, fin;
    int tamaño;
        
    public colaPrioridad(){
        inicio=fin=null;
        tamaño=0;
    }
    
    public boolean vacia(){
        return inicio==null;
    }    
        
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
    
    public Object eliminar(){
        Object aux = inicio.dato;
        inicio=inicio.next;
        tamaño--;
         return aux;
    }
    
    public Object inicioCola(){
        return inicio.dato;
    }
    
    public int tamañoCola(){
        return this.tamaño;
    }
}
   
    

