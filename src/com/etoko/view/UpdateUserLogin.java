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
public class UpdateUserLogin extends javax.swing.JInternalFrame {

    /**
     * Creates new form UpdateUserLogin
     */
    public UpdateUserLogin() {
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

        updatePwdPanel1 = new com.etoko.view.panel.UpdatePwdPanel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Ubah User Login");
        getContentPane().add(updatePwdPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.etoko.view.panel.UpdatePwdPanel updatePwdPanel1;
    // End of variables declaration//GEN-END:variables
}
