package com.etoko.view.panel;

import com.etoko.dao.Karyawan_Dao;
import com.etoko.dao.Transaksi_Dao;
import com.etoko.daointerface.Karyawan_DaoInterface;
import com.etoko.daointerface.Transaksi_DaoInterface;
import com.etoko.editor.Barang_Editor;
import com.etoko.model.Barang;
import com.etoko.model.Karyawan;
import com.etoko.model.Transaksi;
import com.etoko.model.Transaksi_Barang;
import com.etoko.tabelModel.TabelModel_BarangDetail;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Arnold Vengeance
 */
public class TransaksiPanel extends javax.swing.JPanel {

    private TabelModel_BarangDetail tabelModelBarangDetail= new TabelModel_BarangDetail();
    private Transaksi_Barang transaksiBarang;
    private Karyawan_DaoInterface karyawan_DaoIF=new Karyawan_Dao();
    private Transaksi_DaoInterface transaksi_DaoIF=new Transaksi_Dao();
    List<Transaksi> listTransaksi=new ArrayList<>();
    Transaksi transaksi;
    
    public TransaksiPanel() {
        initComponents();
        tblBarangDetail.setDefaultEditor(Barang.class, new Barang_Editor(CariBarang));
        tblBarangDetail.setModel(tabelModelBarangDetail);
        tblBarangDetail.setRowHeight(20);
        muatKaryawan();
    }

    private void muatKaryawan(){
        List<Karyawan> karyawan = karyawan_DaoIF.getKaryawan();
        for(Karyawan k: karyawan){
            cbKaryawan.addItem(k);//On Step 16-1 Minute 8.58
        }
    }
    
    private boolean validInput(){
        boolean valid=false;
        if(txtKodeTransaksi.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Kode masih kosong!");
        }else if(txtPPN.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "PPN masih kosong!");
        }else if(txtTanggal.getDate()==null){
            JOptionPane.showMessageDialog(this, "Tanggal masih kosong!");
        }else if(cbKaryawan.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Karyawan belum dipilih!");
        }else if(tblBarangDetail.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "Barang detail belum ada!");
        }else{
            valid=true;
        }
        return valid;
    }
    
    private void resetForm(){
        txtKodeTransaksi.setText("");
        txtPPN.setText("");
        txtTanggal.setDate(null);
        cbKaryawan.setSelectedIndex(0);
        tabelModelBarangDetail.bersih();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CariBarang = new com.etoko.pencarian.CariBarang();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKodeTransaksi = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        txtPPN = new javax.swing.JTextField();
        txtTanggal = new com.toedter.calendar.JDateChooser();
        cbKaryawan = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarangDetail = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Kd. Transaksi");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("PPN");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Tanggal");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Karyawan");

        txtKodeTransaksi.setEnabled(false);

        btnAdd.setText("...");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        cbKaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Karyawan -" }));

        jScrollPane1.setViewportView(tblBarangDetail);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Detail Barang");

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel2.add(btnTambah);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel2.add(btnHapus);

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel2.add(btnSimpan);

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel2.add(btnReset);

        btnCetak.setText("Cetak");
        jPanel2.add(btnCetak);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbKaryawan, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKodeTransaksi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPPN)
                                    .addComponent(txtTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdd))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKodeTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int setIdTransaksi = transaksi_DaoIF.setIdTransaksi();
        int kode=setIdTransaksi+1;
        txtKodeTransaksi.setText(String.valueOf(kode));
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        transaksiBarang=new Transaksi_Barang();
        tabelModelBarangDetail.insertTransaksi_Barang(transaksiBarang);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if(tblBarangDetail.getSelectedRow()!=-1){
            int index=tblBarangDetail.getSelectedRow();
            tabelModelBarangDetail.deleteTransaksi_Barang(index);
        }else{
            JOptionPane.showMessageDialog(this, "Pilih item transaksi!");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if(validInput()==true){
            transaksi=new Transaksi();
            transaksi.setIdTransaksi(Integer.valueOf(txtKodeTransaksi.getText()));
            transaksi.setPpn(Double.valueOf(txtPPN.getText()));
            transaksi.setTanggal(txtTanggal.getDate());
            Karyawan k=(Karyawan) cbKaryawan.getSelectedItem();
            transaksi.setKaryawan(k);
            // Proses perulangan untuk mengisi Barang Detail
            List<Transaksi_Barang> list=new ArrayList<>();
            for(int i=0;i<tblBarangDetail.getRowCount();i++){
                Transaksi_Barang tb=new Transaksi_Barang();
                tb.setTransaksi(transaksi);
                
                Barang b=(Barang) tblBarangDetail.getValueAt(i, 0);
                int jumlah=(int) tblBarangDetail.getValueAt(i, 1);
                Double harga=(Double) tblBarangDetail.getValueAt(i, 2);
                
                tb.setBarang(b);
                tb.setJumlah(jumlah);
                tb.setHarga(harga);
                list.add(tb);
            }
            transaksi.setTransaksiBarang(list);
            //Proses insert Transaksi
            if(transaksi_DaoIF.insertTransaksi(transaksi)==true){
                JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
                listTransaksi.add(transaksi);
                resetForm();
            }else{
                JOptionPane.showMessageDialog(this, "Data gagal disimpan!");
            }
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetForm();
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.etoko.pencarian.CariBarang CariBarang;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<Object> cbKaryawan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBarangDetail;
    private javax.swing.JTextField txtKodeTransaksi;
    private javax.swing.JTextField txtPPN;
    private com.toedter.calendar.JDateChooser txtTanggal;
    // End of variables declaration//GEN-END:variables
}
