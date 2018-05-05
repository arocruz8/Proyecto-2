
package estructurasDatos;
public class main2 {
    public static void main(String [] args){
        colaNormal cp = new colaNormal();
        cp.enqueue(new datosCliente("Ariel","@","normal","percedero"));
        cp.imprimir();
        cp.enqueue(new datosCliente("Maria","@yahoo.com","embarazada", "no percebero"));
        cp.imprimir();
        cp.dequeue();
        cp.imprimir();
        cp.enqueue(new datosCliente("Ivan","@gmail.com","discapacidad", "no percebero"));
        cp.getTope();
        cp.imprimir();
    }
}
