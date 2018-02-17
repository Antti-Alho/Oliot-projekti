package oliot.liikkuvatOliot;
import java.util.ArrayList;
import oliot.projekti.kartta.Kartta;
import oliot.projekti.kartta.Ruutu;
import java.util.Random;

public class LiikkuvienOhjaaja {
    Random random = new Random();
    Kartta kartta;
    
    public LiikkuvienOhjaaja(Kartta kartta){
        this.kartta = kartta;
    }
    
    public ArrayList<Ihminen> Liikuta(){
        ArrayList<Ihminen> ihmiset = kartta.getIhmiset();
        for (Ihminen ihminen : ihmiset) {
            ihminen.setX(random.nextInt(10));
            ihminen.setY(random.nextInt(10));
        }
        return ihmiset;
    }
    
    public void humalaAskel(){
        
    }

    public Kartta getKartta() {
        return kartta;
    }

    public void setKartta(Kartta kartta) {
        this.kartta = kartta;
    }
}
