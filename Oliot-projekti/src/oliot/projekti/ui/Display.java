/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oliot.projekti.ui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Eelis
 */
public class Display extends JFrame {
    private Naytto naytto;
    private JButton aloita;
    private JPanel painikepaneeli;
    private AloitusRuutu naytto1;
    
    
    public Display() {

        AloitusRuutu naytto1 = new AloitusRuutu();
        JButton aloita = new JButton("Aloita");
        painikepaneeli = new JPanel();
        painikepaneeli.add(aloita);
        aloita.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            naytto1.setVisible(false);
            Naytto naytto = new Naytto();
            add(naytto, BorderLayout.CENTER);
            pack();
            naytto.setVisible(true);
        }
    });
        add(naytto1, BorderLayout.CENTER);
        add(painikepaneeli, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }
       
    
    


    }

    

