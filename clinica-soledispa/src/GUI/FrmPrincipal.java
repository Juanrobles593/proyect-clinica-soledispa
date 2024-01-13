package GUI;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author ROBLES MORALES
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

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto Primer Parcial");
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(1, 1));
        setLocationByPlatform(true);
        setSize(new java.awt.Dimension(785, 510));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        pnlBackGround.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pnlBackGround.setPreferredSize(new java.awt.Dimension(785, 520));
        pnlBackGround.setViewportView(null);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(1366, 681));

        lblUsuario.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        lblUsuario.setText("USUARIO");

        lblPasword.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        lblPasword.setText("CONTRASEÑA");

        spt1.setBackground(new java.awt.Color(153, 153, 153));

        spt2.setBackground(new java.awt.Color(153, 153, 153));

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

        btnIniciarSesion.setBackground(new java.awt.Color(51, 102, 255));
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("INICIAR SESIÓN");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/icon-logo-clinica.png"))); // NOI18N
        jLabel1.setText("   ");
        jLabel1.setPreferredSize(new java.awt.Dimension(587, 164));

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(500, 500, 500)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsuario)
                            .addComponent(lblPasword)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spt2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spt1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)))
                .addGap(370, 370, 370))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(81, 81, 81)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(spt2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPasword)
                .addGap(18, 18, 18)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spt1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );

        pnlBackGround.setViewportView(bg);

        getContentPane().add(pnlBackGround);

        mb.setBackground(new java.awt.Color(255, 255, 255));
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel lblPasword;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuBar mb;
    private javax.swing.JMenu mnPrincipal;
    private javax.swing.JMenuItem mniAyuda;
    private javax.swing.JMenuItem mniCerrarSesion;
    private javax.swing.JMenuItem mniInicio;
    private javax.swing.JMenuItem mniSalir;
    private javax.swing.JScrollPane pnlBackGround;
    private javax.swing.JSeparator spt1;
    private javax.swing.JSeparator spt2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
