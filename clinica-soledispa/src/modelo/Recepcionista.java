
package modelo;

import modelo.recursos.EstadoCivil;
import java.io.Serializable;

/**
 * Clase que hereda de Persona, contiene los datos de Recepcionista.
 * @author X-FORCE - EQUIPO 3 
 * @version PSW - 2023
 */
public class Recepcionista extends Persona implements Serializable{
     /**
     * Constructor completo de Paciente.
     * @param nombre Nombre del paciente.
     * @param apellidos Apellidos del paciente.
     * @param cedula Número de identificación del paciente.
     * @param email Correo electrónico del paciente.
     * @param TipoSangre Tipo de sangre del paciente.
     * @param estadoCivil Estado civil del paciente.
     * @param telefonos Telefonos del paciente.
     * @param direcciones Direcciones del paciente.
     */
    public Recepcionista(String cedula, String nombre, String apellidos, String email, modelo.recursos.TipoSangre TipoSangre,EstadoCivil estadoCivil, Telefono[] telefonos, Direccion[] direcciones) {    
        super(cedula, nombre, apellidos, email, TipoSangre, estadoCivil, telefonos, direcciones);
    }
    /**
     * Método que imprime por consola los datos del enfermero.
     * @return Cadena con los datos del paciente.
     */
    @Override
    public String toString() {
        return "Recepcionista{"+ super.toString()+'}';
    }
}
