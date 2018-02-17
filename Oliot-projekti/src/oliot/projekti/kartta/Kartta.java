package oliot.projekti.kartta;

import java.util.ArrayList;
import java.util.Random;
import oliot.liikkuvatOliot.Esine;
import oliot.liikkuvatOliot.Ihminen;

public class Kartta {

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
                Ruutu[] a = new Ruutu[room.getWidth()];
                for (int l = 0; l < room.getWidth()+levein; l++) {
                    if(j == 0 || j == room.getHeight()){
                        Ruutu ruutu = new Ruutu(j, l, true);
                    }else if(l == 0 || l == room.getWidth()) {
                        Ruutu ruutu = new Ruutu(j, l, true);
                    } else {
                        Ruutu ruutu = new Ruutu(j, l, false);
                    }
                }
            }
            korkein = korkein + room.getHeight();
        }
    }
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
        Ihminen ihminen = new Ihminen(1,1);
        ihminen.ArvoStatit();
        ihmiset.add(ihminen);

	Ihminen ihminen2 = new Ihminen(5,5);
        ihminen.ArvoStatit();
        ihmiset.add(ihminen2);

        Ihminen ihminen3 = new Ihminen(9,9);
        ihminen.ArvoStatit();
        ihmiset.add(ihminen3);

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
    
    public int getHuoneidenMaara() {
        return huoneidenMaara;
    }

    public void setHuoneidenMaara(int huoneidenMaara) {
        this.huoneidenMaara = huoneidenMaara;
    }

    public IntRange getHuoneidenKoko() {
        return huoneidenKoko;
    }

    public void setHuoneidenKoko(IntRange huoneidenKoko) {
        this.huoneidenKoko = huoneidenKoko;
    }

    public ArrayList<Esine> getEsineet() {
        return esineet;
    }

    public void setEsineet(ArrayList<Esine> esineet) {
        this.esineet = esineet;
    }

    public ArrayList<Ihminen> getIhmiset() {
        return ihmiset;
    }

    public void setIhmiset(ArrayList<Ihminen> ihmiset) {
        this.ihmiset = ihmiset;
    }
}
