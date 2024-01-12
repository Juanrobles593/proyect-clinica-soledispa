
package gui;

import modelo.Consulta;
import java.util.List;
import modelo.GenericDomainTableModel;
import modelo.Paciente;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import modelo.Medico;

/**
 *  Clase que contiene el modelo de tabla de tipo Consulta.
 * @author Robles y Castro
 * @version POO-2023
 */
public class TblConsulta 
        extends GenericDomainTableModel<Consulta>{
    
    /**
     * Constructor que recibe las cabezeras de la tbala
     * @param columnIdentifiers Contiene las cabezeras.
     */
    public TblConsulta(List columnIdentifiers){
        super(columnIdentifiers);
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0: return int.class;
            case 1: return LocalDateTime.class;//fecha y hora
            case 2: return String.class;//consultorio
            case 3: return String.class;//Paciente
            case 4: return String.class;//Medico
        }
        throw new ArrayIndexOutOfBoundsException(columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Consulta c = (Consulta) getDomainObject(rowIndex);
        switch(columnIndex) {
            case 0: return c.getId();
            case 1: return c.getFechaHora().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            case 2: return c.getConsultorio();
            case 3: return c.getoPaciente().getApellidos()+" "+c.getoPaciente().getNombre();
            case 4: return c.getoMedico().getApellidos()+" "+c.getoPaciente().getNombre();
            default: throw new ArrayIndexOutOfBoundsException(columnIndex);
        }
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Consulta c = (Consulta) getDomainObject(rowIndex);
        switch(columnIndex) {
            case 0: break;
            case 1: break;
            case 2: c.setConsultorio((String)aValue); break;
            case 3: c.setoPaciente((Paciente)aValue); break;
            case 4: c.setoMedico((Medico)aValue);
       
            default: throw new ArrayIndexOutOfBoundsException(columnIndex);
        }
        notifyTableCellUpdated(rowIndex, columnIndex); // NO olvidar!!!
    }
        
}
