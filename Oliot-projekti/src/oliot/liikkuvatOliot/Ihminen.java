
package oliot.liikkuvatOliot;
public class Ihminen {
    private int humala;
    private int enu;
    private int str;
    private int intell;
    private int cha;
    private Esine esine = new Esine();


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

    public Ihminen(int str, int itelligence, int cha, int humala, int enu) {
        this.str = str;
        this.intell = intell;
        this.cha = cha;
        this.humala = humala;
        this.enu = enu;
        
    }

    public int getStr() {
        return str;
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
