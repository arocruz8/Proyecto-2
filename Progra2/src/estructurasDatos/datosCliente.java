package estructurasDatos;
public class datosCliente {
    private String nombre;
    private String correo;
    private String tipo_usuario;
    private String tipo_paquete;
    
    //setter and getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getTipo_paquete() {
        return tipo_paquete;
    }

    public void setTipo_paquete(String tipo_paquete) {
        this.tipo_paquete = tipo_paquete;
    }
    
    //constructores
    public datosCliente(){
    }
    
    public datosCliente(String nombre, String correo, String tipo_usuario, String tipo_paquete){
        this.nombre=nombre;
        this.correo=correo;
        this.tipo_usuario=tipo_usuario;
        this.tipo_paquete=tipo_paquete;
    }


}
