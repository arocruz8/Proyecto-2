package interfaz;
import quiosco.*;
import estructurasDatos.*;
import javax.swing.JOptionPane;

public class DatosCliente extends javax.swing.JFrame{ 
    
    /*
    objetos para trabajar en la progra
    */
    cliente Xcliente= new cliente();
    ficha Xficha= new ficha();
    Interfaz_inicio X= new Interfaz_inicio();
    
    /*
    colas a utilizar
    */
    ColaPrioridad c1 = new ColaPrioridad();
    ColaPrioridad c2 = new ColaPrioridad();
    heap h2 = new heap(20);
    heap h1 = new heap(20);
    
    ColaPrioridad colaSeguridad= new ColaPrioridad();
    ColaPrioridad colaFichas = new ColaPrioridad();
    
    /*
    atributos clientes
    */
    public static String nombre;
    public static String correo;
    public static String tipo_usuario;
    public static String tipo_paquete;
    public static int prioridad;
    
    /*
    atributos ficha
    */
    public static String tipoPaquete;
    public static String tipoUsuario;
    
    /*
    contadores
    */
    public static int totalDiscapacidad;
    public static int totalEmbarazadas;
    public static int totalRegulares;
    public static int totalAdultoMayor;
    public static int totalPerecederos;
    public static int totalNoPerecederos;
    public static int totalVentanasP;
    public static int totalVentanasNP;
    
    /*
    los tipos que van a ser las ventanas de perecedero y no perecedero
    */
    public static String tipoPerecedero;
    public static String tipoNoPerecedero;
    
    /*
    tiempo minimo y maximo de atencion
    */
    public static int tiempoMinimo;
    public static int tiempoMaximo;
    public static int cantidadColaSeguridad;
    public static int tiempoTotal=0;
    
    /*
    constructores
    */
    public DatosCliente(){
       initComponents();
    }
    
    
    public DatosCliente(String tipoP, String tipoNP, int contadorP, int contadorNP,String MinimoTiempo,String MaximoTiempo) {
        initComponents();
        totalVentanasP=contadorP;
        totalVentanasNP=contadorNP;
        tipoPerecedero=tipoP;
        tipoNoPerecedero=tipoNP;
        tiempoMinimo= Integer.parseInt(MinimoTiempo);
        tiempoMaximo= Integer.parseInt(MaximoTiempo);
        /**
         * Los labels y los botones se muestran dependiendo de cuantas ventanas se hayan solicitado
         */
        if(contadorP>=1){
            Ventana1PLabel.setVisible(true);
            BotonVentana1P.setVisible(true);
        }
        else{
            Ventana1PLabel.setVisible(false);
            BotonVentana1P.setVisible(false);
        }
        if(contadorP>=2){
            Ventana2PLabel.setVisible(true);
            BotonVentana2P.setVisible(true);
        }
        else{
            Ventana2PLabel.setVisible(false);
            BotonVentana2P.setVisible(false);
        }
        if(contadorP>=3){
            Ventana3PLabel.setVisible(true);
            BotonVentana3P.setVisible(true);
        }
        else{
            Ventana3PLabel.setVisible(false);
            BotonVentana3P.setVisible(false);
        }
        
        if(contadorNP>=1){
            Ventana1NPLabel.setVisible(true);
            BotonVentana1NP.setVisible(true);
        }
        else{
            Ventana1NPLabel.setVisible(false);
            BotonVentana1NP.setVisible(false);
        }
        if(contadorNP>=2){
            Ventana2NPLabel.setVisible(true);
            BotonVentana2NP.setVisible(true);
        }
        else{
            Ventana2NPLabel.setVisible(false);
            BotonVentana2NP.setVisible(false);
        }
        if(contadorNP>=3){
            Ventana3NPLabel.setVisible(true);
            BotonVentana3NP.setVisible(true);
        }
        else{
            Ventana3NPLabel.setVisible(false);
            BotonVentana3NP.setVisible(false);
        }
    }
    
