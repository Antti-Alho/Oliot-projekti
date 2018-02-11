package oliot.projekti.kartta;

import java.util.ArrayList;

public class Kartta {
    private int korkeus;
    private int leveys;
    private int huoneidenMaara;
    private IntRange huoneidenKoko;
    private ArrayList<Ruutu[]> koordinaatisto;

    public Kartta(int korkeus, int leveys) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.koordinaatisto = new ArrayList<>();
    }
    
    private ArrayList<Ruutu[]> getKartta(){
        return this.koordinaatisto;
    }
    
    public int getKorkeus() {
        return korkeus;
    }

    public void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    public void setLeveys(int leveys) {
        this.leveys = leveys;
    }

    
}
