
package modelo.recursos;

/**
 * Enum que contiene las especialidades de los Médicos
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class Especialidad {
    private int idEspecialidad;
    private String nombre;
    private double valorCita;
    private boolean activa;
    
    /**
     * Constructor con parámetros de la clase Especialidad.
     * @param idEspecialidad El identificador único de la especialidad.
     * @param nombre         El nombre de la especialidad.
     * @param valorCita  Valor de la cita médica de esa especialidad.
     */
    public Especialidad(int idEspecialidad, String nombre, double valorCita) {
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
        this.valorCita = valorCita;
        this.activa = true;
    }
    
    /**
     * Constructor con parámetros de la clase Especialidad.
     * @param idEspecialidad El identificador único de la especialidad.
     * @param nombre         El nombre de la especialidad.
     * @param valorCita      Valor de la cita médica de esa especialidad.
     * @param activa        Si la especialidad se encuentra activa o no.
     */ 
    public Especialidad(int idEspecialidad, String nombre, double valorCita,boolean activa) {
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
        this.valorCita = valorCita;
        this.activa = activa;
    }

    /**
     * Obtiene el identificador único de la especialidad.
     * @return El identificador único de la especialidad.
     */
    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    /**
     * Obtiene el nombre de la especialidad. 
     * @return El nombre de la especialidad.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la especialidad.
     * @param nombre El nombre de la especialidad.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Devuelve el valor de la cita.
     * @return Valor de la cita.
     */
    public double getValorCita() {
        return valorCita;
    }
    
    /**
     * Método que devuelve si la especialidad esta activa.
     * @return si esta activa la especialidad.
     */
    public boolean isActiva() {
        return activa;
    }
    
    /**
     * Método que establce un nuevo valor a la cita.
     * @param valorCita Nuevo valor de la cita para la especialidad.
     */
    public void setValorCita(double valorCita) {
        this.valorCita = valorCita;
    }
    
    /**
     * Método que cambia el estado de activa/incativa a la especialidad.
     * @param activa Nuevo valor true o false.
     */
    public void setActiva(boolean activa) {
        this.activa = activa;
    } 

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
