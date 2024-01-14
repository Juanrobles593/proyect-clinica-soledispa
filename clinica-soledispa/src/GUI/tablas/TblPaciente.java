
package GUI.tablas;

import java.time.LocalDate;
import java.util.List;
import modelo.recursos.GenericDomainTableModel;
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
            case 0: return Integer.class;  // IdPersona
            case 1: return String.class;  // Cédula
            case 2: return String.class;  // Nombres
            case 3: return String.class;  // Apellidos
            case 4: return String.class;  // Correo electronico
            case 5: return String.class;  // TipoSangre
            case 6: return Boolean.class; // poseeDiscapacidad
            case 7: return String.class;  // TipoDiscapacidad
            case 8: return LocalDate.class;  // FechaNacimiento
        }
        throw new ArrayIndexOutOfBoundsException(columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Paciente p = (Paciente) getDomainObject(rowIndex);
        switch(columnIndex) {
            case 0: return p.getId();
            case 1: return p.getCedula();
            case 2: return p.getNombre();
            case 3: return p.getApellidos();
            case 4: return p.getEmail();
            case 5: return p.getTipoSangre();
            case 6: return p.getEstadoCivil();
            
            
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
