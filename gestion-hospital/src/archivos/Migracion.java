
package archivos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import modelo.Direccion;
import modelo.Medico;
import modelo.Telefono;
/**
 * Clase que 9igra los datos de los pacientes
 * 
 * @author ROBLES MORALES
 */
public class Migracion {

    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conneccionURL = "jdbc:sqlserver://localhost:1433;databaseName=BdClinicaPr;user=usuarioAdmin;password=123;";
            try (Connection conexion = DriverManager.getConnection(conneccionURL)) {
                System.out.println("Conexión establecida");

                // Obtener la lista de médicos
                List<Medico> listaDeMedicos = Archivos.leerMedicos();

                // Consulta SQL para insertar datos en la tabla de médicos
                String query = "INSERT INTO Medicos (carnet, cedula, apellidos, nombre, especialidad) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                    for (Medico medico : listaDeMedicos) {
                        preparedStatement.setString(1, medico.getCarnet());
                        preparedStatement.setString(2, medico.getCedula());
                        preparedStatement.setString(3, medico.getApellidos());
                        preparedStatement.setString(4, medico.getNombre());
                        preparedStatement.setString(5, medico.getEspecialidad().name());
                        preparedStatement.executeUpdate(); // Ejecutar la inserción
                        
                        
                        // Inserción de datos del teléfono
                        String queryTelefono = "INSERT INTO Telefonos (idMedico, numero, operadora) VALUES (?, ?, ?)";
                        List<Telefono> ListTel = medico.getListTelefono();
                        for(Telefono t :ListTel ){
                            try (PreparedStatement preparedStatementTelefono = conexion.prepareStatement(queryTelefono)) {
                                preparedStatementTelefono.setString(1, medico.getCarnet());
                                preparedStatementTelefono.setString(2, t.getNumero());
                                preparedStatementTelefono.setString(3, t.getOperadora().name());

                                preparedStatementTelefono.executeUpdate();
                            }
                        }
                        // Inserción de datos de la dirección
                        String queryDireccion = "INSERT INTO Direcciones (idMedico, ciudad, calle, numero) VALUES (?, ?, ?, ?)";
                        List<Direccion> ListDir= medico.getListDireccion();
                        for(Direccion d : ListDir){
                            try (PreparedStatement preparedStatementDireccion = conexion.prepareStatement(queryDireccion)) {
                                preparedStatementDireccion.setString(1, medico.getCarnet());
                                preparedStatementDireccion.setString(2, d.getCiudad());
                                preparedStatementDireccion.setString(3, d.getCiudad());
                                preparedStatementDireccion.setInt(4, d.getNumero());

                                preparedStatementDireccion.executeUpdate();
                            }
                        }       
                }      
                } catch (SQLException e) {
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.out.println("Error en la conexion");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error enn el proceso");
        }
    }
}