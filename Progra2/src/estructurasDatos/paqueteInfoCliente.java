package estructurasDatos;
import quiosco.*;

public class paqueteInfoCliente extends cliente{
    cliente data = new cliente();
    public int prioridad;
    
    //construcores
    public paqueteInfoCliente(){
    }
    
    public paqueteInfoCliente(cliente data, int prioridad){
        this.data=data;
        this.prioridad=prioridad;
    }
    
    //to string

    @Override
    public String toString() {
        return "paqueteInfoCliente{" + "data=" + data + ", prioridad=" + prioridad + '}';
    }
    
}
