package generarFichas;
public class Clientes {
    private String nombre;
    private Fichas ficha1;
    private int especialidad1;
    

    public Clientes(String nombre, int especialidad1) {
        this.nombre = nombre;
        this.especialidad1 = especialidad1;
        
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

    public int getEspecialidad1() {
        return especialidad1;
    }

    public void setEspecialidad1(int especialidad1) {
        this.especialidad1 = especialidad1;
    }
}
