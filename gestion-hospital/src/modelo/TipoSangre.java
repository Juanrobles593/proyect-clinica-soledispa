
package modelo;

/**
 * Enum que contiene los tipos de sangre.
 * @author ROBLES MORALES
 * @version  POO - 2023
 */
public enum TipoSangre {
    A_POSITIVO("A+"), // No se puede poner directamente el (-) o (+)
    A_NEGATIVO("A-"), // Por tanto se han delarado en constantes.
    B_POSITIVO("B+"),
    B_NEGATIVO("B-"),
    O_POSITIVO("O+"),
    O_NEGATIVO("O-"),
    AB_POSITIVO("AB+"),
    AB_NEGATIVO("AB-");

    private final String tipo;
    /**
     * Constructor de la clase TipoSangre.
     * @param tipo Tipo de sangre declarado en constantes.
     */
    TipoSangre(String tipo) {
        this.tipo = tipo;
    }
    /**
     * Método que devuelve una cadena con el tipo de sangre.
     * @return tipo de sangre.
     */
    public String getTipo() {
        return tipo;
    }
}