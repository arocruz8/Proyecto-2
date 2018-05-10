package quiosco;


public class ficha {
    int codigo;
    static int contador=0;
    
    
    public ficha(){
        this.contador++;
    }
    
    public ficha(int codigo){
        this.codigo=codigo;
    }
    
    //setter and getter
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        ficha.contador = contador;
    }   
}
    
    