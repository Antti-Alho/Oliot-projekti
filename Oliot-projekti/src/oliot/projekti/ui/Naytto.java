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
import oliot.liikkuvatOliot.Pisuaari;
import oliot.liikkuvatOliot.mapController;
import oliot.projekti.kartta.Map;
import oliot.projekti.kartta.Tile;

/**
 *
 * @author melto
 */
public class Naytto extends JPanel implements ActionListener{
    Map kartta;
    private ArrayList<Tile[]> ruudut;
    
    private int xpixelit = 50;
    private int ypixelit = 50;
    Timer timer=new Timer(800, this);
    mapController ohjaaja;
    int frameLaskuri = 0;
    
    
    public Naytto(Map kartta) {
        this.kartta = kartta;
        this.ruudut = kartta.getCoordinates();
        this.ohjaaja = new mapController(kartta);
        this.setPreferredSize(new Dimension(30*kartta.getMaxZize(),30*kartta.getMaxZize()));
        this.setBackground(Color.BLUE);
        timer.start();// .
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < this.ruudut.size(); i++) {
            Tile[] rivi =this.ruudut.get(i);
            
            //seinien tulostus
            for (int j = 0; j < rivi.length; j++) {
                if(rivi[j].isSeinä()){
                    paintHuone(g);
                }
                //Baaritiskin tulostus
                for (int a = 0; a < kartta.getBaaritiskit().size(); a++) {
                    if (kartta.getBaaritiskit().get(a).getX() == i &&
                            kartta.getBaaritiskit().get(a).getY() == j) {
                        paintBaaritiski(g);
                    }
                }
                //ihmisten tulostus
                for (int k = 0; k < kartta.getHumans().size(); k++) {
                    if(kartta.getHumans().get(k).getX() == i && 
                            kartta.getHumans().get(k).getY() == j) {
                        paintIhminen(g);       
                    }
                }
                //esineiden tulostus
                for (int a = 0; a < kartta.getBeers().size(); a++) {
                    if (kartta.getBeers().get(a).getX() == i &&
                            kartta.getBeers().get(a).getY() == j) {
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

                //tuolien tulostus
                for (int a = 0; a < kartta.getTuolit().size(); a++) {
                    if (kartta.getTuolit().get(a).getX() == i &&
                            kartta.getTuolit().get(a).getY() == j) {
                        paintTuolit(g);
                    }
                }
                //Pisuaarien tulostus
                for(int a = 0; a < kartta.getPisuaarit().size(); a++){
                    if(kartta.getPisuaarit().get(a).getX() == i &&
                            kartta.getPisuaarit().get(a).getY() == j){
                        paintPisuaari(g);
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
    
    public void setKartta(ArrayList<Tile[]> ruudut) {
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
    public void paintPisuaari(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(xpixelit, ypixelit, 25, 25);
    }
    
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource()==timer){
            System.out.println(frameLaskuri);
            frameLaskuri++;
            System.out.println("ihmisiä on " + kartta.getHumans().size());
            ArrayList<Human> Liikuta = ohjaaja.move();
            kartta.setIhmiset(Liikuta);
            repaint();//
        }
    }
}

        
       



