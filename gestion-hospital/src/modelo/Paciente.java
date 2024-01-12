
package modelo;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que hereda de Persona, contiene los datos de Paciente.
 * @author ROBLES MORALES
 * @version POO - 2023
 */
public class Paciente extends Persona implements Serializable{
    private String idHistorial;
    /**
     * Constructor completo de Paciente
     * @param nombre
     * @param apellidos
     * @param cedula
     * @param telefono
     * @param direccion 
     */
    public Paciente(String nombre, String apellidos, String cedula, List<Telefono> telefono, List<Direccion> direccion) {
        super(nombre, apellidos, cedula, telefono, direccion);
        this.idHistorial = generarId(cedula, nombre, apellidos);
    }
    /**
     * Constructor de Paciente sin Incluir Direccion.
     * @param nombre
     * @param apellidos
     * @param cedula
     * @param telefono 
     */
    public Paciente(String nombre, String apellidos, String cedula, List<Telefono> telefono) {
        super(nombre, apellidos, cedula, telefono);
        this.idHistorial = generarId(cedula, nombre, apellidos);
    }
    /**
     * Método que aplica una sobreescritura del metodo heredado Generar Id
     * @param cedula
     * @param nombre
     * @param apellidos
     * @return EL ID con dos numeros mas al inicio, pertenecientes a la cedula.
     */
    @Override
    public String generarId(String cedula, String nombre, String apellidos) {
        String dosDigitos = cedula.substring(0,2);
        return dosDigitos+super.generarId(cedula, nombre, apellidos); 
    }
    public String getIdHistorial() {
        return idHistorial;
    }
    @Override
    public String toString() {
        return "Paciente{" + "idHistorial=" + idHistorial + super.toString()+'}';
    }

    
    
    
    
    
}
