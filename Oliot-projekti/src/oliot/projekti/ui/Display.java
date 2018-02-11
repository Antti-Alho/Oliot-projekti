/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oliot.projekti.ui;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;
import oliot.projekti.kartta.Kartta;
import oliot.projekti.kartta.Ruutu;

/**
 *
 * @author Eelis
 */
public class Display extends JPanel {
    Kartta kartta = new Kartta();
    ArrayList<Ruutu[]> ruudut = kartta.getKartta(10, 10);
    
    public Display() {
        setLayout(null);
        
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
            
        int xpixelit = 50;
        int ypixelit = 50;
            
            
        for (int i = 0; i < ruudut.size(); i++) {
            Ruutu[] rivi =ruudut.get(i);
            for (int j = 0; j < rivi.length; j++) {
                if(rivi[j].isSeinä()){
                    g.setColor(Color.black);
                    g.fillRect(xpixelit, ypixelit, 25, 25);
                }
                xpixelit = xpixelit+25;
            }
            xpixelit = 50;
            ypixelit = ypixelit+25;
            
            
        }
    }

    public void setKartta(ArrayList<Ruutu[]> ruudut) {
        this.ruudut = ruudut;
    }
    
    
    
    
}