/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etoko.view.panel;

import com.etoko.dao.Karyawan_Dao;
import com.etoko.daointerface.Karyawan_DaoInterface;
import com.etoko.model.Karyawan;
import com.etoko.tabelModel.TabelModel_Karyawan;
import com.etoko.view.dialog.KaryawanDialog;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Arnold Vengeance
 */
public class KaryawanPanel extends javax.swing.JPanel {

    private TabelModel_Karyawan tabelModelKaryawan=new TabelModel_Karyawan();
    private Karyawan_DaoInterface karyawanDaoIF=new Karyawan_Dao();
    
    public KaryawanPanel() {
        initComponents();
        tblKaryawan.setModel(tabelModelKaryawan);
        muatData();
    }

    private void muatData(){
        List<Karyawan> karyawan = karyawanDaoIF.getKaryawan();
        tabelModelKaryawan.setData(karyawan);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblKaryawan = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        jScrollPane1.setViewportView(tblKaryawan);

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah);

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel1.add(btnUbah);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel1.add(btnHapus);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefresh);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        KaryawanDialog dialog=new KaryawanDialog();
        Karyawan insertKaryawan = dialog.insertKaryawan();
        if(insertKaryawan!=null){
            karyawanDaoIF.insert(insertKaryawan);
            muatData();
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        int index=tblKaryawan.getSelectedRow();
        if(index!=-1){
            Karyawan karyawan = tabelModelKaryawan.getKaryawan(tblKaryawan.convertColumnIndexToModel(index));
            KaryawanDialog dialog=new KaryawanDialog();
            Karyawan updateKaryawan = dialog.updateKaryawan(karyawan);
            if(updateKaryawan!=null){
                karyawanDaoIF.update(updateKaryawan);
                tabelModelKaryawan.updateKaryawan(index, karyawan);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Pilih data Karyawan!");
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int index=tblKaryawan.getSelectedRow();
        if(index!=-1){
            Karyawan karyawan = tabelModelKaryawan.getKaryawan(tblKaryawan.convertColumnIndexToModel(index));
            if(JOptionPane.showConfirmDialog(this, "Apakah anda yakin?", "Konfirmasi Hapus", 
                    JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                karyawanDaoIF.delete(karyawan);
                tabelModelKaryawan.deleteKaryawan(index);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Pilih data Karyawan!");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        muatData();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKaryawan;
    // End of variables declaration//GEN-END:variables
}
