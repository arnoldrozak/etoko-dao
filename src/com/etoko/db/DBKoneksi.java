package com.etoko.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arnold Vengeance
 */
public class DBKoneksi {
    private static Connection koneksi;

    public static Connection getConnection() {
        if(koneksi==null){
            try {
                String url="jdbc:mysql://localhost:3306/etoko";
                String usr="root";
                String pwd="6991";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi=DriverManager.getConnection(url, usr, pwd);
            } catch (SQLException ex) {
                Logger.getLogger(DBKoneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return koneksi;
    }

}
