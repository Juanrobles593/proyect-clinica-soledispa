
package gui;

import modelo.Medico;
import modelo.Paciente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.Persona;
import modelo.Especialidad;
/**
 * Clase JPanel, coentiene los elementos para el registro de la consulta.
 * @author ROBLES MORALES
 * @version POO-2023
 */
public class PnlRegistroConsulta extends JPanel{
    private JPanel pnlConsultaCenter, pnlConsultaSouth;
    private JPanel pnlConsultaCenterSub1,pnlConsultaCenterSub2;
    private JLabel lblTitlePaciente;
    private JLabel lblIdPac;
    private JLabel lblNombrePac;
    private JLabel lblApellidosPac;
    private JComboBox<Especialidad> cbEspecialidad;
    private JComboBox<String> cbMedicos;
    private List<Medico> lstMedicos;
    private List<Paciente> lstPacientes;
    private List<Medico> lstMedicoSelect;
    private JLabel lblTitleMedico;
    private JLabel lblEspecialidadMed;
    private JLabel lblNombreMed;
    private JLabel lblHabitacion;
    private JTextField txtIdPac;
    private JTextField txtNombrePac;
    private JTextField txtApellidosPac;
    private JTextField txtHabitacion;
    private JTextArea txtADiagnostico;
    private JTextArea txtAReceta;
    private JScrollPane sPaneDiagnostico,sPaneReceta;
    private JButton btnRegistrar;
    private JButton btnCancelar;
    private JButton btnBuscar;
    private JLabel lblTitleDiagnostico;
    private final Color blueWarmColor = new Color(0, 102, 204);
    private final Font CandaraFont = new Font("Candara", Font.BOLD, 18);
    private JLabel titleReceta;
    private FrmHospitalListener f;
    private Persona p;
    /**
     * Constructor de la clase
     * @param f  rererencia al panel donde fue llamado.
     */
    public PnlRegistroConsulta(FrmHospitalListener f) {
        this.f = f;
        initComponents();
        
    }
    /**
     * Método Constructor que recibe la referencia del FrmListener y una Persona
     * @param f referencia a la clase escuchadora.
     * @param p referencia a la persona que se ulitliza sus datos.
     */
    public PnlRegistroConsulta(FrmHospitalListener f, Persona p) {
        this.f = f;
        initComponents();
        
    }
    /**
     * Método que inicializa los componentes del Panel
     */
    private void initComponents(){
       
        this.setLayout(new BorderLayout());
        
        this.add(espacioBacio(),BorderLayout.NORTH);
        this.add(espacioBacio(),BorderLayout.WEST);
        this.add(espacioBacio(),BorderLayout.EAST);
        
        pnlConsultaCenter =new JPanel(new GridLayout(2,1));
        this.add(pnlConsultaCenter, BorderLayout.CENTER);
        pnlConsultaSouth =new JPanel(new FlowLayout());
        this.add(pnlConsultaSouth, BorderLayout.SOUTH);
        
        pnlConsultaCenterSub1=new JPanel(new GridLayout(8,2,5,1));
        pnlConsultaCenterSub2 = new JPanel(new GridLayout(1,2,5,5));
        pnlConsultaCenter.add(pnlConsultaCenterSub1);
        pnlConsultaCenter.add(pnlConsultaCenterSub2);
  
        lblTitlePaciente= new JLabel("PACIENTE");
        lblIdPac = new JLabel("Id Historial o Cedula");
        lblNombrePac= new JLabel("Nombre");
        lblApellidosPac = new JLabel("Apellidos");
        
        cbEspecialidad = new JComboBox<>(Especialidad.values());
           
        cbMedicos = new JComboBox<>();
        cbMedicos.addItem("Seleccione una especialidad");
        cbMedicos.setEnabled(false);
        lblTitleMedico = new JLabel("MEDICO");
        lblEspecialidadMed = new JLabel("Especialidad");
        lblNombreMed = new JLabel("Nombres");
        lblHabitacion = new JLabel("Habitación");
        
        txtIdPac = new JTextField();
        txtNombrePac= new JTextField();
        txtNombrePac.setEditable(false);
        txtApellidosPac = new JTextField();
        txtApellidosPac.setEditable(false);
        txtHabitacion = new JTextField("");
        
        ImageIcon lupa= new ImageIcon("./src/recursos/lupaBuscar.jpeg");
        btnBuscar = new JButton(lupa);
        JPanel pnlBuscar=new JPanel(new BorderLayout());
        pnlBuscar.add(txtIdPac, BorderLayout.CENTER);
        pnlBuscar.add(btnBuscar, BorderLayout.EAST);
        
        pnlConsultaCenterSub1.add(lblTitlePaciente);
        lblTitlePaciente.setOpaque(true);
        lblTitlePaciente.setBackground(blueWarmColor);
        lblTitlePaciente.setForeground(Color.WHITE);
        lblTitlePaciente.setFont(CandaraFont);
        
        pnlConsultaCenterSub1.add(lblTitleMedico);
        lblTitleMedico.setOpaque(true);
        lblTitleMedico.setBackground(blueWarmColor);
        lblTitleMedico.setForeground(Color.WHITE);
        lblTitleMedico.setFont(CandaraFont);
        
        pnlConsultaCenterSub1.add(lblIdPac); 
        lblIdPac.setFont(CandaraFont);
        pnlConsultaCenterSub1.add(lblEspecialidadMed);
        lblEspecialidadMed.setFont(CandaraFont);
        pnlConsultaCenterSub1.add(pnlBuscar);
        pnlConsultaCenterSub1.add(cbEspecialidad);
        cbEspecialidad.setFont(CandaraFont);
        pnlConsultaCenterSub1.add(lblNombrePac);
        lblNombrePac.setFont(CandaraFont);       
        pnlConsultaCenterSub1.add(lblNombreMed);
        lblNombreMed.setFont(CandaraFont); 
        pnlConsultaCenterSub1.add(txtNombrePac);
        txtNombrePac.setFont(CandaraFont);        
        pnlConsultaCenterSub1.add(cbMedicos);
        cbMedicos.setFont(CandaraFont);    
        pnlConsultaCenterSub1.add(lblApellidosPac);
        lblApellidosPac.setFont(CandaraFont);       
        pnlConsultaCenterSub1.add(lblHabitacion);
        lblHabitacion.setFont(CandaraFont);      
        pnlConsultaCenterSub1.add(txtApellidosPac);
        txtApellidosPac.setFont(CandaraFont);
        pnlConsultaCenterSub1.add(txtHabitacion);
        txtHabitacion.setFont(CandaraFont);
        
        lblTitleDiagnostico = new JLabel(" Diagnostico");
        pnlConsultaCenterSub1.add(lblTitleDiagnostico);
        lblTitleDiagnostico.setOpaque(true);
        lblTitleDiagnostico.setBackground(blueWarmColor);
        lblTitleDiagnostico.setForeground(Color.WHITE);
        lblTitleDiagnostico.setFont(CandaraFont);
        titleReceta = new JLabel("  Receta");
        pnlConsultaCenterSub1.add(titleReceta);
        titleReceta.setOpaque(true);
        titleReceta.setBackground(blueWarmColor);
        titleReceta.setForeground(Color.WHITE);
        titleReceta.setFont(CandaraFont);
        
        txtADiagnostico = new JTextArea();
        txtADiagnostico.setLineWrap(true); 
        txtADiagnostico.setWrapStyleWord(true); 
        txtAReceta = new  JTextArea();
        txtAReceta.setLineWrap(true); 
        txtAReceta.setWrapStyleWord(true);

        sPaneDiagnostico = new JScrollPane(txtADiagnostico);
        sPaneReceta = new JScrollPane(txtAReceta);
        pnlConsultaCenterSub2.add(sPaneDiagnostico);
        pnlConsultaCenterSub2.add(sPaneReceta);
        
        btnRegistrar = new JButton(" Regitrar Consulta ");
        btnCancelar = new JButton(" Cancelar ");
        pnlConsultaSouth.add(btnRegistrar);
        pnlConsultaSouth.add(btnCancelar);
        
        addListeners();
    }
    /**
     * Método que devuelve un espacio vacío.
     * @return JLabel
     */
    public JLabel espacioBacio(){
        return new JLabel("             ");
    }
    /*
       Metodo que inicializa los escuchadores
    */
    public void addListeners(){
        PnlRegistroConsultaListener listener = new PnlRegistroConsultaListener(this);
        btnRegistrar.addActionListener(listener);
        btnCancelar.addActionListener(listener);
        btnBuscar.addActionListener(listener);
        cbEspecialidad.addActionListener(listener);
    }
 
    public JComboBox<Especialidad> getCbEspecialidad() {
        return cbEspecialidad;
    }

    public JComboBox<String> getCbMedicos() {
        return cbMedicos;
    }

    public JTextField getTxtIdPac() {
        return txtIdPac;
    }

    public JTextField getTxtHabitacion() {
        return txtHabitacion;
    }

    public JTextArea getTxtADiagnostico() {
        return txtADiagnostico;
    }

    public JTextArea getTxtAReceta() {
        return txtAReceta;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setTxtNombrePac(JTextField txtNombrePac) {
        this.txtNombrePac = txtNombrePac;
    }

    public void setTxtApellidosPac(JTextField txtApellidosPac) {
        this.txtApellidosPac = txtApellidosPac;
    }

    public List<Medico> getLstMedicos() {
        return lstMedicos;
    }

    public List<Paciente> getLstPacientes() {
        return lstPacientes;
    }

    public List<Medico> getLstMedicoSelect() {
        return lstMedicoSelect;
    }

    public JTextField getTxtNombrePac() {
        return txtNombrePac;
    }

    public JTextField getTxtApellidosPac() {
        return txtApellidosPac;
    }

    public FrmHospitalListener getF() {
        return f;
    }
    
    
    
}
