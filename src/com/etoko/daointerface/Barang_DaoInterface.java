package com.etoko.daointerface;

import com.etoko.model.Barang;
import java.util.List;

/**
 *
 * @author Arnold Vengeance
 */
public interface Barang_DaoInterface {
    void insert(Barang barang);
    void update(Barang barang);
    void delete(Barang barang);
    void kurangJumlahStok(int jumlah, Barang barang);
    boolean tambahJumlahStok(int jumlah, Barang barang);
    Barang getById(int id);
    List<Barang> getBarang();
}
