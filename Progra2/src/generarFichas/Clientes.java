package generarFichas;
public class Clientes {
    private String nombre;
    private Fichas ficha1;
    private String especialidad1;
    private String tipo_paquete;
    

    public Clientes(String nombre, String especialidad1, String tipo_paquete) {
        this.nombre = nombre;
        this.especialidad1 = especialidad1;
        this.tipo_paquete = tipo_paquete;
        this.ficha1 = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Fichas getFicha1() {
        return ficha1;
    }

    public void setFicha1(Fichas ficha1) {
        this.ficha1 = ficha1;
    }

    public String getEspecialidad1() {
        return especialidad1;
    }

    public void setEspecialidad1(String especialidad1) {
        this.especialidad1 = especialidad1;
    }

    public String getTipo_paquete() {
        return tipo_paquete;
    }

    public void setTipo_paquete(String tipo_paquete) {
        this.tipo_paquete = tipo_paquete;
    }
    
    
}
