package com.etoko.tabelModel;

import com.etoko.model.Barang;
import com.etoko.model.Transaksi_Barang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arnold Vengeance
 */
public class TabelModel_BarangDetail extends AbstractTableModel{
    
    List<Transaksi_Barang> list=new ArrayList<>();

    public TabelModel_BarangDetail() {
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
            case 0: return list.get(rowIndex).getBarang();
            case 1: return list.get(rowIndex).getJumlah();
            case 2: return list.get(rowIndex).getHarga();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Barang";
            case 1: return "Jumlah";
            case 2: return "Harga";
            default:return null;
        }
    }
    
    public void insertTransaksi_Barang(Transaksi_Barang transaksiBarang){
        this.list.add(transaksiBarang);
        fireTableDataChanged();
    }
    
    public void updateTransaksi_Barang(int index, Transaksi_Barang transaksiBarang){
        this.list.set(index, transaksiBarang);
        fireTableDataChanged();
    }
    
    public void deleteTransaksi_Barang(int index){
        this.list.remove(index);
        fireTableDataChanged();
    }
    
    public void setData(List<Transaksi_Barang> list){
        this.list=list;
        fireTableDataChanged();
    }
    
    public Transaksi_Barang getTransaksi_Barang(int index){
        return list.get(index);
    }
    
    public void bersih(){
        list.clear();
        fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0: return Barang.class;
            case 1: return Integer.class;
            case 2: return Double.class;
            default: return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    public Double hitungHarga(int rowIndex){
        Double harga=0.0;
        if(list.get(rowIndex).getBarang()!=null){
            double barang=list.get(rowIndex).getBarang().getHargaJual();
            Integer jumlah=list.get(rowIndex).getJumlah();
            harga=barang*jumlah;
        }
        return harga;
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(aValue!=null&&aValue instanceof Barang&&columnIndex==0){
            Barang barang=(Barang) aValue;
            list.get(rowIndex).setBarang(barang);
            Double hitungHarga=hitungHarga(rowIndex);
            list.get(rowIndex).setHarga(hitungHarga);
        }
        if(aValue!=null&&aValue instanceof Integer&&columnIndex==1){
            Integer jumlah=(Integer) aValue;
            list.get(rowIndex).setJumlah(jumlah);
            Double hitungHarga=hitungHarga(rowIndex);
            list.get(rowIndex).setHarga(hitungHarga);
        }
    }
    
    
    
}
