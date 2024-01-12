
package gui;

import java.util.List;
import modelo.GenericDomainTableModel;
import modelo.Medico;
import modelo.Especialidad;

/**
 *
 * @author Univ. de Guayaquil
 */
public class TblMedico 
        extends GenericDomainTableModel<Medico>{
    
    public TblMedico(List columnIdentifiers){
        super(columnIdentifiers);
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0: return String.class;//id
            case 1: return String.class;
            case 2: return String.class;
            case 3: return String.class;
            case 4: return Especialidad.class;
        }
        throw new ArrayIndexOutOfBoundsException(columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Medico m = (Medico) getDomainObject(rowIndex);
        switch(columnIndex) {
            case 0: return m.getCarnet();
            case 1: return m.getCedula();
            case 2: return m.getApellidos();
            case 3: return m.getNombre();
            case 4: return m.getEspecialidad();
            default: throw new ArrayIndexOutOfBoundsException(columnIndex);
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Medico m = (Medico) getDomainObject(rowIndex);
        switch(columnIndex) {
            case 0: break;
            case 1: m.setCedula((String)aValue); break;   
            case 2: m.setApellidos((String)aValue); break;
            case 3: m.setNombre((String)aValue); break;
            case 4: m.setEspecialidad((Especialidad)aValue);
       
            default: throw new ArrayIndexOutOfBoundsException(columnIndex);
        }
        notifyTableCellUpdated(rowIndex, columnIndex); // NO olvidar!!!
    }
        
}
