
package modelo;
import java.util.Date;
import java.util.List;
/**
 * Clase abstracta que contiene los datos de Persona.
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public abstract class Persona {
    protected int id;
    protected String cedula;
    protected String nombre;
    protected String apellidos;
    protected String email;
    protected String TipoSangre;
    protected String estadoCivil;
    protected Boolean poseeDiscapacidad;
    protected String tipoDiscapacidad;
    protected Date fechaNacimiento;
    protected String sexo;
    protected List<Telefono> telefonos;
    protected List<Direccion> direcciones;
    /**
     * Constructor de Persona para crear una instancia con correo.
     * @param nombre Nombre de la persona.
     * @param apellidos Apellidos de la persona.
     * @param cedula  Número de identifiación de la persona.
     * @param email Correo electronico de la persona.
     * @param TipoSangre Tipo de sangre obtenido de la clase enum.
     * @param estadoCivil Estado civil obtenido de la clase de tipo enum.
     * @param poseeDiscapacidad Indica si la persona posee o no alfuna discapacidad
     * @param tipoDiscapacidad Indica el tipo o detalle de la discapacidad.
     * @param fechaNacimiento Fecha que nacio la persona.
     * @param sexo Género de la persona.
     * @param telefonos Contiene el o los telefonos de la person
     * @param direcciones Conyiene la o las direcciones de la persona.
     */
    public Persona(String cedula, String nombre, String apellidos, String email,
                                String TipoSangre, String estadoCivil, Boolean poseeDiscapacidad,  
                                String tipoDiscapacidad, Date fechaNacimiento,String sexo,List<Telefono> telefonos, List<Direccion> direcciones) {    
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.TipoSangre = TipoSangre;
        this.estadoCivil = estadoCivil;
        this.poseeDiscapacidad = poseeDiscapacidad;
        this.tipoDiscapacidad = tipoDiscapacidad;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.telefonos = telefonos;
        this.direcciones = direcciones;
    }
    /**
     * Constructor de Persona para crear una instancia sin correo.
     * @param nombre Nombre de la persona.
     * @param apellidos Apellidos de la persona.
     * @param cedula  Número de identifiación de la persona.
     * @param TipoSangre Tipo de sangre de la persona.
     * @param estadoCivil Estado civil obtenido de la persona.
     * @param poseeDiscapacidad Indica si la persona posee o no alfuna discapacidad.
     * @param tipoDiscapacidad Indica el tipo o detalle de la discapacidad.
     * @param fechaNacimiento Fecha de nacieminto de la persona.
     * @param sexo Genero de la persona
     * @param telefonos Contiene el o los telefonos de la persona.
     * @param direcciones Conyiene la o las direcciones de la persona.
     */
    public Persona(String cedula, String nombre, String apellidos, String TipoSangre,String estadoCivil, 
                    Boolean poseeDiscapacidad, String tipoDiscapacidad,Date fechaNacimiento,String sexo,List<Telefono> telefonos, List<Direccion> direcciones) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = "N/A";
        this.TipoSangre = TipoSangre;
        this.estadoCivil = estadoCivil;
        this.poseeDiscapacidad = poseeDiscapacidad;
        this.tipoDiscapacidad = tipoDiscapacidad;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo= sexo;
        this.telefonos = telefonos;
        this.direcciones = direcciones;
    }
        
    /**
     * Constructor con todos los campos.
     * @param id id del médico
     * @param nombre Nombre de la persona
     * @param apellidos Apellidos de la persona.
     * @param cedula  Número de identifiación de la persona.
     * @param email Correo de la persona.
     * @param TipoSangre Tipo de sangre obtenido de la clase enum
     * @param estadoCivil Estado civil obtenido de la clase de tipo enum
     * @param poseeDiscapacidad Indica si la persona posee o no alfuna discapacidad
     * @param tipoDiscapacidad Indica el tipo o detalle de la discapacidad.
     * @param fechaNacimiento Fecha de nacimiento de la persona.
     * @param sexo Genero de la persona.
     * @param telefonos Contiene el o los telefonos de la persona
     * @param direcciones Conyiene la o las direcciones de la persona
     */
    public Persona(int id,String cedula, String nombre, String apellidos,String email, String TipoSangre, String estadoCivil, 
                    Boolean poseeDiscapacidad, String tipoDiscapacidad,Date fechaNacimiento,String sexo,List<Telefono> telefonos, List<Direccion> direcciones) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.TipoSangre = TipoSangre;
        this.estadoCivil = estadoCivil;
        this.poseeDiscapacidad = poseeDiscapacidad;
        this.tipoDiscapacidad = tipoDiscapacidad;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.telefonos = telefonos;
        this.direcciones = direcciones;
    }
    
    /**
     * Constructor de Persona para crear una instancia sin correo.
     * @param id id de la Perona
     * @param nombre Nombre de la persona.
     * @param apellidos Apellidos de la persona.
     * @param cedula  Número de identifiación de la persona.
     * @param email Correo electronico
     * @param sexo Genero de la persona
     */
    public Persona(int id,String cedula, String nombre, String apellidos,String email,String sexo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.sexo= sexo;
    }
    /**
     * Método que crea personas con solo 3 paramteros.
     * @param id
     * @param nombre
     * @param apellidos 
     */
    public Persona(int id, String nombre, String apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    
    
    /**
     * Método que devuelve el nombre de la persona.
     * @return Nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que cambia el nombre de la persona.
     * @param nombre Nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve los apellidos de la persona.
     * @return Apellidos de la persona.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Método que cambia los apellidos de la persona.
     * @param apellidos Nuevos apellidos de la persona.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Método que devuelve la cédula de la persona.
     * @return Cédula de la persona.
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Método que cambia la cédula de la persona.
     * @param cedula Nueva cédula de la persona.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Método que devuelve la lista de teléfonos asociados a la persona.
     * @return Lista de teléfonos de la persona.
     */
    public List<Telefono> getListTelefono() {
        return telefonos;
    }

    /**
     * Método que cambia la lista de teléfonos asociados a la persona.
     * @param telefonos Nueva lista de teléfonos de la persona.
     */
    public void setListTelefono(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    /**
     * Método que devuelve la lista de direcciones asociadas a la persona.
     * @return Lista de direcciones de la persona.
     */
    public List<Direccion> getListDireccion() {
        return direcciones;
    }

    /**
     * Método que cambia la lista de direcciones asociadas a la persona.
     * @param direcciones Nueva lista de direcciones de la persona.
     */
    public void setListDireccion(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    /**
     * Método que devuelve el ID de la persona.
     * @return ID de la persona.
     */
    public int getId() {
        return id;
    }

    /**
     * Método que cambia el ID de la persona.
     * @param id Nuevo ID de la persona.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método que devuelve el correo electrónico de la persona.
     * @return Correo electrónico de la persona.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método que cambia el correo electrónico de la persona.
     * @param email Nuevo correo electrónico de la persona.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método que devuelve el tipo de sangre de la persona.
     * @return Tipo de sangre de la persona.
     */
    public String getTipoSangre() {
        return TipoSangre;
    }

    /**
     * Método que cambia el tipo de sangre de la persona.
     * @param TipoSangre Nuevo tipo de sangre de la persona.
     */
    public void setTipoSangre(String TipoSangre) {
        this.TipoSangre = TipoSangre;
    }

    /**
     * Método que devuelve el estado civil de la persona.
     * @return Estado civil de la persona.
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * Método que cambia el estado civil de la persona.
     * @param estadoCivil Nuevo estado civil de la persona.
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Boolean getPoseeDiscapacidad() {
        return poseeDiscapacidad;
    }

    public String getTipoDiscapacidad() {
        return tipoDiscapacidad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }
    
    
    
    /**
     * Método que devuelve una representación en cadena de la persona.
     * @return Cadena que representa a la persona.
     */
    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", TipoSangre=" + TipoSangre + ", estadoCivil=" + estadoCivil + ", telefonos=" + telefonos + ", direcciones=" + direcciones + '}';
    }

}
