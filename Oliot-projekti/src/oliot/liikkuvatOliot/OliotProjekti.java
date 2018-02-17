package oliot.liikkuvatOliot;

import java.util.ArrayList;
import oliot.projekti.kartta.Kartta;
import oliot.projekti.kartta.Ruutu;
import oliot.projekti.ui.Display;
import oliot.projekti.ui.FrameDisplay;

public class OliotProjekti {
    public static void main(String[] args) {
        Kartta kartta = new Kartta();
        LiikkuvienOhjaaja ohjaaja = new LiikkuvienOhjaaja(kartta);
        FrameDisplay display = new FrameDisplay(kartta);
    }
}
    

