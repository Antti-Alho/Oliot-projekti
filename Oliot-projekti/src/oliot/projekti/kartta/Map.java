package oliot.projekti.kartta;

import java.util.ArrayList;
import java.util.Random;
import oliot.liikkuvatOliot.Bar;
import oliot.liikkuvatOliot.Human;
import oliot.liikkuvatOliot.Beer;
import oliot.liikkuvatOliot.fightController;
import oliot.liikkuvatOliot.Chair;
import oliot.liikkuvatOliot.Pisuaari;

public class Map {

    private int roomAmount;
    private IntRange roomSize;
    private ArrayList<Tile[]> coordinates;
    private ArrayList<Beer> beers;
    private ArrayList<Human> humans;
    private ArrayList<Room> rooms;
    private ArrayList<fightController> fights;
    private ArrayList<Bar> bars;
    private ArrayList<Chair> chairs;
    private ArrayList<Human> sittingHumans;
    private ArrayList<Pisuaari> pisuaarit;
    private ArrayList<Human> kusevatIhmiset;
    private ArrayList<Human> poistettavatIhmiset;
    private int maxZize; 
    Random r;
    
    // alustaa kaiken käyttövalmiiksi 
    public Map(
        int roomAmount,
        int sizeMin,
        int sizeMax,
        int objectAmount,
        int humanAmount
    ) {
        this.r = new Random();
        this.maxZize = sizeMax;
        this.humans = new ArrayList<>();
        this.beers = new ArrayList<>();
        this.bars = new ArrayList<>();
        this.chairs = new ArrayList<>();
        this.pisuaarit = new ArrayList<>();
        this.sittingHumans = new ArrayList<>();
        this.fights = new ArrayList();
        this.roomAmount = roomAmount;
        this.roomSize = new IntRange(sizeMin, sizeMax);
        this.coordinates = new ArrayList();
        this.coordinates = generateMap(sizeMax, sizeMax);
        this.generateBar();
        this.generateHumans(humanAmount);
        this.combineTiles();
        this.genrateBeer(objectAmount);
        this.generatePisuaarit(4);
        this.generateChairs();
    }
        
    //generoi huoneeseen ihmisiä
    public void generateHumans(int humanamount){
        for (int i = 0; i <=humanamount; i++){
            int x = r.nextInt(roomSize.max-2)+1;
            int y = r.nextInt(roomSize.max-2)+1;
            Human ihminen = new Human(x, y);
            this.humans.add(ihminen);
            ihminen.ArvoStatit();
        }
    }
    
    // toistaiseksi täyttää huoneen kaljalla
    //tarkoitus laittaa kaljaa baaritiskille kun baaritiski on tyhjä kunhan baaritiski on olemassa
    private void genrateBeer(int oluenMaara) {
        for (int i = 0; i < oluenMaara; i++) {
            Beer e = new Beer(10,r.nextInt(roomSize.max-2)+1, r.nextInt(roomSize.max-2)+1);
            beers.add(e);
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
            room.setKoordinaatisto(generateMap(a, b));
            rooms.add(room);
        }
        
    }
    
    //luo ruuduista verkon etäisyyden ja reitinhakua varten
    public void combineTiles(){
        ArrayList<Tile[]> rivit = this.coordinates;
        for (int i = 1; i < rivit.size()-1; i++) {
            for (int j = 1; j < rivit.get(i).length-1; j++) {
                rivit.get(i)[j].setNaapuriN(rivit.get(i-1)[j]);
                rivit.get(i)[j].setNaapuriE(rivit.get(i)[j+1]);
                rivit.get(i)[j].setNaapuriS(rivit.get(i+1)[j]);
                rivit.get(i)[j].setNaapuriW(rivit.get(i)[j-1]);
            }
        }
    }

