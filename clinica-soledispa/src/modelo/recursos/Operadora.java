
package modelo.recursos;

/**
 * Enum que contiene las distintas operadoras para los télefonos.
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class Operadora {
    private int idOperadora;
    private String nombreOperadora;
    
    /**
     * Constructor de la clase Operadora con todos los atributos.
     * @param idOperadora     El identificador único de la operadora.
     * @param nombreOperadora El nombre de la operadora.
     */
    public Operadora(int idOperadora, String nombreOperadora) {
        this.idOperadora = idOperadora;
        this.nombreOperadora = nombreOperadora;
    }

    /**
     * Obtiene el identificador único de la operadora.
     * @return El identificador único de la operadora.
     */
    public int getIdOperadora() {
        return idOperadora;
    }

    /**
     * Devuelve el nombre de la operadora. 
     * @return El nombre de la operadora.
     */
    public String getNombreOperadora() {
        return nombreOperadora;
    }

    /**
     * Establece un nuevo nombre de la operadora.
     * @param nombreOperadora El nombre de la operadora.
     */
    public void setNombreOperadora(String nombreOperadora) {
        this.nombreOperadora = nombreOperadora;
    }
}
