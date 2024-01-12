
package archivos;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *  Clase que contiene los métodos de Lectura/Escritura de los datos del programa
 * @author ROBLES MORALES
 * @version POO 2023
 */
public class Archivos {

    /**
     * Constructor de la clase Archivos
     */
    public Archivos() {}
    
    /**
     * Método que guarda una lista de Obejtos de Tipo Paciente.
     * @param lstPaciente Contiene la lista de Pacientes a guardar.
     */
    public static void guardarPacientes(List<Paciente> lstPaciente) {
        try {			
            ObjectOutputStream objSalida = 
             new ObjectOutputStream(new FileOutputStream("./src/archivos/pacientes.poo"));
            objSalida.writeObject(lstPaciente);
            objSalida.close();
            System.out.println("Archivo  Pacientes guardado");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        }        
    }  
    
    /**
     *  Método que lee una lista de Obejtos de Tipo Paciente  de una dirección espedifica.
     * @return Lista de Pacientes.
     */
    public static List<Paciente> leerPacientes(){
        
        List<Paciente> lstPaciente = null;
        try {
            ObjectInputStream objEntrada = new ObjectInputStream(new FileInputStream("./src/archivos/pacientes.poo"));
            lstPaciente = (List<Paciente>) objEntrada.readObject();
            objEntrada.close();
            System.out.println("Archivo Leido");

         } catch (IOException | ClassNotFoundException e) {
            lstPaciente = new ArrayList<>();
         }
         return lstPaciente; 
    }
    
    /**
     * Método que lee una lista de Obejtos de Tipo Medicos.
     * @return Lista de Médicos.
     */
    public static List<Medico> leerMedicos(){
        List<Medico> lstMedico = null;
        try {
            ObjectInputStream objEntrada = new ObjectInputStream(new FileInputStream("./src/archivos/medicos.poo"));
            lstMedico = (List<Medico>) objEntrada.readObject();
            objEntrada.close();
            System.out.println("Archivo Leido");

         } catch (IOException | ClassNotFoundException e) {
            lstMedico = new ArrayList<>();
         }
         return lstMedico; 
    }
    
    /**
     * Método que lee y devuelve una lista de Obejtos de Tipo Consulta
     * @return Lista de Onjetos de tipo Consulta.
     */
    public static List<Consulta> leerConsulta(){
        List<Consulta> lstConsulta = null;
        try {
            ObjectInputStream objEntrada = new ObjectInputStream(new FileInputStream("./src/archivos/consultas.poo"));
            lstConsulta = (List<Consulta>) objEntrada.readObject();
            objEntrada.close();
            System.out.println("Archivo Leido");

         } catch (IOException | ClassNotFoundException e) {
            lstConsulta = new ArrayList<>();
         }
         return lstConsulta; 
    }
    
    /**
     * Método que guarda una lista de Obejtos de Tipo Médico.
     * @param lstMedico Lista de Medicos a guardar.
     */
    public static void guardarMedicos(List<Medico> lstMedico) {
        try {			
            ObjectOutputStream objSalida = 
             new ObjectOutputStream(new FileOutputStream("./src/archivos/medicos.poo"));
            objSalida.writeObject(lstMedico);
            objSalida.close();
            System.out.println("Archivo guardado");
        } catch (IOException e) {JOptionPane.showMessageDialog(null, "Ha ocurrido un error");}
        
    }
    
    /**
     *  Método que guarda una lista de Obejtos de Tipo Consulta.
     * @param lstConsulta Contiene la lista de consultas leidas de un archivo.
     */
    public static void guardarConsultas(List<Consulta> lstConsulta) {
        try {			
            ObjectOutputStream objSalida = 
             new ObjectOutputStream(new FileOutputStream("./src/archivos/consultas.poo"));
            objSalida.writeObject(lstConsulta);
            objSalida.close();
            System.out.println("Archivo guardado");
        } catch (IOException e) {JOptionPane.showMessageDialog(null, "Ha ocurrido un error");}
    }
}
    
