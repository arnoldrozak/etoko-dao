package com.etoko.tabelModel;

import com.etoko.model.Karyawan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arnold Vengeance
 */
public class TabelModel_Karyawan extends AbstractTableModel{
    
    List<Karyawan> list=new ArrayList<>();

    public TabelModel_Karyawan() {
    }
    

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return list.get(rowIndex).getIdKaryawan();
            case 1: return list.get(rowIndex).getUsername();
            case 2: return list.get(rowIndex).getNama();
            case 3: return list.get(rowIndex).getStatus();
            case 4: return list.get(rowIndex).getTelepon();
            case 5: return list.get(rowIndex).getAlamat();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Kode Karyawan";
            case 1: return "Username";
            case 2: return "Nama";
            case 3: return "Status";
            case 4: return "Telepon";
            case 5: return "Alamat";
            default:return null;
        }
    }
    
    public void insertKaryawan(Karyawan karyawan){
        this.list.add(karyawan);
        fireTableDataChanged();
    }
    
    public void updateKaryawan(int index, Karyawan karyawan){
        this.list.set(index, karyawan);
        fireTableDataChanged();
    }
    
    public void deleteKaryawan(int index){
        this.list.remove(index);
        fireTableDataChanged();
    }
    
    public void setData(List<Karyawan> list){
        this.list=list;
        fireTableDataChanged();
    }
    
    public Karyawan getKaryawan(int index){
        return list.get(index);
    }
    
    public void bersih(){
        list.clear();
    }
}
