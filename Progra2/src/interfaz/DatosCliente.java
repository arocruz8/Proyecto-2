package interfaz;
import quiosco.*;
import estructurasDatos.*;
import colas_prioridad.*;
import javax.swing.JOptionPane;

public class DatosCliente extends javax.swing.JFrame {
    
    ColaPrioridad c1 = new ColaPrioridad();
    heap h1 = new heap(10);
    ColaPrioridad colaSeguridad= new ColaPrioridad();
    
    //atributos clientes
    public static String nombre;
    public static String correo;
    public static String tipo_usuario;
    public static String tipo_paquete;
    
    //atributos ficha
    public static String tipoPaquete;
    public static String tipoUsuario;
    
    //cliente info = new cliente();
    
    //constructores
    public DatosCliente(){
       initComponents();
    }
    
    
    public DatosCliente(int contador_colaP,int contador_heapP,int contador_colaNP,int contador_heapNP) {
        initComponents();
        /**
         * Los labels y los botones se muestran dependiendo de cuantas ventanas se hayan solicitado
         */
        if(contador_colaP>=1|contador_heapP>=1){
            Ventana1PLabel.setVisible(true);
            BotonVentana1P.setVisible(true);
        }
        else{
            Ventana1PLabel.setVisible(false);
            BotonVentana1P.setVisible(false);
        }
        if(contador_colaP>=2|contador_heapP>=2){
            Ventana2PLabel.setVisible(true);
            BotonVentana2P.setVisible(true);
        }
        else{
            Ventana2PLabel.setVisible(false);
            BotonVentana2P.setVisible(false);
        }
        if(contador_colaP>=3|contador_heapP>=3){
            Ventana3PLabel.setVisible(true);
            BotonVentana3P.setVisible(true);
        }
        else{
            Ventana3PLabel.setVisible(false);
            BotonVentana3P.setVisible(false);
        }
        
        if(contador_colaNP>=1|contador_heapNP>=1){
            Ventana1NPLabel.setVisible(true);
            BotonVentana1NP.setVisible(true);
        }
        else{
            Ventana1NPLabel.setVisible(false);
            BotonVentana1NP.setVisible(false);
        }
        if(contador_colaNP>=2|contador_heapNP>=2){
            Ventana2NPLabel.setVisible(true);
            BotonVentana2NP.setVisible(true);
        }
        else{
            Ventana2NPLabel.setVisible(false);
            BotonVentana2NP.setVisible(false);
        }
        if(contador_colaNP>=3|contador_heapNP>=3){
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
        tipo_usuario=jTextUsuario.getText();
        tipo_paquete=jTextPaquete.getText();
        int prioridad=Integer.parseInt(jTextPrioriadad.getText());
        
        data.setNombre(nombre);
        data.setCorreo(correo);
        data.setTipo_usuario(tipo_usuario);
        data.setTipo_paquete(tipo_paquete);
        data.setPrioridad(prioridad);

        int priority = prioridad;
        
        c1.agregar(priority, data);
        h1.añadir(data, priority);
    }
    
    public void mostrar(){
        c1.imprimir();
        System.out.println(h1.tamañoArreglo());
    }
    
    public void generarficha(){
        ficha f =new ficha(tipoPaquete, tipoUsuario);
        tipoPaquete = jTextPaquete.getText();
        tipoUsuario = jTextUsuario.getText();
        
        f.setTipoPaquete(tipoPaquete);
        f.setTipoUsuario(tipoUsuario);
        f.getFichasP();
        f.getFichasNP();
        f.getCodigoFicha();
        
        ventanaFicha vf = new ventanaFicha(tipoPaquete, tipoUsuario);
        vf.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jLabelPaquete = new javax.swing.JLabel();
        jTextPaquete = new javax.swing.JTextField();
        jLabelUsuario = new javax.swing.JLabel();
        jTextUsuario = new javax.swing.JTextField();
        jLabelCorreo = new javax.swing.JLabel();
        jTextCorreo = new javax.swing.JTextField();
        jTextNombre = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextPrioriadad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
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

        jLabel5.setText("Prioridad");

        jTextPrioriadad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPrioriadadActionPerformed(evt);
            }
        });

        jLabel6.setText("discapacidad [D], adulto mayor [M], mujer embarazada [E], cliente regular [R])");

        jLabel7.setText("D->1, M->2, E->3, R->4");

        jButton7.setText("Generar Ficha");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel19.setText("NP -> no percederos y P -> percederos");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addGap(36, 36, 36))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(63, 349, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(jLabelUsuario)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelCorreo)
                                        .addComponent(jLabelNombre))
                                    .addGap(36, 36, 36)
                                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel7)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(40, 40, 40)
                                        .addComponent(jTextPrioriadad, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(jLabelPaquete)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPaquete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextPrioriadad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton7))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(39, 39, 39)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(26, 26, 26)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel14))
                .addGap(12, 12, 12)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))))
                .addContainerGap(104, Short.MAX_VALUE))
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
                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

    private void jTextPrioriadadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPrioriadadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrioriadadActionPerformed

    private void BotonVentana1PActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVentana1PActionPerformed
        if(c1.estaVacia()==false){
            BotonVentana1P.setText("Liberar y atender");
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
            BotonVentana1P.setText("Atender");
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



    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextPaquete;
    private javax.swing.JTextField jTextPrioriadad;
    private javax.swing.JTextField jTextUsuario;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    // End of variables declaration//GEN-END:variables
}
