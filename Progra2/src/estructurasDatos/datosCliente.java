package estructurasDatos;
public class datosCliente {
    private String nombre;
    private String correo;
    private String tipo_usuario;
    
    public datosCliente(){
    }
    
    public datosCliente(String nombre, String correo, String tipo_usuario){
        this.nombre=nombre;
        this.correo=correo;
        this.tipo_usuario=tipo_usuario;
    }

    @Override
    public String toString() {
        return "datosCliente{" + "nombre=" + nombre + ", correo=" + correo + ", tipo_usuario=" + tipo_usuario + '}';
    }
    
    
}
