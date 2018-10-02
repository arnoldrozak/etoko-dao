package com.etoko.daointerface;

import com.etoko.model.Laporan_Transaksi;
import com.etoko.model.Transaksi;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Arnold Vengeance
 */
public interface Transaksi_DaoInterface {
    boolean insertTransaksi(Transaksi transaksi);
    List<Laporan_Transaksi> getTransaksi();
    List<Laporan_Transaksi> getTransaksi(Date tglMulai, Date tglAkhir);
    List<Laporan_Transaksi> getTransaksi(Transaksi transaksi);
    int setIdTransaksi();
}