    /*
    Este metodo agrega dependiendo del tipo de estructura que el usuario haya seleccionado 
    en la configuración inicial y una vez los datos se hayan llenado en datos clientes se tomara,
    el tipo de paquete que resgistro para añadirlo a la estructura correspondiente
    */
    public void agregarDatos(){
        cliente data = new cliente();
        nombre=jTextNombre.getText();
        correo=jTextCorreo.getText();
        
        data.setNombre(nombre);
        data.setCorreo(correo);
        data.setTipo_usuario(tipo_usuario);
        data.setTipo_paquete(tipo_paquete);
        data.setPrioridad(prioridad);

        int priority = prioridad;
        
        /*
        Si el paquete que se desea agregar es un perecedero se agrega a c1 o a h1 y si es no perecedero se agrega a c2 y h2
        */
        if("P".equals(tipo_paquete)){
            if("cola".equals(tipoPerecedero)){
                c1.agregar(priority, data);
            }else{
                h1.añadir(data, priority);
            }
        }
        if("NP".equals(tipo_paquete)){
            if("cola".equals(tipoNoPerecedero)){
                c2.agregar(priority, data);
            }else{
                h2.añadir(data, priority);
            }
        }
       
    }
    
    /*
    Lo que hace este método es imprimir en consola los datos que se van agregando 
    en cada una de las estructuras por lo que el usurio podra ver como va aumentando 
    el tamaño de cada estructura
    */
    public void mostrar(){
        c1.imprimir();
        c2.imprimir();
        colaSeguridad.imprimir();
    }
    
    /*
    Este metodo se encarga de usar las variables globales tipo_paquete y tipo_usuario,
    para ingresarlas en el objeto f que es de la clas ficha para generarla posteriormente
    f obtendra si el codigo y que tipo de paquete ingreso para agregarlo a la cola de fichas
    */
    public void generarficha(){
        ficha f =new ficha(tipoPaquete, tipoUsuario);
        tipoPaquete = tipo_paquete;
        tipoUsuario = tipo_usuario;
        
        f.setTipoPaquete(tipoPaquete);
        f.setTipoUsuario(tipoUsuario);
        f.getFichasP();
        f.getFichasNP();
        f.getCodigoFicha();
        
        ventanaFicha vf = new ventanaFicha(tipoPaquete, tipoUsuario);
        vf.setVisible(true);
        colaFichas.agregar(prioridad, f);
    }
    
