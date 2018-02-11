package oliot.projekti.kartta;

import java.util.ArrayList;

public class Kartta {
    private int korkeus;
    private int leveys;
    private int huoneidenMaara;
    private IntRange huoneidenKoko;
    private ArrayList<Ruutu[]> koordinaatisto;

    public Kartta(int korkeus, int leveys, int maara, int kokoMin, int kokoMax) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.huoneidenMaara = maara;
        this.huoneidenKoko = new IntRange(kokoMin, kokoMax);
        this.koordinaatisto = new ArrayList<>();
    }
    public Kartta() {
        
    }
    
    private ArrayList<Ruutu[]> luoKartta(){
        
        return this.koordinaatisto;
    }
    
    private ArrayList<Ruutu[]> getKartta(int korkeus, int leveys){
        for (int i = 0; i < korkeus; i++) {
            Ruutu[] ruudut = new Ruutu[leveys];
            for (int j = 0; j < ruudut.length; j++) {
                if (i == 0 || i == korkeus){
                    ruudut[j] = new Ruutu(i, j, true);
                } else {
                    if (j == 0){
                        ruudut[j] = new Ruutu(i, j, true);
                    } else if (j != 0 && j< ruudut.length){
                        ruudut[j] = new Ruutu(i, j, false);
                    } else {
                        ruudut[j] = new Ruutu(i, j, true);
                    }
                }
            }
            koordinaatisto.add(ruudut);
        }
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
