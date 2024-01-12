
package modelo;
import java.io.Serializable;
import java.util.List;
/**
 * Clase abstracta que contiene los datos de Persona.
 * @author ROBLES MORALES
 * @version POO - 2023
 */
public abstract class Persona implements Serializable{
    protected int id;
    protected String cedula;
    protected String nombre;
    protected String apellidos;
    protected String email;
    protected TipoSangre TipoSangre;
    protected EstadoCivil estadoCivil;
    protected List<Telefono> listTelefono;
    protected List<Direccion> listDireccion;
    /**
     * Constructor que contiene todos los datos de Persona.
     * @param nombre Nombre de la persona
     * @param apellidos Apellidos de la persona.
     * @param cedula  Número de identifiación de la persona.
     * @param email Correo electronico de la persona
     * @param TipoSangre Tipo de sangre obtenido de la clase enum
     * @param estadoCivil Estado civil obtenido de la clase de tipo enum
     * @param listTelefono Contiene el o los telefonos de la persona
     * @param listDireccion Conyiene la o las direcciones de la persona
     */
    public Persona(String cedula, String nombre, String apellidos, String email,
                                TipoSangre TipoSangre, EstadoCivil estadoCivil, 
                                List<Telefono> listTelefono, List<Direccion> listDireccion) {    
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.TipoSangre = TipoSangre;
        this.estadoCivil = estadoCivil;
        this.listTelefono = listTelefono;
        this.listDireccion = listDireccion;
    }
    /**
     * Constructor que no contiene el campo correo.
     * @param nombre Nombre de la persona
     * @param apellidos Apellidos de la persona.
     * @param cedula  Número de identifiación de la persona.
     * @param TipoSangre Tipo de sangre obtenido de la clase enum
     * @param estadoCivil Estado civil obtenido de la clase de tipo enum
     * @param listTelefono Contiene el o los telefonos de la persona
     * @param listDireccion Conyiene la o las direcciones de la persona
     */
    public Persona(String cedula, String nombre, String apellidos, TipoSangre TipoSangre, EstadoCivil estadoCivil, List<Telefono> listTelefono, List<Direccion> listDireccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.TipoSangre = TipoSangre;
        this.estadoCivil = estadoCivil;
        this.listTelefono = listTelefono;
        this.listDireccion = listDireccion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public List<Telefono> getListTelefono() {
        return listTelefono;
    }
    public void setListTelefono(List<Telefono> listTelefono) {
        this.listTelefono = listTelefono;
    }
    public List<Direccion> getListDireccion() {
        return listDireccion;
    }
    public void setListDireccion(List<Direccion> listDireccion) {
        this.listDireccion = listDireccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoSangre getTipoSangre() {
        return TipoSangre;
    }

    public void setTipoSangre(TipoSangre TipoSangre) {
        this.TipoSangre = TipoSangre;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", TipoSangre=" + TipoSangre + ", estadoCivil=" + estadoCivil + ", listTelefono=" + listTelefono + ", listDireccion=" + listDireccion + '}';
    }
    
    
}
