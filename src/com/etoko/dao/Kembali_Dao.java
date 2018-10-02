package com.etoko.dao;

import com.etoko.daointerface.Barang_DaoInterface;
import com.etoko.daointerface.Kembali_DaoInterface;
import com.etoko.db.DBKoneksi;
import com.etoko.model.Barang;
import com.etoko.model.Kembali;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arnold Vengeance
 */
public class Kembali_Dao implements Kembali_DaoInterface{

    private Connection koneksi;
    private Barang_DaoInterface barang_DaoIF=new Barang_Dao();
    
    public Kembali_Dao() {
        koneksi=DBKoneksi.getConnection();
    }

    @Override
    public boolean insertKembali(Kembali kembali) {
        
        boolean valid=false;
        Barang_DaoInterface barangDao;
        PreparedStatement statement=null;
        String insert_return="insert into kembali(id_barang, jumlah, tanggal, keterangan) values (?, ?, ?, ?)";
        try {
            koneksi.setAutoCommit(false);
            statement=koneksi.prepareStatement(insert_return);
            statement.setInt(1, kembali.getBarang().getIdBarang());
            statement.setInt(2, kembali.getJumlah());
            statement.setDate(3, new Date(kembali.getTanggal().getTime()));
            statement.setString(4, kembali.getKeterangan());
            statement.executeUpdate();
            
            barangDao=new Barang_Dao();
            barangDao.tambahJumlahStok(kembali.getJumlah(), kembali.getBarang());
            koneksi.commit();
            koneksi.setAutoCommit(true);
            return valid=true;
        } catch (SQLException ex) {
            try {
                koneksi.rollback();
                koneksi.setAutoCommit(true);
                Logger.getLogger(Kembali_Dao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(Kembali_Dao.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return valid=false;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Kembali_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Kembali> getKembali() {
        PreparedStatement statement=null;
        ResultSet rs=null;
        List list=new ArrayList();
        String sql="select * from kembali";
        try {
            statement=koneksi.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                Kembali k=new Kembali();
                k.setIdReturn(rs.getInt("id_return"));
                k.setJumlah(rs.getInt("jumlah"));
                k.setTanggal(rs.getDate("tanggal"));
                k.setKeterangan(rs.getString("keterangan"));
                int idBarang=rs.getInt("id_barang");
                Barang byId = barang_DaoIF.getById(idBarang);
                k.setBarang(byId);
                list.add(k);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Kembali_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Kembali_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Kembali_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}