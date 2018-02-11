package oliot.liikkuvatOliot;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import oliot.projekti.kartta.Kartta;
import oliot.projekti.kartta.Ruutu;
import oliot.projekti.ui.Display;

public class OliotProjekti {
    public static void main(String[] args) {
        final int leveys = 400;
        final int korkeus = 400;
        
        Kartta kartta = new Kartta();
        ArrayList<Ruutu[]> ruudut = kartta.getKartta(10, 10);
        System.out.println(kartta.toString());
        
        JFrame frame = new JFrame("DisplayFrame");
        frame.setPreferredSize(new Dimension(leveys,korkeus ));
        frame.setMinimumSize(new Dimension(leveys, korkeus));
        frame.setMaximumSize(new Dimension(leveys, korkeus));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(new Display());
        frame.setVisible(true);

    }
    
}
