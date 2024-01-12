
package modelo;

import java.io.Serializable;

/**
 * Clase que contiene los atributos de Telefono.
 * @author ROBLES MORALES
 * @version POO - 2023
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Operadora getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }
}
