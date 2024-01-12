package gui;
import archivos.Archivos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

/**
 * Clase escuchadora del FrmHospital del programa.
 * @author ROBLES MORALES
 * @version POO-2023
 */
public class FrmHospitalListener implements ActionListener {
    private FrmHospital frmHospital;
    private PnlRegistros pnlRegCon, pnlRegMed, pnlRegPac;
    private PnlRegistroPersona pnlRegistroPersona;
    private PnlRegistroConsulta pnlRegistroConsulta;
    
    
    /**
     * Metodo contructor que la clase escuchadora de FrmHospital
     * @param frmHospital Referencia a FrmHospital.
     */
    public FrmHospitalListener(FrmHospital frmHospital) {
        this.frmHospital = frmHospital;
    }
    /**
     * Método que contiene el control de acciones de los botones y demás elementos.
     * @param e Acción o evento.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== frmHospital.getBtnMedicos()){
            registrosMedicos();
            return;
        }
        if(e.getSource()== frmHospital.getBtnPacientes()){
            registrosPacientes(); 
            return;
        }
        if(e.getSource()== frmHospital.getBtnConsultas()){
            registrosConsultas();
            return;
        }
        if (e.getSource() == frmHospital.getMniPrincipal()) {
            panelPrincipal(); 
            return;
        }
        if (e.getSource() == frmHospital.getMniSalir()) {            
            System.exit(0); 
            return;
        }
        if (e.getSource() == frmHospital.getMniNuevoDoc()) {
            registrarDoctor();
            return;
        }
        if (e.getSource() == frmHospital.getMniNuevaConsulta()) {
            registrarConsultas();
            return;
        }
        if(e.getSource()== frmHospital.getMniNuevoPaciente()){
            registrarPaciente(); 
            return;
        }
        if(e.getSource()== frmHospital.getMniReporteDoc()){
            reporteMedicos(); 
            return;
        }
        if(e.getSource()== frmHospital.getMniReportePaciente()){
            reportePacientes(); 
            return;
        }
        if(e.getSource()== frmHospital.getMniReporteConsulta()){
            reporteConsultas();
        }
        
    }
    /**
     * Muestra el panel con los registros de consulta.
    */
    public void registrosConsultas(){
        if(pnlRegCon== null){
            List lstElementos = Archivos.leerConsulta();
            List lstCabezeras = Arrays.asList(new Object[]{"ID","Fecha","Consultorio","Paciente","Medico"});
            pnlRegCon = new PnlRegistros(this,  lstElementos, new TblConsulta(lstCabezeras));
            pnlRegCon.getMniVerDireccion().setVisible(false);
            pnlRegCon.getMniVerTelefono().setVisible(false);
            pnlRegCon.getLblTitle().setText("        CONSULTAS");
        }
        pnlRegCon.setLstElementos(Archivos.leerConsulta());
        pnlRegCon.revalidate();
        pnlRegCon.repaint();
        frmHospital.getContentPane().removeAll();
        frmHospital.getContentPane().add(pnlRegCon);
        revalidarContentPane();
        
    }
    /**
     * Muestra el panel con el reporte de consultas.
    */
    public void reporteConsultas(){
        registrosConsultas();
        //ocultarEdit(pnlRegCon);  
        pnlRegCon.revalidate();
        pnlRegCon.repaint();
        revalidarContentPane();
    }
    
    /**
     * Muestra el panel con los registros de Medicos.
    */
    public void registrosMedicos(){ 
        if(pnlRegMed== null){
            List lstElementos = Archivos.leerMedicos();
            List lstCabezeras = Arrays.asList(new Object[]{"ID Carnet","CI","Apellidos","Nombre","Especialidad"});
            pnlRegMed = new PnlRegistros(this,  lstElementos, new TblMedico(lstCabezeras));
            pnlRegMed.getMniVerDiagReceta().setVisible(false);
            pnlRegMed.getLblTitle().setText("        MÉDICOS");
        }
        pnlRegMed.setLstElementos(Archivos.leerMedicos());
        pnlRegMed.revalidate();
        pnlRegMed.repaint();
        frmHospital.getContentPane().removeAll();
        frmHospital.getContentPane().add(pnlRegMed);
        revalidarContentPane();
    }
    /**
     * Muestra el panel con el reporte de Medicos.
    */
    public void reporteMedicos(){
        registrosMedicos();
        //ocultarEdit(pnlRegMed);
        revalidarContentPane();
        pnlRegMed.revalidate();
        pnlRegMed.repaint();
    }
    
