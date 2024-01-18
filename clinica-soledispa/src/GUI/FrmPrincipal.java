package GUI;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Frame principal del sistema, el login de ingreso al sistema.
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class FrmPrincipal extends javax.swing.JFrame {  
    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        pnlBackGround = new javax.swing.JScrollPane();
        bg = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblPasword = new javax.swing.JLabel();
        spt1 = new javax.swing.JSeparator();
        spt2 = new javax.swing.JSeparator();
        txtPassword = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        btnIniciarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        mb = new javax.swing.JMenuBar();
        mnPrincipal = new javax.swing.JMenu();
        mniInicio = new javax.swing.JMenuItem();
        mniCerrarSesion = new javax.swing.JMenuItem();
        mniSalir = new javax.swing.JMenuItem();
        mniAyuda = new javax.swing.JMenuItem();
        mnMedico = new javax.swing.JMenu();
        mniRegistrarMedico = new javax.swing.JMenuItem();
        mniRegistrarMedico1 = new javax.swing.JMenuItem();
        mnPaciente = new javax.swing.JMenu();
        mniRegistrarPaciente = new javax.swing.JMenuItem();
        mniRegistrarPaciente1 = new javax.swing.JMenuItem();
        mnRecepcionista = new javax.swing.JMenu();
        mniRegistrarRecepcionista = new javax.swing.JMenuItem();
        mniRegistrarRecepcionista1 = new javax.swing.JMenuItem();
        mnEnfermero = new javax.swing.JMenu();
        mniRegistrarEnfermero = new javax.swing.JMenuItem();
        mniRegistrarEnfermero1 = new javax.swing.JMenuItem();
        mnCitaMedica = new javax.swing.JMenu();
        mniAgendar = new javax.swing.JMenuItem();
        mniReprogramar = new javax.swing.JMenuItem();
        mniConsultar = new javax.swing.JMenuItem();
        mnReprogramar2 = new javax.swing.JMenuItem();
        mnEnfermero1 = new javax.swing.JMenu();
        mniRegistrarEnfermero2 = new javax.swing.JMenuItem();
        mniRegistrarEnfermero3 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clinica Soledispa");
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(1, 1));
        setLocationByPlatform(true);
        setSize(new java.awt.Dimension(1155, 540));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pnlBackGround.setPreferredSize(new java.awt.Dimension(1070, 520));
        pnlBackGround.setRequestFocusEnabled(false);
        pnlBackGround.setViewportView(null);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(1070, 520));

        lblUsuario.setBackground(new java.awt.Color(0, 0, 255));
        lblUsuario.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(0, 0, 102));
        lblUsuario.setText("USUARIO");

        lblPasword.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        lblPasword.setForeground(new java.awt.Color(0, 0, 102));
        lblPasword.setText("CONTRASEÑA");

        spt1.setBackground(new java.awt.Color(0, 0, 255));

        spt2.setBackground(new java.awt.Color(51, 51, 255));

        txtPassword.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(153, 153, 153));
        txtPassword.setText("**********");
        txtPassword.setBorder(null);
        txtPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPassword.setFocusable(false);

        txtUsuario.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtUsuario.setText("Ingrese su usuario");
        txtUsuario.setBorder(null);
        txtUsuario.setFocusable(false);

        btnIniciarSesion.setBackground(new java.awt.Color(51, 204, 255));
        btnIniciarSesion.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("INICIAR SESIÓN");
        btnIniciarSesion.setToolTipText("");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/images/icon-logo-clinica.png"))); // NOI18N
        jLabel1.setText("   ");
        jLabel1.setPreferredSize(new java.awt.Dimension(587, 164));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(443, 443, 443)
                        .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsuario)
                            .addComponent(spt2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPasword)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spt1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spt2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPasword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spt1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
        );

        pnlBackGround.setViewportView(bg);

        getContentPane().add(pnlBackGround);

        mb.setBackground(new java.awt.Color(102, 204, 255));
        mb.setBorder(null);
        mb.setAlignmentY(0.1F);
        mb.setBorderPainted(false);

        mnPrincipal.setForeground(new java.awt.Color(51, 51, 51));
        mnPrincipal.setText("INICIO");
        mnPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mnPrincipal.setFont(new java.awt.Font("Nirmala UI", 1, 10)); // NOI18N

        mniInicio.setBackground(new java.awt.Color(204, 204, 204));
        mniInicio.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        mniInicio.setText("Inicio");
        mnPrincipal.add(mniInicio);

        mniCerrarSesion.setBackground(new java.awt.Color(204, 204, 204));
        mniCerrarSesion.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        mniCerrarSesion.setText("Cerrar Sesión");
        mnPrincipal.add(mniCerrarSesion);

        mniSalir.setBackground(new java.awt.Color(204, 204, 204));
        mniSalir.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        mniSalir.setText("Salir");
        mnPrincipal.add(mniSalir);

        mniAyuda.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        mniAyuda.setText("Ayuda");
        mnPrincipal.add(mniAyuda);

        mb.add(mnPrincipal);

        mnMedico.setText("MEDICOS");

        mniRegistrarMedico.setText("REGISTRAR");
        mnMedico.add(mniRegistrarMedico);

        mniRegistrarMedico1.setText("REPORTE");
        mnMedico.add(mniRegistrarMedico1);

        mb.add(mnMedico);

        mnPaciente.setText("PACIENTE");

        mniRegistrarPaciente.setText("REGISTRAR");
        mnPaciente.add(mniRegistrarPaciente);

        mniRegistrarPaciente1.setText("REPORTE");
        mnPaciente.add(mniRegistrarPaciente1);

        mb.add(mnPaciente);

        mnRecepcionista.setText("RECEPCIONISTA");

        mniRegistrarRecepcionista.setText("REGISTRAR");
        mnRecepcionista.add(mniRegistrarRecepcionista);

        mniRegistrarRecepcionista1.setText("REPORTE");
        mnRecepcionista.add(mniRegistrarRecepcionista1);

        mb.add(mnRecepcionista);

        mnEnfermero.setText("ENFERMERO");

        mniRegistrarEnfermero.setText("REGISTRAR");
        mnEnfermero.add(mniRegistrarEnfermero);

        mniRegistrarEnfermero1.setText("REPORTE");
        mnEnfermero.add(mniRegistrarEnfermero1);

        mb.add(mnEnfermero);

        mnCitaMedica.setText("CITAS MÉDICAS");

        mniAgendar.setText("AGENDAR");
        mnCitaMedica.add(mniAgendar);

        mniReprogramar.setText("REPROGRAMAR");
        mnCitaMedica.add(mniReprogramar);

        mniConsultar.setText("CONSULTAR");
        mnCitaMedica.add(mniConsultar);

        mnReprogramar2.setText("TOMAR SIGNOS VITALES");
        mnCitaMedica.add(mnReprogramar2);

        mb.add(mnCitaMedica);

        mnEnfermero1.setText("USUARIOS");

        mniRegistrarEnfermero2.setText("EDITAR");
        mnEnfermero1.add(mniRegistrarEnfermero2);

        mniRegistrarEnfermero3.setText("REPORTE");
        mnEnfermero1.add(mniRegistrarEnfermero3);

        mb.add(mnEnfermero1);

        setJMenuBar(mb);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JMenuItem getMniCerrarSesion() {
        return mniCerrarSesion;
    }

    public JMenuItem getMniInicio() {
        return mniInicio;
    }

    public JMenu getMnPrincipal() {
        return mnPrincipal;
    }   

    public JMenuBar getMb() {
        return mb;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public JButton getBtnIniciarSesion() {
        return btnIniciarSesion;
    }

    public JMenuItem getMniAyuda() {
        return mniAyuda;
    }

    public JScrollPane getPnlBackGround() {
        return pnlBackGround;
    }

    public JMenuItem getMniRegistrarMedico() {
        return mniRegistrarMedico;
    }

    public JPanel getBg() {
        return bg;
    }

    public JMenuItem getMniSalir() {
        return mniSalir;
    }

    public JMenuItem getMniAgendar() {
        return mniAgendar;
    }

    public JMenuItem getMniConsultar() {
        return mniConsultar;
    }

    public JMenuItem getMniRegistrarRecepcionista() {
        return mniRegistrarRecepcionista;
    }

    public JMenuItem getMniReprogramar() {
        return mniReprogramar;
    }

    public JMenuItem getMniRegistrarEnfermero() {
        return mniRegistrarEnfermero;
    }

    public JMenuItem getMniRegistrarPaciente() {
        return mniRegistrarPaciente;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel lblPasword;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuBar mb;
    private javax.swing.JMenu mnCitaMedica;
    private javax.swing.JMenu mnEnfermero;
    private javax.swing.JMenu mnEnfermero1;
    private javax.swing.JMenu mnMedico;
    private javax.swing.JMenu mnPaciente;
    private javax.swing.JMenu mnPrincipal;
    private javax.swing.JMenu mnRecepcionista;
    private javax.swing.JMenuItem mnReprogramar2;
    private javax.swing.JMenuItem mniAgendar;
    private javax.swing.JMenuItem mniAyuda;
    private javax.swing.JMenuItem mniCerrarSesion;
    private javax.swing.JMenuItem mniConsultar;
    private javax.swing.JMenuItem mniInicio;
    private javax.swing.JMenuItem mniRegistrarEnfermero;
    private javax.swing.JMenuItem mniRegistrarEnfermero1;
    private javax.swing.JMenuItem mniRegistrarEnfermero2;
    private javax.swing.JMenuItem mniRegistrarEnfermero3;
    private javax.swing.JMenuItem mniRegistrarMedico;
    private javax.swing.JMenuItem mniRegistrarMedico1;
    private javax.swing.JMenuItem mniRegistrarPaciente;
    private javax.swing.JMenuItem mniRegistrarPaciente1;
    private javax.swing.JMenuItem mniRegistrarRecepcionista;
    private javax.swing.JMenuItem mniRegistrarRecepcionista1;
    private javax.swing.JMenuItem mniReprogramar;
    private javax.swing.JMenuItem mniSalir;
    private javax.swing.JScrollPane pnlBackGround;
    private javax.swing.JSeparator spt1;
    private javax.swing.JSeparator spt2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
