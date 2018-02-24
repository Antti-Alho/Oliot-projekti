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
    
    
    public MenuNaytto() {
        setPreferredSize(new Dimension(500,500));
        
        //backroungimage
        setLayout(new BorderLayout());
        JLabel background = new JLabel (new ImageIcon
        ("C:\\Users\\Eelis\\Pictures\\barfight.jpg")); //tähän url tai kuvan paikka
        add(background);
        background.setLayout(new FlowLayout());
        
        
    }
    
}