    /**
     * Muestra el panel con los registros de Pacientes.
    */
    public void registrosPacientes(){ 
        if(pnlRegPac== null){
            List lstElementos = Archivos.leerPacientes();
            List lstCabezeras = Arrays.asList(new Object[]{"ID Historial","CI","Nombre","Apellidos"});
            pnlRegPac = new PnlRegistros(this,  lstElementos, new TblPaciente(lstCabezeras));
            pnlRegPac.getMniVerDiagReceta().setVisible(false);
            pnlRegPac.getLblTitle().setText("        PACIENTES");
        }
        frmHospital.getContentPane().removeAll();
        frmHospital.getContentPane().add(pnlRegPac);
        //pnlRegPac.setLstElementos(Archivos.leerPacientes());
        pnlRegPac.getTblModel().notifyDomainObjectUpdated(Archivos.leerPacientes());
        pnlRegPac.revalidate();
        pnlRegPac.repaint();    
        revalidarContentPane();
    }
    /**
     * Muestra el panel con el reporte de Pacientes.
    */
    public void reportePacientes(){
        registrosPacientes();
        ocultarEdit(pnlRegPac);   
        revalidarContentPane();
        pnlRegPac.revalidate();
        pnlRegPac.repaint();
    }
    
    /**
     * Oculta los botones de edicion
     * @param pnlReg Contiene una referencia a un JPanel de tipo PnlRegistros.
     */
    public void ocultarEdit(PnlRegistros pnlReg){
        pnlReg.getBtnRegistrar().setVisible(false);
        //pnlReg.getBtnEliminar().setVisible(false);
        pnlReg.revalidate();
        pnlReg.repaint();
    }
    
    /**
     *  Metodo que cambia al panel de registro de Doctor.
     */
    public void registrarDoctor(){
        frmHospital.getContentPane().removeAll();
        if(pnlRegistroPersona == null){
           pnlRegistroPersona = new PnlRegistroPersona(this);
        }
        pnlRegistroPersona.getLblEspecialidad().setVisible(true);
        pnlRegistroPersona.getCbEspecialidad().setVisible(true);
        frmHospital.getContentPane().add(pnlRegistroPersona);
        revalidarContentPane();
    }
    /**
     * Metodo que cambia al panel de registro de pacientes.
     */
    public void registrarPaciente(){
       frmHospital.getContentPane().removeAll();
       if(pnlRegistroPersona == null){
           pnlRegistroPersona = new PnlRegistroPersona(this);
        }
       frmHospital.getContentPane().add(pnlRegistroPersona);
       pnlRegistroPersona.getLblEspecialidad().setVisible(false);
       pnlRegistroPersona.getCbEspecialidad().setVisible(false);
       revalidarContentPane();
    }
    
    /**
     * Metodo que cambia al panel de registro de consultas.
     */
    public void registrarConsultas(){       
       frmHospital.getContentPane().removeAll();
        if(pnlRegistroConsulta == null){
           pnlRegistroConsulta = new PnlRegistroConsulta(this);
        }
       frmHospital.getContentPane().add(pnlRegistroConsulta);
       revalidarContentPane();
    }
    /**
     * Método que regresa al panel principal.
     */
    public void panelPrincipal(){
        frmHospital.getContentPane().removeAll();
        frmHospital.getContentPane().add(frmHospital.getPnlPrincipal());
        revalidarContentPane();
    } 
    /**
     * Metodo que revalida el frmHospital.getContentPane() del Frm.
     */
    private void revalidarContentPane(){
        frmHospital.getContentPane().revalidate();
        frmHospital.getContentPane().repaint();
    }
    /**
     * Método que devuelve una referencia al FrmHospital.
     * @return  frmHospital 
     */
    public FrmHospital getFrmHospital() {
        return frmHospital;
    }
     
}