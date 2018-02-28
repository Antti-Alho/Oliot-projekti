/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oliot.projekti.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import oliot.liikkuvatOliot.Human;
import oliot.projekti.kartta.Map;

/**
 *
 * @author Eelis
 */
public class StatitNaytto extends JPanel implements ActionListener{
    Map kartta;
    private ArrayList<Human> ihmiset;
    private JLabel statit;
    Timer timer = new Timer(500, this);
    private double numerot; 
    
   
    
    public StatitNaytto(Map kartta) {
        timer.start();
        this.kartta = kartta;
        setPreferredSize(new Dimension(200, 500));
        setBackground(Color.WHITE);
        
        
    }
    
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource()==timer) {
            printHp();
            repaint();
        }
    }
    public void printHp() {
        for (Human human : ihmiset) {
            System.out.println(human.getEnu());
            
        }
    }
}

    
