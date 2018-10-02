package com.etoko.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Arnold Vengeance
 */
public class Kembali {
    private int idReturn;
    private Barang barang;
    private int jumlah;
    private Date tanggal;
    private String keterangan;

    public int getIdReturn() {
        return idReturn;
    }

    public void setIdReturn(int idReturn) {
        this.idReturn = idReturn;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idReturn;
        hash = 37 * hash + Objects.hashCode(this.barang);
        hash = 37 * hash + this.jumlah;
        hash = 37 * hash + Objects.hashCode(this.tanggal);
        hash = 37 * hash + Objects.hashCode(this.keterangan);
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
        final Kembali other = (Kembali) obj;
        if (this.idReturn != other.idReturn) {
            return false;
        }
        if (this.jumlah != other.jumlah) {
            return false;
        }
        if (!Objects.equals(this.keterangan, other.keterangan)) {
            return false;
        }
        if (!Objects.equals(this.barang, other.barang)) {
            return false;
        }
        if (!Objects.equals(this.tanggal, other.tanggal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Return{" + "idReturn=" + idReturn + ", barang=" + barang + ", jumlah=" + jumlah + ", tanggal=" + tanggal + ", keterangan=" + keterangan + '}';
    }
}