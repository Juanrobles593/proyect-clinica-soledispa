
package modelo;

/**
 * Clase asocidada a los roles que se desempeñan el la clinica.
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class Rol {
    private int idRol;
    private String nombreRol;
    
     /**
     * Constructor de la clase Rol con todos los atributos.
     * @param idRol  El identificador único del rol.
     * @param nombreRol  El nombre del rol.
     */
    public Rol(int idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }

    /**
     * Devuelve el identificador único del rol. 
     * @return El identificador único del rol.
     */
    public int getIdRol() {
        return idRol;
    }

    /**
     * Devuelve el nombre del rol.
     * @return El nombre del rol.
     */
    public String getNombreRol() {
        return nombreRol;
    }

    /**
     * Reestablece el nombre del rol.
     * @param nombreRol El nombre del rol.
     */
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
