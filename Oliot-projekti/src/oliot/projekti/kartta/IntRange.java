
package oliot.projekti.kartta;

import java.util.Random;

class IntRange {
    public int max;
    public int min;
    Random random = new Random();

    public IntRange(int max, int min) {
        this.max = max;
        this.min = min;
    }
    
    public int randomSize(){
        return random.nextInt(max-min)+min;
    }
}
