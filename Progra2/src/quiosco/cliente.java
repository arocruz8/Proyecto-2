package quiosco;
public class cliente{
    //atributos
    private String nombre;
    private String correo;
    private String tipo_usuario;
    private String tipo_paquete;
    private int prioridad;
    private static int cantD;
    private static int cantM;
    private static int cantE;
    private static int cantR;
    
    private ficha fi;
    
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

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public ficha getFi() {
        return fi;
    }

    public void setFi(ficha fi) {
        this.fi = fi;
    }

    public int getCantD() {
        return cantD;
    }

    public static void setCantD(int cantD) {
        cliente.cantD = cantD;
    }

    public int getCantM() {
        return cantM;
    }

    public static void setCantM(int cantM) {
        cliente.cantM = cantM;
    }

    public int getCantE() {
        return cantE;
    }

    public static void setCantE(int cantE) {
        cliente.cantE = cantE;
    }

    public int getCantR() {
        return cantR;
    }

    public static void setCantR(int cantR) {
        cliente.cantR = cantR;
    }
    
    //constructores
   public cliente(){
   }
    
    public cliente(String nombre, String correo, String tipo_usuario, String tipo_paquete, int prioridad){
        this.nombre=nombre;
        this.correo=correo;
        this.tipo_usuario=tipo_usuario;
        this.tipo_paquete=tipo_paquete;
        this.prioridad=prioridad;
        this.fi=null;
        if(this.tipo_usuario == "D"){
            this.cantD++;
        }else if(this.tipo_usuario == "M"){
            this.cantM++;
        }else if(this.tipo_usuario == "E"){
            this.cantE++;
        }else if (this.tipo_usuario == "R"){
            this.cantR++;
        }
    }
    
    //to string
    @Override
    public String toString() {
        return "cliente{" + "nombre=" + nombre + ", correo=" + correo + ", tipo_usuario=" + tipo_usuario + ", tipo_paquete=" + tipo_paquete + ", prioridad=" + prioridad + '}';
    }    
}
