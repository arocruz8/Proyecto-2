package interfaz;
import quiosco.*;
import estructurasDatos.*;
import colas_prioridad.*;
import javax.swing.JOptionPane;

public class DatosCliente extends javax.swing.JFrame{ 
        
    cliente Xcliente= new cliente();
    ficha Xficha= new ficha();
    
    ColaPrioridad c1 = new ColaPrioridad();
    ColaPrioridad c2 = new ColaPrioridad();
    heap h2 = new heap(20);
    heap h1 = new heap(20);
    ColaPrioridad colaSeguridad= new ColaPrioridad();
    ColaPrioridad colaFichas = new ColaPrioridad();
    
    //atributos clientes
    public static String nombre;
    public static String correo;
    public static String tipo_usuario;
    public static String tipo_paquete;
    public static int prioridad;
    
    //atributos ficha
    public static String tipoPaquete;
    public static String tipoUsuario;
    
    //contadores
    public static int totalDiscapacidad;
    public static int totalEmbarazadas;
    public static int totalRegulares;
    public static int totalAdultoMayor;
    public static int totalPerecederos;
    public static int totalNoPerecederos;
    
    //cola
    public static String tipoPerecedero;
    public static String tipoNoPerecedero;
    
    //constructores
    public DatosCliente(){
       initComponents();
    }
    
    
    public DatosCliente(String tipoP, String tipoNP, int contadorP, int contadorNP) {
        initComponents();
        tipoPerecedero=tipoP;
        tipoNoPerecedero=tipoNP;
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
    
    public void agregarDatos(){
        cliente data = new cliente();
        nombre=jTextNombre.getText();
        correo=jTextCorreo.getText();
        //tipo_usuario=jTextUsuario.getText();
        //tipo_paquete=jTextPaquete.getText();
        
        data.setNombre(nombre);
        data.setCorreo(correo);
        data.setTipo_usuario(tipo_usuario);
        data.setTipo_paquete(tipo_paquete);
        data.setPrioridad(prioridad);

        int priority = prioridad;
        
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
    
    public void mostrar(){
        c1.imprimir();
        c2.imprimir();
        System.out.println(h1.tamañoArreglo());
        System.out.println(h2.tamañoArreglo());
    }
    
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jButton1 = new javax.swing.JButton();
        panel4 = new java.awt.Panel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();

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

        jButton1.setText("Generar claves de seguridad");

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Administrador");

        jLabel10.setText("Tiempo de espera");

        jLabel11.setText("Cantidad ventanillas visibles");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jLabel12.setText("Cantidad de paquetes Percederos");

        jTextField4.setText("jTextField4");

        jLabel13.setText("Cantidad de paquetes no percederos");

        jTextField5.setText("jTextField5");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Cantidad de ficahas dispensadas");

        jLabel15.setText("Adulto mayor");

        jTextField6.setText("jTextField6");

        jLabel16.setText("Embarazadas");

        jTextField7.setText("jTextField7");

        jLabel17.setText("Discapacidad");

        jTextField8.setText("jTextField8");

        jLabel18.setText("Regular");

        jTextField9.setText("jTextField9");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Entrega");

        jTextField1.setText("jTextField1");

        jTextField10.setText("jTextField10");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Seguridad");

        jTextField11.setText("jTextField11");
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        jTextField12.setText("jTextField12");

        jTextField13.setText("jTextField13");

        jTextField14.setText("jTextField14");

        jTextField15.setText("jTextField15");

        jTextField16.setText("jTextField16");

        jTextField17.setText("jTextField17");

        jTextField18.setText("jTextField18");

        jTextField19.setText("jTextField19");

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(39, 39, 39)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(32, 32, 32)
                                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField14, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField15, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField16, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
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
                                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
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
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(9, 9, 9)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(48, Short.MAX_VALUE))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField13))
                        .addGap(53, 53, 53))))
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
        if(c1.estaVacia()==false){
            BotonVentana2P.setText("Liberar y atender");
            cliente info=(cliente) c1.desacolar();
            h1.eliminar();
            JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre()+" en Ventana 2");
            int prioridad=4;
            if("P".equals(info.getTipo_paquete())|"p".equals(info.getTipo_paquete())){
                prioridad=1;
            }
            if("NP".equals(info.getTipo_paquete())|"np".equals(info.getTipo_paquete())){
                prioridad=2;
            }
            colaSeguridad.agregar(prioridad, info);
        }
        else{
            BotonVentana2P.setText("Atender");
        }
    }//GEN-LAST:event_BotonVentana2PActionPerformed

    private void BotonVentana3PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentana3PActionPerformed
        if(c1.estaVacia()==false){
            BotonVentana3P.setText("Liberar y atender");
            cliente info=(cliente) c1.desacolar();
            h1.eliminar();
            JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre()+" en Ventana 3");
            int prioridad=4;
            if("P".equals(info.getTipo_paquete())|"p".equals(info.getTipo_paquete())){
                prioridad=1;
            }
            if("NP".equals(info.getTipo_paquete())|"np".equals(info.getTipo_paquete())){
                prioridad=2;
            }
            colaSeguridad.agregar(prioridad, info);
        }
        else{
            BotonVentana3P.setText("Atender");
        }
    }//GEN-LAST:event_BotonVentana3PActionPerformed

    private void BotonVentana1NPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentana1NPActionPerformed
        if(c1.estaVacia()==false){
            BotonVentana1NP.setText("Liberar y atender");
            cliente info=(cliente) c1.desacolar();
            h1.eliminar();
            JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre()+" en Ventana 1");
            int prioridad=4;
            if("P".equals(info.getTipo_paquete())|"p".equals(info.getTipo_paquete())){
                prioridad=1;
            }
            if("NP".equals(info.getTipo_paquete())|"np".equals(info.getTipo_paquete())){
                prioridad=2;
            }
            colaSeguridad.agregar(prioridad, info);
        }
        else{
            BotonVentana1NP.setText("Atender");
        }
    }//GEN-LAST:event_BotonVentana1NPActionPerformed

    private void BotonVentana2NPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentana2NPActionPerformed
        if(c1.estaVacia()==false){
            BotonVentana2NP.setText("Liberar y atender");
            cliente info=(cliente) c1.desacolar();
            h1.eliminar();
            JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre()+" en Ventana 1");
            int prioridad=4;
            if("P".equals(info.getTipo_paquete())|"p".equals(info.getTipo_paquete())){
                prioridad=1;
            }
            if("NP".equals(info.getTipo_paquete())|"np".equals(info.getTipo_paquete())){
                prioridad=2;
            }
            colaSeguridad.agregar(prioridad, info);
        }
        else{
            BotonVentana2NP.setText("Atender");
        }
    }//GEN-LAST:event_BotonVentana2NPActionPerformed

    private void BotonVentana3NPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentana3NPActionPerformed
        if(c1.estaVacia()==false){
            BotonVentana3NP.setText("Liberar y atender");
            cliente info=(cliente) c1.desacolar();
            h1.eliminar();
            JOptionPane.showMessageDialog(null,"Atendiendo a "+info.getNombre()+" en Ventana 1");
            int prioridad=4;
            if("P".equals(info.getTipo_paquete())|"p".equals(info.getTipo_paquete())){
                prioridad=1;
            }
            if("NP".equals(info.getTipo_paquete())|"np".equals(info.getTipo_paquete())){
                prioridad=2;
            }
            colaSeguridad.agregar(prioridad, info);
        }
        else{
            BotonVentana3NP.setText("Atender");
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

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
        c1.getFrente();
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        colaFichas.imprimir();
    }//GEN-LAST:event_jButton2ActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel Ventana1NPLabel;
    private javax.swing.JLabel Ventana1PLabel;
    private javax.swing.JLabel Ventana2NPLabel;
    private javax.swing.JLabel Ventana2PLabel;
    private javax.swing.JLabel Ventana3NPLabel;
    private javax.swing.JLabel Ventana3PLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPaquete;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JTextField jTextCorreo;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextNombre;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    // End of variables declaration//GEN-END:variables
}
