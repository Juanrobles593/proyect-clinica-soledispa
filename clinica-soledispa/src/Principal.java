
import GUI.FrmPrincipal;
import controlador.FrmPrincipalListener;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

//import modelo.bd.GestorBD;
//import java.sql.Connection;

/**
 * Clase que contiene el método main para la ejecución del programa.
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class Principal {
    public static void main (String []args) {  
        
        FrmPrincipal  frm = new FrmPrincipal();
        FrmPrincipalListener frmListener = new FrmPrincipalListener(frm);
        frm.setVisible(true);
//        try {    
//            GestorBD gestorBD = new GestorBD();
//            Connection conexion = gestorBD.obtenerConexion();
//            esperarCincoSegundos();
//            gestorBD.cerrarConexion(conexion);
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
//        }  
//    }
//    
//    public static void esperarCincoSegundos() {
//        try {
//            Thread.sleep(5000); // 5000 milisegundos = 5 segundos
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
