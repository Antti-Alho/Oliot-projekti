
package oliot.projekti.kartta;

import java.util.ArrayList;

public class Room {
    private int height;
    private int width;
    private ArrayList<Tile[]> koordinaatisto;
    private Room naapuriN;
    private Room naapuriS;
    private Room naapuriW;
    private Room naapuriE;

    public Room(int height, int wedth) {
        this.height = height;
        this.width = wedth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Room getNaapuriN() {
        return naapuriN;
    }

    public void setNaapuriN(Room naapuri) {
        this.naapuriN = naapuri;
    }

    public ArrayList<Tile[]> getKoordinaatisto() {
        return koordinaatisto;
    }

    public void setKoordinaatisto(ArrayList<Tile[]> koordinaatisto) {
        this.koordinaatisto = koordinaatisto;
        this.height = koordinaatisto.size();
        this.width = koordinaatisto.get(0).length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int wedth) {
        this.width = wedth;
    }
    
}
