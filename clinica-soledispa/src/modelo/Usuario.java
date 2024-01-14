
package modelo;

/**
 * Clase Usuario que contien la información de los usuarios registrados en el sistema.
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class Usuario {
    Persona oPersona;
    String contrasenia;
    Rol oRol;  
    boolean activo;
    
    /**
     * Constructor de la clase Usuario con todos los atributos.
     * @param oPersona   La persona asociada al usuario.
     * @param contrasenia  La contraseña del usuario.
     * @param oRol   El rol del usuario.
     * @param activo Si el usuario esta activo o no.
     */
    public Usuario(Persona oPersona, String contrasenia, Rol oRol, boolean activo) {
        this.oPersona = oPersona;
        this.contrasenia = contrasenia;
        this.oRol = oRol;
        this.activo = activo;
    }
    
     /**
     * Constructor de la clase Usuario sin el atributo contraseña.
     * @param oPersona   La persona asociada al usuario.
     * @param oRol   El rol del usuario.
     */
    public Usuario(Persona oPersona, Rol oRol) {
        this.oPersona = oPersona;
        this.oRol = oRol;
    }
    
    /**
     * Constructor de Usuario con sin contraseña
     * @param oPersona Persona Asociada.
     * @param oRol Rol de la persona.
     * @param activo si esta o no activo.
     */
    public Usuario(Persona oPersona, Rol oRol, boolean activo) {
        this.oPersona = oPersona;
        this.oRol = oRol;
        this.activo = activo;
    }

    /**
     * Obtiene la persona asociada al usuario.
     * @return La persona asociada al usuario.
     */
    public Persona getoPersona() {
        return oPersona;
    }

    /**
     * Devuelve la persona asociada al usuario.
     * @param oPersona La persona asociada al usuario.
     */
    public void setoPersona(Persona oPersona) {
        this.oPersona = oPersona;
    }

    /**
     * Devuelve la contraseña del usuario.
     * @return La contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Reestabalece una nueva contraseña la contraseña del usuario.
     * @param contrasenia La contraseña del usuario.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el rol del usuario.
     * @return El rol del usuario.
     */
    public Rol getoRol() {
        return oRol;
    }

    /**
     * Establece el rol del usuario.
     * @param oRol El rol del usuario.
     */
    public void setoRol(Rol oRol) {
        this.oRol = oRol;
    }
    
    /**
     * Método que decuelve si la especialidad esta activa.
     * @return Especialidad activa.
     */
    public boolean isActivo() {
        return activo;
    }
    
    /**
     * Método que establece un nuevo valor
     * @param activo nuevo valor de activo o inactivo.
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
