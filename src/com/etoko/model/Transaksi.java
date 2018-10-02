package com.etoko.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Arnold Vengeance
 */
public class Transaksi {
    private int idTransaksi;
    private double ppn;
    private Date tanggal;
    private Karyawan karyawan;
    private List<Transaksi_Barang> transaksiBarang;

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public double getPpn() {
        return ppn;
    }

    public void setPpn(double ppn) {
        this.ppn = ppn;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    public List<Transaksi_Barang> getTransaksiBarang() {
        return transaksiBarang;
    }

    public void setTransaksiBarang(List<Transaksi_Barang> transaksiBarang) {
        this.transaksiBarang = transaksiBarang;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idTransaksi;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.ppn) ^ (Double.doubleToLongBits(this.ppn) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.tanggal);
        hash = 23 * hash + Objects.hashCode(this.karyawan);
        hash = 23 * hash + Objects.hashCode(this.transaksiBarang);
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
        final Transaksi other = (Transaksi) obj;
        if (this.idTransaksi != other.idTransaksi) {
            return false;
        }
        if (Double.doubleToLongBits(this.ppn) != Double.doubleToLongBits(other.ppn)) {
            return false;
        }
        if (!Objects.equals(this.tanggal, other.tanggal)) {
            return false;
        }
        if (!Objects.equals(this.karyawan, other.karyawan)) {
            return false;
        }
        if (!Objects.equals(this.transaksiBarang, other.transaksiBarang)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transaksi{" + "idTransaksi=" + idTransaksi + ", ppn=" + ppn + ", tanggal=" + tanggal + ", karyawan=" + karyawan + ", transaksiBarang=" + transaksiBarang + '}';
    }
}