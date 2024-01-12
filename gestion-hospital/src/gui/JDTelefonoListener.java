
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Telefono;
import modelo.Operadora;

/**
 *  Clase escuchadora de la clase JDTelefono.
 * @author ROBLES MORALES
 * @since 23-08-23
 * @version POO 2023
 */
public class JDTelefonoListener implements ActionListener{
    private JDTelefono jdT;
    private List<Telefono> lstTelefonos;
   
    /**
     * Constructor  de la clase escuchadora de JDTelefono.
     * @param jdT contiene el JDTelefono
     */
    public JDTelefonoListener(JDTelefono jdT) {
        this.jdT = jdT;
    }
    /**
     * Metodo que realiza acciones de acuerdo a que elemento realizo la accion.
     * @param e Contiene el evento
     */
    @Override
    public void actionPerformed(ActionEvent e){
        Object object = e.getSource(); 
        
        if(object == jdT.getBtnAgregar()){
            String num1 =jdT.getTxtNumero1().getText();
            String num2 = jdT.getTxtNumero2().getText();
            Operadora esp1 = jdT.getCbOperadora1().getItemAt(jdT.getCbOperadora1().getSelectedIndex());
            Operadora esp2 = jdT.getCbOperadora2().getItemAt(jdT.getCbOperadora2().getSelectedIndex());
            
            if("".equals(num1) && "".equals(num2)){
                JOptionPane.showMessageDialog(null, "Ingrese por lo menos 1 numero");
                return;
            }
            if(!"".equals(num1) && "".equals(num2)){
                try{
                    int nume = Integer.parseInt(num1);
                    Telefono t1 = new Telefono(num1,esp1);
                    jdT.setLstTelefonos(new ArrayList<>());
                    jdT.getLstTelefonos().add(t1);
                    jdT.setVisible(false);
                }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Ingrese solo numeros en el primer campo");
                        jdT.getTxtNumero1().setText("");
                }return;
            }
            if(!"".equals(num1) && !"".equals(num2)){
                try{
                    int nume = Integer.parseInt(num1);
                    int nume2 = Integer.parseInt(num2);
                    Telefono t1 = new Telefono(num1,esp1);
                    jdT.setLstTelefonos(new ArrayList<>());
                    jdT.getLstTelefonos().add(t1);
                    Telefono t2 = new Telefono(num2,esp2);
                    jdT.getLstTelefonos().add(t2);
                    jdT.setVisible(false);
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Ingrese solo numeros en los campos 1 y 2");
                    jdT.getTxtNumero2().setText("");
                    jdT.getTxtNumero1().setText("");
                }    
            }
        }
        if(object == jdT.getBtnCerrar()){
            jdT.setVisible(false);
        }
    }
}

