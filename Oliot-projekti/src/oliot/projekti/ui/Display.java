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
import oliot.projekti.kartta.Map;

/**
 *
 * @author Eelis
 */
public class Display extends JFrame {
    private Naytto naytto;
    private MenuNaytto naytto1;
    private JButton aloita;
    private JPanel painikepaneeli, kokopaneeli;
    private JLabel kokolabel;
    private JTextField tekstikenttä;
    private JSpinner numerot;
    
    
    public Display() {

        MenuNaytto naytto1 = new MenuNaytto();
        JButton aloita = new JButton("Aloita");
        painikepaneeli = new JPanel();
        kokopaneeli = new JPanel();
        kokolabel = new JLabel("Anna koko");
        
        //vaihtoehto jos textfield ei toimi
        numerot = new JSpinner();
        //textfield
        tekstikenttä = new JTextField(10);
        
        kokopaneeli.add(kokolabel);
        kokopaneeli.add(tekstikenttä);
        painikepaneeli.add(aloita);
        
        
        //nappi josta ohjelma alkaa
        aloita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                naytto1.setVisible(false);
                int TextFieldValue = Integer.parseInt(tekstikenttä.getText());
                Map kartta = new Map(TextFieldValue, TextFieldValue, TextFieldValue, TextFieldValue, TextFieldValue);
                Naytto naytto = new Naytto(kartta);
                add(naytto, BorderLayout.CENTER);
                pack();
                naytto.setVisible(true);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                
                StatitNaytto statitNaytto = new StatitNaytto(kartta);
                add(statitNaytto, BorderLayout.EAST);
                pack();
                statitNaytto.setVisible(true);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });
        add(naytto1, BorderLayout.CENTER);
        add(painikepaneeli, BorderLayout.SOUTH);
        add(kokopaneeli, BorderLayout.NORTH);
        
        pack();
        setVisible(true);    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
        naytto1.getRootPane().setDefaultButton(aloita);
    }
    
}

    

