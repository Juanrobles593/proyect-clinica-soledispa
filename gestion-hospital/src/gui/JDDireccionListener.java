
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Direccion;

/**
 *  Clase escuchadora de JDDirecion
 * @since 23-08-2023 23:07
 * @author ROBLES MORALES
 * @version POO 2023
 */
public class JDDireccionListener implements ActionListener {
    private JDDireccion jdD;
    private String ciudad1,ciudad2;
    private String calle1,calle2;
    private String numero1,numero2;
            
    /**
     * Constructor de JDDirecionListener.
     * @param jdD Contiene una referencia a la clase JDDireccion.
     */
    public JDDireccionListener(JDDireccion jdD) {
        this.jdD = jdD;
    }
    /**
     * Metodo que realiza acciones de acuerdo a que elemento realizo la accion.
     * @param e Contiene el evento
     */
    @Override
    public void actionPerformed(ActionEvent e){
        Object object = e.getSource(); 
        
        if(object == jdD.getBtnGuardar()){
            ciudad1 = jdD.getTxtCiudad1().getText();
            ciudad2 = jdD.getTxtCiudad2().getText();
            calle1 = jdD.getTxtCalle1().getText();
            calle2 = jdD.getTxtCalle2().getText();
            numero1 = jdD.getTxtNumero1().getText();
            numero2 = jdD.getTxtNumero2().getText();
            //Comprobar si no se ha escrito nada
            if(comprobarVacio(ciudad1, calle1,numero1) && comprobarVacio(ciudad2, calle2,numero2) ){
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una Direccion como mínimo");
                return;
                }
            // Comprobar si la primera direccion esta completa
            if(comprobar(ciudad1, calle1,numero1)){
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos de la Direccion 1");
                return;
            }
            // Comprueba si los campos de la segunda direccion estan vacios
            if(comprobarVacio(ciudad2, calle2,numero2)){
                try{
                    int nume = Integer.parseInt(numero1);
                    Direccion d1 = new Direccion(ciudad1, calle1, nume);
                    jdD.setLstDirecciones(new ArrayList<>());
                    jdD.getLstDirecciones().add(d1);
                    jdD.setVisible(false);
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Ingrese solo numeros en el campo numero de Direccion 1");
                    jdD.getTxtNumero1().setText("");
                }
            }else{
                //Comprobar si los campos de la direccion 2 estan completos
                if(comprobar(ciudad2, calle2,numero2)){
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos de la Direccion 2"); 
                }else{
                    try{
                        int nume1 = Integer.parseInt(numero1);
                        int nume2 = Integer.parseInt(numero2);
                        Direccion d1 = new Direccion(ciudad1, calle1, nume1);
                        jdD.setLstDirecciones(new ArrayList<>());
                        jdD.getLstDirecciones().add(d1);
                        Direccion d2 = new Direccion(ciudad2, calle2, nume2);
                        
                        jdD.getLstDirecciones().add(d2);
                        jdD.setVisible(false);
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, " Por favor, ingrese solo numeros en los campos 'Numero' ");
                        
                        jdD.getTxtNumero2().setText("");
                    }
                }
            } 
        } 
        if(object == jdD.getBtnCerrar()){
            
            jdD.setVisible(false);
        }
    }
    
    /**
     *  Método que comprueba si uno o mas String esta vácio
     * 
     * @param ciudad Contiene un Strin de la ciudad
     * @param calle Contiene la calle de la direccion
     * @param numero Contiene el numero de ña direccion
     * @return True o False de la condición
     */
    
    public boolean comprobar(String ciudad, String calle,String numero){
        return "".equals(ciudad) || "".equals(calle) || "".equals(numero);
    }
    
    /**
     * Metodo que compruba si 3 String esta vacio
     * @param ciudad contiene la ciudad de la direccion
     * @param calle contiene la calle de la direccion
     * @param numero contiene el numero de la direccion
     * @return boolean de la consicion
     */
    public boolean comprobarVacio(String ciudad, String calle,String numero){
        return "".equals(ciudad) && "".equals(calle) && "".equals(numero);
    }
}
