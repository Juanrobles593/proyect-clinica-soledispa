
package gui;

import archivos.Archivos;
import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Especialidad;

/**
 *  Clase ewscuchadora de PnlRegistroConsulta
 * @since agosto-2023
 * @author ROBLES MORALES
 * @version POO 2023
 */
public class PnlRegistroConsultaListener implements ActionListener{
    private PnlRegistroConsulta pnl;
    private Especialidad especialidadFiltro;
    private List<Medico> lstMedicos;
    private List<Medico> lstMedicosFiltro;
    private List<Paciente> lstPacientes;
    private List<Consulta> lstConsulta;
    private Paciente p;
    private Consulta c;
    private static int id;
    
    /**
     * Constructor de la clase escuchadora de PnlRegistro.
     * @param pnl 
     */
    public PnlRegistroConsultaListener(PnlRegistroConsulta pnl) {
        this.pnl = pnl;
        recuperarDatos();
    }
    /**
     * Método que realiza acciones de los elementos del PnlRegistroPersona.
     * @param e Contiene el objeto sobre el cual se realiza la acción
     */
    @Override
    public void actionPerformed(ActionEvent e){
        Object object = e.getSource();
        
        if(object == pnl.getBtnBuscar()){
            buscarPaciente();
            revalidate();
        }
        if(object == pnl.getCbEspecialidad()){
            medicosRefresh();
            revalidate();
        }
        if (object == pnl.getBtnCancelar()){
            limpiar();
            pnl.getF().panelPrincipal();
            revalidate();
        }
        if(object == pnl.getBtnRegistrar()){
            addConsulta();
            revalidate();
        }
    }
    /**
     * Método que añade un registro de consulta y actualiza.
     */
    public void addConsulta() {
        String consultorio= pnl.getTxtHabitacion().getText();
        String diagnostico = pnl.getTxtADiagnostico().getText();
        String receta = pnl.getTxtAReceta().getText();
        int item = pnl.getCbMedicos().getSelectedIndex();
        Medico medico = lstMedicosFiltro.get(item);
        c = new Consulta(id,consultorio, p, medico, diagnostico, receta);
        
        lstConsulta.add(c);
        Archivos.guardarConsultas(lstConsulta);
        lstConsulta= Archivos.leerConsulta();
        limpiar();
        recuperarDatos();
    }
    /**
     * Método que busca pacientes por ID o cédula.
     */
    private void buscarPaciente(){
        String idBuscar = pnl.getTxtIdPac().getText();
        for (Paciente paciente : lstPacientes) {
            if (paciente.getIdHistorial().equals(idBuscar) ||  paciente.getCedula().equals(idBuscar) ) {
                p = paciente;
                pnl.getTxtNombrePac().setText(p.getNombre());
                pnl.getTxtApellidosPac().setText(p.getApellidos());
                pnl.revalidate();
                pnl.repaint();
                break;
            }
        }if(p == null){
            int respuesta = JOptionPane.showConfirmDialog(null,"¿Deseas crear un nuevo Paciente?",
                    "NuevoPaciente",JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                pnl.getF().registrarPaciente();
            }
        }
    }
    /**
     * Método que muestra los doctores de un área en un comboBox
     */
    public void medicosRefresh(){
        pnl.getCbMedicos().removeAllItems();
        lstMedicosFiltro= new ArrayList<>();
        especialidadFiltro = pnl.getCbEspecialidad().getItemAt(pnl.getCbEspecialidad().getSelectedIndex());
        if (especialidadFiltro != null) {
            for (Medico m : lstMedicos) {
                if ( especialidadFiltro.equals(m.getEspecialidad())) {
                    lstMedicosFiltro.add(m);
                    String mNombre = m.getApellidos()+" "+m.getNombre();
                    pnl.getCbMedicos().addItem(mNombre);
                }
            }
            if(pnl.getCbMedicos().getItemCount() >= 1){
                pnl.getCbMedicos().setEnabled(true);
            }else{
                pnl.getCbMedicos().setEnabled(false);
            }
        }
    }
    /**
     * Método que lee los datos en memoria.
     */
    private void recuperarDatos(){
        lstMedicos = Archivos.leerMedicos();
        lstPacientes = Archivos.leerPacientes();
        lstConsulta = Archivos.leerConsulta(); 
        id= lstConsulta.size()+1;
    }
    /**
     * Método que limpia el panel para el ingreso de un nuevo registro.
     */
    private void limpiar(){
        pnl.getTxtNombrePac().setText("");
        pnl.getTxtApellidosPac().setText("");
        pnl.getTxtIdPac().setText("");
        pnl.getCbEspecialidad().setSelectedItem(false);
        pnl.getCbMedicos().removeAllItems();
        pnl.getTxtHabitacion().setText("");
        pnl.getTxtADiagnostico().setText("");
        pnl.getTxtAReceta().setText("");
    }
    /**
     * Método que ravalida y repinta el JPanl.
     */
    public void revalidate(){
        pnl.revalidate();
        pnl.repaint();
    }
    
}
