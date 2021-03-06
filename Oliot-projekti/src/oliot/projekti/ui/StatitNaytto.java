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
import oliot.liikkuvatOliot.fightController;
import oliot.projekti.kartta.Map;

/**
 *
 * @author Eelis
 */
public class StatitNaytto extends JPanel implements ActionListener{
    Map kartta;
    private ArrayList<Human> ihmiset;
    private JLabel statit;
    Timer timer = new Timer(800, this);
    private double numerot; 
    private ArrayList<JLabel> ihmistenstatit;
    
    
   
    
    public StatitNaytto(Map kartta) {
        timer.start();
        this.ihmistenstatit = new ArrayList<>();
        this.kartta = kartta;
        setPreferredSize(new Dimension(200, 500));
        setBackground(Color.WHITE);
        this.ihmiset = kartta.getHumans();
        this.statit = new JLabel("Ihmisten Statit");
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource()==timer) {
            printIhminen();
            repaint();
        }
    }
    
    public void printIhminen() {
      statit.setText(buildHumanhtml());
      add(statit);
      
      
    }
    public String buildHumanhtml() {
        String tulos = "<HTML>";
        tulos = tulos + "Ihmiset , hp <br>"; 
        for (Human human : ihmiset) {
            tulos = tulos + "<br>" + human.getNimi() + "," + human.getEnu();
        }
        tulos = tulos + "<br> Tappelut: <br>";
        
        int tappelulaskuri = 0;
        for (fightController tappelu : kartta.getTappelut()) {
            tappelulaskuri++;
            tulos = tulos + "<br>" + "Tappelu:" + tappelulaskuri;
            for (int i = 0; i < tappelu.getIhmiset().size(); i++) {
                tulos = tulos + "<br>" + tappelu.getIhmiset().get(i).getNimi() + " " + tappelu.getIhmiset().get(i).getEnu();
            }
        }
        tulos = tulos + "</HTML>";
        return tulos;
    }
}

    
