package estructurasDatos;
public class LinkedList<cliente>{
    private Nodo<cliente> head;
    
    public Nodo<cliente> getHead() {
        return head;
    }
    public void setHead(Nodo<cliente> head) {
	this.head = head;
    }
    
    public LinkedList(){
        listaVacia();
    }

    private void listaVacia(){
        head = null;
    }
    public boolean esVacia(){
        return head == null;
    }

    public void add(cliente t){
        Nodo<cliente> nuevo = new Nodo<>(t);
 
        if (!esVacia()){
            nuevo.setSiguiente(head);
        }
        head=nuevo;
         
    }
    
    public Nodo<cliente> devolverUltimo(){
        Nodo<cliente> elemen = null;
        Nodo<cliente> aux;
        if (!esVacia()){
            aux = head;
            
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            elemen = aux;
        }
        return elemen;
    }

    public int largoLista(){
        Nodo<cliente> aux;
        int numElementos=0;
        aux = head;
        while(aux != null){
            numElementos++;
            aux = aux.getSiguiente();
        }
        return numElementos;
 
    }

    public cliente devolverDato(int pos){
        Nodo<cliente> aux=head;
        int cont=0;
        cliente dato=null;
        if(pos<0 || pos>=largoLista()){
            System.out.println("La posicion insertada no es correcta");
        }else{
            while(aux!=null){
                if (pos == cont){
                    dato=aux.getDato();
                }
                aux=aux.getSiguiente();
                cont++; 
            }
        }
        return dato;         
    }
    
    public Nodo<cliente> devolverNodo(int pos){
        Nodo<cliente> aux=head;
        int cont=0;
         
        if(pos<0 || pos>=largoLista()){
            System.out.println("La posicion insertada no es correcta");
        }else{
            while(aux!=null){
                if (pos == cont){
                    return aux; 
                }
                aux=aux.getSiguiente();
                cont++;
                 
            }
        }
         
        return aux;
         
    }
    
    public void remove(){
        if(head.getSiguiente()!=null)
                head = head.getSiguiente();
        else head = null;
    }

    public String mostrarLista(){

        String contenido="";
        Nodo<cliente> aux=head;

        while(aux!=null){
            contenido+="["+aux.getDato()+"]";
            aux=aux.getSiguiente();
        }

        return contenido;
    }

    public void show(){
        System.out.print("Inicio>");
        if (!esVacia()) {
            Nodo<cliente> current = head;

            do{
                System.out.print("-["+current.getDato()+"]");
                current = current.getSiguiente();
            }while(current != null);

            System.out.println("-null");
        }
    }


}

