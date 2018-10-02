package com.etoko.model;

import java.util.Objects;

/**
 *
 * @author Arnold Vengeance
 */
public class Karyawan {
    private int idKaryawan;
    private String username;
    private String password;
    private String nama;
    private String status;
    private String telepon;
    private String alamat;

    public int getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(int idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idKaryawan;
        hash = 41 * hash + Objects.hashCode(this.username);
        hash = 41 * hash + Objects.hashCode(this.password);
        hash = 41 * hash + Objects.hashCode(this.nama);
        hash = 41 * hash + Objects.hashCode(this.status);
        hash = 41 * hash + Objects.hashCode(this.telepon);
        hash = 41 * hash + Objects.hashCode(this.alamat);
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
        final Karyawan other = (Karyawan) obj;
        if (this.idKaryawan != other.idKaryawan) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.telepon, other.telepon)) {
            return false;
        }
        if (!Objects.equals(this.alamat, other.alamat)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nama;
    }
}
