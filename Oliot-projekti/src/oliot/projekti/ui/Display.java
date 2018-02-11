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
            
        int rivi = 50;
            int leveys = 50;
            
            
        for (int i = 0; i < ruudut.size(); i++) {
            Ruutu[]get=ruudut.get(i);
            for (int j = 0; j < get.length; j++) {
                g.setColor(Color.black);
                g.fillRect(rivi, leveys, 25, 25);
                 
            }
            rivi = rivi+25;
            
            
        }
        int riviA = 50;
            int leveysA = 50;
            
        for (int i = 0; i < ruudut.size(); i++) {
            Ruutu[]get=ruudut.get(i);
            for (int j = 0; j < get.length; j++) {
                g.setColor(Color.black);
                g.fillRect(riviA, leveysA, 25, 25);
                
            }    
               leveysA=leveysA + 25;
        }
    }
    
    
    
    
}