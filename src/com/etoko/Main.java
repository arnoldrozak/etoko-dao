package com.etoko;

import com.etoko.db.DBKoneksi;
import com.etoko.view.dialog.SplashScreen;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arnold Vengeance
 */
public class Main {
    
    public static void main(String[] args) {
        SplashScreen screen=new SplashScreen();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        screen.setVisible(true);
        for(int i=0;i<=100;i++){
            try {
                screen.getLoadingBar().setValue(i);
                Thread.sleep(25);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        screen.dispose();
        MainMenu menuUtama=new MainMenu();
        menuUtama.setVisible(true);
    }
    
}
