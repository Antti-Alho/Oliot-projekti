package oliot.projekti.kartta;

import java.util.ArrayList;
import java.util.Random;
import oliot.liikkuvatOliot.Esine;
import oliot.liikkuvatOliot.Ihminen;

public class Kartta {

    private int roomAmount;
    private IntRange roomSize;
    private ArrayList<Ruutu[]> koordinaatisto;
    private ArrayList<Esine> esineet;
    private ArrayList<Ihminen> ihmiset;
    private ArrayList<Room> rooms;
    Random r;

    public Kartta(
            int huoneidenMaara,
            int kokoMin,
            int kokoMax,
            int esineidenMaara,
            int ihmistenMaara
    ) {
        this.r = new Random();
        this.ihmiset = new ArrayList<>();
        this.esineet = new ArrayList<>();
        this.roomAmount = huoneidenMaara;
        this.roomSize = new IntRange(kokoMin, kokoMax);
        this.koordinaatisto = new ArrayList();
        this.koordinaatisto = generoiKartta(kokoMax, kokoMax);
        generoiIhmiset(ihmistenMaara);
        generoiEsineet(esineidenMaara);
    }
    
    public Kartta() {
        this.r = new Random();
        this.ihmiset = new ArrayList<>();
        this.koordinaatisto = new ArrayList<>();
        for (int i = 0; i < roomAmount; i++) {
            rooms.add(new Room(roomSize.randomSize(), roomSize.randomSize()));
        }
    }

    public void generoiIhmiset(int ihmisia){
        for (int i = 0; i <=ihmisia; i++){
            int x = r.nextInt(roomSize.max);
            int y = r.nextInt(roomSize.max);
            Ihminen ihminen = new Ihminen(x, y);
            for (Ihminen ihminen1 : ihmiset) {
                if (ihminen.getX() == ihminen1.getX() && ihminen.getY() == ihminen1.getY()){
                    ihminen.setX(ihminen.getX() + 1);
                }
            }
            ihmiset.add(ihminen);
        }
    }
    
    //katsoo huoneiden lukumaarän luo jokaisen huoneen erikseen, 
    //asettelee ne vierekkäin ja
    //sijoittaa huoneiden väliin käytävän
    
    public void yhdistaHuoneet(){
        int xhuoneet = 0;
        int yhuoneet = 0;
        int a;
        int b;
        for (int i = 0; i < roomAmount; i++) {
            a = roomSize.randomSize();
            b = roomSize.randomSize();
            Room room = new Room(a , b);
            room.setKoordinaatisto(generoiKartta(a, b));
            rooms.add(room);
        }
        
    }
    
    public void yhdistaRuudut(){
        
    }
    
    public ArrayList<Ruutu[]> getKoordinaatisto(){
        return this.koordinaatisto;
    }

    //ajetaan kerran luonnin yhteydessä
    public ArrayList<Ruutu[]> generoiKartta(int korkeus, int leveys){
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
        return roomAmount;
    }

    public void setHuoneidenMaara(int huoneidenMaara) {
        this.roomAmount = huoneidenMaara;
    }

    public IntRange getHuoneidenKoko() {
        return roomSize;
    }

    public void setHuoneidenKoko(IntRange huoneidenKoko) {
        this.roomSize = huoneidenKoko;
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

    private void generoiEsineet(int esineidenMaara) {
        for (int i = 0; i < esineidenMaara; i++) {
            Esine e = new Esine(r.nextInt(roomSize.max), r.nextInt(roomSize.max));
            esineet.add(e);
        }
    }
}
