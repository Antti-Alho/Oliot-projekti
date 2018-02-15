package oliot.liikkuvatOliot;

import java.util.ArrayList;
import oliot.projekti.kartta.Kartta;
import oliot.projekti.kartta.Ruutu;
import oliot.projekti.ui.Display;
import oliot.projekti.ui.FrameDisplay;

public class OliotProjekti {
    public static void main(String[] args) {
        Kartta kartta = new Kartta();
        ArrayList<Ruutu[]> ruudut = kartta.getKartta(10, 10);
        
        FrameDisplay display = new FrameDisplay(ruudut); 
        
        
        
        
                    
        }

    }
    

