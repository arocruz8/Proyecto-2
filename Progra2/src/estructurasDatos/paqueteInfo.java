package estructurasDatos;
public class paqueteInfo {
    String tipo;
    int prioridad;
    
    //construcores
    public paqueteInfo(){
    }
    
    public paqueteInfo(String tipo, int prioridad){
        this.tipo=tipo;
        this.prioridad=prioridad;
    }
    
    //to string
    @Override
    public String toString() {
        return "paqueteInfo{" + "tipo=" + tipo + ", prioridad=" + prioridad + '}';
    }
    
}
