package generarFichas;
public class Fichas{
    //atributos de la clase ficha
    private String especialidad;
    private int codigo;
    
    //constructor
    public Fichas(String especialidad, int codigo){
        this.especialidad = especialidad;
        this.codigo = codigo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
