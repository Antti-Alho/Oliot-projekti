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
public class Pisuaari {
    int x, y, kusenMaara;
    public Pisuaari(int x, int y, int kusenMaara){
        this.x = x;
        this.y = y;
        this.kusenMaara = kusenMaara;
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

    public int getKusenMaara() {
        return kusenMaara;
    }

    public void setKusenMaara(int kusenMaara) {
        this.kusenMaara = kusenMaara;
    }
    
}
