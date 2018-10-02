package com.etoko.view.panel;

import com.etoko.dao.Barang_Dao;
import com.etoko.daointerface.Barang_DaoInterface;
import com.etoko.model.Barang;
import com.etoko.tabelModel.TabelModel_Barang;
import com.etoko.view.dialog.BarangDialog;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Arnold Vengeance
 */
public class BarangPanel extends javax.swing.JPanel {

    private TabelModel_Barang tabelModelBarang=new TabelModel_Barang();
    private Barang_DaoInterface barang_DaoIF=new Barang_Dao();
    
    public BarangPanel() {
        initComponents();
        tblBarang.setModel(tabelModelBarang);
        muatData();
    }

    private void muatData(){
        List<Barang> barang = barang_DaoIF.getBarang();
        tabelModelBarang.setData(barang);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        jScrollPane1.setViewportView(tblBarang);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        BarangDialog dialog=new BarangDialog();
        Barang insertBarang = dialog.insertBarang();
        if(insertBarang!=null){
            barang_DaoIF.insert(insertBarang);
            muatData();
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        int index=tblBarang.getSelectedRow();
        if(index!=-1){
            Barang barang = tabelModelBarang.getBarang(tblBarang.convertRowIndexToModel(index));
            BarangDialog dialog=new BarangDialog();
            Barang updateBarang = dialog.updateBarang(barang);
            if(updateBarang!=null){
                barang_DaoIF.update(updateBarang);
                tabelModelBarang.updateBarang(index, barang);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Pilih data Barang!");
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int index=tblBarang.getSelectedRow();
        if(index!=-1){
            Barang barang = tabelModelBarang.getBarang(tblBarang.convertRowIndexToModel(index));
            BarangDialog dialog=new BarangDialog();
            if(JOptionPane.showConfirmDialog(this, "Apakah anda yakin?", "Konfirmasi Hapus",
                    JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
                barang_DaoIF.delete(barang);
                tabelModelBarang.deleteBarang(index);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Pilih data Barang!");
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
    private javax.swing.JTable tblBarang;
    // End of variables declaration//GEN-END:variables
}
