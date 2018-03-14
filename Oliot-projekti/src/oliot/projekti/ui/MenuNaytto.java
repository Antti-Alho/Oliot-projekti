/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oliot.projekti.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author melto
 */
public class MenuNaytto extends JPanel {
    private ImageIcon image;
    private JLabel background;
    
    //luodaan tässä classissa aloitusnäyttö jossa on kuva
    public MenuNaytto() {
        this.setPreferredSize(new Dimension(500,500));
        
        //aloitusnäytön taustakuva
        this.setLayout(new BorderLayout());
        this.image = new ImageIcon(getClass().getResource("BarFight.jpg"));
        this.background = new JLabel (image);
        
        
        this.add(background);
        this.background.setLayout(new FlowLayout());
    }
    
}
