
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import modelo.GenericDomainTableModel;

/**
 *  Clase que devuelve una tabla de elementos páginada.
 * @author ROBLES MORALES 
 * @version POO-2023
 */

public class PnlRegistros extends JPanel {
    private FrmHospitalListener frm;
    private List lstElementos;
    private GenericDomainTableModel tblModel;
    private JTable tblDatos;
    private final Color blueWarmColor = new Color(0, 102, 204);
    private final Font CandaraFont = new Font("Candara", Font.BOLD, 18);
    private JButton btnRegistrar;
    private JButton btnEliminar;
    private JButton btnVerDetalle;
    private JPanel pnlNavegacion;
    private JButton btnAtras;
    private JButton btnSiguiente;
    private JButton btnPrimeraPagina;
    private JButton btnUltimaPagina;
    private JLabel lblPagina;
    private JPanel pnlCenter,pnlSouth;
    private JComboBox<Integer> cbCantidadElementos;
    private JPopupMenu pmnAccion;
    private JMenuItem mniVerTelefono;
    private JMenuItem mniVerDireccion;
    private JMenuItem mniVerDiagReceta;
    private JPanel pnlNorth;
    private JLabel lblTitle;
    /**
     * Constructor del panel de registros
     * @param frm Contiene la referencia al Frm principal
     * @param lstElementos Contiene una lista de Objetos a mostrar en una tabla.
     * @param tblModel Contiene el modelo de tabla que mostrará los objetos yha mencionados.
     */
    public PnlRegistros(FrmHospitalListener frm,List lstElementos, GenericDomainTableModel tblModel) {
        this.frm = frm;
        this.lstElementos = lstElementos;
        this.tblModel=tblModel;
        
        initComponents();
    }
    /**
     * Metodo que inicializa los elementos del Panel
     */
    public void initComponents(){
        this.setLayout(new BorderLayout());
        
        tblDatos = new JTable(tblModel);
        tblDatos.setDefaultEditor(Object.class, null);// Confihgurar que no se pueda editar
        tblDatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Solo se pueda seleccionar 1 fila a la vez.
        
        //crear PopMenu
        pmnAccion = new JPopupMenu ();
        mniVerTelefono= new JMenuItem("Ver Telefono(s)");
        mniVerDireccion = new JMenuItem("Ver Dirección(es)");
        mniVerDiagReceta = new JMenuItem("Ver diagnostico");
        pmnAccion.add(mniVerTelefono);
        pmnAccion.add(mniVerDireccion);
        pmnAccion.add(mniVerDiagReceta);
        tblDatos.setComponentPopupMenu(pmnAccion);
        
        JScrollPane scrollPaneCon= new JScrollPane();
        scrollPaneCon.setViewportView(tblDatos);
        pnlSouth = new JPanel(new FlowLayout());
        
        pnlNorth = new JPanel(new BorderLayout());
        this.add(pnlNorth, BorderLayout.NORTH);
        lblTitle = new JLabel("");
        pnlNorth.add(lblTitle, BorderLayout.WEST);
        cbCantidadElementos = new JComboBox<>();
        for (int i = 5; i <= 20; i+=5) {
            cbCantidadElementos.addItem(i);
        }
        
        pnlNorth.add(cbCantidadElementos, BorderLayout.EAST);
        this.add(lblVacio(),BorderLayout.WEST);
        this.add(lblVacio(),BorderLayout.EAST);
        this.add(pnlSouth,BorderLayout.SOUTH);
        btnRegistrar=new JButton(" Registrar nuevo ");
        //btnEliminar=new JButton(" Eliminar Registro ");
        btnVerDetalle=new JButton(" Ver detalle Completo");
        pnlSouth.add(btnRegistrar);
       // pnlSouth.add(btnEliminar);
        pnlSouth.add(btnVerDetalle);
        pnlCenter = new JPanel(new BorderLayout());
        this.add(pnlCenter, BorderLayout.CENTER);
        pnlCenter.add(scrollPaneCon, BorderLayout.CENTER);
        
        pnlNavegacion = new JPanel(new GridLayout(1,5,3,1));
        btnAtras = new JButton("   <<   ");
        btnAtras.setEnabled(false);
        btnPrimeraPagina = new JButton(" |< ");
        btnPrimeraPagina.setEnabled(false);
        btnSiguiente = new JButton("  >>   ");
        btnSiguiente.setEnabled(false);
        btnUltimaPagina = new JButton(" >| ");
        btnUltimaPagina.setEnabled(false);
        lblPagina= new JLabel("    PAG. 1    ");
        if(lstElementos.size() > 5){
            tblModel.addRows(lstElementos.subList(0,5));
            btnSiguiente.setEnabled(true);
            btnUltimaPagina.setEnabled(true);
        }else{
            tblModel.addRows(lstElementos); 
        }
        
        pnlNavegacion.add(btnPrimeraPagina);
        pnlNavegacion.add(btnAtras);
        pnlNavegacion.add(lblPagina);
        pnlNavegacion.add(btnSiguiente);
        pnlNavegacion.add(btnUltimaPagina);
        pnlCenter.add(pnlNavegacion, BorderLayout.SOUTH);
        addListeners();
    }
    /**
     * Metodo que crea un JLabel
     * @return Un JLabel 
     */
    private JLabel lblVacio(){
        return new JLabel("         ");
    }
    /**
     * Metodo que añade listeners a los elementos que lo necesiten
     */
    private void addListeners(){
        PnlRegistrosListener listener = new PnlRegistrosListener(this) ;
        btnRegistrar.addActionListener(listener);
        //btnEliminar.addActionListener(listener);
        btnVerDetalle.addActionListener(listener);
        btnAtras.addActionListener(listener);
        btnSiguiente.addActionListener(listener);
        btnPrimeraPagina.addActionListener(listener);
        btnUltimaPagina.addActionListener(listener);
        mniVerTelefono.addActionListener(listener);
        mniVerDireccion.addActionListener(listener);
        mniVerDiagReceta.addActionListener(listener);
        //cbCantidadElementos.addItemListener(listener);
        cbCantidadElementos.addActionListener(listener);
    }

    public List getLstElementos() {
        return lstElementos;
    }

    public void setLstElementos(List lstElementos) {
        this.lstElementos = lstElementos;
    }
    
    public GenericDomainTableModel getTblModel() {
        return tblModel;
    }
   
    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnVerDetalle() {
        return btnVerDetalle;
    }

    public JButton getBtnAtras() {
        return btnAtras;
    }
    public JButton getBtnSiguiente() {
        return btnSiguiente;
    }
    public JButton getBtnPrimeraPagina() {
        return btnPrimeraPagina;
    }
    public JButton getBtnUltimaPagina() {
        return btnUltimaPagina;
    }
    public JComboBox<Integer> getCbCantidadElementos() {
        return cbCantidadElementos;
    }
    public JLabel getLblPagina() {
        return lblPagina;
    }
    public JTable getTblDatos() {
        return tblDatos;
    }
    public FrmHospitalListener getFrm() {
        return frm;
    } 

    public JMenuItem getMniVerTelefono() {
        return mniVerTelefono;
    }

    public JMenuItem getMniVerDireccion() {
        return mniVerDireccion;
    }

    public JPopupMenu getPmnAccion() {
        return pmnAccion;
    }

    public JMenuItem getMniVerDiagReceta() {
        return mniVerDiagReceta;
    }

    public JLabel getLblTitle() {
        return lblTitle;
    } 
}