    /*
    Este método determina el tiempo que se va a tomar atendiendo un paquete en la cola de seguridad
    */
    public void tiempoEspera(){
        int num;
        num=(int)(Math.random()*(tiempoMaximo-tiempoMinimo+1)+tiempoMinimo);
        int tiempo=num*100;
        /**
         * Se suma el tiempo que se va a durar atendiendo al cliente al total para sacar el promedio y se suma uno a la cantidadColaSeguridad
         */
        tiempoTotal=tiempoTotal+tiempo;
        cantidadColaSeguridad++;
        try{
            if(colaSeguridad.estaVacia()==false){
                cliente info=(cliente) colaSeguridad.desacolar();
                JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre());
                /**
                 * Se hace un sleep por el tiempo generado en el random 
                 */
                Thread.sleep(tiempo);
                JOptionPane.showMessageDialog(null,"Atendido");
            }
        }
        catch(Exception e){
            
        }
    }
    
    /**
     * Metodo que calcula el tiempo promedio que se dura en la cola seguridad
     * @return 
     */
    public int tiempoPromedio(){
        int promedio=tiempoTotal/cantidadColaSeguridad;
        return promedio;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField20 = new javax.swing.JTextField();
        panel1 = new java.awt.Panel();
        jLabelPaquete = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelCorreo = new javax.swing.JLabel();
        jTextCorreo = new javax.swing.JTextField();
        jTextNombre = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        BotonDiscapacidad = new javax.swing.JButton();
        BotonAdultoMayor = new javax.swing.JButton();
        BotonEmbarazada = new javax.swing.JButton();
        BotonRegular = new javax.swing.JButton();
        BotonPerecedero = new javax.swing.JButton();
        BotonNoPerecedero = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panel2 = new java.awt.Panel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        BotonVentana1P = new javax.swing.JButton();
        BotonVentana2P = new javax.swing.JButton();
        BotonVentana3P = new javax.swing.JButton();
        BotonVentana1NP = new javax.swing.JButton();
        BotonVentana2NP = new javax.swing.JButton();
        BotonVentana3NP = new javax.swing.JButton();
        Ventana1PLabel = new javax.swing.JLabel();
        Ventana2PLabel = new javax.swing.JLabel();
        Ventana3PLabel = new javax.swing.JLabel();
        Ventana3NPLabel = new javax.swing.JLabel();
        Ventana2NPLabel = new javax.swing.JLabel();
        Ventana1NPLabel = new javax.swing.JLabel();
        panel3 = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        panel4 = new java.awt.Panel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TiempoPromedioLab = new javax.swing.JTextField();
        TotalVentanasLab = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        PerecederosLab = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        NoPerecederosLab = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        AdultoMayorLab = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        EmbarazadasLab = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        DiscapacidadLab = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        RegularLab = new javax.swing.JTextField();
        ActualizarBoton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TipoVentanasPLab = new javax.swing.JTextField();
        TipoVentanasNPLab = new javax.swing.JTextField();

        jTextField20.setText("jTextField9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelPaquete.setText("Tipo de paquete");

        jLabelUsuario.setText("Tipo de usuario");

        jLabelCorreo.setText("Correo");

        jLabelNombre.setText("Nombre");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Datos de clientes");

        jButton3.setText("Mostrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton7.setText("Generar Ficha");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        BotonDiscapacidad.setText("Discapacitado");
        BotonDiscapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonDiscapacidadActionPerformed(evt);
            }
        });

        BotonAdultoMayor.setText("Adulto Mayor");
        BotonAdultoMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAdultoMayorActionPerformed(evt);
            }
        });

        BotonEmbarazada.setText("Embarazada");
        BotonEmbarazada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEmbarazadaActionPerformed(evt);
            }
        });

        BotonRegular.setText("Regular");
        BotonRegular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegularActionPerformed(evt);
            }
        });

        BotonPerecedero.setText("Perecedero");
        BotonPerecedero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPerecederoActionPerformed(evt);
            }
        });

        BotonNoPerecedero.setText("No Perecedero");
        BotonNoPerecedero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNoPerecederoActionPerformed(evt);
            }
        });

        jButton2.setText("Ver Cola de Fichas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCorreo)
                            .addComponent(jLabelNombre))
                        .addGap(36, 36, 36)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton7)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(jLabelUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotonDiscapacidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonAdultoMayor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonEmbarazada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonRegular)
                                .addGap(64, 64, 64))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jLabelPaquete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonPerecedero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonNoPerecedero)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCorreo)
                    .addComponent(jTextCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(BotonDiscapacidad)
                    .addComponent(BotonAdultoMayor)
                    .addComponent(BotonEmbarazada)
                    .addComponent(BotonRegular))
                .addGap(26, 26, 26)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPaquete)
                    .addComponent(BotonPerecedero)
                    .addComponent(BotonNoPerecedero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton7)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Control de entregas");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Perecedero");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("No perecedero");

        BotonVentana1P.setText("Atender");
        BotonVentana1P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVentana1PActionPerformed(evt);
            }
        });

        BotonVentana2P.setText("Atender");
        BotonVentana2P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVentana2PActionPerformed(evt);
            }
        });

        BotonVentana3P.setText("Atender");
        BotonVentana3P.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVentana3PActionPerformed(evt);
            }
        });

        BotonVentana1NP.setText("Atender");
        BotonVentana1NP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVentana1NPActionPerformed(evt);
            }
        });

        BotonVentana2NP.setText("Atender");
        BotonVentana2NP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVentana2NPActionPerformed(evt);
            }
        });

        BotonVentana3NP.setText("Atender");
        BotonVentana3NP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVentana3NPActionPerformed(evt);
            }
        });

        Ventana1PLabel.setText("Ventana 1");

        Ventana2PLabel.setText("Ventana 2");

        Ventana3PLabel.setText("Ventana 3");

        Ventana3NPLabel.setText("Ventana 3");

        Ventana2NPLabel.setText("Ventana 2");

        Ventana1NPLabel.setText("Ventana 1");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(Ventana1NPLabel)
                                .addGap(97, 97, 97)
                                .addComponent(Ventana2NPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(Ventana3NPLabel))
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(BotonVentana1P))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(BotonVentana1NP)))
                        .addGap(74, 74, 74)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonVentana2P)
                            .addComponent(BotonVentana2NP))
                        .addGap(82, 82, 82)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonVentana3NP)
                            .addComponent(BotonVentana3P)))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(Ventana1PLabel)
                        .addGap(97, 97, 97)
                        .addComponent(Ventana2PLabel)
                        .addGap(105, 105, 105)
                        .addComponent(Ventana3PLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ventana1PLabel)
                    .addComponent(Ventana2PLabel)
                    .addComponent(Ventana3PLabel))
                .addGap(32, 32, 32)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonVentana2P)
                    .addComponent(BotonVentana1P)
                    .addComponent(BotonVentana3P))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotonVentana3NP)
                            .addComponent(BotonVentana1NP)
                            .addComponent(BotonVentana2NP))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ventana3NPLabel)
                            .addComponent(Ventana2NPLabel)
                            .addComponent(Ventana1NPLabel))
                        .addGap(79, 79, 79))))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Control de seguridad");

        jButton4.setText("Atender");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Ventana 1");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Ventana 2");

        jButton5.setText("Atender");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jButton5))
                .addGap(117, 117, 117))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(62, 62, 62)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel19))
                .addGap(42, 42, 42)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Administrador");

        jLabel10.setText("Tiempo promedio espera cola seguridad");

        jLabel11.setText("Cantidad ventanillas visibles");

        TiempoPromedioLab.setText("0");

        TotalVentanasLab.setText("0");
        TotalVentanasLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalVentanasLabActionPerformed(evt);
            }
        });

        jLabel12.setText("Cantidad de paquetes perecederos");

        PerecederosLab.setText("0");
        PerecederosLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerecederosLabActionPerformed(evt);
            }
        });

        jLabel13.setText("Cantidad de paquetes no percederos");

        NoPerecederosLab.setText("0");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Cantidad de fichas dispensadas");

        jLabel15.setText("Adulto mayor");

        AdultoMayorLab.setText("0");

        jLabel16.setText("Embarazadas");

        EmbarazadasLab.setText("0");

        jLabel17.setText("Discapacidad");

        DiscapacidadLab.setText("0");

        jLabel18.setText("Regular");

        RegularLab.setText("0");

        ActualizarBoton.setText("Actualizar");
        ActualizarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarBotonActionPerformed(evt);
            }
        });

        jLabel5.setText("Ventanillas Perecederos");

        jLabel6.setText("Ventanillas No Perecederos");

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(ActualizarBoton)
                            .addComponent(jLabel5)
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(97, 97, 97)
                                .addComponent(TipoVentanasNPLab))))
                    .addComponent(jLabel4)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(39, 39, 39)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TipoVentanasPLab, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TiempoPromedioLab, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                                .addComponent(PerecederosLab)
                                .addComponent(NoPerecederosLab)
                                .addComponent(TotalVentanasLab)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(DiscapacidadLab, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                            .addComponent(EmbarazadasLab, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AdultoMayorLab, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RegularLab))))
                .addContainerGap())
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TiempoPromedioLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(AdultoMayorLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalVentanasLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(9, 9, 9)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PerecederosLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NoPerecederosLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(EmbarazadasLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(DiscapacidadLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(RegularLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(TipoVentanasPLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(TipoVentanasNPLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addComponent(ActualizarBoton)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(panel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        mostrar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        agregarDatos();
        generarficha();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void BotonVentana1PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentana1PActionPerformed
        /**
         * Se hacen los cambios del boton de atender en la ventana, se extrae al cliente de la cola o el heap
         * dependiendo de lo que se haya configurado y se agrega el cliente a la cola de seguridad
         */
        if("P".equals(tipo_paquete)){
            if("cola".equals(tipoPerecedero)){
                if(c1.estaVacia()==false){
                    BotonVentana1P.setText("Liberar y atender");
                    cliente info=(cliente) c1.desacolar();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre()+" en Ventana 1");
                    int prioridad=1;
                    colaSeguridad.agregar(prioridad, info);
                }
                else{
                    BotonVentana1P.setText("Atender");
                }
            }
            else{
                if(h1.vacia()==false){
                    BotonVentana1P.setText("Liberar y atender");
                    cliente info=(cliente) h1.eliminar();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre()+" en Ventana 1");
                    int prioridad=1;
                    colaSeguridad.agregar(prioridad, info);
                }
                else{
                    BotonVentana1P.setText("Atender");
                }
            }
        }
    }//GEN-LAST:event_BotonVentana1PActionPerformed

    private void BotonVentana2PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentana2PActionPerformed
        if("P".equals(tipo_paquete)){
            if("cola".equals(tipoPerecedero)){
                if(c1.estaVacia()==false){
                    BotonVentana2P.setText("Liberar y atender");
                    cliente info=(cliente) c1.desacolar();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre()+" en Ventana 2");
                    int prioridad=1;
                    colaSeguridad.agregar(prioridad, info);
                }
                else{
                    BotonVentana2P.setText("Atender");
                }
            }
            else{
                if(h1.vacia()==false){
                    BotonVentana2P.setText("Liberar y atender");
                    cliente info=(cliente) h1.eliminar();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre()+" en Ventana 2");
                    int prioridad=1;
                    colaSeguridad.agregar(prioridad, info);
                }
                else{
                    BotonVentana2P.setText("Atender");
                }
            }
        }
    }//GEN-LAST:event_BotonVentana2PActionPerformed

    private void BotonVentana3PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentana3PActionPerformed
        if("P".equals(tipo_paquete)){
            if("cola".equals(tipoPerecedero)){
                if(c1.estaVacia()==false){
                    BotonVentana3P.setText("Liberar y atender");
                    cliente info=(cliente) c1.desacolar();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre()+" en Ventana 3");
                    int prioridad=1;
                    colaSeguridad.agregar(prioridad, info);
                }
                else{
                    BotonVentana3P.setText("Atender");
                }
            }
            else{
                if(h1.vacia()==false){
                    BotonVentana3P.setText("Liberar y atender");
                    cliente info=(cliente) h1.eliminar();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre()+" en Ventana 3");
                    int prioridad=1;
                    colaSeguridad.agregar(prioridad, info);
                }
                else{
                    BotonVentana3P.setText("Atender");
                }
            }
        }
    }//GEN-LAST:event_BotonVentana3PActionPerformed

    private void BotonVentana1NPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentana1NPActionPerformed
        if("NP".equals(tipo_paquete)){
            if("cola".equals(tipoNoPerecedero)){
                if(c2.estaVacia()==false){
                    BotonVentana1NP.setText("Liberar y atender");
                    cliente info=(cliente) c2.desacolar();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre()+" en Ventana 1");
                    int prioridad=1;
                    colaSeguridad.agregar(prioridad, info);
                }
                else{
                    BotonVentana1NP.setText("Atender");
                }
            }
            else{
                if(h2.vacia()==false){
                    BotonVentana1NP.setText("Liberar y atender");
                    cliente info=(cliente) h2.eliminar();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre()+" en Ventana 1");
                    int prioridad=1;
                    colaSeguridad.agregar(prioridad, info);
                }
                else{
                    BotonVentana1NP.setText("Atender");
                }
            }
        }
    }//GEN-LAST:event_BotonVentana1NPActionPerformed

    private void BotonVentana2NPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentana2NPActionPerformed
        if("NP".equals(tipo_paquete)){
            if("cola".equals(tipoNoPerecedero)){
                if(c2.estaVacia()==false){
                    BotonVentana2NP.setText("Liberar y atender");
                    cliente info=(cliente) c2.desacolar();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre()+" en Ventana 2");
                    int prioridad=1;
                    colaSeguridad.agregar(prioridad, info);
                }
                else{
                    BotonVentana2NP.setText("Atender");
                }
            }
            else{
                if(h2.vacia()==false){
                    BotonVentana2NP.setText("Liberar y atender");
                    cliente info=(cliente) h2.eliminar();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre()+" en Ventana 2");
                    int prioridad=1;
                    colaSeguridad.agregar(prioridad, info);
                }
                else{
                    BotonVentana2NP.setText("Atender");
                }
            }
        }
    }//GEN-LAST:event_BotonVentana2NPActionPerformed

    private void BotonVentana3NPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentana3NPActionPerformed
        if("NP".equals(tipo_paquete)){
            if("cola".equals(tipoNoPerecedero)){
                if(c2.estaVacia()==false){
                    BotonVentana3NP.setText("Liberar y atender");
                    cliente info=(cliente) c2.desacolar();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre()+" en Ventana 3");
                    int prioridad=1;
                    colaSeguridad.agregar(prioridad, info);
                }
                else{
                    BotonVentana3NP.setText("Atender");
                }
            }
            else{
                if(h2.vacia()==false){
                    BotonVentana3NP.setText("Liberar y atender");
                    cliente info=(cliente) h2.eliminar();
                    JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre()+" en Ventana 3");
                    int prioridad=1;
                    colaSeguridad.agregar(prioridad, info);
                }
                else{
                    BotonVentana3NP.setText("Atender");
                }
            }
        }
    }//GEN-LAST:event_BotonVentana3NPActionPerformed

    private void BotonDiscapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonDiscapacidadActionPerformed
        tipo_usuario="D";
        prioridad=1;
        totalDiscapacidad++;
    }//GEN-LAST:event_BotonDiscapacidadActionPerformed

    private void BotonAdultoMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAdultoMayorActionPerformed
        tipo_usuario="M";
        prioridad=2;
        totalAdultoMayor++;
    }//GEN-LAST:event_BotonAdultoMayorActionPerformed

    private void BotonEmbarazadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEmbarazadaActionPerformed
        tipo_usuario="E";
        prioridad=3;
        totalEmbarazadas++;
    }//GEN-LAST:event_BotonEmbarazadaActionPerformed

    private void BotonRegularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegularActionPerformed
        tipo_usuario="R";
        prioridad=4;
        totalRegulares++;
    }//GEN-LAST:event_BotonRegularActionPerformed

    private void BotonPerecederoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPerecederoActionPerformed
        tipo_paquete="P";
        totalPerecederos++;
    }//GEN-LAST:event_BotonPerecederoActionPerformed

    private void BotonNoPerecederoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNoPerecederoActionPerformed
        tipo_paquete="NP";
        totalNoPerecederos++;
    }//GEN-LAST:event_BotonNoPerecederoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        colaFichas.imprimir();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        tiempoEspera();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        tiempoEspera();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void TotalVentanasLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalVentanasLabActionPerformed
        int r;
        r=X.contadorVentanasNP+X.contadorVentanasP;
    }//GEN-LAST:event_TotalVentanasLabActionPerformed
