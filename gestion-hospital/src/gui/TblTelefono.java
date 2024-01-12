
package gui;

import modelo.Telefono;
import java.util.List;
import modelo.GenericDomainTableModel;
import modelo.Operadora;



/**
 *
 * @author Robles y Castro
 */
public class TblTelefono 
        extends GenericDomainTableModel<Telefono>{
    
    public TblTelefono(List columnIdentifiers){
        super(columnIdentifiers);
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0: return String.class;//numero
            case 1: return Operadora.class;//operadora
        }
        throw new ArrayIndexOutOfBoundsException(columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Telefono t = (Telefono) getDomainObject(rowIndex);
        switch(columnIndex) {
            case 0: return t.getNumero();
            case 1: return t.getOperadora();
            
            default: throw new ArrayIndexOutOfBoundsException(columnIndex);
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Telefono t = (Telefono) getDomainObject(rowIndex);
        switch(columnIndex) {
            case 0: t.setNumero((String)aValue);break;
            case 1: t.setOperadora((Operadora)aValue);break;
            
            default: throw new ArrayIndexOutOfBoundsException(columnIndex);
        }
        notifyTableCellUpdated(rowIndex, columnIndex); // NO olvidar!!!
    }
        
}
