
package modelo.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt; //https://mvnrepository.com/artifact/org.mindrot/jbcrypt/0.4

/**
 * Clase gestora de la base de datos que realiza las distintas peticiones a la BD
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class GestorBD {
    private static final String URL = "jdbc:sqlserver://bd-clinica-soledispa.database.windows.net:1433";
    private static final String USUARIO = "administrador";
    private static final String CONTRASENA = "User.2024";
    
    public Connection obtenerConexion() throws ClassNotFoundException, SQLException {
        System.out.println("Conectando a la base de datos...");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        System.out.println("Conexión exitosa.");
        return conexion;
    }

    public void cerrarConexion(Connection conexion) throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            System.out.println("Cerrando conexión...");
            conexion.close();
            System.out.println("Conexión cerrada.");
        }
    }

    public boolean registrarUsuario(String nombreUsuario, String contrasena) throws ClassNotFoundException {
        Connection conexion = null;
        try {
            // Generar un hash seguro de la contraseña
            String hashContrasena = BCrypt.hashpw(contrasena, BCrypt.gensalt());

            conexion = obtenerConexion();

            String consulta = "INSERT INTO Usuario (usuario, hashContrasena) VALUES (?, ?)";
            try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
                statement.setString(1, nombreUsuario);
                statement.setString(2, hashContrasena);

                int filasAfectadas = statement.executeUpdate();
                return filasAfectadas > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cerrarConexion(conexion);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    // Método para verificar la contraseña de un usuario
    public boolean verificarContrasena(String nombreUsuario, String contrasena) throws ClassNotFoundException {
        Connection conexion = null;
        try {
            conexion = obtenerConexion();

            String consulta = "SELECT hashContrasena FROM Usuario WHERE usuario = ?";
            try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
                statement.setString(1, nombreUsuario);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String hashAlmacenado = resultSet.getString("hashContrasena");
                        return BCrypt.checkpw(contrasena, hashAlmacenado);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cerrarConexion(conexion);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
