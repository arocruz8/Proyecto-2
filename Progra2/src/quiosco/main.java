package quiosco;
public class main {
    public static void main(String[] args){
    ColaPrioridad cp = new ColaPrioridad();
    
    cp.insertar(new cliente("Ariel", "a@gmail.com", "Normal", "Percedero", 0), 0);
    cp.imprimir();
    
    cp.insertar(new cliente("Maria", "m@yahoo.com", "Embarazada", "No percedero", 1), 1);
    cp.imprimir();
    
    cp.insertar(new cliente("Zaida", "z@yahoo.com", "Normal", "No percedero", 0), 0);
    cp.imprimir();
    
    cp.primero();
    //cp.imprimir();
    
    cp.primero_prioridad();
    //cp.imprimir();
    
    cp.imprimir();
    
    }
}
