
package modelo.recursos;

/**
 * Enum que contiene las especialidades de los Médicos
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class Especialidad {
    private int idEspecialidad;
    private String nombre;
    
    /**
     * Constructor con parámetros de la clase Especialidad.
     * @param idEspecialidad El identificador único de la especialidad.
     * @param nombre         El nombre de la especialidad.
     */
    public Especialidad(int idEspecialidad, String nombre) {
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
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
}
