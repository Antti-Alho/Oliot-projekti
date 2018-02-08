package oliot.projekti.kartta;

import oliot.liikkuvatOliot.Esine;
import oliot.liikkuvatOliot.Ihminen;

public class Ruutu {
    private int x;
    private int y;
    private boolean seinä;
    private Ihminen ihminen;
    private Esine esine;
    
    public Ruutu naapuriN;
    public Ruutu naapuriS;
    public Ruutu naapuriW;
    public Ruutu naapuriE;
}
