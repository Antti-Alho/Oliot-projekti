/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oliot.projekti.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
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
    private JLabel kokolabel, tekstivaara;
    private JTextField tekstikenttä;
    private JSpinner numerot;
    
    
    public Display() {

        MenuNaytto naytto1 = new MenuNaytto();
        JButton aloita = new JButton("Aloita");
        painikepaneeli = new JPanel();
        kokopaneeli = new JPanel();
        kokolabel = new JLabel("Anna koko");
        
        
        tekstivaara = new JLabel("");
        tekstivaara.setForeground(Color.RED);
        
        //vaihtoehto jos textfield ei toimi
        numerot = new JSpinner();
        
        //textfield
        NumberFormat summamuoto = NumberFormat.getNumberInstance();
        tekstikenttä = new JFormattedTextField(summamuoto);;
        tekstikenttä.setColumns(10);
        
        //luo punaisella tekstillä huomion että kirjoita numeroita
        tekstikenttä.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                try {
                    int i = Integer.parseInt(tekstikenttä.getText());
                    tekstivaara.setText(" ");
                } catch (NumberFormatException el) {
                    tekstivaara.setText("Anna vähintään kaksi numeroa");
                }
            }
        });
        
        kokopaneeli.add(tekstivaara);
        kokopaneeli.add(kokolabel);
        kokopaneeli.add(tekstikenttä);
        painikepaneeli.add(aloita);
        
        
        //nappi josta ohjelma alkaa
        aloita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                //jos tekstikenttä on tyhjä annetaan kartalle 20 perus kooksi
                if( tekstikenttä.getText().isEmpty()) {
                    int koko= 20;
                    naytto1.setVisible(false);
                    Map kartta = new Map(koko, koko, koko, koko, koko);
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
                //muuten menee tekstfieldin value 
                else {
                    
                int TextFieldValue = Integer.parseInt(tekstikenttä.getText());
                naytto1.setVisible(false);
                
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
                
                
                }}
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

    

