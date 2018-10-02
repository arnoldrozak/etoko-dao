package com.etoko.tabelModel;

import com.etoko.model.Gudang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arnold Vengeance
 */
public class TabelModel_Gudang extends AbstractTableModel{
    
    List<Gudang> list=new ArrayList<>();

    public TabelModel_Gudang() {
    }
    

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return list.get(rowIndex).getIdGudang();
            case 1: return list.get(rowIndex).getNama();
            case 2: return list.get(rowIndex).getKeterangan();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Kode Gudang";
            case 1: return "Nama Gudang";
            case 2: return "Keterangan";
            default:return null;
        }
    }
    
    public void insertGudang(Gudang gudang){
        this.list.add(gudang);
        fireTableDataChanged();
    }
    
    public void updateGudang(int index, Gudang gudang){
        this.list.set(index, gudang);
        fireTableDataChanged();
    }
    
    public void deleteGudang(int index){
        this.list.remove(index);
        fireTableDataChanged();
    }
    
    public void setData(List<Gudang> list){
        this.list=list;
        fireTableDataChanged();
    }
    
    public Gudang getGudang(int index){
        return list.get(index);
    }
    
    public void bersih(){
        list.clear();
    }
}
