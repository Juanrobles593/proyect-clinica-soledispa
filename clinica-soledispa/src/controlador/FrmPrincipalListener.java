
package controlador;

import GUI.FrmPrincipal;
import GUI.PnlCitaMedica;
import GUI.PnlRegistrar;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class FrmPrincipalListener implements ActionListener, MouseListener{
    private final Color colorNegro51 = new Color(51,51,51);
    private final Color colorNegro153 = new Color(153,153,153);
    private FrmPrincipal frm;
    private PnlRegistrar pnlRegistrarMedico;
       
    
    /**
     * Metodo constructor de la clase escuchadora de FrmPrincipal
     * @param frm referencia al FrmPrincipal
     */
    public FrmPrincipalListener(FrmPrincipal frm) {
        this.frm = frm;
        addListeners();
    }
    
    //------------ActionListener-----------------------
    /**
     * Método que maneja el eventos generales en los elementos del Frame
     * @param e Objeto de tipo ActionEvent que representa un evento general en el Frame
     */
    @Override
    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource(); 
        
        if(obj == frm.getBtnIniciarSesion()){
            String usuario = frm.getTxtUsuario().getText();
            String contrasenia = String.valueOf(frm.getTxtPassword().getPassword());
            //peticion a la base de datos
            if(autenticacion(usuario, contrasenia)){
                //es admin
            }
            frm.getPnlBackGround().setViewportView(new PnlCitaMedica());
        }
        if(obj == frm.getMniCerrarSesion()){
            frm.getPnlBackGround().setViewportView(frm.getBg());
        }
        if(obj == frm.getMniSalir()){
            System.exit(0);
        }
        if(obj == frm.getMniRegistrarMedico()){
            if(pnlRegistrarMedico == null){
                pnlRegistrarMedico = new PnlRegistrar();
                PnlRegistrarListener p = new PnlRegistrarListener(pnlRegistrarMedico);
            } 
            frm.getPnlBackGround().setViewportView(pnlRegistrarMedico);
        }
       
    }
    
    // ------------MouseListener---------------------
    /**
     * Metodo que maneja el evento de mouse saliendo de un objeto
     * @param e Objeto de tipo MouseEvent que representa el evento de mouseExited
     */
    @Override
    public void mouseExited(MouseEvent e) {
        
        Object obj= e.getSource();
        
        if(obj instanceof JMenu mn){
            mn.setForeground(colorNegro51);
            mn.setBackground(Color.WHITE);
            mn.setOpaque(true);
            mn.repaint();
        }
        if(obj instanceof JLabel lbl){
            lbl.getParent().setBackground(colorNegro153);
            lbl.setForeground(colorNegro51);
        }
    }
    
    /**
     * Metodo que maneja el evento del mouse sobre un elemento del Frm
     * @param e Objeto de tipo MouseEvent que representa el evento de mouseEnetered
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        Object obj= e.getSource();
        
       if(obj instanceof JMenu mn ){
            mn.setOpaque(true);
            mn.setForeground(Color.WHITE);
            mn.setBackground(colorNegro153);
            mn.repaint();
       }
       if(obj instanceof JLabel lbl){
            lbl.getParent().setBackground(colorNegro51);
            lbl.setForeground(Color.white);
        }
    }
  
    /**
     * Método que administra el evento de presionar del mouse.
     * @param e Objeto de tipo MouseEvent que representa el evento de mousePressed
     */
    @Override
    public void mousePressed(MouseEvent e) {
        //cuando el mouse esta encima
        Object obj= e.getSource();
       if(obj == frm.getTxtUsuario()){
            if(frm.getTxtUsuario().getText().equals("Ingrese su usuario")){
                frm.getTxtUsuario().setFocusable(true);
                frm.getTxtUsuario().requestFocus();
                frm.getTxtUsuario().setText("");
                frm.getTxtUsuario().setForeground(colorNegro51);
            }
            if(String.valueOf(frm.getTxtPassword().getPassword()).isEmpty()){
                frm.getTxtPassword().setText("**********");
                frm.getTxtPassword().setForeground(colorNegro153);
            }
        }
       if(obj == frm.getTxtPassword()){
            if(String.valueOf(frm.getTxtPassword().getPassword()).equals("**********")){
                frm.getTxtPassword().setFocusable(true);
                frm.getTxtPassword().requestFocus();
                frm.getTxtPassword().setText("");
                frm.getTxtPassword().setForeground(colorNegro51);
            }
            if(frm.getTxtUsuario().getText().isEmpty()){
                frm.getTxtUsuario().setText("Ingrese su usuario");
                frm.getTxtUsuario().setForeground(colorNegro153);
            }
        }      
    }
    
    /**
     * Método que administra el evento de arrastrar el mouse.
     * @param e Objeto de tipo MouseEvent que representa el evento de mouseReleased
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        //Método no utlizado
    }
    /**
     * Método que administra el evento de click el mouse.
     * @param e Objeto de tipo MouseEvent que representa el evento de mouseClicked.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        //  Método no utilizado
    }
    /**
     * Metodo void que añade el escuchador mouseListener.
     */
    private void addListeners(){
        //Mouse listener
        frm.getTxtUsuario().addMouseListener(this);
        frm.getTxtPassword().addMouseListener(this);
        // --------- ActionListener  -------------
        // -- Menu Principal
        frm.getMniInicio().addActionListener(this);
        frm.getMniCerrarSesion().addActionListener(this);
        frm.getMniAyuda().addActionListener(this);
        frm.getBtnIniciarSesion().addActionListener(this);
        frm.getMniRegistrarMedico().addActionListener(this);
        frm.getMniSalir().addActionListener(this);
    }
    
    /**
     * Método que abre el documento a partir de una ruta.
     * @param ruta Contiene la ruta del archivo que se debe abrir
     */
    public static void abrirDocumento(String ruta) {
        try {
            Desktop.getDesktop().open(new File(ruta));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al abrir el archivo", "Error", 0);
        }
    }
    
    /**
     * Método que revalida el Formulario y lo repinta para ver los cambios en su
     * diseño o interfaz.
     */
    private void validar(){
        frm.revalidate();
        frm.repaint();
    }
    
//    /**
//     * Método que remueve y actualiza el contenido del Frame con un panel.
//     * @param pnl panel con el cual se mostrará.
//     */
//    private void changePnlBg(JPanel pnl){
//        
//    }
    /**
     * Método que cambia la vista del programa.
     * @param pnl contiene el panel a mostrar en la vista.
     */
    private void setView(JPanel pnl){
        frm.getPnlBackGround().setViewportView(pnl);
        validar();
    }
    
    private boolean autenticacion(String usuario, String contrasenia) {
        return true;
    }
}
