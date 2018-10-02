package com.etoko.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Arnold Vengeance
 */
public class Barang {
    private int idBarang;
    private String nama;
    private double hargaBeli;
    private double hargaJual;
    private Date tanggal;
    private int jumlah;
    private Gudang gudang;

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(double hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(double hargaJual) {
        this.hargaJual = hargaJual;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Gudang getGudang() {
        return gudang;
    }

    public void setGudang(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idBarang;
        hash = 97 * hash + Objects.hashCode(this.nama);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.hargaBeli) ^ (Double.doubleToLongBits(this.hargaBeli) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.hargaJual) ^ (Double.doubleToLongBits(this.hargaJual) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.tanggal);
        hash = 97 * hash + this.jumlah;
        hash = 97 * hash + Objects.hashCode(this.gudang);
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
        final Barang other = (Barang) obj;
        if (this.idBarang != other.idBarang) {
            return false;
        }
        if (Double.doubleToLongBits(this.hargaBeli) != Double.doubleToLongBits(other.hargaBeli)) {
            return false;
        }
        if (Double.doubleToLongBits(this.hargaJual) != Double.doubleToLongBits(other.hargaJual)) {
            return false;
        }
        if (this.jumlah != other.jumlah) {
            return false;
        }
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.tanggal, other.tanggal)) {
            return false;
        }
        if (!Objects.equals(this.gudang, other.gudang)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nama;
    }
}