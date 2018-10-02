package com.etoko.dao;

import com.etoko.daointerface.Barang_DaoInterface;
import com.etoko.db.DBKoneksi;
import com.etoko.model.Barang;
import com.etoko.model.Gudang;
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
public class Barang_Dao implements Barang_DaoInterface{
    
    private Connection koneksi;
    private Gudang_Dao gudangDao=new Gudang_Dao();

    public Barang_Dao() {
        koneksi=DBKoneksi.getConnection();
    }

    @Override
    public void insert(Barang barang) {
        PreparedStatement statement=null;
        String sql="insert into barang (nama, harga_beli, harga_jual, tanggal, jumlah, id_gudang) "
                + "values (?, ?, ?, ?, ?, ?)";
        try {
            statement=koneksi.prepareStatement(sql);
            statement.setString(1, barang.getNama());
            statement.setDouble(2, barang.getHargaBeli());
            statement.setDouble(3, barang.getHargaJual());
            statement.setDate(4, new Date(barang.getTanggal().getTime()));
            statement.setInt(5, barang.getJumlah());
            statement.setInt(6, barang.getGudang().getIdGudang());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Barang_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void update(Barang barang) {
        PreparedStatement statement=null;
        String sql="update barang set nama=?, harga_beli=?, harga_jual=?, tanggal=?, jumlah=?, id_gudang=? where "
                + "id_barang=?";
        try {
            statement=koneksi.prepareStatement(sql);
            statement.setString(1, barang.getNama());
            statement.setDouble(2, barang.getHargaBeli());
            statement.setDouble(3, barang.getHargaJual());
            statement.setDate(4, new Date(barang.getTanggal().getTime()));
            statement.setInt(5, barang.getJumlah());
            statement.setInt(6, barang.getGudang().getIdGudang());
            statement.setInt(7, barang.getIdBarang());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Barang_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void delete(Barang barang) {
        PreparedStatement statement=null;
        String sql="delete from barang where id_barang=?";
        try {
            statement=koneksi.prepareStatement(sql);
            statement.setInt(1, barang.getIdBarang());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Barang_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void kurangJumlahStok(int jumlah, Barang barang) {
        PreparedStatement statement=null;
        String sql="update barang set jumlah=jumlah-? where id_barang=?";
        try {
            statement=koneksi.prepareStatement(sql);
            statement.setInt(1, jumlah);
            statement.setInt(2, barang.getIdBarang());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Barang_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean tambahJumlahStok(int jumlah, Barang barang) {
        PreparedStatement statement=null;
        boolean valid=false;
        String sql="update barang set jumlah=jumlah+? where id_barang=?";
        try {
            statement=koneksi.prepareStatement(sql);
            statement.setInt(1, jumlah);
            statement.setInt(2, barang.getIdBarang());
            statement.executeUpdate();
            return valid=true;
        } catch (SQLException ex) {
            Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return valid=false;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Barang_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Barang getById(int id) {
        PreparedStatement statement=null;
        ResultSet rs=null;
        Barang b=null;
        String sql="select * from barang where id_barang=?";
        try {
            statement=koneksi.prepareStatement(sql);
            statement.setInt(1, id);
            rs=statement.executeQuery();
            while(rs.next()){
                b=new Barang();
                b.setIdBarang(rs.getInt("id_barang"));
                int idGudang=rs.getInt("id_gudang");
                Gudang byId = gudangDao.getById(id);
                b.setGudang(byId);
                
                b.setHargaJual(rs.getDouble("harga_jual"));
                b.setHargaBeli(rs.getDouble("harga_beli"));
                b.setJumlah(rs.getInt("jumlah"));
                b.setNama(rs.getString("nama"));
                b.setTanggal(rs.getDate("tanggal"));
            }
            return b;
        } catch (SQLException ex) {
            Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Barang_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Barang_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Barang> getBarang() {
        PreparedStatement statement=null;
        ResultSet rs=null;
        List list=new ArrayList();
        String sql="select * from barang";
        try {
            statement=koneksi.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                Barang b=new Barang();
                b.setIdBarang(rs.getInt("id_barang"));
                int idGudang=rs.getInt("id_gudang");
                Gudang byId = gudangDao.getById(idGudang);
                b.setGudang(byId);
                
                b.setHargaJual(rs.getDouble("harga_jual"));
                b.setHargaBeli(rs.getDouble("harga_beli"));
                b.setJumlah(rs.getInt("jumlah"));
                b.setNama(rs.getString("nama"));
                b.setTanggal(rs.getDate("tanggal"));
                list.add(b);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Barang_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Barang_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}