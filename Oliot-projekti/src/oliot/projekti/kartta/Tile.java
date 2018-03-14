package oliot.projekti.kartta;

import java.util.ArrayList;
import oliot.liikkuvatOliot.Human;

public class Tile {
    private int x;
    private int y;
    private boolean seinä;
    private Human ihminen;
    
    private Tile route;
    private Tile naapuriN;
    private Tile naapuriS;
    private Tile naapuriW;
    private Tile naapuriE;
    private int d;
    
    public Tile(int x, int y, boolean seinä) {
        this.x = x;
        this.y = y;
        this.seinä = seinä;
        this.d = 0;
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
    
    public Tile getNaapuriN() {
        return naapuriN;
    }

    public void setNaapuriN(Tile naapuriN) {
        this.naapuriN = naapuriN;
    }

    public Tile getNaapuriS() {
        return naapuriS;
    }

    public void setNaapuriS(Tile naapuriS) {
        this.naapuriS = naapuriS;
    }

    public Tile getNaapuriW() {
        return naapuriW;
    }

    public void setNaapuriW(Tile naapuriW) {
        this.naapuriW = naapuriW;
    }

    public Tile getNaapuriE() {
        return naapuriE;
    }

    public void setNaapuriE(Tile naapuriE) {
        this.naapuriE = naapuriE;
    }
   
    public Tile getRoute() {
        return route;
    }

    public void setRoute(Tile route) {
        this.route = route;
    }
    
    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
    
    public ArrayList<Tile> getNaapuritMP(){
        ArrayList<Tile> a = new ArrayList<>();
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
