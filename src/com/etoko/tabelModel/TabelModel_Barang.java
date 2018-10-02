package com.etoko.tabelModel;

import com.etoko.model.Barang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arnold Vengeance
 */
public class TabelModel_Barang extends AbstractTableModel{
    
    List<Barang> list=new ArrayList<>();

    public TabelModel_Barang() {
    }
    

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return list.get(rowIndex).getIdBarang();
            case 1: return list.get(rowIndex).getNama();
            case 2: return list.get(rowIndex).getHargaBeli();
            case 3: return list.get(rowIndex).getHargaJual();
            case 4: return list.get(rowIndex).getJumlah();
            case 5: return list.get(rowIndex).getTanggal();
            case 6: return list.get(rowIndex).getGudang();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Kode Barang";
            case 1: return "Nama";
            case 2: return "Harga Beli";
            case 3: return "Harga Jual";
            case 4: return "Jumlah";
            case 5: return "Tanggal";
            case 6: return "Gudang";
            default:return null;
        }
    }
    
    
    
    public void insertBarang(Barang barang){
        this.list.add(barang);
        fireTableDataChanged();
    }
    
    public void updateBarang(int index, Barang barang){
        this.list.set(index, barang);
        fireTableDataChanged();
    }
    
    public void deleteBarang(int index){
        this.list.remove(index);
        fireTableDataChanged();
    }
    
    public void setData(List<Barang> list){
        this.list=list;
        fireTableDataChanged();
    }
    
    public Barang getBarang(int index){
        return list.get(index);
    }
    
    public void bersih(){
        list.clear();
    }
}
