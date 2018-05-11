package quiosco;


public class ficha {
    private String codigoFicha;
    private String tipoPaquete;
    private String tipoUsuario;
    private static int numFicha;
    private static int fichasP;
    private static int fichasNP;

    public ficha(String tipoPaquete, String tipoUsuario) {
        this.tipoPaquete = tipoPaquete;
        this.tipoUsuario = tipoUsuario;
        if(this.numFicha==99){  //lleva el número consecutivo de la ficha
            this.numFicha = 0;
        }else{
            this.numFicha++;
        }
        this.codigoFicha = this.tipoPaquete+" - "+this.tipoUsuario+" - "+this.numFicha;
        if(this.tipoPaquete.equals("P")){   // lleva la contidad de las ficha de perecederos
            this.fichasP++;                 // o no perecederos instanciadas
        }else{
            this.fichasNP++;
        }
    }

    public String getCodigoFicha() {
        return codigoFicha;
    }

    public void setCodigoFicha(String codigoFicha) {
        this.codigoFicha = codigoFicha;
    }

    public String getTipoPaquete() {
        return tipoPaquete;
    }

    public void setTipoPaquete(String tipoPaquete) {
        this.tipoPaquete = tipoPaquete;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public static int getNumFicha() {
        return numFicha;
    }

    public static void setNumFicha(int numFicha) {
        ficha.numFicha = numFicha;
    }

    public static int getFichasP() {
        return fichasP;
    }

    public static void setFichasP(int fichasP) {
        ficha.fichasP = fichasP;
    }

    public static int getFichasNP() {
        return fichasNP;
    }

    public static void setFichasNP(int fichasNP) {
        ficha.fichasNP = fichasNP;
    }
    
    public static void main(String[] args){
        ficha ficha1=new ficha("NP", "D");
        ficha ficha2=new ficha("P", "E");
        ficha ficha3=new ficha("NP", "M");
        
        System.out.println(ficha1.getCodigoFicha());
        System.out.println(ficha2.getCodigoFicha());
        System.out.println(ficha3.getCodigoFicha());
        
        ficha1.getFichasP();
        ficha1.getFichasNP();
    }
}