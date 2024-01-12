
package gui;

import archivos.Archivos;
import modelo.Direccion;
import modelo.Medico;
import modelo.Paciente;
import modelo.Persona;
import modelo.Telefono;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Especialidad;

/**
 * Clase escuchadora de PnlRegistroPersona.
 * @author ROBLES MORALES
 * @version POO-2023
 * 
 */
public class PnlRegistroPersonaListener implements ActionListener{
    private PnlRegistroPersona pnl;
    private List<Medico> lstMedicos;
    private List<Paciente> lstPacientes;
    private Persona p;
    private JDTelefono jdTel;
    private JDDireccion jdDir;
    String cedula;
    String nombre;
    String apellidos;
    List<Telefono> lstTel;
    List<Direccion> lstDir;
    Especialidad especialidad;
    
    /**
     * Constructor de la clase escuchadora PnlRegistroPersona.
     * @param pnl contiene la refeencia a la clase PnlRegistroPersona.
     */       
    public PnlRegistroPersonaListener(PnlRegistroPersona pnl) {
        this.pnl = pnl;
        cargarDatos();
    }
    
    /**
     * Método heredado que controla los eventos que se realizen en los elementos del panel.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e){
        Object object = e.getSource();
        if(object== pnl.getBtnAgregarDir()){
            if("Ver Direccion(es)".equals(pnl.getBtnAgregarDir().getText())){
                if(pnl.getP().getListDireccion() == null){
                new JDDireccion (pnl.getP().getListDireccion()).setVisible(true);
                return;
                }else{
                JOptionPane.showMessageDialog(null, " La persona seleccionada no posee direcciones registradas");
                }
                return;
            }else{
                if(jdDir == null){
                    jdDir = new JDDireccion();
                }
                jdDir.setLocationRelativeTo(pnl);
                jdDir.setVisible(true);
                return;
            }
        }
        if(object== pnl.getBtnAgregarTel()){
            
            if("Ver Telefono(s)".equals(pnl.getBtnAgregarTel().getText())){
               new JDTelefono(pnl.getP().getListTelefono()).setVisible(true);
                return;
            }else if(jdTel == null){
                jdTel= new JDTelefono();
            }
            jdTel.setLocationRelativeTo(pnl);
            jdTel.setVisible(true);
            return;
        }
        if(object== pnl.getBtnRegistrar()){
            verificarDatos();
            //agregarPersona();
        }
        if(object==pnl.getBtnCancelar()){      
            pnl.getF().panelPrincipal();     
        }
    }
    
    /**
     * Método que agrega Personas (Medicos y Pacientes) al sistema.
     */
    private void agregarPersona(){
        
        cedula = pnl.getTxtCedula().getText();
        nombre = pnl.getTxtNombre().getText();
        apellidos = pnl.getTxtApellidos().getText();
        lstTel= jdTel.getLstTelefonos();
        lstDir= jdDir.getLstDirecciones();
        p = null;
        if(pnl.getCbEspecialidad().isVisible()){
            especialidad = pnl.getCbEspecialidad().getItemAt(pnl.getCbEspecialidad().getSelectedIndex());
            p = new Medico(especialidad,nombre, apellidos, cedula, lstTel, lstDir);
            lstMedicos.add((Medico)p);
            guardarMedicos();
        }else{
            p = new Paciente( nombre, apellidos, cedula, lstTel,lstDir); 
            lstPacientes.add((Paciente)p);
            guardarPacientes();
        }
        limpiar();       
    }
    
    /**
     * Método que limpia los elementos del panel.
     */
    private void limpiar(){
        pnl.getTxtCedula().setText("");
        pnl.getTxtNombre().setText("");
        pnl.getTxtApellidos().setText("");
        pnl.getCbEspecialidad().setSelectedIndex(0);
        limpiarDireccion();
        limpiarTelefono();
    }
    
    /**
     *  Método que carga los datos de los archivos a las listas locales.
     */
    private void cargarDatos(){
        lstMedicos = Archivos.leerMedicos();
        lstPacientes = Archivos.leerPacientes();
    }
    
    /**
     * Método que guarda los datos de los pacientes.
     */
    private void guardarPacientes(){
        Archivos.guardarPacientes(lstPacientes);
        cargarDatos();
    }
    /**
     * Método que guarda los datos de los medicos en archivo binario.
     */
    private void guardarMedicos(){
        Archivos.guardarMedicos(lstMedicos);
        cargarDatos();
    }
    
    /**
     * Metodo que limpia los txtField del JDialog
     */
    private void limpiarDireccion(){
        jdDir.getTxtCiudad1().setText("");
        jdDir.getTxtCiudad2().setText("");
        jdDir.getTxtCalle1().setText("");
        jdDir.getTxtCalle2().setText("");
        jdDir.getTxtNumero1().setText("");
        jdDir.getTxtNumero2().setText("");
        jdDir.repaint();
        jdDir.revalidate();
    }
    
    /**
     * Metodo que limpia los campos del JDTelefono
     */
    private void limpiarTelefono(){
        jdTel.getTxtNumero1().setText("");
        jdTel.getTxtNumero2().setText("");
        jdTel.getCbOperadora1().setSelectedIndex(0);
        jdTel.getCbOperadora2().setSelectedIndex(0);
        jdTel.revalidate();
        jdTel.repaint();
    }
    /**
     * Método que verifica si los datos de los campos de registro son correctos.
     */
    private void verificarDatos(){
        cedula = pnl.getTxtCedula().getText();
        nombre = pnl.getTxtNombre().getText();
        apellidos = pnl.getTxtApellidos().getText();
        try{
            lstTel= jdTel.getLstTelefonos();
            lstDir= jdDir.getLstDirecciones();
            lstTel.get(0);
            lstDir.get(0);
        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog(pnl, "Por favor, debe ingresar como mínimo un numero de telefono y una dirección"); 
            return;
        }
        try{
            int n = Integer.parseInt(cedula);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(pnl, "Por favor, ingrese un númro de cédula Valido");return;
        }
        if("".equals(nombre) && "".equals(apellidos) ){
            JOptionPane.showMessageDialog(pnl, "Por favor complete todos los campos");
            return;
        }
        agregarPersona();
    }
}
