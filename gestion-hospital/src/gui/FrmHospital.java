
package gui;


import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
/**
 * Clase principal que contiene el JFrame del programa.
 * @author ROBLES MORALES
 * @version POO-2023
 */
public class FrmHospital extends JFrame {
    private JMenuBar barraMenu; 
    private JMenu mnAyuda;
    private JMenuItem mniPrincipal, mniSalir;
    private JMenu mnDoctor;
    private JMenuItem mniNuevoDoc, mniReporteDoc;
    private JMenu mnPaciente;
    private JMenuItem mniNuevoPaciente, mniReportePaciente;
    private JMenu mnConsultas;
    private JMenuItem mniNuevaConsulta, mniReporteConsulta;
    private JPanel contentPane;
    private JPanel pnlPrincipal;
    private JPanel pnlPrincipalEste;
    private final JButton btnConsultas = new JButton("Consultas");
    private final JButton btnMedicos = new JButton("Medicos");
    private final JButton btnPacientes = new JButton("Pacientes");
    //colores y font
    private final Color blueWarmColor = new Color(0, 102, 204); 
    private final Font CandaraFont = new Font("Candara", Font.BOLD, 18);

    /**
     * Constructor de Frame principal
     */
    public FrmHospital(){
        super("Clínica Soledispa");
        setSize(900,1200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);
        initComponents();
        componentsPrincipal();   
        addListeners();
        pack();
    }
    /**
     * Metodo que agrega los escuvhadores a los elementos del FrmHospital.
     */
    private void addListeners(){ 
        FrmHospitalListener listenerPrincipal= new FrmHospitalListener(this);
        mniPrincipal.addActionListener(listenerPrincipal);
        mniSalir.addActionListener(listenerPrincipal);
        mniNuevoDoc.addActionListener(listenerPrincipal);
        mniReporteDoc.addActionListener(listenerPrincipal);
        mniNuevoPaciente.addActionListener(listenerPrincipal);
        mniReportePaciente.addActionListener(listenerPrincipal);
        mniNuevaConsulta.addActionListener(listenerPrincipal);
        mniReporteConsulta.addActionListener(listenerPrincipal);
        mniNuevaConsulta.addActionListener(listenerPrincipal);
        btnConsultas.addActionListener(listenerPrincipal);
        btnMedicos.addActionListener(listenerPrincipal);
        btnPacientes.addActionListener(listenerPrincipal);
    }
    /**
     * Método que inicializa los componentes del FrmHospital
     */
    private void initComponents(){
        
        barraMenu= new JMenuBar();
        setJMenuBar(barraMenu);  
        
        mnAyuda = new JMenu("Ayuda");
        mnDoctor = new JMenu("Médico");
        mnPaciente = new JMenu("Paciente");
        mnConsultas = new JMenu("Consultas");
        barraMenu.add(mnAyuda);
        barraMenu.add(mnDoctor);
        barraMenu.add(mnPaciente);
        barraMenu.add(mnConsultas);
        
        mniPrincipal= new JMenuItem("Principal");
        mniSalir = new JMenuItem("Salir");
        mnAyuda.add(mniPrincipal);
        mnAyuda.add(mniSalir);
        
        mniNuevoDoc = new JMenuItem("Nuevo"); 
        mniReporteDoc = new JMenuItem("Reporte");
        mnDoctor.add(mniNuevoDoc);
        mnDoctor.add(mniReporteDoc);
        
        mniNuevoPaciente = new JMenuItem("Nuevo");
        mniReportePaciente = new JMenuItem("Reporte");
        mnPaciente.add(mniNuevoPaciente);
        mnPaciente.add(mniReportePaciente);
        
        mniNuevaConsulta = new JMenuItem("Nueva");
        mniReporteConsulta = new JMenuItem("Reporte");
        mnConsultas.add(mniNuevaConsulta);
        mniNuevaConsulta.setMnemonic('A');
        mnConsultas.add(mniReporteConsulta);   
        
    }

    /**
     * Metodo que añade los componetes del panel principal al contentPane
     */
    public void componentsPrincipal(){
        pnlPrincipal=new JPanel(new BorderLayout());
        pnlPrincipal.setBackground(blueWarmColor);

        pnlPrincipalEste = new JPanel(new GridLayout(3,1));
        pnlPrincipal.add(pnlPrincipalEste,BorderLayout.WEST);

        pnlPrincipalEste.add(btnConsultas);
        pnlPrincipalEste.add(btnMedicos);
        pnlPrincipalEste.add(btnPacientes);

        ImageIcon imageIcon = new ImageIcon("./src/recursos/logoCompleto.jpeg");
        JLabel lblCentroLogo= new JLabel();
        lblCentroLogo.setIcon(imageIcon);
        pnlPrincipal.add(lblCentroLogo, BorderLayout.CENTER);
        contentPane.add(pnlPrincipal);
    }

    //Getter de los botones

    /**
     *  Metodo getter de mniDuevoDoc
     * @return mniNuevoDoc 
     */
    public JMenuItem getMniNuevoDoc() {
        return mniNuevoDoc;
    }

    /**
     *  Método que devuelve un JMenuIten
     * @return mniPrincipal
     */
    public JMenuItem getMniPrincipal() {
        return mniPrincipal;
    }

    /**
     *  Método que devuelve un JButton de consultas.
     * @return btnConsultas
     */
    public JButton getBtnConsultas() {
        return btnConsultas;
    }

    /**
     * Método que devuelve un JButton de Médicos.
     * @return btnMedicos
     */
    public JButton getBtnMedicos() {
        return btnMedicos;
    }

    /**
     * Método que devuelve el btnPacientes
     * @return btnPacientes
     */
    public JButton getBtnPacientes() {
        return btnPacientes;
    }

    /**
     *  Metodo que devuele el JMeni Item de salir.
     * @return mniSalir
     */
    public JMenuItem getMniSalir() {
        return mniSalir;
    }

    /**
     *  Método que devuelve un JMenuItem.
     * @return mniReporteDoc
     */
    public JMenuItem getMniReporteDoc() {
        return mniReporteDoc;
    }

    /**
     * Método que devuelve un JMenuItem.
     * @return mniNuevoPaciente
     */
    public JMenuItem getMniNuevoPaciente() {
        return mniNuevoPaciente;
    }

    /**
     * Método que devuelve un JMenuItem.
     * @return mniReportePaciente
     */
    public JMenuItem getMniReportePaciente() {
        return mniReportePaciente;
    }

    /**
     * 
     * @return
     */
    public JMenuItem getMniNuevaConsulta() {
        return mniNuevaConsulta;
    }

    /**
     *
     * @return
     */
    public JMenuItem getMniReporteConsulta() {
        return mniReporteConsulta;
    } 

    /**
     *
     * @return
     */
    public JPanel getPnlPrincipal() {
        return pnlPrincipal;
    }

    /**
     *
     * @return
     */
    @Override
    public JPanel getContentPane() {
        return contentPane;
    }
    

}
