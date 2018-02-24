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
public class Olut extends Esine{
    int maara;

    public int getMaara() {
        return maara;
    }

    public Olut(int maara, int x, int y) {
        super(x, y);
        this.maara = maara;
    }

    public void setMaara(int maara) {
        this.maara = maara;
    }
    
    public void Juo(){
        this.maara = maara - 1;
    }
        
}
