
package oliot.projekti.kartta;
public class Room {
    private int height;
    private int width;

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

    public int getWedth() {
        return width;
    }

    public void setWedth(int wedth) {
        this.width = wedth;
    }
    
}
