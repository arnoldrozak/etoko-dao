package com.etoko.model;

import java.util.Objects;

/**
 *
 * @author Arnold Vengeance
 */
public class Gudang {
    private int idGudang;
    private String nama;
    private String keterangan;

    public int getIdGudang() {
        return idGudang;
    }

    public void setIdGudang(int idGudang) {
        this.idGudang = idGudang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idGudang;
        hash = 79 * hash + Objects.hashCode(this.nama);
        hash = 79 * hash + Objects.hashCode(this.keterangan);
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
        final Gudang other = (Gudang) obj;
        if (this.idGudang != other.idGudang) {
            return false;
        }
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.keterangan, other.keterangan)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nama;
    }
}
