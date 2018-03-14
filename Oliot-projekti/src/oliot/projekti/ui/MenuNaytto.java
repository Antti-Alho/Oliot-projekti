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
    
    public MenuNaytto() {
        setPreferredSize(new Dimension(500,500));
        
        //backroungimage
        setLayout(new BorderLayout());
        image = new ImageIcon(getClass().getResource("BarFight.jpg"));
        background = new JLabel (image);
        
        
        add(background);
        background.setLayout(new FlowLayout());
    }
    
}
