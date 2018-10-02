package com.etoko.dao;

import com.etoko.daointerface.Gudang_DaoInterface;
import com.etoko.db.DBKoneksi;
import com.etoko.model.Gudang;
import java.sql.Connection;
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
public class Gudang_Dao implements Gudang_DaoInterface{
    
    private Connection koneksi;
    
    public Gudang_Dao() {
        koneksi=DBKoneksi.getConnection();
    }

    @Override
    public void insert(Gudang gudang) {
        PreparedStatement statement=null;
        String sql="insert into gudang (nama, keterangan) values (?, ?)";
        try {
            statement=koneksi.prepareStatement(sql);
            statement.setString(1, gudang.getNama());
            statement.setString(2, gudang.getKeterangan());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void update(Gudang gudang) {
        PreparedStatement statement=null;
        String sql="update gudang set nama=?, keterangan=? where id_gudang=?";
        try {
            statement=koneksi.prepareStatement(sql);
            statement.setString(1, gudang.getNama());
            statement.setString(2, gudang.getKeterangan());
            statement.setInt(3, gudang.getIdGudang());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void delete(Gudang gudang) {
        PreparedStatement statement=null;
        String sql="delete from gudang where id_gudang=?";
        try {
            statement=koneksi.prepareStatement(sql);
            statement.setInt(1, gudang.getIdGudang());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Gudang getById(int id) {
        PreparedStatement statement=null;
        ResultSet rs=null;
        Gudang g=null;
        String sql="select * from gudang where id_gudang=?";
        try {
            statement=koneksi.prepareStatement(sql);
            statement.setInt(1, id);
            rs=statement.executeQuery();
            while(rs.next()){
                g=new Gudang();
                g.setIdGudang(rs.getInt("id_gudang"));
                g.setNama(rs.getString("nama"));
                g.setKeterangan(rs.getString("keterangan"));
            }
            return g;
        } catch (SQLException ex) {
            Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Gudang> getGudang() {
        PreparedStatement statement=null;
        ResultSet rs=null;
        List list=new ArrayList();
        String sql="select * from gudang";
        try {
            statement=koneksi.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                Gudang g=new Gudang();
                g.setIdGudang(rs.getInt("id_gudang"));
                g.setNama(rs.getString("nama"));
                g.setKeterangan(rs.getString("keterangan"));
                list.add(g);
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
                    Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Gudang_Dao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}