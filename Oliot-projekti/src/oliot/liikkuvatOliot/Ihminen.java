
package oliot.liikkuvatOliot;
import java.util.Random;
public class Ihminen {
    private int humala;
    private int enu;
    private int str;
    private int intell;
    private int cha;
    private Esine esine = new Esine();
    private int x;
    private int y;
    Random rand = new Random();

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
        return enu;
    }

    public void setEnu(int enu) {
        this.enu = enu;
    }
    
    
    public Esine getEsine() {
        return esine;
    }

    public void setEsine(Esine esine) {
        this.esine = esine;
    }

    public Ihminen(int str, int itelligence, int cha, int humala, int enu, int x, int y) {
        this.str = str;
        this.intell = itelligence;
        this.cha = cha;
        this.humala = humala;
        this.enu = enu;
        this.x = x;
        this.y = y;
    }
    public Ihminen (int x, int y){
        this.x = x;
        this.y = y;
        ArvoStatit();
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
    public void ArvoStatit(){
        this.cha = rand.nextInt(10)+1;
        this.enu = rand.nextInt(10)+1;
        this.humala = rand.nextInt(10)+1;
        this.intell = rand.nextInt(10)+1;
        this.str = rand.nextInt(10)+1;
    }               
}
