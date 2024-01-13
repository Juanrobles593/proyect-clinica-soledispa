
package modelo;

import java.io.Serializable;

/**
 * Clase que contiene los datos de Direccion
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class Direccion implements Serializable {
    private String ciudad;
    private String calle;
    private int numero;
    /**
     * Constructor de Direccion con todos sus atributos
     * @param ciudad
     * @param calle
     * @param numero 
     */
    public Direccion(String ciudad, String calle, int numero) {
        this.ciudad = ciudad;
        this.calle = calle;
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Direccion{" + "ciudad=" + ciudad + ", calle=" + calle + ", numero=" + numero + '}';
    }
    
    
}
