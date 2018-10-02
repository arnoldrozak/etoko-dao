package com.etoko.laporan.dialog;

import javax.swing.JDialog;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Arnold Vengeance
 */
public class TampilanLaporan extends JDialog{
    private String judul;
    private JRViewer jv;

    public TampilanLaporan(String judul, JRViewer jv) {
        this.judul = judul;
        this.jv = jv;
        pengaturan();
    }
    
    private void pengaturan(){
        setSize(900, 700);
        setLocationRelativeTo(null);
        setTitle(judul);
        getContentPane().add(jv);
        setVisible(true);
    }
}
