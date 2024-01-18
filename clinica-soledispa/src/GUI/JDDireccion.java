
package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.Direccion;

/**
 * Clase que contiene el JDualog para el registro de  direcciones.
 * @author ROBLES MORALES
 * @version POO-2023
 */
public class JDDireccion extends JDialog {
    private JPanel contentPane, pnlCentro, pnlSouth;
    private JTextField txtCiudad1,txtCiudad2;
    private JTextField txtCalle1;
    private JTextField txtCalle2;
    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JButton btnGuardar;
    private JButton btnCerrar;
    private List<Direccion> lstDirecciones;
    /**
     * Construtor vacio de JDdireccion
     */
    public JDDireccion() {
        setTitle(" Direcciones");
        initComponents();
    }
    
    /**
     * Construtor vacio de JDdireccion
     * @param lstDirecciones
     */
    public JDDireccion(List<Direccion> lstDirecciones) {
        this.lstDirecciones = lstDirecciones;
        setTitle(" Direcciones");
        initComponents();
        int i = 0;
        for(Direccion d : lstDirecciones){
            if(i == 0){
            txtCiudad1.setText(d.getCiudad());
            txtCalle1.setText(d.getCalle());
            txtNumero1.setText(d.getCalle());
            }else{
            txtCiudad2.setText(d.getCiudad());
            txtCalle2.setText(d.getCalle());
            txtNumero2.setText(d.getCalle());   
            }
        }
        txtCiudad1.setEditable(false);
        txtCalle1.setEditable(false);
        txtNumero1.setEditable(false);
        txtCiudad2.setEditable(false);
        txtCalle2.setEditable(false);
        txtNumero2.setEditable(false);
        btnGuardar.setVisible(false);
    }
    /**
     * Metodo que inicializa los elementos del JDDireccion
     */
    public void initComponents(){
        setLocationRelativeTo(null);
        setSize(500,250);
        setVisible(true);
        //Reemplazo el contentPane
        
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);
        
        //creandoel  panel del centro y otros elementos
        pnlCentro = new JPanel(new GridLayout(6,3,4,4));
        pnlSouth = new JPanel();
        //Añadiendo elementos al content pane
        contentPane.add(new JLabel("        "),BorderLayout.EAST);
        contentPane.add(new JLabel("        "),BorderLayout.WEST);
        contentPane.add(pnlCentro,BorderLayout.CENTER);
        contentPane.add(pnlSouth, BorderLayout.SOUTH);
        //Inicializando textField
        txtCiudad1 = new JTextField();
        txtCiudad2 = new JTextField();
        txtCalle1 = new JTextField();
        txtCalle2 = new JTextField();
        txtNumero1 = new JTextField();
        txtNumero2 = new JTextField();
        btnGuardar= new JButton("Guardar");
        btnCerrar = new JButton("Cerrar");
        
        pnlCentro.add(new JLabel("Direccion 1"));
        pnlCentro.add(new JLabel ());
        pnlCentro.add(new JLabel());
        
        pnlCentro.add(new JLabel("Ciudad"));
        pnlCentro.add(new JLabel("Calle"));
        pnlCentro.add(new JLabel("Numero"));
        
        pnlCentro.add(txtCiudad1);
        pnlCentro.add(txtCalle1);
        pnlCentro.add(txtNumero1);
        
        pnlCentro.add(new JLabel("Direccion 2  - Opcional"));
        pnlCentro.add(new JLabel ());
        pnlCentro.add(new JLabel());
        
        pnlCentro.add(new JLabel("Ciudad"));
        pnlCentro.add(new JLabel("Calle"));
        pnlCentro.add(new JLabel("Numero"));
        
        pnlCentro.add(txtCiudad2);
        pnlCentro.add(txtCalle2);
        pnlCentro.add(txtNumero2);
        
        pnlSouth.add(btnGuardar);
        pnlSouth.add(btnCerrar); 
    }

    public JTextField getTxtCiudad1() {
        return txtCiudad1;
    }

    public JTextField getTxtCiudad2() {
        return txtCiudad2;
    }

    public JTextField getTxtCalle1() {
        return txtCalle1;
    }

    public JTextField getTxtCalle2() {
        return txtCalle2;
    }

    public JTextField getTxtNumero1() {
        return txtNumero1;
    }

    public JTextField getTxtNumero2() {
        return txtNumero2;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnCerrar() {
        return btnCerrar;
    }

    public List<Direccion> getLstDirecciones() {
        return lstDirecciones;
    }

    public void setLstDirecciones(List<Direccion> lstDirecciones) {
        this.lstDirecciones = lstDirecciones;
    }
    
    
}
