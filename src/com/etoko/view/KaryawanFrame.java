/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etoko.view;

/**
 *
 * @author Arnold Vengeance
 */
public class KaryawanFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form KaryawanFrame
     */
    public KaryawanFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        karyawanPanel1 = new com.etoko.view.panel.KaryawanPanel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Master Karyawan");
        getContentPane().add(karyawanPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.etoko.view.panel.KaryawanPanel karyawanPanel1;
    // End of variables declaration//GEN-END:variables
}
