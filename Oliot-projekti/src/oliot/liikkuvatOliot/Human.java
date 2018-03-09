
package oliot.liikkuvatOliot;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Human {
    private int humala;
    private int hp;
    private int str;
    private int intell;
    private int cha;
    private int tavoite;
    private Olut olut;
    private Tuoli tuoli;
    private Pisuaari pisuaari;   
    private String nimi;
    private int x;
    private int y;
    private ArrayList<String> log;
    Random rand = new Random();
    
    public Human(int str, int itelligence, int cha, int humala, int hp, int x, int y) {
        this.str = str;
        this.intell = itelligence;
        this.cha = cha;
        this.humala = humala;
        this.hp = hp;
        this.x = x;
        this.y = y;
        //1 juo 2 istu 3 kuse
        this.tavoite = 1;
        //nimeä arpoessa luetaan tekstitiedostoja.
        try {
            this.nimi = randomName();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Human (int x, int y){
        this.x = x;
        this.y = y;
        ArvoStatit();
        
        this.tavoite = 1;
        this.log = new ArrayList<>();
        this.log.add("<HTML>");
        try {
            this.nimi = randomName();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Human.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    private String randomName() throws FileNotFoundException {
        URL url = getClass().getResource("namesFirst.txt");
        File file = new File(url.getPath());
        Scanner sc = new Scanner(file);
        URL url2 = getClass().getResource("namesLast.txt");
        File file2 = new File(url2.getPath());
        Scanner sc2 = new Scanner(file2);
        String name = "";
        
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> surNames = new ArrayList<>();
        
        while (sc.hasNextLine()) {
            names.add(sc.nextLine());
        }
        while (sc2.hasNextLine()) {
            surNames.add(sc2.nextLine());
        }
        int a = rand.nextInt(names.size());
        name = name + names.get(a) + " ";
        
        a = rand.nextInt(surNames.size());
        name = name + surNames.get(a);
        System.out.println(name);
        return name;
    }

    public void tavoiteSaavutettu(){
        if (this.tavoite == 1){
            this.tavoite = 2;
            this.log.add("Sain oluen!");
        } else if (this.tavoite == 2) {
            this.tavoite = 3;
            this.log.add("Istuin alas juomaan");
        } else if (this.tavoite == 3) {
            this.tavoite = 1;
            this.log.add("Haluaisin olutta!");
        } else {
            this.tavoite = 1;
        }
    }
    
    public void ArvoStatit(){
        this.cha = rand.nextInt(10)+1;
        this.humala = rand.nextInt(10);
        this.hp = rand.nextInt(50)+50;
        this.intell = rand.nextInt(10)+1;
        this.str = rand.nextInt(10)+1;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public int getHumala() {
        return humala;
    }

    public void setHumala(int humala) {
        this.humala = humala;
    }

    public int getEnu() {
        return hp;
    }

    public void setEnu(int enu) {
        this.hp = enu;
    }
    
    public int getStr() {
        return this.str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getItell() {
        return intell;
    }

    public void setItelligence(int itelligence) {
        this.intell = itelligence;
    }

    public int getCha() {
        return cha;
    }

    public void setCha(int cha) {
        this.cha = cha;   
    }

    public Olut getOlut() {
        return olut;
    }

    public void setOlut(Olut olut) {
        this.olut = olut;
    }

    public Tuoli getTuoli() {
        return tuoli;
    }

    public void setTuoli(Tuoli tuoli) {
        this.tuoli = tuoli;
    }

    public Pisuaari getPisuaari() {
        return pisuaari;
    }

    public void setPisuaari(Pisuaari pisuaari) {
        this.pisuaari = pisuaari;
    }
    
    public int getTavoite() {
        return tavoite;
    }

    public void setTavoite(int tavoite) {
        this.tavoite = tavoite;
    }
    @Override
    public String toString(){
        return this.x + " " +this.y;
    }
}
