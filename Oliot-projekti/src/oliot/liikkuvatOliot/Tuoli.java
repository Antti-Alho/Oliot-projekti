/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oliot.liikkuvatOliot;
import java.util.Random;
/**
 *
 * @author Petteri
 */
public class Tuoli extends Esine{
    int tuoliStr;
    Random rand = new Random();
    
    public Tuoli(int x, int y) {
        
        super(x, y);
        tuoliStr = rand.nextInt(10)+1;
    }
}
