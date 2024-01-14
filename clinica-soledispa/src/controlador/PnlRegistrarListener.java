
package controlador;

import GUI.PnlRegistrar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 * @author X-FORCE - EQUIPO 3
 * @version  PSW - 2023
 */
public class PnlRegistrarListener implements ActionListener, DocumentListener{
    private PnlRegistrar pnl;

    public PnlRegistrarListener(PnlRegistrar pnl) {
        this.pnl = pnl;
        addListeners();
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == pnl.getCheckDiscapacidad()){
            if(pnl.getCheckDiscapacidad().isSelected()){
                pnl.getTxtaDiscapacidad().setEditable(true);
            }else{
                pnl.getTxtaDiscapacidad().setEditable(false);
            }
            
        }
    }
        
        
    
    /**
     * Método que atrapa el evento de insertar a un elemento.
     * @param e 
     */
    @Override
    public void insertUpdate(DocumentEvent e) {
        verificarTextField(e.getDocument());
        System.out.println("llega alescuchador");
    }
    /**
     * Método que atrapa el evento de eliminar un elemento.
     * @param e 
     */
    @Override
    public void removeUpdate(DocumentEvent e) {
         verificarTextField(e.getDocument());
    }
    /**
     * Método que adapta cambios de estilos
     * @param e 
     */
    @Override
    public void changedUpdate(DocumentEvent e) { } //Metodo no utilizado

    private void verificarTextField(Document doc) {
        if (doc == pnl.getTxtCedula().getDocument()) {
            pnl.getTxtUsuario().setText(pnl.getTxtCedula().getText());
        } else if (doc == pnl.getTxtContrasena2().getDocument()) {
            if(String.valueOf(pnl.getTxtContrasena().getPassword()) ==  String.valueOf(pnl.getTxtContrasena2().getPassword())){
                System.out.println("Las contraseñas coinciden");
            }else{
                System.out.println("La contraseñaS NO coiniciden");
            }
        }
    }
    
    private void addListeners() {
        pnl.getBtnRegistrar().addActionListener(this);
        pnl.getTxtCedula().getDocument().addDocumentListener(this);
        pnl.getTxtContrasena2().getDocument().addDocumentListener(this);
        pnl.getCheckDiscapacidad().addActionListener(this);
    }  
}
