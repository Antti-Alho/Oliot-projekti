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
public class Olut{
    int maara;
    int x;
    int y;

    public int getMaara() {
        return maara;
    }

    public Olut(int maara, int x, int y) {
        this.x = x;
        this.y = y;
        this.maara = maara;
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
    
    public void Juo(){
        this.maara = maara - 1;
    }
        
}
