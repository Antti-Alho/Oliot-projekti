
package oliot.liikkuvatOliot;
import java.util.Random;
public class Ihminen {
    private int humala;
    private int enu;
    private int str;
    private int intell;
    private int cha;
    private int tavoite;
   
    private Esine esine;
    private int x;
    private int y;
    Random rand = new Random();
    
    public Ihminen(int str, int itelligence, int cha, int humala, int enu, int x, int y) {
        this.str = str;
        this.intell = itelligence;
        this.cha = cha;
        this.humala = humala;
        this.enu = enu;
        this.x = x;
        this.y = y;
        
        this.tavoite = 1;
    }
    public Ihminen (int x, int y){
        this.x = x;
        this.y = y;
        ArvoStatit();
        
        this.tavoite = 1;
    }

    public void tavoiteSaavutettu(){
        if (this.tavoite == 1){
            this.tavoite = 2;
        } else if (this.tavoite == 2) {
            this.tavoite = 3;
        } else if (this.tavoite == 3) {
            this.tavoite = 1;
        } else {
            this.tavoite = 1;
        }
    }
    
    public void ArvoStatit(){
        this.cha = rand.nextInt(10)+1;
        this.enu = rand.nextInt(10)+1;
        this.humala = rand.nextInt(10)+1;
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
        return enu;
    }

    public void setEnu(int enu) {
        this.enu = enu;
    }
    
    //testaa onko null
    public Esine getEsine() {
        return esine;
    }

    public void setEsine(Esine esine) {
        this.esine = esine;
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
}
