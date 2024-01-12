
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase escuchadora de JDReceta
 * @author ROBLES MORALES
 * @version POO-2023
 */
public class JDRecetaListener implements ActionListener {

    private  JDReceta jdR;
    /**
     *  Conatructor de la clase escuchadora.
     * @param jdR contiene la referencia del panel donde fue invocado. 
     */
    public JDRecetaListener(JDReceta jdR) {
        this.jdR = jdR;
    }
    /**
     * Método que contiene las acciones realizada por los botones
     * @param e Evento que se realizó 
     */
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == jdR.getBtnCerrar()){
            jdR.setVisible(false);
        }
    }
}