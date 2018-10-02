package com.etoko.editor;

import com.etoko.model.Barang;
import com.etoko.pencarian.CariBarang;
import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Arnold Vengeance
 */
public class Barang_Editor extends AbstractCellEditor implements TableCellEditor{
    
    private CariBarang cariBarang=new CariBarang();

    public Barang_Editor(CariBarang barang) {
        this.cariBarang=barang;
    }
    

    @Override
    public Object getCellEditorValue() {
        return cariBarang.getBarang();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        Barang barang=null;
        if(value instanceof Barang){
            barang=(Barang) value;
        }
        cariBarang.setBarang(barang);
        return cariBarang;
    }
    
}
