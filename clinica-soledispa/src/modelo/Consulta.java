
package modelo;
import modelo.recursos.Especialidad;
import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * Clase modelo que contiene los atributos y contructores de Cosulta
 * @author ROBLES MORALES
 */

public class Consulta implements Serializable{
    private  int numero;
    private LocalDateTime fechaHora;
    private Paciente oPaciente;
    private Especialidad especialidad;
    private Medico oMedico;
    private int habitación;
    private String diagnostico;
    private String receta;
    private float talla;
    private float peso;
    private String presion;
    private int pulso;
    private boolean seRealizo;
    private double valor;
       
    /**
     * Constructor de Consulta con los datos relevantes.
     * @param fechaHora Muestra la fecha de la cita médica.
     * @param oPaciente Paciente asignadon a la cita.
     * @param especialidad Especialidad de la clinica.
     * @param oMedico Médico que realizara la cita.
     */
    public Consulta(LocalDateTime fechaHora, Paciente oPaciente, Especialidad especialidad, Medico oMedico) {    
        this.fechaHora = fechaHora;
        this.oPaciente = oPaciente;
        this.especialidad = especialidad;
        this.oMedico = oMedico;
    }
    
    /**
     * Constructor de Consulta con los datos relevantes.
     * @param numero identificador de la consulta.
     * @param fechaHora Muestra la fecha de la cita médica.
     * @param oPaciente Paciente asignadon a la cita.
     * @param especialidad Especialidad de la clinica.
     * @param oMedico Médico que realizara la cita.
     */
    public Consulta(int numero, LocalDateTime fechaHora, Paciente oPaciente, Especialidad especialidad, Medico oMedico) {
        this.numero = numero;
        this.fechaHora = fechaHora;
        this.oPaciente = oPaciente;
        this.especialidad = especialidad;
        this.oMedico = oMedico;
    }
    
    /**
     * Constructor de Consulta con los datos relevantes.
     * @param numero identificador de la consulta.
     * @param fechaHora Muestra la fecha de la cita médica.
     * @param oPaciente Paciente asignadon a la cita.
     * @param especialidad Especialidad de la clinica.
     * @param oMedico Médico que realizara la cita.
     * @param habitación Número de habitación/consultorio.
     * @param diagnostico Diagnostico general de la cita.
     * @param receta Receta y/0 indicaciones del médico.
     * @param talla Talla del paciente al momento de la consulta.
     * @param peso Peso al momento de la cita médica.
     * @param presion Presion del paciente en el momento de la cita médica.
     * @param pulso Pulso del paciente al momento de la cita médica.
     * @param seRealizo Se ha realizado o no la consulta.
     * @param valor Precio pagado por la consulta en el agendamiento.
     */
    public Consulta(int numero, LocalDateTime fechaHora, Paciente oPaciente, Especialidad especialidad, Medico oMedico, int habitación, String diagnostico, String receta, float talla, float peso, String presion, int pulso, boolean seRealizo, double valor) {
        this.numero = numero;
        this.fechaHora = fechaHora;
        this.oPaciente = oPaciente;
        this.especialidad = especialidad;
        this.oMedico = oMedico;
        this.habitación = habitación;
        this.diagnostico = diagnostico;
        this.receta = receta;
        this.talla = talla;
        this.peso = peso;
        this.presion = presion;
        this.pulso = pulso;
        this.seRealizo = seRealizo;
        this.valor = valor;
    }  

    /**
     * Retorna el número de la consulta.
     * @return numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Retorna la hora de la consulta.
     * @return fechaHora
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Retorna el habitación
     * @return habitación
     */
    public int getHabitación() {
        return habitación;
    }

    /**
     * Retorna el habitación
     * @param habitación
     */
    public void setHabitación(int habitación) {
        this.habitación = habitación;
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
    
    /**
     * Método que devuelve la especialidad de la cita médica.
     * @return espacialidad de la cita médica.
     */
    public Especialidad getEspecialidad() {
        return especialidad;
    }
    
    /**
     * Método que cambia la especialidad de la cita médica.
     * @param especialidad Especialidad nueva que tendrá la cita.
     */
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    
    /**
     * Método que devuelve la talla del paciente al momento de la cita.
     * @return Talla del paciente al momento.
     */
    public float getTalla() {
        return talla;
    }
    
    /**
     * Método que sustituye la talla del paciente.
     * @param talla nueva talla al momento de la cita.
     */
    public void setTalla(float talla) {
        this.talla = talla;
    }
    
    /**
     * Método que devuelve el peso del paciente de la cita médica.
     * @return Peso del paciente.
     */
    public float getPeso() {
        return peso;
    }
    
    /**
     * Método que utituye el peso del paciente de la cita médica.
     * @param peso Peso del paciente al moemento de la cita.
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    /**
     * Método que devuelve la presión del paciente en la cita médica.
     * @return Presión del paciente.
     */
    public String getPresion() {
        return presion;
    }
    
    /**
     * Nétodo que cambia el valor de presión del paciente.
     * @param presion Presion del paciente.
     */
    public void setPresion(String presion) {
        this.presion = presion;
    }

    /**
     * Método que devuelve el pulso del paciente en la cita médica.
     * @return Pulso del paciente.
     */
    public int getPulso() {
        return pulso;
    }

    /**
     * Método que cambia el valor del pulso del paciente.
     * @param pulso Nuevo pulso del paciente.
     */
    public void setPulso(int pulso) {
        this.pulso = pulso;
    }

    /**
     * Método que devuelve si la consulta médica se realizó o no.
     * @return true si la consulta se realizó, false si no.
     */
    public boolean isSeRealizo() {
        return seRealizo;
    }

    /**
     * Método que cambia el estado de realización de la consulta médica.
     * @param seRealizo true si la consulta se realizó, false si no.
     */
    public void setSeRealizo(boolean seRealizo) {
        this.seRealizo = seRealizo;
    }

    /**
     * Método que devuelve el valor asociado a la consulta médica.
     * @return Valor asociado a la consulta.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Método que cambia el valor asociado a la consulta médica.
     * @param valor Nuevo valor asociado a la consulta.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
}

