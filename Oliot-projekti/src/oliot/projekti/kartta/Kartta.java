package oliot.projekti.kartta;

import java.util.ArrayList;

public class Kartta {
    private int korkeus;
    private int leveys;
    private int huoneidenMaara;
    private IntRange huoneidenKoko;

    public Kartta(int korkeus, int leveys) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        ArrayList<Ruutu> koorninaatisto = new ArrayList<>();
    }
    
    private void start(){
        
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
