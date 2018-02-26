package oliot.projekti.kartta;

import java.util.ArrayList;
import oliot.liikkuvatOliot.Esine;
import oliot.liikkuvatOliot.Human;

public class Ruutu {
    private int x;
    private int y;
    private boolean seinä;
    private Human ihminen;
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

    public Human getIhminen() {
        return ihminen;
    }

    public void setIhminen(Human ihminen) {
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
    
    public ArrayList<Ruutu> getNaapuritMP(){
        ArrayList<Ruutu> a = new ArrayList<>();
        if(this.naapuriN.seinä == false)a.add(this.naapuriN);
        if(this.naapuriE.seinä == false)a.add(this.naapuriE);
        if(this.naapuriS.seinä == false)a.add(this.naapuriS);
        if(this.naapuriW.seinä == false)a.add(this.naapuriW);
        return a;
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
