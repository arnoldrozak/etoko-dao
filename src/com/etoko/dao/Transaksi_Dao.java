package com.etoko.dao;

import com.etoko.daointerface.Transaksi_DaoInterface;
import com.etoko.db.DBKoneksi;
import com.etoko.model.Barang;
import com.etoko.model.Karyawan;
import com.etoko.model.Laporan_Transaksi;
import com.etoko.model.Transaksi;
import com.etoko.model.Transaksi_Barang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Arnold Vengeance
 */
public class Transaksi_Dao implements Transaksi_DaoInterface{
    private Connection koneksi;
    private Karyawan_Dao karyawanDao=new Karyawan_Dao();
    private Barang_Dao barangDao=new Barang_Dao();
    
    public Transaksi_Dao() {
        koneksi=DBKoneksi.getConnection();
    }
    

    @Override
    public boolean insertTransaksi(Transaksi transaksi) {
        boolean valid=false;
        PreparedStatement statement=null;
        String sql="insert into transaksi (id_transaksi, ppn, tanggal, id_karyawan) values (?, ?, ?, ?)";
        try {
            koneksi.setAutoCommit(false);
            statement=koneksi.prepareStatement(sql);
            statement.setInt(1, transaksi.getIdTransaksi());
            statement.setDouble(2, transaksi.getPpn());
            statement.setDate(3, new java.sql.Date(transaksi.getTanggal().getTime()));
            statement.setInt(4, transaksi.getKaryawan().getIdKaryawan());
            statement.executeUpdate();
            
            //Proses INSERT ke Transaksi_Barang
            String TRANSAKSI_SQL="insert into transaksi_barang (id_barang, id_transaksi, jumlah, harga) values "
                    + "(?, ?, ?, ?)";
            List<Transaksi_Barang> transaksiBarang = transaksi.getTransaksiBarang();        //WARNING abis kepencet disable
            
            int validJumlah=0;
            for(Transaksi_Barang barangTransaksi: transaksiBarang){
                statement=koneksi.prepareStatement(TRANSAKSI_SQL);
                statement.setInt(1, barangTransaksi.getBarang().getIdBarang());
                statement.setInt(2, barangTransaksi.getTransaksi().getIdTransaksi());
                statement.setInt(3, barangTransaksi.getJumlah());
                statement.setDouble(4, barangTransaksi.getHarga());
                statement.executeUpdate();
                //Update Stok
                barangDao=new Barang_Dao();
                if(barangTransaksi.getBarang().getJumlah()<barangTransaksi.getJumlah()){
                    JOptionPane.showMessageDialog(null, "Jumlah "+barangTransaksi.getBarang().getNama() +"Tidak mencukupi");
                    validJumlah=barangTransaksi.getBarang().getJumlah()-barangTransaksi.getJumlah();
                    valid=false;
                }else{
                    barangDao.kurangJumlahStok(barangTransaksi.getJumlah(), barangTransaksi.getBarang());
                }
            }
            //Validasi Stok(Jika stok tidak minus maka simpan transaksi)
            if(validJumlah<0){
                koneksi.rollback();
                koneksi.setAutoCommit(true);
            }else{
                koneksi.commit();
                koneksi.setAutoCommit(true);
                valid=true;
            }
            
        } catch (SQLException ex) {
            try {
                koneksi.rollback();
                koneksi.setAutoCommit(true);
                Logger.getLogger(Transaksi_Dao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Transaksi_Dao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Transaksi_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public List<Laporan_Transaksi> getTransaksi() {
        PreparedStatement statement=null;
        ResultSet rs=null;
        List list=new ArrayList();
        String sql="select * from transaksi inner join transaksi_barang on "
                + "(transaksi.id_transaksi=transaksi_barang.id_transaksi)";
        try {
            statement=koneksi.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                Laporan_Transaksi lt = new Laporan_Transaksi();
                    Transaksi t=new Transaksi();
                    t.setIdTransaksi(rs.getInt("transaksi.id_transaksi"));
                    t.setTanggal(rs.getDate("transaksi.tanggal"));
                    int idKaryawan=rs.getInt("transaksi.id_karyawan");
                    Karyawan byId = karyawanDao.getById(idKaryawan);
                    t.setKaryawan(byId);
                    t.setPpn(rs.getDouble("transaksi.ppn"));
                lt.setTransaksi(t);
                    Transaksi_Barang tb=new Transaksi_Barang();
                    int idBarang=rs.getInt("transaksi_barang.id_barang");
                    Barang byId1 = barangDao.getById(idBarang);
                    tb.setBarang(byId1);
                    tb.setHarga(rs.getDouble("transaksi_barang.harga"));
                    tb.setJumlah(rs.getInt("transaksi_barang.jumlah"));
                lt.setTransaksiBarang(tb);
                
                list.add(lt);
               
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Transaksi_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Transaksi_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Laporan_Transaksi> getTransaksi(Date tglMulai, Date tglAkhir) {
        PreparedStatement statement=null;
        ResultSet rs=null;
        List list=new ArrayList();
        String sql="select * from transaksi inner join transaksi_barang on "
                + "(transaksi.id_transaksi=transaksi_barang.id_transaksi) "
                + "where (transaksi.tanggal>=?) and (transaksi.tanggal<=?)";
        try {
            statement=koneksi.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(tglMulai.getTime()));
            statement.setDate(2, new java.sql.Date(tglAkhir.getTime()));
            rs=statement.executeQuery();
            while(rs.next()){
                Laporan_Transaksi lt = new Laporan_Transaksi();
                    Transaksi t=new Transaksi();
                    t.setIdTransaksi(rs.getInt("transaksi.id_transaksi"));
                    t.setTanggal(rs.getDate("transaksi.tanggal"));
                    int idKaryawan=rs.getInt("transaksi.id_karyawan");
                    Karyawan byId = karyawanDao.getById(idKaryawan);
                    t.setKaryawan(byId);
                    t.setPpn(rs.getDouble("transaksi.ppn"));
                lt.setTransaksi(t);
                    Transaksi_Barang tb=new Transaksi_Barang();
                    int idBarang=rs.getInt("transaksi_barang.id_barang");
                    Barang byId1 = barangDao.getById(idBarang);
                    tb.setBarang(byId1);
                    tb.setHarga(rs.getDouble("transaksi_barang.harga"));
                    tb.setJumlah(rs.getInt("transaksi_barang.jumlah"));
                lt.setTransaksiBarang(tb);
                
                list.add(lt);
               
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Transaksi_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Transaksi_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Laporan_Transaksi> getTransaksi(Transaksi transaksi) {
        PreparedStatement statement=null;
        ResultSet rs=null;
        List list=new ArrayList();
        String sql="select * from transaksi inner join transaksi_barang on "
                + "(transaksi.id_transaksi=transaksi_barang.id_transaksi) "
                + "where transaksi.id_transaksi=?";
        try {
            statement=koneksi.prepareStatement(sql);
            statement.setInt(1, transaksi.getIdTransaksi());
            rs=statement.executeQuery();
            while(rs.next()){
                Laporan_Transaksi lt = new Laporan_Transaksi();
                    Transaksi t=new Transaksi();
                    t.setIdTransaksi(rs.getInt("transaksi.id_transaksi"));
                    t.setTanggal(rs.getDate("transaksi.tanggal"));
                    int idKaryawan=rs.getInt("transaksi.id_karyawan");
                    Karyawan byId = karyawanDao.getById(idKaryawan);
                    t.setKaryawan(byId);
                    t.setPpn(rs.getDouble("transaksi.ppn"));
                lt.setTransaksi(t);
                    Transaksi_Barang tb=new Transaksi_Barang();
                    int idBarang=rs.getInt("transaksi_barang.id_barang");
                    Barang byId1 = barangDao.getById(idBarang);
                    tb.setBarang(byId1);
                    tb.setHarga(rs.getDouble("transaksi_barang.harga"));
                    tb.setJumlah(rs.getInt("transaksi_barang.jumlah"));
                lt.setTransaksiBarang(tb);
                
                list.add(lt);
               
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Transaksi_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Transaksi_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public int setIdTransaksi() {
        PreparedStatement statement=null;
        ResultSet rs=null;
        int kode=0;
        String sql="SELECT max(transaksi.id_transaksi) as maks FROM transaksi;";
        try {
            statement=koneksi.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                kode=rs.getInt("maks");
            }
            return kode;
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return kode;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Transaksi_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Transaksi_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
