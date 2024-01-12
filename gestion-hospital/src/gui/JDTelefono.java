
package gui;

import modelo.Telefono;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.Operadora;

/**
 * Clase que maneja el registro de telefonos
 * @since 23-08-23
 * @version POO 2023
 * @author ROBLES MORALES
 */
public class JDTelefono extends JDialog{
    private JPanel contentPane , pnlCentro;
    private List<Telefono> lstTelefonos;
    private JTextField txtNumero1, txtNumero2;
    private JComboBox<Operadora> cbOperadora1,cbOperadora2;
    private JButton btnAgregar;
    private JPanel pnlSouth;
    private JButton btnCerrar;
    
    /**
     * Constructor de la clase JDtelefono
     * 
     */
    public JDTelefono() {
        initComponents();
    }
    /**
     * Comtructor que muestra los telefonos
     * @param lstTelefonos contiene la lista de telefonos
     */
    public JDTelefono(List<Telefono> lstTelefonos) {
        this.lstTelefonos = lstTelefonos;
        initComponents();
        int i = 0;
        for(Telefono t : lstTelefonos){
            if(i == 0){
            txtNumero1.setText(t.getNumero());
            cbOperadora1.setSelectedItem(t.getOperadora());
            }else{
            txtNumero2.setText(t.getNumero());
            cbOperadora2.setSelectedItem(t.getOperadora());    
            }
        }
        btnAgregar.setVisible(false);
        txtNumero1.setEditable(false);
        txtNumero2.setEditable(false);
        cbOperadora1.setEnabled(false);
        cbOperadora2.setEnabled(false);
        btnAgregar.setEnabled(false);
    }
    
    /**
     * Metodo que inicializa los componentes del JDTelefono
     */
    public void initComponents(){
        setTitle("Telefonos");
        setLocationRelativeTo(null);
        setSize(400,200);
        setVisible(true);
        //Reemplazo el contentPane
        
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);
        
        JLabel lbl = new JLabel("     ");
        //creandoel  panel del centro y otros elementos
        pnlCentro = new JPanel(new GridLayout(4,2,4,4));
        pnlSouth = new JPanel();
        txtNumero1 = new JTextField();
        cbOperadora1 = new JComboBox<>(Operadora.values());
        cbOperadora2 = new JComboBox<>(Operadora.values());
        txtNumero1= new JTextField();
        txtNumero2 = new JTextField();
        //Añadiendo elementos
        contentPane.add(new JLabel("        "),BorderLayout.EAST);
        contentPane.add(new JLabel("        "),BorderLayout.WEST);
        contentPane.add(pnlCentro,BorderLayout.CENTER);
        contentPane.add(pnlSouth, BorderLayout.SOUTH);
    
        pnlCentro.add(new JLabel("Telefono 1"));
        pnlCentro.add(new JLabel("          "));
        pnlCentro.add(txtNumero1);
        pnlCentro.add(cbOperadora1);
        pnlCentro.add(new JLabel("Telefono 2 - Opcional"));
        pnlCentro.add(new JLabel("          "));
        pnlCentro.add(txtNumero2);
        pnlCentro.add(cbOperadora2);
        
        btnAgregar = new JButton("Guardar");
        btnCerrar = new JButton("Cerrar");
        pnlSouth.add(btnAgregar);
        pnlSouth.add(btnCerrar);
        addListener();
    }
    /**
     * Método que añade escucachadores a los botones del JDteledono 
    */
    public void addListener(){
        JDTelefonoListener listener = new JDTelefonoListener(this);
        btnAgregar.addActionListener(listener);
        btnCerrar.addActionListener(listener);
    }
     
    /**
     * Metodo que devuelve la lista de telefono
     * @return Lista de telefonos
     */
    public List<Telefono> getLstTelefonos() {
        return lstTelefonos;
    }  

    public void setLstTelefonos(List<Telefono> lstTelefonos) {
        this.lstTelefonos = lstTelefonos;
    }

    public JTextField getTxtNumero1() {
        return txtNumero1;
    }

    public JTextField getTxtNumero2() {
        return txtNumero2;
    }

    public JComboBox<Operadora> getCbOperadora1() {
        return cbOperadora1;
    }

    public JComboBox<Operadora> getCbOperadora2() {
        return cbOperadora2;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnCerrar() {
        return btnCerrar;
    }
    
}
