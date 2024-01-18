
package modelo;

import java.util.Date;
import java.util.List;

/**
 * Clase que hereda de Persona, contiene los datos de Enfermero.
 * @author X-FORCE - EQUIPO 3 
 * @version PSW - 2023
 */
public class Enfermero extends Persona {
     /**
     * Constructor de Paciente para crear una instancia.
     * @param nombre Nombre del paciente.
     * @param apellidos Apellidos del paciente.
     * @param cedula Número de identificación del paciente.
     * @param tipoSangre Tipo de sangre del paciente.
     * @param estadoCivil Estado civil del paciente.
     * @param poseeDiscapacidad Si el enfermero posee alguna condicion de discapacidad
     * @param tipoDiscapacidad El tipo de discapacidad que posea.
     * @param fechaNacimiento Fecha de nacimiento del enfermero
     * @param sexo Género de nacimiento del Enfermero
     * @param telefonos Telefonos del paciente.
     * @param direcciones Direcciones del paciente.
     */
    public Enfermero(String cedula, String nombre, String apellidos, String tipoSangre,
            String estadoCivil, boolean poseeDiscapacidad, String tipoDiscapacidad, Date fechaNacimiento,
            String sexo,List<Telefono> telefonos, List<Direccion> direcciones) {    
        super(cedula, nombre, apellidos,  tipoSangre, estadoCivil, poseeDiscapacidad, tipoDiscapacidad, fechaNacimiento,sexo, telefonos, direcciones);
    }

     /**
     * Constructor completo de Paciente.
     * @param nombre Nombre del paciente.
     * @param apellidos Apellidos del paciente.
     * @param cedula Número de identificación del paciente.
     * @param email Correo electrónico del paciente.
     * @param tipoSangre Tipo de sangre del paciente.
     * @param estadoCivil Estado civil del paciente.
     * @param poseeDiscapacidad Si el enfermero posee alguna condicion de discapacidad
     * @param tipoDiscapacidad El tipo de discapacidad que posea.
     * @param fechaNacimiento Fecha de nacieminto
     * @param sexo Género de nacimiento de enfermero.
     * @param telefonos Telefonos del paciente.
     * @param direcciones Direcciones del paciente.
     */
    public Enfermero(String cedula, String nombre, String apellidos, String email, String tipoSangre,
            String estadoCivil, boolean poseeDiscapacidad, String tipoDiscapacidad,Date fechaNacimiento,
            String sexo,List<Telefono>telefonos, List<Direccion> direcciones) {    
        super(cedula, nombre, apellidos, email, tipoSangre, estadoCivil, poseeDiscapacidad, tipoDiscapacidad,fechaNacimiento,sexo, telefonos, direcciones);
    }
    
    /**
     * Método que imprime por consola los datos del enfermero.
     * @return Cadena con los datos del paciente.
     */
    @Override
    public String toString() {
        return "Enfermero{"+ super.toString()+'}';
    }
}
