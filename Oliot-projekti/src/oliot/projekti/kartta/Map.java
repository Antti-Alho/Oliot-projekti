package oliot.projekti.kartta;

import java.util.ArrayList;
import java.util.Random;
import oliot.liikkuvatOliot.Baaritiski;
import oliot.liikkuvatOliot.Human;
import oliot.liikkuvatOliot.Olut;
import oliot.liikkuvatOliot.TappeluOhjaaja;
import oliot.liikkuvatOliot.Tuoli;

public class Map {

    private int roomAmount;
    private IntRange roomSize;
    private ArrayList<Ruutu[]> koordinaatisto;
    private ArrayList<String> tulostettavat;
    private ArrayList<Olut> esineet;
    private ArrayList<Human> ihmiset;
    private ArrayList<Room> rooms;
    private ArrayList<TappeluOhjaaja> tappelut;
    private ArrayList<Baaritiski> baaritiskit;
    private ArrayList<Tuoli> tuolit;
    private ArrayList<Human> istuvatIhmiset;
    
    private int maxZize;
    Random r;
    
    // alustaa kaiken käyttövalmiiksi 
    public Map(
            int huoneidenMaara,
            int kokoMin,
            int kokoMax,
            int esineidenMaara,
            int ihmistenMaara
    ) {
        this.r = new Random();
        this.maxZize = kokoMax;
        this.ihmiset = new ArrayList<>();
        this.esineet = new ArrayList<>();
        this.baaritiskit = new ArrayList<>();
        this.tuolit = new ArrayList<>();
        this.istuvatIhmiset = new ArrayList<>();
        this.roomAmount = huoneidenMaara;
        this.roomSize = new IntRange(kokoMin, kokoMax);
        this.koordinaatisto = new ArrayList();
        this.koordinaatisto = generoiKartta(kokoMax, kokoMax);
        generoiBaaritiskit();
        generateChairs(ihmistenMaara/2);
        generoiIhmiset(ihmistenMaara);
        yhdistaRuudut();
        generoiOluet(esineidenMaara);
        this.tappelut = new ArrayList();
    }
        
    //generoi huoneeseen ihmisiä
    public void generoiIhmiset(int ihmisia){
        for (int i = 0; i <=ihmisia; i++){
            int x = r.nextInt(roomSize.max-2)+1;
            int y = r.nextInt(roomSize.max-2)+1;
            Human ihminen = new Human(x, y);
            ihmiset.add(ihminen);
            ihminen.ArvoStatit();
        }
    }
    
    // toistaiseksi täyttää huoneen kaljalla
    //tarkoitus laittaa kaljaa baaritiskille kun baaritiski on tyhjä kunhan baaritiski on olemassa
    private void generoiOluet(int oluenMaara) {
        for (int i = 0; i < oluenMaara; i++) {
            Olut e = new Olut(10,r.nextInt(roomSize.max-2)+1, r.nextInt(roomSize.max-2)+1);
            esineet.add(e);
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
    
    //luo ruuduista verkon etäisyyden ja reitinhakua varten
    public void yhdistaRuudut(){
        ArrayList<Ruutu[]> rivit = this.koordinaatisto;
        for (int i = 1; i < rivit.size()-1; i++) {
            for (int j = 1; j < rivit.get(i).length-1; j++) {
                rivit.get(i)[j].setNaapuriN(rivit.get(i-1)[j]);
                rivit.get(i)[j].setNaapuriE(rivit.get(i)[j+1]);
                rivit.get(i)[j].setNaapuriS(rivit.get(i+1)[j]);
                rivit.get(i)[j].setNaapuriW(rivit.get(i)[j-1]);
            }
        }
    }
    
    public ArrayList<Ruutu[]> getKoord(){
        return this.koordinaatisto;
    }

    //ajetaan kerran luonnin yhteydessä asettelee seinät koordinaatistoon
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

    //tulostaa koordinaatiston tekstimuodossa
    // käytettiin ennen graafista tulostusta testaamiseen
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
    
    // getterit ja setterit
    
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

    public ArrayList<Olut> getOluet() {
        return esineet;
    }

    public void setEsineet(ArrayList<Olut> esineet) {
        this.esineet = esineet;
    }

    public ArrayList<Human> getIhmiset() {
        return ihmiset;
    }

    public void setIhmiset(ArrayList<Human> ihmiset) {
        this.ihmiset = ihmiset;
    }
    
    public ArrayList<TappeluOhjaaja> getTappelut() {
        return tappelut;
    }

    public void setTappelut(ArrayList<TappeluOhjaaja> tappelut) {
        this.tappelut = tappelut;
    }
    public int getMaxZize() {
        return maxZize;
    }

    public void setMaxZize(int maxZize) {
        this.maxZize = maxZize;
    }

    public ArrayList<Baaritiski> getBaaritiskit() {
        return baaritiskit;
    }

    public void setBaaritiskit(ArrayList<Baaritiski> baaritiskit) {
        this.baaritiskit = baaritiskit;
    }

    private void generoiBaaritiskit() {
        for (int i = 1; i < koordinaatisto.size()-1; i++) {
            baaritiskit.add(new Baaritiski(1,i));
        }
    }

    public ArrayList<Tuoli> getTuolit() {
        return tuolit;
    }

    public void setTuolit(ArrayList<Tuoli> tuolit) {
        this.tuolit = tuolit;
    }

    public ArrayList<Human> getIstuvatIhmiset() {
        return istuvatIhmiset;
    }

    public void setIstuvatIhmiset(ArrayList<Human> istuvatIhmiset) {
        this.istuvatIhmiset = istuvatIhmiset;
    }
    
    private void generateChairs(int amount) {
        for (int i = 0; i < amount; i++) {
            Tuoli e = new Tuoli(r.nextInt(roomSize.max-2)+1, r.nextInt(roomSize.max-2)+1);
            tuolit.add(e);
        }
    }
}   
