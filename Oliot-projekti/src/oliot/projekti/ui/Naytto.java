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
import oliot.liikkuvatOliot.Human;
import oliot.liikkuvatOliot.LiikkuvienOhjaaja;
import oliot.projekti.kartta.Map;
import oliot.projekti.kartta.Ruutu;

/**
 *
 * @author melto
 */
public class Naytto extends JPanel implements ActionListener{
    Map kartta;
    private ArrayList<Ruutu[]> ruudut;
    
    private int xpixelit = 50;
    private int ypixelit = 50;
    Timer timer=new Timer(800, this);
    LiikkuvienOhjaaja ohjaaja;
    int frameLaskuri = 0;
    
    
    public Naytto(Map kartta) {
        this.kartta = kartta;
        this.ruudut = kartta.getKoord();
        this.ohjaaja = new LiikkuvienOhjaaja(kartta);
        this.setPreferredSize(new Dimension(30*kartta.getMaxZize(),30*kartta.getMaxZize()));
        this.setBackground(Color.BLUE);
        timer.start();// .
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < this.ruudut.size(); i++) {
            Ruutu[] rivi =this.ruudut.get(i);
            
            //seinien tulostus
            for (int j = 0; j < rivi.length; j++) {
                if(rivi[j].isSeinä()){
                    paintHuone(g);
                }
                //ihmisten tulostus
                for (int k = 0; k < kartta.getIhmiset().size(); k++) {
                    if(kartta.getIhmiset().get(k).getX() == i && 
                            kartta.getIhmiset().get(k).getY() == j) {
                        paintIhminen(g);       
                    }
                }
                //esineiden tulostus
                for (int a = 0; a < kartta.getOluet().size(); a++) {
                    if (kartta.getOluet().get(a).getX() == i &&
                            kartta.getOluet().get(a).getY() == j) {
                        paintEsine(g);
                    }
                }
                //tappelun tulostus
                for (int a = 0; a < kartta.getTappelut().size(); a++) {
                    if (kartta.getTappelut().get(a).getX() == i &&
                            kartta.getTappelut().get(a).getY() == j) {
                        paintTappelu(g);
                    }
                }
                //Baaritiskin tulostus
                for (int a = 0; a < kartta.getBaaritiskit().size(); a++) {
                    if (kartta.getBaaritiskit().get(a).getX() == i &&
                            kartta.getBaaritiskit().get(a).getY() == j) {
                        paintBaaritiski(g);
                    }
                }
                //tuolien tulostus
                for (int a = 0; a < kartta.getTuolit().size(); a++) {
                    if (kartta.getTuolit().get(a).getX() == i &&
                            kartta.getTuolit().get(a).getY() == j) {
                        paintTuolit(g);
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
        g.fillRect(xpixelit, ypixelit, 25, 25);
    }
    
    public void paintHuone(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(xpixelit, ypixelit, 25, 25);
    }
    
    public void paintEsine(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(xpixelit, ypixelit, 10, 10);
    }
    
    public void paintTappelu(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(xpixelit, ypixelit, 25, 25);
    }
    
    public void paintBaaritiski(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(xpixelit, ypixelit, 25, 25);
    }
    
    public void paintTuolit(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect(xpixelit, ypixelit, 25, 25);
    }
    
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource()==timer){
            System.out.println(frameLaskuri);
            frameLaskuri++;
            System.out.println("ihmisiä on " + kartta.getIhmiset().size());
            ArrayList<Human> Liikuta = ohjaaja.Liikuta();
            kartta.setIhmiset(Liikuta);
            repaint();//
        }
    }
}

        
       



