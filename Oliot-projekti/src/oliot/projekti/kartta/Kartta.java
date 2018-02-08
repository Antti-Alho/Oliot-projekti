package oliot.projekti.kartta;

public class Kartta {
    private int korkeus;
    private int leveys;
    private int huoneidenMaara;
    private IntRange huoneidenKoko;

    public Kartta(int korkeus, int leveys) {
        this.korkeus = korkeus;
        this.leveys = leveys;
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
