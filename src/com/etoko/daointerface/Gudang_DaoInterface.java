package com.etoko.daointerface;

import com.etoko.model.Gudang;
import java.util.List;

/**
 *
 * @author Arnold Vengeance
 */
public interface Gudang_DaoInterface {
    void insert(Gudang gudang);
    void update(Gudang gudang);
    void delete(Gudang gudang);
    Gudang getById(int id);
    List<Gudang> getGudang();
}
