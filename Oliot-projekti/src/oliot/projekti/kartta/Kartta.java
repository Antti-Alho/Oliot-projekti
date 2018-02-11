package oliot.projekti.kartta;

import java.util.ArrayList;

public class Kartta {

    private int huoneidenMaara;
    private IntRange huoneidenKoko;
    private ArrayList<Ruutu[]> koordinaatisto;

    public Kartta(int maara, int kokoMin, int kokoMax) {

        this.huoneidenMaara = maara;
        this.huoneidenKoko = new IntRange(kokoMin, kokoMax);
        this.koordinaatisto = new ArrayList<>();
    }
    public Kartta() {
        this.koordinaatisto = new ArrayList<>();
        for (int i = 0; i < huoneidenMaara; i++) {
            Room room = new Room(huoneidenKoko.huoneenKoko(), huoneidenKoko.huoneenKoko());
            
        }
        
    }
    
    
    //täyttää ja palauttaa koordinaatiston 
    public ArrayList<Ruutu[]> getKoordinaatisto(){
        
        return this.koordinaatisto;
    }
    
    //luo yhden huoneen jolla testataan muuta toiminnallisuutta!
    //älä anna liian pientä kokoa
    public ArrayList<Ruutu[]> getKartta(int korkeus, int leveys){
        for (int i = 0; i < korkeus; i++) {
            Ruutu[] ruudut = new Ruutu[leveys];
            for (int j = 0; j < ruudut.length; j++) {
                if (i == 0 || i == korkeus-1){
                    ruudut[j] = new Ruutu(i, j, true);
                } else {
                    if (j == 0){
                        ruudut[j] = new Ruutu(i, j, true);
                    } else if (j != 0 && j< ruudut.length-1){
                        ruudut[j] = new Ruutu(i, j, false);
                    } else {
                        ruudut[j] = new Ruutu(i, j, true);
                    }
                }
            }
            koordinaatisto.add(ruudut);
        }
        // tässä välissä lisää muut oliot karttaan jos tarvitset
        
        return this.koordinaatisto;
    }
    
    
    @Override
    public String toString(){
        String a = "";
        
        for (Ruutu[] ruutus : koordinaatisto) {
            for (Ruutu ruutu : ruutus) {
                a = a+ruutu.toString();
            }
            a = a + System.lineSeparator();
        }
        
        return a;
        
    }

    
}
