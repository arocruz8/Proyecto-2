package colas_prioridad;
public class colaP {
    //atributos clase cola de prioridad
    private Nodo cola;

    /**
     * construcotres
     */
    public colaP() {
        cola = new Nodo();
        cola.sig = null;
        /**
         * La reconcha de la loraaaa
         */
    }

    /**
     *vacia
     * @return
     */
    public boolean vacia() {
        return (cola.sig==null);
    } 
    
    /**
     *obtiene el primer elemento de la cola
     * @return
     */
    public Object primero(){
        return cola.sig.elemento;
    }
    
    /**
     *primero con prioridad
     * @return
     */
    public int primero_prioridad(){
        return cola.sig.prioridad;
    }      

    /**
     *agrega a la cola lo que hace es buscar el tipo de prioridad que tenga si ya existe lo mete
     * en la cola que pertenezca sino crea una cola nueva
     * @param elemento
     * @param prioridad
     */
    public void insertar(Object elemento, int prioridad) {
        Nodo p,q;
        boolean encontrado = false;
        p = cola;
        while((p.sig!=null)&&(!encontrado)) {
            if (p.sig.prioridad<prioridad) 
                encontrado = true;
            else p = p.sig;
        }
        q = p.sig;
        p.sig = new Nodo();
        p = p.sig;
        p.elemento = elemento;
        p.prioridad = prioridad;
        p.sig = q;
    }   
                  
    /**
     *elimina
     */
    public void eliminar(){
        if (vacia()){
            cola = cola.sig;
        }
    } 
    
    public void eliminarPrioridad(int prioridad){
        Nodo p,q;
        boolean a = false;
        p=cola;
        while((p.sig!=null&&(!a))){
            if(p.sig.prioridad==prioridad)
                a = true;
            else p=p.sig;
        }
        q=p.sig;
    }

    /**
     *muestra en consola
     */
    public void imprimir(){
        Nodo aux = cola;
            System.out.println("\nCola :");
        while(aux != null){
            System.out.println(aux.elemento);
            aux = aux.sig;
        }
            System.out.println("");
    }
        
    /**
     * busca en la cola
     * @param elemento
     * @return
     */
    public boolean buscar(Object elemento){
        Nodo aux = cola;
        boolean existe = false;
        while(existe != true && aux != null){
            if (elemento== aux.getElemento()) {
                existe = true;
            }
            else{
                aux = aux.sig;
            }
        }
        return existe;
    }
}
