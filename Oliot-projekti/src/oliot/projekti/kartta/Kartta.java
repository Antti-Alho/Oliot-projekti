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
        this.huoneidenMaara = huoneidenMaara;
        this.huoneidenKoko = new IntRange(kokoMin, kokoMax);
        this.koordinaatisto = new ArrayList();
        this.koordinaatisto = generoiKartta(kokoMax, kokoMax);
        generoiIhmiset(ihmistenMaara);
        generoiEsineet(esineidenMaara);
    }
    
    public Kartta() {
        this.r = new Random();
        this.ihmiset = new ArrayList<>();
        this.koordinaatisto = new ArrayList<>();
        for (int i = 0; i < huoneidenMaara; i++) {
            rooms.add(new Room(huoneidenKoko.arvoHuoneenKoko(), huoneidenKoko.arvoHuoneenKoko()));
        }
    }

    public void generoiIhmiset(int ihmisia){
        for (int i = 0; i <=ihmisia; i++){
            int x = r.nextInt(huoneidenKoko.max);
            int y = r.nextInt(huoneidenKoko.max);
            Ihminen ihminen = new Ihminen(x, y);
            for (Ihminen ihminen1 : ihmiset) {
                if (ihminen.getX() == ihminen1.getX() && ihminen.getY() == ihminen1.getY()){
                    ihminen.setX(ihminen.getX() + 1);
                }
            }
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

    private void generoiEsineet(int esineidenMaara) {
        for (int i = 0; i < esineidenMaara; i++) {
            Esine e = new Esine(r.nextInt(huoneidenKoko.max), r.nextInt(huoneidenKoko.max));
            esineet.add(e);
        }
    }
}
