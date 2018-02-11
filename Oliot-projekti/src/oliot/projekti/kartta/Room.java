
package oliot.projekti.kartta;
public class Room {
    private int height;
    private int wedth;

    public Room(int height, int wedth, Corridor corridor) {
        this.height = height;
        this.wedth = wedth;
    }

    public Room(int height, int wedth) {
        this.height = height;
        this.wedth = wedth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWedth() {
        return wedth;
    }

    public void setWedth(int wedth) {
        this.wedth = wedth;
    }
    
}
