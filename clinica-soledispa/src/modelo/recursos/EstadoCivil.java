
package modelo.recursos;

/**
 * Enum que contiene todos los estados civiles.
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class EstadoCivil {
   private int idEstadoCivil;
   private String nombreEstadoCivil;
   
   /**
     * Constructor con parámetros de la clase EstadoCivil.
     * @param idEstadoCivil      El identificador único del estado civil.
     * @param nombreEstadoCivil  El nombre del estado civil.
     */
    public EstadoCivil(int idEstadoCivil, String nombreEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
        this.nombreEstadoCivil = nombreEstadoCivil;
    }

    /**
     * Obtiene el identificador único del estado civil.
     * @return El identificador único del estado civil.
     */
    public int getIdEstadoCivil() {
        return idEstadoCivil;
    }

    /**
     * Obtiene el nombre del estado civil.
     * @return El nombre del estado civil.
     */
    public String getNombreEstadoCivil() {
        return nombreEstadoCivil;
    }

    /**
     * Establece el nombre del estado civil.
     * @param nombreEstadoCivil El nombre del estado civil.
     */
    public void setNombreEstadoCivil(String nombreEstadoCivil) {
        this.nombreEstadoCivil = nombreEstadoCivil;
    }
}