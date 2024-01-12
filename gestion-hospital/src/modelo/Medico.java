
package modelo;
import java.io.Serializable;
import java.util.List;

/**
 * Clase que contiene los datos de Médico, hereda de Persona.
 * @author ROBLES MORALES
 * @version POO - 2023
 */
public class Medico extends Persona implements Serializable {
    private Especialidad especialidad;
    /**
     * Constructor completo de Medico
     * @param especialidad
     * @param nombre
     * @param apellidos
     * @param cedula
     * @param telefono
     * @param direccion 
     */   
    public Medico(Especialidad especialidad, String nombre, String apellidos, String cedula, List<Telefono> telefono, List<Direccion> direccion) {
        super(nombre, apellidos, cedula, telefono, direccion);
        atributos(especialidad, cedula, nombre, apellidos);
    }
    /**
     * Constructor que no incluye la lista de direcciones
     * @param especialidad
     * @param nombre
     * @param apellidos
     * @param cedula
     * @param telefono 
     */
    public Medico(Especialidad especialidad, String nombre, String apellidos, String cedula, List<Telefono> telefono) {
        super(nombre, apellidos, cedula, telefono);
        this.especialidad = especialidad;
    }
    /**
     * Metodo que genera los atributos que se repiten en los constructores
     * @param especialidad
     * @param cedula
     * @param nombre
     * @param apellidos 
     */
    private void atributos(Especialidad especialidad){
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    
    
}

        
    
    
    


