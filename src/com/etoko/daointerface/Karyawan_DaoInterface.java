package com.etoko.daointerface;

import com.etoko.model.Karyawan;
import java.util.List;

/**
 *
 * @author Arnold Vengeance
 */
public interface Karyawan_DaoInterface {
    void insert (Karyawan karyawan);
    void update (Karyawan karyawan);
    void delete (Karyawan karyawan);
    Karyawan getById(int id);
    List<Karyawan> getKaryawan();
    Karyawan login(String username, String password);
    boolean ubahPassword(String oldUsername, String oldPassword, String newUsername, String newPassword);
}