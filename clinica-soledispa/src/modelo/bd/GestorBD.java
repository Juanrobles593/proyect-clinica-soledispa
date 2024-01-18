
package modelo.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Direccion;
import modelo.Enfermero;
import modelo.Medico;
import modelo.Paciente;
import modelo.Persona;
import modelo.Recepcionista;
import modelo.Telefono;
import modelo.recursos.Especialidad;
import org.mindrot.jbcrypt.BCrypt; //https://mvnrepository.com/artifact/org.mindrot/jbcrypt/0.4

/**
 * Clase gestora de la base de datos que realiza las distintas peticiones a la BD
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class GestorBD {
    private static Connection conexion;    
    /**
     * Método que realia la conexion a la base de datos
     * @return
     * @throws ClassNotFoundException 
     */
    public static Connection obtenerConexion() throws ClassNotFoundException {
        
        if(conexion == null){
            String URL = "jdbc:sqlserver://bd-clinica-soledispa.database.windows.net:1433;"
                          +"database=BdClinica;"
                          +"user=administrador;"
                          + "password=User.2024;"
                          + "loginTimeOut=30;";
            try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(URL);
            System.out.println("Conexión exitosa.");
            
            }catch(SQLException ex){
                System.out.println(ex.toString());
                return null;
            }
        }
        return conexion; 
    }
    /**
     * Método que cierra la conexion a la base de datos
     * @param conexion
     * @throws SQLException 
     */
    public static void cerrarConexion(Connection conexion) throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            System.out.println("Cerrando conexión...");
            conexion.close();
            System.out.println("Conexión cerrada.");
        }
        
    }
    public static int agregarPersona(Persona p){
        try {
                    Connection con = obtenerConexion();
                    String[] columnasGeneradas = {"idPersona"};  // Especificar las columnas generadas

                    try (PreparedStatement ps = con.prepareStatement("INSERT INTO Persona (cedula, nombres, apellidos, correoElectronico, " +
                                "tipoSangre, estadoCivil, poseeDiscapacidad, tipoDiscapacidad, fechaNacimiento, sexo) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", columnasGeneradas)) {

                        // Establecer los valores de los parámetros para la persona
                        ps.setString(1, p.getCedula());
                        ps.setString(2, p.getNombre());
                        ps.setString(3, p.getApellidos());
                        ps.setString(4, p.getApellidos());
                        ps.setString(5, p.getTipoSangre());
                        ps.setString(6, p.getEstadoCivil());
                        ps.setBoolean(7, p.getPoseeDiscapacidad());
                        if (p.getPoseeDiscapacidad()) {
                            ps.setString(8, p.getTipoDiscapacidad());
                        } else {
                            ps.setString(8, "N/A");
                        }
                        ps.setDate(9, new java.sql.Date(p.getFechaNacimiento().getTime()));
                        ps.setString(10, p.getSexo());

                        int affectedRows = ps.executeUpdate();

                        if (affectedRows > 0) {
                            // Obtener el ID generado
                            ResultSet generatedKeys = ps.getGeneratedKeys();
                            if (generatedKeys.next()) {
                                int idPersonaGenerado = generatedKeys.getInt(1);
                                agregarTelefonos(idPersonaGenerado, p.getListTelefono());
                                agregarDirecciones(idPersonaGenerado,p.getDirecciones());
                                return idPersonaGenerado;
                            }
                        }
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    System.out.println(ex.toString());
                }
        return 0;
    }
    /**
     * Metodo que añade un usario al sistema.
     * @param idPersona
     * @param cedula
     * @param contrasena 
     */ 
    private static void agregarUsuario(int idPersona, String cedula, String contrasena, int rol) {
        try {
            Connection con = obtenerConexion();
            try (PreparedStatement ps = con.prepareStatement("INSERT INTO Usuario (usuario, hashContrasena, idRol, idPersona) VALUES (?, ?,? ,?)")) {
                // Llamar al método para obtener la contraseña hasheada
                String hashContrasena = hashContrasena(contrasena);

                ps.setString(1, cedula);
                ps.setString(2, hashContrasena);
                ps.setInt(3, rol); // ID de Rol para Médico
                ps.setInt(4, idPersona);
                int affectedRows = ps.executeUpdate();

                if (affectedRows > 0) {
                    // Éxito al agregar el usuario
                    System.out.println("Usuario agregado exitosamente.");
                } else {
                    // Manejar el caso en que no se insertó correctamente en la tabla Usuario
                    System.out.println("No se pudo agregar el usuario.");
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }
    
    /**
     * Método que añade un Medico a la base de datos
     * @param p Medico que se agregar a la base de datos.
     * @param contrasena Contraseña de seguridad para ingresar al sistema.
     */
    public static void agregarMedico(Medico p, String contrasena) {
        p.setId(agregarPersona(p));
        try {
            Connection con = obtenerConexion();
            try (PreparedStatement ps = con.prepareStatement("INSERT INTO Medico (idPersona, idEspecialidad) VALUES (?, ?)")) {
                ps.setInt(1, p.getId());
                ps.setInt(2, p.getEspecialidad().getId());

                int affectedRows = ps.executeUpdate();

                if (affectedRows > 0) {
                    // Éxito al agregar el médico
                    System.out.println("Médico agregado exitosamente.");
                } else {
                    // Manejar el caso en que no se insertó correctamente en la tabla Medico
                    System.out.println("No se pudo agregar el médico.");
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
        agregarUsuario(p.getId(), p.getCedula(), contrasena, 2); // 2 es el id rol de Médico
    } 
    /**
     * Método que agrega un Paciente a la base de datos.
     * @param p Paciente que se agrega a la base de datos
     */
    public static void agregarPaciente(Paciente p) {
        p.setId(agregarPersona(p));
                try {
            Connection con = obtenerConexion();
            try (PreparedStatement ps = con.prepareStatement("INSERT INTO Paciente (idPersona) VALUES (?)")) {
                ps.setInt(1, p.getId());

                int affectedRows = ps.executeUpdate();

                if (affectedRows > 0) {
                    // Éxito al agregar el paciente
                    System.out.println("Paciente agregado exitosamente.");
                } else {
                    // Manejar el caso en que no se insertó correctamente en la tabla Paciente
                    System.out.println("No se pudo agregar el paciente.");
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }
    
    /**
     * Método que agrega un enfermero a la base de datos.
     * @param enfermero Enfermero a añadir.
     * @param contrasena Contraseña de acceso al sistema.
     */
    public static void agregarEnfermero(Enfermero enfermero, String contrasena) {
        enfermero.setId(agregarPersona(enfermero));
        try {
            Connection con = obtenerConexion();
            try (PreparedStatement ps = con.prepareStatement("INSERT INTO Enfermero (idPersona) VALUES (?)")) {
                ps.setInt(1, enfermero.getId());

                int affectedRows = ps.executeUpdate();

                if (affectedRows > 0) {
                    // Éxito al agregar el enfermero
                    System.out.println("Enfermero agregado exitosamente.");
                } else {
                    // Manejar el caso en que no se insertó correctamente en la tabla Enfermero
                    System.out.println("No se pudo agregar el enfermero.");
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
        agregarUsuario(enfermero.getId(), enfermero.getCedula(), contrasena, 3); // 3 es el ID de Rol para Enfermero
    }

    /**
     * Método para agregar un Recepcionista a la base de datos.
     * @param recepcionista Recepcionista a añadir.
     * @param contrasena Contraseña de acceso al sistema.
     */
    public static void agregarRecepcionista(Recepcionista recepcionista, String contrasena) {
        recepcionista.setId(agregarPersona(recepcionista));
        try {
            Connection con = obtenerConexion();
            try (PreparedStatement ps = con.prepareStatement("INSERT INTO Recepcionista (idPersona) VALUES (?)")) {
                ps.setInt(1, recepcionista.getId());

                int affectedRows = ps.executeUpdate();

                if (affectedRows > 0) {
                    // Éxito al agregar el recepcionista
                    System.out.println("Recepcionista agregado exitosamente.");
                } else {
                    // Manejar el caso en que no se insertó correctamente en la tabla Recepcionista
                    System.out.println("No se pudo agregar el recepcionista.");
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
        agregarUsuario(recepcionista.getId(), recepcionista.getCedula(), contrasena, 4); // 4 es el ID de Rol para Recepcionista
    }
     
    /**
     * Método para obtener la contraseña hasheada utilizando BCrypt
     * @param contrasena Recibe la contraseña como texto.
     * @return Contraseña encryptada
     */  
    private static String hashContrasena(String contrasena) {
    // Generar un hash de la contraseña usando BCrypt
        return BCrypt.hashpw(contrasena, BCrypt.gensalt());
    }
    
    // Método para agregar direcciones a la base de datos
    private static void agregarDirecciones(int idPersona, List<Direccion> direcciones) {
        try {
            Connection con = obtenerConexion();

            for (Direccion direccion : direcciones) {
                try (PreparedStatement ps = con.prepareStatement("INSERT INTO Direccion (ciudad, calle, numero, idPersona) VALUES (?, ?, ?, ?)")) {
                    ps.setString(1, direccion.getCiudad());
                    ps.setString(2, direccion.getCalle());
                    ps.setInt(3, direccion.getNumero());
                    ps.setInt(4, idPersona);

                    int affectedRows = ps.executeUpdate();

                    if (affectedRows > 0) {
                        // Éxito al agregar la dirección
                        System.out.println("Dirección agregada exitosamente.");
                    } else {
                        // Manejar el caso en que no se insertó correctamente en la tabla Direccion
                        System.out.println("No se pudo agregar la dirección.");
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }
    // Método para agregar teléfonos a la base de datos
    private static void agregarTelefonos(int idPersona, List<Telefono> telefonos) {
        try {
            Connection con = obtenerConexion();

            for (Telefono telefono : telefonos) {
                try (PreparedStatement ps = con.prepareStatement("INSERT INTO Telefono (operadora, numero, idPersona) VALUES (?, ?, ?)")) {
                    ps.setString(1, telefono.getOperadora().name());
                    ps.setString(2, telefono.getNumero());
                    ps.setInt(3, idPersona);

                    int affectedRows = ps.executeUpdate();

                    if (affectedRows > 0) {
                        // Éxito al agregar el teléfono
                        System.out.println("Teléfono agregado exitosamente.");
                    } else {
                        // Manejar el caso en que no se insertó correctamente en la tabla Telefono
                        System.out.println("No se pudo agregar el teléfono.");
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }
    /**
     * Método que carga las especialidades de la base
     * @return 
     */
    public static List<Especialidad> lstEspecialidad(){
        try {
            Statement statement = obtenerConexion().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT idEspecialidad, nombre FROM Especialidad");

            List<Especialidad> especialidades = new ArrayList<>();

            while (resultSet.next()) {
                Especialidad especialidad = new Especialidad();
                especialidad.setId(resultSet.getInt("idEspecialidad"));
                especialidad.setNombre(resultSet.getString("nombre"));

                especialidades.add(especialidad);
            }
            return especialidades;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    
}