/**
 * El boton actualiza las estadisticas de varios totales y ventanas
 * @param evt 
 */
    private void ActualizarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarBotonActionPerformed
        String modificador;
        modificador=Integer.toString(totalAdultoMayor);
        AdultoMayorLab.setText(modificador);
        modificador=Integer.toString(totalEmbarazadas);
        EmbarazadasLab.setText(modificador);
        modificador=Integer.toString(totalDiscapacidad);
        DiscapacidadLab.setText(modificador);
        modificador=Integer.toString(totalRegulares);
        RegularLab.setText(modificador);
        modificador=Integer.toString(tiempoPromedio());
        TiempoPromedioLab.setText(modificador);
        modificador=Integer.toString(totalPerecederos);
        PerecederosLab.setText(modificador);
        modificador=Integer.toString(totalNoPerecederos);
        NoPerecederosLab.setText(modificador);
        modificador=Integer.toString(totalVentanasP+totalVentanasNP);
        TotalVentanasLab.setText(modificador);
        if(tipoPerecedero=="cola"){
            TipoVentanasPLab.setText("Cola");
        }
        else{
            TipoVentanasPLab.setText("Heap");
        }
        if(tipoNoPerecedero=="cola"){
            TipoVentanasNPLab.setText("Cola");
        }
        else{
            TipoVentanasNPLab.setText("Heap");
        }
    }//GEN-LAST:event_ActualizarBotonActionPerformed

    private void PerecederosLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerecederosLabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PerecederosLabActionPerformed

        private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        Xcliente.getCantM();
    }                                           

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        Xcliente.getCantE();
    }                                           

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        Xcliente.getCantD();
    }                                           

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        Xcliente.getCantR();
    }                                           

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        Xficha.getFichasP();
    }                                           

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        Xficha.getFichasNP();
    }                                           

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        colaFichas.getFrente();
    }     
     
    private void jTextField13ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        colaSeguridad.getFrente();
    }                     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarBoton;
    private javax.swing.JTextField AdultoMayorLab;
    private javax.swing.JButton BotonAdultoMayor;
    private javax.swing.JButton BotonDiscapacidad;
    private javax.swing.JButton BotonEmbarazada;
    private javax.swing.JButton BotonNoPerecedero;
    private javax.swing.JButton BotonPerecedero;
    private javax.swing.JButton BotonRegular;
    private javax.swing.JButton BotonVentana1NP;
    private javax.swing.JButton BotonVentana1P;
    private javax.swing.JButton BotonVentana2NP;
    private javax.swing.JButton BotonVentana2P;
    private javax.swing.JButton BotonVentana3NP;
    private javax.swing.JButton BotonVentana3P;
    private javax.swing.JTextField DiscapacidadLab;
    private javax.swing.JTextField EmbarazadasLab;
    private javax.swing.JTextField NoPerecederosLab;
    private javax.swing.JTextField PerecederosLab;
    private javax.swing.JTextField RegularLab;
    private javax.swing.JTextField TiempoPromedioLab;
    private javax.swing.JTextField TipoVentanasNPLab;
    private javax.swing.JTextField TipoVentanasPLab;
    private javax.swing.JTextField TotalVentanasLab;
    private javax.swing.JLabel Ventana1NPLabel;
    private javax.swing.JLabel Ventana1PLabel;
    private javax.swing.JLabel Ventana2NPLabel;
    private javax.swing.JLabel Ventana2PLabel;
    private javax.swing.JLabel Ventana3NPLabel;
    private javax.swing.JLabel Ventana3PLabel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPaquete;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JTextField jTextCorreo;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextNombre;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    // End of variables declaration//GEN-END:variables
}
