package oliot.liikkuvatOliot;

import java.util.ArrayList;
import oliot.projekti.kartta.Kartta;
import oliot.projekti.kartta.Ruutu;
import oliot.projekti.ui.Display;
import javax.swing.*;

public class OliotProjekti {
    public static void main(String[] args) {
        Kartta kartta = new Kartta();
        ArrayList<Ruutu[]> ruudut = kartta.getKartta(10, 10);
        
        Display display = new Display();
        display.setVisible(true);
        display.setKartta(ruudut);
        
        
        JFrame jf = new JFrame();
        jf.setTitle("FightPub");
        jf.setSize(600,400);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(display);

    }
    
}
