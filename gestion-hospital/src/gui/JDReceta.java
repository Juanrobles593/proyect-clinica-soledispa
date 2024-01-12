
package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Clase de tipo JDialog que prmite el ingreso de direcciones.
 * @author ROBLES MORALES
 */
public class JDReceta extends JDialog{

    private JPanel contentPane;
    private JPanel pnlCentro;
    private JPanel pnlSouth;
    private JLabel lblReceta;
    private JLabel lblDiagnostico;
    private JTextArea txtADiagnostico;
    private JTextArea txtAReceta;
    private JScrollPane sPaneDiagnostico;
    private JScrollPane sPaneReceta;
    private JPanel pnlCentro1;
    private JPanel pnlCentro2;
    private JButton btnCerrar;
    private String diagnostico, receta;
    
    
    /**
     * Construtor vacio de JDdireccion
     * @param diagnostico
     * @param receta
     */
    public JDReceta(String diagnostico, String receta) {
        this.diagnostico = diagnostico;
        this.receta = receta;
        setTitle(" Diagnostico y receta");
        initComponents();
    }
    /**
     * Método que inicializa los componentes del JDReceta
     */
    private void initComponents(){
        setLocationRelativeTo(null);
        setSize(300,250);
        setVisible(true);
        //Reemplazo el contentPane
        
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);
        
        //creandoel  panel del centro y otros elementos
        pnlCentro = new JPanel(new GridLayout(2,1,4,4));
        pnlSouth = new JPanel();
        //Añadiendo elementos al content pane
        contentPane.add(new JLabel("        "),BorderLayout.EAST);
        contentPane.add(new JLabel("        "),BorderLayout.WEST);
        contentPane.add(pnlCentro,BorderLayout.CENTER);
        contentPane.add(pnlSouth, BorderLayout.SOUTH);
        lblReceta = new JLabel("Receta");
        lblDiagnostico= new JLabel("Diagnostico");
        btnCerrar= new JButton("Cerrar");
        pnlCentro1= new JPanel(new BorderLayout());
        pnlCentro2= new JPanel(new BorderLayout());
        pnlSouth.add(btnCerrar);
        pnlCentro.add(pnlCentro1);
        pnlCentro.add(pnlCentro2);
        txtADiagnostico = new JTextArea();
        txtADiagnostico.setLineWrap(true); 
        txtADiagnostico.setWrapStyleWord(true); 
        txtADiagnostico.setText(diagnostico);
        txtADiagnostico.setEditable(false);
        txtAReceta = new  JTextArea();
        txtAReceta.setLineWrap(true); 
        txtAReceta.setWrapStyleWord(true);
        txtAReceta.setText(receta);
        txtAReceta.setEditable(false);
        sPaneDiagnostico = new JScrollPane(txtADiagnostico);
        sPaneReceta = new JScrollPane(txtAReceta);
        
        pnlCentro1.add(lblDiagnostico,BorderLayout.NORTH);
        pnlCentro1.add(sPaneDiagnostico, BorderLayout.CENTER);
        pnlCentro2.add(lblReceta, BorderLayout.NORTH);
        pnlCentro2.add(sPaneReceta,BorderLayout.CENTER);
        addListeners();
        
    }
    /**
     * Método que añade los escuchadores al JDReceta
     */
    private void addListeners(){
        btnCerrar.addActionListener(new JDRecetaListener(this));
    }
    
    /**
     * Método que devuelve el Boton
     * @return  btnCerrar
     */
    public JButton getBtnCerrar() {
        return btnCerrar;
    }
    
}
