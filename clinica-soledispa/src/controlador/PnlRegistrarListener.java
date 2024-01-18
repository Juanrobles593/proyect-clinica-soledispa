
package controlador;


import GUI.JDDireccion;
import GUI.JDTelefono;
import GUI.PnlRegistrar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import modelo.Direccion;
import modelo.Enfermero;
import modelo.Medico;
import modelo.Paciente;
import modelo.Persona;
import modelo.Recepcionista;
import modelo.Telefono;
import modelo.bd.GestorBD;
import modelo.recursos.Especialidad;

/**
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class PnlRegistrarListener implements ActionListener, DocumentListener,PropertyChangeListener{
    private PnlRegistrar pnl;
    private JDDireccion jdDireccion;
    private JDDireccionListener jdDireccionListener;
    private JDTelefono jdTelefono;
    private JDTelefonoListener jdTelefonoListener;
    private Persona p;
    private List<Especialidad> especialidades;

    public PnlRegistrarListener(PnlRegistrar pnl)  {
        this.pnl = pnl;
        addListeners();
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == pnl.getCheckDiscapacidad()){
            if(pnl.getCheckDiscapacidad().isSelected()){
                pnl.getTxtaDiscapacidad().setEditable(true);
            }else{
                pnl.getTxtaDiscapacidad().setEditable(false);
            } 
        }
        if(obj == pnl.getBtnDirecciones()){
            if(jdDireccion== null){
               jdDireccion = new JDDireccion();
               jdDireccionListener = new JDDireccionListener(jdDireccion);
            }
            jdDireccion.setVisible(true);
        }
        if(obj == pnl.getBtnTelefonos()){
            if(jdTelefono== null){
               jdTelefono = new JDTelefono();
               jdTelefonoListener = new JDTelefonoListener(jdTelefono);
            }
            jdTelefono.setVisible(true);
        }
        if(obj == pnl.getBtnRegistrar()){
            if(verificarCampos()){
                String cedula = pnl.getTxtCedula().getText();
                String nombres = pnl.getTxtNombre().getText();
                String apellidos = pnl.getTxtApellidos().getText();
                String correoElectronico = pnl.getTxtCorreo().getText();
                String tipoSangre =  (String) pnl.getCbTipoSangre().getSelectedItem();;
                String estadoCivil =  pnl.getCbEstadoCivil().getItemAt(pnl.getCbEstadoCivil().getSelectedIndex());
                Boolean poseeDiscapacidad = pnl.getCheckDiscapacidad().isSelected();
                String tipoDiscapacidad ;
                if (poseeDiscapacidad) {
                    tipoDiscapacidad =  pnl.getTxtaDiscapacidad().getText();
                } else {
                    tipoDiscapacidad = "N/A";
                }
                Date fechaNacimiento = pnl.getDateFechaNacimiento().getDate();
                String sexo = pnl.getCbSexo().getItemAt(pnl.getCbSexo().getSelectedIndex());
                List<Telefono> lstTelefonos =jdTelefono.getLstTelefonos();
                List<Direccion> lstDirecciones= jdDireccion.getLstDirecciones();
                String contrasena = String.valueOf(pnl.getTxtContrasena().getPassword());
                
                if("REGISTRO DE MÉDICOS".equals(pnl.getLblTitulo().getText())){
                    Especialidad especialidad = especialidades.get(pnl.getCbEspecialidad().getSelectedIndex());
                    p =  new Medico(especialidad, cedula, nombres, apellidos, correoElectronico, tipoSangre,
                    estadoCivil, fechaNacimiento, poseeDiscapacidad, tipoDiscapacidad, sexo, lstTelefonos, lstDirecciones);
                    GestorBD.agregarMedico((Medico)p, contrasena);
                    limpiar();
                }else{
                    if("REGISTRO DE PACIENTES".equals(pnl.getLblTitulo().getText())){
                        p =  new Paciente( cedula, nombres, apellidos, correoElectronico, tipoSangre, estadoCivil,
                            poseeDiscapacidad, tipoDiscapacidad, fechaNacimiento, sexo, lstTelefonos, lstDirecciones);
                        GestorBD.agregarPaciente((Paciente)p);
                        limpiar();
                    }

                    if("REGISTRO DE RECEPCIONISTAS".equals(pnl.getLblTitulo().getText())){
                        p =  new Recepcionista( cedula, nombres, apellidos, correoElectronico, tipoSangre, estadoCivil,
                                poseeDiscapacidad, tipoDiscapacidad, fechaNacimiento, sexo, lstTelefonos, lstDirecciones);
                        GestorBD.agregarRecepcionista((Recepcionista)p, contrasena);
                        limpiar();
                    }

                    if("REGISTRO DE ENFERMEROS(AS)".equals(pnl.getLblTitulo().getText())){
                        p =  new Enfermero(cedula, nombres, apellidos, correoElectronico, tipoSangre, estadoCivil,
                                poseeDiscapacidad, tipoDiscapacidad, fechaNacimiento, sexo, lstTelefonos, lstDirecciones);
                        GestorBD.agregarEnfermero((Enfermero)p, contrasena);
                        limpiar();
                    }
                }
            }               
        }
    }
                         
    /**
     * Método que atrapa el evento de insertar a un elemento.
     * @param e 
     */
    @Override
    public void insertUpdate(DocumentEvent e) {
        verificarTextField(e.getDocument());
        System.out.println("llega alescuchador");
    }
    /**
     * Método que atrapa el evento de eliminar un elemento.
     * @param e 
     */
    @Override
    public void removeUpdate(DocumentEvent e) {
        verificarTextField(e.getDocument());
    }
    /**
     * Método que adapta cambios de estilos
     * @param e 
     */
    @Override
    public void changedUpdate(DocumentEvent e) { } //Metodo no utilizado
    /**
     * Metodo que verifica cambios es textField
     * @param doc 
     */
    private void verificarTextField(Document doc) {
        if (doc == pnl.getTxtCedula().getDocument()) {
            pnl.getTxtUsuario().setText(pnl.getTxtCedula().getText());
        } else if (doc == pnl.getTxtContrasena2().getDocument()) {
            if(String.valueOf(pnl.getTxtContrasena().getPassword()) ==  String.valueOf(pnl.getTxtContrasena2().getPassword())){
                System.out.println("Las contraseñas coinciden");
            }else{
                System.out.println("La contraseñaS NO coiniciden");
            }
        }
    }
    /**
     * Metodo que maneja el evento de cambio del calendario y calcula la edad
     * @param e 
     */
    @Override
    public void propertyChange(PropertyChangeEvent e) {
        Object obj = e.getSource();
         if(obj == pnl.getDateFechaNacimiento()){
             
            Date fechaSeleccionada = pnl.getDateFechaNacimiento().getDate();
            
            if(fechaSeleccionada != null){
                LocalDate fechaNacimiento = fechaSeleccionada.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
                LocalDate fechaActual = LocalDate.now();
                Period periodo = Period.between(fechaNacimiento, fechaActual);
                if(periodo.getYears()<18 && !"REGISTRO DE PACIENTES".equals(pnl.getLblTitulo().getText())){
                    JOptionPane.showMessageDialog(null, 
            "Edad no valida", "Error", JOptionPane.ERROR_MESSAGE);
                    pnl.getDateFechaNacimiento().setDate(null);
                    pnl.getTxtEdad().setText("");
                }
                pnl.getTxtEdad().setText(""+periodo.getYears());
            }   
        }
    }
    /**
     * Método que añade especialidades al panel.
     * @throws ClassNotFoundException 
     */
    public void vistaMedico() throws ClassNotFoundException{
        pnl.getCbEspecialidad().removeAllItems();
        especialidades = GestorBD.lstEspecialidad();
        for (Especialidad especialidad : especialidades) {
            pnl.getCbEspecialidad().addItem(especialidad.getNombre());
        }
    }

    /**
     * Método que verifica si los campos estan completados correctamente.
     * @return 
     */
    private boolean verificarCampos() {
        if(pnl.getTxtCedula().getText().length() != 10){
            JOptionPane.showMessageDialog(null, 
            "Por favor, ingrese un numero de cedula valido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(pnl.getTxtNombre().getText().isBlank() ||pnl.getTxtNombre().getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, 
            "Por favor, el campo nombre no debe estar vacio", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(jdDireccion == null || jdDireccion.getLstDirecciones() == null){
            JOptionPane.showMessageDialog(null, 
            "Por favor, ingrese al menos 1 direccion", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(jdTelefono == null || jdTelefono.getLstTelefonos()== null){
            JOptionPane.showMessageDialog(null, 
            "Por favor, ingrese al menos 1 número de telfono", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    /**
     * Actualiza la vista para cuando se registren pacientes.
     */   
    public void vistaPaciente(){
        pnl.getLblTitulo().setText("REGISTRO DE PACIENTES");
        pnl.getPnlUsuario().setVisible(false);
        pnl.getLblEspecialidad().setVisible(false);
        pnl.getCbEspecialidad().setVisible(false);
    }    
    /**
     * Actualiza la vista para cuando se registren Recepcionistas.
     */   
    public void vistaRecepcionista(){
        pnl.getLblTitulo().setText("REGISTRO DE RECEPCIONISTAS");
        pnl.getLblEspecialidad().setVisible(false);
        pnl.getCbEspecialidad().setVisible(false);
    }    
    /**
     * Actualiza la vista para cuando se registren Enfermeros.
     */   
    public void vistaEnfermero(){
        pnl.getLblTitulo().setText("REGISTRO DE ENFERMEROS(AS)");
        pnl.getLblEspecialidad().setVisible(false);
        pnl.getCbEspecialidad().setVisible(false);
    }
 
    private void limpiar(){
        pnl.getTxtCedula().setText("");
        pnl.getTxtNombre().setText("");
        pnl.getTxtApellidos().setText("");
        pnl.getTxtCorreo().setText("");
        pnl.getCbEspecialidad().setSelectedIndex(0);
        pnl.getCbEstadoCivil().setSelectedIndex(0);
        pnl.getCbTipoSangre().setSelectedIndex(0);
        pnl.getCbSexo().setSelectedIndex(0);
        pnl.getDateFechaNacimiento().setDate(null);
        pnl.getTxtEdad().setText("");
        pnl.getCheckDiscapacidad().setSelected(false);
        pnl.getTxtaDiscapacidad().setText("");
        pnl.getTxtUsuario().setText("");
        pnl.getTxtContrasena().setText("");
        pnl.getTxtContrasena2().setText("");
        jdTelefonoListener.limpiar();
        jdDireccionListener.limpiar();
        pnl.revalidate();
        pnl.repaint();
    }   
    /**
     * Método que añade escuchadores a los elementos del panel
     */
    private void addListeners() {
        pnl.getBtnRegistrar().addActionListener(this);
        pnl.getTxtCedula().getDocument().addDocumentListener(this);
        pnl.getTxtContrasena2().getDocument().addDocumentListener(this);
        pnl.getCheckDiscapacidad().addActionListener(this);
        pnl.getBtnTelefonos().addActionListener(this);
        pnl.getBtnDirecciones().addActionListener(this);
        pnl.getDateFechaNacimiento().addPropertyChangeListener(this);
    }  

    

}
