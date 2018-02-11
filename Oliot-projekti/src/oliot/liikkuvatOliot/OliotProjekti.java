package oliot.liikkuvatOliot;

import java.util.ArrayList;
import oliot.projekti.kartta.Kartta;
import oliot.projekti.kartta.Ruutu;

public class OliotProjekti {
    public static void main(String[] args) {
        Kartta kartta = new Kartta();
        ArrayList<Ruutu[]> ruudut = kartta.getKartta(10, 10);
        System.out.println(kartta.toString());
        
    }
    
}
