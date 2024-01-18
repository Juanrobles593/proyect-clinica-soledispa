
package modelo;


import java.io.Serializable;

/**
 * Clase que contiene los atributos de Telefono.
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */

public class Telefono implements Serializable{
    private String numero;
    private Operadora operadora;
    
    /**
     * Constructor de la clase.
     * @param numero Contiene el número del Télefono.
     * @param operadora  CVontiene la operadora delñ télefono.
     */
    public Telefono(String numero, Operadora operadora) {
        this.numero = numero;
        this.operadora = operadora;
    }
    /**
     * Método que devuelve el número de teléfono.
     * @return Número de teléfono.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Método que cambia el número de teléfono.
     * @param numero Número de teléfono.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Método que devuelve la operadora asociada al teléfono.
     * @return Operadora asociada al teléfono.
     */
    public Operadora getOperadora() {
        return operadora;
    }

    /**
     * Método que cambia la operadora asociada al teléfono.
     * @param operadora Operadora asociada al teléfono.
     */
    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }
}
