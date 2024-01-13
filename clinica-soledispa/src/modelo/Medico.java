
package modelo;
import java.io.Serializable;

/**
 * Clase que contiene los datos de Médico, hereda de Persona.
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class Medico extends Persona implements Serializable {
    private Especialidad especialidad;
    
    /**
     * Constructor completo de la clase Médicos.
     * @param especialidad Especialidad del médico.
     * @param nombre Nombre o nombres del medico.
     * @param apellidos Apellidos del médico.
     * @param cedula Cedula o número de indentidad
     * @param email correo electronico válido
     * @param TipoSangre tipo de sangre
     * @param estadoCivil estado actual del médico
     * @param telefonos lista de los médicos
     * @param direcciones Lista de direcciones
     */
    public Medico(Especialidad especialidad, String cedula, String nombre, String apellidos, String email, 
            modelo.TipoSangre TipoSangre, EstadoCivil estadoCivil, Telefono[] telefonos, Direccion[] direcciones) {
        super(cedula, nombre, apellidos, email, TipoSangre, estadoCivil, telefonos, direcciones);
        this.especialidad = especialidad;
    }
    /**
     * Constructor de médico que no incluye el correo.
     * @param especialidad Especialidad del médico.
     * @param nombre Nombre o nombres del medico.
     * @param apellidos Apellidos del médico.
     * @param cedula Cedula o número de indentidad
     * @param TipoSangre tipo de sangre
     * @param estadoCivil estado actual del médico
     * @param telefonos lista de los médicos
     * @param direcciones Lista de direcciones
     */
    public Medico(Especialidad especialidad, String cedula, String nombre, String apellidos, modelo.TipoSangre TipoSangre,
                EstadoCivil estadoCivil, Telefono[] telefonos, Direccion[] direcciones) {
        super(cedula, nombre, apellidos, TipoSangre, estadoCivil, telefonos, direcciones);
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

        
    
    
    


