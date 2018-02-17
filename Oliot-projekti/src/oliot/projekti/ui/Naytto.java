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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import oliot.liikkuvatOliot.Ihminen;
import oliot.liikkuvatOliot.LiikkuvienOhjaaja;
import oliot.projekti.kartta.Kartta;
import oliot.projekti.kartta.Ruutu;

/**
 *
 * @author melto
 */
public class Naytto extends JPanel implements ActionListener{
    Kartta kartta;
    private ArrayList<Ruutu[]> ruudut;
    final private int x;
    final private int y;
    private int xpixelit = 50;
    private int ypixelit = 50;
    Timer timer=new Timer(500, this);
    LiikkuvienOhjaaja ohjaaja;
    int frameLaskuri = 0;
    
    public Naytto(Kartta kartta) {
        this.ohjaaja = new LiikkuvienOhjaaja(kartta);
        setPreferredSize(new Dimension(1000,1000));
        setBackground(Color.BLUE);
        x=200; y=150;
        this.kartta = kartta;
        this.ruudut = kartta.getKartta(10, 10);
        timer.start();// Start the timer here.
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < this.ruudut.size(); i++) {
            Ruutu[] rivi =this.ruudut.get(i);

            for (int j = 0; j < rivi.length; j++) {
                if(rivi[j].isSeinä()){
                    paintHuone(g);
                }
                for (int k = 0; k < kartta.getIhmiset().size(); k++) {
                    if(kartta.getIhmiset().get(k).getX() == i && kartta.getIhmiset().get(k).getY() == j) {
                        paintIhminen(g);
                    }
                }
                xpixelit = xpixelit+25;
            }
            xpixelit = 50;
            ypixelit = ypixelit+25;
        }
        xpixelit=50;
        ypixelit=50;
    }
    
    public void setKartta(ArrayList<Ruutu[]> ruudut) {
            this.ruudut = ruudut;
    }
    
    public void paintIhminen(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(xpixelit, ypixelit, 10, 10);
    }
    
    public void paintHuone(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(xpixelit, ypixelit, 25, 25);
    }
    
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource()==timer){
            System.out.println(frameLaskuri);
            frameLaskuri++;
            ArrayList<Ihminen> Liikuta = ohjaaja.Liikuta();
            kartta.setIhmiset(Liikuta);
            repaint();// this will call at every 1 second
        }
    }
}

        
       