    //ajetaan kerran luonnin yhteydessä asettelee seinät koordinaatistoon
    public ArrayList<Tile[]> generateMap(int korkeus, int leveys){
        for (int i = 0; i < korkeus; i++) {
            Tile[] ruudut = new Tile[leveys];
            for (int j = 0; j < ruudut.length; j++) {
                if (i == 0 || i == korkeus-1){
                    ruudut[j] = new Tile(i, j, true);
                } else {
                    if (j == 0){
                        ruudut[j] = new Tile(i, j, true);
                    } else if (j != 0 && j< ruudut.length-1){
                        ruudut[j] = new Tile(i, j, false);
                    } else {
                        ruudut[j] = new Tile(i, j, true);
                    }
                }
            }
            coordinates.add(ruudut);
        }
        return this.coordinates;
    }
    
    public void generatePisuaarit(int amount){
        for (int i = 0; i < amount; i++) {
            Pisuaari p = new Pisuaari((roomSize.max/2),1,0);
            Pisuaari o = new Pisuaari((roomSize.max/2)+1, 1, 0);
            pisuaarit.add(p);
            pisuaarit.add(o);
        }
    }
    
    private void generateBar() {
        for (int i = 1; i < coordinates.size()/4; i++) {
            bars.add(new Bar(1,i));
        }
    }
    
    private void generateChairs() {
        for (int i = 0; i < 10; i++) {
            Chair chair = new Chair(r.nextInt(roomSize.max-2)+1,r.nextInt(roomSize.max-2)+1);
            chairs.add(chair);
        }
    }

    public void fillTheBar() {
        boolean barIsEmpty = true;
        for (Bar bar : bars) {
            for (Beer beer : beers) {
                if (beer.getX() == bar.getX() && beer.getY() == bar.getY()) {
                    barIsEmpty = false;
                }
            }
            if (barIsEmpty) {
                beers.add(new Beer(10 , bar.getX(), bar.getY()));
                barIsEmpty = true;
            }
        }
    }
    
    //tulostaa koordinaatiston tekstimuodossa
    // käytettiin ennen graafista tulostusta testaamiseen
    @Override
    public String toString(){
        
        String a = "";

        for (Tile[] ruutus : coordinates) {
            for (Tile ruutu : ruutus) {
                a = a+ruutu.toString();
            }
            a = a + System.lineSeparator();
        }
        return a;
    }
    
    public ArrayList<Tile[]> getCoordinates(){
        return this.coordinates;
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

    public ArrayList<Beer> getBeers() {
        return beers;
    }

    public void setEsineet(ArrayList<Beer> esineet) {
        this.beers = esineet;
    }

    public ArrayList<Human> getHumans() {
        return humans;
    }

    public void setIhmiset(ArrayList<Human> ihmiset) {
        this.humans = ihmiset;
    }
    
    public ArrayList<fightController> getTappelut() {
        return fights;
    }

    public void setTappelut(ArrayList<fightController> tappelut) {
        this.fights = tappelut;
    }
    
    public int getMaxZize() {
        return maxZize;
    }

    public void setMaxZize(int maxZize) {
        this.maxZize = maxZize;
    }

    public ArrayList<Bar> getBaaritiskit() {
        return bars;
    }

    public void setBaaritiskit(ArrayList<Bar> baaritiskit) {
        this.bars = baaritiskit;
    }
    
    public ArrayList<Chair> getTuolit() {
        return chairs;
    }

    public void setTuolit(ArrayList<Chair> tuolit) {
        this.chairs = tuolit;
    }

    public ArrayList<Human> getIstuvatIhmiset() {
        return sittingHumans;
    }

    public void setIstuvatIhmiset(ArrayList<Human> istuvatIhmiset) {
        this.sittingHumans = istuvatIhmiset;
    }
    
    public ArrayList<Pisuaari> getPisuaarit() {
        return pisuaarit;
    }

    public void setPisuaarit(ArrayList<Pisuaari> pisuaarit) {
        this.pisuaarit = pisuaarit;
    }
    
    public ArrayList<Human> getKusevatIhmiset() {
        return kusevatIhmiset;
    }

    public void setKusevatIhmiset(ArrayList<Human> kusevatIhmiset) {
        this.kusevatIhmiset = kusevatIhmiset;
    }

    public ArrayList<Human> getPoistettavatIhmiset() {
        return poistettavatIhmiset;
    }

    public void setPoistettavatIhmiset(ArrayList<Human> poistettavatIhmiset) {
        this.poistettavatIhmiset = poistettavatIhmiset;
    }

    
}   
