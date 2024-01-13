
package modelo;

/**
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class Usuario {
    Persona oPersona;
    String contrasenia;
    Rol oRol;  
    
    /**
     * Constructor de la clase Usuario con todos los atributos.
     * @param oPersona   La persona asociada al usuario.
     * @param contrasenia  La contraseña del usuario.
     * @param oRol   El rol del usuario.
     */
    public Usuario(Persona oPersona, String contrasenia, Rol oRol) {
        this.oPersona = oPersona;
        this.contrasenia = contrasenia;
        this.oRol = oRol;
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
}
