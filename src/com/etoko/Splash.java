package com.etoko;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Arnold Vengeance
 */
public class Splash extends JPanel{
    private Image gambar;

    public Splash() {
        gambar=new ImageIcon(getClass().getResource("/com/etoko/gambar/EtokoSplash.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D gd=(Graphics2D) g.create();
        gd.drawImage(gambar, 0, 0, getWidth(), getHeight(), this);
        gd.dispose();
    }
    
}
