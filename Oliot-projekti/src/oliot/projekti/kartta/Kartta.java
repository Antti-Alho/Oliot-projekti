

package oliot.projekti.kartta;

import java.util.ArrayList;
import java.util.Random;
import oliot.liikkuvatOliot.Esine;
import oliot.liikkuvatOliot.Ihminen;

public class Kartta {
    //luo koordinaatiston ruuduista esineistä ja ihmisistä

    private int huoneidenMaara;
    private IntRange huoneidenKoko;
    private ArrayList<Ruutu[]> koordinaatisto;
    private ArrayList<Esine> esineet;
    private ArrayList<Ihminen> ihmiset;
    private ArrayList<Room> rooms;

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

    public void GeneroiIhmiset(int ihmisia){
        for (int i = 0; i <=ihmisia; i++){
            Ihminen ihminen = new Ihminen(i, i);
            ihminen.ArvoStatit();
            ihmiset.add(ihminen);
        }

    }
    //ei toimi vielä älä koske antti hoitaa
    public void yhdistaHuoneet(){
        int korkein = 0;
        int levein = 0;
        
        for (int i = 0; i < rooms.size(); i++) {
            
            Room room = rooms.get(i);
            for (int j = 0; j < room.getHeight()+korkein; j++) {
                Ruutu[] a = new Ruutu[room.getWedth()];
                for (int l = 0; l < room.getWedth()+levein; l++) {
                    if(j == 0 || j == room.getHeight()){
                        Ruutu ruutu = new Ruutu(j, l, true);
                    }else if(l == 0 || l == room.getWedth()) {
                        Ruutu ruutu = new Ruutu(j, l, true);
                    } else {
                        Ruutu ruutu = new Ruutu(j, l, false);
                    }
                }
            }
            korkein = korkein + room.getHeight();
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
