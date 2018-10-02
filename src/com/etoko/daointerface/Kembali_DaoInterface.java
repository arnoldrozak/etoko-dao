package com.etoko.daointerface;

import com.etoko.model.Kembali;
import java.util.List;

/**
 *
 * @author Arnold Vengeance
 */
public interface Kembali_DaoInterface {
    boolean insertKembali(Kembali kembali);
    List<Kembali> getKembali();
}
