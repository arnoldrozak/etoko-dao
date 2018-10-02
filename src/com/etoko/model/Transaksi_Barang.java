package com.etoko.model;

import java.util.Objects;

/**
 *
 * @author Arnold Vengeance
 */
public class Transaksi_Barang {
    private Barang barang;
    private Transaksi transaksi;
    private int jumlah;
    private double harga;

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.barang);
        hash = 59 * hash + Objects.hashCode(this.transaksi);
        hash = 59 * hash + this.jumlah;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.harga) ^ (Double.doubleToLongBits(this.harga) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transaksi_Barang other = (Transaksi_Barang) obj;
        if (this.jumlah != other.jumlah) {
            return false;
        }
        if (Double.doubleToLongBits(this.harga) != Double.doubleToLongBits(other.harga)) {
            return false;
        }
        if (!Objects.equals(this.barang, other.barang)) {
            return false;
        }
        if (!Objects.equals(this.transaksi, other.transaksi)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transaksi_Barang{" + "barang=" + barang + ", transaksi=" + transaksi + ", jumlah=" + jumlah + ", harga=" + harga + '}';
    }
}