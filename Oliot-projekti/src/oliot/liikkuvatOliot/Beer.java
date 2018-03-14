/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oliot.liikkuvatOliot;

/**
 *
 * @author Petteri
 */
public class Beer{
    private int maara;
    private int x;
    private int y;
    private boolean empty;

    public Beer(int maara, int x, int y) {
        this.x = x;
        this.y = y;
        this.maara = maara;
        this.empty = false;
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

    public void setMaara(int maara) {
        this.maara = maara;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
    
    public void Juo(){
        this.maara = maara - 1;
    }
    
    public int getMaara() {
        return maara;
    }
        
}
