
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Consulta;
import modelo.Persona;

/**
 *  Clase escuchadora del Panel PnlRegistros
 * @since 24-Agosto-2023
 * @author ROBLES MORALES
 * @version POO 2023
 */
public class PnlRegistrosListener implements ActionListener,ItemListener{
    private PnlRegistros pnl ;
    private List lstElementos, lstMostrar;
    private int pagina =0;
    private int maxElementos;
    private Persona p;
    private Consulta c;
    private JDReceta jdR;

    /**
     * Constructor de la clase escuchadora.
     * @param pnl Contiene el panel del q es escuchadora.
     */
    public PnlRegistrosListener(PnlRegistros pnl) {
        this.pnl = pnl;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object object = e.getSource();
        lstElementos = pnl.getLstElementos();
        maxElementos = pnl.getCbCantidadElementos().getItemAt(pnl.getCbCantidadElementos().getSelectedIndex());
        // Obtener la clase que se maneja
        String tipo = pnl.getTblModel().getColumnName(0);
        if(object == pnl.getBtnRegistrar()){
            if( "ID".equals(tipo)){
                pnl.getFrm().registrarConsultas(); 
                pnl.getPmnAccion().setVisible(false); return;
            }if("ID Historial".equals(tipo)){
                pnl.getFrm().registrarPaciente();   return;
            }if("ID Carnet".equals(tipo)){
                pnl.getFrm().registrarDoctor();
            }
            return; 
        }
//        if(object == pnl.getBtnVerDetalle()){
//            if( "ID".equals(tipo) || "ID Historial".equals(tipo)){
//                editarPersona();   return;
//            }if("ID Carnet".equals(tipo)){
//                pnl.getFrm().registrarDoctor();
//            return;
//            }
//        }
//        if(object == pnl.getBtnEliminar()){
//            
//            return; 
//        }
        if(object == pnl.getBtnPrimeraPagina()){
            primeraPagina();
            return; 
        }
        if(object == pnl.getBtnUltimaPagina()){
            ultimaPagina();
            return; 
        }
        if(object == pnl.getBtnSiguiente()){
            siguientePagina();
            return; 
        }
        if(object == pnl.getBtnAtras()){
           anteriorPagina();
           return;
        }
        if(object == pnl.getCbCantidadElementos()){
            int max = pnl.getCbCantidadElementos().getItemAt(pnl.getCbCantidadElementos().getSelectedIndex());
            primeraPagina(max);
            pnl.getTblDatos().revalidate();
            pnl.getTblDatos().repaint();
            return;
        }
        if(object == pnl.getMniVerDireccion()){
            if(lstMostrar == null){
                lstMostrar = new ArrayList<>();
                lstMostrar=lstElementos.subList(0,5);
            }
            p = (Persona)lstMostrar.get(pnl.getTblDatos().getSelectedRow());
            if(p.getListDireccion() != null){
                JDDireccion jdDir = new JDDireccion (p.getListDireccion());
                jdDir.setLocationRelativeTo(pnl);
                jdDir.setVisible(true);
                return;
            }
            JOptionPane.showMessageDialog(null, " La persona seleccionada no posee direcciones registradas");
        }
        if(object == pnl.getMniVerTelefono()){
            if(lstMostrar == null){
                if(lstElementos.size() > 5){lstMostrar=lstElementos.subList(0,5);}
                else{lstMostrar=lstElementos.subList(0,lstElementos.size());}
            
            }
            System.out.println("Ver Telefono");
            p = (Persona)lstMostrar.get(pnl.getTblDatos().getSelectedRow());
            JDTelefono jdTel = new JDTelefono(p.getListTelefono());
            jdTel.setLocationRelativeTo(pnl);
            jdTel.setVisible(true);
            return;
        }
        if(e.getSource() == pnl.getMniVerDiagReceta()){
            
            if(lstMostrar == null){
                lstMostrar = new ArrayList<>();
                if(lstElementos.size() > 5){lstMostrar=lstElementos.subList(0,5);}
                else{lstMostrar=lstElementos.subList(0,lstElementos.size());}
            }
            System.out.println("Ver Receta y diagnostico");
            c = (Consulta)lstMostrar.get(pnl.getTblDatos().getSelectedRow());
            System.out.println("probando");
            jdR = new JDReceta(c.getDiagnostico(), c.getReceta());
            jdR.setLocationRelativeTo(pnl);
            jdR.setVisible(true);
            System.out.println("probando hecho");
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
           pnl.getBtnSiguiente().setEnabled(true);
           pnl.getBtnUltimaPagina().setEnabled(true);
       }else{
           lstMostrar=lstElementos.subList(pagina,lstElementos.size());
           limpiarReemplazar(lstMostrar); 
       }
       pnl.getBtnAtras().setEnabled(false);
       pnl.getBtnPrimeraPagina().setEnabled(false);
    }
    /**
     *  Metodo que regresa a la primera pagina de la tabla
     */
    public void primeraPagina(int max){
       pagina=0;
       if(lstElementos.size() > max){
           lstMostrar=lstElementos.subList(pagina, max);
           limpiarReemplazar(lstMostrar);
           pnl.getBtnSiguiente().setEnabled(true);
           pnl.getBtnUltimaPagina().setEnabled(true);
       }else{
           lstMostrar=lstElementos.subList(pagina,lstElementos.size());
           limpiarReemplazar(lstMostrar); 
       }
       pnl.getBtnAtras().setEnabled(false);
       pnl.getBtnPrimeraPagina().setEnabled(false);
    }
    /**
     *  Metodo que regresa a la última pagina de la tabla
     */
    public void ultimaPagina(){
        pagina = (int)lstElementos.size()/maxElementos;
        lstMostrar= lstElementos.subList(maxElementos*pagina,lstElementos.size());
        limpiarReemplazar(lstMostrar);    
        pnl.getBtnSiguiente().setEnabled(false);       
        pnl.getBtnUltimaPagina().setEnabled(false);
        pnl.getBtnAtras().setEnabled(true);
        pnl.getBtnPrimeraPagina().setEnabled(true);
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
           pnl.getBtnAtras().setEnabled(true);
           pnl.getBtnPrimeraPagina().setEnabled(true); 
        }
        
    }
    /**
     *  Metodo que retrocede una pagina de la tabla
     */
    public void anteriorPagina(){
        pagina --;
        if(pagina <= 1){
            primeraPagina();
            return;
        }
        lstMostrar=lstElementos.subList(maxElementos*pagina , maxElementos*pagina +maxElementos);
        limpiarReemplazar(lstMostrar);
        pnl.getBtnAtras().setEnabled(true);
        pnl.getBtnPrimeraPagina().setEnabled(true);
    }
    /**
     * Metodo que limpia y reemplaza la data del TableModel de la clase Pnlregistros
     * @param l Contiene la lista de Objetos a reemplazar y mostrar en la tabla 
     */
    public void limpiarReemplazar(List l){
        pnl.getTblModel().clearTableModelData();
        pnl.getTblModel().addRows(l);
        pnl.getTblDatos().revalidate();
        pnl.getTblDatos().repaint();
        int num = pagina +1;
        pnl.getLblPagina().setText("    Página "+ num);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        lstElementos = pnl.getLstElementos();
        int max = pnl.getCbCantidadElementos().getItemAt(pnl.getCbCantidadElementos().getSelectedIndex());
        primeraPagina(max);
        pnl.getTblDatos().revalidate();
        pnl.getTblDatos().repaint();
                
    }
    
    /**
     * Metodo que permite editar una Persona (Medico y Doctor)
     */
//    public void editarPersona(){
//        if(lstMostrar == null){
//            lstMostrar = new ArrayList<>();
//            lstMostrar=lstElementos.subList(0,5);
//        }
//        p=(Persona)lstMostrar.get(pnl.getTblDatos().getSelectedRow());
//        FrmHospital f = pnl.getFrm().getFrmHospital();
//        f.getContentPane().removeAll();
//        f.getContentPane().add(new PnlRegistroPersona(pnl.getFrm(), p));
//        f.getContentPane().revalidate();
//        f.getContentPane().repaint();
//        
//    }
    
}
