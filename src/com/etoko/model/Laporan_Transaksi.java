package com.etoko.model;

/**
 *
 * @author Arnold Vengeance
 */
public class Laporan_Transaksi {
    private Transaksi transaksi;
    private Transaksi_Barang transaksiBarang;

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Transaksi_Barang getTransaksiBarang() {
        return transaksiBarang;
    }

    public void setTransaksiBarang(Transaksi_Barang transaksiBarang) {
        this.transaksiBarang = transaksiBarang;
    }
    
    
}
