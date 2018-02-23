
package oliot.projekti.kartta;

import java.util.ArrayList;

public class Room {
    private int height;
    private int width;
    private ArrayList<Ruutu[]> koordinaatisto;

    public Room(int height, int wedth, Corridor corridor) {
        this.height = height;
        this.width = wedth;
    }

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

    public ArrayList<Ruutu[]> getKoordinaatisto() {
        return koordinaatisto;
    }

    public void setKoordinaatisto(ArrayList<Ruutu[]> koordinaatisto) {
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
