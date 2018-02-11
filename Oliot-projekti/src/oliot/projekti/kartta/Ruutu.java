package oliot.projekti.kartta;

import oliot.liikkuvatOliot.Esine;
import oliot.liikkuvatOliot.Ihminen;

public class Ruutu {
    private int x;
    private int y;
    private boolean seinä;
    private Ihminen ihminen;
    private Esine esine;
    
    public Ruutu naapuriN;
    public Ruutu naapuriS;
    public Ruutu naapuriW;
    public Ruutu naapuriE;
    

    public Ruutu(int x, int y, boolean seinä) {
        this.x = x;
        this.y = y;
        this.seinä = seinä;
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

    public boolean isSeinä() {
        return seinä;
    }

    public void setSeinä(boolean seinä) {
        this.seinä = seinä;
    }

    public Ihminen getIhminen() {
        return ihminen;
    }

    public void setIhminen(Ihminen ihminen) {
        this.ihminen = ihminen;
    }

    public Esine getEsine() {
        return esine;
    }

    public void setEsine(Esine esine) {
        this.esine = esine;
    }

    public Ruutu getNaapuriN() {
        return naapuriN;
    }

    public void setNaapuriN(Ruutu naapuriN) {
        this.naapuriN = naapuriN;
    }

    public Ruutu getNaapuriS() {
        return naapuriS;
    }

    public void setNaapuriS(Ruutu naapuriS) {
        this.naapuriS = naapuriS;
    }

    public Ruutu getNaapuriW() {
        return naapuriW;
    }

    public void setNaapuriW(Ruutu naapuriW) {
        this.naapuriW = naapuriW;
    }

    public Ruutu getNaapuriE() {
        return naapuriE;
    }

    public void setNaapuriE(Ruutu naapuriE) {
        this.naapuriE = naapuriE;
    }
    
    @Override
    public String toString(){
        if (seinä){
            return "#";
        } else {
            return "_";
        }
    }
    
    
}
