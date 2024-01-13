
import GUI.FrmPrincipal;
import javax.swing.JFrame;

/**
 * Clase que contiene el método main para la ejecución del programa.
 * @author Robles Morales & Castro Avila
 * @version POO - 2023
 */
public class Principal {
    public static void main (String []args){
       FrmPrincipal  frm = new FrmPrincipal();
       frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
       frm.getMb().setVisible(false);
       frm.setVisible(true);
    } 
}
