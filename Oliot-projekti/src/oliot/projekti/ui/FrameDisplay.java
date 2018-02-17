/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oliot.projekti.ui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import oliot.projekti.kartta.Ruutu;

/**
 *
 * @author melto
 */
public class FrameDisplay extends JFrame {
    private Naytto naytto;
    
    public FrameDisplay(ArrayList<Ruutu[]> ruudut) {
        
        Naytto naytto = new Naytto(ruudut);
        add(naytto, BorderLayout.CENTER);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
}
