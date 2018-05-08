package generarFichas;
public class Fichas {
    //atributos de la clase ficha
    private int especialidad;
    private int codigo;
    
    //constructor
    public Fichas(int especialidad, int codigo) {
        this.especialidad = especialidad;
        this.codigo = codigo;
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
