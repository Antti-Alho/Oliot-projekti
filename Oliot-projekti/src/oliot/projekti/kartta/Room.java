
package oliot.projekti.kartta;
public class Room {
    private int x;
    private int y;
    private int height;
    private int wedth;
    private Corridor corridor;

    public Room(int x, int y, int height, int wedth, Corridor corridor) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.wedth = wedth;
        this.corridor = corridor;
    }

    public Room(int x, int y, int height, int wedth) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.wedth = wedth;
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

    public Corridor getCorridor() {
        return corridor;
    }

    public void setCorridor(Corridor corridor) {
        this.corridor = corridor;
    }
    
    
}
