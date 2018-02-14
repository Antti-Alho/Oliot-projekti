/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oliot.projekti.ui;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import oliot.projekti.kartta.Kartta;
import oliot.projekti.kartta.Ruutu;

/**
 *
 * @author melto
 */
public class Naytto extends JPanel {
    Kartta kartta = new Kartta();
    ArrayList<Ruutu[]> ruudut = kartta.getKartta(10, 10);
    final private int x;
    final private int y;
    private int xpixelit = 50;
    private int ypixelit = 50;
    
    public Naytto() {
        setPreferredSize(new Dimension(400,400));
        setBackground(Color.BLUE);
        x=200; y=150;
        
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (int i = 0; i < ruudut.size(); i++) {
            Ruutu[] rivi =ruudut.get(i);
            for (int j = 0; j < rivi.length; j++) {
                if(rivi[j].isSeinä()){
                    paintHuone(g);
                }
                
                if(rivi[j].getIhminen()!= null) {
                        paintIhminen(g);
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
        public void paintIhminen(Graphics g) {
            g.setColor(Color.blue);
            g.fillRect(xpixelit, ypixelit, 10, 10);
        }
        
        public void paintHuone(Graphics g) {
            g.setColor(Color.BLACK);
            g.fillRect(xpixelit, ypixelit, 25, 25);
        }

}
