
package controlador;

import GUI.PnlRegistros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author ROBLES MORALES
 */
public class PnlRegistrosListener implements ActionListener {
    private PnlRegistros pnlRegistros;
    private int pagina = 0;
    private int maxElementos;
    private List lstElementos, lstMostrar;

    public PnlRegistrosListener(PnlRegistros pnlRegistros) {
        this.pnlRegistros = pnlRegistros;
        addListeners();
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object object = e.getSource();
        lstElementos = pnlRegistros.getLstElementos();
        maxElementos = pnlRegistros.getCbCantidadElementos().getItemAt(pnlRegistros.getCbCantidadElementos().getSelectedIndex());
        
        if(object == pnlRegistros.getBtnPrimeraPagina()){
            primeraPagina();
            return; 
        }
        if(object == pnlRegistros.getBtnUltimaPagina()){
            ultimaPagina();
            return; 
        }
        if(object == pnlRegistros.getBtnSiguiente()){
            siguientePagina();
            return; 
        }
        if(object == pnlRegistros.getBtnAtras()){
           anteriorPagina();
           return;
        }
        if(object == pnlRegistros.getCbCantidadElementos()){
            int max = pnlRegistros.getCbCantidadElementos().getItemAt(pnlRegistros.getCbCantidadElementos().getSelectedIndex());
            primeraPagina(max);
            pnlRegistros.getTblDatos().revalidate();
            pnlRegistros.getTblDatos().repaint();
        }
    }
    /**
     *  Metodo que regresa a la primera pagina de la tabla
     */
    public void primeraPagina(){
       pagina=0;
       if(lstElementos.size() > maxElementos){
           lstMostrar=lstElementos.subList(pagina, maxElementos);
           limpiarReemplazar(lstMostrar);
           pnlRegistros.getBtnSiguiente().setEnabled(true);
           pnlRegistros.getBtnUltimaPagina().setEnabled(true);
       }else{
           lstMostrar=lstElementos.subList(pagina,lstElementos.size());
           limpiarReemplazar(lstMostrar); 
       }
       pnlRegistros.getBtnAtras().setEnabled(false);
       pnlRegistros.getBtnPrimeraPagina().setEnabled(false);
    }
    /**
     *  Metodo que regresa a la primera pagina de la tabla
     * @param max Numero máximo de elementos a mostrar en la tabla.
     */
    public void primeraPagina(int max){
       pagina=0;
       if(lstElementos.size() > max){
           lstMostrar=lstElementos.subList(pagina, max);
           limpiarReemplazar(lstMostrar);
           pnlRegistros.getBtnSiguiente().setEnabled(true);
           pnlRegistros.getBtnUltimaPagina().setEnabled(true);
       }else{
           lstMostrar=lstElementos.subList(pagina,lstElementos.size());
           limpiarReemplazar(lstMostrar); 
       }
       pnlRegistros.getBtnAtras().setEnabled(false);
       pnlRegistros.getBtnPrimeraPagina().setEnabled(false);
    }
    /**
     *  Metodo que regresa a la última pagina de la tabla
     */
    public void ultimaPagina(){
        pagina = (int)lstElementos.size()/maxElementos;
        lstMostrar= lstElementos.subList(maxElementos*pagina,lstElementos.size());
        limpiarReemplazar(lstMostrar);    
        pnlRegistros.getBtnSiguiente().setEnabled(false);       
        pnlRegistros.getBtnUltimaPagina().setEnabled(false);
        pnlRegistros.getBtnAtras().setEnabled(true);
        pnlRegistros.getBtnPrimeraPagina().setEnabled(true);
    }
    /**
     *  Metodo que avanza una pagina de la tabla
     */
    public void siguientePagina(){
        pagina ++;
        if(pagina >= (int)lstElementos.size()/maxElementos ){
            ultimaPagina();
        }else{
           lstMostrar= lstElementos.subList(maxElementos*pagina , maxElementos*pagina +maxElementos);
           limpiarReemplazar(lstMostrar);
           pnlRegistros.getBtnAtras().setEnabled(true);
           pnlRegistros.getBtnPrimeraPagina().setEnabled(true); 
        }      
    }
    /**
     *  Método que retrocede una pagina de la tabla
     */
    public void anteriorPagina(){
        pagina --;
        if(pagina <= 1){
            primeraPagina();
            return;
        }
        lstMostrar=lstElementos.subList(maxElementos*pagina , maxElementos*pagina +maxElementos);
        limpiarReemplazar(lstMostrar);
        pnlRegistros.getBtnAtras().setEnabled(true);
        pnlRegistros.getBtnPrimeraPagina().setEnabled(true);
    }
    /**
     * Metodo que limpia y reemplaza la data del TableModel de la clase Pnlregistros
     * @param l Contiene la lista de Objetos a reemplazar y mostrar en la tabla 
     */
    public void limpiarReemplazar(List l){
        pnlRegistros.getTblModel().clearTableModelData();
        pnlRegistros.getTblModel().addRows(l);
        pnlRegistros.getTblDatos().revalidate();
        pnlRegistros.getTblDatos().repaint();
        int num = pagina +1;
        pnlRegistros.getLblPagina().setText("    Página "+ num);
    }
    /**
     * Método que añade los escuchadores actionListener a los elementos del panel.
     */
    private void addListeners() {
        pnlRegistros.getBtnRegistrar().addActionListener(this);
        pnlRegistros.getBtnVerDetalle().addActionListener(this);
        pnlRegistros.getBtnAtras().addActionListener(this);
        pnlRegistros.getBtnSiguiente().addActionListener(this);
        pnlRegistros.getBtnPrimeraPagina().addActionListener(this);
        pnlRegistros.getBtnUltimaPagina().addActionListener(this);
        pnlRegistros.getCbCantidadElementos().addActionListener(this);
    }
}
