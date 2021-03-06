package com.etoko.view.dialog;

import javax.swing.JProgressBar;

/**
 *
 * @author Arnold Vengeance
 */
public class SplashScreen extends javax.swing.JDialog {

    
    public SplashScreen() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public JProgressBar getLoadingBar() {
        return LoadingBar;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splash1 = new com.etoko.Splash();
        LoadingBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout splash1Layout = new javax.swing.GroupLayout(splash1);
        splash1.setLayout(splash1Layout);
        splash1Layout.setHorizontalGroup(
            splash1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(splash1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LoadingBar, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        splash1Layout.setVerticalGroup(
            splash1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, splash1Layout.createSequentialGroup()
                .addContainerGap(281, Short.MAX_VALUE)
                .addComponent(LoadingBar, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(splash1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar LoadingBar;
    private com.etoko.Splash splash1;
    // End of variables declaration//GEN-END:variables
}
