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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
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
    private Document documentti;
    
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
        
        //textfield kerrotaan että hyväksyy vain numeroita
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
        
        //jbutton lukee mitä on tekstikentässä
        aloita.setEnabled(false);
        documentti = tekstikenttä.getDocument();
        documentti.addDocumentListener(new JButtonStateController(aloita));
        
        
        
        kokopaneeli.add(tekstivaara);
        kokopaneeli.add(kokolabel);
        kokopaneeli.add(tekstikenttä);
        painikepaneeli.add(aloita);
        
        
        add(naytto1, BorderLayout.CENTER);
        naytto1.add(painikepaneeli, BorderLayout.SOUTH);
        naytto1.add(kokopaneeli, BorderLayout.NORTH);
        
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);    
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        naytto1.getRootPane().setDefaultButton(aloita);
        
        
       
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
        
     
    }
    class JButtonStateController implements DocumentListener {
    private JButton button;

    JButtonStateController(JButton b) {
        this.button = b;
    }

    public void changedUpdate(DocumentEvent e) {
        disableIfEmpty(e);
    }

    public void insertUpdate(DocumentEvent e){
        disableIfEmpty(e);
    }

    public void removeUpdate(DocumentEvent e){
        disableIfEmpty(e);
    }

    public void disableIfEmpty(DocumentEvent e) {
        button.setEnabled(e.getDocument().getLength() > 0);
    }
}
    
}
