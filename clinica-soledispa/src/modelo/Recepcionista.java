
package modelo;

import java.util.Date;
import java.util.List;

/**
 * Clase que hereda de Persona, contiene los datos de Recepcionista.
 * @author X-FORCE - EQUIPO 3 
 * @version PSW - 2023
 */
public class Recepcionista extends Persona {
     /**
     * Constructor de Recepcionista para crear instancias .
     * @param nombre Nombre del paciente.
     * @param apellidos Apellidos del paciente.
     * @param cedula Número de identificación del paciente.
     * @param email Correo electrónico del paciente.
     * @param tipoSangre Tipo de sangre del paciente.
     * @param estadoCivil Estado civil del paciente.
     * @param poseeDiscapacidad Si recepcionista posee alguna discapacidad.
     * @param tipoDiscapacidad El tipo de discapacidad en caso de poseer.
     * @param fechaNacimiento FEcha de nacimiento.
     * @param sexo Sexo o género de nacimiento del recepcionista.
     * @param telefonos Telefonos del paciente.
     * @param direcciones Direcciones del paciente.
     */
    public Recepcionista(String cedula, String nombre, String apellidos, String email, String tipoSangre,
            String estadoCivil, boolean poseeDiscapacidad, String tipoDiscapacidad, Date fechaNacimiento,
            String sexo,List<Telefono> telefonos, List<Direccion> direcciones) {    
        super(cedula, nombre, apellidos, email, tipoSangre, estadoCivil, poseeDiscapacidad, tipoDiscapacidad,fechaNacimiento, sexo,telefonos, direcciones);
    }
    
    /**
     * Constructor completo de Recepcionista  .
     * @param id identificador de recepcionista.
     * @param nombre Nombre del paciente.
     * @param apellidos Apellidos del paciente.
     * @param cedula Número de identificación del paciente.
     * @param email Correo electrónico del paciente.
     * @param tipoSangre Tipo de sangre del paciente.
     * @param estadoCivil Estado civil del paciente.
     * @param poseeDiscapacidad Si recepcionista posee alguna discapacidad.
     * @param tipoDiscapacidad El tipo de discapacidad en caso de poseer.
     * @param fechaNacimiento Fecha de nacimeinto.
     * @param sexo Sexo o genero de nacieminto del Recepcionista.
     * @param telefonos Telefonos del paciente.
     * @param direcciones Direcciones del paciente.
     */
    public Recepcionista(int id, String cedula, String nombre, String apellidos, String email, String tipoSangre,
            String estadoCivil, boolean poseeDiscapacidad, String tipoDiscapacidad, Date fechaNacimiento,
            String sexo,List<Telefono> telefonos, List<Direccion> direcciones) {    
        super( id,cedula, nombre, apellidos, email, tipoSangre, estadoCivil, poseeDiscapacidad, tipoDiscapacidad,fechaNacimiento,sexo, telefonos, direcciones);
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
