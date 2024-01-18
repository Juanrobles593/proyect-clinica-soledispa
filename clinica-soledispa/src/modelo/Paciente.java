
package modelo;

import java.util.Date;
import java.util.List;

/**
 * Clase que hereda de Persona, contiene los datos de Paciente.
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class Paciente extends Persona {
     /**
     * Constructor completo de Paciente
     * @param nombre Nombre del paciente.
     * @param apellidos Apellidos del paciente.
     * @param cedula Número de identificación del paciente.
     * @param email Correo electrónico del paciente.
     * @param tipoSangre Tipo de sangre del paciente.
     * @param estadoCivil Estado civil del paciente.
     * @param poseeDiscapacidad Tiene discapacidad el paciente
     * @param tipoDiscapacidad  Tipo de descapacidad en caso de poseer
     * @param fechaNacimiento Fecha de nacimiento.
     * @param sexo Género de nacimiento de Paciente.
     * @param telefonos Telefonos del paciente
     * @param direcciones Direcciones del paciente.
     */
    public Paciente(String cedula, String nombre, String apellidos, String email,String tipoSangre,
                    String estadoCivil,boolean poseeDiscapacidad, String tipoDiscapacidad, Date fechaNacimiento,
                    String sexo,List<Telefono> telefonos, List<Direccion> direcciones) {    
        super(cedula, nombre, apellidos, email, tipoSangre, estadoCivil, poseeDiscapacidad, tipoDiscapacidad,fechaNacimiento, sexo,telefonos, direcciones);
    }
    /**
     * Constructor de Paciente sin correo
     * @param nombre Nombre del paciente.
     * @param apellidos Apellidos del paciente.
     * @param cedula Número de identificación del paciente.
     * @param tipoSangre Tipo de sangre del paciente.
     * @param estadoCivil Estado civil del paciente.
     * @param poseeDiscapacidad Posee discapacidad el paciente.
     * @param tipoDiscapacidad Tipo de discapacidad en caso de tener.
     * @param fechaNacimiento Fecha de nacimeinto.
     * @param sexo Genero de nacimiento de Paciente
     * @param telefonos Arreglo con los telefonos del paciente.
     * @param direcciones Arreglo con las direcciones del paciente.
     */
    public Paciente(String cedula, String nombre, String apellidos, String tipoSangre,
            String estadoCivil, boolean poseeDiscapacidad, String tipoDiscapacidad,Date fechaNacimiento,
            String sexo,List<Telefono> telefonos, List<Direccion> direcciones) {
        super(cedula, nombre, apellidos, tipoSangre, estadoCivil, poseeDiscapacidad, tipoDiscapacidad, fechaNacimiento,sexo, telefonos, direcciones);
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
