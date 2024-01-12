
package modelo;
import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * Clase modelo que contiene los atributos y contructores de Cosulta
 * @author ROBLES MORALES
 */

public class Consulta implements Serializable{
    private  int id;
    private LocalDateTime fechaHora;
    private String consultorio;
    private Paciente oPaciente;
    private Medico oMedico;
    private String receta;
    private String diagnostico;
    //Formato de fecha
    //DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    /**
     * Constructor de Consulta
     * @param id Id es automatico.
     * @param consultorio Referencia al  consultorio.
     * @param oPaciente Paciente de la cita
     * @param oMedico Medico que atiende la cita.
     * @param diagnostico Diagnostico de la cita.
     * @param receta Receta enviada por el médico.
     */
    public Consulta(int id,String consultorio, Paciente oPaciente, Medico oMedico,String diagnostico, String receta) {
        this.id = id;
        
        this.fechaHora = LocalDateTime.now();
        //fechaHora.format(formateador);
        this.consultorio = consultorio;
        this.oPaciente = oPaciente;
        this.oMedico = oMedico;
        this.diagnostico = diagnostico;
        this.receta = receta;
    }

    /**
     * Retorna el número de la consulta.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna la hora de la consulta.
     * @return fechaHora
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Retorna el consultorio
     * @return consultorio
     */
    public String getConsultorio() {
        return consultorio;
    }

    /**
     * Retorna el consultorio
     * @param consultorio
     */
    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    /**
     *  Retorna el Paciente
     * @return oPaciente
     */
    public Paciente getoPaciente() {
        return oPaciente;
    }

    /**
     * Método que recibe un Paciente para reemplzar al actual.
     * @param oPaciente
     */
    public void setoPaciente(Paciente oPaciente) {
        this.oPaciente = oPaciente;
    }

    /**
     * Método que recibe un Médico para reemplzar al actual.
     * @return oMedico
     */
    public Medico getoMedico() {
        return oMedico;
    }

    /**
     * Método que recibe un Paciente para reemplzar al actual.
     * @param oMedico
     */
    public void setoMedico(Medico oMedico) {
        this.oMedico = oMedico;
    }

    /**
     * Método que devuelve el valor de receta.
     * @return receta
     */
    public String getReceta() {
        return receta;
    }

    /**
     * Método que reemplaza el valor de receta
     * @param receta
     */
    public void setReceta(String receta) {
        this.receta = receta;
    }

    /**
     * Método que retorna el diagnostico de la consulta.
     * @return diagnostico
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * Método que reemplaza el valor de diagnostico de Consulta.
     * @param diagnostico Contiene el nuevo valor de diagnostico
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}

