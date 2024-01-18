
package controlador;

import GUI.PnlRegistrarCita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;
import modelo.bd.GestorBD;
import modelo.recursos.Especialidad;

/**
 *
 * @author ROBLES MORALES
 */
public class PnlRegistrarCitaListener implements ActionListener {
    private PnlRegistrarCita pnl;
    private List<Especialidad> especialidades;
    private List<Medico> medicos;
    private Paciente p;

    public PnlRegistrarCitaListener(PnlRegistrarCita pnl) throws ClassNotFoundException {
        this.pnl = pnl;
        vistaEspecialidades();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == pnl.getBtnRegistrar()){
            registrarCitaMedica();
        }
        if(obj == pnl.getBtnBuscar()){
            buscarPaciente();
        }
        if(obj == pnl.getCbMedicos()){
            actualizarMedicos();
        }
    }
    
    /**
     * Método que carga las especialidades, al cbEspecialidades, de la base de datos.
     * @throws ClassNotFoundException 
     */
    public void vistaEspecialidades() throws ClassNotFoundException{
        pnl.getCbEspecialidad().removeAllItems();
        especialidades = GestorBD.lstEspecialidad();
        for (Especialidad especialidad : especialidades) {
            pnl.getCbEspecialidad().addItem(especialidad.getNombre());
        }
    }
    /**
     * Actualiza la lista de médicos segun la especialidad.
     */
    private void actualizarMedicos(){
        pnl.getCbMedicos().removeAllItems();
        int item = pnl.getCbEspecialidad().getSelectedIndex();
        medicos = GestorBD.obtenerMedicosPorEspecialidad(especialidades.get(item).getId());
        
        for(Medico medico : medicos){
            pnl.getCbMedicos().addItem(medico.getApellidos() + " "+medico.getNombre());
        }
        pnl.revalidate();
        pnl.repaint();
    }
    /**
     * 
     */
    private void registrarCitaMedica() {
        int item = pnl.getCbEspecialidad().getSelectedIndex();
        Especialidad especialidad = especialidades.get(pnl.getCbEspecialidad().getSelectedIndex());
        Medico oMedico = medicos.get(pnl.getCbMedicos().getSelectedIndex());
        Consulta consulta = new Consulta(DateALocalDateTime(pnl.getDcFechaCita().getDate()), p, especialidad, oMedico);
        GestorBD.agregarConsulta(consulta);
    }
    /**
     * Busca un paciente y devulve sus datos.
     */
    private void buscarPaciente() {
        
        p = GestorBD.obtenerPacientePorCedula(pnl.getTxtCi_Nombre().getText());
        if(p != null){
            pnl.getTxtNombre().setText(p.getApellidos()+" " +p.getNombre());
            pnl.getTxtCorreo().setText(p.getEmail());
            pnl.getTxtSexo().setText(p.getSexo());
            pnl.revalidate();
            pnl.repaint();
        }
    }
    public static int determinarSiguienteNumeroCita(Date fecha, int idMedico, int idEspecialidad) {
        int numeroCitas = GestorBD.obtenerNumeroCitasMedicas(fecha, idEspecialidad, idMedico);
        // El siguiente número de cita sería el número actual más 1
        return numeroCitas + 1;
    }
    private static LocalDateTime DateALocalDateTime(Date date) {
        // Convertir Date a Instant
        Instant instant = date.toInstant();

        // Crear LocalDateTime a partir de Instant y la zona horaria predeterminada del sistema
        LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();

        return localDateTime;
    }
}
