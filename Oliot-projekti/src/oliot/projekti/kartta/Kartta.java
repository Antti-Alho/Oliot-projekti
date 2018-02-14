

package oliot.projekti.kartta;

import java.util.ArrayList;
import java.util.Random;
import oliot.liikkuvatOliot.Ihminen;

public class Kartta {

    private int huoneidenMaara;
    private IntRange huoneidenKoko;
    private ArrayList<Ruutu[]> koordinaatisto;
    private ArrayList<Ihminen> ihmiset;
    private ArrayList<Room> rooms;
    
    
    public void GeneroiIhmiset(int ihmisia){
        Random random = new Random();
        for (int i = 0; i <=ihmisia; i++){
            ihmiset.add(new Ihminen(random.nextInt(10)+1, random.nextInt(10)+1));
        }
        
    }

    public Kartta(int maara, int kokoMin, int kokoMax) {
        this.ihmiset = new ArrayList<>();

        this.huoneidenMaara = maara;
        this.huoneidenKoko = new IntRange(kokoMin, kokoMax);
        this.koordinaatisto = new ArrayList<>();
    }
    
    public Kartta() {
        this.ihmiset = new ArrayList<>();
        this.koordinaatisto = new ArrayList<>();
        for (int i = 0; i < huoneidenMaara; i++) {
            rooms.add(new Room(huoneidenKoko.arvoHuoneenKoko(), huoneidenKoko.arvoHuoneenKoko()));    
        }
        
    }
    
    public void yhdistaHuoneet(){
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            for (int j = 0; j < room.getWedth(); j++) {
                
            }
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
        Ihminen ihminen = new Ihminen(leveys, leveys, leveys, 0, 0);
        koordinaatisto.get(5)[5].setIhminen(ihminen);
        
	 Ihminen ihminen2 = new Ihminen(leveys, leveys, leveys, 0, 0);
        koordinaatisto.get(8)[8].setIhminen(ihminen);
        
        Ihminen ihminen3 = new Ihminen(leveys, leveys, leveys, 0, 0);
        koordinaatisto.get(1)[1].setIhminen(ihminen);
        
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