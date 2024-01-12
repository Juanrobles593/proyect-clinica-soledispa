
package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.Persona;
import modelo.Especialidad;

/**
 *  Clase que contiene el Panel de registro de persona
 *  @since 21 de Agosto
 *  @version POO 2-8 2023
 *  @author Robles Juan & Castro Avila
 */
public class PnlRegistroPersona extends JPanel{
    private JPanel pnlThisSur,pnlRegistro;
    private JButton btnAgregarTel;
    private JButton btnAgregarDir;
    private JPanel pnlRegistroSub1,pnlRegistroSub1Center, pnlRegistroSub1South;
    private JButton btnRegistrar, btnCancelar;
    private JLabel lblNombre;
    private JLabel lblApellidos;
    private JLabel lblCedula;
    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JTextField txtCedula;
    private JLabel lblEspecialidad;
    private JComboBox<Especialidad> cbEspecialidad;
    private JPanel pnlRegistroSub2;
    private FrmHospitalListener f;
    private Persona p;
    
    /**
     * Constructor del Panel de registro de Personas
     * @param f contiene una referencia a la ventana principal para poder acceder a ella
     */
    public PnlRegistroPersona(FrmHospitalListener f) {
        this.f = f;
        initComponents();
        addListeners();
    }
    
    /**
     * Constructor del Panel de registro de Personas que muestra los datos de la persona.
     * @param f contiene una referencia a la ventana principal para poder acceder a ella
     * @param p contiene un objeto Persona
     */
//    public PnlRegistroPersona(FrmHospitalListener f, Persona p) {
//        this.f = f;
//        this.p = p;
//        initComponents();
//        System.out.println("hola");
//        txtNombre.setText(p.getNombre());
//        txtApellidos.setText(p.getApellidos());
//        txtCedula.setText(p.getCedula());
//        
//        if(p.getClass() == Medico.class){
//            Medico m = (Medico)p;
//            cbEspecialidad.setSelectedItem(m.getEspecialidad());
//        }else{
//            cbEspecialidad.setVisible(false);
//            lblEspecialidad.setVisible(false);
//        }
//        btnAgregarDir.setText("Ver direccion(es)");
//        btnAgregarTel.setText("Ver telefono(s)");
//        btnRegistrar.setVisible(false);
//        btnCancelar.setText("Regresar");
//        txtNombre.setEditable(false);
//        txtApellidos.setEditable(false);
//        txtCedula.setEditable(false);
//        addListeners();
//    }
    /**
     * Metodo que inicializa los componentes del PnlRegistroPersonas
     */
    private void initComponents(){
        this.setLayout(new BorderLayout());
        pnlRegistro=new JPanel(new GridLayout(2,1));
        this.add(pnlRegistro,BorderLayout.CENTER);
        
        pnlRegistroSub1 = new JPanel(new BorderLayout());
        pnlRegistroSub2 = new JPanel(new BorderLayout());
        pnlRegistro.add(pnlRegistroSub1);
        pnlRegistro.add(pnlRegistroSub2);

        pnlThisSur = new JPanel();
        this.add(pnlThisSur, BorderLayout.SOUTH);
        
        pnlRegistroSub1.add(new JLabel("              "),BorderLayout.NORTH);
        pnlRegistroSub1.add(new JLabel("              "),BorderLayout.WEST);
        pnlRegistroSub1.add(new JLabel("              "),BorderLayout.EAST);
        
        pnlRegistroSub1South = new JPanel();
        pnlRegistroSub1.add(pnlRegistroSub1South,BorderLayout.SOUTH);
        btnAgregarTel = new JButton(" Telefono(s)");
        pnlRegistroSub1South.add(btnAgregarTel);
        btnAgregarDir = new JButton("Dirección(s)");
        pnlRegistroSub1South.add(btnAgregarDir);
        
        pnlRegistroSub1Center= new JPanel(new GridLayout(6,2,10,5));
        pnlRegistroSub1.add(pnlRegistroSub1Center,BorderLayout.CENTER);
        
        btnRegistrar = new JButton("Registrar");
        btnCancelar = new JButton("Cancelar");
        pnlThisSur.add(btnRegistrar, BorderLayout.SOUTH);
        pnlThisSur.add(btnCancelar, BorderLayout.SOUTH);
        
        lblNombre = new JLabel("Nombre");
        lblApellidos = new JLabel("Apellidos");
        lblCedula = new JLabel("Cedula");        
        txtNombre = new JTextField();
        txtApellidos = new JTextField();
        txtCedula = new JTextField();
        lblEspecialidad = new JLabel ("Especialidad");
        cbEspecialidad = new JComboBox<>(Especialidad.values());
        cbEspecialidad.setSelectedItem(0);
        
        pnlRegistroSub1Center.add(lblNombre);
        pnlRegistroSub1Center.add(lblEspecialidad);
        pnlRegistroSub1Center.add(txtNombre);
        pnlRegistroSub1Center.add(cbEspecialidad);
        pnlRegistroSub1Center.add(lblApellidos); 
        pnlRegistroSub1Center.add(new JLabel("              "));
        pnlRegistroSub1Center.add(txtApellidos); 
        pnlRegistroSub1Center.add(new JLabel("              "));
        pnlRegistroSub1Center.add(lblCedula); 
        pnlRegistroSub1Center.add(new JLabel("Recuerde llenar el campo cedula solo con números"));
        pnlRegistroSub1Center.add(txtCedula);
        
    }
    /**
     * Metodo que añade escuchadores a los elementos del Panel de Registro de Personas(Medicos y Pacientes)
     */
    private void addListeners(){
        PnlRegistroPersonaListener listener = new PnlRegistroPersonaListener(this);
        btnRegistrar.addActionListener(listener);
        btnCancelar.addActionListener(listener);
        btnAgregarDir.addActionListener(listener);
        btnAgregarTel.addActionListener(listener);
    }

    /**
     *
     * @return
     */
    public JButton getBtnAgregarTel() {
        return btnAgregarTel;
    }

    /**
     *
     * @return
     */
    public JButton getBtnAgregarDir() {
        return btnAgregarDir;
    }

    /**
     *
     * @return
     */
    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    /**
     *
     * @return
     */
    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtApellidos() {
        return txtApellidos;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtCedula() {
        return txtCedula;
    }

    /**
     *
     * @return
     */
    public JLabel getLblEspecialidad() {
        return lblEspecialidad;
    }

    /**
     *
     * @return
     */
    public JComboBox<Especialidad> getCbEspecialidad() {
        return cbEspecialidad;
    }

    /**
     *
     * @return
     */
    public FrmHospitalListener getF() {
        return f;
    }
    /**
     * Método que devuelve el objeto de p
     * @return p
     */
    public Persona getP() {
        return p;
    }
    
    
    
}
