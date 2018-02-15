/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oliot.projekti.ui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import oliot.projekti.kartta.Ruutu;

/**
 *
 * @author Eelis
 */
public class Display extends JFrame {
    private Naytto naytto;
    private JButton aloita;
    private JPanel painikepaneeli;
    private AloitusRuutu naytto1;
    
    
    public Display(ArrayList<Ruutu[]> ruudut) {

        AloitusRuutu naytto1 = new AloitusRuutu();
        JButton aloita = new JButton("Aloita");
        painikepaneeli = new JPanel();
        painikepaneeli.add(aloita);
        aloita.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            naytto1.setVisible(false);
            Naytto naytto = new Naytto(ruudut);
            add(naytto, BorderLayout.CENTER);
            pack();
            naytto.setVisible(true);
        }
    });
        add(naytto1, BorderLayout.CENTER);
        add(painikepaneeli, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
        
        
        
    }
       
    
    


    }

    

