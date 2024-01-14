
package modelo;

import modelo.recursos.EstadoCivil;
import java.io.Serializable;

/**
 * Clase que hereda de Persona, contiene los datos de Paciente.
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class Paciente extends Persona implements Serializable{
     /**
     * Constructor completo de Paciente
     * @param nombre Nombre del paciente.
     * @param apellidos Apellidos del paciente.
     * @param cedula Número de identificación del paciente.
     * @param email Correo electrónico del paciente.
     * @param TipoSangre Tipo de sangre del paciente.
     * @param estadoCivil Estado civil del paciente.
     * @param poseeDiscapacidad Tiene discapacidad el paciente
     * @param tipoDiscapacidad  Tipo de descapacidad en caso de poseer
     * @param telefonos Telefonos del paciente
     * @param direcciones Direcciones del paciente.
     */
    public Paciente(String cedula, String nombre, String apellidos, String email, 
                    modelo.recursos.TipoSangre TipoSangre,EstadoCivil estadoCivil,  
                    boolean poseeDiscapacidad, String tipoDiscapacidad,Telefono[] telefonos, Direccion[] direcciones) {    
        super(cedula, nombre, apellidos, email, TipoSangre, estadoCivil, poseeDiscapacidad, tipoDiscapacidad, telefonos, direcciones);
    }
    /**
     * Constructor de Paciente sin correo
     * @param nombre Nombre del paciente.
     * @param apellidos Apellidos del paciente.
     * @param cedula Número de identificación del paciente.
     * @param TipoSangre Tipo de sangre del paciente.
     * @param estadoCivil Estado civil del paciente.
     * @param poseeDiscapacidad Posee discapacidad el paciente.
     * @param tipoDiscapacidad Tipo de discapacidad en caso de tener.
     * @param telefonos Arreglo con los telefonos del paciente.
     * @param direcciones Arreglo con las direcciones del paciente.
     */
    public Paciente(String cedula, String nombre, String apellidos, modelo.recursos.TipoSangre TipoSangre,
            EstadoCivil estadoCivil, boolean poseeDiscapacidad, String tipoDiscapacidad,Telefono[] telefonos, Direccion[] direcciones) {
        super(cedula, nombre, apellidos, TipoSangre, estadoCivil, poseeDiscapacidad, tipoDiscapacidad, telefonos, direcciones);
    }
    /**
     * Método que imprime por consola los datos del paciente.
     * @return Cadena con los datos del paciente.
     */
    @Override
    public String toString() {
        return "Paciente{"+ super.toString()+'}';
    }
}
