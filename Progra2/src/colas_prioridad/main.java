package colas_prioridad;
public class main {
    public static void main(String[] args){
    ColaPrioridad cp = new ColaPrioridad();
    
    cp.insertar(new cliente("Ariel", "a@gmail.com", "Normal", "Percedero"), 0);
    cp.imprimir();
    
    cp.insertar(new cliente("Maria", "m@yahoo.com", "Embarazada", "No percedero"), 1);
    cp.imprimir();
    
    }
}
