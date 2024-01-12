
package gui;

import java.util.List;
import modelo.GenericDomainTableModel;
import modelo.Paciente;

/**
 *
 * @author Robles Juan y Castro
 */
public class TblPaciente 
        extends GenericDomainTableModel<Paciente>{
    
    public TblPaciente(List columnIdentifiers){
        super(columnIdentifiers);
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0: return String.class;//id
            case 1: return String.class;
            case 2: return String.class;
            case 3: return String.class;                       
        }
        throw new ArrayIndexOutOfBoundsException(columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Paciente p = (Paciente) getDomainObject(rowIndex);
        switch(columnIndex) {
            case 0: return p.getIdHistorial();
            case 1: return p.getCedula();
            case 2: return p.getNombre();
            case 3: return p.getApellidos();
            
            default: throw new ArrayIndexOutOfBoundsException(columnIndex);
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Paciente p = (Paciente) getDomainObject(rowIndex);
        switch(columnIndex) {
            case 0: break;
            case 1: p.setNombre((String)aValue); break;
            case 2: p.setCedula((String)aValue); break;
            case 3: p.setApellidos((String)aValue); break;
       
            default: throw new ArrayIndexOutOfBoundsException(columnIndex);
        }
        notifyTableCellUpdated(rowIndex, columnIndex); // NO olvidar!!!
    }
   
        
}
