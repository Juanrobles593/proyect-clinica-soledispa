
package modelo;
import modelo.recursos.Especialidad;
import java.util.Date;
import java.util.List;

/**
 * Clase que contiene los datos de Médico, hereda de Persona.
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class Medico extends Persona {
    private Especialidad especialidad;
    
    /**
     * Constructor de la clase Médicos para crear instancias.
     * @param especialidad Especialidad del médico.
     * @param nombre Nombre o nombres del medico.
     * @param apellidos Apellidos del médico.
     * @param cedula Cedula o número de indentidad
     * @param email Correo electronico del médico
     * @param tipoSangre tipo de sangre
     * @param estadoCivil estado actual del médico
     * @param fechaNacimiento Fecha de nacimeinto
     * @param poseeDiscapacidad Si el médico posee alguna discapacidad
     * @param tipoDiscapacidad El tipo de discapacidad en caso de poseer.
     * @param sexo Género de nacimiento de Medico
     * @param telefonos lista de los telefono del médicos.
     * @param direcciones Lista de direcciones del médico.
     */
    public Medico(Especialidad especialidad, String cedula, String nombre, String apellidos, String email,
            String tipoSangre, String estadoCivil, Date fechaNacimiento,boolean poseeDiscapacidad, 
            String tipoDiscapacidad, String sexo,List<Telefono> telefonos, List<Direccion> direcciones) {
        super(cedula, nombre, apellidos, email, tipoSangre, estadoCivil, poseeDiscapacidad, tipoDiscapacidad,fechaNacimiento, sexo, telefonos, direcciones);
        this.especialidad = especialidad;
    }
    /**
     * Constructor de médico completo.
     * @param id
     * @param especialidad Especialidad del médico.
     * @param nombre Nombre o nombres del medico.
     * @param apellidos Apellidos del médico.
     * @param cedula Cedula o número de indentidad
     * @param email Correo electronico del médico
     * @param tipoSangre tipo de sangre
     * @param estadoCivil estado actual del médico
     * @param poseeDiscapacidad Si el médico posee discapacidad.
     * @param tipoDiscapacidad Tipo de discapacidad del médico en caso de poseer
     * @param fechaNacimiento Fecha de nacimeinto del médico
     * @param sexo Genero de nacimiento de médico
     * @param telefonos lista de los médicos
     * @param direcciones Lista de direcciones
     */
    public Medico(int id,Especialidad especialidad, String cedula, String nombre, String apellidos,String email,String tipoSangre,
          String estadoCivil,boolean poseeDiscapacidad, String tipoDiscapacidad,Date fechaNacimiento,String sexo, List<Telefono> telefonos, List<Direccion> direcciones) {
        super(id, cedula, nombre, apellidos, email, tipoSangre, estadoCivil, poseeDiscapacidad, tipoDiscapacidad,fechaNacimiento, sexo,telefonos, direcciones);
        this.especialidad = especialidad;
    }
    /**
     * Método que devuelve el valor de especialidad del médico.
     * @return Especialidad del médico.
     */
    public Especialidad getEspecialidad() {
        return especialidad;
    }
    /**
     * Método que cambia la especialidad de un médico.
     * @param especialidad nuevo valor de especialidad.
     */
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
    /**
     * Metodo que devuelve los datos del médico.
     * @return Cadena con todos los datos del médico.
     */
    @Override
    public String toString() {
        return "Medico{ "+ super.toString() + "especialidad=" + especialidad + '}';
    }
}

        
    
    
    


