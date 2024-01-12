/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import modelo.Direccion;
import java.util.List;
import modelo.GenericDomainTableModel;



/**
 *
 * @author Robles y Castro
 */
public class TblDireccion 
        extends GenericDomainTableModel<Direccion>{
    
    public TblDireccion(List columnIdentifiers){
        super(columnIdentifiers);
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0: return String.class;//ciudad
            case 1: return String.class;//calle
            case 2: return Integer.class;//numero
        }
        throw new ArrayIndexOutOfBoundsException(columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Direccion d = (Direccion) getDomainObject(rowIndex);
        switch(columnIndex) {
            case 0: return d.getCiudad();
            case 1: return d.getCalle();
            case 2: return d.getNumero();
            default: throw new ArrayIndexOutOfBoundsException(columnIndex);
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Direccion d = (Direccion) getDomainObject(rowIndex);
        switch(columnIndex) {
            case 0: d.setCiudad((String)aValue);break;
            case 1: d.setCalle((String)aValue);break;
            case 2: d.setNumero((Integer)aValue); break;
            
            default: throw new ArrayIndexOutOfBoundsException(columnIndex);
        }
        notifyTableCellUpdated(rowIndex, columnIndex); // NO olvidar!!!
    }
        
}
